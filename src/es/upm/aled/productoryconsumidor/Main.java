package es.upm.aled.productoryconsumidor;

public class Main {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();

        int numProductores = 3;
        int numConsumidores = 2;

        for (int i = 0; i < numProductores; i++) {
            new Productor(buffer).start();
        }

        for (int i = 0; i < numConsumidores; i++) {
            new Consumidor(buffer).start();
        }
    }
}
