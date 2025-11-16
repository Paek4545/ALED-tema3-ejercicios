package es.upm.aled.canibales;

import java.util.Random;

public class Marmita {
	// Dentro de la marmita incluimos las raciones, la capacidad y si hay un canibal esperando a que se  rellene:
	private int raciones;
	private final int capacidad;
	private boolean avisado = false;
	private Random rand = new Random();
	
	public Marmita(int capacidad) {
		this.capacidad = capacidad;
		this.raciones = capacidad;
	}
	
	public synchronized void comer(int id) {
		// Mientras no haya raciones para comer, el caníbal tendrá que esperar a que se rellene
		try {
			while(raciones == 0) {
				// Si hay un canibal esperando a rellenar, entonces este avisará al cocinero
				if (!avisado) {
					avisado = true;
					System.out.println("No quedan raciones. El caníbal " + id + " avisa al cocinero");
					notifyAll();
				}
				wait();
			}
			// En caso de que haya comida disponible:
			System.out.println("El caníbal " + id + " se sirve la marmita. Raciones restantes: " + (raciones -1));
			Thread.sleep(rand.nextLong(1, 1001));
			// Después de servirse, el número de raciones disminuirá:
			raciones--;
			
			// En caso de que después de comer se quede sin raciones, el siguiente caníbal avisará al cocinero:
			if (raciones == 0) {
				avisado = false;
				notifyAll(); 
			}
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		}	
			
		}

	
	public synchronized void rellenar() {
		// En este caso se espera hasta que un caníbal avise que esté vacía
		try {
			while(!avisado) {
				wait();	
			}
			System.out.println("El cocinero está rellenando la marmita...");
			Thread.sleep(rand.nextLong(1,1501));
			// El consiguero consigue rellenar
			raciones = capacidad;
			System.out.println("El cocinero ha terminado de rellenar. Raciones: " + capacidad);
			
			// El cocinero entonces pondrá el avisado a falso y notificará a todos los caníbales de que ya esta relleno
			avisado = false;
			notifyAll();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		}
	}

