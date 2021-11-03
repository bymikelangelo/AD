package ejercicios;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import teclado.Teclado;

public class Ejercicio3 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		Teclado teclado = new Teclado();
		
		System.out.println("Directorio actual: " + System.getProperty("user.dir"));
		
		String ruta = teclado.solicitarCadena("Introduce la ruta del archivo. ");
		
		File archivo = new File(ruta);
		
		try {
			archivo.createNewFile();
			
			FileWriter escritura = new FileWriter(archivo, true);
			escritura.write(teclado.solicitarCadena("Escribe algo en el fichero. "));
			escritura.close();
			
			FileReader lectura = new FileReader(archivo);
			
			String cadenaCaracteres = "";
			char caracter;
			int numCaracter = lectura.read();
			
			System.out.println("Mostrando datos en el fichero.");
			while (numCaracter != -1) {
				caracter = (char)numCaracter;
				cadenaCaracteres = cadenaCaracteres + caracter;
				numCaracter = lectura.read();
			}
			lectura.close();
			
			System.out.println(cadenaCaracteres);
		}
		
		catch (IOException e) {
			System.out.println("No existe el archivo o el directorio");
		}

	}

}
