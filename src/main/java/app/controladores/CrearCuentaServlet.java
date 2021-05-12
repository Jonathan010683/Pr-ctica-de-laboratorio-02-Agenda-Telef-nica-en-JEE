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
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	response.sendRedirect("/Practica02/crear-cuenta.jsp");
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "/login.jsp";
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = new Usuario();
			usuario.setCedula(request.getParameter("cedula"));
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setApellido(request.getParameter("apellido"));
			usuario.setCorreo(request.getParameter("correo"));
			usuario.setContrasena(request.getParameter("contrasena"));
			usuarioDAO.agregar(usuario);
			request.setAttribute(
				"mensaje", 
				"Usuario registrado correctamente.\n" +
				"Por favor, inicie sesión."
			);
			request.setAttribute("tipoMensaje", "exito");
		} catch (Exception e) {
			request.setAttribute("mensaje", "Ya existe un usuario registrado\ncon este correo/cedula.");
			request.setAttribute("tipoMensaje", "error");
			url = "/crear-cuenta.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}