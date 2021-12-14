package repasoAccesoAleatorio;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ConjuntoDepartamentos {
	
	private String ruta;
	private RandomAccessFile fichero;
	private static int TAMAGNO_REGISTRO = 4 + 40 + 40;  // numeroDepart + nombre + localidad
	
	public ConjuntoDepartamentos (String ruta) {
		this.ruta = ruta;
	}
	
	public String getRuta() {
		return ruta;
	}
	
	public void abrir () throws FileNotFoundException {
		this.fichero = new RandomAccessFile(ruta, "rw");
	}
	
	public void cerrar() throws IOException {
		this.fichero.close();
	}
	
	public boolean agnadir(Departamento departamento, int posicion) throws Exception{
		this.fichero.seek(calcularPosicion(posicion));
		fichero.writeInt(departamento.getNumeroDepart());
		fichero.writeChars(departamento.getNombre());
		fichero.writeChars(departamento.getLocalidad());
		return true;
	}
	
	public String leer(int posicion) throws IOException {
		this.fichero.seek(calcularPosicion(posicion));
		int numeroDepart = fichero.readInt();
		String nombre = "";
		for (int i = 0; i < Departamento.getTAMAGNO_CAMPO(); i++) {
			nombre = nombre + fichero.readChar();
			//System.out.println(nombre);
		}
		String localidad = "";
		for (int i = 0; i < Departamento.getTAMAGNO_CAMPO(); i++) {
			localidad = localidad + fichero.readChar();
			//System.out.println(localidad);
		}
		
		Departamento departamento = new Departamento(numeroDepart, nombre, localidad);
		return departamento.toString();
	}
	
	public int calcularPosicion(int posicion) {
		return (posicion - 1) * TAMAGNO_REGISTRO;
	}
	
}
