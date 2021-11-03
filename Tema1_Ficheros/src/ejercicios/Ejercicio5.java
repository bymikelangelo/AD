package ejercicios;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import teclado.Teclado;

public class Ejercicio5 {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Teclado teclado = new Teclado();
		
		try {
			FileWriter escritura = new FileWriter("ficheros/ejercicio4.txt", true);
			String frase = teclado.solicitarCadena("Introduce una frase. ");
			while(!frase.equals("fin")) {
				escritura.write(frase + "\r\n");
				frase = teclado.solicitarCadena("Introduce una frase. ");
			}
			escritura.close();
			
			FileReader lectura = new FileReader("ficheros/ejercicio4.txt");
			System.out.println("Visualizando ");
			int caracterN = lectura.read();
			char caracter;
			String cadena = "";
			while (caracterN != -1) {
				caracter = (char) caracterN;
				cadena = cadena + caracter;
				caracterN = lectura.read();
			} ;
			
			lectura.close();
			System.out.println(cadena);
		}
		
		catch (IOException e) {
			System.out.println("No existe el archivo o el directorio");
		}

		
	}

	
}