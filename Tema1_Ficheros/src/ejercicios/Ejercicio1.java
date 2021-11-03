package ejercicios;

import java.io.File;
import java.io.IOException;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		
		File[] ficheros = new File[4];
		
		File fichero1 = new File("fichero1.txt");
		File fichero2 = new File("fichero2.txt");
		File fichero3 = new File("fichero3.txt");
		File fichero4 = new File("fichero4.txt");
		
//		File[] ficheros2 = new File[4];
//		
//		ficheros2[0] = fichero1;
//		ficheros2[1] = fichero2;
//		
//		for (int i = 0; i < ficheros2.length; i++) {
//			ficheros2[i] = fichero + i;
//		}
		
		int existe = 0;
		int noExiste = 0;
		
		for (int i = 0; i < ficheros.length; i++) {
			ficheros[i] = new File("./ficheros", "fichero" + i + ".txt");
			
			if (ficheros[i].exists()) {
				existe ++;
				
				if (ficheros[i].isFile()) {
					System.out.println("Fichero" + i + " es fichero.");
				}
				else {
					System.out.println("Fichero" + i + " es directorio.");
				}
			}
			else {
				noExiste ++;
			}
		}
		
		System.out.println("Existen: " + existe);
		System.out.println("No existen: " + noExiste);

		System.out.println(ficheros[0].getPath());
		
		File carpeta = new File ("./ficheros");
		
		if (carpeta.mkdir()) 
			System.out.println("Carpeta creada");
		else
			System.out.println("Fallo al crear ruta");
		
		try {
			if (ficheros[0].createNewFile())
				System.out.println("Archivo creado");
			else 
				System.out.println("Fallo al crear fichero");
			
			if (ficheros[0].createNewFile())
				System.out.println("Archivo creado");
			else 
				System.out.println("Fallo al crear fichero");
		}
		catch (IOException e){
			System.out.println("Fallo al crear los ficheros");
		}
		
		File fichero5 = new File("./ficheros/", "fichero5.txt");
		
		try {
			if (fichero5.createNewFile())
				System.out.println("Archivo creado");
			else 
				System.out.println("Fallo");
		}
		catch (IOException e){
			System.out.println("Fallo al crear fichero");
		}

	}

}
