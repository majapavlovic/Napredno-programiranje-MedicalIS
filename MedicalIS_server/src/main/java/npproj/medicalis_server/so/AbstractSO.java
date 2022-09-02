/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.medicalis_server.so;

import npproj.shared_lib.domain.GeneralDObject;
import java.util.List;

/**
 * Apstraktna klasa koja predstavlja apstraktnu sistemsku operaciju (SO) koju nasledjuju konkretne SO
 * @author Maja
 */
public abstract class AbstractSO {
    
    /**
     * Rezultat SO, objekat klase GeneralDObject
     */
    GeneralDObject result;
    /**
     * Rezultat SO, objekat klase Object
     */
    Object result1;
    /**
     * Lista objekata GeneralDObject 
     */

    /**
     * Funkcija za izvrsavanje sistemske operacije
     * Izvrsava se provera preduslova, zapocinje transakcija, izvrsava SO i commit-uje transakcija
     * @param param parametar transakcije, GeneralDObject
     * @throws Exception Greska pri izvrsavanju SO
     */
    public void execute(GeneralDObject param) throws Exception {
        try {
            precondition(param);
            startTransaction();
            executeOperation(param);
            comitTransaction();
            System.out.println("Uspesno izvrsena operacija!");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Greska!");
            rollbackTransaction();
            throw new Exception(exception);
        }
    }
    
    protected abstract void precondition(GeneralDObject param) throws Exception;

    protected abstract void executeOperation(GeneralDObject param) throws Exception;

    private void startTransaction() {
    }

    protected void comitTransaction() throws Exception {
    }

    protected void rollbackTransaction() throws Exception {
    }

    public GeneralDObject getResult() {
        return result;
    }

    public Object getResult1() {
        return result1;
    }
    

    
}
