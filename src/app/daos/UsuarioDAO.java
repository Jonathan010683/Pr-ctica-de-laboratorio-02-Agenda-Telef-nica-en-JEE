package app.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import app.modelos.Usuario;

public class UsuarioDAO {

	public UsuarioDAO() {
	}
	
	public void agregar(Usuario usuario) throws Exception {
		String sql = "INSERT INTO usuarios(cedula, nombre, apellido, correo, contrasena) VALUES('" +
					  usuario.getCedula() + "', '" + usuario.getNombre() + "', '" + 
				      usuario.getApellido() + "', '" + usuario.getCorreo() + "', '" +
					  usuario.getContrasena() + "')";
		BaseDatos.ejecutarSentencia(sql);
	}
	
	public Usuario buscarPorCedula(String cedula) {
		Usuario usuario = null;
		String sql1 = "SELECT * FROM usuarios WHERE cedula = '" + cedula + "'";
		try {
			ResultSet resultado = BaseDatos.ejecutarConsulta(sql1);
			if (resultado.next()) {
				TelefonoDAO telefonoDAO = new TelefonoDAO();
				usuario = new Usuario();
				usuario.setCedula(cedula);
				usuario.setNombre(resultado.getString("nombre"));
				usuario.setApellido(resultado.getString("apellido"));
				usuario.setCorreo(resultado.getString("correo"));
				usuario.setContrasena(resultado.getString("contrasena"));
				usuario.setTelefonos(telefonoDAO.listar(cedula));
			}
			resultado.close();
		} catch (SQLException e) {
			System.out.println("ERROR DB: Ha ocurrido un problema al buscar el usuario especificado.");
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario buscarPorCorreo(String correo) {
		Usuario usuario = null;
		String sql1 = "SELECT * FROM usuarios WHERE correo = '" + correo + "'";
		try {
			ResultSet resultado = BaseDatos.ejecutarConsulta(sql1);
			if (resultado.next()) {
				TelefonoDAO telefonoDAO = new TelefonoDAO();
				usuario = new Usuario();
				usuario.setCedula(resultado.getString("cedula"));
				usuario.setNombre(resultado.getString("nombre"));
				usuario.setApellido(resultado.getString("apellido"));
				usuario.setCorreo(correo);
				usuario.setContrasena(resultado.getString("contrasena"));
				usuario.setTelefonos(telefonoDAO.listar(resultado.getString("cedula")));
			}
			
			resultado.close();
			BaseDatos.cerrarConexion();
		} catch (SQLException e) {
			System.out.println("ERROR DB: Ha ocurrido un problema al buscar el usuario especificado.");
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return usuario;
	}
}