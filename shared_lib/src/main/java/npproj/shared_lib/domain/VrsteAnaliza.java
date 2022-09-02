/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa iz koje se citaju vrste mogucih laboratorijskih analiza
 *
 * @author Maja
 */
public class VrsteAnaliza implements Serializable {

    /**
     * Lista mogucih analiza
     */
    public List<String> analize = new ArrayList();

    /**
     * Konstuktor koji populise listu analiza
     */
    public VrsteAnaliza() {
        analize.add("Bakterioloska");
        analize.add("Mikoloska");
        analize.add("Paraziti");
        analize.add("Virusoloska");
        analize.add("Mikobakterioloska");
    }

    /**
     * Vraca listu analiza
     *
     * @return List{@literal <}String{@literal >}
     */
    public List<String> getAnalize() {
        return analize;
    }

}
