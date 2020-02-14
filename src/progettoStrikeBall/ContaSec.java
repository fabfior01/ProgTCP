/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoStrikeBall;

import static java.lang.Thread.sleep;

/**
 *
 * @author informatica
 */
public class ContaSec extends Thread {

    public void run() {
        try {
            
            for(int i=10;i>0;i--){
                System.out.println(i);
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("errore");
            System.exit(-1);
        }
    }

}