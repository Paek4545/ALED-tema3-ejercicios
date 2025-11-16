package es.upm.aled.canibales;

import java.util.Random;

public class Canibales extends Thread{
	private final int id;
	private final Marmita marmita;
	private Random rand = new Random();
	
	public Canibales(int id, Marmita marmita) {
		this.id = id;
		this.marmita = marmita;
	}
	
	@Override
	public void run() {
		try {
			// Los caníbales comeran entre 3 y 6 raciones
			int comidas = rand.nextInt(3,6);
			for (int i = 0; i < comidas; i++) {
				Thread.sleep(rand.nextLong(1,1501)); // Tiempo entre comidas
				marmita.comer(id);
			}
			System.out.println("Caníbal " + id + " ha terminado de comer sus raciones.");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
