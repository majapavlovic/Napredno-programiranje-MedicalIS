package npproj.medicalis_server.so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import npproj.shared_lib.domain.Analiza;
import npproj.shared_lib.domain.Laborant;
import npproj.shared_lib.domain.Rezultat;

class InsertRezultatTest {
	AbstractSO so;
	@BeforeEach
	void setUp() throws Exception {
		so = new InsertRezultat();
	}

	@AfterEach
	void tearDown() throws Exception {
		so = null;
	}

	@Test
	void testPreconditionWrongParam() {
		assertThrows(java.lang.Exception.class, () -> so.precondition(null));	
	}
	@Test
	void testPreconditionMissingParam() {
		Rezultat r = new Rezultat();
		r.setAnaliza(new Analiza(1l));
		r.setRezultat_analize("");
		Exception thrown = assertThrows(java.lang.Exception.class, () -> so.precondition(r));	
		
		assertEquals("Morate upisati vrednost rezultata!", thrown.getMessage());
	}

	@Test
	void testExecuteOperation() {
		Rezultat r = new Rezultat();
		Analiza a = new Analiza(1l);
		r.setAnaliza(a);
		r.setRezultat_analize("Test");
		r.setDatumIzdavanja(new Date(2022-1900, 8, 7));
		r.setLaborant(new Laborant("majpav"));
		try {
			so.execute(r);
			FindRezultatAnalize findRez = new FindRezultatAnalize();
			findRez.execute(a);
			Rezultat result = (Rezultat) findRez.getResult();
			assertNotNull(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
