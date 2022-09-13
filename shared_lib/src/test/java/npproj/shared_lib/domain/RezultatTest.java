package npproj.shared_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RezultatTest {
	Rezultat r;
	ResultSet rs;

	@BeforeEach
	public void setUp() throws Exception {
		r = new Rezultat();
	}

	@AfterEach
	public void tearDown() throws Exception {
		r=null;
	}

	@Test
	public void testSetSifra_rezultata() {
		r.setSifra_rezultata(111l);
		
		assertEquals(111l, r.getSifra_rezultata());
	}

	@Test
	public void testSetAnaliza() {
		Analiza a = new Analiza(1l);
		r.setAnaliza(a);
		
		assertEquals(a, r.getAnaliza());
	}

	@Test
	public void testSetRezultat_analize() {
		r.setRezultat_analize("Rezultat");
		
		assertEquals("Rezultat", r.getRezultat_analize());
	}

	@Test
	public void testSetDatumIzdavanja() {
		Date d = new Date(2022-1900, 8, 3);
		
		r.setDatumIzdavanja(d);
		assertEquals(d,  r.getDatumIzdavanja());
	}

	@Test
	public void testSetLaborant() {
		Laborant l = new Laborant("majpav");
		
		r.setLaborant(l);
		assertEquals(l,  r.getLaborant());
	}

	@Test
	public void testGetAtrValue() {		
        r.setSifra_rezultata(1l);
        r.setRezultat_analize("Rezultat");
        Date d = new Date(2022-1900, 8, 3);
        Laborant l = new Laborant("majpav");
        Analiza a = new Analiza(2l);
        r.setDatumIzdavanja(d);
        r.setLaborant(l);
        r.setAnaliza(a);
        
        assertEquals("1, 'Rezultat', '2022-09-03', 'majpav', 2", r.getAtrValue());
	}

	@Test
	public void testSetAtrValue() {
		
		r.setSifra_rezultata(1l);
        r.setRezultat_analize("Rezultat");
        Date d = new Date(2022-1900, 8, 3);
        Laborant l = new Laborant("majpav");
        Analiza a = new Analiza(2l);
        r.setDatumIzdavanja(d);
        r.setLaborant(l);
        r.setAnaliza(a);
        
        assertEquals("sifra_rezultata=1, rezultat_analize='Rezultat', datum_izdavanja='2022-09-03', laborant='majpav', sifra_analize=2", r.setAtrValue());
	}

	@Test
	public void testGetWhereCondition() {
		Analiza a = new Analiza(1l);
		r.setAnaliza(a);
		assertEquals("sifra_analize = 1", r.getWhereCondition());
	}

	@Test
	public void testGetNewRecord() {
		try {

			rs = Mockito.mock(ResultSet.class);

			Mockito.when(rs.getLong("sifra_rezultata")).thenReturn(1l);
			Mockito.when(rs.getString("rezultat_analize")).thenReturn("Izolovana je normalna flora.");
			Mockito.when(rs.getDate("datum_izdavanja")).thenReturn(new Date(2022-1900, 8, 6));
			Mockito.when(rs.getString("laborant")).thenReturn("majpav");
			Mockito.when(rs.getLong("sifra_analize")).thenReturn(2l);

			Rezultat rezDummy = (Rezultat) r.getNewRecord(rs);

			assertNotNull(rezDummy);

			assertEquals(1l, rezDummy.getSifra_rezultata());
			assertEquals("2022-09-06", rezDummy.getDatumIzdavanja().toString());
			assertEquals("Izolovana je normalna flora.", rezDummy.getRezultat_analize());
			assertEquals("majpav", rezDummy.getLaborant().getUsername());
			assertEquals(2l, rezDummy.getAnaliza().getSifraAnalize());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testToString() {
		r.setSifra_rezultata(1l);
        r.setRezultat_analize("Rezultat");
        Date d = new Date(2022-1900, 8, 3);
        r.setDatumIzdavanja(d);
        
        assertEquals("sifra_rezultata=1, rezultat_analize='Rezultat', datum_izdavanja='2022-09-03'", r.toString());
	}

}
