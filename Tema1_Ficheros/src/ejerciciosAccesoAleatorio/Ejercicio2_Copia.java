package ejerciciosAccesoAleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.TreeSet;

import teclado.Teclado;

public class Ejercicio2_Copia {

	class Departamento implements Comparable{
		
		int numero;
		StringBuffer nombre;
		StringBuffer localidad;
		static int total = 0;
		
		public Departamento(String nombre, String localidad) {
			this.numero = total + 1;
			this.nombre = new StringBuffer(nombre);
			this.nombre.setLength(20);
			this.localidad = new StringBuffer(localidad);
			this.localidad.setLength(20);
			total++;
		}
		
		public int getNumero() {
			return numero;
		}
		public void setNumero(int numero) {
			this.numero = numero;
		}
		public String getNombre() {
			return nombre.toString();
		}
		public void setNombre(String nombre) {
			this.nombre = new StringBuffer(nombre);
			this.nombre.setLength(20);
		}
		public String getLocalidad() {
			return localidad.toString();
		}
		public void setLocalidad(String localidad) {
			this.localidad = new StringBuffer(localidad);
			this.localidad.setLength(20);
		}

		@Override
		public int compareTo(Object o) {
			return 0;
		}

	}
	
	public static void main(String[] args) {
		
		Teclado teclado = new Teclado();
		try {
			RandomAccessFile archivo = new RandomAccessFile("ficheros/departamentos.dat", "rw");
			TreeSet<Departamento> departamentos = new TreeSet<>();
			archivo.seek(0);
			int numDepartamento = 0;
			String respuesta = "";
			int tamanyoString = 20;  //el tamaño que tendra cada dato de tipo string en el archivo binario.
			do {
				numDepartamento++;
				archivo.writeInt(numDepartamento);
				StringBuffer dato = new StringBuffer(teclado.solicitarCadena("Escribe nombre departamento: "));
				dato.setLength(tamanyoString);
				archivo.writeChars(dato.toString());
				dato = new StringBuffer(teclado.solicitarCadena("Escribe localidad: "));
				dato.setLength(tamanyoString);
				archivo.writeChars(dato.toString());
				respuesta = teclado.solicitarCadena("¿Quieres escribir otro departamento? (s/n) ");
			} while (respuesta.toLowerCase().equals("s"));
			
			int entradaUsuario = teclado.solicitarEnteroPositivo("Introduce número de departamento. ");
			// tamaño de cada departamento
			// 4 byte + 20*2 byte + 20*2 byte = 84 bytes
			archivo.seek(0);
			int numDepart = 0;
			String nombreDepart = "";
			String localidadDepart = "";
			for (long i = 0; i <= archivo.length(); i++) {
				 numDepart = archivo.readInt();
				 System.out.println(numDepart);
				if (numDepart == entradaUsuario) {
					for (i = i; i < i + 40; i++) {
						nombreDepart = nombreDepart + archivo.readChar();
					}
					for (i = i; i < i + 40; i++) {
						localidadDepart = localidadDepart + archivo.readChar();
					}
					break;
				}
				i = i + 83;
			}
			
			System.out.println("Número: " + numDepart + " Departamento: " + nombreDepart + " Localidad: " + localidadDepart);
		}
		
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

}
