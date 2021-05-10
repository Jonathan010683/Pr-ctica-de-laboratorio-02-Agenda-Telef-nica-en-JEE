package app.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.daos.UsuarioDAO;
import app.modelos.Usuario;

/**
 * Servlet implementation class CrearCuentaServlet
 */
@WebServlet("/crear-cuenta")
public class CrearCuentaServlet extends HttpServlet {
	   
    public CrearCuentaServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setCedula(request.getParameter("cedula"));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setApellido(request.getParameter("apellido"));
		usuario.setCorreo(request.getParameter("correo"));
		usuario.setContrasena(request.getParameter("contrasena"));
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.agregar(usuario);
		response.sendRedirect("/Practica02/index.html");
	}
}