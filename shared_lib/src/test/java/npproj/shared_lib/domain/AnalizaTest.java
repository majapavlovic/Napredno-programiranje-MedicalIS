package npproj.shared_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AnalizaTest {
	Analiza a;
	ResultSet rs;
	
	@BeforeEach
	void setUp() throws Exception {
		a = new Analiza();
	}

	@AfterEach
	void tearDown() throws Exception {
		a=null;
	}

	@Test
	void testSetSifraAnalize() {
		a.setSifraAnalize(1l);
		assertEquals(1l, a.getSifraAnalize());
	}

	@Test
	void testSetVrstaAnalize() {
		a.setVrstaAnalize("Bakterioloska");
		assertEquals("Bakterioloska", a.getVrstaAnalize());
	}

	@Test
	void testSetVrstaUzorka() {
		a.setVrstaUzorka("Bris grla");
		assertEquals("Bris grla", a.getVrstaUzorka());
	}

	@Test
	void testSetUput() {
		Uput u = new Uput();
		u.setSifraUputa(1l);
		a.setUput(u);
		assertEquals(u, a
				.getUput());
	}

	@Test
	void testGetAtrValue() {
		a.setSifraAnalize(1l);
		a.setVrstaAnalize("Bakterioloska");
		a.setVrstaUzorka("Bris grla");
		Uput u = new Uput(2l);
		a.setUput(u);
		
		assertEquals("1, 'Bakterioloska', 'Bris grla', 2", a.getAtrValue());

	}

	@Test
	void testSetAtrValue() {
		a.setSifraAnalize(1l);
		a.setVrstaAnalize("Bakterioloska");
		a.setVrstaUzorka("Bris grla");
		Uput u = new Uput(2l);
		a.setUput(u);
		
		assertEquals("sifra_analize = 1, vrsta_analize='Bakterioloska', vrsta_uzorka='Bris grla', sifra_uputa=2", a.setAtrValue());	
	}


	@Test
	void testGetWhereCondition() {
		Uput u = new Uput(1l);
		a.setUput(u);
		
		assertEquals("sifra_uputa = 1", a.getWhereCondition());
	}

	@Test
	void testGetNewRecord() {
		try {

			rs = Mockito.mock(ResultSet.class);

			Mockito.when(rs.getLong("sifra_analize")).thenReturn(1l);
			Mockito.when(rs.getString("vrsta_analize")).thenReturn("Bakterioloska");
			Mockito.when(rs.getString("vrsta_uzorka")).thenReturn("Bris grla");
			Mockito.when(rs.getLong("sifra_uputa")).thenReturn(2l);


			Analiza analizaDummy = (Analiza) a.getNewRecord(rs);

			assertNotNull(analizaDummy);

			assertEquals(1l, analizaDummy.getSifraAnalize());
			assertEquals("Bakterioloska", analizaDummy.getVrstaAnalize());
			assertEquals("Bris grla", analizaDummy.getVrstaUzorka());
			assertEquals(2l, analizaDummy.getUput().getSifraUputa());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	void testToString() {
		a.setSifraAnalize(1l);
		a.setVrstaAnalize("Bakterioloska");
		a.setVrstaUzorka("Bris grla");
		
		assertEquals("sifra_analize = 1, vrsta_analize='Bakterioloska', vrsta_uzorka='Bris grla'", a.toString());
	}

}
