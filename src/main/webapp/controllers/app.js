/**
 * Created by yuri on 15.02.16.
 */
// app.js
/*
 Created on : 28.10.2015, 9:33:58
 Author     : Vasyanin Yuri

 Использованные модули в проекте:
 */
var routerApp = angular.module('routerApp', [
    'ui.router',                //организации навигации между различными частями нашего приложения
    'ui.bootstrap',              //использование виджетов bootstrap
    'ngAnimate',
    'restangular',
    'ngCookies',
    'ui.bootstrap.contextMenu'
]);

//сервис фабрика для передачи параметров между контроллерами
routerApp.factory('theService', function () {
    return {
        thing: {
            x: 1,                                   //номер вида списка- короткий=1, подробный=2,scrum=3
            visibleNav: false,                      //скрыть панель
            idUser: 1,                              //пользователь
            multisel: [],
            multsDiag: [],
            multsDiagvp: []
        }
    };
});

//angular.module('auth')
routerApp.service('AuthService', function($cookies, $http, Restangular) {
        'use strict';

        var self = this;
        this.status = { authorized: false };

        this.loginByCredentials = function(username, password) {
            return Restangular.all('sessions').post({ email: username, password: password }).then(function(response) {
                    return self.loginByToken(response);//.contents
                });
        };

        this.loginByToken = function(token) {
            $http.defaults.headers.common['X-Token'] = token;

            return Restangular.all('sessions').get(token).then(function(response) {
                    $cookies.accessToken = token;
                    self.status.authorized = true;
                    return response;
                });
        };

        this.logout = function() {
            self.status.authorized = false;
            $cookies.accessToken = '';
            Restangular.all('sessions').remove();
        };
    });

routerApp.constant('CONST', {
    curr_url: window.location.pathname + "api/mess/"
});

routerApp.directive('autoc', function () {
    return {
        restrict: 'E',
        scope: {
            par: "@",
            placeh: "@",
            model: "="
        },
        template: //'<label>{{placeh}}<i ng-show="loadingLocations" class="glyphicon glyphicon-refresh"></i></label>' +
        '<input type="text" ng-model="model" placeholder="{{placeh}}" uib-typeahead="item as item[par] for item in getLocation($viewValue)"' +
        'typeahead-loading="loadingLocations" typeahead-no-results="noResults" class="form-control mtb5" uib-tooltip="{{placeh}}" tooltip-placement="left">' +
        '<i ng-show="loadingLocations" class="glyphicon glyphicon-refresh"></i>'+
        '<div ng-show="noResults"><i class="glyphicon glyphicon-remove"></i> Запись отсутсвует.' +
        '<button type="button" class="btn btn-link" ng-click="save()" >Добавить</button>' +
        '</div>',
        controller: function ($scope, $http, CONST) {
            $scope.getLocation = function (val) {
                return $http.get(CONST.curr_url + 'fam/' + $scope.par + "=" + val, {}).then(function (response) {
                    return response.data;
                });
            };

            $scope.save = function () {
                $http({
                    url: CONST.curr_url + 'crspr',
                    method: "POST",
                    type: "application/json",
                    data: $scope.par + "=" + $scope.model
                }).then(function (response) {  // success
                    //var jsontext = '{"id":"'+response.data+'","'+ $scope.par +'":"'+$scope.model+'"}';
                    $scope.model = JSON.parse('{"id":"' + response.data + '","' + $scope.par + '":"' + $scope.model + '"}');
                    //var tmp = $scope.model;
                    //$scope.model = {id: response.data};
                    //$scope.model[$scope.par] = tmp;
                    $scope.noResults = false;
                }, function (response) { // optional  // failed
                    alert("Ошибка записи!" + response);
                });
            };
        }
    }

});

