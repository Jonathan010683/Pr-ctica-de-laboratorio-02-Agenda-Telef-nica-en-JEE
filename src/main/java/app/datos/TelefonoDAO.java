package app.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.modelos.Telefono;

public class TelefonoDAO {

	public void agregar(Telefono telefono, String cedulaUsuario) {
		String sql = "INSERT INTO telefonos(numero, tipo, operadora, usuario_cedula) VALUES('" + 
				      telefono.getNumero() + "', '" + telefono.getTipo() + "', '" +
				      telefono.getOperadora() + "', '" + cedulaUsuario + "');";
		BaseDatos.ejecutarSentencia(sql);
	}
	
	public void modificar(Telefono telefono) {
		String sql = "UPDATE telefonos SET " +
					 "numero = '" + telefono.getNumero() + "'," +
					 "tipo = '" + telefono.getTipo() + "'," + 
					 "operadora = '" + telefono.getOperadora() + "' " +
					 "WHERE codigo = " + telefono.getCodigo() + ";";
		BaseDatos.ejecutarSentencia(sql);
	}
	
	public Telefono buscar(Integer codigo) {
		Telefono telefono = null;
		String sql = "SELECT * from telefonos WHERE codigo = " + codigo + ";";
		ResultSet resultado = BaseDatos.ejecutarConsulta(sql);
		try {
			if (resultado.next()) {
				telefono = new Telefono();
				telefono.setCodigo(resultado.getInt("codigo"));
				telefono.setNumero(resultado.getString("numero"));
				telefono.setTipo(resultado.getString("tipo"));
				telefono.setOperadora(resultado.getString("operadora"));
			}
			resultado.close();
		} catch (SQLException e) {
			System.out.println("ERROR DB: Ocurrió un problema al buscar el telefono especificado.");
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return telefono;
	}

	public void eliminar(Integer codigo) {
		String sql = "DELETE FROM telefonos WHERE codigo = " + codigo + ";";
		BaseDatos.ejecutarSentencia(sql);
	}
	
	public List<Telefono> listar() {
		List<Telefono> telefonos = new ArrayList<>();
		String sql = "SELECT * FROM telefonos;";
		ResultSet resultados = BaseDatos.ejecutarConsulta(sql);
		try {
			while (resultados.next()) {
				Telefono telefono = new Telefono();
				telefono.setCodigo(resultados.getInt("codigo"));
				telefono.setNumero(resultados.getString("numero"));
				telefono.setTipo(resultados.getString("tipo"));
				telefono.setOperadora(resultados.getString("operadora"));
				telefonos.add(telefono);
			}
			resultados.close();
		} catch (SQLException e) {
			System.out.println("ERROR DB: Ocurrió un problema al listar los telefonos.");
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return telefonos;
	}
	
	public List<Telefono> listarConFiltro(String filtro) {
		List<Telefono> telefonos = new ArrayList<>();
		String sql = "SELECT * FROM telefonos WHERE numero = '" + filtro + "'" +
					 "OR usuario_cedula = '" + filtro + "';";
		ResultSet resultados = BaseDatos.ejecutarConsulta(sql);
		try {
			while (resultados.next()) {
				Telefono telefono = new Telefono();
				telefono.setCodigo(resultados.getInt("codigo"));
				telefono.setNumero(resultados.getString("numero"));
				telefono.setTipo(resultados.getString("tipo"));
				telefono.setOperadora(resultados.getString("operadora"));
				telefonos.add(telefono);
			}
			resultados.close();
		} catch (SQLException e) {
			System.out.println("ERROR DB: Ocurrió un problema al listar los telefonos.");
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return telefonos;
	}
}