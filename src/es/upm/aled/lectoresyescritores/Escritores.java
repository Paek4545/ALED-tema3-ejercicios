package es.upm.aled.lectoresyescritores;

import java.util.Random;

public class Escritores extends Thread{
	// Recurso compartido de Escritores y Lectores
		private final RecursoCompartido recursos;
		private final int id;
		
		public Escritores(RecursoCompartido recursos, int id) {
			this.recursos = recursos;
			this.id = id;
		}
		
		@Override
		public void run() {
			try {
				recursos.escribir(id);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	
}
