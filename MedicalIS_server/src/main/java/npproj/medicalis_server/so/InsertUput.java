/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.medicalis_server.so;

import npproj.medicalis_server.dbbroker.BrokerBazePodataka_impl;
import npproj.shared_lib.domain.Analiza;
import npproj.shared_lib.domain.GeneralDObject;
import npproj.shared_lib.domain.Uput;
import java.util.List;

/**
 * Klasa koja predstavlja SO za unos uputa u bazu podataka
 * @author Maja
 */
public class InsertUput extends AbstractSO {

    /**
     * Objekat klase BrokerBazePodataka_impl
     */
    BrokerBazePodataka_impl bbp;
    Object result;

    /**
     * Konstruktor koji kreira novi objekat klase BrokerBazePodataka_impl i
     * uspostavlja konekciju sa bazom podataka
     */
    public InsertUput() {
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
            throw new Exception("Niste uneli odgovarajuci parametar!");
        }
        Uput u = (Uput) param;
        if (u.getUputnaDijagnoza().isEmpty()) {
            throw new Exception("Morate upisati uputnu dijagnozu!");
        }
        if (u.getAnalize() == null || u.getAnalize().isEmpty()) {
            throw new Exception("Morate uneti barem jednu analizu u uput!");
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

        Uput u = (Uput) param;

        Long max = (Long) bbp.findMaxRecord(u);
        u.setSifraUputa(++max);

        List<Analiza> lista = setSifreAnaliza(u, u.getAnalize());

        if (!bbp.insertRecord(u) || !saveAnalize(lista)) {
            throw new Exception("Neuspesno cuvanje uputa!");
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

    /**
     * Metoda koja postavlja sifre analiza uputa Trazi maksimalnu sifru analize
     * i baze podataka i uvecava
     *
     * @param uput uput
     * @param analize analize uputa
     * @return listu analiza sa siframa
     */
    public List<Analiza> setSifreAnaliza(Uput uput, List<Analiza> analize) {
        Long maxAnaliza = (Long) bbp.findMaxRecord(new Analiza());
        for (Analiza a : analize) {
            a.setSifraAnalize(++maxAnaliza);
            a.setUput(uput);
        }
        return analize;
    }
    /**
     * Metoda koja snima analize u bazu podataka
     * @param analize lista analiza za cuvanje u bazi
     * @return true ako su analize uspesno sacuvane, false ukoliko nisu
     */
    public boolean saveAnalize(List<Analiza> analize) {
        boolean b = false;
        for (Analiza a : analize) {
//            System.out.println("Analize u save: " + a);
            b = bbp.insertRecord(a);
        }
        return b;
    }

}
