/**
 * Created by yuri on 17.02.16.
 */
routerApp.controller('CtrlFind', function ($scope, $log, $filter, $uibModal, $interval, $http) {//, $state, theService
    //массив json объектов задач
    $scope.urlst = window.location.pathname + "api/mess/";

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
        $http.get($scope.urlst + 'listSpisokLpmo').success(function (response) {
            $scope.items = response;
            $scope.search();
            $scope.totalItems = $scope.items.length;
        });
    };

    //массив json объектов listJurnal
    $scope.find = function () {
        $http.get($scope.urlst + 'find', {//fam=
            params: { spisokLpmoKl: $scope.sel.spisokLpmoKl, obshhee: $scope.sel.obshhee }         //}//{ fam: val, sensor: false }
        }).success(function (response) {
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

    //Изменение статуса
    $scope.rate = 7;
    $scope.max = 10;
    $scope.isReadonly = false;

    $scope.hoveringOver = function (value) {
        $scope.overStar = value;
        $scope.percent = 100 * (value / $scope.max);
    };

    // открытие диалогового окна для редактирования задачи
    $scope.open = function (cl, size) {
        //если постой объект, создадим новую задачу
        if (cl === null) {

        }

        //создадим новый экземпляр диалогового окна
        var modalInst = $uibModal.open({
            templateUrl: 'modKl.html', controller: 'ModalInstCtrlKL', size: size,
            resolve: {items: cl}
        });                                     //передадим объект cl


        modalInst.result.then(function (selItem) {                      //возвратим результат изменений
            $scope.selected = selItem;
        }, function () {
            $log.info('Modal info');
        });
    };

    var _selected;
    $scope.selected = undefined;
    //$scope.states = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Dakota', 'North Carolina', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'];

    //$scope.getLocation = function (val) {
    //    return $http.get($scope.urlst + 'fam/' + val, {
    //        //params: { fam: val }//{ fam: val, sensor: false }
    //    }).then(function (response) {
    //        return response.data;//.results.map(function (item) { return item;/*.formatted_address;*/  });
    //    });
    //};

    $scope.selectedRow = null;  // initialize our variable to null
    $scope.setClickedRow = function(index){  //function that sets the value of selectedRow to current index
        $scope.selectedRow = index;
    }

    //Сохранить
    $scope.save = function () {
        $scope.sel.spisokLpmoKl.kl = null;
        $scope.sel.spisokLpmoKl.pol = false;
        //$scope.sel.spisokLpmoKl.datasRozhd = null;
        $scope.sel.spisokLpmoKl.pasportaId = null;
        $http({
            url: $scope.urlst + 'createKl',
            method: "POST",
            type: "application/json",
            data: $scope.sel.spisokLpmoKl
        }).then(function (response) {  // success
            $scope.sel.spisokLpmoKl.kl = response.data;
            $scope.items.push($scope.sel.spisokLpmoKl);
            $scope.search();
            $scope.totalItems = $scope.items.length;
        }, function (response) { // optional  // failed
            alert("Ошибка записи!" + response);
        });
    };

    //параметры виджета выбора даты
    //статус открытия
    //$scope.open = function ($event) {
    //    $scope.status.opened = true;
    //};
    ////объект статуса
    //$scope.status = {
    //    opened: false
    //};
    //
    //$scope.dateOptions = {
    //    formatYear: 'yyyy',                   //формат года
    //    startingDay: 1                      //начало месяца
    //};
    ////формат даты виджета
    //$scope.format = 'dd.MM.yyyy';

});

////контроллер созданного диалогового окна
//routerApp.controller('ModalInstCtrlKL', function ($scope, $uibModalInstance, $http, items) {
//
//    $scope.urlst = window.location.pathname + "api/mess/";
//    //items.spisokLpmoKl = new Date(items.datasReg);
//    //items.zaklAkt = new Date(items.zaklAkt);
//    $scope.items = items;                                               //входные параметры
//    $scope.selected = {item: $scope.items}; //[0]                     //изменения
//    $scope.toppanel=true;
//
//    $scope.showHideFIO = function (val) {
//        $scope.toppanel = val;
//    };
//
//    $scope.getLocation = function (val) {
//        return $http.get($scope.urlst + 'fam/' + val, {//fam=
//            //params: { fam: val }//{ fam: val, sensor: false }
//        }).then(function (response) {
//            return response.data;//.results.map(function (item) { return item;/*.formatted_address;*/  });
//        });
//    };
//
//    $scope.loadAdres = function () {
//        $http.get($scope.urlst + 'adr/' + $scope.items.spisokLpmoKl.kl).success(function (response) {
//            $scope.adres = response;
//        });
//        $scope.toppanel=false;
//    };
//
//    $scope.loadObshhee = function () {
//        $http.get($scope.urlst + 'obsh/' + $scope.items.spisokLpmoKl.kl).success(function (response) {
//            $scope.obshhee = response;
//        });
//        $scope.toppanel=false;
//    };
//
//    //Сохранить
//    $scope.save = function (it, num, ind) {
//        $http({
//            url: $scope.urlst + 'crspr',
//            method: "POST",
//            type: "application/json",
//            data: num+"="+it
//        }).then(function (response) {  // success
//            if(num === 'fam') {
//               $scope.items.spisokLpmoKl.sprFamId = { id: response.data, fam: it };
//            } else if(num === 'name') {
//                $scope.items.spisokLpmoKl.sprNameId = { id: response.data, name: it };
//            }else if(num === 'otch') {
//                $scope.items.spisokLpmoKl.sprOtchId = { id: response.data, otch: it };
//            }else if(num === 'gragd') {
//                $scope.items.spisokLpmoKl.pasportaId.sprGragdanstvoId = { id: response.data, gragd: it };
//            }else if(num === 'kemVydan') {
//                $scope.items.spisokLpmoKl.pasportaId.sprPaspKemVydanId = { id: response.data, kemVydan: it };
//            }else if(num === 'oblast') {
//                $scope.adres.sprOblastId = { id: response.data, oblast: it };
//            }else if(num === 'gorod') {
//                $scope.adres.sprGorodId = { id: response.data, gorod: it };
//            }else if(num === 'raion') {
//                $scope.adres.sprRaionId = { id: response.data, raion: it };
//            }else if(num === 'ulici') {
//                $scope.adres.sprUliciId = { id: response.data, ulici: it };
//            }else if(num === 'naselPunkt') {
//                $scope.adres.sprNaselPunktId = { id: response.data, naselPunkt: it };
//            }else if(num === 'nameOrg') {
//                $scope.items.rabotaId.sprOrgId = { id: response.data, nameOrg: it };
//            }else if(num === 'nazvPodrazdelenija') {
//                $scope.items.rabotaId.sprMestoRabotyId = { id: response.data, nazvPodrazdelenija: it };
//            }else if(num === 'professija') {
//                $scope.items.rabotaId.sprProfesijaId = { id: response.data, professija: it };
//            }else if(num === 'nameOrg2') {
//                $scope.obshhee.medOrg = { id: response.data, nameOrg: it };
//            }
//            $scope.noResults[ind] = false;
//        }, function (response) { // optional  // failed
//            alert("Ошибка записи!" + response);
//        });
//    };
//
//    /*$scope.getLocation2 = function (val) {
//        return $http.get($scope.urlst + 'fam/name=' + val, {}).then(function (response) {
//            return response.data;
//        });
//    };
//
//    $scope.getLocation3 = function (val) {
//        return $http.get($scope.urlst + 'fam/otch=' + val, {}).then(function (response) {
//            return response.data;
//        });
//    };*/
//
//    //$scope.ok = function () {
//    //    $uibModalInstance.close($scope.selected.item);
//    //};
//    //
//    //$scope.cancel = function () {
//    //    $uibModalInstance.dismiss('cancel');
//    //};
//
//    $scope.evnt = function (val) {                                      //собылие закрытия и возврата результатов
//        if (val === 'ok') {
//            $uibModalInstance.close($scope.selected.item);
//        } else {
//            $uibModalInstance.dismiss('cancel');
//        }
//    };
//
//    //параметры виджета выбора даты
//    //статус открытия
//    $scope.open = function ($event) {
//        $scope.status.opened = true;
//    };
//    //объект статуса
//    $scope.status = {
//        opened: false
//    };
//
//    $scope.dateOptions = {
//        formatYear: 'yyyy',                   //формат года
//        startingDay: 1                      //начало месяца
//    };
//    //формат даты виджета
//    $scope.format = 'dd.MM.yyyy';
//
//});