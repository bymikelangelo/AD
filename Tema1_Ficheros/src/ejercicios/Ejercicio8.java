package ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio8 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File fichero = new File ("pedidos.txt");
		int c;
		try {
			FileInputStream f = new FileInputStream(fichero);
			
			while ((c = f.read()) != -1) 
				System.out.println((char) c);
			
			f.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("El fichero " + fichero.getAbsolutePath() + " no existe. ");
		}
	}

}
