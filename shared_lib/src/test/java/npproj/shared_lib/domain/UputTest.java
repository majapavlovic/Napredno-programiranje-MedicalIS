package npproj.shared_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UputTest {
	Uput u;
	ResultSet rs;
	@BeforeEach
	void setUp() throws Exception {
		u = new Uput();
	}

	@AfterEach
	void tearDown() throws Exception {
		u = null;
	}

	@Test
	void testSetSifraUputa() {
		u.setSifraUputa(1l);
		assertEquals(1l, u.getSifraUputa());
	}

	@Test
	void testSetDatumUputa() {
		Date d = new Date(2022 - 1900, 8, 6);
		u.setDatumUputa(d);
		assertEquals(d, u.getDatumUputa());
	}

	@Test
	void testSetUputnaDijagnoza() {
		u.setUputnaDijagnoza("Bronhitis");
		assertEquals("Bronhitis", u.getUputnaDijagnoza());
	}

	@Test
	void testSetLekar() {
		Lekar l = new Lekar("majpav");
		u.setLekar(l);
		assertEquals(l, u.getLekar());
	}

	@Test
	void testSetPacijent() {
		KartonPacijenta p = new KartonPacijenta("2701996556841");
		u.setPacijent(p);
		assertEquals(p, u.getPacijent());
	}

	@Test
	void testSetAnalize() {

		Analiza a1 = new Analiza(1l);
		a1.setVrstaAnalize("Bakterioloska");
		a1.setVrstaUzorka("Bris grla");
		Analiza a2 = new Analiza(2l);
		a2.setVrstaAnalize("Virusoloska");
		a2.setVrstaUzorka("Bris grla");
		Analiza a3 = new Analiza(3l);
		a3.setVrstaAnalize("Bakterioloska");
		a3.setVrstaUzorka("Sputum");

		List<Analiza> analize = new ArrayList<>();
		analize.add(a1);
		analize.add(a2);
		analize.add(a3);

		u.setAnalize(analize);
		assertEquals(analize, u.getAnalize());
	}

	@Test
	void testGetAtrValue() {
		u.setSifraUputa(1l);
		Date d = new Date(2022 - 1900, 8, 6);
		u.setDatumUputa(d);
		u.setUputnaDijagnoza("Bronhitis");
		Lekar l = new Lekar("majpav");
		u.setLekar(l);
		KartonPacijenta p = new KartonPacijenta("2703996151354");
		u.setPacijent(p);
		assertEquals("1, '2022-09-06', 'Bronhitis', 'majpav', '2703996151354'", u.getAtrValue());
	}

	@Test
	void testSetAtrValue() {

		u.setSifraUputa(1l);
		Date d = new Date(2022 - 1900, 8, 6);
		u.setDatumUputa(d);
		u.setUputnaDijagnoza("Bronhitis");
		Lekar l = new Lekar("majpav");
		u.setLekar(l);
		KartonPacijenta p = new KartonPacijenta("2703996151354");
		u.setPacijent(p);

		assertEquals("sifra_uputa=1, datum_uputa='2022-09-06', "
				+ "uputna_dijagnoza='Bronhitis', sifra_lekara='majpav', jmbg='2703996151354'", u.setAtrValue());
	}

	@Test
	void testGetWhereCondition() {
		KartonPacijenta p = new KartonPacijenta("2703996485966");
		u.setPacijent(p);
		assertEquals("jmbg = '2703996485966' ORDER BY sifra_uputa DESC", u.getWhereCondition());
	}

	@Test
	void testGetNewRecord() {
		try {

			rs = Mockito.mock(ResultSet.class);

			Mockito.when(rs.getLong("sifra_uputa")).thenReturn(1l);
			Mockito.when(rs.getDate("datum_uputa")).thenReturn((java.sql.Date) new Date(2022-1900, 8, 6));
			Mockito.when(rs.getString("uputna_dijagnoza")).thenReturn("Bronhitis");
			Mockito.when(rs.getString("sifra_lekara")).thenReturn("majpav");
			Mockito.when(rs.getString("jmbg")).thenReturn("2703996458955");

			Uput uputDummy = (Uput) u.getNewRecord(rs);

			assertNotNull(uputDummy);

			assertEquals(1l, uputDummy.getSifraUputa());
			assertEquals("2022-09-06", uputDummy.getDatumUputa().toString());
			assertEquals("Bronhitis", uputDummy.getUputnaDijagnoza());
			assertEquals("majpav", uputDummy.getLekar().getUsername());
			assertEquals("2703996458955", uputDummy.getPacijent().getJmbg());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testToString() {
		u.setSifraUputa(1l);
		Date d = new Date(2022 - 1900, 8, 6);
		u.setDatumUputa(d);
		u.setUputnaDijagnoza("Bronhitis");
		Lekar l = new Lekar("majpav");
		u.setLekar(l);
		KartonPacijenta p = new KartonPacijenta("2703996151354");
		u.setPacijent(p);
		
		assertEquals("sifra_uputa=1, datum_uputa='2022-09-06', "
				+ "uputna_dijagnoza='Bronhitis', sifra_lekara='majpav', jmbg='2703996151354'", u.toString());
	}

}
