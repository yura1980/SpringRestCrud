/**
 * Created by yuri on 15.02.16.
 */
routerApp.controller('CtrlAutor', function ($scope, $state, $http, theService) {

    theService.thing.visibleNav = false;                                //скрыть панели

    $scope.urlst = window.location.pathname + "api/mess/";

    //массив json объектов пользователей
    $scope.getUsers = function () {
        $http.get($scope.urlst + 'listPass').success(function (response) {
            $scope.users = response;
            $scope.usr = $scope.users[0].id;
        });
    };

    $scope.getUsers();

    //функция проверки Аутентификации пользователя
    $scope.checkLogin = function () {
        $scope.users.forEach(function (it) {
            if ($scope.usr === it.id && $scope.psw === it.pole2) {
                theService.thing.visibleNav = true;                     //показать панели
                theService.thing.idUser = it.id;                    //id пользователя
                $state.transitionTo('home');                            //переместиться по адресу
            }
        });
    };

});