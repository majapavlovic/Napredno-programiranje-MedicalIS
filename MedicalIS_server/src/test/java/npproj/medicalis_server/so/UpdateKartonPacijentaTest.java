package npproj.medicalis_server.so;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import npproj.shared_lib.domain.KartonPacijenta;
import npproj.shared_lib.domain.Lekar;

class UpdateKartonPacijentaTest {
	AbstractSO so;

	@BeforeEach
	void setUp() throws Exception {
		so = new UpdateKartonPacijenta();
	}

	@AfterEach
	void tearDown() throws Exception {
		so = null;
	}
	@Test
	void testPreconditionWrongParam() {
		assertThrows(java.lang.Exception.class, () -> so.precondition(null));
	}

	@ParameterizedTest
	@CsvSource ({
		" '2703999715999', '5000506456', '', 'Peric', '1999', '3', '27', 'Muski', 'Jove Ilica 198a', '0690005555', 'A+', 'Dijabetes', 'majpav', 'Niste uneli sve obavezne parametre!'",
		" '27039997155955', '50005064564', 'Pera', 'Peric', '1999', '3', '27', 'Muski', 'Jove Ilica 198a', '0690005555', 'A+', 'Dijabetes', 'majpav', 'Duzina JMBG-a mora biti tacno 13 cifara!'",
		" '2708999715999', '500050', 'Pera', 'Peric', '1999', '3', '27', 'Muski', 'Jove Ilica 198a', '0690005555', 'A+', 'Dijabetes', 'majpav', 'Duzina LBO-a mora biti tacno 11 cifara!'",
		" '2708999715999', '50005045912', 'Pera', 'Peric', '', '', '', 'Muski', 'Jove Ilica 198a', '0690005555', 'A+', 'Dijabetes', 'majpav', 'Niste uneli sve obavezne parametre!'",
		" '2708999715999', '50005045912', 'Pera', 'Peric', '1999', '3', '7', 'Muski', 'Jove Ilica 198a', '0690005555', 'A+', 'Dijabetes', 'majpav', 'Datum rodjenja i JMBG se ne poklapaju!'"
	})
	void testPrecondition(String jmbg, String lbo, String ime, String prezime, String god, String mes, String dan, String pol, String adresa, String tel, String krvnaGr, String hron, String lekar, String errMess) {
		KartonPacijenta p = new KartonPacijenta();
		p.setJmbg(jmbg);
		p.setLbo(lbo);
		p.setIme(ime);
		p.setPrezime(prezime);
		if(god.isEmpty() || mes.isEmpty() || dan.isEmpty()) {
			p.setDatumRodjenja(null);
		}
		else {
			int g = Integer.valueOf(god);
			int m = Integer.valueOf(mes);
			int d = Integer.valueOf(dan);
			Date datumRodjenja = new Date(g-1900, m-1, d);
			p.setDatumRodjenja(datumRodjenja); 
		}
		p.setPol(pol);
		p.setAdresa(adresa);
		p.setKontaktTelefon(tel);
		p.setKrvnaGrupa(krvnaGr);
		p.setHronicneDijagnoze(hron);
		Lekar l = new Lekar(lekar);
		p.setLekar(l);
		Exception thrown = assertThrows(java.lang.Exception.class, 
				() -> so.precondition(p));
		
		assertEquals(errMess, thrown.getMessage());
	}

	@Test
	void testExecuteOperation() {
		KartonPacijenta p = new KartonPacijenta();
		p.setJmbg("2703999715999");
		p.setLbo("50005064564");
		p.setIme("Pera");
		p.setPrezime("Peric");
		Date datumRodjenja = new Date(1999-1900, 2, 27);
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
		
		try {
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
