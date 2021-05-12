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
</head>
<body class="container-fluid fondo">
	<div class="row">
		<div class="col">
			<div class="row banner">
				<div class="col my-3">
					<a class="btn btn-light float-right" style="width: 15%;"
						href="index.html">Página principal</a>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col">
					<c:set var="telefonos" scope="session" value="${telefonosEncontrados}"/>
					<h1 class="text-center text-light my-3">Teléfonos encontrados</h1>
					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th class="text-center" scope="col">Número</th>
								<th class="text-center" scope="col">Tipo</th>
								<th class="text-center" scope="col">Operadora</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="telefono" items="${telefonos}">
								<tr>
									<td class="text-light text-center">${telefono.numero}</td>
									<td class="text-light text-center">${telefono.tipo}</td>
									<td class="text-light text-center">${telefono.operadora}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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
</body>
</html>