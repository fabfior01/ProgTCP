package multicast;

import java.net.*;
import java.io.*;
import java.util.*;

public class MulticastServer {
	public static void main(String[] args) {
		boolean attivo = true;
		byte[] bufferOUT = new byte[1024];
		int cr = 25;
		int porta = 3500;
		try {
			InetAddress gruppo = InetAddress.getByName("225.4.5.6");
			MulticastSocket socket = new MulticastSocket();
			// contenitore per il dato da trasmettere
			String dString = null;
			// ciclo per la trasmissione del dato
			while (attivo) {
				dString= "Invio primo Messaggio";//invio del messaggio
                                bufferOUT = dString.getBytes();
				// creo il DatagramPacket
				DatagramPacket packet = new DatagramPacket(bufferOUT, bufferOUT.length, gruppo, porta);
				// invio il dato
				socket.send(packet);
				Thread.sleep(1000);
				cr--;
				if (cr == 0) {
					System.out.println("Server in chiusura");
					attivo = false;
				} else {
					System.out.println("Server attivo per altri " + cr + " secondi");
				}
			}
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("Errore nella creazione del gruppo");
		} catch (IOException ex) {
			System.out.println("Errore nella creazione del socket");
		} catch (InterruptedException exc) {
			System.out.println("Errore nel far attendere il processo per 1s");
		}
	}
}
