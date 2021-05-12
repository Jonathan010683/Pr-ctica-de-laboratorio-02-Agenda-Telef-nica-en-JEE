package app.controladores;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.daos.TelefonoDAO;
import app.modelos.Telefono;
import app.modelos.Usuario;

@WebServlet("/modificar-telefono")
public class ModificarTelefonoServlet extends HttpServlet {
	
	public ModificarTelefonoServlet() {
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
					sesion.setAttribute("telefonoModificar", telefono);
					response.sendRedirect("/Practica02/modificar-telefono.jsp");
					break;
				}
			}
		} else {
			response.sendRedirect("/Practica02/ver-telefonos");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			TelefonoDAO telefonoDAO = new TelefonoDAO();
			Telefono telefono = (Telefono) request.getSession().getAttribute("telefonoModificar");
			telefono.setNumero(request.getParameter("numero"));
			telefono.setTipo(request.getParameter("tipo"));
			telefono.setOperadora(request.getParameter("operadora"));
			telefonoDAO.modificar(telefono);;
			request.setAttribute("mensaje", "Telefono modificado correctamente.");
			request.setAttribute("tipoMensaje", "exito");
		} catch (Exception e) {
			request.setAttribute("mensaje", "Otro usuario tiene registrado este número.");
		}
		request.getRequestDispatcher("/modificar-telefono.jsp").forward(request, response);
	}

}
