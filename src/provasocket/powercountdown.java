package provasocket;

import java.util.*;

/*
 * @author Fabio Fiorucci
 */
public class powercountdown extends Thread {
	private int tempo;
	private boolean connesso;

	public powercountdown(int tempo) {
		this.tempo = tempo;
		this.connesso = false;
	}

	public void run() {
		while (tempo > 0 && connesso == false)// si interrompe se qualcuno si connette o finisce il temoo
		{
			try {
				System.out.println(tempo / 1000);
				this.sleep(1000);
				tempo = tempo - 1000;
			} catch (InterruptedException ex) {
				System.out.println("ERRORE Interruzione del conto alla rovescia");
			}
		}
	}

	// metodo per l'interruzione del conto alla rovescia
	public void setConnesso() {
		this.connesso = true;
	}
}
