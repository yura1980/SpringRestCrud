/**
 * Created by yuri on 17.02.16.
 */
routerApp.controller('CtrlSp', function ($scope, $log, $filter, $uibModal, Restangular) {//$interval, $http, $state, theService
    //массив json объектов задач
    //$scope.urlst = window.location.pathname + "api/mess/";

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
        Restangular.all('listPoseshenie').getList().then(function (response) {
            $scope.items = response;
            $scope.search();
            $scope.totalItems = $scope.items.length;
        });
        //$http.get($scope.urlst + 'listPoseshenie').success(function (response) {
        //    $scope.items = response;
        //    $scope.search();
        //    $scope.totalItems = $scope.items.length;
        //});
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
            var cl = {
                id: -1,
                dataPos: new Date(),//"2016-02-01T00:00:00.000Z",
                utochn: false,
                zakl: false,
                dogovora: null,
                potok: null,
                oplata: {id: -1, oplata: true, cena: 0, skidka: 0, dispans: false, dataDispans: null},
                rezultatMo: null,
                jurnalRn: 1, //{
                //    "rn": 1,
                //    "datasReg": "",
                //    "obrabotkaDok": true,
                //    "zaklAkt": "",
                //    "idVidPmo": 1,
                //    "sprOrgId": {"id": 1, "nameOrg": "физ.лица", "sprOrgDopInf": null, "cenyMoOrg": null},
                //    "sprPoliklinikiId": {"id": 1, "poliklinika": "тест", "idR": null, "sprTipPoliklinikiId": null}
                //},
                spisokLpmoKl: {
                    kl: -1,
                    pol: false,
                    datasRozhd: null,//"1980-11-11T00:00:00.000Z",
                    sprFamId: null,//{"id": 1, "fam": "Васянин"},
                    sprNameId: null,//{"id": 1, "name": "Юрий"},
                    sprOtchId: null,
                    pasportaId: {
                        id: -1,
                        pasport: "",
                        datasVydachi: null,//"2011-11-11T00:00:00.000Z",
                        migrant1: false,
                        sprGragdanstvoId: null,//{"id": 1, "gragd": "Россия"},
                        sprPaspKemVydanId: null//{"id": 1, "kemVydan": "УВД Ульяновского района"}
                    }
                },
                sprPrichNejavkiNaMoId: null,
                prichinaId: null,//{"id": 1, "prich": "МО"},
                sprVidMoId: {"id": 1, "vidMo": "Предв", "sokr": "Предв"},
                rabotaId: {
                    id: -1,
                    stazhObshh: null,//"1970-01-01T00:00:00.000Z",
                    stazhTekushh: null,//"1970-01-01T00:00:00.000Z",
                    sprMestoRabotyId: null,//{"id": 1, "nazvPodrazdelenija": "Основное"},
                    sprOrgId: null,//{"id": 1, "nameOrg": "физ.лица", "sprOrgDopInf": null, "cenyMoOrg": null},
                    sprProfesijaId: null//{"id": 1, "professija": "программист"}
                }
            };
            $scope.items.push(cl);
            $scope.totalItems = $scope.items.length;
            $scope.search();
            $scope.setPage($scope.pagedItems.length);
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
    //
    //$scope.getLocation = function (val) {
    //    return $http.get($scope.urlst + 'fam/' + val, {
    //        //params: { fam: val }//{ fam: val, sensor: false }
    //    }).then(function (response) {
    //        return response.data;//.results.map(function (item) { return item;/*.formatted_address;*/  });
    //    });
    //};
});

