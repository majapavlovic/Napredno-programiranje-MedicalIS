/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.communication;

import java.io.Serializable;

/**
 *  Klasa koja predtavlja zahtev koji se salje serveru/klijentu
 * @author Maja
 */
public class Request implements Serializable {
    /**
     * Operacija koja treba da se izvrsi kao int
     */
    private int operation;
    /**
     * Argument requesta
     */
    private Object argument;

    /**
     * Konstruktor koji postavlja vrednosti
     * @param operation operacija
     * @param argument argument requesta
     */
    public Request(int operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }
    /**
     * Vraca operaciju Requesta
     * @return operation
     */
    public int getOperation() {
        return operation;
    }
    /**
     * Vraca argument Requesta
     * @return 
     */
    public Object getArgument() {
        return argument;
    }
}
