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
 *
 * @author Maja
 */
public class UpdateKartonPacijenta extends AbstractSO{
    BrokerBazePodataka_impl bbp;
   GeneralDObject result;
   boolean resultB = false;

    public UpdateKartonPacijenta() {
        bbp = new BrokerBazePodataka_impl();
        bbp.makeConnection();
    }

    @Override
    protected void precondition(GeneralDObject param) throws Exception {
        if (param == null || !(param instanceof KartonPacijenta)) {
            throw new Exception("Niste uneli odgovarajuci parametar");
        }
        KartonPacijenta k = (KartonPacijenta) param;
        if(k.getJmbg()==null || k.getLbo()==null ||
                k.getIme().isEmpty() || k.getPrezime().isEmpty() ||
                k.getDatumRodjenja()==null || k.getPol().isEmpty()
                || k.getKrvnaGrupa().isEmpty() || k.getLekar()==null) {
            throw new Exception("Niste uneli sve obavezne parametre!");
        }
        if(k.getJmbg().toString().length()!=13) {
            throw new Exception("Duzina JMBG-a mora biti tacno 13 cifara!");
        }
        if(k.getLbo().toString().length()!=11) {
            throw new Exception("Duzina LBO-a mora biti tacno 11 cifara!");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyy");
        String datum = formatter.format(k.getDatumRodjenja());
        
        if(!(datum.substring(0, 4) + datum.substring(5)).equals(k.getJmbg().toString().substring(0,7))) {
            throw new Exception("Datum rodjenja i JMBG se ne poklapaju!");
        }
        
    }

    @Override
    protected void executeOperation(GeneralDObject param) throws Exception {

        KartonPacijenta k = (KartonPacijenta) param;
        boolean b = bbp.updateRecord(k);
        if(!b) throw new Exception("Neuspesno dodavanje kartona!");
           
    }

    @Override
    protected void comitTransaction() throws Exception {
        bbp.commitTransation();
    }

    @Override
    protected void rollbackTransaction() throws Exception {
        bbp.rollbackTransation();
    }

    public boolean isResultB() {
        return resultB;
    }

}