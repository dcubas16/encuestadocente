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

			<h2>
				<strong>Encuesta de Evaluación de Alumnos 2017-2</strong>
			</h2>

			<h3>
				<strong>Datos Generales</strong>
			</h3>

			<div class="form-horizontal">

				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Facultad:</label>
					<div class="col-sm-8">
						<input type="text" ng-model="cabeceraEncuesta.facultadNombre"
							ng-disabled="cabeceraHabilitada" class="form-control"
							id="exampleInputName2" placeholder="">
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Departamento
						Académico:</label>
					<div class="col-sm-8">
						<input type="text" ng-model="cabeceraEncuesta.carreraProfNombre"
							ng-disabled="cabeceraHabilitada" class="form-control"
							id="exampleInputName2" placeholder="">
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Semestre
						Académico:</label>
					<div class="col-sm-8">
						<input type="text" value="2017-1" class="form-control"
							ng-disabled="cabeceraHabilitada" id="exampleInputName2"
							placeholder="">
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Año
						de Estudios:</label>
					<div class="col-sm-8">
						<input type="text" value="2017" class="form-control"
							ng-disabled="cabeceraHabilitada" id="exampleInputName2"
							placeholder="">
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Asignatura:</label>
					<div class="col-sm-8">

						<select ng-model="cursoSeleccionado" class="form-control"
							ng-change="obtenerDocente()"
							ng-options="item.id as item.nombre for item in cursosAlumno">
							<option value="">Seleccione curso</option>
						</select>

					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Código
						del Curso:</label>
					<div class="col-sm-8">
						<input type="text" ng-model="cabeceraEncuesta.cursoId"
							ng-disabled="cabeceraHabilitada" class="form-control"
							id="exampleInputName2" placeholder="">
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputName2" class="col-sm-3 control-label">Nombre
						del Profesor:</label>
					<div class="col-sm-8">
						<input type="text" ng-model="cabeceraEncuesta.docenteNombres"
							ng-disabled="cabeceraHabilitada" class="form-control"
							id="exampleInputName2" placeholder="">
					</div>
				</div>

			</div>

			<script>
				var idAlumno = '${idAlumno}';
				var idEncuesta = '${idEncuesta}';
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

				app
						.controller(
								'CabeceraEncuestaController',
								function($scope, $http) {

									$scope.cabeceraHabilitada = true;

									$http
											.get(
													'api/obtenerCabeceraEncuesta/'
															+ idAlumno)
											.then(
													function(response) {
														$scope.cabeceraEncuesta = response.data;
														$scope.cabeceraEncuesta.docenteNombres = '';
														$scope.cabeceraEncuesta.cursoId = '';
													});

									$http
											.get(
													'api/obtenerCursosPorAlumno/'
															+ idAlumno)
											.then(
													function(response) {
														$scope.cursosAlumno = response.data;
													});

									$scope.obtenerDocente = function() {

										if ($scope.cursoSeleccionado == null) {
											$scope.esEncuestaNueva = false;
											$scope.limpiarEncuesta();
											return;
										}

										for (i = 0; i < $scope.cursosAlumno.length; i++) {
											if ($scope.cursosAlumno[i].id == $scope.cursoSeleccionado) {
												$scope.cabeceraEncuesta.docenteNombres = $scope.cursosAlumno[i].docenteNombres;
												$scope.cabeceraEncuesta.cursoId = $scope.cursosAlumno[i].id;
												$scope.cabeceraEncuesta.idAlumnoGrupo = $scope.cursosAlumno[i].idAlumnoGrupo;
											}
										}

										$http
												.get(
														'api/obtenerEncuesta/'
																+ idEncuesta)
												.then(
														function(response) {
															$scope.encuesta = response.data;
														});
									}

									$scope
											.$on(
													'ngRepeatFinished',
													function(
															ngRepeatFinishedEvent) {
														$http
																.get(
																		'api/obtenerEncuestaAlumnoGrupo/'
																				+ $scope.cabeceraEncuesta.idAlumnoGrupo
																				+ "/"
																				+ idEncuesta)
																.then(
																		function(
																				response) {
																			$scope.listaDetallePreguntaAlumnoGrupo = response.data;

																			for (i = 0; i < $scope.listaDetallePreguntaAlumnoGrupo.length; i++) {

																				$(
																						'input[name='
																								+ $scope.listaDetallePreguntaAlumnoGrupo[i].idPregunta
																								+ '][value='
																								+ $scope.listaDetallePreguntaAlumnoGrupo[i].valor
																								+ ']')
																						.prop(
																								'checked',
																								true);
																				$(
																						'input[name='
																								+ $scope.listaDetallePreguntaAlumnoGrupo[i].idPregunta
																								+ '][value='
																								+ $scope.listaDetallePreguntaAlumnoGrupo[i].valor
																								+ ']')
																						.parent()
																						.addClass(
																								"active");
																			}

																			if ($scope.listaDetallePreguntaAlumnoGrupo.length == 0) {
																				$scope.esEncuestaNueva = true;
																			} else {
																				$scope.esEncuestaNueva = false;
																			}
																		});
													});

									$scope.limpiarEncuesta = function() {
										$scope.cabeceraEncuesta.docenteNombres = "";
										$scope.cabeceraEncuesta.cursoId = "";
										$scope.cabeceraEncuesta.idAlumnoGrupo = "";

										$scope.listaDetallePreguntaAlumnoGrupo = null;
										$scope.encuesta = null;
										$scope.arregloCriterioPregunta = [];

									}

									var objetoEncuesta = {
										idPregunta : 0,
										idAlumnoGrupo : 0,
										valor : 0
									};

									$scope.arregloCriterioPregunta = [];

									$scope.guardarEncuesta = function() {
										
										$scope.arregloCriterioPregunta = [];

										if (!$scope.esEncuestaNueva) {
											return;
										}

										if ($scope.cabeceraEncuesta.cursoId == "") {
											alert("Debe seleccionar el curso");
											return;
										}

										var arregloEncuesta = $('input[class=criterioPregunta]:checked');
										
 										for (var i = 0; i < arregloEncuesta.length; i++) {

											objetoEncuesta = new Object();

											objetoEncuesta.idPregunta = arregloEncuesta[i].name;
											objetoEncuesta.idAlumnoGrupo = $scope.cabeceraEncuesta.idAlumnoGrupo;
											objetoEncuesta.valor = arregloEncuesta[i].value;

											$scope.arregloCriterioPregunta
													.push(objetoEncuesta);
										}

										if (arregloEncuesta.length < ($('input[class=criterioPregunta]').length / 5)) {
											alert("Se tiene que completar la encuesta para ser guardada");
										} else {

											var jsonListaDetalle = JSON
													.stringify($scope.arregloCriterioPregunta);

											$http
													.post(
															'api/guardarEncuesta',
															jsonListaDetalle)
													.then(
															function(response) {
																if (response.data.esExito) {
																	alert("La encuesta se guardó con éxito");
																	$scope.esEncuestaNueva = false;
																} else {
																	alert("Ocurrió el siguiente error: "
																			+ response.mensaje);
																	$scope.esEncuestaNueva = false;
																}
															});
										}

									};

								});
			</script>

			<br>
			<h3>
				<strong>Instrucciones</strong>
			</h3>
			<p>{{encuesta.instruccion}}</p>

			<br>

			<h3>
				<strong>Tabla de Calificaciones</strong>
			</h3>

			<div class="container">

				<div class="row">
					<div class="col-md-8" align="center">
						<h4>
							<strong>CRITERIOS</strong>
						</h4>
					</div>
					<div class="col-md-4" align="center">
						<h4>
							<strong>PUNTAJE TOTAL 13</strong>
						</h4>
					</div>
				</div>

				<input name="esModificacion" id="esModificacion" hidden="true">

				<div class="row" ng-repeat="criterio in encuesta.listaCriterio"
					on-finish-render="ngRepeatFinished">
					<div class="col-md-8" align="center">
						<h4>
							<strong style="text-transform: capitalize;">{{criterio.descripcion}}</strong>
						</h4>
					</div>
					<div class="col-md-4" align="center">
						<h4>
							<strong>Ponderación( {{criterio.ponderacion}} )</strong>
						</h4>
					</div>

					<div class="row" ng-repeat="pregunta in encuesta.listaPregunta">

						<div ng-if="pregunta.idCriterio == criterio.id">
							<br>
							<div class="col-md-8">{{pregunta.orden}}.
								{{pregunta.descripcion}}</div>
							<div class="col-md-4" align="center">
								<div class="btn-group btn-group-justified" data-toggle="buttons">
									<label class="btn btn-primary" ng-disabled="!esEncuestaNueva"><input
										type="radio" value="1" class="criterioPregunta"
										ng-attr-name="{{ pregunta.id}}"
										ng-attr-id="{{ 'c' + criterio.id + 'p' + pregunta.id}}"
										ng-disabled="!esEncuestaNueva" autocomplete="off">1 </label> <label
										class="btn btn-primary" ng-disabled="!esEncuestaNueva">
										<input type="radio" value="2" class="criterioPregunta"
										ng-attr-name="{{ pregunta.id}}"
										ng-attr-id="{{ 'c' + criterio.id + 'p' + pregunta.id}}"
										autocomplete="off">2
									</label> <label class="btn btn-primary" ng-disabled="!esEncuestaNueva">
										<input type="radio" value="3" class="criterioPregunta"
										ng-attr-name="{{ pregunta.id}}"
										ng-attr-id="{{ 'c' + criterio.id + 'p' + pregunta.id}}"
										autocomplete="off">3
									</label> <label class="btn btn-primary" ng-disabled="!esEncuestaNueva">
										<input type="radio" value="4" class="criterioPregunta"
										ng-attr-name="{{ pregunta.id}}"
										ng-attr-id="{{ 'c' + criterio.id + 'p' + pregunta.id}}"
										autocomplete="off">4
									</label> <label class="btn btn-primary" ng-disabled="!esEncuestaNueva">
										<input type="radio" value="5" class="criterioPregunta"
										ng-attr-name="{{ pregunta.id}}"
										ng-attr-id="{{ 'c' + criterio.id + 'p' + pregunta.id}}"
										autocomplete="off">5
									</label>
								</div>
							</div>
						</div>
					</div>

					<br>
				</div>

				<a class="btn btn-success" ng-click="guardarEncuesta()" href="#"
					ng-disabled="!esEncuestaNueva" role="button">Guardar</a>

			</div>
		</div>
</body>
</html>