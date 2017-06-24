<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="/encuestadocente/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/encuestadocente/resources/css/signin.css" rel="stylesheet">

</head>

<body>

	<div class="container">

		<form class="form-signin">
			<h2 class="form-signin-heading">Por favor identifiquese</h2>
			<label for="inputEmail" class="sr-only">Correo electrónico</label> <input
				type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required="" autofocus=""> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required="">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Recordar
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Identificar</button>
		</form>

	</div>

</body>
</html>