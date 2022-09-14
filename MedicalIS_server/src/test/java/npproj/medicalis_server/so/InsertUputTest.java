package npproj.medicalis_server.so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import npproj.medicalis_server.dbbroker.BrokerBazePodataka_impl;
import npproj.shared_lib.domain.Analiza;
import npproj.shared_lib.domain.KartonPacijenta;
import npproj.shared_lib.domain.Laborant;
import npproj.shared_lib.domain.Lekar;
import npproj.shared_lib.domain.Rezultat;
import npproj.shared_lib.domain.Uput;

class InsertUputTest {
	AbstractSO so;
	BrokerBazePodataka_impl bbp;
	@BeforeEach
	void setUp() throws Exception {
		so = new InsertUput();
		bbp = new BrokerBazePodataka_impl();
		bbp.makeConnection();
		
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
	void testExecuteOperation() throws Exception {
		Uput u = new Uput();

        Long max = (Long) bbp.findMaxRecord(u);
        u.setSifraUputa(++max);
		u.setUputnaDijagnoza("TEST");
		try {
			u.setPacijent(new KartonPacijenta("2703999715999"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		u.setLekar(new Lekar("majpav"));
        u.setDatumUputa(new Date(2022-1900, 8, 14));
        Analiza a1 = new Analiza();
        a1.setVrstaAnalize("Bakterioloska");
        a1.setVrstaUzorka("Bris grla");
        
        Analiza a2 = new Analiza();
        a2.setVrstaAnalize("Bakterioloska");
        a2.setVrstaUzorka("Bris nosa");
        
        List<Analiza> analize = new ArrayList<>();
        analize.add(a1);
        analize.add(a2);
        
        u.setAnalize(analize);

		try {
			so.execute(u);
			FindAllUputi find = new FindAllUputi();
			
			find.execute(u);
			List<Uput> result = (List<Uput>) find.getResult1();
			assertNotNull(result);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
