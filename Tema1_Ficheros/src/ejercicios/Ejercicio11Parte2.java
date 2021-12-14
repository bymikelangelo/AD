package ejercicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import teclado.Teclado;

public class Ejercicio11Parte2 {
	
	public static void escribir(FileOutputStream archivo) throws IOException{
		Teclado teclado = new Teclado();
		String cadena = teclado.solicitarCadena("Introduce una frase: ");
		for (int pos = 0; pos < cadena.length(); pos++) {
			archivo.write(cadena.charAt(pos));
		}
		archivo.write('\n');  //para separar las frases
	}
	
	public static String leer(FileInputStream archivo) throws IOException{
		String cadena = "";
		int car;
		char cara;
		car = archivo.read();
		while (car != -1) {
			cara = (char) car;
			cadena = cadena + cara;;
			car = archivo.read();
		}
		return cadena;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String cadena;

		try {
			FileOutputStream f1 = new FileOutputStream("ficheros/hola.txt");
			System.out.println("\nEscribiendo en el primer fichero");
			escribir(f1);
			f1.close();
			
			FileOutputStream f3 = new FileOutputStream("ficheros/hola2.txt");
			System.out.println("\nEscribiendo en el segundo fichero");
			escribir(f3);
			f3.close();
			
			FileInputStream f2 = new FileInputStream("ficheros/hola.txt");
			System.out.println("\nEl contenido del primer fichero es: ");
			String contenidoF2 = leer(f2);
			System.out.println(contenidoF2);
			f2.close();
			
			FileInputStream f4 = new FileInputStream("ficheros/hola2.txt");
			System.out.println("\nEl contenido del segundo fichero es: ");
			String contenidoF4 = leer(f4);
			System.out.println(contenidoF4);
			f4.close();
			
			if (contenidoF2.equals(contenidoF4)) 
				System.out.println("Son iguales");
			else
				System.out.println("No son iguales");
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		
	}

}
