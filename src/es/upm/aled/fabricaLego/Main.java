package es.upm.aled.fabricaLego;

public class Main {
	public static void main(String[] args) {

	    FabricaLego fabrica = new FabricaLego();

	    Thread productorRojo = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            try {
	                while (true) {
	                    fabrica.producirRojo();
	                    Thread.sleep(500);
	                }
	            } catch (InterruptedException e) {}
	        }
	    });

	    Thread productorAzul = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            try {
	                while (true) {
	                    fabrica.producirAzul();
	                    Thread.sleep(500);
	                }
	            } catch (InterruptedException e) {}
	        }
	    });

	    Thread pedidos = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            try {
	                while (true) {
	                    int rojas = 1 + (int)(Math.random() * 10);
	                    int azules = 1 + (int)(Math.random() * 10);

	                    fabrica.gestorPedidos(rojas, azules);
	                    Thread.sleep(1000);
	                }
	            } catch (InterruptedException e) {}
	        }
	    });

	    productorRojo.start();
	    productorAzul.start();
	    pedidos.start();
	}
}