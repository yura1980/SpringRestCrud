/**
 * Created by yuri on 15.02.16.
 */
/*
 Created on : 28.10.2015, 9:33:58
 Author     : Vasyanin Yuri
 */
routerApp.controller('CtrlTask', function ($scope, $log, $filter, $uibModal, $interval, $http, $state, theService) {
    //массив json объектов задач
    $scope.urlst = window.location.pathname + "api/mess/";

    //theService.thing.visibleNav=true;
    //$scope.someThing = theService.thing;                            //праметры из другого контроллера
    $scope.sort = {sortingOrder: 'id', reverse: false};             //праметры сортировки

    $scope.gap = 5;                                                 //шаг страницы для таблицы
    $scope.filteredItems = [];                                      //фильтр.элементы страницы
    $scope.itemsPerPage = 5;                                        //кол-во элементов на странице
    $scope.pagedItems = [];                                         //элементы страницы
    $scope.currentPage = 1;                                         //текущая страница
    $scope.updateTask = 0;                                          //номер обновления

    //фильтрация элементов таблицы
    $scope.search = function () {
        //текущий пользователь
        //$scope.items = $filter('filter')($scope.items, {'idUser': $scope.someThing.idUser});

        //поиск
        $scope.filteredItems = $filter('filter')($scope.items, function (item) {
            for (var attr in item) {
                if (searchMatch(item[attr], $scope.query))
                    return true;
            }
            return false;
        });
        //сортировка таблицы
        if ($scope.sort.sortingOrder !== '') {
            $scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sort.sortingOrder, $scope.sort.reverse);
        }
        $scope.currentPage = 1;
        //группировка
        $scope.groupToPages();
    };
    //поиск
    var searchMatch = function (haystack, needle) {
        if (!needle) {
            return true;
        }
        return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
    };

    //расчет элементов страницы в таблице
    $scope.groupToPages = function () {
        $scope.pagedItems = [];

        for (var i = 0; i < $scope.filteredItems.length; i++) {
            if (i % $scope.itemsPerPage === 0) {
                $scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [$scope.filteredItems[i]];
            } else {
                $scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
            }
        }
    };

    //массив json объектов listJurnal
    $scope.getJurnal = function () {
        $http.get($scope.urlst + 'listJurnal').success(function (response) {
            $scope.items = response;
            $scope.search();
            $scope.totalItems = $scope.items.length;
        });
    };

    //инициализация
    $scope.getJurnal();

    // параметры "пагинатора" таблицы
    $scope.maxSize = 5;

    //установка на нужной странице
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    // открытие диалогового окна для редактирования задачи
    $scope.open = function (cl, size) {
        //если постой объект, создадим новую задачу
        if (cl === null) {
            cl = {
                "id": $scope.items.length + 1,
                "idUser": $scope.someThing.idUser,
                "name": "--",
                "description": "--",
                "curdata": new Date(),
                "prior": 1,
                "pltime": "0",
                "zatrtime": "0",
                "stat": "false"
            };
            $scope.items.push(cl);
            $scope.totalItems = $scope.items.length;
            $scope.search();
            $scope.setPage($scope.pagedItems.length);
        }
        //создадим новый экземпляр диалогового окна
        var modalInst = $uibModal.open({
            templateUrl: 'mod.html', controller: 'ModalInstCtrl', size: size,
            resolve: {items: cl}
        });                                     //передадим объект cl
        modalInst.result.then(function (selItem) {                      //возвратим результат изменений
            $scope.selected = selItem;
        }, function () {
            $log.info('Modal info');
        });
    };

    //посещения
    $scope.getPoseshenie = function () {
        $http.get($scope.urlst + 'listPoseshenie').success(function (response) {
            $scope.poseshenie = response;
            $log.info($scope.poseshenie);
        });
    };

    $scope.openSp = function () {
        $state.transitionTo('spisok');
        //"spisok"
    }

    ////прогресс
    //$scope.onProgrComplete = function (){
    //    $scope.dynamic =Math.floor(($filter('filter')($scope.items, {'idUser': $scope.someThing.idUser, stat:null})).length*100/ $scope.items.length);
    //};
    ////прогресс
    //$scope.onProgrComplete();

    //Изменение статуса
    $scope.rate = 7;
    $scope.max = 10;
    $scope.isReadonly = false;

    $scope.hoveringOver = function (value) {
        $scope.overStar = value;
        $scope.percent = 100 * (value / $scope.max);
    };
});

//контроллер созданного диалогового окна
routerApp.controller('ModalInstCtrl', function ($scope, $uibModalInstance, $http, items) {

    $scope.urlst = window.location.pathname + "api/mess/";

    $scope.getLocation = function (val) {
        return $http.get($scope.urlst + 'fam/' + val, {//fam=
            //params: { fam: val }//{ fam: val, sensor: false }
        }).then(function (response) {
            return response.data;//.results.map(function (item) { return item;/*.formatted_address;*/  });
        });
    };

    items.datasReg = new Date(items.datasReg);
    items.zaklAkt = new Date(items.zaklAkt);
    $scope.items = items;                                               //входные параметры
    $scope.selected = {item: $scope.items}; //[0]                     //изменения
    $scope.evnt = function (val) {                                      //собылие закрытия и возврата результатов
        if (val === 'ok') {
            $uibModalInstance.close($scope.selected.item);
        } else {
            $uibModalInstance.dismiss('cancel');
        }
    };

    //параметры виджета выбора даты
    //статус открытия
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

});

//создание своей дириктивы сортировки таблицы
routerApp.$inject = ['$scope', '$filter'];                          //вручную указываем объекты, которые хотим внедрить в виде строк
routerApp.directive("customSort", function () {                     //Метод-фабрика для директивы
    return {
        restrict: 'A',                                              //директива используеться как атрибут
        transclude: true,                                           //приоритет на котором объявлена эта директива будет последним приоритетом исполнения. Т.е. будут выполнены только директивы приоритетом выше и с таким же
        scope: {                                                    //в атрибут передается имя переменной в текущем Scope. И локальная переменная будет напрямую с ней связана
            order: '=',
            sort: '='
        },
        template://шаблон стиля заголовка колонки
        ' <a ng-click="sort_by(order)" style="cursor: pointer;color: #555555;">' +
        '    <span ng-transclude></span>' +
        '    <i ng-class="selectedCls(order)"></i>' +
        '</a>',
        link: function (scope) {                                    //собитие нажатия на заголовок

            //смена сотрировки колонки(по возростанию/убыванию)
            scope.sort_by = function (newSortingOrder) {
                var sort = scope.sort;
                //инверсия сортировки
                if (sort.sortingOrder === newSortingOrder) {
                    sort.reverse = !sort.reverse;
                }

                sort.sortingOrder = newSortingOrder;
            };

            //смена иконки(стиля) выбранной колонки для сортровки
            scope.selectedCls = function (column) {
                if (column === scope.sort.sortingOrder) {
                    return ('glyphicon glyphicon-sort-by-attributes' + ((scope.sort.reverse) ? '-alt' : ''));
                }
                else {
                    return 'glyphicon glyphicon-sort';
                }
            };
        }

    };

});


