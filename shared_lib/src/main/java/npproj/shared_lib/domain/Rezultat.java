/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Klasa koja predstavlja Rezultat laboratorijske analize koji popunjava Laborant
 * @author Maja
 */
public class Rezultat implements Serializable, GeneralDObject {
    
    /**
     * Sifra rezultata kao Long
     */
    Long sifra_rezultata;
    /**
     * Vrednost rezultata analize kao String
     */
    String rezultat_analize;
    /**
     * Datum izdavanja rezultata kao Date
     */
    Date datumIzdavanja;
    /**
     * Laborant koji je izdao rezultat, objekat klase Laborant
     */
    Laborant laborant;
    /**
     * Analiza za koju je izdat rezultata, objekat klase Analiza
     */
    Analiza analiza;

    /**
     * Bezparametarski konstruktor
     */
    public Rezultat() {
    }
    /**
     * Parametarski konstruktor koji postavlja vrednosti atributa 
     * @param sifra_rezultata sifra rezultata
     * @param rezultat_analize vrednost rezultata analize
     * @param datumIzdavanja datum izdavanja rezultata
     * @param laborant laborant koji je izdao rezultata
     * @param analiza analiza za koju je izdat rezultat
     */
    public Rezultat(Long sifra_rezultata, String rezultat_analize, Date datumIzdavanja, Laborant laborant, Analiza analiza) {
        this.sifra_rezultata = sifra_rezultata;
        this.rezultat_analize = rezultat_analize;
        this.datumIzdavanja = datumIzdavanja;
        this.laborant = laborant;
        this.analiza = analiza;
    }
    /**
     * Vraca sifru rezultata
     * @return sifra_rezultata kao String
     */
    public Long getSifra_rezultata() {
        return sifra_rezultata;
    }
    /**
     * Postavlja sifru rezultata
     * @param sifra_rezultata sifra rezultata 
     */
    public void setSifra_rezultata(Long sifra_rezultata) {
        this.sifra_rezultata = sifra_rezultata;
    }
    /**
     * Vraca analizu za koju je izdat rezultat
     * @return analiza kao objekat klase Analiza
     */
    public Analiza getAnaliza() {
        return analiza;
    }
    /**
     * Postavlja analizu za koju je izdat rezultat
     * @param analiza analiza 
     */
    public void setAnaliza(Analiza analiza) {
        this.analiza = analiza;
    }
    /**
     * Vraca rezultat analize
     * @return rezultat_analize kao String
     */
    public String getRezultat_analize() {
        return rezultat_analize;
    }
    /**
     * Postavlja vrednost rezultata analize
     * @param rezultat_analize rezultat analize
     */
    public void setRezultat_analize(String rezultat_analize) {
        this.rezultat_analize = rezultat_analize;
    }
    /**
     * Vraca datum izdavanja rezultata
     * @return datumIzdavanja kao Date
     */
    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }
    /**
     * Postavlja datum izdavanja rezultata
     * @param datumIzdavanja datum izdavanja analize
     */
    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }
    /**
     * Vraca laboranta koji je izdao rezultat
     * @return Laborant
     */
    public Laborant getLaborant() {
        return laborant;
    }
    /**
     * Postavlja laboranta koji je izdao rezultat
     * @param laborant Laborant 
     */
    public void setLaborant(Laborant laborant) {
        this.laborant = laborant;
    }
    /**
     * Vraca vrednosti atributa klase Rezultat
     * @return String koji sadrzi vrednosti atributa odvojene zarezima 
     */
    @Override
    public String getAtrValue() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return sifra_rezultata + ", '" + rezultat_analize + "', '" + formatter.format(datumIzdavanja)
                + "', '" + laborant.getUsername() + "', " + analiza.getSifraAnalize();
    }
    /**
     * Vraca vrednosti atributa klase Rezultat
     * @return String koji sadrzi vrednosti atributa u obliku "atribut=vrednost"
     */
    @Override
    public String setAtrValue() {
        return "sifra_rezultata=" + sifra_rezultata + ", rezultat_analize='" + rezultat_analize
                + "', datum_izdavanja='" + datumIzdavanja + "', laborant='" + laborant.getUsername() 
                + "', sifra_analize=" + analiza.getSifraAnalize();
    }
    /**
     * Vraca ime klase Rezultat
     * @return naziv klase kao String
     */
    @Override
    public String getClassName() {
        return "Rezultat";
    }
    /**
     * Vraca vrednost atributa sifra_analize
     * @return String u obliku "sifra_analize = vrednost"
     */
    @Override
    public String getWhereCondition() {
        return "sifra_analize = " + analiza.getSifraAnalize();
    }
    /**
     * Kreira i vraca novi objekat klase Rezultat
     * @param rs objekat ResultSet iz kod se izvlace vrednosti atributa novog Rezultata
     * @return GeneralDObjekat objekat klase koja implementira interfejs GeneralDObjekat
     * @throws SQLException ukoliko je doslo do SQL greske
     */
    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new Rezultat(rs.getLong("sifra_rezultata"), rs.getString("rezultat_analize"),
                rs.getDate("datum_izdavanja"), new Laborant(rs.getString("laborant")),
                new Analiza(rs.getLong("sifra_analize")));
    }
    /**
     * Vraca String koji se koristi za specifikaciju sortiranja redova iz baze podataka
     * @return String "sifra_rezultata ASC"
     */
    @Override
    public String getOrderBy() {
        return "sifra_rezultata ASC";
    }
    /**
     * Vraca String naziv polja u bazi podataka
     * @return String "sifra_rezultata"
     */
    @Override
    public String getFields() {
        return "sifra_rezultata";
    }
    /**
     * Vraca vrednosti atributa Rezultata
     * @return String u obliku "atribut=vrednost"
     */
    @Override
    public String toString() {
        return "sifra_rezultata=" + sifra_rezultata + ", rezultat_analize='" + rezultat_analize
                + "', datum_izdavanja='" + datumIzdavanja + "'";
    }

}
