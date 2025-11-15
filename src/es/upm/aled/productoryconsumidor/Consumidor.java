package es.upm.aled.productoryconsumidor;

import java.util.Random;

public class Consumidor extends Thread {
	 private final Buffer buffer;
	    private final Random random = new Random();

	    public Consumidor(Buffer buffer) {
	        this.buffer = buffer;
	    }

	    @Override
	    public void run() {
	        while (true) {
	            buffer.consumir();
	            // Ya se imprime dentro de consumir()
	            try {
	                Thread.sleep(random.nextInt(500));
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
