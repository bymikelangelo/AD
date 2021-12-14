package practicaMySQL;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);

		System.out.println("Elige tipo de busqueda: ");
		
		System.out.println("1 - Listado de todos los libros.\n" + 
				"2 - Listado de todos los socios.\n" + "1 - Listado de todos los prestamos.\n" + 
				"4 - Listado de todos los libros prestados actualmente.\n" + "5 - Número de libros prestados a un socio determinado.\n" + 
				"6 - Libros que han superado la fecha de fin de préstamo.\n" +  "7 - Socios que tienen libros que han superado la fecha de fin de préstamo.");
		
		int opcion = teclado.nextInt();
		
		ConectorMySQL conexion = new ConectorMySQL();
		
		try {
			switch (opcion) {
			case 1: conexion.buscar(1, "libros");
				break;
			case 2: conexion.buscar(2, "socios");
			break;
			case 3: conexion.buscar(3, "prestamos");
			break;
			case 4: conexion.buscar(4, "libros");
			break;
			case 5: conexion.buscar(5, "libros");
			break;
			case 6: conexion.buscar(6, "libros");
			break;
			case 7: conexion.buscar(7, "socios");
			break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
