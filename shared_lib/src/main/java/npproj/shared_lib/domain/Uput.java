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
import java.util.List;

/**
 * Klasa koja predstavlja Uput pacijenta
 *
 * @author Maja
 */
public class Uput implements Serializable, GeneralDObject {

    /**
     * Sifra uputa pacijenta kao Long
     */
    Long sifraUputa;
    /**
     * Datum uputa pacijenta kao Date
     */
    Date datumUputa;
    /**
     * Uputna dijagnoza kao String
     */
    String uputnaDijagnoza;
    /**
     * Lekar koji kreira uput, objekat klase Lekar
     */
    Lekar lekar;
    /**
     * Karton pacijenta, objekat klase KartonPacijenta
     */
    KartonPacijenta pacijent;
    /**
     * Lista analiza uputa kao List{@literal <}Analiza{@literal >}
     */
    List<Analiza> analize;

    /**
     * Konstruktor bez parametara klase Uput
     */
    public Uput() {
    }

    /**
     * Parametarski konstruktor klase Uput koji postavlja vrednosti svih
     * atributa
     *
     * @param sifraUputa sifra uputa
     * @param datumUputa datum uputa
     * @param uputnaDijagnoza uputna dijagnoza uputa
     * @param lekar lekar koji kreira uput
     * @param pacijent karton pacijenta
     * @param analize lista analiza uputa
     * @throws Exception ukoliko nisu prosledjeni validni parametri
     */
    public Uput(Long sifraUputa, Date datumUputa, String uputnaDijagnoza, Lekar lekar,
            KartonPacijenta pacijent, List<Analiza> analize) throws Exception {
        if(uputnaDijagnoza.isEmpty()) {
        	throw new Exception("Morate upisati uputnu dijagnozu!");
        }
        if(analize==null || analize.isEmpty()) {
        	throw new Exception("Morate uneti barem jednu analizu u uput!");
        }
    	this.sifraUputa = sifraUputa;
        this.datumUputa = datumUputa;
        this.uputnaDijagnoza = uputnaDijagnoza;
        this.lekar = lekar;
        this.pacijent = pacijent;
        this.analize = analize;
    }

    /**
     * Parametarski konstruktor klase Uput koji postavlja vrednosti svih
     * atributa osim liste analiza
     *
     * @param sifraUputa sifra uputa
     * @param datumUputa datum uputa
     * @param uputnaDijagnoza uputna dijagnoza uputa
     * @param lekar lekar koji kreira uput
     * @param pacijent karton pacijenta
     * @throws Exception  ako podaci nisu validni
     */
    public Uput(Long sifraUputa, Date datumUputa, String uputnaDijagnoza,
            Lekar lekar, KartonPacijenta pacijent) throws Exception {
    	  if(uputnaDijagnoza.isEmpty()) {
          	throw new Exception("Morate upisati uputnu dijagnozu!");
          }
        this.sifraUputa = sifraUputa;
        this.datumUputa = datumUputa;
        this.uputnaDijagnoza = uputnaDijagnoza;
        this.lekar = lekar;
        this.pacijent = pacijent;
    }

