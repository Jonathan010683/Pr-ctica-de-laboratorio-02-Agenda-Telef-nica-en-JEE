package app.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.daos.TelefonoDAO;
import app.modelos.Telefono;
import app.modelos.Usuario;

/**
 * Servlet implementation class EliminarTelefonoServlet
 */
@WebServlet("/eliminar-telefono")
public class EliminarTelefonoServlet extends HttpServlet {
	
	public EliminarTelefonoServlet() {
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null ) {
			int codigo = Integer.valueOf(id);
			HttpSession sesion = request.getSession();
			Usuario usuario = (Usuario) sesion.getAttribute("usuario");
			for (Telefono telefono: usuario.getTelefonos()) {
				if (telefono.getCodigo() == codigo) {
					try {
						new TelefonoDAO().eliminar(codigo);
						response.sendRedirect("/pruebaPagina02/ver-telefonos");
					} catch (Exception e) {
						request.setAttribute("mensaje", "No se ha podido eliminar el telefono.");
						request.getRequestDispatcher("/ver-telefonos").forward(request, response);
					}
					break;
				}
			}
		} else {
			response.sendRedirect("/pruebaPagina02/ver-telefonos");
		}
	}
}
