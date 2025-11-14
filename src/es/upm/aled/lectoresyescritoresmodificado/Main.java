package es.upm.aled.lectoresyescritoresmodificado;


public class Main {

	public static void main(String[] args) {
		// Nos creamos como objeto el recurso compartido
		RecursoEntero entero1 = new RecursoEntero("recurso1");
		RecursoEntero entero2 = new RecursoEntero("recurso2");
		// Nos creamos los hilos de Lectores y Escritores:
		LectoresMoficado l1 = new LectoresMoficado(entero1, entero2);
		LectoresMoficado l2 = new LectoresMoficado(entero1, entero2);
		LectoresMoficado l3 = new LectoresMoficado(entero1, entero2);
		EscritoresModificado e1 = new EscritoresModificado(entero1, entero2);
		EscritoresModificado e2 = new EscritoresModificado(entero1, entero2);
		EscritoresModificado e3 = new EscritoresModificado(entero1, entero2);
		l1.start();
		l2.start();
		e1.start();
		e2.start();
		l3.start();
		e3.start();

	}

}
