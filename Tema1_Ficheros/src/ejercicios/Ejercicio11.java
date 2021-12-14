package ejercicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import teclado.Teclado;

public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Teclado teclado = new Teclado();
		
		String cadena;
		int car;
		char cara;
		
		try {
			FileOutputStream f1 = new FileOutputStream("ficheros/hola.txt");
			cadena = teclado.solicitarCadena("\nIntroduce una frase: ");
			for (int pos = 0; pos < cadena.length(); pos++) {
				f1.write(cadena.charAt(pos));
			}
			//f1.write('\n');  //para separar las frases
			f1.close();
			
			System.out.println("\nEl contenido del fichero es: ");;
			
			FileInputStream f2 = new FileInputStream("ficheros/hola.txt");
			System.out.println("Carácteres disponibles: " + f2.available());  //cuenta los bytes disponibles para lectura en el archivo.
			car = f2.read();
			while (car != -1) {
				cara = (char) car;
				System.out.println(cara);
				car = f2.read();
			}
			
			f2.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		
	}

}
