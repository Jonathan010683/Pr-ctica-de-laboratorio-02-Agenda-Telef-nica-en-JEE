package app.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroSesion
 */
@WebFilter({
	"/ver-telefonos", "/ver-telefonos.jsp",
	"/crear-telefono", "/crear-telefono.jsp",
	"/modificar-telefono", "/modificar-telefono.jsp",
	"/eliminar-telefono",
	"/cerrar-sesion"
})
public class FiltroSesion implements Filter {

    public FiltroSesion() {
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpSession sesion = ((HttpServletRequest) request).getSession();
		if (sesion.getAttribute("usuario") != null)
			chain.doFilter(request, response);
		else {
			((HttpServletResponse) response).sendRedirect("/Practica02/login.jsp");
		}
	}
}