//контроллер созданного диалогового окна
routerApp.controller('ModalInstCtrlKL', function ($scope, $uibModalInstance, items, Restangular) {

    //$scope.urlst = window.location.pathname + "api/mess/";

    items.dataPos = new Date(items.dataPos);
    items.spisokLpmoKl.datasRozhd = new Date(items.spisokLpmoKl.datasRozhd);
    if (items.spisokLpmoKl.pasportaId === null) {
        items.spisokLpmoKl.pasportaId = {
            id: -1,
            pasport: "",
            datasVydachi: "",
            migrant1: false,
            sprGragdanstvoId: null,
            sprPaspKemVydanId: null
        }
    } else {
        items.spisokLpmoKl.pasportaId.datasVydachi = new Date(items.spisokLpmoKl.pasportaId.datasVydachi);
    }
    items.rabotaId.stazhObshh = new Date(items.rabotaId.stazhObshh);
    items.rabotaId.stazhTekushh = new Date(items.rabotaId.stazhTekushh);

    $scope.items = items;                                               //входные параметры
    $scope.selected = {item: $scope.items}; //[0]                     //изменения
    $scope.toppanel = true;

    $scope.adres = {
        id: -1, tip: 1, nomerDoma: null, korpus: null, nomerKvartiry: null, adres: null, sprGorodId: null,
        sprNaselPunktId: null, sprOblastId: null, sprRaionId: null, sprUliciId: null
    };
    $scope.obshhee = {id: -1, telefon: null, nomerPoljusa: null, telefon2: null, snils: null, medOrg: null};

    $scope.showHideFIO = function (val) {
        $scope.toppanel = val;
    };

    $scope.loadObj = function (val) {
        Restangular.one(val, $scope.items.spisokLpmoKl.kl).get()
            .then(function (response) {
                if (response !== undefined) {
                    if (val === 'adr') {
                        $scope.adres = response;
                    } else if (val === 'obsh') {
                        $scope.obshhee = response;
                    }
                }
            });
        //$http.get($scope.urlst + 'adr/' + $scope.items.spisokLpmoKl.kl).success(function (response) {
        //    $scope.adres = response;
        //});
        $scope.toppanel = false;
    };

    $scope.bildAdres = function () {
        $scope.adres.adres = $scope.adres.sprOblastId.oblast + ', г.' + $scope.adres.sprGorodId.gorod + ', ' + $scope.adres.sprRaionId.raion + ' р-н, ' +
            $scope.adres.sprNaselPunktId.naselPunkt + ', ул.' +$scope.adres.sprUliciId.ulici + ', д.' + $scope.adres.nomerDoma + ', корп.' +
            $scope.adres.korpus + ', кв.' + $scope.adres.nomerKvartiry;
    };

    $scope.multi =
        [{ pr: 1, id: 1, fam: 'раз', info: "Artifact SpringRestCrud:war: Artifact is being deployed, please wait..." },
            {pr: 1, id: 2, fam: 'два', info: "Artifact SpringRestCrud"},
            { pr: 2, id: 3, fam: 'три', info: "Artifact SpringRestCrud:war: Artifact is." }];

    //$scope.loadObshhee = function () {
    //    //$http.get($scope.urlst + 'obsh/' + $scope.items.spisokLpmoKl.kl).success(function (response) {
    //    //    $scope.obshhee = response;
    //    //});
    //    $scope.toppanel = false;
    //};

    //Сохранить
    //$scope.save = function (it, num, ind) {
    //    $http({
    //        url: $scope.urlst + 'crspr',
    //        method: "POST",
    //        type: "application/json",
    //        data: num+"="+it
    //    }).then(function (response) {  // success
    //        if(num === 'fam') {
    //           $scope.items.spisokLpmoKl.sprFamId = { id: response.data, fam: it };
    //        } else if(num === 'name') {
    //            $scope.items.spisokLpmoKl.sprNameId = { id: response.data, name: it };
    //        }else if(num === 'otch') {
    //            $scope.items.spisokLpmoKl.sprOtchId = { id: response.data, otch: it };
    //        }else if(num === 'gragd') {
    //            $scope.items.spisokLpmoKl.pasportaId.sprGragdanstvoId = { id: response.data, gragd: it };
    //        }else if(num === 'kemVydan') {
    //            $scope.items.spisokLpmoKl.pasportaId.sprPaspKemVydanId = { id: response.data, kemVydan: it };
    //        }else if(num === 'oblast') {
    //            $scope.adres.sprOblastId = { id: response.data, oblast: it };
    //        }else if(num === 'gorod') {
    //            $scope.adres.sprGorodId = { id: response.data, gorod: it };
    //        }else if(num === 'raion') {
    //            $scope.adres.sprRaionId = { id: response.data, raion: it };
    //        }else if(num === 'ulici') {
    //            $scope.adres.sprUliciId = { id: response.data, ulici: it };
    //        }else if(num === 'naselPunkt') {
    //            $scope.adres.sprNaselPunktId = { id: response.data, naselPunkt: it };
    //        }else if(num === 'nameOrg') {
    //            $scope.items.rabotaId.sprOrgId = { id: response.data, nameOrg: it };
    //        }else if(num === 'nazvPodrazdelenija') {
    //            $scope.items.rabotaId.sprMestoRabotyId = { id: response.data, nazvPodrazdelenija: it };
    //        }else if(num === 'professija') {
    //            $scope.items.rabotaId.sprProfesijaId = { id: response.data, professija: it };
    //        }else if(num === 'nameOrg2') {
    //            $scope.obshhee.medOrg = { id: response.data, nameOrg: it };
    //        }
    //        $scope.noResults[ind] = false;
    //    }, function (response) { // optional  // failed
    //        alert("Ошибка записи!" + response);
    //    });
    //};


    //$scope.ok = function () {
    //    $uibModalInstance.close($scope.selected.item);
    //};
    //
    //$scope.cancel = function () {
    //    $uibModalInstance.dismiss('cancel');
    //};

    $scope.evnt = function (val) {                                      //собылие закрытия и возврата результатов
        if (val === 'ok') {
            $uibModalInstance.close($scope.selected.item);
        } else {
            $uibModalInstance.dismiss('cancel');
        }
    };

    $scope.save = function () {
        if (!$scope.formKl.osnForm.$dirty || !$scope.formKl.osnForm.$valid) {
            items.oplata = null;
        }
        if (!$scope.formKl.paspForm.$dirty || !$scope.formKl.paspForm.$valid) {
            items.spisokLpmoKl.pasportaId = null;
        }
        if (!$scope.formKl.rabForm.$dirty || !$scope.formKl.rabForm.$valid) {
            items.rabotaId = null;
        }
        if (!$scope.formKl.adrForm.$dirty || !$scope.formKl.adrForm.$valid) {
            $scope.adres = null;//.id = $scope.items.spisokLpmoKl.kl;//Restangular.all('createAdr').post($scope.adres).then(function (response) {  });
        }
        if (!$scope.formKl.obshForm.$dirty || !$scope.formKl.obshForm.$valid) {
            $scope.obshhee = null;//.id = $scope.items.spisokLpmoKl.kl;//Restangular.all('createObsh').post($scope.obshhee).then(function (response) { });
        }

        var Klient = {
            poseshenie: $scope.items,
            adres: $scope.adres,
            obshhee: $scope.obshhee
        };

        Restangular.all('createPos').post(Klient).then(function (response) {//$scope.items
            var ids = response;
            $scope.items.id = ids[0];
            $scope.items.spisokLpmoKl.kl = ids[1];

            $uibModalInstance.close($scope.selected.item);
        });

        //alert(JSON.stringify($scope.items));
    };

});