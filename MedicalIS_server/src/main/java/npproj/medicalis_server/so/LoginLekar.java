/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.medicalis_server.so;

import npproj.medicalis_server.dbbroker.BrokerBazePodataka_impl;
import npproj.shared_lib.domain.GeneralDObject;
import npproj.shared_lib.domain.Lekar;

/**
 * Klasa koja predstavlja SO za logovanje Lekara na sistem
 * @author Maja
 */
public class LoginLekar extends AbstractSO {
    /**
     * Objekat klase BrokerBazePodataka_impl
     */
    BrokerBazePodataka_impl bbp;
    GeneralDObject result;

    /**
     * Konstruktor koji kreira novi objekat klase BrokerBazePodataka_impl i
     * uspostavlja konekciju sa bazom podataka
     */
    public LoginLekar() {
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
        if (param == null || !(param instanceof Lekar)) {
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
        Lekar l = (Lekar) param;
        result = (Lekar) bbp.findRecord(l);

    }

    /**
     * Vraca rezultat SO
     *
     * @return rezultat SO kao objekat klase koja implementira GeneralDObject
     */
    public GeneralDObject getResult() {
        return result;
    }

}
