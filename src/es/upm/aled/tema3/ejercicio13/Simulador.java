package es.upm.aled.tema3.ejercicio13;

import java.util.Random;

public class Simulador {
	public static void main(String[] args) {
		// Nos creamos el número de clientes (50) y la peluquería:
	 int numClientes = 50;
	 Peluqueria peluqueria = new Peluqueria();
	 Random rand = new Random();
	
	 // Iniciamos la simulación con los 50 clientes:
	 System.out.println("Iniciando la simulación...");
	 for (int i = 0; i < numClientes; i++) {
		 Cliente cliente = new Cliente(peluqueria);
		 cliente.start();
		 
		 // Los clientes llegarán en intervalos aleatorios de 150 milisegundos:
		 try {
			 Thread.sleep(rand.nextInt(0, 151));
		 } catch(InterruptedException e) {
			 e.printStackTrace();
		 }
	 }
	 System.out.println("Todos los clientes han sido generados con éxito.");
	 
	}
	
	
}
