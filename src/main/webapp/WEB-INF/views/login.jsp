<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en" ng-app="login">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<link
	href="/encuestadocente/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">

<link href="/encuestadocente/resources/css/signin.css" rel="stylesheet">

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/encuestadocente/resources/js/jquery.js"></script>
<script
	src="/encuestadocente/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="/encuestadocente/resources/angular/angular.min.js"></script>

</head>

<body>

	<div class="container" ng-controller="LoginController">

		<form id="loginForm" class="form-signin" action="poll.htm">
			<h2 class="form-signin-heading">Por favor identifiquese</h2>
			<label for="inputEmail" class="sr-only">Correo electrónico</label> <input
				type="email" id="inputEmail" class="form-control" ng-model="email"
				placeholder="Email address" required="" autofocus=""> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				ng-model="password" placeholder="Password" required="">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Recordar
				</label>
			</div>
			
			<!-- 			<button ng-click="loguear()" class="btn btn-lg btn-primary btn-block" -->
			<!-- 				id="signButton">Identificar</button> -->
			<!-- 			<a href="poll.htm" type="button">sdasd</a> -->

			<input type="hidden" id="idAlumno" name="idAlumno" ng-model="idAlumno">
			<input type="hidden" id="idAdministrativo" name="idAdministrativo" ng-model="idAdministrativo">
				
			<a class="btn btn-lg btn-primary btn-block" ng-click="loguear()"
				href="#" role="button">Identificar</a>

			<script>
				var app = angular.module('login', []);
	
				app.controller('LoginController',
	
				function($scope, $http) {
	
					$scope.email = "";
					$scope.password = "";
	
					$scope.loguear = function() {
						
						if($scope.email.trim().length == 0 || $scope.password.trim().length == 0 ){
							alert("Debe ingresar el email y el password");
						}
	
						$http.get('api/obtenerUsuario/' + $scope.email.trim() + "/" + $scope.password.trim()).then(
								function(response) {
									if (response.data == "" || response.data == null ) {
										alert("El usuario o la contraseña no son correctos");
									}else{
										var usuario = response.data;
										if(usuario.idTipoUsuario == 1){
//  											window.location = "statistics.htm";
											$("#idAdministrativo").val(usuario.idAdministrativo);
											$("#loginForm").attr("action", "statistics.htm");
											$( "#loginForm" ).submit();
											
										}else {
											if(usuario.idTipoUsuario == 2) {

												$("#idAlumno").val(usuario.idAlumno);
												$( "#loginForm" ).submit();

											}
										}
										
									}
	
								});
					}
	
				});
			</script>

		</form>

		

	</div>

</body>



</html>