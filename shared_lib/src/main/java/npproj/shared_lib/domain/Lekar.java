/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Klasa koja predstavlja lekara
 * Lekar popunjava kartone pacijenata i upute za laboratorijske analize
 * @author Maja
 */
public class Lekar implements Serializable, GeneralDObject {
    
    /**
     * Username Lekara koji koristi za logovanje na sistem
     */
    String username;
    /**
     * Password Lekara koji koristi za logovanje na sistem
     */
    String password;
    /**
     * Ime lekara
     */
    String ime;
    /**
     * Prezime lekara
     */
    String prezime;

    /**
     * Konstruktor bez parametara
     */
    public Lekar() {
    }
    /**
     * Parametarski konstruktor koji postavlja atribute objekta klase Lekar
     * @param username username lekara
     * @param password password lekara
     * @param ime ime lekara
     * @param prezime prezime lekara
     */
    public Lekar(String username, String password, String ime, String prezime) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }
    /**
     * Konstruktor koji postavlja vrednost parametra username
     * @param username username Lekara
     */
    public Lekar(String username) {
        this.username = username;
    }
    /**
     * Konstruktor koji postavlja vrednost parametara username i password
     * @param username username Lekara
     * @param password password lekara
     */
    public Lekar(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Vraca ime lekara
     * @return ime lekara kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime lekara
     * @param ime ime lekara
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Vraca prezime lekara
     * @return prezime lekara kao String
     */    
    public String getPrezime() {
        return prezime;
    }
    /**
     * Postavlja prezime lekara
     * @param prezime prezime lekara
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    /**
     * Vraca username lekara
     * @return username lekara kao String
     */
    public String getUsername() {
        return username;
    }
    /**
     * Postavlja username lekara
     * @param username username lekara
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Vraca password lekara
     * @return password lekara kao String
     */
    public String getPassword() {
        return password;
    }
    /**
     * Postavlja password lekara
     * @param password password lekara
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Vraca vrednosti atributa klase Lekar
     * @return String koji sadrzi vrednosti atributa odvojene zarezima 
     */
    @Override
    public String getAtrValue() {
        return "'" + username + "', '" + password + "', '" + ime + "', '" + prezime + "'";
    }
    /**
     * Vraca vrednosti atributa klase Lekar
     * @return String koji sadrzi vrednosti atributa u obliku "atribut=vrednost"
     */
    @Override
    public String setAtrValue() {
        return "korisnicko_ime='" + username + "', korisnicka_sifra='" + password +
                "', ime='" + ime + "', prezime='" + prezime + "'";
    }
    /**
     * Vraca ime klase Lekar
     * @return naziv klase kao String
     */
    @Override
    public String getClassName() {
        return "Lekar";
    }
    /**
     * Vraca vrednosti atributa username i password
     * @return String u obliku "korisnicko_ime='username' AND korisnicka_sifra='password'"
     */
    @Override
    public String getWhereCondition() {
        return "korisnicko_ime='" + username + "' AND korisnicka_sifra='" + password + "'";
    }
    /**
     * Kreira i vraca novi objekat klase Lekar
     * @param rs objekat ResultSet iz kod se izvlace vrednosti atributa novog Lekara
     * @return GeneralDObjekat objekat klase koja implementira interfejs GeneralDObjekat
     * @throws SQLException ukoliko je doslo do SQL greske
     */
    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new Lekar(rs.getString("korisnicko_ime"), rs.getString("korisnicka_sifra"), 
                rs.getString("ime"), rs.getString("prezime"));
    }
    /**
     * Vraca username Lekara 
     * @return String u obliku "korisnicko_ime='username'"
     */
    @Override
    public String getWhereCondition1() {
        return "korisnicko_ime='" + username + "'";
    }

}
