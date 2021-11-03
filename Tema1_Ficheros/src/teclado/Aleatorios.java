package teclado;

import java.util.Random;

public class Aleatorios {

	static Random random = new Random();
	
	private String[] titulo = {"Poema de Gilgamesh", "Todo se desmorona", "Cuentos infantiles", "Divina comedia", "Orgullo y prejuicio", "PapÃ¡ Goriot", "Molloy", "DecamerÃ³n", "Ficciones", "Cumbres Borrascosas", 
			"El extranjero", "Poemas", "Viaje al fin de la noche", "Don Quijote de la Mancha", "Los cuentos de Canterbury", "Relatos cortos", "Nostromo", "Grandes Esperanzas", "Jacques el fatalista", "Berlin Alexanderplatz", 
			"Crimen y castigo", "Middlemarch", "El hombre invisible", "Medea", "Â¡Absalom, Absalom!", "Madame Bovary", "Romancero gitano", "Cien aÃ±os de soledad", "Fausto", "Almas muertas",
			"El tambor de hojalata", "Gran SertÃ³n: Veredas", "Hambre", "El viejo y el mar", "IlÃ­ada", "Casa de muÃ±ecas", "Ulises", "El proceso", "Shakuntala", "El sonido de la montaÃ±a",
			"Zorba, el griego", "Hijos y amantes", "Gente independiente", "El cuaderno dorado", "Pippi Calzaslargas", "Diario de un loco", "Hijos de nuestro barrio", "Los Buddenbrook", "Moby-Dick", "El SeÃ±or de los Anillos"};
			
	private String[] autor = {"AnÃ³nimo", "Chinua Achebe", "Hans Christian Andersen", "Dante Alighieri", "Jane Austen", "HonorÃ© de Balzac", "Samuel Beckett Nobel", "Giovanni Boccaccio", "Jorge Luis Borges", "Emily BrontÃ«",
			"Albert Camus", "Paul Celan", "Louis-Ferdinand CÃ©line", "Miguel de Cervantes", "Geoffrey Chaucer", "AntÃ³n ChÃ©jov", "Joseph Conrad", "Charles Dickens", "Denis Diderot", "Alfred DÃ¶blin",
			"FiÃ³dor Dostoievski", "George Eliot", "Ralph Ellison", "EurÃ­pides", "William Faulkner", "Gustave Flaubert", "Federico GarcÃ­a Lorca", "Gabriel GarcÃ­a MÃ¡rquez", "Johann Wolfgang von Goethe", "Nikolai Gogol",
			"GÃ¼nter Grass", "JoÃ£o GuimarÃ£es Rosa", "Knut Hamsun", "Ernest Hemingway", "Homero", "Henrik Ibsen", "James Joyce", "Franz Kafka", "KÄ�lidÄ�sa", "Yasunari Kawabata",
			"Nikos Kazantzakis", "D. H. Lawrence", "HalldÃ³r Laxness", "Doris Lessing", "Astrid Lindgren", "Lu Xun", "Naguib Mahfuz", "Thomas Mann", "Herman Melville", "J. R. R. Tolkien"};
	
	private String[] nombre = {"Alex", "Yasser", "Andrea", "David", "IvÃ¡n", "Paloma", "Julio", "InÃ©s", "Emma", "Pilar",
			"Marta", "MarÃ­a", "Antonio", "Estaban", "Daniel", "Jorge", "Iulen", "Raquel", "TomÃ¡s", "Matias",
			"Guillermo", "Miguel", "Will", "CÃ©sar", "Marcos", "VerÃ³nica", "Frodo", "Gandalf", "Aragorn", "Luigi",
			"Richard", "Michael", "Matteo", "Laura", "Yuna", "Auron", "Titus", "Cloud", "RamÃ³n", "Juan",
			"Bilbo", "Axl", "Steven", "Mario", "Leonardo", "Cloud", "Lionel", "Diego", "Mikel", "Miguel Ã�ngel"};
	
	private String[] apellido = {"Jaso", "BolsÃ³n", "GarcÃ­a", "Lobera", "Marquez", "Picasso", "Perez", "Smith", "Pedroche", "Arcas",
			"MillÃ¡n", "Amati", "EchÃ¡varri", "Prats", "TomÃ¡s", "Casco", "Rivas", "Castillo", "Huszak", "Siles",
			"Atiencia", "Pedraza", "Fiordean", "Bargas", "Llosa", "Romero", "RodrÃ­guez", "Torres", "Ronaldo", "Messi",
			"Flores", "Rose", "Slash", "Scott", "Oliver", "Cameron", "SÃ¡nchez", "DÃ­az", "Ayuso", "Tyler",
			"Laborda", "Jobs", "Gates", "CÃ©sar", "Jerry", "Vital", "Serra", "Strife", "LÃ³pez", "RuÃ­z"};
	

	public String obtenerTitulo() {
		return titulo[random.nextInt(titulo.length)];
	}
	
	public String obtenerAutor() {
		return autor[random.nextInt(autor.length)];
	}
	
	public String obtenerNombre() {
		return nombre[random.nextInt(nombre.length)];
	}
	
	public String obtenerApellido() {
		return apellido[random.nextInt(apellido.length)];
	}
	
	public String obtenerNombreCompleto() {
		return nombre[random.nextInt(nombre.length)] + " " + apellido[random.nextInt(apellido.length)];
	}
	public int obtenerNumeroEntero(int numero) {
		return random.nextInt(numero + 1);
	}
	
	public int obtenerNumeroEnteroPositivo(int numero) {
		return random.nextInt(numero) + 1;
	}
	
}
