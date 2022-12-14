/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package npproj.medicalis_server.component;

import npproj.shared_lib.domain.GeneralDObject;
import npproj.shared_lib.domain.Laborant;
import npproj.shared_lib.domain.Lekar;
import npproj.shared_lib.domain.Rezultat;
import npproj.shared_lib.domain.Uput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.SpringLayout;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maja
 */
public class TableModelKorisnici extends AbstractTableModel {

    List<GeneralDObject> korisnici = new ArrayList<>();
    String[] kolone = {"Korisnicko ime", "Ime i prezime", "Tip korisnika", "Vreme prijave"};

    @Override
    public int getRowCount() {
        return korisnici.size();

    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GeneralDObject o = korisnici.get(rowIndex);
        if (o.getClassName().equals("Lekar")) {
            Lekar l = (Lekar) o;
            switch (columnIndex) {
                case 0:
                    return l.getUsername();
                case 1:
                    return l.getIme() + " " + l.getPrezime();
                case 2:
                    return l.getClassName();
                case 3:
                    return new Date().toString();
                default:
                    return "N/A";
            }
        } else if (o.getClassName().equals("Laborant")) {
            Laborant lb = (Laborant) o;
            switch (columnIndex) {
                case 0:
                    return lb.getUsername();
                case 1:
                    return lb.getIme() + " " + lb.getPrezime();
                case 2:
                    return lb.getClassName();
                case 3:
                    return new Date().toString();
                default:
                    return "N/A";
            }
        }
        return "";
    }

    public void setKorisnici(List<GeneralDObject> korisnici) {
        this.korisnici = korisnici;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void addKorisnik(GeneralDObject korisnik) {
        korisnici.add(korisnik);
        fireTableDataChanged();
    }

    public void removeLekar(Lekar lekar) {
        for (GeneralDObject gdo : korisnici) {
            if (gdo instanceof Lekar) {
                Lekar l = (Lekar) gdo;
                if (lekar.getUsername().equals(l.getUsername())) {
                    korisnici.remove(l);
                    fireTableDataChanged();
                    break;
                }
            }
        }
    }

    public void removeLaborant(Laborant lab) {
        for (GeneralDObject gdo : korisnici) {
            if (gdo instanceof Laborant) {
                Laborant l = (Laborant) gdo;
                if (lab.getUsername().equals(l.getUsername())) {
                    korisnici.remove(l);
                    fireTableDataChanged();
                    break;
                }
            }
        }
    }
}
