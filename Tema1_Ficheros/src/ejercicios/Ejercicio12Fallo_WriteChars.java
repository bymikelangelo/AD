package ejercicios;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import teclado.Teclado;

public class Ejercicio12Fallo_WriteChars {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		Teclado teclado = new Teclado();
		int numInt;
		String cadena;
		float numFloat;
		
		FileOutputStream fichEscrit = new FileOutputStream("prueba.txt");
		DataOutputStream escritTipos = new DataOutputStream(fichEscrit);
		
		numInt = teclado.solicitarEntero("Inserta un número entero: ");
		escritTipos.writeInt(numInt);
		
		numFloat = teclado.solicitarRealEnSimplePrecision("Inserta un número con decimales: ");
		escritTipos.writeFloat(numFloat);
		
		cadena = teclado.solicitarCadena("Inserta una cadena: ");
	  	escritTipos.writeChars(cadena);
		
		escritTipos.close();
		
		FileInputStream fichLect = new FileInputStream("prueba.txt");
		DataInputStream lectTipos = new DataInputStream(fichLect);
		
		numInt = lectTipos.readInt();
		numFloat =lectTipos.readFloat();
//		cadena = lectTipos.readLine();  //el método está en deshuso, por lo tanto, utilizamos BufferedReader
		BufferedReader lectTiposBuffer = new BufferedReader(new InputStreamReader(fichLect));
		cadena = lectTiposBuffer.readLine();
		
//		String cadenaSinEspacios = "";
//		for (int i = 0; i < cadena.length(); i++) {
//			if (cadena.charAt(i) == ' ') {
//				break;
//			}	
//			else 
//				cadenaSinEspacios = cadenaSinEspacios + cadena.charAt(i);
//		}
		
//		System.out.println(cadena.length());
//		System.out.println(cadenaSinEspacios.length());
		System.out.println("\nLos datos leídos del ficheros son: \n");
		System.out.println("\t" + numInt + "\t" + numFloat + "\t" + cadena);
		System.out.println("\nfin de la cadena");
	}

}

