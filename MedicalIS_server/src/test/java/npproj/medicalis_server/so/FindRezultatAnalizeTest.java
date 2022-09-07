package npproj.medicalis_server.so;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import npproj.shared_lib.domain.Analiza;
import npproj.shared_lib.domain.Rezultat;

class FindRezultatAnalizeTest {
	AbstractSO so;

	@BeforeEach
	void setUp() throws Exception {
		so = new FindRezultatAnalize();
	}

	@AfterEach
	void tearDown() throws Exception {
		so = null;
	}

	@Test
	void testPrecondition() {
		assertThrows(java.lang.Exception.class, () -> so.precondition(null));
	}

	@Test
	void testExecuteOperation() {
		Analiza a = new Analiza();
		a.setSifraAnalize(1l);
		try {
			so.execute(a);
			Rezultat result = (Rezultat) so.getResult();
			assertNotNull(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
