/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.medicalis_server.so;

import npproj.shared_lib.communication.ResponseType;
import npproj.medicalis_server.dbbroker.BrokerBazePodataka_impl;
import npproj.shared_lib.domain.Analiza;
import npproj.shared_lib.domain.GeneralDObject;
import npproj.shared_lib.domain.Lekar;
import npproj.shared_lib.domain.Uput;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja SO pronalazenja svih uputa iz baze podataka
 *
 * @author Maja
 */
public class FindAllUputi extends AbstractSO {

    /**
     * Objekat klase BrokerBazePodataka_impl
     */
    BrokerBazePodataka_impl bbp;
    /**
     * Rezultat SO kao Object
     */
    Object result1;

    /**
     * Konstruktor koji kreira novi objekat klase BrokerBazePodataka_impl i
     * uspostavlja konekciju sa bazom podataka
     */
    public FindAllUputi() {
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
        if (param == null || !(param instanceof Uput)) {
            throw new Exception("Greska u preconditions");
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
        Uput u = new Uput();
        List<GeneralDObject> odoUputi = bbp.findAllRecords_NoCondition(u);
        List<Uput> uputi = new ArrayList<>();
        for (GeneralDObject odo : odoUputi) {
            u = (Uput) odo;
            u.setLekar((Lekar) bbp.findRecord1(u.getLekar()));
            u.setAnalize(findAnalize(u));
            uputi.add(u);
        }
        result1 = uputi;

    }

    /**
     * Metoda za pronalazenje analiza jednog uputa iz baze podataka
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

    /**
     * Vraca rezultat izvrsenja SO
     *
     * @return Object rezultat
     */
    @Override
    public Object getResult1() {
        return result1;
    }

}
