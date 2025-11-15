package es.upm.aled.productoryconsumidor;

import java.util.Random;

public class Productor extends Thread{
	 private final Buffer buffer;
	    private final Random random = new Random();

	    public Productor(Buffer buffer) {
	        this.buffer = buffer;
	    }

	    @Override
	    public void run() {
	        while (true) { 
	            int dato = random.nextInt(10001); // Entre 0 y 10.000
	            buffer.producir(dato);
	            try {
	                Thread.sleep(random.nextInt(500));
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
