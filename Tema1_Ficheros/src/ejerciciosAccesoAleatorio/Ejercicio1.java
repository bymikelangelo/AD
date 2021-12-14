package ejerciciosAccesoAleatorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import teclado.Teclado;

public class Ejercicio1 {
	
	static Teclado teclado = new Teclado();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader leerEntero = new BufferedReader(new InputStreamReader(System.in));
		RandomAccessFile  archivo;
		try {
			archivo = new RandomAccessFile("ficheros/aleatorio.txt", "rw");
			boolean completado = false;
			do {
				completado = false;
				System.out.println("Escribe un número: ");
				String valor = leerEntero.readLine();
				int valorNumerico = Integer.parseInt(valor);	
				archivo.writeInt(valorNumerico);
				completado = true;
			} while (completado);		
			
		}
		
		catch (NumberFormatException nbe) {
			try {
				archivo = new RandomAccessFile("ficheros/aleatorio.txt", "r");
				long posicion = 0;
				do {
					posicion = teclado.solicitarLong("Escribe posición (divisor de cuatro). Tamaño archivo: " + archivo.length() + ". ") ;
				} while ((posicion % 4 != 0) | (posicion >= archivo.length()));
				archivo.seek(posicion);
				System.out.println("Mostrando: ");
				System.out.println(archivo.readInt());
			}
			
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
