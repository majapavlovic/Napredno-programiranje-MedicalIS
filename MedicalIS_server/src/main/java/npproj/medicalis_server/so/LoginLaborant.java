/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.medicalis_server.so;

import npproj.medicalis_server.dbbroker.BrokerBazePodataka_impl;
import npproj.shared_lib.domain.GeneralDObject;
import npproj.shared_lib.domain.Laborant;

/**
 * Klasa koja predstavlja SO za logovanje Laboranta na sistem
 * @author Maja
 */
public class LoginLaborant extends AbstractSO {
    /**
     * Objekat klase BrokerBazePodataka_impl
     */
    BrokerBazePodataka_impl bbp;
    GeneralDObject result;
    /**
     * Konstruktor koji kreira novi objekat klase BrokerBazePodataka_impl i uspostavlja konekciju sa bazom podataka
     */
    public LoginLaborant() {
        bbp = new BrokerBazePodataka_impl();
        bbp.makeConnection();
    }
    /**
     * Metoda za proveru uslova za izvrsenje SO
     * @param param objekat klase koja implementira GeneralDObject nad kojim se vrsi SO
     * @throws Exception vraca gresku ako nisu ispunjeni zadati uslovi
     */
    @Override
    protected void precondition(GeneralDObject param) throws Exception {
        if (param == null || !(param instanceof Laborant)) {
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
        Laborant l = (Laborant) param;
        result = (Laborant) bbp.findRecord(l);

    }

    public GeneralDObject getResult() {
        return result;
    }

}
