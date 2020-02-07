/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettotcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author informatica
 */
public class Server {

     public static void main(String[] args) {
          try {
               ServerSocket sSocket;
               int porta = 3500;
               int k = 0;

               k++;

               sSocket = new ServerSocket(porta);
               Socket connesione;
               try {
                    int t = 10000;
                    ContaSec t1 = new ContaSec();
                    sSocket.setSoTimeout(t);
                    System.out.println("in attesa della " + k + "-esima connessione...");
                    t1.start();
                    connesione = sSocket.accept();
                    System.out.println("Connessione stabilita");
                    sSocket.close();
                    System.out.println("Connessione chiusa");
               } catch (SocketException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("sas");
               }
          } catch (IOException ex) {
               Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
          }

     }
}
