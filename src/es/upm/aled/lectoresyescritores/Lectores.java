package es.upm.aled.lectoresyescritores;


public class Lectores extends Thread {
	private final RecursoCompartido recurso;
	
	public Lectores(RecursoCompartido recurso) {
		this.recurso = recurso;
	}
	
	@Override
	public void run() {
		// Leemos el recurso
		recurso.leer();
	}
}
