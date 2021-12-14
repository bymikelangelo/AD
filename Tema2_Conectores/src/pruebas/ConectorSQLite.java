package pruebas;

import java.sql.*;

public class ConectorSQLite {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC").newInstance();
			Connection conexion = DriverManager.getConnection
					("jdbc:sqlite:/home/mikelangelo/Escritorio/sqlite/restaurante");
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM platos;");
			while (resultado.next()) {
				System.out.println(resultado.getInt(1) +  " " + resultado.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
