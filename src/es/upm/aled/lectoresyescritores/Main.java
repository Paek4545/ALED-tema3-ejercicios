package es.upm.aled.lectoresyescritores;

public class Main {

	public static void main(String[] args) {
		// Nos creamos como objeto el recurso compartido
		RecursoCompartido recurso = new RecursoCompartido();
		// Nos creamos los hilos de Lectores y Escritores:
		Lectores l1 = new Lectores(recurso);
		Lectores l2 = new Lectores(recurso);
		Escritores e1 = new Escritores(recurso);
		Escritores e2 = new Escritores(recurso);
		l1.start();
		l2.start();
		e1.start();
		e2.start();
		

	}

}
