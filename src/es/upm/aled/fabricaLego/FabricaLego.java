package es.upm.aled.fabricaLego;

public class FabricaLego extends Thread{
	private int piezaRoja = 0;
	private int piezaAzul = 0;
	private final int capacidad = 50;
	
	public synchronized void producirRojo() throws InterruptedException {
		// Si hay piezaRojas que la capacidad de la cesta, la producción deberá de esperar:
		while(piezaRoja >= capacidad) {
			wait();
		}
		piezaRoja++;
		System.out.println("Se ha producido una pieza roja.");
		notifyAll(); // Notificamos al gestor de pedidos
	}
	
	public synchronized void producirAzul() throws InterruptedException {
		// Análogo al anterior:
		while(piezaAzul >= capacidad) {
			wait();
		}
		piezaAzul++;
		System.out.println("Se ha producido una pieza azul.");
		notifyAll(); // Notificamos al gestor de pedidos
	}
	
	public synchronized void gestorPedidos(int cantRojas, int cantAzules) throws InterruptedException{
		// En este caso el gestor de pedidos tendrá que esperar mientras que la cantidad de pieza rojas y azules
		// sea insuficiente para enviar:
		System.out.println("El gestor de pedidos solicita " + cantRojas + " y " + cantAzules + " piezas.");
		while(piezaRoja < cantRojas || piezaAzul < cantAzules) {
			wait();
			System.out.println("No hay suficientes piezas. El gestor de pedidos espera.");
		}
		piezaRoja -= cantRojas;
		piezaAzul -= cantAzules;
		System.out.println("Pedido realizado.");
		notifyAll();
		
	}
}
