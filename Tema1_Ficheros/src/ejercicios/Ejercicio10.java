package ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader archivo = new FileReader("ficheros/prueba.txt");
			BufferedReader lectura = new BufferedReader(archivo);	
			int caracter;
			TreeMap<Character, Integer> ascii = new TreeMap<>();
			while ((caracter = lectura.read()) != -1) {
				if (ascii.containsKey((char)caracter)) {
					ascii.put((char)caracter, ascii.get((char)caracter) + 1);
				}
				else 
					ascii.put((char)caracter, 1);
			}
			lectura.close();
			
			for (Character c: ascii.keySet()) {
				System.out.println("char = " + (int) c + ", nº veces = " + ascii.get(c));
			}
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		};

	}

}
