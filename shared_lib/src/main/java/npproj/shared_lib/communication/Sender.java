/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja predstavlja sendera, sluzi za slanje poruka preko soketa
 * @author Maja
 */
public class Sender {
    /**
     * Soket za slanje poruka
     */
    private Socket socket;
    /**
     * Parametarki konstruktor postavlja vrednost soketa
     * @param socket soket
     */
    public Sender(Socket socket) {
        this.socket = socket;
    }
    /**
     * Metoda koja sluzi za slanje poruka preko soketa
     * @param object objekat koji se salje preko soketa
     * @throws Exception greska u slanju poruke
     */
    public void send(Object object) throws Exception {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw  new Exception("Error sending object: " + ex.getMessage());
        }
    }
}
