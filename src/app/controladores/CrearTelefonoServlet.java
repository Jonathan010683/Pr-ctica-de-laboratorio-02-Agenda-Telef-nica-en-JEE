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

@WebServlet("/crear-telefono")
public class CrearTelefonoServlet extends HttpServlet {
	   
    public CrearTelefonoServlet() {
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			TelefonoDAO telefonoDAO = new TelefonoDAO();
			Telefono telefono = new Telefono();
			telefono.setNumero(request.getParameter("numero"));
			telefono.setTipo(request.getParameter("tipo"));
			telefono.setOperadora(request.getParameter("operadora"));
			telefonoDAO.agregar(telefono, usuario.getCedula());
			request.setAttribute("mensaje", "Telefono registrado correctamente.");
			request.setAttribute("tipoMensaje", "exito");
		} catch (Exception e) {
			request.setAttribute("mensaje", "Otro usuario tiene registrado este número.");
			request.setAttribute("tipoMensaje", "error");
		}
		request.getRequestDispatcher("/crear-telefono.jsp").forward(request, response);
	}

}
