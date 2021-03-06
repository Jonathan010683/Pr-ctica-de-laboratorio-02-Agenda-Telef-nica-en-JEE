package app.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {

	private static Connection conexion;
	private static Statement sentencia;
	
	private static void abrirConexion() {
		String URL = "jdbc:mysql://localhost:3306/jee";
		String USUARIO = "root";
		String CLAVE = "cuenca";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			conexion.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR DB: No se ha podido cargar el driver.");
			System.out.println(e.getCause());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR DB: No se ha podido establecer la conexión.");
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("ERROR DB: Ha ocurrido un problema al cerrar la conexión.");
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void ejecutarSentencia(String sql) throws Exception {
		try {
			abrirConexion();
			sentencia = conexion.createStatement();
			sentencia.executeUpdate(sql);
			sentencia.close();
			confirmarCambios();
			cerrarConexion();
		} catch (SQLException e) {
			revertirCambios();
			System.out.println("Sentencia SQL: " + sql);
			System.out.println(e.getCause());
			throw new Exception("ERROR DB: No se ha podido ejecutar la sentencia SQL.");
		}
	}
	
	public static ResultSet ejecutarConsulta(String sql) {
		ResultSet resultado = null;
		try {
			abrirConexion();
			sentencia  = conexion.createStatement();
			resultado = sentencia.executeQuery(sql);
			resultado.setFetchDirection(ResultSet.FETCH_FORWARD);
			//sentencia.close();
			//cerrarConexion();
		} catch (SQLException e) {
			System.out.println("ERROR DB: No se ha podido ejecutar la consulta SQL.");
			System.out.println("Consulta SQL: " + sql);
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return resultado;
	}
	
	private static void confirmarCambios() {
		try {
			conexion.commit();
		} catch (SQLException e) {
			System.out.println("ERROR DB: Ha ocurrido un problema al tratar de hacer commit.");
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	private static void revertirCambios() {
		try {
			conexion.rollback();
		} catch (SQLException e) {
			System.out.println("ERROR DB: Ha ocurrido un problema al tratar de hacer rollback.");
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
}
