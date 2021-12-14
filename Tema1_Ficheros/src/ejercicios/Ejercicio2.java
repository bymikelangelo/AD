package ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
	
		System.out.println("Introduce una ruta específica. ");
		File ruta = new File(teclado.nextLine());
		
		if (ruta.exists() ) {
			String[] archivos = ruta.list();
			System.out.println("Hay " + archivos.length + " archivo/os en " + ruta.getAbsolutePath());
			
			if (ruta.length() != 0) {
				for (int i = 0; i  < archivos.length; i++) {
					System.out.println(archivos[i]);
				}
			}
		}
		else 
			System.out.println("No existe la ruta especificada.");
	}
	
}
