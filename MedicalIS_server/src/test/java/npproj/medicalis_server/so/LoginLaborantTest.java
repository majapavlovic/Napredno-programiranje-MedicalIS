package npproj.medicalis_server.so;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import npproj.shared_lib.domain.Laborant;

class LoginLaborantTest {
	AbstractSO so;

	@BeforeEach
	void setUp() throws Exception {
		so = new LoginLaborant();
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
		Laborant l = new Laborant();
		l.setUsername("majpav");
		l.setPassword("12345");
		
		try {
			so.execute(l);
			Laborant result = (Laborant) so.getResult();
			assertEquals("'majpav', '12345', 'Maja', 'Pavlovic'", result.getAtrValue());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
