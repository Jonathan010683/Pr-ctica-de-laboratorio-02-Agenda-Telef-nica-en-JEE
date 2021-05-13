package app.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.daos.TelefonoDAO;
import app.modelos.Telefono;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/buscar-telefonos")
public class BuscarTelefonosServlet extends HttpServlet {
	   
    public BuscarTelefonosServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("/pruebaPagina02/index.html");
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filtro = request.getParameter("filtro");
		List<Telefono> telefonos = new TelefonoDAO().listar(filtro);
		if (telefonos.size() > 0) {
			request.setAttribute("telefonosEncontrados", telefonos);
			request.getRequestDispatcher("/telefonos-usuario.jsp").forward(request, response);
		} else {
			response.sendRedirect("/pruebaPagina02/no-encontrado.html");
		}
	}
}