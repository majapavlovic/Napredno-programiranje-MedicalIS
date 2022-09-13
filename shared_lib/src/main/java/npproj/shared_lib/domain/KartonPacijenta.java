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
 * Klasa koja predstavlja karton pacijenta Kartone pacijenata kreira Lekar
 * 
 * @author Maja
 */
public class KartonPacijenta implements Serializable, GeneralDObject {

	/**
	 * Jmbg pacijenta kao String
	 */
	String jmbg;
	/**
	 * Lbo pacijenta kao String
	 */
	String lbo;
	/**
	 * Ime pacijenta kao String
	 */
	String ime;
	/**
	 * Prezime pacijenta kao String
	 */
	String prezime;
	/**
	 * Pol pacijenta kao String
	 */
	String pol;
	/**
	 * Datum rodjenja pacijenta kao Date
	 */
	Date datumRodjenja;
	/**
	 * Adresa pacijenta kao String
	 */
	String adresa;
	/**
	 * Kontakt telefona pacijenta kao String
	 */
	String kontaktTelefon;
	/**
	 * Krvna grupa pacijenta kao String
	 */
	String krvnaGrupa;
	/**
	 * Hronicna dijagnoza pacijenta kao String
	 */
	String hronicneDijagnoze;
	/**
	 * Lekar pacijenta, objekat klase Lekar
	 */
	Lekar lekar;
	/**
	 * Lista uputa pacijenta List{@literal <}Uput{@literal >}
	 */
	List<Uput> uputi;

	/**
	 * Konstruktor bez parametara
	 */
	public KartonPacijenta() {
	}

	/**
	 * Parametarski konstruktor koji postavlja jmbg pacijenta
	 * 
	 * @param jmbg jmbg pacijenta
	 * @throws Exception ukoliko vrednost jmbg nije validna
	 */
	public KartonPacijenta(String jmbg) throws Exception {
		if (jmbg.isEmpty())
			throw new Exception("JMBG je obavezno polje!");
		if (jmbg.length() != 13)
			throw new Exception("Duzina JMBG mora biti tacno 13!");
		try {
			Long l = Long.valueOf(jmbg);
		} catch (Exception ex) {
			throw new Exception("JMBG mora da se sastoji samo od cifara!");
		}
		this.jmbg = jmbg;
	}

	/**
	 * Parametarski konstruktor koji postavlja atribute pacijenta
	 * 
	 * @param jmbg              jmbg pacijenta
	 * @param lbo               lbo pacijenta
	 * @param ime               ime pacijenta
	 * @param prezime           prezime pacijenta
	 * @param pol               pol pacijenta
	 * @param datumRodjenja     datum rodjenja pacijenta
	 * @param adresa            adresa pacijenta
	 * @param kontaktTelefon    kontakt telefon pacijenta
	 * @param krvnaGrupa        krvna grupa pacijenta
	 * @param hronicneDijagnoze hronicne dijagnoze pacijenta
	 * @param lekar             Lekar pacijenta
	 * @throws Exception ako nisu prosledjeni validni podaci
	 */
	public KartonPacijenta(String jmbg, String lbo, String ime, String prezime, String pol, Date datumRodjenja,
			String adresa, String kontaktTelefon, String krvnaGrupa, String hronicneDijagnoze, Lekar lekar) throws Exception {
		if (jmbg.isEmpty() || lbo.isEmpty() || ime.isEmpty() || prezime.isEmpty() || datumRodjenja == null
				|| pol.isEmpty() || krvnaGrupa.isEmpty() || lekar == null) {
			throw new Exception("Niste uneli sve obavezne parametre!");
		}
		if (jmbg.toString().trim().length() != 13) {
			throw new Exception("Duzina JMBG-a mora biti tacno 13 cifara!");
		}
		if (lbo.toString().length() != 11) {
			throw new Exception("Duzina LBO-a mora biti tacno 11 cifara!");
		}
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyy");
		String datum = formatter.format(datumRodjenja);

		if (!(datum.substring(0, 4) + datum.substring(5)).equals(jmbg.toString().substring(0, 7))) {
			throw new Exception("Datum rodjenja i JMBG se ne poklapaju!");
		}
		this.jmbg = jmbg;
		this.lbo = lbo;
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.kontaktTelefon = kontaktTelefon;
		this.krvnaGrupa = krvnaGrupa;
		this.hronicneDijagnoze = hronicneDijagnoze;
		this.lekar = lekar;
	}

	/**
	 * Vraca vrednost atributa jmbg
	 * 
	 * @return jmbg pacijenta kao String
	 */
	public String getJmbg() {
		return jmbg;
	}

