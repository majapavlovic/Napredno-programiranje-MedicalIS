/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.medicalis_server.so;

import npproj.medicalis_server.dbbroker.BrokerBazePodataka_impl;
import npproj.shared_lib.domain.GeneralDObject;
import npproj.shared_lib.domain.KartonPacijenta;
import java.text.SimpleDateFormat;

/**
 * Klasa koja predstavlja SO za azuriranje podataka u kartonu pacijenta
 * @author Maja
 */
public class UpdateKartonPacijenta extends AbstractSO {

    /**
     * Objekat brokera baze podataka, klase BrokerBazePodataka_impl
     */
    BrokerBazePodataka_impl bbp;

    /**
     * Konstruktor koji kreira novi objekat klase BrokerBazePodataka_impl i
     * uspostavlja konekciju sa bazom podataka
     */
    public UpdateKartonPacijenta() {
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
        KartonPacijenta k = (KartonPacijenta) param;
        if (k.getJmbg() == null || k.getLbo() == null
                || k.getIme().isEmpty() || k.getPrezime().isEmpty()
                || k.getDatumRodjenja() == null || k.getPol().isEmpty()
                || k.getKrvnaGrupa().isEmpty() || k.getLekar() == null) {
            throw new Exception("Niste uneli sve obavezne parametre!");
        }
        if (k.getJmbg().toString().length() != 13) {
            throw new Exception("Duzina JMBG-a mora biti tacno 13 cifara!");
        }
        if (k.getLbo().toString().length() != 11) {
            throw new Exception("Duzina LBO-a mora biti tacno 11 cifara!");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyy");
        String datum = formatter.format(k.getDatumRodjenja());

        if (!(datum.substring(0, 4) + datum.substring(5)).equals(k.getJmbg().toString().substring(0, 7))) {
            throw new Exception("Datum rodjenja i JMBG se ne poklapaju!");
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
        boolean b = bbp.updateRecord(k);
        if (!b) {
            throw new Exception("Neuspesno dodavanje kartona!");
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
     * Metoda koja vrsi rollback(povlacjenje) transakcije
     *
     * @throws Exception greska
     */
    @Override
    protected void rollbackTransaction() throws Exception {
        bbp.rollbackTransation();
    }

}
