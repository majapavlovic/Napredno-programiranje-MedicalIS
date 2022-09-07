package npproj.medicalis_server.so;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import npproj.shared_lib.domain.Uput;

class FindAllUputiTest {
	AbstractSO so;

	@BeforeEach
	void setUp() throws Exception {
		so = new FindAllUputi();
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
		try {
			so.execute(new Uput());
			List<Uput> result = (List<Uput>) so.getResult1();
			assertNotNull(result);
			assertTrue(result.size() >= 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