	/**
	 * Postavlja vrednost atributa jmbg
	 * 
	 * @param jmbg jmbg pacijenta
	 * @throws Exception ako vrednost JMBG nije validna
	 */
	public void setJmbg(String jmbg) throws Exception {
		if (jmbg.isEmpty())
			throw new Exception("JMBG je obavezno polje!");
		if (jmbg.length() != 13)
			throw new Exception("Duzina JMBG mora biti tacno 13!");
		try {
			Long l = Long.valueOf(jmbg);
		} catch (Exception ex) {
			throw new Exception("JMBG mora da se sastoji samo od cifara!");
		}
		this.jmbg = jmbg;
	}

	/**
	 * Vraca vrednost atributa lbo
	 * 
	 * @return lbo pacijenta kao String
	 */
	public String getLbo() {
		return lbo;
	}

	/**
	 * Postavlja vrednost atributa lbo
	 * 
	 * @param lbo lbo pacijenta
	 * @throws Exception ukoliko vrednost LBO nije validna
	 */
	public void setLbo(String lbo) throws Exception {
		if (lbo.isEmpty())
			throw new Exception("LBO je obavezno polje!");
		if (lbo.length() != 11)  
			throw new Exception("Duzina LBO mora biti tacno 11!");
		try {
			Long l = Long.valueOf(lbo);
		} catch (Exception ex) {
			throw new Exception("LBO mora da se sastoji samo od cifara!");
		}
		this.lbo = lbo;
	}

	/**
	 * Vraca vrednost atributa ime
	 * 
	 * @return ime pacijenta kao String
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja vrednost atributa ime
	 * 
	 * @param ime ime pacijenta
	 * @throws Exception ako je ime prazno
	 */
	public void setIme(String ime) throws Exception {
		if (ime.isEmpty())
			throw new Exception("Ime je obavezno polje!");
		this.ime = ime;
	}

	/**
	 * Vraca vrednost atributa prezime
	 * 
	 * @return prezime pacijenta kao String
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja vrednost atributa prezime
	 * 
	 * @param prezime prezime pacijenta
	 * @throws Exception ako je ime prazno
	 */
	public void setPrezime(String prezime) throws Exception {
		if (prezime.isEmpty())
			throw new Exception("Prezime je obavezno polje!");
		this.prezime = prezime;
	}

	/**
	 * Vraca vrednost atributa pol
	 * 
	 * @return pol pacijenta kao String
	 */
	public String getPol() {
		return pol;
	}

	/**
	 * Postavlja vrednost atributa pol
	 * 
	 * @param pol pol pacijenta
	 * @throws Exception ako je vrednost pola nije validna
	 */
	public void setPol(String pol) throws Exception {
		if (!pol.equals("Muski") && !pol.equals("Zenski") && !pol.equals("Nije odredjeno"))
			throw new Exception("Nije validna vrednost pola!");
		this.pol = pol;
	}

	/**
	 * Vraca vrednost atributa datumRodjenja
	 * 
	 * @return datumRodjenja kao Date
	 */
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	/**
	 * Postavlja vrednost atributa datumRodjenja
	 * 
	 * @param datumRodjenja datum rodjenja pacijenta
	 */
	public void setDatumRodjenja(Date datumRodjenja) {
		if(datumRodjenja == null)
			throw new NullPointerException();
		this.datumRodjenja = datumRodjenja;
	}

	/**
	 * Vraca vrednost atributa Adresa
	 * 
	 * @return adresa pacijenta kao String
	 */
	public String getAdresa() {
		return adresa;
	}

	/**
	 * Postavlja vrednost atributa adresa
	 * 
	 * @param adresa adresa pacijenta
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	/**
	 * Vraca vrednost atributa kontaktTelefon
	 * 
	 * @return kontaktTelefona pacijenta kao String
	 */
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	/**
	 * Postavlja vrednost atributa kontaktTelefon
	 * 
	 * @param kontaktTelefon kontakt telefon pacijenta
	 */
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	/**
	 * Vraca vrednost atributa krvnaGrupa
	 * 
	 * @return krvnaGrupa pacijenta kao String
	 */
	public String getKrvnaGrupa() {
		return krvnaGrupa;
	}

	/**
	 * Postavlja vrednost atributa krvnaGrupa
	 * 
	 * @param krvnaGrupa krvna grupa pacijenta
	 */
	public void setKrvnaGrupa(String krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}

	/**
	 * Vraca vrednost atributa hronicneDijagnoze
	 * 
	 * @return hronicneDijagnoze pacijenta kao String
	 */
	public String getHronicneDijagnoze() {
		return hronicneDijagnoze;
	}

	/**
	 * Postavlja vrednost atributa hronicneDijagnoze
	 * 
	 * @param hronicneDijagnoze hronicne dijagnoze pacijenta
	 */
	public void setHronicneDijagnoze(String hronicneDijagnoze) {
		this.hronicneDijagnoze = hronicneDijagnoze;
	}

