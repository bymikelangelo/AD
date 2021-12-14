package ejercicio1;

public class Coche {
	private int numeroCoche;
	private StringBuffer marca;
	private StringBuffer modelo;
	private static int TAMAGNO_CAMPO = 20;
	
	public Coche(int numeroCoche, String marca, String modelo) {
		this.numeroCoche = numeroCoche;
		this.marca = new StringBuffer(marca);
		this.marca.setLength(TAMAGNO_CAMPO);
		this.modelo = new StringBuffer(modelo);
		this.modelo.setLength(TAMAGNO_CAMPO);
	}

	public int getNumeroCoche() {
		return numeroCoche;
	}

	public String getMarca() {
		return marca.toString();
	}

	public void setMarca(String marca) {
		this.marca = new StringBuffer(marca);
		this.marca.setLength(TAMAGNO_CAMPO);
	}

	public String getModelo() {
		return modelo.toString();
	}

	public void setModelo(String modelo) {
		this.modelo = new StringBuffer(modelo);
		this.modelo.setLength(TAMAGNO_CAMPO);
	}
	
	public static int getTAMAGNO_CAMPO() {
		return TAMAGNO_CAMPO;
	}

	@Override
	public String toString() {
		return "Coche [numeroCoche=" + numeroCoche + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
}