package multicast;

import java.net.*;
import java.io.*;

public class MulticastClient {
	public static void main(String[] args) {
		byte[] bufferIN = new byte[1024];
		// parametri del server
		int porta = 3500;//porta
		String gruppo = "225.4.5.6";//gruppo
		try {
			MulticastSocket socket = new MulticastSocket(porta);//creo il socket
			socket.joinGroup(InetAddress.getByName(gruppo));//entro nel gruppo
			DatagramPacket packetIN = new DatagramPacket(bufferIN, bufferIN.length);
			socket.receive(packetIN);
			// visualizzo parametri e dati raccolti
			System.out.println("Ho ricevuto i dati di lunghezza: " + packetIN.getLength() + " da: "
					+ packetIN.getAddress().toString() + " porta: " + packetIN.getPort());
			System.out.write(packetIN.getData(), 0, packetIN.getLength());
			System.out.println();
			socket.leaveGroup(InetAddress.getByName(gruppo));// lascio il gruppo
			socket.close();// chiudo il socket
		} catch (IOException e) {
			System.out.println("Errore nella crezione del utente");
		}
	}
}
