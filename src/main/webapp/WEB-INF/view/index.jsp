<%-- 
    Document   : index
    Created on : 07.11.2015, 16:32:49
    Author     : yura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Messeg</title>
        <!-- CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"> 
        <style>
            <%@include file='../../styles/mycss.css' %>
        </style>
        <!-- JS  -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
        <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.14.1.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script>
            <%@include file='../../controllers/contr.js' %>
        </script>        
    </head>
    <body  ng-app="myApp">
        <div ng-controller="myCtrl" >
            
            <!-- навигация -->
            <nav class="navbar navbar-default" style="width: 99%" role="navigation"  >
                <div class="navbar-header">
                    <a class="navbar-brand" ui-sref="autor">UI таск messeg</a>
                </div>
                <ul class="nav navbar-nav" >
                    <li><a href="#" data-toggle="modal" data-target="#myModal" ng-click="add()">Добавить</a></li>               
                </ul>
                <ul class="nav navbar-nav" >
                    <li><a href="#">Ссылки</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">                
                    <li><a ui-sref="autor"><span class="glyphicon glyphicon-log-in"></span> Login </a></li>
                </ul>
            </nav>

            <div class="form-group col-md-4" >
                <div class="list-group">
                    <a style="margin-bottom: 20px" class="list-group-item list-group-item-warning" 
                       href="#" ng-repeat="it in pagedItems[currentPage-1]" ng-mouseenter="setItem(it)" ng-click="setItem(it)"
                        data-toggle="modal" data-target="#myModal"> 
                        <span class="badge" >{{it.id}}</span> 
                        <h4>{{it.sprAvtorsId.avtor}}</h4>
                        <hr/>
                        <pre style="float: right; width: 250px">Время: {{it.timez | date:'dd.MM.yyyy HH:mm'}}</pre>
                        <p class="list-group-item-text">
                            {{it.text}}
                        </p>
                    </a>
                </div>
                <uib-pagination total-items="totalItems" items-per-page="gap" 
                                ng-model="currentPage" max-size="maxSize" class="pagination-lg" boundary-links="true" rotate="false" num-pages="numPages"></uib-pagination>
            </div>
            <div class="col-md-4" >
                <pre><label>Автор:</label> {{ scrum.sprAvtorsId.avtor}}<p><label>Запись от:</label> {{scrum.timez | date:'dd.MM.yyyy HH:mm'}}</p><p><label>Ваш текст:</label> {{ scrum.text}}</p></pre>
                <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" ng-click="add()">Добавить</button>
            </div>
            
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Запись от: {{scrum.timez | date:'dd.MM.yyyy HH:mm'}}</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form">
                                <div class="form-group">
                                    <label for="avt">Автор:</label>
                                    <input id="avt" type="" autosave="some_unique_value" name="s" 
                                           placeholder="Автор" results="5" name="avtorsearch" 
                                           ng-model="scrum.sprAvtorsId.avtor" class="form-control" autofocus list="avtor">        
                                    <datalist style="overflow:scroll;" id="avtor">                                         
                                        <option  ng-repeat="it in itemsAu" value="{{it.avtor}}"></option>                                        
                                    </datalist>                                  
                                </div>                    
                                <div class="form-group">
                                    <label for="prim">Ваш текст:</label>
                                    <textarea class="form-control" rows="3" ng-model="scrum.text" id="prim"></textarea>
                                </div>                                
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" ng-show="sh_butt" ng-click="save()" data-dismiss="modal">Сохранить</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                        </div>
                    </div>

                </div>
            </div>

        </div>
 
    </body>
</html>
