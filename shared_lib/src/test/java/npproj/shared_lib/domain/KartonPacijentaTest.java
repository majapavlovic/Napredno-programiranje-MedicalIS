package npproj.shared_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class KartonPacijentaTest {
	KartonPacijenta pacijent;
	ResultSet rs;

	@BeforeEach
	public void setUp() throws Exception {
		pacijent = new KartonPacijenta();
	}

	@AfterEach
	public void tearDown() throws Exception {
		pacijent = null;
	}

	@ParameterizedTest
	@CsvSource({
			" '2703999715999', '5000506456', '', 'Peric', 1999, 3, 27, 'Muski', 'Jove Ilica 198a', '0690005555', 'A+', 'Dijabetes', 'majpav', 'Niste uneli sve obavezne parametre!'",
			" '27039997155955', '50005064564', 'Pera', 'Peric', 1999, 3, 27, 'Muski', 'Jove Ilica 198a', '0690005555', 'A+', 'Dijabetes', 'majpav', 'Duzina JMBG-a mora biti tacno 13 cifara!'",
			" '2708999715999', '500050', 'Pera', 'Peric', 1999, 3, 27, 'Muski', 'Jove Ilica 198a', '0690005555', 'A+', 'Dijabetes', 'majpav', 'Duzina LBO-a mora biti tacno 11 cifara!'",
			" '2708999715999', '50005045912', 'Pera', 'Peric', 1999, 3, 7, 'Muski', 'Jove Ilica 198a', '0690005555', 'A+', 'Dijabetes', 'majpav', 'Datum rodjenja i JMBG se ne poklapaju!'" })
	public void testParametrisedKartonPacijenta(String jmbg, String lbo, String ime, String prezime, int god,
			int mes, int dan, String pol, String adresa, String tel, String krvnaGr, String hron, String lekar,
			String errMess) {

		try {			
			Date datumRodjenja = new Date(god - 1900, mes - 1, dan);;

			Lekar l = new Lekar(lekar);
			Exception thrown = assertThrows(java.lang.Exception.class, 
					() -> new KartonPacijenta(jmbg, lbo, ime,
					prezime, pol, datumRodjenja, adresa, tel, krvnaGr, hron, l));
			assertEquals(errMess, thrown.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSetJmbg() {
		try {
			pacijent.setJmbg("2703999715999");
			assertEquals("2703999715999", pacijent.getJmbg());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetJmbgShort() {
		try {
			Exception thrown = assertThrows(java.lang.Exception.class, () -> pacijent.setJmbg("270399971599"));
			assertEquals("Duzina JMBG mora biti tacno 13!", thrown.getMessage());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetJmbgLong() {
		try {
			Exception thrown = assertThrows(java.lang.Exception.class, () -> pacijent.setJmbg("27039997159999"));
			assertEquals("Duzina JMBG mora biti tacno 13!", thrown.getMessage());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetJmbgChar() {
		try {
			Exception thrown = assertThrows(java.lang.Exception.class, () -> pacijent.setJmbg("2703996485aaa"));
			assertEquals("JMBG mora da se sastoji samo od cifara!", thrown.getMessage());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetLbo() {
		try {

			pacijent.setLbo("1112225091");

			assertEquals("1112225091", pacijent.getLbo());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSetLboLong() {
		try {

			Exception thrown = assertThrows(java.lang.Exception.class, () -> pacijent.setLbo("111122223334"));

			assertEquals("Duzina LBO mora biti tacno 11!", thrown.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSetLboShort() {
		try {
			Exception thrown = assertThrows(java.lang.Exception.class, () -> pacijent.setLbo("111122"));

			assertEquals("Duzina LBO mora biti tacno 11!", thrown.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSetLboChar() {
		try {
			Exception thrown = assertThrows(java.lang.Exception.class, () -> pacijent.setLbo("111122aaaaa"));

			assertEquals("LBO mora da se sastoji samo od cifara!", thrown.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSetIme() {
		try {
			pacijent.setIme("Pera");
			assertEquals("Pera", pacijent.getIme());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSetImeEmptyString() {
		try {

			Exception thrown = assertThrows(java.lang.Exception.class, () -> pacijent.setIme(""));
			assertEquals("Ime je obavezno polje!", thrown.getMessage());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSetPrezime() {
		try {
			pacijent.setPrezime("Peric");

			assertEquals("Peric", pacijent.getPrezime());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSetPrezimeEmptyString() {
		try {

			Exception thrown = assertThrows(java.lang.Exception.class, () -> pacijent.setPrezime(""));
			assertEquals("Prezime je obavezno polje!", thrown.getMessage());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetPol() {
		try {
			pacijent.setPol("Muski");

			assertEquals("Muski", pacijent.getPol());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSetPolWrongValue() {
		try {

			Exception thrown1 = assertThrows(java.lang.Exception.class, () -> pacijent.setPol(""));
			Exception thrown2 = assertThrows(java.lang.Exception.class, () -> pacijent.setPol("M"));

			assertEquals("Nije validna vrednost pola!", thrown1.getMessage());
			assertEquals("Nije validna vrednost pola!", thrown2.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSetDatumRodjenja() {
		Date datumRodjenja = new Date(1999 - 1900, 2, 27);

		pacijent.setDatumRodjenja(datumRodjenja);
		assertEquals(datumRodjenja, pacijent.getDatumRodjenja());

	}
	@Test
	public void testSetDatumRodjenjaNull() {
		assertThrows(java.lang.NullPointerException.class, () -> pacijent.setDatumRodjenja(null));

	}

	@Test
	public void testSetAdresa() {
		pacijent.setAdresa("Jove Ilica 198a");
		assertEquals("Jove Ilica 198a", pacijent.getAdresa());
	}

	@Test
	public void testSetKontaktTelefon() {
		pacijent.setKontaktTelefon("065 0000555");

		assertEquals("065 0000555", pacijent.getKontaktTelefon());
	}

	@Test
	public void testSetKrvnaGrupa() {
		pacijent.setKrvnaGrupa("A+");
		assertEquals("A+", pacijent.getKrvnaGrupa());
	}

	@Test
	public void testSetHronicneDijagnoze() {
		pacijent.setHronicneDijagnoze("Dijabetes");
		assertEquals("Dijabetes", pacijent.getHronicneDijagnoze());
	}

	@Test
	public void testSetUputi() {
		List<Uput> uputi = new ArrayList<>();
		Uput u1 = new Uput(1l);
		Uput u2 = new Uput(2l);
		Uput u3 = new Uput(3l);
		Uput u4 = new Uput(4l);
		uputi.add(u1);
		uputi.add(u2);
		uputi.add(u3);
		uputi.add(u4);
		pacijent.setUputi(uputi);
		assertEquals(uputi, pacijent.getUputi());

	}

	@Test
	public void testSetLekar() throws Exception {
		Lekar l = new Lekar("majpav");
		pacijent.setLekar(l);
		assertEquals(l, pacijent.getLekar());
	}

	@Test
	public void testGetAtrValue() {
		try {
			pacijent.setJmbg("2703999715999");
			pacijent.setLbo("5000506456");
			pacijent.setIme("Pera");
			pacijent.setPrezime("Peric");
			Date datumRodjenja = new Date(1999 - 1900, 2, 27);
			pacijent.setDatumRodjenja(datumRodjenja);
			pacijent.setPol("Muski");
			pacijent.setAdresa("Jove Ilica 198a");
			pacijent.setKontaktTelefon("069 0005555");
			pacijent.setKrvnaGrupa("A+");
			pacijent.setHronicneDijagnoze("Dijabetes");
			Lekar l = new Lekar("majpav");
			pacijent.setLekar(l);

			assertEquals(
					"'2703999715999', '5000506456', 'Pera', 'Peric', '1999-03-27', "
							+ "'Muski', 'Jove Ilica 198a', '069 0005555', 'A+', 'Dijabetes', 'majpav'",
					pacijent.getAtrValue());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testSetAtrValue() {
		try {
			pacijent.setJmbg("2703999715999");
			pacijent.setLbo("5000506456");
			pacijent.setIme("Pera");
			pacijent.setPrezime("Peric");
			Date datumRodjenja = new Date(1999 - 1900, 2, 27);
			pacijent.setDatumRodjenja(datumRodjenja);
			pacijent.setPol("Muski");
			pacijent.setAdresa("Jove Ilica 198a");
			pacijent.setKontaktTelefon("069 0005555");
			pacijent.setKrvnaGrupa("A+");
			pacijent.setHronicneDijagnoze("Dijabetes");
			Lekar l = new Lekar("majpav");
			pacijent.setLekar(l);

			assertEquals("jmbg= '2703999715999', lbo='5000506456', ime='Pera', prezime='Peric', pol='Muski', "
					+ "datumrodjenja='1999-03-27', adresa='Jove Ilica 198a', kontakt_telefon='069 0005555', krvna_grupa='A+', "
					+ "hronicne_dijagnoze='Dijabetes', lekar='majpav'", pacijent.setAtrValue());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	public void testGetWhereCondition() {
		try {
			pacijent.setJmbg("2703999715999");

			assertEquals("jmbg = '2703999715999'", pacijent.getWhereCondition());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testGetNewRecord() {
		try {

			rs = Mockito.mock(ResultSet.class);

			Mockito.when(rs.getString("jmbg")).thenReturn("2703996459623");
			Mockito.when(rs.getString("lbo")).thenReturn("16574578945");
			Mockito.when(rs.getString("ime")).thenReturn("Pera");
			Mockito.when(rs.getString("prezime")).thenReturn("Peric");
			Mockito.when(rs.getString("pol")).thenReturn("Muski");
			Mockito.when(rs.getDate("datumrodjenja")).thenReturn(new java.sql.Date(1996 - 1900, 2, 27));
			Mockito.when(rs.getString("adresa")).thenReturn("Jove Ilica 198a");
			Mockito.when(rs.getString("kontakt_telefon")).thenReturn("0650000555");
			Mockito.when(rs.getString("krvna_grupa")).thenReturn("A+");
			Mockito.when(rs.getString("hronicne_dijagnoze")).thenReturn("Nema");
			Mockito.when(rs.getString("lekar")).thenReturn("majpav");

			KartonPacijenta pDummy = (KartonPacijenta) pacijent.getNewRecord(rs);

			assertNotNull(pDummy);

			assertEquals("2703996459623", pDummy.getJmbg());
			assertEquals("16574578945", pDummy.getLbo());
			assertEquals("Pera", pDummy.getIme());
			assertEquals("Peric", pDummy.getPrezime());
			assertEquals("Muski", pDummy.getPol());
			assertEquals("1996-03-27", pDummy.getDatumRodjenja().toString());
			assertEquals("Jove Ilica 198a", pDummy.getAdresa());
			assertEquals("0650000555", pDummy.getKontaktTelefon());
			assertEquals("A+", pDummy.getKrvnaGrupa());
			assertEquals("majpav", pDummy.getLekar().getUsername());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testToString() {
		try {
			pacijent.setJmbg("2703999715999");
			pacijent.setLbo("5000506456");
			pacijent.setIme("Pera");
			pacijent.setPrezime("Peric");
			pacijent.setAdresa("Jove Ilica 198a");
			pacijent.setKontaktTelefon("069 0005555");
			pacijent.setKrvnaGrupa("A+");
			pacijent.setHronicneDijagnoze("Dijabetes");
			Lekar l = new Lekar();
			l.setIme("Maja");
			l.setPrezime("Pavlovic");
			pacijent.setLekar(l);

			assertEquals("jmbg= '2703999715999', lbo='5000506456', ime='Pera', prezime='Peric', pol='', "
					+ "datumrodjenja='', adresa='Jove Ilica 198a', kontakt_telefon='069 0005555', krvna_grupa='A+', "
					+ "hronicne_dijagnoze='Dijabetes', lekar=Maja Pavlovic", pacijent.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void testGetWhereCondition1() {
		try {
			pacijent.setJmbg("2703999715999");
			Lekar l = new Lekar("majpav");
			pacijent.setLekar(l);

			assertEquals("jmbg = '2703999715999' AND lekar='majpav'", pacijent.getWhereCondition1());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
