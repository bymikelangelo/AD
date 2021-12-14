package ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader archivo = new FileReader("ficheros/prueba.txt");
			BufferedReader lectura = new BufferedReader(archivo);	
			String linea;
			while ((linea = lectura.readLine()) != null) {
				System.out.println(linea);
			}
			lectura.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		};

	}

}
