package ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio2b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
	
		System.out.println("Introduce una ruta específica. ");
		File ruta = new File(teclado.nextLine());
		System.out.println("Introduce la extension del archivo. ");
		String extension = teclado.nextLine();
		
		if (ruta.exists() ) {
			String[] archivos = ruta.list();
			System.out.println("Hay " + archivos.length + " archivo/os en " + ruta.getAbsolutePath());
			
			if (ruta.length() != 0) {
				int contador = 0;
				for (int i = 0; i  < archivos.length; i++) {
					String ext = archivos[i].substring(archivos[i].lastIndexOf(".") + 1);
					if (ext.equals(extension)) {
						contador ++;
						System.out.println(archivos[i]);
					}
				}
				if (contador == 0)
					System.out.println("No existen archivos de tipo " + extension + " en " + ruta.getAbsolutePath());
			}
		}
		else 
			System.out.println("No existe la ruta especificada.");
	}
	
}
