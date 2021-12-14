package ejerciciosAccesoAleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;
import teclado.Teclado;

public class EjercicioClase {
	
	public static void main(String[] args) throws IOException {
		Teclado teclado = new Teclado();
		RandomAccessFile archivo = new RandomAccessFile("ficheros/enteros.dat", "rw");
		System.out.println("Tamaño archivo: " + archivo.length());
		System.out.println("Numero de enteros: " + archivo.length() / 4);
		
		long posicion = teclado.solicitarLong("Introduce posición del archivo deseada. ") * 4;
		if (posicion < archivo.length()) {
			System.out.println("Se ha leido el entero: " + archivo.readInt());
			String respuesta = teclado.solicitarCadena("¿deseas modificarlo? (s/n): ");
			if (respuesta.toLowerCase().equals("s")) {
				archivo.seek(posicion);
				archivo.writeInt(teclado.solicitarEntero("Introduce número. "));
				archivo.seek(posicion);
				System.out.println("Se ha introducido el entero: " + archivo.readInt());
				archivo.close();
			}
			else 
				System.out.println("No se ha modificado el archivo.");
		}
		else 
			System.out.println("posicion errónea.");
	}
}
