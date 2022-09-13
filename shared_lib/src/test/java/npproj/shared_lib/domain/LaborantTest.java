package npproj.shared_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LaborantTest {
	Laborant l;
	ResultSet rs;

	@BeforeEach
	public void setUp() throws Exception {
		l=new Laborant();
	}

	@AfterEach
	public void tearDown() throws Exception {
		l=null;
	}

	@Test
	public void testSetIme() {
		l.setIme("Mara");
		assertEquals("Mara", l.getIme());
	}

	@Test
	public void testSetPrezime() {
		l.setPrezime("Maric");
		assertEquals("Maric", l.getPrezime());
	}

	@Test
	public void testSetUsername() {
		l.setUsername("mmaric");
		assertEquals("mmaric", l.getUsername());
	}

	@Test
	public void testSetPassword() {
		l.setPassword("pass1234");
		assertEquals("pass1234", l.getPassword());
	}

	@Test
	public void testGetAtrValue() {
		l.setIme("Mara");
		l.setPrezime("Maric");
		l.setUsername("mmaric");
		l.setPassword("pass1234");
		
		assertEquals("'mmaric', 'pass1234', 'Mara', 'Maric'", l.getAtrValue());

	}

	@Test
	public void testSetAtrValue() {
		l.setIme("Mara");
		l.setPrezime("Maric");
		l.setUsername("mmaric");
		l.setPassword("pass1234");

		assertEquals("korisnicko_ime='mmaric', korisnicka_sifra='pass1234', ime='Mara', prezime='Maric'", l.setAtrValue());
	}

	@Test
	public void testGetWhereCondition() {
		l.setUsername("mmaric");
		l.setPassword("pass1234");
        assertEquals("korisnicko_ime='mmaric' AND korisnicka_sifra='pass1234'", l.getWhereCondition());

	}

	@Test
	public void testGetNewRecord() {
		try {
			rs = Mockito.mock(ResultSet.class);
	
			Mockito.when(rs.getString("korisnicko_ime")).thenReturn("mmaric");
			Mockito.when(rs.getString("korisnicka_sifra")).thenReturn("pass1234");
			Mockito.when(rs.getString("ime")).thenReturn("Mara");
			Mockito.when(rs.getString("prezime")).thenReturn("Maric");
	
			Laborant labDummy = (Laborant) l.getNewRecord(rs);
	
			assertNotNull(labDummy);
	
			assertEquals("mmaric", labDummy.getUsername());
			assertEquals("pass1234", labDummy.getPassword());
			assertEquals("Mara", labDummy.getIme());
			assertEquals("Maric", labDummy.getPrezime());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetWhereCondition1() {
		l.setUsername("mmaric");
		assertEquals("korisnicko_ime='mmaric'", l.getWhereCondition1());
	}

}
