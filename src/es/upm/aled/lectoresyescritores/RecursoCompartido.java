package es.upm.aled.lectoresyescritores;

public class RecursoCompartido {
	private Integer entero = null;
	
	private int numLectores = 0;
	private boolean escribiendo = false;
	
	// Acceso a la lectura:
	public synchronized void accesoLectura(int idLector) throws InterruptedException {
		// Si el entero es null o se está escribiendo tendrá que esperar:
		while (escribiendo || this.entero == null) {
			System.out.println("El lector " + idLector + " tendrá que esperar para leer.");
			wait();
		}
		// Si no cumple dicha condición el número de lectores se incrementará en 1:
		numLectores++;
		System.out.println("El lector " + idLector + " ha empezado a leer.");
	}
	
	public synchronized void terminaLectura(int idLector) throws InterruptedException {
		// Si el lector termina la lectura, actualizamos el número de lectores disminuyéndolo en 1:
		numLectores--;
		// Notificamos a todos los escritores en caso de que no haya lectores:
		if (numLectores == 0) {
		notifyAll();
		}
		System.out.println("El lector " + idLector + " ha terminado de leer.");
		
	}
	
	public synchronized void accesoEscritura(int idEscritor) throws InterruptedException {
		// En este caso este método tendrá que esperar en caso de que haya lectores leyendo o si se está escribiendo
		while(numLectores > 0 || escribiendo) {
			System.out.println("El escritor " + idEscritor + " se espera a escribir.");
			wait();
		}
		escribiendo = true;
		System.out.println("El escritor " + idEscritor + " ha comenzado a escribir.");
	} 
	
	public synchronized void terminaEscritura(int idEscritor) throws InterruptedException {
		escribiendo = false;
		System.out.println("El escritor " + idEscritor + " ha terminado de escribir.");
		notifyAll();
	}
	
	// Nos creamos ahora los métodos de leer y escribir:
	public void leer(int idLector) throws InterruptedException {
		// Para leer, primero accedemos a dicha lectura
		this.accesoLectura(idLector);
		// Leemos la referencia del entero guardándolo en un Integer:
		Integer valorLeido = this.entero;
		System.out.println("El lector " + idLector + " está leyendo " + valorLeido);
		// Hacemos una espera de 500 ms
		Thread.sleep((long)Math.random()*500);
		// Terminamos la lectura:
		this.terminaLectura(idLector);
	}
		
	public void escribir(int idEscritor) throws InterruptedException {
		this.accesoEscritura(idEscritor);
		// Cogemos primero el valor antiguo o anterior:
		Integer valorAntiguo = this.entero;
		// Generamos el nuevo entero de manera aleatoria:
		this.entero = (int) Math.random() * 10001;
		System.out.println("El escritor " + idEscritor + " está escribiendo y cambia el valor antiguo " + String.valueOf(valorAntiguo) + " por el valor nuevo " + this.entero);
		Thread.sleep( (long) Math.random() * 500);
		this.terminaEscritura(idEscritor);
	}
	
}
