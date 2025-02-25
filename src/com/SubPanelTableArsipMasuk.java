/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import lib.database.Query;
import penghubungPanel.Penghubung;

/**
 *
 * @author USER
 */
public class SubPanelTableArsipMasuk extends javax.swing.JPanel {
Penghubung DashboardUtama;
    Query query;
    String[] atributs = {"id_surat","no_surat","perihal","deskripsi","tanggal_diterima","nama_surat","file_digital"};
    //value ketika mengklik table
    String[] valuePerBaris;
    //value comboBox
    int filterBy;
    //value ketika mencari data table
    String valueCari;
    
    String buttonEdit;
    
    SubPanelEdit PanelEdit;

    public SubPanelTableArsipMasuk(Penghubung jembatan) {
        initComponents();
        filterBy = 0;
        valueCari = TextFieldCari.getText();
        valuePerBaris = new String[atributs.length];
        query = new Query();
        this.DashboardUtama = jembatan;
        menampilkanDataTableTerbaru(false,atributs,0,null);
    }
    
        //set variable ke null
    void bersihkanTextNull(String[] valuePerBaris){
        for(int i=0; i<valuePerBaris.length; i++){
            valuePerBaris[i] = null;
        }
    }
    
    void menampilkanDataTableTerbaru(Boolean pencarian, String[] atributs, int filterBy, String valueCari){
        ResultSet HasilQuery = null;
        DefaultTableModel ModelTable = new DefaultTableModel();
        ModelTable.addColumn("ID Surat");
        ModelTable.addColumn("No.Surat");
        ModelTable.addColumn("Perihal");
        ModelTable.addColumn("Deskripsi");
        ModelTable.addColumn("Tanggal Diterima");
        ModelTable.addColumn("File");
        
        if(pencarian != true){
            HasilQuery = query.setNamaTabel("surat").setAtribut(atributs).select();
        }else{
            String dipilih = atributs[0];
            for(int i=0; i<atributs.length; i++){
               if(filterBy == i){
                    dipilih = atributs[i];
                } 
            }
            HasilQuery = query.setNamaTabel("surat").setAtribut(atributs).setWhereId(dipilih, valueCari).selectWhereLike();
        }
        
        try {
            while(HasilQuery.next()){
                ModelTable.addRow(new Object[] {
                    HasilQuery.getString("surat."+atributs[0]+""),
                    HasilQuery.getString("surat."+atributs[1]+""),
                    HasilQuery.getString("surat."+atributs[2]+""),
                    HasilQuery.getString("surat."+atributs[3]+""),
                    HasilQuery.getString("surat."+atributs[4]+""),
                    HasilQuery.getString("surat."+atributs[5]+""),
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardArsipMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
        TableSuratMasuk.setModel(ModelTable);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TextFieldCari = new javax.swing.JTextField();
        ComboBoxCari = new javax.swing.JComboBox<>();
        ButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSuratMasuk = new javax.swing.JTable();
        ButtonEdit = new javax.swing.JButton();
        ButtonCetak = new javax.swing.JButton();
        ButtonDownload = new javax.swing.JButton();

        setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 440));
        jPanel1.setLayout(null);

        TextFieldCari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextFieldCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCariActionPerformed(evt);
            }
        });
        jPanel1.add(TextFieldCari);
        TextFieldCari.setBounds(600, 0, 200, 30);

        ComboBoxCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Surat", "No. Surat", "Perihal", "Deskripsi", "Tanggal Diterima", "File" }));
        ComboBoxCari.setToolTipText("");
        ComboBoxCari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(ComboBoxCari);
        ComboBoxCari.setBounds(480, 0, 110, 30);

        ButtonDelete.setText("Delete");
        ButtonDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonDelete);
        ButtonDelete.setBounds(0, 0, 100, 30);

        TableSuratMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Surat", "No. Surat", "Perihal", "Deskripsi", "Tanggal Diterima", "File"
            }
        ));
        TableSuratMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSuratMasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableSuratMasuk);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 60, 800, 380);

        ButtonEdit.setText("Edit");
        ButtonEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonEdit);
        ButtonEdit.setBounds(120, 0, 100, 30);

        ButtonCetak.setText("Cetak");
        ButtonCetak.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCetakActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonCetak);
        ButtonCetak.setBounds(360, 0, 100, 30);

        ButtonDownload.setText("Download");
        ButtonDownload.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDownloadActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonDownload);
        ButtonDownload.setBounds(240, 0, 100, 30);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCariActionPerformed
        this.filterBy = ComboBoxCari.getSelectedIndex();
        this.valueCari = TextFieldCari.getText();
        menampilkanDataTableTerbaru(true, this.atributs, this.filterBy, this.valueCari);
    }//GEN-LAST:event_TextFieldCariActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        try{
            UIManager.put("OptionPane.yesButtonText", "Lanjutkan");
            UIManager.put("OptionPane.noButtonText", "Batalkan");

            if(this.valuePerBaris[0] != null){
                int option = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mendelete data pada baris ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    query.setNamaTabel("surat").setWhereId(this.atributs[0], this.valuePerBaris[0]).delete();
                    bersihkanTextNull(this.valuePerBaris);
                } else {
                    throw new Exception("tidak jadi hapus data");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Tidak ada data yang dipilih");
            }
        }catch(Exception e){
            bersihkanTextNull(this.valuePerBaris);
        }
        menampilkanDataTableTerbaru(false, this.atributs, 0, null);
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void TableSuratMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSuratMasukMouseClicked
        try{
            int baris = TableSuratMasuk.rowAtPoint(evt.getPoint());

            for(int i=0; i<this.atributs.length-1; i++){
                this.valuePerBaris[i] = TableSuratMasuk.getValueAt(baris,i ).toString();
            }
            DashboardUtama.getValuesPanelTable(this.valuePerBaris);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal memilih data" + e.getMessage());
        }
    }//GEN-LAST:event_TableSuratMasukMouseClicked

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        this.DashboardUtama.pindahToSubPanelEdit();
    }//GEN-LAST:event_ButtonEditActionPerformed

    private void ButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCetakActionPerformed

    }//GEN-LAST:event_ButtonCetakActionPerformed

    private void ButtonDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDownloadActionPerformed

    }//GEN-LAST:event_ButtonDownloadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCetak;
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonDownload;
    private javax.swing.JButton ButtonEdit;
    private javax.swing.JComboBox<String> ComboBoxCari;
    private javax.swing.JTable TableSuratMasuk;
    private javax.swing.JTextField TextFieldCari;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
