package es.upm.aled.lectoresyescritores;


public class Lectores extends Thread {
	private final RecursoCompartido recursos;
	private final int id;
	public Lectores(RecursoCompartido recursos, int id) {
		this.recursos = recursos;
		this.id = id;
	}
	
	@Override
	public void run() {
		// Leemos el recurso
		try {
			recursos.leer(id);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
