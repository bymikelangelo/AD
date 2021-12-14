package ejercicio1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
	
	private static RandomAccessFile fichero;
	private static int TAMAGNO_REGISTRO = 4 + 40 + 40;

	public static void main(String[] args) {
		
		Coche coche1 = new Coche(1, "BMW", "Serie 1");
		Coche coche2 = new Coche(23, "Mercedes Benz", "Clase C");
		Coche coche3 = new Coche(4, "Porsche", "911 Carrera");
		Coche coche4 = new Coche(7, "BMW", "M3");
		Coche coche5 = new Coche(9, "BMW", "i8");
		
		try {
			fichero = new RandomAccessFile("coches.dat", "rw");
			System.out.println(agnadir(coche1, coche1.getNumeroCoche()));
			System.out.println(agnadir(coche2, coche2.getNumeroCoche()));
			System.out.println(agnadir(coche3, coche3.getNumeroCoche()));
			System.out.println(agnadir(coche4, coche4.getNumeroCoche()));
			System.out.println(agnadir(coche5, coche5.getNumeroCoche()));
			
			//la posicion del coche la marca el numero del coche 
			System.out.println(leer(1));
			System.out.println(leer(23));
			System.out.println(leer(4));
			System.out.println(leer(7));
			System.out.println(leer(9));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean agnadir(Coche coche, int posicion) throws Exception{
		fichero.seek(calcularPosicion(posicion));
		fichero.writeInt(coche.getNumeroCoche());
		fichero.writeChars(coche.getMarca());
		fichero.writeChars(coche.getModelo());
		return true;
	}
	
	public static String leer(int posicion) throws IOException {
		fichero.seek(calcularPosicion(posicion));
		int numeroCoche = fichero.readInt();
		String marca = "";
		for (int i = 0; i < Coche.getTAMAGNO_CAMPO(); i++) {
			marca = marca + fichero.readChar();
			//System.out.println(nombre);
		}
		String modelo = "";
		for (int i = 0; i < Coche.getTAMAGNO_CAMPO(); i++) {
			modelo = modelo + fichero.readChar();
			//System.out.println(localidad);
		}
		
		Coche coche = new Coche(numeroCoche, marca, modelo);
		return coche.toString();
	}
	
	public static int calcularPosicion(int posicion) {
		return (posicion - 1) * TAMAGNO_REGISTRO;
	}

}
