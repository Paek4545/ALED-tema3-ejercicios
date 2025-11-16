package es.upm.aled.canibales;

import java.util.Random;

public class Cocineros extends Thread {
	private final Marmita marmita;
	
	public Cocineros(Marmita marmita) {
		this.marmita = marmita;
	}
	
	@Override
	public void run() {
	
			while(true) {
				marmita.rellenar();
			}	
	}
}
