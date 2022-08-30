/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Klasa koja predstavlja laboratorijsku analizu
 * @author Maja
 */
public class Analiza implements GeneralDObject, Serializable {

    /**
     * Sifra analize kao Long
     */
    Long sifraAnalize;
    /**
     * Vrsta analize kao String
     */
    String vrstaAnalize;
    /**
     * Vrsta uzorka za analizu kao String
     */
    String vrstaUzorka;
    /**
     * Uput za koji se vrsi analiza, objekat klase Uput
     */
    Uput uput;

    /**
     * Kreira objekat Analiza i postavlja atribut sifraAnalize na zadatu vrednost
     * @param sifraAnalize sifra analize
     */
    public Analiza(Long sifraAnalize) {
        this.sifraAnalize = sifraAnalize;
    }
    
    /**
     * Kreira objekat Analiza i postavlja vrednosti atributa
     * @param sifraAnalize sifra analize
     * @param vrstaAnalize vrsta analize
     * @param vrstaUzorka vrsta uzorka
     * @param uput uput za analizu
     */
    public Analiza(Long sifraAnalize, String vrstaAnalize, String vrstaUzorka, Uput uput) {
        this.sifraAnalize = sifraAnalize;
        this.vrstaAnalize = vrstaAnalize;
        this.vrstaUzorka = vrstaUzorka;
        this.uput = uput;
    }
    /**
     * Konstruktor bez parametara
     */
    public Analiza() {
    }
    /**
     * Vraca vrednost atributa sifraAnalize
     * @return sifraAnalize kao Long
     */
    public Long getSifraAnalize() {
        return sifraAnalize;
    }
    /**
     * Postavlja vrednost atributa sifraAnalize
     * @param sifraAnalize nova sifra analize
     */
    public void setSifraAnalize(Long sifraAnalize) {
        this.sifraAnalize = sifraAnalize;
    }
    /**
     * Vraca vrednost atributa vrstaAnalize
     * @return vrsta analize kao String
     */
    public String getVrstaAnalize() {
        return vrstaAnalize;
    }
    /**
     * Postavlja vrednost atributa vrstaAnalize
     * @param vrstaAnalize nova vrsta analize
     */
    public void setVrstaAnalize(String vrstaAnalize) {
        this.vrstaAnalize = vrstaAnalize;
    }
    /**
     * Vraca vrednost atributa vrstaUzorka
     * @return vrsta uzorka kao String
     */
    public String getVrstaUzorka() {
        return vrstaUzorka;
    }
    /**
     * Postavlja vrednost atributa vrstaUzorka 
     * @param vrstaUzorka nova vrsta uzorka 
     */
    public void setVrstaUzorka(String vrstaUzorka) {
        this.vrstaUzorka = vrstaUzorka;
    }
    /*
    * Vraca objekat klase Uput za koji se radi analiza
    * @return uput objekat klase Uput
    */
    public Uput getUput() {
        return uput;
    }
    /**
     * Postavlja vrednost atributa uput na zadatu vrednost
     * @param uput objekat klase Uput
     */
    public void setUput(Uput uput) {
        this.uput = uput;
    }
    
    /**
     * Vraca vrednosti atributa sifraAnalize, vrstaAnalize, vrstaUzorka i sifru uputa kao string
     * @return String u obliku "sifraAnalize, vrstaAnalize, vrstaUzorka, sifraUputa"
     */
    @Override
    public String getAtrValue() {
        return sifraAnalize + ", '" + vrstaAnalize + "', '" + vrstaUzorka + "', " + uput.getSifraUputa();
    }

    @Override
    public String setAtrValue() {
        return "sifra_analize = " + sifraAnalize + ", vrsta_analize='" + 
                vrstaAnalize + "', vrsta_uzorka='" + vrstaUzorka + "', sifra_uputa=" + uput.getSifraUputa();
    }

    @Override
    public String getClassName() {
        return "Analiza";
    }

    @Override
    public String getWhereCondition() {
        return "sifra_uputa = " + uput.getSifraUputa();
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new Analiza(
                rs.getLong("sifra_analize"),
                rs.getString("vrsta_analize"),
                rs.getString("vrsta_uzorka"),
                new Uput(rs.getLong("sifra_uputa")));
    }

    @Override
    public String getFields() {
        return "sifra_analize";
    }

    @Override
    public String toString() {
        return "sifra_analize = " + sifraAnalize + ", vrsta_analize='" + 
                vrstaAnalize + "', vrsta_uzorka='" + vrstaUzorka + "'";
    }

}
