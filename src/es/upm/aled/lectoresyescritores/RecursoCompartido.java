package es.upm.aled.lectoresyescritores;

public class RecursoCompartido {
	private int valor=0;
	
	// Lectura sincronizada:
	public synchronized int leer() {
		System.out.println("Leemos el valor actual " + valor);
		return valor;
	}
	
	// Escritura sincronizada:
	public synchronized void escribir(int valorNuevo) {
		System.out.println("Cambiamos del valor actual " + valor + " al valor nuevo " + valorNuevo);
		valor = valorNuevo;
		
	}
}
