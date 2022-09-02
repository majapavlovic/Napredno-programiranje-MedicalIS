/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa iz koje se citaju vrste mogucih uzoraka za laboratorijske analize
 *
 * @author Maja
 */
public class VrstaUzorka implements Serializable {

    /*
    * Lista vrsta uzoraka kao  lista Stringova
     */
    List<String> uzorci = new ArrayList<>();

    /**
     * Konstruktor klase VrstaUzorka koji populise listu uzoraka
     */
    public VrstaUzorka() {
        uzorci.add("Bris grla");
        uzorci.add("Bris nosa");
        uzorci.add("Krv");
        uzorci.add("Urin");
        uzorci.add("Feces");
        uzorci.add("Sputum");
        uzorci.add("Bris rane(duboke)");
        uzorci.add("Bris površinske rane");
    }

    /**
     * Vraca listu uzorci
     *
     * @return uzorci kao List{@literal <}String{@literal >}
     */
    public List<String> getUzorci() {
        return uzorci;
    }
}