	/**
	 * Vraca listu uputa pacijenta
	 * 
	 * @return uputi pacijenta kao List{@literal <}Uput{@literal >}
	 */
	public List<Uput> getUputi() {
		return uputi;
	}

	/**
	 * Postavlja listu uputa pacijenta
	 * 
	 * @param uputi lista uputa pacijenta
	 */
	public void setUputi(List<Uput> uputi) {
		this.uputi = uputi;
	}

	/**
	 * Vraca lekara pacijenta
	 * 
	 * @return lekar pacijenta, objekat klase Lekar
	 */
	public Lekar getLekar() {
		return lekar;
	}

	/**
	 * Postavlja vrednost atributa Lekar
	 * 
	 * @param lekar lekar pacijenta
	 */
	public void setLekar(Lekar lekar) {
		if (lekar == null) {
			throw new NullPointerException();
		}
		this.lekar = lekar;
	}

	/**
	 * Vraca vrednosti atributa klase KartonPacijenta
	 * 
	 * @return String koji sadrzi vrednosti atributa odvojene zarezima
	 */
	@Override
	public String getAtrValue() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return "'" + jmbg.toString() + "', '" + lbo.toString() + "', '" + ime + "', '" + prezime + "', '"
				+ formatter.format(datumRodjenja) + "', '" + pol.toString() + "', '" + adresa + "', '" + kontaktTelefon
				+ "', '" + krvnaGrupa.toString() + "', '" + hronicneDijagnoze + "', '" + lekar.getUsername() + "'";
	}

	/**
	 * Vraca vrednosti atributa klase KartonPacijenta
	 * 
	 * @return String koji sadrzi vrednosti atributa u obliku "atribut=vrednost"
	 */
	@Override
	public String setAtrValue() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return "jmbg= '" + jmbg + "', lbo='" + lbo + "', ime='" + ime + "', prezime='" + prezime + "', pol='"
				+ pol.toString() + "', datumrodjenja='" + formatter.format(datumRodjenja) + "', adresa='" + adresa
				+ "', kontakt_telefon='" + kontaktTelefon + "', krvna_grupa='" + krvnaGrupa.toString()
				+ "', hronicne_dijagnoze='" + hronicneDijagnoze + "', lekar='" + lekar.getUsername() + "'";
	}

	/**
	 * Vraca ime klase KartonPacijenta
	 * 
	 * @return naziv klase kao String
	 */
	@Override
	public String getClassName() {
		return "KartonPacijenta";
	}

	/**
	 * Vraca jmbg pacijenta kao deo Stringa
	 * 
	 * @return String u obliku "jmbg=jmbg"
	 */
	@Override
	public String getWhereCondition() {
		return "jmbg = '" + jmbg + "'";
	}

	/**
	 * Kreira i vraca novi objekat klase KartonPacijenta
	 * 
	 * @param rs objekat ResultSet iz kod se izvlace vrednosti atributa novog
	 *           kartonPacijenta
	 * @return GeneralDObjekat objekat klase koja implementira interfejs
	 *         GeneralDObjekat
	 * @throws Exception 
	 * @throws SQLException 
	 */
	@Override
	public GeneralDObject getNewRecord(ResultSet rs) throws SQLException, Exception {
		return new KartonPacijenta(rs.getString("jmbg"), rs.getString("lbo"), rs.getString("ime"),
				rs.getString("prezime"), rs.getString("pol"), rs.getDate("datumrodjenja"), rs.getString("adresa"),
				rs.getString("kontakt_telefon"), rs.getString("krvna_grupa"), rs.getString("hronicne_dijagnoze"),
				new Lekar(rs.getString("lekar")));
	}

	/**
	 * Vraca vrednosti atributa klase KartonPacijenta
	 * 
	 * @return String koji sadrzi vrednosti atributa u obliku "atribut=vrednost"
	 */
	@Override
	public String toString() {
		return "jmbg= '" + jmbg + "', lbo='" + lbo + "', ime='" + ime + "', prezime='" + prezime + "', pol='"
				+ ((pol == null) ? "" : pol.toString()) + "', datumrodjenja='"
				+ ((datumRodjenja == null) ? "" : datumRodjenja.toString()) + "', adresa='" + adresa
				+ "', kontakt_telefon='" + kontaktTelefon + "', krvna_grupa='" + krvnaGrupa!=null?krvnaGrupa.toString():""
				+ "', hronicne_dijagnoze='" + hronicneDijagnoze + "', lekar=" + lekar.getIme() + " "
				+ lekar.getPrezime();
	}

	/**
	 * Vraca vrednosti atributa jmbg i lekar
	 * 
	 * @return jmbg pacijenta i username lekara pacijenta
	 */
	@Override
	public String getWhereCondition1() {
		return "jmbg = '" + jmbg + "' AND lekar='" + lekar.getUsername() + "'";
	}

}
