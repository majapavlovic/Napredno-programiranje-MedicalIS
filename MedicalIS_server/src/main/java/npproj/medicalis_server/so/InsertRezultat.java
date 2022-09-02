/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.medicalis_server.so;

import npproj.medicalis_server.dbbroker.BrokerBazePodataka;
import npproj.medicalis_server.dbbroker.BrokerBazePodataka_impl;
import npproj.shared_lib.domain.GeneralDObject;
import npproj.shared_lib.domain.Rezultat;

/**
 * Klasa koja predstavlja SO za unos Rezultata u bazu podataka
 *
 * @author Maja
 */
public class InsertRezultat extends AbstractSO {

    /**
     * Objekat klase BrokerBazePodataka_impl
     */
    BrokerBazePodataka_impl bbp;

    /**
     * Konstruktor koji kreira novi objekat klase BrokerBazePodataka_impl i
     * uspostavlja konekciju sa bazom podataka
     */
    public InsertRezultat() {
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
        if (param == null || !(param instanceof Rezultat)) {
            throw new Exception("Niste uneli odgovarajuci parametar!");
        }
        Rezultat r = (Rezultat) param;
        if (r.getRezultat_analize().isEmpty()) {
            throw new Exception("Morate upisati vrednost rezultata!");
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
        Rezultat rez = (Rezultat) param;

        Long max = (Long) bbp.findMaxRecord(rez);
        rez.setSifra_rezultata(++max);

        if (!bbp.insertRecord(rez)) {
            throw new Exception("Neuspesno cuvanje rezultata!");
        }
    }

    /**
     * Metoda koja commit-uje(potvrdjuje) transakciju
     *
     * @throws Exception greska
     */
    @Override
    protected void comitTransaction() throws Exception {
        bbp.commitTransation();
    }

    /**
     * Metoda koja vrsi rollback(povlacenje) transakcije
     *
     * @throws Exception greska
     */
    @Override
    protected void rollbackTransaction() throws Exception {
        bbp.rollbackTransation();
    }

}
