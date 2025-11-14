package es.upm.aled.lectoresyescritoresmodificado;

import java.util.Random;

import es.upm.aled.lectoresyescritores.RecursoCompartido;

public class LectoresMoficado extends Thread {
	private final RecursoEntero recurso1;
	private final RecursoEntero recurso2;
	private final Random random = new Random();

	public LectoresMoficado(RecursoEntero recurso1, RecursoEntero recurso2) {
		this.recurso1 = recurso1;
		this.recurso2 = recurso2;
	}

	@Override
	public void run() {
		// Leemos los recursos
		if(random.nextBoolean()) {
			recurso1.leer();
			recurso2.leer();
		} else {
			recurso2.leer();
			recurso1.leer();
		}
	}

	
}
