package repasoAccesoAleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import teclado.Teclado;

public class Main {

	public static void main(String[] args) {
		
		ConjuntoDepartamentos universidad = new ConjuntoDepartamentos("ficheros/departamentos.dat");
		
		Departamento dep1 = new Departamento(34, "Informatica", "Zaragoza");
		Departamento dep2 = new Departamento(2, "Electronica", "Huesca");
		Departamento dep3 = new Departamento(5, "Matemáticas", "Huesca");
		Departamento dep4 = new Departamento(1, "Electronica", "Zaragoza");
		Departamento dep5 = new Departamento(4, "Ingles", "Teruel");
		
		try {
			universidad.abrir();
			System.out.println(universidad.agnadir(dep1, dep1.getNumeroDepart()));
			System.out.println(universidad.agnadir(dep2, dep2.getNumeroDepart()));
			System.out.println(universidad.agnadir(dep3, dep3.getNumeroDepart()));
			System.out.println(universidad.agnadir(dep4, dep4.getNumeroDepart()));
			System.out.println(universidad.agnadir(dep5, dep5.getNumeroDepart()));
			
			System.out.println(universidad.leer(34));
			System.out.println(universidad.leer(1));
			
			universidad.cerrar();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
