package ejercicios;

import java.io.*;
import teclado.Teclado;

public class Ejercicio12 {
	public static void main(String args[]) throws IOException{
		  int numInt;
		  String cadena;
		  float numFloat;
		  Teclado teclado = new Teclado();
		  
		  FileOutputStream fichEscrit = new FileOutputStream("prueba.txt");
		  DataOutputStream escritTipos = new DataOutputStream(fichEscrit);
		  
		  numInt = teclado.solicitarEntero("Inserta un número entero: ");
		  escritTipos.writeInt(numInt);
		  
		  numFloat = teclado.solicitarRealEnSimplePrecision("Inserta un número con decimales: ");
		  escritTipos.writeFloat(numFloat);
		  
		  cadena = teclado.solicitarCadena("Inserta una cadena: ");
//		  escritTipos.writeChars(cadena);
		  for (int pos = 0; pos < cadena.length(); pos++) {
				fichEscrit.write(cadena.charAt(pos));
		  }
		  
		  escritTipos.close();
		  
		  FileInputStream fichLect = new FileInputStream("prueba.txt");
		  DataInputStream lectTipos = new DataInputStream(fichLect);
		  
		  numInt = lectTipos.readInt();
		  numFloat = lectTipos.readFloat();
		  cadena = lectTipos.readLine();
		  
		  System.out.println("\nLos datos leídos del fichero son: \n");
		  System.out.println("\t" + numInt + "\t" + numFloat + "\t" + cadena);
		}

}
