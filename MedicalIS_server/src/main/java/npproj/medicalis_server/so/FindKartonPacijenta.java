/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.medicalis_server.so;

import java.util.ArrayList;
import java.util.List;
import npproj.medicalis_server.dbbroker.BrokerBazePodataka_impl;
import npproj.shared_lib.domain.Analiza;
import npproj.shared_lib.domain.GeneralDObject;
import npproj.shared_lib.domain.KartonPacijenta;
import npproj.shared_lib.domain.Lekar;
import npproj.shared_lib.domain.Uput;

/**
 * Klasa koja predstavlja SO za pronalazenje kartona pacijenta u bazi podataka
 *
 * @author Maja
 */
public class FindKartonPacijenta extends AbstractSO {

    /**
     * Objekat klase BrokerBazePodataka_impl
     */
    BrokerBazePodataka_impl bbp;
    /**
     * Rezultat izvrsavanja SO
     */
    GeneralDObject result;

    /**
     * Konstruktor koji kreira novi objekat klase BrokerBazePodataka_impl i
     * uspostavlja konekciju sa bazom podataka
     */
    public FindKartonPacijenta() {
        bbp = new BrokerBazePodataka_impl();
        bbp.makeConnection();
    }

    /**
     * Metoda za proveru uslova za izvrsenje SO
     *
     * @param param objekat klase koja implementira GeneralDObject nad kojim se
     * vrsi SO
     * @throws Exception vraca gresku ako nisu ispunjeni zadati uslovi
     */
    @Override
    protected void precondition(GeneralDObject param) throws Exception {
        if (param == null || !(param instanceof KartonPacijenta)) {
            throw new Exception("Niste uneli odgovarajuci parametar");
        }
    }

    /**
     * Metoda za izvrsavanje SO
     *
     * @param param objekat klase koja implementira GeneralDObject nad kojim se
     * vrsi SO
     * @throws Exception greska pri izvrsavanju SO
     */
    @Override
    protected void executeOperation(GeneralDObject param) throws Exception {

        KartonPacijenta k = (KartonPacijenta) param;
        k = (KartonPacijenta) bbp.findRecord(k);

        Lekar l = k.getLekar();
        AbstractSO findLekar = new FindLekar();
        findLekar.executeOperation(l);

        k.setLekar((Lekar) findLekar.getResult());

        k.setUputi(findUputi(k));

        result = k;
    }

    public GeneralDObject getResult() {
        return result;
    }

    /**
     * Metoda za pronalazenje uputa pacijenta u bazi podataka
     *
     * @param k karton pacijenta za koji se traze uputi
     * @return lista uputa
     */
    private List<Uput> findUputi(KartonPacijenta k) {
        Uput u = new Uput();
        u.setPacijent(k);
        List<GeneralDObject> l = bbp.findAllRecords(u);
        List<Uput> uputi = new ArrayList<>();
        if (l != null && !l.isEmpty()) {
            for (GeneralDObject odo : l) {
                List<Analiza> analize = new ArrayList<>();

                u = (Uput) odo;
                u.setLekar((Lekar) bbp.findRecord1(new Lekar(u.getLekar().getUsername())));

                u.setAnalize(findAnalize(u));

                uputi.add(u);
            }
        }
        return uputi;
    }

    /**
     * Metoda za pronalazenje analiza u bazi podataka
     *
     * @param u uput za koji se traze analize
     * @return lista analiza
     */
    private List<Analiza> findAnalize(Uput u) {
        Analiza a = new Analiza();
        a.setUput(u);
        List<Analiza> analize = new ArrayList<>();
        List<GeneralDObject> l = bbp.findAllRecords(a);
        for (GeneralDObject gdo : l) {
            analize.add((Analiza) gdo);
        }
        return analize;
    }
}
