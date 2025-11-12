package es.upm.aled.lectoresyescritores;

import java.util.Random;

public class Escritores extends Thread{
	// Recurso compartido de Escritores y Lectores
	private final RecursoCompartido recursos;
	private final Random random = new Random();
	
	public Escritores(RecursoCompartido recursos) {
		this.recursos = recursos;

	}
	
	@Override
	public void run() {
		// Nos creamos el valor nuevo entre 0 y 1000 que va a sustituir al valor actual
		int valorNuevo = random.nextInt(1001);
		recursos.escribir(valorNuevo);
	}
	
}
