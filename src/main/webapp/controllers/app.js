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
    'ngAnimate'
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

routerApp.config(function ($stateProvider, $urlRouterProvider) {
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
        // Описание
        .state('about', {
            url: '/home',
            templateUrl: 'partial-about.html'
        });
});