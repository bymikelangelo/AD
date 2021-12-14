package ejercicios;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejemplo1 {

	public static void main(String[] args) throws IOException{
		Scanner teclado = new Scanner(System.in);
		String cadTechFich, cadFichPant = "";
		int car;
		char cara;
		
		FileWriter fichEsc = new FileWriter("nuevo.txt");
		System.out.print("\nIntroduce una frase: ");
		cadTechFich = teclado.nextLine();
		fichEsc.write(cadTechFich);
		fichEsc.close();
		
		FileReader fichLect = new FileReader("nuevo.txt");
		car = fichLect.read();
		while (car!=-1) {
			cara = (char) car;
			cadFichPant = cadFichPant + cara;
			car = fichLect.read();
		}
		fichLect.close();
		System.out.println("\nLa frase leida del fichero es: \"" + cadFichPant + "\"");
	}
}
