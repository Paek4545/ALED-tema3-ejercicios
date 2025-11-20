package es.upm.aled.tema3.ejercicio13;

public class Cliente extends Thread {
	
	private Peluqueria peluqueria;
	
	public Cliente(Peluqueria peluqueria) {
		this.peluqueria = peluqueria;
	}
	
	@Override
	public void run() {
		// El cliente intentará entrar a la peluqueria:
		boolean esAtendido = peluqueria.entrarPeluqueria();
		// Si ha conseguido entrar, se hará primero el corte de pelo y luego saldrá de la peluquería:
		if(esAtendido) {
			peluqueria.simularCortePelo();
			peluqueria.salirPeluqueria();
		}
	}
}