    /**
     * Parametarski konstruktor klase Uput koji postavlja vrednosti atributa
     *
     * @param sifraUputa sifra uputa
     * @param datumUputa datum uputa
     * @param uputnaDijagnoza uputna dijagnoza
     * @throws Exception ako podaci nisu validni
     */
    public Uput(Long sifraUputa, Date datumUputa, String uputnaDijagnoza) throws Exception {
    	  if(uputnaDijagnoza.isEmpty()) {
          	throw new Exception("Morate upisati uputnu dijagnozu!");
          }
        this.sifraUputa = sifraUputa;
        this.datumUputa = datumUputa;
        this.uputnaDijagnoza = uputnaDijagnoza;

    }
    /**
     * Konstruktor koji postavlja vrednost sifre uputa
     * @param sifraUputa sifra uputa
     */
    public Uput(Long sifraUputa) {
        this.sifraUputa = sifraUputa;
    }
    /**
     * Vraca sifru uputa
     * @return sifraUputa kao Long
     */
    public Long getSifraUputa() {
        return sifraUputa;
    }
    /**
     * Postavlja sifru uputa
     * @param sifraUputa sifra uputa
     */
    public void setSifraUputa(Long sifraUputa) {
        this.sifraUputa = sifraUputa;
    }
    /**
     * Vraca datum uputa
     * @return datum uputa kao Date
     */
    public Date getDatumUputa() {
        return datumUputa;
    }
    /**
     * Postavlja datum uputa
     * @param datumUputa datum uputa
     */
    public void setDatumUputa(Date datumUputa) {
        this.datumUputa = datumUputa;
    }
    /**
     * Vraca uputnu dijagnozu
     * @return uputnaDijagnoza kao String
     */
    public String getUputnaDijagnoza() {
        return uputnaDijagnoza;
    }
    /**
     * Postavlja uputnu dijagnozu
     * @param uputnaDijagnoza uputna dijagnoza
     * @throws Exception ako nije uneta vrednost za uputni dijagnozu
     */
    public void setUputnaDijagnoza(String uputnaDijagnoza) throws Exception {
    	if (uputnaDijagnoza.isEmpty()) {
    	     throw new Exception("Morate upisati uputnu dijagnozu!");
		}
        this.uputnaDijagnoza = uputnaDijagnoza;
    }
    /**
     * Vraca lekara koji je izdao uput
     * @return lekar, objekar klase Lekar
     */
    public Lekar getLekar() {
        return lekar;
    }
    /**
     * Postavlja lekara koji je izdao uput
     * @param lekar lekar 
     */
    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }
    /**
     * Vraca pacijenta za koga je izdat uput
     * @return pacijent, objekat klase KartonPacijenta
     */
    public KartonPacijenta getPacijent() {
        return pacijent;
    }
    /**
     * Postavlja pacijenta za kog se izdaje uput
     * @param pacijent pacijent 
     */
    public void setPacijent(KartonPacijenta pacijent) {
        this.pacijent = pacijent;
    }
    /**
     * Vraca listu analiza uputa
     * @return analize uputa, {@literal <}Analiza{@literal >}
     */
    public List<Analiza> getAnalize() {
        return analize;
    }
    /**
     * Postavlja listu analiza uputa
     * @param analize lista analiza
     */
    public void setAnalize(List<Analiza> analize) {
        this.analize = analize;
    }
    /**
     * Vraca vrednosti atributa klase Uput
     * @return String koji sadrzi vrednosti atributa odvojene zarezima 
     */
    @Override
    public String getAtrValue() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return sifraUputa + ", '" + formatter.format(datumUputa) + "', '"
                + uputnaDijagnoza + "', '" + lekar.getUsername() + "', '"
                + pacijent.getJmbg() + "'";
    }
    /**
     * Vraca vrednosti atributa klase Uput
     * @return String koji sadrzi vrednosti atributa u obliku "atribut=vrednost"
     */
    @Override
    public String setAtrValue() {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return "sifra_uputa=" + sifraUputa + ", datum_uputa='" + formatter.format(datumUputa) + "', uputna_dijagnoza='"
                + uputnaDijagnoza + "', sifra_lekara='" + lekar.getUsername() + "', jmbg='"
                + pacijent.getJmbg() + "'";
    }
    /**
     * Vraca ime klase Uput
     * @return naziv klase kao String
     */
    @Override
    public String getClassName() {
        return "Uput";
    }
    /**
     * Vraca String koji se koristi za specifikaciju uslova za povlacenje podataka iz baze podataka
     * @return String "jmbg = 'vrednost' ORDER BY sifra_uputa DESC";
     */
    @Override
    public String getWhereCondition() {
        return "jmbg = '" + pacijent.getJmbg().toString() + "' ORDER BY sifra_uputa DESC";
    }
    /**
     * Kreira i vraca novi objekat klase Uput
     * @param rs objekat ResultSet iz kod se izvlace vrednosti atributa novog Uputa
     * @return GeneralDObjekat objekat klase koja implementira interfejs GeneralDObjekat
     * @throws Exception ako je doslo do greske u konstruktoru KartonPacijenta
     */
    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws Exception {
        return new Uput(rs.getLong("sifra_uputa"), rs.getDate("datum_uputa"),
                rs.getString("uputna_dijagnoza"), new Lekar(rs.getString("sifra_lekara")),
                new KartonPacijenta(rs.getString("jmbg")));
    }
    /**
     * Vraca vrednosti atributa objekta klase Uput u Stringu
     * @return String u obliku "atribut=rezultat"
     */
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return "sifra_uputa=" + sifraUputa + ", datum_uputa='" + formatter.format(datumUputa) + "', uputna_dijagnoza='"
                + uputnaDijagnoza + "', sifra_lekara='" + lekar.getUsername() + "', jmbg='"
                + pacijent.getJmbg() + "'";
    }
    /**
     * Vraca String naziv polja u bazi podataka
     * @return String "sifra_uputa"
     */
    @Override
    public String getFields() {
        return "sifra_uputa";
    }
    /**
     * Vraca String koji se koristi za specifikaciju sortiranja redova iz baze podataka
     * @return String "sifra_uputa DESC"
     */
    @Override
    public String getOrderBy() {
        return "sifra_uputa DESC";
    }

}
