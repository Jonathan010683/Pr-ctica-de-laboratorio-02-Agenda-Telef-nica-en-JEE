package app.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.daos.UsuarioDAO;
import app.modelos.Telefono;
import app.modelos.Usuario;

@WebServlet("/ver-telefonos")
public class VerTelefonosServlet extends HttpServlet {
	
    public VerTelefonosServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	HttpSession sesion = request.getSession();
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
    	usuario = new UsuarioDAO().buscarPorCedula(usuario.getCedula());
    	sesion.setAttribute("usuario", usuario);
    	response.sendRedirect("/pruebaPagina02/ver-telefonos.jsp");
	}
}
