/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import npproj.shared_lib.communication.Response;
import npproj.shared_lib.communication.ResponseType;
import npproj.medicalis_client.component.TableModelAnalize;
import npproj.medicalis_client.component.TableModelUputi;
import npproj.medicalis_client.controller.ClientController;
import npproj.shared_lib.domain.Analiza;
import npproj.shared_lib.domain.Laborant;
import npproj.shared_lib.domain.Rezultat;
import npproj.shared_lib.domain.Uput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Maja
 */
public class FrmMain_Laborant extends javax.swing.JFrame {

    Laborant laborant;
    List<Rezultat> rezultati = new ArrayList<>();
    List<Analiza> analize = new ArrayList<>();
    List<Uput> uputi = new ArrayList<>();
    TableModelAnalize tblModelAnalize;
    TableModelUputi tblModelUputi;
    Uput uput;
    Analiza analiza;
    Rezultat rezultat;

    /**
     * Creates new form FrmMain_Laborant
     */
    public FrmMain_Laborant(Laborant laborant) {
        initComponents();
        this.setLocationRelativeTo(null);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.laborant = laborant;
        ClientController.getInstance().setFrmLaborant(this);
        prepareForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUputi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSifraAnalize = new javax.swing.JTextField();
        txtDatumUputa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLekar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRezultat = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        btnZapamti = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtVrstaUzorka = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAnaliza = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtLaborant = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDatuimRezultata = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblLaborant = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAnalize = new javax.swing.JTable();
        btnLogout = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MedicalIS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 24), new java.awt.Color(0, 153, 255))); // NOI18N

        tblUputi.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblUputi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUputi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUputiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUputi);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Lista uputa");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prikaz uputa i unos rezultata", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 18), new java.awt.Color(102, 153, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Sifra analize");

        txtSifraAnalize.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSifraAnalize.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSifraAnalize.setEnabled(false);
        txtSifraAnalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSifraAnalizeActionPerformed(evt);
            }
        });

        txtDatumUputa.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDatumUputa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDatumUputa.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Datum uputa");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Lekar");

        txtLekar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLekar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLekar.setEnabled(false);

        txtRezultat.setColumns(20);
        txtRezultat.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtRezultat.setRows(5);
        jScrollPane2.setViewportView(txtRezultat);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Rezultat:");

        btnZapamti.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnZapamti.setText("Zapamti");
        btnZapamti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZapamtiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("Vrsta uzorka");

        txtVrstaUzorka.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtVrstaUzorka.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtVrstaUzorka.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Analiza");

        txtAnaliza.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtAnaliza.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAnaliza.setEnabled(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Podaci o rezultatu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18))); // NOI18N

        txtLaborant.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLaborant.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtLaborant.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Laborant");

        txtDatuimRezultata.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDatuimRezultata.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDatuimRezultata.setEnabled(false);
        txtDatuimRezultata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatuimRezultataActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("Datum izdavanja");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtLaborant, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatuimRezultata, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtDatuimRezultata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLaborant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(btnZapamti, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLekar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(txtSifraAnalize))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumUputa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtVrstaUzorka, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnaliza, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtSifraAnalize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAnaliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtVrstaUzorka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtDatumUputa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel8)
                                .addGap(186, 186, 186))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLekar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnZapamti)
                                .addGap(375, 375, 375))))))
        );

        lblLaborant.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblLaborant.setText("jLabel7");

        tblAnalize.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblAnalize.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAnalize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAnalizeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblAnalize);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLaborant, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addGap(390, 390, 390))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLaborant)
                    .addComponent(btnLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnZapamtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZapamtiActionPerformed
        if (uput != null && rezultat != null && !txtSifraAnalize.getText().isEmpty() && !txtRezultat.getText().isEmpty()) {
            try {
                Rezultat rez = new Rezultat();
                rez.setAnaliza(analiza);
                rez.setRezultat_analize(txtRezultat.getText());
                rez.setLaborant(laborant);
                rez.setDatumIzdavanja(new Date());

                ClientController.getInstance().insertRezultat(rez);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Morate odabrati uput i upisati vrednost rezultata!", "Greska", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnZapamtiActionPerformed

    private void tblUputiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUputiMouseClicked

        int row = tblUputi.rowAtPoint(evt.getPoint());

        uput = tblModelUputi.getUput(row);

        analize = uput.getAnalize();
        for (Analiza a : analize) {
            System.out.println(a);
        }

        try {
            ClientController.getInstance().getRezultat(analize);
        } catch (Exception ex) {
            Logger.getLogger(FrmMain_Laborant.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*   uput = u;
        rezultat = r;

        txtAnaliza.setText(u.getAnaliza());
        txtSifraUputa.setText(u.getSifraUputa().toString());
        txtDatumUputa.setText(u.getDatumUputa().toString());
        txtVrstaUzorka.setText(u.getVrstaUzorka());
        txtLekar.setText(u.getLekar().getIme() + " " + u.getLekar().getPrezime());
        if (rezultat != null && rezultat.getRezultat_analize() != null) {
            txtRezultat.setText(r.getRezultat_analize());
            txtLaborant.setText(r.getLaborant().getIme() + " " + r.getLaborant().getPrezime());
        }*/
        //JOptionPane.showMessageDialog(this, tblModelUputi.getUputRezultat(row));

        /*   uput = u;
        rezultat = r;

        txtAnaliza.setText(u.getAnaliza());
        txtSifraUputa.setText(u.getSifraUputa().toString());
        txtDatumUputa.setText(u.getDatumUputa().toString());
        txtVrstaUzorka.setText(u.getVrstaUzorka());
        txtLekar.setText(u.getLekar().getIme() + " " + u.getLekar().getPrezime());
        if (rezultat != null && rezultat.getRezultat_analize() != null) {
            txtRezultat.setText(r.getRezultat_analize());
            txtLaborant.setText(r.getLaborant().getIme() + " " + r.getLaborant().getPrezime());
        }*/
        //JOptionPane.showMessageDialog(this, tblModelUputi.getUputRezultat(row));

    }//GEN-LAST:event_tblUputiMouseClicked

    private void txtSifraAnalizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSifraAnalizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSifraAnalizeActionPerformed

    private void tblAnalizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAnalizeMouseClicked

        analiza = tblModelAnalize.getAnaliza(tblAnalize.rowAtPoint(evt.getPoint()));
        rezultat = tblModelAnalize.getRezultat(tblAnalize.rowAtPoint(evt.getPoint()));

        txtSifraAnalize.setText(analiza.getSifraAnalize().toString());
        txtDatumUputa.setText(uput.getDatumUputa().toString());
        txtVrstaUzorka.setText(analiza.getVrstaUzorka());
        txtAnaliza.setText(analiza.getVrstaAnalize());

        txtLekar.setText(uput.getLekar().getIme() + " " + uput.getLekar().getPrezime());

        if (rezultat != null && rezultat.getLaborant() != null) {
            txtLaborant.setText(rezultat.getLaborant().getIme() + " " + rezultat.getLaborant().getPrezime());
            txtDatuimRezultata.setText(rezultat.getDatumIzdavanja().toString());
        }

    }//GEN-LAST:event_tblAnalizeMouseClicked

    private void txtDatuimRezultataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatuimRezultataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatuimRezultataActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        new FrmLogin().setVisible(true);
        ClientController.getInstance().logoutLaborant(laborant);
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnZapamti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblLaborant;
    private javax.swing.JTable tblAnalize;
    private javax.swing.JTable tblUputi;
    private javax.swing.JTextField txtAnaliza;
    private javax.swing.JTextField txtDatuimRezultata;
    private javax.swing.JTextField txtDatumUputa;
    private javax.swing.JTextField txtLaborant;
    private javax.swing.JTextField txtLekar;
    private javax.swing.JTextArea txtRezultat;
    private javax.swing.JTextField txtSifraAnalize;
    private javax.swing.JTextField txtVrstaUzorka;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        try {
            //ClientController.getInstance().getAnalize();
            //ClientController.getInstance().getRezultati();

            ClientController.getInstance().getUputi();

            tblModelUputi = new TableModelUputi();
            tblModelAnalize = new TableModelAnalize();
            tblUputi.setModel(tblModelUputi);
            tblAnalize.setModel(tblModelAnalize);

            lblLaborant.setText(laborant.getIme() + " " + laborant.getPrezime() + "(" + laborant.getUsername() + ")");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Greska u preuzimanju podataka: " + ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setRezultati(Response response) {
        rezultati = (List<Rezultat>) response.getResponse();
        if (!analize.isEmpty()) {
            tblModelAnalize.setAnalizeRezultati(analize, rezultati);
        }
        //tblModelUputiRez.setRezultati(rezultati);
    }

    public void notifyInsert(String message) {
        JOptionPane.showMessageDialog(this, message);

        try {
            ClientController.getInstance().getRezultati();
            ClientController.getInstance().notifyOthers();
        } catch (Exception ex) {
            Logger.getLogger(FrmMain_Laborant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refresh() {
        prepareForm();
    }

    public void showAnalize(Response response) {
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            analize = (List<Analiza>) response.getResponse();
            tblModelAnalize.setAnalize(analize);
        }
    }

    public void setUputi(Response response) {
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            uputi = (List<Uput>) response.getResponse();
            tblModelUputi.setUputi(uputi);
        }
    }
}