/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.medicalis_server.so;

import npproj.medicalis_server.dbbroker.BrokerBazePodataka_impl;
import npproj.shared_lib.domain.Analiza;
import npproj.shared_lib.domain.GeneralDObject;
import npproj.shared_lib.domain.Laborant;
import npproj.shared_lib.domain.Rezultat;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja SO za pronalazenje rezultata analize u bazi podataka
 *
 * @author Maja
 */
public class FindRezultatAnalize extends AbstractSO {

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
    public FindRezultatAnalize() {
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
        if (param == null || !(param instanceof Analiza)) {
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
        Analiza a = (Analiza) param;
        Rezultat r = new Rezultat();
        r.setAnaliza(a);
        r = (Rezultat) bbp.findRecord(r);

        if (r != null) {
            Laborant l = r.getLaborant();

            AbstractSO findLab = new FindLaborant();
            findLab.execute(l);

            r.setLaborant((Laborant) findLab.getResult());
        }

        result = r;
    }
    /**
     * Vraca rezultat izvrsavanja SO
     *
     * @return
     */
    public GeneralDObject getResult() {
        return result;
    }

}
