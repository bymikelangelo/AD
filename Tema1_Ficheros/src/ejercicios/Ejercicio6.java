package ejercicios;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import teclado.Teclado;

public class Ejercicio6 {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Teclado teclado = new Teclado();
		
		try {
			FileReader lectura = new FileReader("ficheros/ejercicio4.txt");
			int caracterN = lectura.read();
			char caracter;
			String cadena = "";
			while (caracterN != -1) {
				caracter = (char) caracterN;
				cadena = cadena + caracter;
				caracterN = lectura.read();
			} ;
			
			lectura.close();
			
			FileWriter escritura = new FileWriter("ficheros/copiaEjercicio4.txt", false);
			escritura.write(cadena);
			escritura.close();
			System.out.println("Copia creada");
		}
		
		catch (IOException e) {
			System.out.println("No existe el archivo o el directorio");
		}

		
	}

	
}