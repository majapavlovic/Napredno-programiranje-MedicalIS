  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.shared_lib.communication;

import java.io.Serializable;

/**
 * Klasa koja predstavlja sifarnik za operacije u komunikaciji izmedju servera i klijenta
 * @author Maja
 */
public class Operations implements Serializable{
    public static final int LOGIN_LEKAR = 1;
    public static final int LOGIN_LAB = 2;
    public static final int SHUTDOWN = 3;
    public static final int GET_PACIJENT = 4;
    public static final int GET_REZULTAT = 5;
    public static final int INSERT_PACIJENT = 6;
    public static final int INSERT_UPUT = 7;
    public static final int GET_ALL_UPUT = 8;
    public static final int GET_ALL_REZULTAT = 9;
    public static final int INSERT_REZULTAT = 10;
    public static final int UPDATE_PACIJENT = 11;
    public static final int REFRESH = 12;
    public static final int GET_ALL_ANALIZA = 13;
    public static final int GET_REZULTATI = 14;
    public static final int LOGOUT_LEKAR = 15;
    public static final int LOGOUT_LAB = 16;
}
