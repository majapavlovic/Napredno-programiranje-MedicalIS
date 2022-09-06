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
import org.mockito.Mockito;

class KartonPacijentaTest {
	KartonPacijenta pacijent;
	ResultSet rs;

	@BeforeEach
	void setUp() throws Exception {
		pacijent = new KartonPacijenta();
	}

	@AfterEach
	void tearDown() throws Exception {
		pacijent = null;
	}

	@Test
	void testSetJmbg() {
		pacijent.setJmbg("2703999715999");

		assertEquals("2703999715999", pacijent.getJmbg());
	}

	@Test
	void testSetLbo() {

		pacijent.setLbo("1112225091");

		assertEquals("1112225091", pacijent.getLbo());
	}

	@Test
	void testSetIme() {
		pacijent.setIme("Pera");

		assertEquals("Pera", pacijent.getIme());
	}

	@Test
	void testSetPrezime() {
		pacijent.setPrezime("Peric");

		assertEquals("Peric", pacijent.getPrezime());
	}

	@Test
	void testSetPol() {
		pacijent.setPol("Muski");
		
		assertEquals("Muski", pacijent.getPol());
	}

	@Test
	void testSetDatumRodjenja() {
		Date datumRodjenja = new Date(1999-1900, 2, 27);
		
		pacijent.setDatumRodjenja(datumRodjenja);
		assertEquals(datumRodjenja, pacijent.getDatumRodjenja());	
		
	}

	@Test
	void testSetAdresa() {
		pacijent.setAdresa("Jove Ilica 198a");
		assertEquals("Jove Ilica 198a", pacijent.getAdresa());
	}

	@Test
	void testSetKontaktTelefon() {
		pacijent.setKontaktTelefon("065 0000555");
		
		assertEquals("065 0000555", pacijent.getKontaktTelefon());
	}

	@Test
	void testSetKrvnaGrupa() {
		pacijent.setKrvnaGrupa("A+");
		assertEquals("A+", pacijent.getKrvnaGrupa());
	}

	@Test
	void testSetHronicneDijagnoze() {
		pacijent.setHronicneDijagnoze("Dijabetes");
		assertEquals("Dijabetes", pacijent.getHronicneDijagnoze());		
	}

	@Test
	void testSetUputi() {
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
	void testSetLekar() {
		Lekar l = new Lekar("majpav");
		pacijent.setLekar(l);
		assertEquals(l, pacijent.getLekar());
	}

	@Test
	void testGetAtrValue() {
		pacijent.setJmbg("2703999715999");
		pacijent.setLbo("5000506456");
		pacijent.setIme("Pera");
		pacijent.setPrezime("Peric");
		Date datumRodjenja = new Date(1999-1900, 2, 27);
		pacijent.setDatumRodjenja(datumRodjenja);
		pacijent.setPol("Muski");
		pacijent.setAdresa("Jove Ilica 198a");
		pacijent.setKontaktTelefon("069 0005555");
		pacijent.setKrvnaGrupa("A+");
		pacijent.setHronicneDijagnoze("Dijabetes");
		Lekar l = new Lekar("majpav");
		pacijent.setLekar(l);
		
		
		assertEquals("'2703999715999', '5000506456', 'Pera', 'Peric', '1999-03-27', "
				+ "'Muski', 'Jove Ilica 198a', '069 0005555', 'A+', 'Dijabetes', 'majpav'", pacijent.getAtrValue());
	}

	@Test
	void testSetAtrValue() {
		
		pacijent.setJmbg("2703999715999");
		pacijent.setLbo("5000506456");
		pacijent.setIme("Pera");
		pacijent.setPrezime("Peric");
		Date datumRodjenja = new Date(1999-1900, 2, 27);
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

	}


	@Test
	void testGetWhereCondition() {
		pacijent.setJmbg("2703999715999");
		
		assertEquals("jmbg = '2703999715999'", pacijent.getWhereCondition());
	}

	@Test
	void testGetNewRecord() {
		try {

			rs = Mockito.mock(ResultSet.class);

			Mockito.when(rs.getString("jmbg")).thenReturn("2703996459623");
			Mockito.when(rs.getString("lbo")).thenReturn("16574578945");
			Mockito.when(rs.getString("ime")).thenReturn("Pera");
			Mockito.when(rs.getString("prezime")).thenReturn("Peric");
			Mockito.when(rs.getString("pol")).thenReturn("Muski");
			Mockito.when(rs.getDate("datumrodjenja")).thenReturn(new java.sql.Date(1996-1900, 2, 27));
			Mockito.when(rs.getString("adresa")).thenReturn("Jove Ilica 198a");
			Mockito.when(rs.getString("kontakt_telefon")).thenReturn("0650000555");
			Mockito.when(rs.getString("krvna_grupa")).thenReturn("A+");
			Mockito.when(rs.getString("hronicne_dijagnoze")).thenReturn("Nema");
			Mockito.when(rs.getString("lekar")).thenReturn("majpav");

			KartonPacijenta pDummy =  (KartonPacijenta) pacijent.getNewRecord(rs);

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
	void testToString() {
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
	}

	@Test
	void testGetWhereCondition1() {
		pacijent.setJmbg("2703999715999");
		Lekar l = new Lekar("majpav");
		pacijent.setLekar(l);
		
		assertEquals("jmbg = '2703999715999' AND lekar='majpav'", pacijent.getWhereCondition1());
	}

}
