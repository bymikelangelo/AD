package ejerciciosAccesoAleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.TreeSet;

import teclado.Teclado;

public class Ejercicio2 {

	static File archivo = new File("ficheros/departamentos.dat");
	static Teclado teclado = new Teclado();
	static TreeSet<Departamento> leidosDepartamentos;  //corresponde a la coleccion que almacena los datos leidos del binario
	
	static class Departamento implements Comparable<Departamento>{
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
		
		public Departamento(int numero, String nombre, String localidad) {
			this.numero = numero;
			this.nombre = new StringBuffer(nombre);
			this.nombre.setLength(20);
			this.localidad = new StringBuffer(localidad);
			this.localidad.setLength(20);
			total++;
		}
		
		@Override
		public String toString() {
			return "Departamento [numero=" + numero + ", nombre=" + nombre.toString() + ", localidad=" + localidad.toString() + "]";
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
		public int compareTo(Departamento o) {
			return this.numero - o.numero;
		}
	}
	
	public static TreeSet<Departamento> crearDepartamentos() {
		TreeSet<Departamento> departamentos = new TreeSet<>();
		int numDepartamento = 0;
		int respuesta = 0;
		int tamanyoString = 20;  //el tamaño que tendra cada dato de tipo string en el archivo binario.
		do {
			String nombre = teclado.solicitarCadena("Escribe nombre departamento: ");
			String localidad = teclado.solicitarCadena("Escribe localidad: ");
			Departamento departamento = new Departamento(nombre, localidad);
			if (departamentos.add(departamento))
				System.out.println("departamento creado.");
			else 
				System.out.println("error al crear departamento.");
			respuesta = teclado.solicitarEntero("¿Deseas crear otro departamento?\n 1 - Si. \n 0 - No.");
		} while (respuesta != 0);
		return departamentos;
	}
	
	public static TreeSet<Departamento> leerDepartamentos () throws IOException {
		RandomAccessFile accesoAleatorio = new RandomAccessFile(archivo, "r");
		TreeSet<Departamento> departamentos = new TreeSet<>();
		accesoAleatorio.seek(0);
		int contador = 0;
		for (int i = 0; i < archivo.length(); i++) {
			int numero = accesoAleatorio.readInt();
			i+=4;
			String nombre = "";
			for (int x = 0; x < 20; x++) {
				nombre = nombre + accesoAleatorio.readChar();
				i+=2;
			}
			String localidad = "";
			for (int x = 0; x < 20; x++) {
				localidad = localidad + accesoAleatorio.readChar();
				i+=2;
			}
			System.out.println(i);
			departamentos.add(new Departamento(numero, nombre, localidad));
		}
		return departamentos;
	}
	
	public static String mostrarDepartamento (int numero) {
		Departamento buscadoDepart = null;
		for (Departamento d: leidosDepartamentos) {
			if (numero == d.numero)
				buscadoDepart = d;
		}
		if (buscadoDepart == null)
			return "no existe departamento con ese número.";
		else 
			return buscadoDepart.toString();
	}
	
	public static void main(String[] args) {
		int respuesta = 0;
		do {
			respuesta = teclado.solicitarEntero("Que deseas hacer?\n 1 - Cargar archivo.\n 2 - Sobreescribir.\n 0 - Salir. ");
			
			switch (respuesta) {
			case 0:
				System.out.println("gracias por usar el programa.");
				break;
			case 1:
				try {
					leidosDepartamentos = leerDepartamentos();
					respuesta = teclado.solicitarEnteroPositivo("introduce número de departamento. ");
					System.out.println(mostrarDepartamento(respuesta)); 
					
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (IOException ioe) {
					System.out.println(ioe.getMessage());
				}
				
				break;
			case 2:
				try {
					archivo.delete();
					RandomAccessFile accesoAleatorio = new RandomAccessFile(archivo, "rw");
					//creamos la coleccion con los departamentos
					TreeSet<Departamento> departamentos = crearDepartamentos();
					//introducimos los datos de la coleccion en el archivo binario
					for (Departamento d: departamentos) {
						accesoAleatorio.writeInt(d.numero);
						//sabemos que la varible nombre siempre va a tener 20 caracteres
						for (int i = 0; i < 20; i++) {  
							accesoAleatorio.writeChar(d.nombre.charAt(i));
						}
						//sabemos que la varible localidad siempre va a tener 20 caracteres
						for (int i = 0; i < 20; i++) {  
							accesoAleatorio.writeChar(d.localidad.charAt(i));
						}
					}
					
					//una vez escrita la coleccion en el binario, creamos otra coleccion con los archivos leidos del binario.
					System.out.println("Leyendo archivo...");
					leidosDepartamentos = leerDepartamentos();
					respuesta = teclado.solicitarEnteroPositivo("introduce número de departamento. ");
					System.out.println(mostrarDepartamento(respuesta)); 
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} 
				
				break;
			}
		} while (respuesta != 0);
	}
}
