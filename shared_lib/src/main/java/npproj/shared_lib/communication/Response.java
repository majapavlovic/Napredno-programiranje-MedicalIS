/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.communication;

import java.io.Serializable;

/**
 * Klasa koja predstavlja response koji salje server/klijent 
 * @author Maja
 */
public class Response implements Serializable {
    /**
     * Objekat responsa kao Object
     */
    private Object response;
    /**
     * Tip responsa (SUCCESS, ERROR)
     */
    private ResponseType responseType;
    /**
     * Greska responsa
     */
    private Exception exception;
    /**
     * Operacija responsa
     */
    private int operation;
    /**
     * Bezparametarski konstruktor
     */
    public Response() {
    }
    /**
     * Vraca vrednost responsa
     * @return response objekat responsa
     */
    public Object getResponse() {
        return response;
    }
    /**
     * Postavlja vrednost responsa
     * @param response objekat responsa 
     */
    public void setResponse(Object response) {
        this.response = response;
    }
    /**
     * Vraca tip responsa
     * @return responseType 
     */
    public ResponseType getResponseType() {
        return responseType;
    }
    /**
     * Postavlja tip responsa
     * @param responseType tip responsa
     */
    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }
    /**
     * Vraca gresku responsa
     * @return Exception
     */
    public Exception getException() {
        return exception;
    }
    /**
     * Postavlja Exception ukoliko je doslo do greske
     * @param exception greska
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }
    /**
     * Vraca operaciju responsa
     * @return operacija kao int
     */
    public int getOperation() {
        return operation;
    }
    /**
     * Postavlja operaciju responsa
     * @param operation 
     */
    public void setOperation(int operation) {
        this.operation = operation;
    }
    

    
}
