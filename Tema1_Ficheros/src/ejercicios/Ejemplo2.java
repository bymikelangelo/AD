package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo2 {

	public static void main(String[] args) throws IOException{
		String cadena;
		File fich = new File("fichero.txt");
		BufferedReader flujo = new BufferedReader(new FileReader(fich));
		if (fich.exists()){
			System.out.println("\nEsta es la información que contiene el fichero: ");
			cadena = flujo.readLine();
			while (cadena != null){
				System.out.println(cadena);
				cadena = flujo.readLine();
			}
		}
	}
}
