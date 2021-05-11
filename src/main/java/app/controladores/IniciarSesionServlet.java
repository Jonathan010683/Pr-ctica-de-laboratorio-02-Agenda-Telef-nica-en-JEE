package app.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.daos.UsuarioDAO;
import app.modelos.Usuario;

@WebServlet("/iniciar-sesion")
public class IniciarSesionServlet extends HttpServlet {
	
	public IniciarSesionServlet() {
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (request.getSession().getAttribute("usuario") != null) {
			response.sendRedirect("/Practica02/ver-telefonos");
		} else {
			response.sendRedirect("/Practica02/login.html");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		Usuario usuario = new UsuarioDAO().buscarPorCorreo(correo);
		if (usuario != null) {
			if (usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)) {
				sesion.setAttribute("usuario", usuario);
				response.sendRedirect("/Practica02/ver-telefonos");
			} else {
				sesion.setAttribute("usuario", null);
				System.out.println("ERROR: La clave es incorrecta");
				response.sendRedirect("/Practica02/login.html");
			}
		} else {
			sesion.setAttribute("usuario", null);
			System.out.println("ERROR: El usuario no existe");
			response.sendRedirect("/Practica02/login.html");
		}
	}
}
