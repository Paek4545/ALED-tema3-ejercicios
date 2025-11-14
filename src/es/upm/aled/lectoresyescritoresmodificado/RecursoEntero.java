package es.upm.aled.lectoresyescritoresmodificado;

public class RecursoEntero {
	  private int valor = 0;
	    private final String nombre;

	    public RecursoEntero(String nombre) {
	        this.nombre = nombre;
	    }

	    // Lectura sincronizada
	    public synchronized int leer() {
	        System.out.println("Leemos " + nombre + ", valor actual: " + valor);
	        return valor;
	    }

	    // Escritura sincronizada
	    public synchronized void escribir(int valorNuevo) {
	        System.out.println("Cambiamos " + nombre + " del valor actual " + valor + " al valor nuevo " + valorNuevo);
	        valor = valorNuevo;
	    }
}
