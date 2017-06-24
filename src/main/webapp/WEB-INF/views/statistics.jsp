<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en" ng-app="poll">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Fixed Top Navbar Example for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link
	href="/encuestadocente/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/encuestadocente/resources/js/jquery.js"></script>
<script
	src="/encuestadocente/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="/encuestadocente/resources/angular/angular.min.js"></script>

</head>

<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Encuesta de Docentes</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
<!-- 					<li class="active"><a href="#">Home</a></li> -->
<!-- 					<li><a href="#about">About</a></li> -->
<!-- 					<li><a href="#contact">Contact</a></li> -->
<!-- 					<li class="dropdown"><a href="#" class="dropdown-toggle" -->
<!-- 						data-toggle="dropdown" role="button" aria-haspopup="true" -->
<!-- 						aria-expanded="false">Dropdown <span class="caret"></span></a> -->
<!-- 						<ul class="dropdown-menu"> -->
<!-- 							<li><a href="#">Action</a></li> -->
<!-- 							<li><a href="#">Another action</a></li> -->
<!-- 							<li><a href="#">Something else here</a></li> -->
<!-- 							<li role="separator" class="divider"></li> -->
<!-- 							<li class="dropdown-header">Nav header</li> -->
<!-- 							<li><a href="#">Separated link</a></li> -->
<!-- 							<li><a href="#">One more separated link</a></li> -->
<!-- 						</ul></li> -->
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<!-- 					<li><a href="../navbar/">Default</a></li> -->
					<li><a href="../navbar-static-top/">Bienvenido Enrique
							Bellido Molina</a></li>
					<li class="active"><a href="./">Cerrar sesión<span
							class="sr-only">(current)</span></a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron" ng-controller="CabeceraEncuestaController">
			<br>

			<h3>
				<strong>Reporte de Resultados por Docente y Curso</strong>
			</h3>
			
			<br>

			<div class="form-horizontal">

				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Facultad:</label>
					<div class="col-sm-8">
						<select ng-model="idFacultad" class="form-control"
							ng-change="obtenerCarrerasProfesionales()"
							ng-options="item.id as item.nombre for item in facultades">
							<option value="">Seleccione facultad</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Departamento
						Académico:</label>
					<div class="col-sm-8">
						<select ng-model="idCarreraProfesional" class="form-control"
							ng-change="obtenerCursos()"
							ng-options="item.id as item.nombre for item in carrerasProfesionales">
							<option value="">Seleccione departamento académico</option>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Semestre
						Académico:</label>
					<div class="col-sm-8">
						<input type="text" value="2017-1" class="form-control"
							ng-disabled="cabeceraDesHabilitada" id="exampleInputName2"
							placeholder="">
					</div>
				</div>
				
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Año
						de Estudios:</label>
					<div class="col-sm-8">
						<input type="text" value="2017" class="form-control"
							ng-disabled="cabeceraDesHabilitada" id="exampleInputName2"
							placeholder="">
					</div>
				</div>
				
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Curso:</label>
					<div class="col-sm-8">
						<select ng-model="idCurso" class="form-control"
							ng-change="obtenerGrupos()"
							ng-options="item.id as item.nombre for item in cursos">
							<option value="">Seleccione curso</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Grupo:</label>
					<div class="col-sm-8">
						<select ng-model="idGrupo" class="form-control"
							ng-change="obtenerDocenteGrupo()"
							ng-options="item.id as item.nombreGrupo for item in grupos">
							<option value="">Seleccione grupo</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Docente:</label>
					<div class="col-sm-8">
						<select ng-model="idDocente" class="form-control"
							ng-options="item.idDocente as item.docenteNombreCompleto for item in grupos">
							<option value="">Seleccione docente</option>
						</select>
					</div>
				</div>

			</div>

			<script>
			
				var app = angular.module('poll', []);

				app.directive('onFinishRender', function($timeout) {
					return {
						restrict : 'A',
						link : function(scope, element, attr) {
							if (scope.$last === true) {
								$timeout(function() {
									scope.$emit(attr.onFinishRender);
								});
							}
						}
					}
				});

				app.controller('CabeceraEncuestaController', function($scope, $http) {
					$scope.cabeceraDesHabilitada = true;
					$scope.idFacultad = null;
					$scope.idEncuesta = '${idEncuesta}';
					$scope.idUsuario = '${idAdministrativo}';
					

					$http.get('api/obtenerFacultades').then(
							function(response) {
								$scope.facultades = response.data;
							});
					
					$scope.obtenerCarrerasProfesionales = function() {
						
						if($scope.idFacultad != null){
							$http.get('api/obtenerCarrerasProfesionales/' + $scope.idFacultad).then(
										function(response) {
											$scope.carrerasProfesionales = response.data;
										}
							);
						}
					}
					
					$scope.obtenerCursos = function() {
						
						if($scope.idCarreraProfesional != null){
							$http.get('api/obtenerCursos/' + $scope.idCarreraProfesional).then(
										function(response) {
											$scope.cursos = response.data;
										}
							);
						}
					}
					
					$scope.obtenerGrupos = function() {
						
						if($scope.idCurso != null){
							$http.get('api/obtenerGruposPorCurso/' + $scope.idCurso).then(
										function(response) {
											$scope.grupos = response.data;
										}
							);
						}
					}
					
					$scope.obtenerDocenteGrupo = function() {
						
						if($scope.idGrupo != null){
							
							for(i = 0; i < $scope.grupos.length; i++){
								if( $scope.grupos[i].idGrupo =  $scope.idGrupo){
									$scope.idDocente = $scope.grupos[i].idDocente;
								}
							}
						}
					}
					
					

				});
			</script>

			<div class="container">

				<input name="esModificacion" id="esModificacion" hidden="true">
				
				<div class="progress">
				  <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
				    60%
				  </div>
				</div>

			</div>
		</div>
</body>
</html>