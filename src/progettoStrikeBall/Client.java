/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoStrikeBall;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author informatica
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket connessione;
        String server = "localhost";
        int porta = 3500;
        connessione = new Socket(server, porta);
        System.out.println("connesione aperta");
        connessione.close();
        System.out.println("connesione chiusa");
    }

}
