<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en" ng-app="myapp">
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

<script src="/encuestadocente/resources/js/loader.js"></script>

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

				</ul>
				<ul class="nav navbar-nav navbar-right">

					<li><a href="../navbar-static-top/">Bienvenido
							Administrador</a></li>
					<li class="active"><a href="./">Cerrar sesión<span
							class="sr-only">(current)</span></a></li>
				</ul>
			</div>

		</div>
	</nav>

	<br />
	<br />
	<br />
	<br />
	<br />

	<div ng-controller="EncuestaController">

		<div class="container">
			<div class="form-horizontal">

				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Semestre
						Académico</label>
					<div class="col-sm-8">
						<input type="text" value="2017-1" class="form-control"
							id="idSemestre" name="idSemestre" placeholder=""
							ng-model="idSemestre" ng-disabled="true">
					</div>
				</div>

				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Nombre
						de Encuesta</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="nombre" name="nombre"
							placeholder="" ng-model="nombre" ng-disabled="idEncuesta!=null">
					</div>
				</div>

				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Instrucciones</label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="3" id="instrucciones"
							name="instrucciones" ng-model="instrucciones"
							ng-disabled="idEncuesta!=null"></textarea>
					</div>
				</div>

				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Estado</label>
					<div class="col-sm-8">
						<select class="form-control" ng-model="idEstado"
							ng-disabled="idEncuesta!=null">
							<option value="">Seleccione estado</option>
							<option value="1">Activo</option>
							<option value="0">Inactivo</option>
						</select>
					</div>
				</div>

			</div>
			<br />
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">

					<a class="btn btn-success" href="#" ng-click="guardarEncuesta()"
						role="button"><span class="glyphicon glyphicon-floppy-disk"
						aria-hidden="true"></span> Guardar</a>
				</div>
				<div class="col-md-4"></div>
			</div>

			<br />

			<div class="row" ng-show="idEncuesta!=null">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<form class="form-inline" ng-submit="agregarCriterio(criterio)">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Criterio"
										style="width: 350px" ng-model="criterio.descripcion" required>
								</div>
								<div class="form-group">
									<input type="number" class="form-control" style="width: 120px"
										placeholder="Ponderación" ng-model="criterio.ponderacion"
										required>
								</div>

								<button type="submit" class="btn btn-primary"
									aria-label="Left Align" value="Agregar">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
									Agregar
								</button>

								<!-- 								<input type="submit" value="Agregar" class="btn btn-primary"> -->
							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="row" ng-show="idEncuesta!=null">
				<div class="col-md-4">
					<form class="form-inline" ng-submit="eliminarCriterio()">
						<label for="exampleInputName2" class="col-sm-3 control-label">Criterio</label>
						<div class="col-sm-8">
							<select ng-model="idCriterio" class="form-control"
								ng-change="obtenerPreguntasPorCriterio()"
								ng-options="item.id as item.descripcion for item in listaCriterios">
								<option value="">Seleccione criterio</option>
							</select>
						</div>
						<div class="col-sm-1">
							<button type="submit" class="btn btn-danger" value="EliminarCriterio">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								Eliminar
							</button>
						</div>
					</form>
				</div>
			</div>

			<br />
			<div class="row" ng-show="idCriterio!=null">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<form class="form-inline" ng-submit="agregarPregunta(pregunta)">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Pregunta"
										style="width: 350px" ng-model="pregunta.descripcion" required>
								</div>

								<button type="submit" class="btn btn-primary"
									aria-label="Left Align" value="Agregar">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
									Agregar
								</button>
								<!-- 								<input type="submit" value="Agregar" class="btn btn-primary"> -->
							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="row" ng-show="idCriterio!=null">
				<div class="col-md-12">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th><input type="checkbox" ng-model="selectedAll"
									ng-click="checkAll()" /></th>
								<th hidden="true">idCriterio</th>
								<th hidden="true">idPregunta</th>
								<th>Pregunta</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="pregunta in listaPreguntas">
								<td><input type="checkbox" ng-model="pregunta.selected" /></td>
								<td hidden="true">{{pregunta.idCriterio}}</td>
								<td hidden="true">{{pregunta.id}}</td>
								<td>{{pregunta.descripcion}}</td>
							</tr>
						</tbody>
					</table>

					<div class="form-group">

						<button type="button" class="btn btn-danger pull-right"
							value="Remove" ng-click="remove()">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							Eliminar
						</button>
						<!-- 						<input type="button" class="btn btn-danger pull-right" -->
						<!-- 							ng-click="remove()" value="Remove"> -->
					</div>
				</div>
			</div>
		</div>

	</div>

	<script type="text/javascript">
		var app = angular.module("myapp", []);

		app
				.controller(
						"EncuestaController",

						function($scope, $http) {

							$scope.idEncuesta = 1;
							$scope.nombre = "";
							$scope.instrucciones = "";
							$scope.estado = "";
							$scope.idSemestre = "2017-1";
							$scope.listaCriterios = [];
							$scope.listaPreguntas = [];
							$scope.listaPreguntasAux = [];
							$scope.idCriterio = null;

							/******************************************************************************************************/
							$scope.agregarCriterio = function(criterio) {
								$http
										.get(
												'api/guardarCriterio/'
														+ $scope.idEncuesta
														+ "/"
														+ criterio.descripcion
														+ "/"
														+ criterio.ponderacion
														+ "/"
														+ ($scope.listaCriterios.length + 1))
										.then(
												function(response) {
													if (response.data.id != null) {

														$scope.listaCriterios
																.push({
																	'id' : "",
																	'idEncuesta' : $scope.idEncuesta,
																	'descripcion' : criterio.descripcion,
																	'ponderacion' : criterio.ponderacion,
																	'orden' : ($scope.listaCriterios.length + 1)
																});
														$scope.PD = {};

														alert("El criterio se guardó exitosamente");
													} else {
														alert("Ocurrió un problema al intentar guardar el criterio");
													}
												});
							};

							$scope.eliminarCriterio = function() {
															
								$http
										.get(
												'api/eliminarCriterio/'
														+ $scope.idEncuesta
														+ "/"
														+ $scope.idCriterio)
										.then(
												function(response) {
													if (response.data == true) {

														for (i = 0; i < $scope.listaCriterios.length; i++) {
															if ($scope.listaCriterios[i].id == $scope.idCriterio) {

																$scope.listaCriterios.splice( i, 1);
															}
														}

														alert("El criterio se eliminó exitosamente");
													} else {
														alert("Ocurrió un problema al intentar eliminar el criterio");
													}
												});
							};

							$scope.agregarPregunta = function(pregunta) {
								$scope.listaPreguntas
										.push({
											'id' : "",
											'idCriterio' : $scope.idCriterio,
											'descripcion' : pregunta.descripcion,
											'orden' : ($scope.listaCriterios.length + 1)
										});
								$scope.PD = {};
							};

							$scope.remove = function() {
								var newDataList = [];
								$scope.selectedAll = false;
								angular.forEach($scope.listaPreguntas,
										function(selected) {
											if (!selected.selected) {
												newDataList.push(selected);
											}
										});
								$scope.listaPreguntas = newDataList;
							};

							//TRABAJANDO AQUI
							// 							$scope.eliminarCriterio = function(criterio) {
							// 								for (i = 0; i < $scope.listaCriterios.length; i++) {
							// 									if ($scope.listaCriterios[i].id == criterio.id) {

							// 										$scope.listaCriterios.splice(i, 1);
							// 									}
							// 								}
							// 							};

							$scope.checkAll = function() {
								if (!$scope.selectedAll) {
									$scope.selectedAll = true;
								} else {
									$scope.selectedAll = false;
								}

								angular
										.forEach(
												$scope.listaPreguntas,
												function(listaPreguntas) {
													listaPreguntas.selected = $scope.selectedAll;
												});
							};

							$scope.guardarEncuesta = function() {
								$http
										.get(
												'api/guardarEncuesta/'
														+ $scope.nombre + "/"
														+ $scope.instrucciones)
										.then(
												function(response) {
													if (response.data.id != null) {
														$scope.idEncuesta = response.data.id;
														alert("La encuesta se guardó exitosamente");
													} else {
														alert("Ocurrió un problema al intentar guardar  la encuesta");
													}
												});
							};

							$scope.obtenerEncuesta = function() {
								$http
										.get(
												'api/obtenerEncuesta/'
														+ $scope.idEncuesta)
										.then(
												function(response) {
													$scope.encuesta = response.data;
													$scope.listaCriterios = response.data.listaCriterio;
													$scope.listaPreguntasAux = response.data.listaPregunta;
												});
							};

							$scope.obtenerPreguntasPorCriterio = function() {
								$scope.listaPreguntas = [];

								for (i = 0; i < $scope.listaPreguntasAux.length; i++) {
									if ($scope.listaPreguntasAux[i].idCriterio == $scope.idCriterio) {

										$scope.listaPreguntas
												.push({
													'idCriterio' : $scope.listaPreguntasAux[i].idCriterio,
													'id' : $scope.listaPreguntasAux[i].id,
													'descripcion' : $scope.listaPreguntasAux[i].descripcion
												});

									}
								}
							};

							/*PARA PRUEBAS*/
							$scope.obtenerEncuesta();

						});
	</script>

</body>
</html>