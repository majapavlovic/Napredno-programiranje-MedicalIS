/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa iz koje se citaju krvne grupe
 *
 * @author Maja
 */
public class KrvnaGrupa implements Serializable {

    /**
     * Lista krvnih grupa
     */
    public List<String> krvneGrupe = new ArrayList();

    /**
     * Konstruktor koji populise listu krvnih grupa
     */
    public KrvnaGrupa() {
        krvneGrupe.add("A+");
        krvneGrupe.add("A-");
        krvneGrupe.add("AB+");
        krvneGrupe.add("AB-");
        krvneGrupe.add("B+");
        krvneGrupe.add("B-");
        krvneGrupe.add("O+");
        krvneGrupe.add("O-");
    }

    /**
     * Vraca listu krvnih grupa
     *
     * @return lista krvnih grupa Lista{@literal <}String{@literal >}
     */
    public List<String> getKrvneGrupe() {
        return krvneGrupe;
    }
}
