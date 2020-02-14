/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoStrikeBall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author fabio
 */
class Connect extends Thread
{
private Socket client = null;
BufferedReader in = null;
PrintStream out = null;
public Connect() {}
public Connect(Socket clientSocket)
{
client = clientSocket;
try
{
in = new BufferedReader(
new InputStreamReader(client.getInputStream()));
out = new PrintStream(client.getOutputStream(), true);
}
catch(IOException e1)
{
try { client.close(); }
catch(IOException e) { System.out.println(e.getMessage());}
return;
}
this.start();
}
public void run()
{
try
{
out.println("Generico messaggio per il Client");
out.flush();
// chiude gli stream e le connessioni
out.close();
in.close();
client.close();
}
catch(Exception e) {}
}
}