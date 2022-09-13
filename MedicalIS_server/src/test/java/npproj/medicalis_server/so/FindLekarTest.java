package npproj.medicalis_server.so;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import npproj.shared_lib.domain.Lekar;


public class FindLekarTest {
	AbstractSO so;

	@BeforeEach
	public void setUp() throws Exception {
		so = new FindLekar();
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
		Lekar l = new Lekar();
		l.setUsername("majpav");
		try {
			so.execute(l);
			Lekar result = (Lekar) so.getResult();
			assertNotNull(result);
			assertEquals(l.getUsername(), result.getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
