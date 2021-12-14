package ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import teclado.Teclado;

public class Ejercicio7 {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Teclado teclado = new Teclado();
		
		try {
			FileWriter escritura = new FileWriter("ficheros/ejercicio4.txt", false);
			String frase = teclado.solicitarCadena("Introduce una frase. ");
			while(!frase.equals("fin")) {
				escritura.write(frase + "\r\n");
				frase = teclado.solicitarCadena("Introduce una frase. ");
			}
			escritura.close();
			
			FileReader lectura = new FileReader("ficheros/ejercicio4.txt");
			BufferedReader buffer = new BufferedReader(lectura);
			
			System.out.println("Visualizando ");
			String cadena = buffer.readLine();
			while (cadena != null) {
				System.out.println(cadena);
				cadena = buffer.readLine();
			} ;
			
			lectura.close();
		}
		
		catch (IOException e) {
			System.out.println("No existe el archivo o el directorio");
		}

		
	}

	
}