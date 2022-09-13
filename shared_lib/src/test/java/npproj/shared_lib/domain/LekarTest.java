package npproj.shared_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LekarTest {
	Lekar l;
	ResultSet rs;

	@BeforeEach
	public void setUp() throws Exception {
		l = new Lekar();
	}

	@AfterEach
	public void tearDown() throws Exception {
		l = null;
	}

	@Test
	public void testSetIme() {
		l.setIme("Pera");
		assertEquals("Pera", l.getIme());
	}

	@Test
	public void testSetPrezime() {
		l.setPrezime("Peric");
		assertEquals("Peric", l.getPrezime());
	}

	@Test
	public void testSetUsername() {
		l.setUsername("pperic");
		assertEquals("pperic", l.getUsername());
	}

	@Test
	public void testSetPassword() {
		l.setPassword("pass1234");
		assertEquals("pass1234", l.getPassword());
	}

	@Test
	public void testGetAtrValue() {
		l.setIme("Pera");
		l.setPrezime("Peric");
		l.setUsername("pperic");
		l.setPassword("pass1234");
		
		assertEquals("'pperic', 'pass1234', 'Pera', 'Peric'", l.getAtrValue());
	}

	@Test
	public void testSetAtrValue() {
		l.setIme("Pera");
		l.setPrezime("Peric");
		l.setUsername("pperic");
		l.setPassword("pass1234");

		assertEquals("korisnicko_ime='pperic', korisnicka_sifra='pass1234', ime='Pera', prezime='Peric'", l.setAtrValue());
	}

	@Test
	public void testGetWhereCondition() {
		l.setUsername("pperic");
		l.setPassword("pass1234");
        assertEquals("korisnicko_ime='pperic' AND korisnicka_sifra='pass1234'", l.getWhereCondition());

	}

	@Test
	public void testGetNewRecord() {
		try {
			rs = Mockito.mock(ResultSet.class);
	
			Mockito.when(rs.getString("korisnicko_ime")).thenReturn("pperic");
			Mockito.when(rs.getString("korisnicka_sifra")).thenReturn("pass1234");
			Mockito.when(rs.getString("ime")).thenReturn("Pera");
			Mockito.when(rs.getString("prezime")).thenReturn("Peric");
	
			Lekar lekarDummy = (Lekar) l.getNewRecord(rs);
	
			assertNotNull(lekarDummy);
	
			assertEquals("pperic", lekarDummy.getUsername());
			assertEquals("pass1234", lekarDummy.getPassword());
			assertEquals("Pera", lekarDummy.getIme());
			assertEquals("Peric", lekarDummy.getPrezime());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetWhereCondition1() {
		l.setUsername("pperic");
		assertEquals("korisnicko_ime='pperic'", l.getWhereCondition1());
	}

}
