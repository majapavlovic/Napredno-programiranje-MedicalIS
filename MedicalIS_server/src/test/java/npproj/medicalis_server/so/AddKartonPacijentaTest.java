package npproj.medicalis_server.so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import javax.management.InvalidApplicationException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import npproj.medicalis_server.dbbroker.BrokerBazePodataka_impl;
import npproj.shared_lib.domain.KartonPacijenta;
import npproj.shared_lib.domain.Lekar;

public class AddKartonPacijentaTest {
	AbstractSO so;
	BrokerBazePodataka_impl bbp;
	@BeforeEach
	public void setUp() throws Exception {
		so = new AddKartonPacijenta();
		bbp = new BrokerBazePodataka_impl();
		bbp.makeConnection();
	}

	@AfterEach
	public void tearDown() throws Exception {
		so = null;
		bbp.closeConnection();
	}

	@Test
	public void testPreconditionWrongParam() {
		assertThrows(java.lang.Exception.class, () -> so.precondition(null));
	}


	@Test
	public void testExecuteOperation() {
		try {
			KartonPacijenta p = new KartonPacijenta();
			p.setJmbg("2703999715999");
			p.setLbo("50005064564");
			p.setIme("Pera");
			p.setPrezime("Peric");
			Date datumRodjenja = new Date(1999 - 1900, 2, 27);
			p.setDatumRodjenja(datumRodjenja);
			p.setPol("Muski");
			p.setAdresa("Jove Ilica 198a");
			p.setKontaktTelefon("0650000555");
			p.setKrvnaGrupa("A+");
			p.setHronicneDijagnoze("Nema");
			Lekar l = new Lekar("majpav");
			l.setIme("Maja");
			l.setPrezime("Pavlovic");
			p.setLekar(l);			
			
			so.execute(p);
			FindKartonPacijenta find = new FindKartonPacijenta();
			find.execute(p);
			assertEquals(p.getAtrValue(), find.getResult().getAtrValue());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
