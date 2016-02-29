# UI messeger

Программа для чтения и зоздания ленты сообщений, которая включает в себя:

  - Добавление сообщений
  - Просмотр сообщений
  - Сортировка по дате создания

В проекте использованы следующие сторонние библеотеки, модули, фраемворки.

> Spring MVC,
> Bootstrap,
> jquery,
> angularJS,
> ui-bootstrap,
> hibernate.

### Version
0.0.1

### Plugins UI JS клиент messeger

Использование внешних библеотек для клиентского приложения:

* [//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css] - bootstrap!
* [https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js] - jquery
* [//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js] - angularJS
* [//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.14.1.js] - ui-bootstrap
* [http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js] - bootstrap
* contr.js - контроллер для angular JS
* mycss.css - Библеотека стилей

### Installation

Сборка проекта в IDE NetBeans:

```sh
------------------------------------------------------------------------
Building SpringRestCrudMaven 1.0-SNAPSHOT
------------------------------------------------------------------------

--- maven-resources-plugin:2.4.3:resources (default-resources) @ SpringRestCrud ---
Using 'UTF-8' encoding to copy filtered resources.
Copying 1 resource

--- maven-compiler-plugin:2.3.2:compile (default-compile) @ SpringRestCrud ---
Nothing to compile - all classes are up to date

--- maven-resources-plugin:2.4.3:testResources (default-testResources) @ SpringRestCrud ---
Using 'UTF-8' encoding to copy filtered resources.
skip non existing resourceDirectory D:\_MED_\JAVA\SpringRestCrud\src\test\resources

--- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ SpringRestCrud ---
No sources to compile

--- maven-surefire-plugin:2.10:test (default-test) @ SpringRestCrud ---
Surefire report directory: D:\_MED_\JAVA\SpringRestCrud\target\surefire-reports
```

### Development

Запуск проекта.
Инициализация репозитория:
```sh
Создание каталога git D:\_MED_\JAVA\SpringRestCrud/.git
git init D:\_MED_\JAVA\SpringRestCrud
```
Deploying on GlassFish Server 4.1:
```sh
NetBeans: Deploying on GlassFish Server 4.1
    profile mode: false
    debug mode: false
    force redeploy: true
Запуск GlassFish Server 4.1
```