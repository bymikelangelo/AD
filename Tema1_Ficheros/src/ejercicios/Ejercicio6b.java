package ejercicios;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import teclado.Teclado;

public class Ejercicio6b {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Teclado teclado = new Teclado();
		
		System.out.println("Directorio actual: " + System.getProperty("user.dir"));
		String ruta = teclado.solicitarCadena("Introduce ruta del archivo. ");
		try {
			FileReader lectura = new FileReader(ruta);
			int caracterN = lectura.read();
			char caracter;
			String cadena = "";
			while (caracterN != -1) {
				caracter = (char) caracterN;
				cadena = cadena + caracter;
				caracterN = lectura.read();
			} ;
			
			lectura.close();
			
			FileWriter escritura = new FileWriter(ruta + "Copia", false);
			escritura.write(cadena);
			escritura.close();
			System.out.println("Copia creada");
		}
		
		catch (IOException e) {
			System.out.println("No existe el archivo o el directorio");
		}

		
	}

	
}