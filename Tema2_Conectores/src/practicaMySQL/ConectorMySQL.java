package practicaMySQL;

import java.sql.*;

public class ConectorMySQL {
	
	Connection conexion;
	Statement sentencia;
	ResultSet resultado;
	
	public String buscar(int tipoConsulta, String tabla) throws SQLException, InstantiationException, 
	IllegalAccessException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conexion = DriverManager.getConnection
				("jdbc:mysql://192.168.3.88/ejemplo", "ejemplo", "ejemplo");
				
		sentencia = conexion.createStatement();
		switch (tipoConsulta) {
		case 1:
			resultado = sentencia.executeQuery ("SELECT * FROM libros");
			break;
		case 2:
			resultado = sentencia.executeQuery ("SELECT * FROM socios");
			break;
		case 3:
			resultado = sentencia.executeQuery ("SELECT * FROM prestamos");
			break;
		case 4:
			resultado = sentencia.executeQuery ("SELECT * FROM prestamos WHERE fec_inicio <= CURDATE()");
			break;
		case 5:
			resultado = sentencia.executeQuery ("SELECT * FROM prestamos WHERE cod_socio = ("
					+ "SELECT codigo FROM socios WHERE nombre = 'Legolas')");
			break;
		case 6:
			resultado = sentencia.executeQuery ("SELECT * FROM prestamos WHERE fec_fin <= CURDATE() AND devuelto = 0");
			break;
		case 7:
			resultado = sentencia.executeQuery ("SELECT * FROM socios WHERE codigo = ("
					+ "SELECT cod_socio FROM prestamos WHERE fec_fin < CURDATE() AND devuelto = 0)");
			break;
		default:
			return "Opción no válida.";
		}

		String cadena = "";
		switch (tabla) {
		case "libros":
			while (resultado.next()) {
				cadena = cadena + resultado.getInt("codigo") + " * " + resultado.getString("titulo") + 
			resultado.getString("autor") + resultado.getString("editorial") + resultado.getInt("anyo") + 
			resultado.getString("ISBN") + resultado.getInt("numero_ejemplares") + resultado.getInt("numero_paginas") + "\n";;
			}
			break;
		case "socios":
			while (resultado.next()) {
				cadena = cadena + resultado.getInt("codigo") + " * " + resultado.getString("nombre") + 
			resultado.getString("apellidos") + resultado.getDate("fec_nacimiento") + resultado.getString("domicilio") + 
			resultado.getString("telefono") + "\n";;
			}
			break;
		case "prestamos":
			while (resultado.next()) {
				cadena = cadena + resultado.getInt("cod_libro") +  resultado.getInt("cod_socio") + resultado.getDate("fec_inicio") + 
						resultado.getDate("fec_fin") + resultado.getBoolean("devuelto") + "\n";
			}
		}
		
		resultado.close();
		sentencia.close();
		conexion.close();
		
		return cadena;
	}
}


