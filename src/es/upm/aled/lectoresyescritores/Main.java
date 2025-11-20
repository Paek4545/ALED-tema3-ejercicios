package es.upm.aled.lectoresyescritores;

import java.util.Random;

public class Main {
	public static void main(String[] args) {

	    RecursoCompartido recurso = new RecursoCompartido();

	    // Crear array de tamaño aleatorio entre 1 y 10
	    int[] array = new int[(int)(Math.random() * 10) + 1];

	    // Rellenar el array con valores (por ejemplo, IDs)
	    for (int i = 0; i < array.length; i++) {
	        array[i] = i; // o cualquier valor que quieras
	    }

	    // Elegimos un ID cualquiera, por ejemplo el primero
	    Random rnd = new Random();

	 // Elegir una posición aleatoria del array
	 int randomIndex = rnd.nextInt(array.length);

	 // El ID es el valor del array en esa posición
	 int id = array[randomIndex];

	    // Crear hilos
	    Lectores l1 = new Lectores(recurso, id);
	    Lectores l2 = new Lectores(recurso, id);
	    Lectores l3 = new Lectores(recurso, id);
	    Escritores e1 = new Escritores(recurso, id);
	    Escritores e2 = new Escritores(recurso, id);
	    Escritores e3 = new Escritores(recurso, id);

	    // Ejecutar hilos
	    l1.start();
	    e1.start();
	    l2.start();
	    e2.start();
	    l3.start();
	    e3.start();
	    System.out.println("Tamaño array: " + array.length);
	    System.out.println("Índice aleatorio: " + randomIndex);
	    System.out.println("ID elegido: " + id);

	}
	
}