package es.upm.aled.tema3.ejercicio13;

import java.util.Random;

public class Peluqueria{
	private final int sofasMax= 5;
	private int sofasOcupados = 0;
	private boolean sillaOcupada = false;
	private Random random = new Random();
	
	// Vamos a tener 3 métodos: uno para la entrada a la peluquería, otra para la salida y otro para el corte de pelo
	public synchronized boolean entrarPeluqueria() {
		// TODAS LAS SILLAS Y SOFAS SE ENCUENTRAN OCUPADAS --> El cliente se marcha
		if (sillaOcupada && sofasOcupados == sofasMax) {
			System.out.println("Todos los asientos de la peluquería están ocupados (establecimiento lleno).");
			return false;
		}
		// Si la silla de la peluquería está libre, la ocupa:
		if (!sillaOcupada) {
			sillaOcupada = true;
			System.out.println("El cliente " + Thread.currentThread().getName() + " ha ocupado la silla.");
			return true;
		}
		
		// Si la silla de la peluquería está ocupada, pero hay sitios libres en los sofás, ocupa una de estas
		if (sillaOcupada) {
			sofasOcupados++;
			System.out.println("El cliente " + Thread.currentThread().getName() + " ocupa uno de los sofás.");
		}
		// Además de ponerse en el sofá, el cliente tendrá que esperar a que la silla ya no esté ocupada
			while(sillaOcupada) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Si la silla ya no está ocupada, se quitará del sofá y se pondrá en el la silla:
			sofasOcupados--;
			sillaOcupada = true;
			System.out.println("El cliente " + Thread.currentThread().getName() + " pasa del sofá a la silla.");
			return true;

		}
		return false;
		
	}
		public synchronized void salirPeluqueria() {
			sillaOcupada = false;
			System.out.println("El cliente " + Thread.currentThread().getName() + " sale de la peluquería.");
			// El cliente por tanto notificará al resto de que la silla ahora se encuentra libre.
			// solo el cliente más rápido será el que ocupe este puesto vacío.
			notifyAll();
		}
		
		public void simularCortePelo() {
			// SImulamos el corte de pelo entre 0 y 400 ms:
			try {
				 Thread.sleep(random.nextLong(0,401));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

}
