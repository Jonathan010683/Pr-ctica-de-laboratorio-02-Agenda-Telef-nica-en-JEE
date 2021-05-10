function mostrarAlerta(mensaje) {
	$('#alerta').text(mensaje);
	$('.alert').show(); 
}

$(document).ready(function() {
	$('#registrar').click(function (event) {
		let contrasena = $('#contrasena').val();
		let contrasenaRepetir = $('#contrasena-repetir').val();
		if (contrasena === contrasenaRepetir) {
			$('form').submit();
		} else {
			mostrarAlerta('Error: Las contraseñas no coinciden.');
		}
	});
})