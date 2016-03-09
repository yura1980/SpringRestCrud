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
    'restangular'
]);

//сервис фабрика для передачи параметров между контроллерами
routerApp.factory('theService', function () {
    return {
        thing: {
            x: 1,                                   //номер вида списка- короткий=1, подробный=2,scrum=3
            visibleNav: false,                      //скрыть панель
            idUser: 1                               //пользователь
        }
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
        template: '<label>{{placeh}}:<i ng-show="loadingLocations" class="glyphicon glyphicon-refresh"></i></label>' +
        '<input type="text" ng-model="model" placeholder="{{placeh}}" uib-typeahead="item as item[par] for item in getLocation($viewValue)"' +
        'typeahead-loading="loadingLocations" typeahead-no-results="noResults" class="form-control">' +
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
                    $scope.model = JSON.parse('{"id":"'+response.data+'","'+ $scope.par +'":"'+$scope.model+'"}');
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
        '<input type="text" size="10" class="form-control" uib-datepicker-popup="{{format}}" placeholder="{{placeh}}"' +
        'ng-model="model" is-open="status.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close"/>' +
        '<span class="input-group-btn">' +
        '<button type="button" class="btn btn-default" ng-click="open($event)"><i class="glyphicon glyphicon-calendar"></i></button>' +
        '</span></p>',
        controller: function ($scope) {
            $scope.open = function ($event) {
                $scope.status.opened = true;
            };
            //объект статуса
            $scope.status = {
                opened: false
            };

            $scope.dateOptions = {
                formatYear: 'yyyy',                   //формат года
                startingDay: 1                      //начало месяца
            };
            //формат даты виджета
            $scope.format = 'dd.MM.yyyy';
        }
    }

});

routerApp.config(function ($stateProvider, $urlRouterProvider, RestangularProvider) {
    RestangularProvider.setBaseUrl(window.location.pathname + "api/mess/");

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