package repasoAccesoAleatorio;

public class Departamento {
	private int numeroDepart;
	private StringBuffer nombre;
	private StringBuffer localidad;
	private static int TAMAGNO_CAMPO = 20;
	
	public Departamento(int numeroDepart, String nombre, String localidad) {
		this.numeroDepart = numeroDepart;
		this.nombre = new StringBuffer(nombre);
		this.nombre.setLength(TAMAGNO_CAMPO);
		this.localidad = new StringBuffer(localidad);
		this.localidad.setLength(TAMAGNO_CAMPO);
	}

	public int getNumeroDepart() {
		return numeroDepart;
	}

	public void setNumeroDepart(int numeroDepart) {
		this.numeroDepart = numeroDepart;
	}

	public String getNombre() {
		return nombre.toString();
	}

	public void setNombre(String nombre) {
		this.nombre = new StringBuffer(nombre);
		this.nombre.setLength(TAMAGNO_CAMPO);
	}

	public String getLocalidad() {
		return localidad.toString();
	}

	public void setLocalidad(String localidad) {
		this.localidad = new StringBuffer(localidad);
		this.localidad.setLength(TAMAGNO_CAMPO);
	}
	
	public static int getTAMAGNO_CAMPO() {
		return TAMAGNO_CAMPO;
	}

	@Override
	public String toString() {
		return "Departamento [numeroDepart=" + numeroDepart + ", nombre=" + nombre + ", localidad=" + localidad + "]";
	}
	
}
