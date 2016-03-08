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
    'ui.bootstrap',             //использование виджетов bootstrap
    'ngAnimate',
    'restangular'//ngResource,
    //'ngStorage'
]);

routerApp.constant('CONST', {
    curr_url: window.location.pathname + "api/mess/"
});

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

//routerApp.factory("Pass", function($resource) {
//    return $resource(window.location.pathname  + "api/mess/"+ 'listPass');
//});

//routerApp.config(['$resourceProvider', function($resourceProvider) {
//    // Don't strip trailing slashes from calculated URLs
//    $resourceProvider.defaults.stripTrailingSlashes = false;
//}]);

routerApp.config(function ($stateProvider, $urlRouterProvider, RestangularProvider) {
    RestangularProvider.setBaseUrl(window.location.pathname + "api/mess/");

    $urlRouterProvider.otherwise('/home');          //страница по умолчанию
    $stateProvider
    //Аутентификация пользователя
    //    .state('login', {
    //        url: '/login',
    //        templateUrl: 'login.html',//'src/auth/partials/login.html',
    //        controller: 'CtrlAutor'//,             //контроллер
    //        //data: {
    //        //    'noLogin': true
    //        //}
    //    })
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

//routerApp.service('SessionService', [
//    '$injector',
//    function($injector) {
//        "use strict";
//
//        this.checkAccess = function(event, toState, toParams, fromState, fromParams) {
//            var $scope = $injector.get('$rootScope'),
//                $sessionStorage = $injector.get('$sessionStorage');
//
//            if (toState.data !== undefined) {
//                if (toState.data.noLogin !== undefined && toState.data.noLogin) {
//                    // если нужно, выполняйте здесь какие-то действия перед входом без авторизации
//                }
//            } else {
//                // вход с авторизацией
//                if ($sessionStorage.user) {
//                    $scope.$root.user = $sessionStorage.user;
//                } else {
//                    // если пользователь не авторизован - отправляем на страницу авторизации
//                    event.preventDefault();
//                    $scope.$state.go('auth.login');
//                }
//            }
//        };
//    }
//]);
//
//routerApp.run(['$rootScope', '$state', '$stateParams', 'SessionService',
//    function ($rootScope, $state, $stateParams, SessionService) {
//        $rootScope.$state = $state;
//        $rootScope.$stateParams = $stateParams;
//        $rootScope.user = null;
//
//        // Здесь мы будем проверять авторизацию
//        $rootScope.$on('$stateChangeStart',
//            function (event, toState, toParams, fromState, fromParams) {
//                SessionService.checkAccess(event, toState, toParams, fromState, fromParams);
//            }
//        );
//        console.log("::use::run");
//    }]);