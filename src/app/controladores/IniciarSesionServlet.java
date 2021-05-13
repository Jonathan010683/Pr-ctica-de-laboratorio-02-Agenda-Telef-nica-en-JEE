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
			response.sendRedirect("/pruebaPagina02/ver-telefonos");
		} else {
			response.sendRedirect("/pruebaPagina02/login.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		Usuario usuario = new UsuarioDAO().buscarPorCorreo(correo);
		if (usuario != null) {
			if (usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)) {
				sesion.setAttribute("usuario", usuario);
				response.sendRedirect("/pruebaPagina02/ver-telefonos");
				return;
			} else {
				sesion.setAttribute("usuario", null);
				request.setAttribute("mensaje", "La clave es incorrecta.");
				request.setAttribute("tipoMensaje", "error");
			}
		} else {
			sesion.setAttribute("usuario", null);
			request.setAttribute("mensaje", "No existe ningún usuario con este correo.");
			request.setAttribute("tipoMensaje", "error");
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
