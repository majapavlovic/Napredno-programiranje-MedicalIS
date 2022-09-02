/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja predstavlja receivera, sluzi za primanje poruka 
 * @author Maja
 */
public class Receiver {
    /**
     * Soket za primanje poruka
     */
    private Socket socket;
    /**
     * Konstruktor koji postavlja vrednost soketa
     * @param socket 
     */
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    /**
     * Metoda koja cita poruke iz inputStream-a
     * @return objekat koji predstavlja poruku primljenu kroz soket
     * @throws Exception ukoliko je doslo do greske pri primanju poruke
     */
    public Object receive() throws Exception {
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(socket.getInputStream());
               return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error receiving object: " + ex.getMessage());
        }
     
    }
   
    
}
