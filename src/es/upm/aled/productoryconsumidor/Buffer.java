package es.upm.aled.productoryconsumidor;

public class Buffer {
	private final int[] buffer = new int[10];
	private int count = 0;      // Número de elementos en el buffer
	private int in = 0;         // Índice para el siguiente productor
	private int out = 0;        // Índice para el siguiente consumidor
	
	// Producir dato
    public synchronized void producir(int dato) {
        while (count == buffer.length) {
            try {
                wait(); // Buffer lleno, esperar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Pinemos en el buffer el dato que vamos a introducir
        buffer[in] = dato;
        System.out.println(Thread.currentThread().getName() + " produce: " + dato);
        // Recorremos el array
        in = (in + 1) % buffer.length;
        count++;
        notifyAll(); // Despertar consumidores
    }

    // Consumir dato
    public synchronized int consumir() {
        while (count == 0) {
            try {
                wait(); // Buffer vacío, esperar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int dato = buffer[out];
        System.out.println(Thread.currentThread().getName() + " consume: " + dato);
        // Recorremos el array
        out = (out + 1) % buffer.length;
        count--;
        notifyAll(); // Despertar productores
        return dato;
    }
}

