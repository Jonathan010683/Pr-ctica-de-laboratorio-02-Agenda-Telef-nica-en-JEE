package app.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cerrar-sesion")
public class CerrarSesionServlet extends HttpServlet {
	  
    public CerrarSesionServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		if (sesion.getAttribute("usuario") != null) {
			sesion.invalidate();
			response.sendRedirect("/Practica02/index.html");
		}
	}
}