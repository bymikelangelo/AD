package pruebas;

import java.sql.*;

public class ConectorMySQL {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = DriverManager.getConnection
<<<<<<< HEAD
					("jdbc:mysql://192.168.3.88/biblioteca", "admin", "admin");
			
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery
					("SELECT * from libros");
=======
					("jdbc:mysql://192.168.3.88/ejemplo", "ejemplo", "ejemplo");
			
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery
					("SELECT * from departamento");
>>>>>>> refs/remotes/origin/master
			
			while (resultado.next()) {
				System.out.println(resultado.getInt(1) + " * " + resultado.getInt(2) + " * " + resultado.getInt(3));;
			}
			
			resultado.close();
			sentencia.close();
			conexion.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
