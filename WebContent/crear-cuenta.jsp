<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Práctica02</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
		integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" 
		crossorigin="anonymous">
	<link rel="stylesheet" href="recursos/css/extra.css">
</head>
<body class="container-fluid fondo">
	<div class="row">
		<div class="col">
			<div class="row banner">
				<div class="col my-3">
					<a class="btn btn-light mx-auto float-right" style="width: 15%;"
						href="index.html">Página principal</a>
				</div>
			</div>
			<c:set var="mensaje" scope="request" value="${mensaje}"/>
			<c:set var="tipoMensaje" scope="request" value="${tipoMensaje}"/>
			<form class="container form-group" action="/pruebaPagina02/crear-cuenta" method="post">
				<div class="alert alert-danger alert-dismissible collapse w-25 mt-3 mx-auto" role="alert">
  					<label id="alerta"></label>
  					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    					<span aria-hidden="true">&times;</span>
  					</button>
				</div>	
				<c:if test="${tipoMensaje == 'error'}">
					<div class="alert alert-danger alert-dismissible w-25 mt-3 mx-auto" 
						role="alert">
  						<label>${mensaje}</label>
  						<button type="button" class="close" data-dismiss="alert" 
  							aria-label="Close">
    						<span aria-hidden="true">&times;</span>
  						</button>
					</div>
				</c:if>
				<h3 class="text-light text-center mt-3">Nueva cuenta</h3>
				<input class="form-control text-center mt-3 mx-auto w-25"
                	type="text" name="cedula" placeholder="Cédula"
               		maxlength="10" onkeypress="return esNumero(event)" required>
                <input class="form-control text-center mt-2 mx-auto w-25"
                    type="text" maxlength="50" name="nombre" 
                    placeholder="Nombre" required>
                <input class="form-control text-center mt-2 mx-auto w-25"
                    type="text" maxlength="50" name="apellido" 
                    placeholder="Apellido" required>
                <input class="form-control text-center mt-2 mx-auto w-25"
                    type="email" maxlength="50" name="correo" 
                    placeholder="Correo electrónico" required>
                <input class="form-control text-center mt-2 mx-auto w-25" id="contrasena"
                    type="password" maxlength="50" name="contrasena" 
                    placeholder="Contraseña" required>
                <input class="form-control text-center mt-2 mx-auto w-25" id="contrasena-repetir"
                    type="password" maxlength="50" name="contrasena-repetida" 
                    placeholder="Repetir Contraseña" required>
                <button class="form-control text-center btn-primary mx-auto mt-3 mb-5"
                    id="registrar" style="width:20%" type="button">Registrar
                </button>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" 
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" 
		crossorigin="anonymous">
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" 
		crossorigin="anonymous">
	</script>
	<script type="text/javascript" src="recursos/js/extra.js">
	</script>
	<script type="text/javascript" src="recursos/js/crear-cuenta.js">
	</script>
</body>
</html>