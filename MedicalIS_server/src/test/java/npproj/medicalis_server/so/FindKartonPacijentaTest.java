package npproj.medicalis_server.so;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import npproj.shared_lib.domain.KartonPacijenta;
import npproj.shared_lib.domain.Lekar;

public class FindKartonPacijentaTest {
	AbstractSO so;

	@BeforeEach
	public void setUp() throws Exception {
		so = new FindKartonPacijenta();
	}

	@AfterEach
	public void tearDown() throws Exception {
		so = null;
	}

	@Test
	public void testPrecondition() {
		assertThrows(java.lang.Exception.class, () -> so.precondition(null));
	}

	@Test
	public void testExecuteOperation() {
		try {
			KartonPacijenta p = new KartonPacijenta("2703999715077");
			Lekar l = new Lekar();
			l.setUsername("majpav");
			p.setLekar(l);
			so.execute(p);
			KartonPacijenta result = (KartonPacijenta) so.getResult();
			assertNotNull(result);
			assertEquals(p.getJmbg(), result.getJmbg());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
