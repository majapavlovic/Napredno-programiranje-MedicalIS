package npproj.shared_lib.domain;

import java.io.Serializable;
import java.sql.*;

/**
 * Interfejs koji predstavlja apstraktni objekat cije se metode koriste pri komunikaciji sa bazom podataka
 * Njega implementiraju klase Lekar, Laborant, KartonPacijenta, Uput, Analiza, Rezultat
 * @author Maja
 */
public interface GeneralDObject extends Serializable{
    
    /**
     * Vraca vrednost 
     * @return 
     */
    String getAtrValue();
    String setAtrValue();
    String getClassName();
    String getWhereCondition();

    GeneralDObject getNewRecord(ResultSet rs) throws SQLException, Exception;

    public default String getFields() { return "*"; }

    public default String getOrderBy() { return ""; }

    public default String getWhereCondition1() {return ""; }
}