routerApp.directive('dateb', function () {
    return {
        restrict: 'E',
        scope: {
            //par: "@",
            placeh: "@",
            model: "="
        },
        template: '<label>{{placeh}}:</label>' +
        '<p class="input-group">' +
        '<input type="text" size="10" class="form-control" uib-datepicker-popup="{{dateParam.format}}" placeholder="{{placeh}}"' +
        'ng-model="model" is-open="dateParam.status.opened" datepicker-options="dateParam.dateOptions" ng-required="true" close-text="Close"/>' +
        '<span class="input-group-btn">' +
        '<button type="button" class="btn btn-default" ng-click="dateParam.open($event)"><i class="glyphicon glyphicon-calendar"></i></button>' +
        '</span></p>',
        controller: function ($scope) {
            if($scope.model !== undefined){
                $scope.model = new Date($scope.model);
            }

            $scope.dateParam = {
                status: {opened: false},
                dateOptions: {
                    formatYear: 'yyyy',                   //формат года
                    startingDay: 1                      //начало месяца
                },
                format: 'dd.MM.yyyy',
                open: function ($event) {
                    $scope.dateParam.status.opened = true;
                }
            };
        }
    }

});

routerApp.directive('multis', function () {
    return {
        restrict: 'E',
        scope: {
            stylecss: "@",
            par: "@",
            parpp: "@",
            placeh: "@",
            multisel: "=",
            setdirty:"&"
        },
        template: '<label>{{placeh}}</label>' +
        '<div class="bordr4">' +
        '<label class="bordr5" ng-class="{{stylecss}}" ng-click="change(item)" ng-repeat="item in multisel" uib-popover="{{item[parpp]}}" popover-trigger="mouseenter" popover-title="Наименование" >' +
        '{{item[par]}}<span ng-click="detlPr(item)" class="glyphicon glyphicon-remove-circle ml10 cur"></span>' +
        '</label>' +
        '<input type="text" ng-model="model" placeholder="Добавить" uib-typeahead="item as (item[par]+\' - \'+item[parpp]) for item in getLocation($viewValue)"' +
        'typeahead-loading="loadingLocations" typeahead-no-results="noResults" class="bnone ml10" typeahead-on-select="addPr()">' +
        '<i ng-show="loadingLocations" class="glyphicon glyphicon-refresh"></i>' +
        '<span ng-show="noResults"><i class="glyphicon glyphicon-remove"></i>Запись отсутсвует.</span>' +
        '</div>' /*+
         '<label>Второй:</label>' +
         '<div class="bordr4">' +
         '<label class="btn-primary bordr5" ng-repeat="item in multisel.pr2" uib-popover="{{item.info}}" popover-trigger="mouseenter" popover-title="Наименование">' +
         '{{item.fam}}<span ng-click="detlPr(item,2)" class="glyphicon glyphicon-remove-circle ml10 cur"></span>' +
         '</label>' +
         '</div>' +
         '<div class="form-inline text-left pt10">' +

         '</div>'*/,
        controller: function ($scope, Restangular,theService) {
            $scope.addPr = function () {
                if ($scope.multisel.length === 1 && $scope.multisel[0].id === -1) {
                    $scope.multisel = [$scope.model];

                } else {
                    $scope.multisel.push($scope.model);
                }
                $scope.setServ();
                $scope.model = null;
            };

            $scope.setServ = function () {
                var mprv=[];
                $scope.multisel.forEach(function (item) {
                    mprv.push(item.id);
                });
                theService.thing.multisel=mprv;
            };

            $scope.detlPr = function (it) {
                $scope.multisel.splice($scope.multisel.indexOf(it), 1);
                if ($scope.multisel.length === 0) {
                    $scope.multisel = [{id: -1, nomer: "пусто"}];
                }
                $scope.setServ();
                $scope.setdirty();
            };
            $scope.change = function (it) {
                if ($scope.multisel[0].pr === undefined) {
                    return;
                }
                var i = $scope.multisel.indexOf(it);
                $scope.multisel[i].pr = ($scope.multisel[i].pr === 1 ? 2 : 1);
            };
            $scope.getLocation = function (val) {
                return Restangular.all('fam/' + $scope.par + "=" + val).getList().then(function (response) {
                    return response;
                });
            };
        }
    }

});

