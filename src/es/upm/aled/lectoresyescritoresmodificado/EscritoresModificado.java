package es.upm.aled.lectoresyescritoresmodificado;

import java.util.Random;

import es.upm.aled.lectoresyescritores.RecursoCompartido;

public class EscritoresModificado extends Thread{
	//Recurso compartido de Escritores y Lectores
		private final RecursoEntero recurso1;
		private final RecursoEntero recurso2;
		private final Random random = new Random();
		
		public EscritoresModificado(RecursoEntero recurso1, RecursoEntero recurso2) {
			this.recurso1 = recurso1;
			this.recurso2 = recurso2;

		}
		
		@Override
		public void run() {
			// Valor entre 0 y 10.000
			int valorNuevo = random.nextInt(10001);
			// Elergimos aleatoriamente cuál es el entero a modificar:
			if (random.nextBoolean()) {
				recurso1.escribir(valorNuevo);
			} else {
				recurso2.escribir(valorNuevo);
			}
		}
	
}
