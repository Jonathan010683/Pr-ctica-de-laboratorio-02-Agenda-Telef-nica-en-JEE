<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Práctica02</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
		integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" 
		crossorigin="anonymous">
	<link rel="stylesheet" href="recursos/css/extra.css">
<body class="container-fluid fondo">
	<div class="row">
		<div class="col">
			<div class="row banner">
				<div class="col my-3">
					<a class="btn btn-primary ml-2 float-right" style="width: 15%;"
						href="/pruebaPagina02/cerrar-sesion">Cerrar sesión</a>
					<a class="btn btn-light float-right" style="width: 15%;"
						href="/pruebaPagina02/ver-telefonos">Perfil</a>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col">
					<c:set var="telefono" scope="session" value="${telefonoModificar}"/>
					<c:set var="mensaje" scope="request" value="${mensaje}"/>
					<c:set var="tipoMensaje" scope="request" value="${tipoMensaje}"/>
					<h1 class="text-center text-light my-3">Modificar teléfono</h1>
					<form class="form-group" action="/pruebaPagina02/modificar-telefono" method="post">
						<c:choose>
							<c:when test="${tipoMensaje == 'exito'}">
								<div class="alert alert-success alert-dismissible w-25 mt-3 mx-auto" 
									role="alert">
  									<label id="alerta">${mensaje}</label>
  									<button type="button" class="close" data-dismiss="alert" 
  										aria-label="Close">
    									<span aria-hidden="true">&times;</span>
  									</button>
								</div>
							</c:when>
							<c:when test="${tipoMensaje == 'error'}">
								<div class="alert alert-danger alert-dismissible w-25 mt-3 mx-auto" 
									role="alert">
  									<label id="alerta">${mensaje}</label>
  									<button type="button" class="close" data-dismiss="alert" 
  										aria-label="Close">
    									<span aria-hidden="true">&times;</span>
  									</button>
								</div>
							</c:when>
						</c:choose>
						<input class="form-control text-center mt-3 mx-auto w-25"
                			type="text" name="numero" placeholder="Número"
               				maxlength="20" onkeypress="return esNumero(event)" 
               				value="${telefono.numero}" required>
               			<input class="form-control text-center mt-2 mx-auto w-25"
                    		type="text" maxlength="20" name="tipo" 
                    		placeholder="Tipo" value="${telefono.tipo}" required>
                    	<input class="form-control text-center mt-2 mx-auto w-25"
                    		type="text" maxlength="20" name="operadora" 
                    		placeholder="Operadora" value="${telefono.operadora}" required>
                    	<input class="form-control text-center btn-primary mx-auto mt-3 mb-5"
                    		style="width:20%" type="submit" value="Guardar">
					</form>
				</div>
			</div>
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
</body>
</html>