routerApp.directive('multis2', function () {
    return {
        restrict: 'E',
        scope: {
            stylecss: "@",
            par: "@",
            parpp: "@",
            placeh: "@",
            multisel: "=",
            setdirty:"&"
        },
        template: '<label>{{placeh}}</label>' +
        '<div class="bordr4">' +
        '<label class="bordr5" ng-class="{{stylecss}}" ng-click="change(item)" ng-repeat="item in multisel" uib-popover="{{item[parpp]}}" popover-trigger="mouseenter" popover-title="Наименование" >' +
        '{{item[par]}}<span ng-click="detlPr(item)" class="glyphicon glyphicon-remove-circle ml10 cur"></span>' +
        '</label>' +
        '<input type="text" ng-model="model" placeholder="Добавить" uib-typeahead="item as (item[par]+\' - \'+item[parpp]) for item in getLocation($viewValue)"' +
        'typeahead-loading="loadingLocations" typeahead-no-results="noResults" class="bnone ml10" typeahead-on-select="addPr()">' +
        '<i ng-show="loadingLocations" class="glyphicon glyphicon-refresh"></i>' +
        '<span ng-show="noResults"><i class="glyphicon glyphicon-remove"></i>Запись отсутсвует.</span>' +
        '</div>' ,
        controller: function ($scope, Restangular,theService) {
            $scope.addPr = function () {
                if ($scope.multisel.length === 1 && $scope.multisel[0].id === -1) {
                    $scope.multisel = [$scope.model];
                } else {
                    $scope.multisel.push($scope.model);
                }
                $scope.setServ();
                $scope.model = null;
            };

            $scope.setServ = function () {
                var m=[], vp=[];
                $scope.multisel.forEach(function (item) { m.push(item.id); vp.push(false); });
                theService.thing.multsDiag=m;
                theService.thing.multsDiagvp=vp;
            };

            $scope.detlPr = function (it) {
                $scope.multisel.splice($scope.multisel.indexOf(it), 1);
                if ($scope.multisel.length === 0) {
                    $scope.multisel = [{id: -1, ndiag: "пусто"}];
                }
                $scope.setServ();
                $scope.setdirty();
            };
            $scope.change = function (it) {
                if ($scope.multisel[0].id <0 ) {
                    return;
                }
                var i = $scope.multisel.indexOf(it);
                if(!$scope.multisel[i].hasOwnProperty("vpervye")){
                    $scope.multisel[i].vpervye = false;
                }
                $scope.multisel[i].vpervye = !$scope.multisel[i].vpervye;// === true ? false : true);
            };
            $scope.getLocation = function (val) {
                return Restangular.all('fam/' + $scope.par + "=" + val).getList().then(function (response) {
                    return response.plain();
                });
            };
        }
    }

});

routerApp.config(function ($stateProvider, $urlRouterProvider, RestangularProvider) {
    RestangularProvider.setBaseUrl(window.location.pathname + "api/mess/");

    // Now let's configure the response extractor for each request
    //RestangularProvider.setResponseExtractor(function(response, operation, what, url) {
    //    var newResponse;
    //    // This is a get for a list
    //    if (operation === "getList") {
    //        // First the newResponse will be response.objects which is actually an array
    //        newResponse = response.objects;
    //        // Then we add to this array a special property containing the metadata for paging for example
    //        newResponse.metadata = response.data.meta;
    //    } else {
    //        // If it's an element, then we just return the "regular" response as there's no object wrapping it
    //        newResponse = response;
    //    }
    //    return newResponse;
    //});

    $urlRouterProvider.otherwise('/home');          //страница по умолчанию
    $stateProvider
    //Аутентификация пользователя
        .state('autor', {
            url: '/home',                       //адрес
            templateUrl: 'partial-autor.html',  //шаблон
            controller: 'CtrlAutor'             //контроллер
        })
        // Главная, состояние и вид
        .state('home', {
            url: '/home',
            templateUrl: 'partial-home.html',
            controller: 'CtrlTask'
        })
        .state('spisok', {
            url: '/home',
            templateUrl: 'partial-spisok.html',
            controller: 'CtrlSp'
        })
        .state('find', {
            url: '/home',
            templateUrl: 'partial-find.html',
            controller: 'CtrlFind'
        })
        .state('scrum', {
            url: '/home',
            templateUrl: 'partial-scrum.html',
            controller: 'myCtrl'
        })
        .state('sprav', {
            url: '/home',
            templateUrl: 'partial-sprav.html',
            controller: 'CtrlSprav'
        })
        // Описание
        .state('about', {
            url: '/home',
            templateUrl: 'partial-about.html'
        });
});