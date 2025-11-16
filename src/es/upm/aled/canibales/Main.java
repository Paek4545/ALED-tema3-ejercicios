package es.upm.aled.canibales;

public class Main {
	public static void main(String[] args) {
	    Marmita m = new Marmita(5);
	    new Cocineros(m).start();

	    for (int i = 1; i <= 6; i++) {
	        new Canibales(i, m).start();
	    }
	}

}
