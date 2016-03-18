/**
 * Created by yuri on 15.02.16.
 */
routerApp.controller('CtrlAutor', function ($scope, $state, Restangular) {//, AuthService, $http, theService

    //$scope.isAutorized = false;
    //theService.thing.visibleNav = false;                                //скрыть панели
    //$scope.urlst = window.location.pathname + "api/mess/";

    //$scope.login = function (login, password) {
    //    AuthService.loginByCredentials(login, password).catch(function () {
    //        //выводим ошибку авторизации
    //    });
    //};

    //массив json объектов пользователей
    Restangular.all('listPass').getList().then(function (response) {
            $scope.users = response.plain();
            $scope.usr = $scope.users[0].id;
        });

    //функция проверки Аутентификации пользователя
    $scope.checkLogin = function () {
        Restangular.one('login', $scope.usr + "=" + $scope.psw).get()
            .then(function (response) {
                $state.transitionTo(response);
            });
        //$http.get(CONST.curr_url + 'login/' + $scope.usr + "=" + $scope.psw)
        //    .success(function (response) {
        //        $state.transitionTo(response);
        //    });
        //$http({
        //    url: $scope.urlst + 'login',
        //    method: "POST",
        //    type: "application/json",
        //    data: $scope.usr+"="+$scope.psw
        //}).then(function (response) {  // success
        //    $scope.rez = response.data;
        //}, function (response) { // optional  // failed
        //    alert("Ошибка!" + response);
        //});
    };

    //$scope.getUsers = function () {
    //    $scope.users =Restangular.all('listPass').getList().$object;  // GET: /users
    //    $scope.usr = $scope.users[0];
    //        //.then(function(users) {
    //        //    $scope.users =users;
    //        //    // returns a list of users
    //        //    $scope.usr = users[0]; // first Restangular obj in list: { id: 123 }
    //        //})
    //
    //    //$scope.users = $resource(CONST.curr_url + 'listPass/', {}, {
    //    //    query: {method: 'GET', isArray: true,  cache: true}}
    //    //).query();
    //    //$scope.usr = $scope.users[0].id;
    //
    //    //$http.get(CONST.curr_url + 'listPass').success(function (response) {
    //    //    $scope.users = response;
    //    //    $scope.usr = $scope.users[0].id;
    //    //});
    //};
    //
    //$scope.getUsers();

});