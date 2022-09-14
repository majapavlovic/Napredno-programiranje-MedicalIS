/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Klasa koja predstavlja Laboranta
 * Implementira interfejse Serializable i GeneralDOject
 *
 * @author Maja
 */
public class Laborant implements Serializable, GeneralDObject {

    /**
     * Username Laboranta koji koristi za logovanje na sistem
     */
    String username;
    /**
     * Password Laboranta koji koristi za logovanje na sistem
     */
    String password;
    /**
     * Ime laboranta
     */
    String ime;
    /**
     * Prezime laboranta
     */
    String prezime;

    /**
     * Konstruktor bez parametara
     */
    public Laborant() {
    }

    /**
     * Parametarski konstruktor kreira objekat klase Laborant i postavlja atribute na zadate vrednosti
     * @param username novi username laboranta
     * @param password novi password laboranta
     * @param ime novo ime laboranta
     * @param prezime novo prezime laboranta
     */
    public Laborant(String username, String password, String ime, String prezime) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }
    
    /**
     * Parametarski konstruktor kreira objekat klase Laborant i postavlja atribut username na zadatu vrednost
     * @param username novi username laboranta
     */
    public Laborant(String username) {
        this.username = username;
    }
    
    /**
     * Vraca ime laboranta
     * @return ime laboranta kao String
     */
    public String getIme() {
        return ime;
    }
    /**
     * Postavlja ime laboranta
     * @param ime novo ime laboranta
     * @throws Exception ako je ime prazno
     */
    public void setIme(String ime) throws Exception {
    	if(ime.isEmpty())
    		throw new Exception("Ime ne moze biti prazno");
        this.ime = ime;
    }
    /**
     * Vraca prezime laboranta
     * @return prezime laboranta kao String
     */
    public String getPrezime() {
        return prezime;
    }
    
    /**
     * Postavlja prezime laboranta
     * @param prezime novo prezime laboranta
     * @throws Exception ako je prezime prazno
     */
    public void setPrezime(String prezime) throws Exception {
    	if(prezime.isEmpty())
    		throw new Exception("Prezime ne moze biti prazno!");
        this.prezime = prezime;
    }
    /**
     * Vraca username laboranta
     * @return username laboranta kao String
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Postavlja username na zadatu vrednost
     * @param username novi username laboranta
     * @throws Exception ako je username prazan
     */
    public void setUsername(String username) throws Exception {
    	if(username.isEmpty())
    		throw new Exception("Username ne moze biti prazan!");
        this.username = username;
    }
    
    /**
     * Vraca password laboranta
     * @return password kao string
     */ 
    public String getPassword() {
        return password;
    }
    
    /**
     * Postavlja password na zadatu vrednost
     * @param password novi password laboranta
     * @throws Exception ako je password prazan
     */
    public void setPassword(String password) throws Exception {
    	if(password.isEmpty())
    		throw new Exception("Password ne moze biti prazan");
        this.password = password;
    }
    
    /**
     * Vraca vrednosti atributa username, password, ime i prezime
     * @return String u obliku "username, password, ime, prezime"
     */
    @Override
    public String getAtrValue() {
        return "'" + username + "', '" + password + "', '" + ime + "', '" + prezime + "'";

    }
    
    /***
     * Vraca vrednosti atributa username, password, ime i prezime
     * @return String u obliku "korisnicko_ime=username, korisnicka_sifra=password, ime=ime, prezime=prezime"
     */
    @Override
    public String setAtrValue() {
        return "korisnicko_ime='" + username + "', korisnicka_sifra='"
                + password + "', ime='" + ime + "', prezime='" + prezime + "'";
    }
    
    /**
     * Vraca naziv klase Laborant
     * @return naziv klase kao String
     */
    @Override
    public String getClassName() {
        return "Laborant";
    }
    
    /**
     * Vraca username i pasword u Stringu koji se koristi za upit u bazu podataka
     * @return String u obliku "korisnicko_ime=username AND korisnicka_sifra=password"
     */
    @Override
    public String getWhereCondition() {
        return "korisnicko_ime='" + username + "' AND korisnicka_sifra='" + password + "'";
    }

    /**
     * Kreira i vraca novi objekat klase Laborant
     * @param rs objekat ResultSet iz kod se izvlace vrednosti atributa novog Laboranta
     * @return GeneralDObjekat objekat klase koja implementira interfejs GeneralDObjekat
     * @throws SQLException ukoliko je doslo do SQL greske
     */
    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new Laborant(rs.getString("korisnicko_ime"), rs.getString("korisnicka_sifra"),
                rs.getString("ime"), rs.getString("prezime"));
    }
    
    /**
     * Vraca String koji sadrzi username 
     * @return String "korisnicko_ime=username"
     */
    @Override
    public String getWhereCondition1() {
        return "korisnicko_ime='" + username + "'";
    }

}
