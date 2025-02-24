package com;

import lib.database.Query;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;


public class DashboardArsipMasuk extends javax.swing.JPanel {
    Query query = new Query();
    
    String idSurat, noSurat, perihal, deskripsi, fileDigital, tanggalDiterima;
    String[] atributs = {"id_surat","no_surat","perihal","deskripsi","file_digital","tanggal_diterima","tanggal_dikeluarkan","penerima"};
    String filterBy;
    
    public DashboardArsipMasuk() {
        initComponents();
        PanelPopUpEdit.setVisible(false);
        menampilkanDataTableTerbaru();
    }
    
    //set variable ke null
    void bersihkanTextNull(){
          this.idSurat = null;
          this.perihal = null;
          this.deskripsi = null;
          this.fileDigital = null;
          this.tanggalDiterima = null;
    }
    //set textField ke kosong
    void ambilText(){
        TextFieldSuratEditPopUp.setText(this.noSurat);
        TextFieldPerihalEditPopUp.setText(this.perihal);
        TextFieldDeskripsiEditPopUp.setText(this.deskripsi);
        TextFieldTanggalMasukEditPopUp.setText(this.tanggalDiterima);
    }
    
    String getValueId(String[] id){
        return id[0];
    };
    
    //Untuk Rolling panel
    void hideKomponenUtama(){
        TableSuratMasuk.setVisible(false);
        jScrollPane1.setVisible(false);
        ButtonDelete.setVisible(false);
        ButtonCetak.setVisible(false);
        ComboBoxCari.setVisible(false);
        TextFieldCari.setVisible(false);
        ButtonEdit.setVisible(false);
        PanelPopUpEdit.setVisible(true);
    }
    void hideKomponenUpdateData(){
        PanelPopUpEdit.setVisible(false);
        TableSuratMasuk.setVisible(true);
        jScrollPane1.setVisible(true);
        ButtonDelete.setVisible(true);
        ButtonCetak.setVisible(true);
        ComboBoxCari.setVisible(true);
        ButtonEdit.setVisible(true);
        TextFieldCari.setVisible(true);
    }
    
    void menampilkanDataTableTerbaru(){
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("No Surat");
        modelTable.addColumn("Perihal");
        modelTable.addColumn("Deskripsi");
        modelTable.addColumn("File");
        modelTable.addColumn("Tanggal Diterima");
        
        ResultSet hasilQuery = query.setNamaTabel("surat").setAtribut(this.atributs).select();
        
        try {
            while(hasilQuery.next()){
                modelTable.addRow(new Object[] {
                    hasilQuery.getString("surat.no_surat"),
                    hasilQuery.getString("surat.perihal"),
                    hasilQuery.getString("surat.deskripsi"),
                    hasilQuery.getString("surat.file_digital"),
                    hasilQuery.getString("surat.tanggal_diterima"),                   
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardArsipMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
        TableSuratMasuk.setModel(modelTable);
    }
    
    void menampilkanDataTableTerbaruPencarian(){
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.addColumn("No Surat");
        modelTable.addColumn("Perihal");
        modelTable.addColumn("Deskripsi");
        modelTable.addColumn("File");
        modelTable.addColumn("Tanggal Diterima");
        
        String list = (String) ComboBoxCari.getSelectedItem();
        switch(list){
            case "Perihal":
                this.filterBy = "perihal";
                break;
//            case "Pengirim":
//                this.filterBy = "alamat";
//                break;
            case "No.Surat":
                this.filterBy = "no_surat";
                break;
        }
        
        ResultSet hasilQuery = query.setNamaTabel("surat").setAtribut(this.atributs).setWhereId(this.filterBy, TextFieldCari.getText()).selectWhereLike();
        
        try {
            while(hasilQuery.next()){
                modelTable.addRow(new Object[] {
                    hasilQuery.getString("surat.no_surat"),
                    hasilQuery.getString("surat.perihal"),
                    hasilQuery.getString("surat.deskripsi"),
                    hasilQuery.getString("surat.file_digital"),
                    hasilQuery.getString("surat.tanggal_diterima"),                       
                    
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardArsipMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
        TableSuratMasuk.setModel(modelTable);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelDashboardArsipMasuk = new javax.swing.JLabel();
        TextFieldCari = new javax.swing.JTextField();
        ComboBoxCari = new javax.swing.JComboBox<>();
        LabelCari = new javax.swing.JLabel();
        ButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSuratMasuk = new javax.swing.JTable();
        ButtonEdit = new javax.swing.JButton();
        ButtonCetak = new javax.swing.JButton();
        PanelPopUpEdit = new javax.swing.JPanel();
        LabelFileEditPopUp = new javax.swing.JLabel();
        LabelSuratPopupEdit = new javax.swing.JLabel();
        LabelPerihalEditPopUp = new javax.swing.JLabel();
        LabelDeskripsiEditPopUp = new javax.swing.JLabel();
        LabelTanggalMasukEditPopUp = new javax.swing.JLabel();
        ButtonBatalEditPopUp = new javax.swing.JButton();
        ButtonUpdateEditPopUp = new javax.swing.JButton();
        TextFieldSuratEditPopUp = new javax.swing.JTextField();
        TextFieldPerihalEditPopUp = new javax.swing.JTextField();
        TextFieldDeskripsiEditPopUp = new javax.swing.JTextField();
        TextFieldTanggalMasukEditPopUp = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setAlignmentX(0.0F);
        setAlignmentY(100.0F);
        setMaximumSize(new java.awt.Dimension(950, 950));
        setMinimumSize(new java.awt.Dimension(950, 600));
        setLayout(null);

        LabelDashboardArsipMasuk.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        LabelDashboardArsipMasuk.setText("Dashboard Arsip Masuk");
        add(LabelDashboardArsipMasuk);
        LabelDashboardArsipMasuk.setBounds(337, 5, 275, 28);

        TextFieldCari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextFieldCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCariActionPerformed(evt);
            }
        });
        add(TextFieldCari);
        TextFieldCari.setBounds(670, 100, 200, 30);

        ComboBoxCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perihal", "Pengirim", "No.Surat" }));
        ComboBoxCari.setToolTipText("");
        ComboBoxCari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(ComboBoxCari);
        ComboBoxCari.setBounds(550, 100, 110, 30);

        LabelCari.setText("Cari Berdasarkan: ");
        add(LabelCari);
        LabelCari.setBounds(550, 80, 130, 20);

        ButtonDelete.setText("Delete");
        ButtonDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });
        add(ButtonDelete);
        ButtonDelete.setBounds(70, 100, 100, 30);

        TableSuratMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No. Surat", "Perihal", "Penerima", "Tujuan", "Tanggal Keluar", "File"
            }
        ));
        TableSuratMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSuratMasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableSuratMasuk);
        if (TableSuratMasuk.getColumnModel().getColumnCount() > 0) {
            TableSuratMasuk.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableSuratMasuk.getColumnModel().getColumn(1).setResizable(false);
            TableSuratMasuk.getColumnModel().getColumn(5).setPreferredWidth(180);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(70, 160, 800, 380);

        ButtonEdit.setText("Edit");
        ButtonEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditActionPerformed(evt);
            }
        });
        add(ButtonEdit);
        ButtonEdit.setBounds(190, 100, 100, 30);

        ButtonCetak.setText("Cetak");
        ButtonCetak.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCetakActionPerformed(evt);
            }
        });
        add(ButtonCetak);
        ButtonCetak.setBounds(430, 100, 100, 30);

        PanelPopUpEdit.setLayout(null);

        LabelFileEditPopUp.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelFileEditPopUp.setText("File:");
        PanelPopUpEdit.add(LabelFileEditPopUp);
        LabelFileEditPopUp.setBounds(20, 250, 80, 20);

        LabelSuratPopupEdit.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelSuratPopupEdit.setText("No. Surat:");
        PanelPopUpEdit.add(LabelSuratPopupEdit);
        LabelSuratPopupEdit.setBounds(20, 40, 80, 20);

        LabelPerihalEditPopUp.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelPerihalEditPopUp.setText("Perihal:");
        PanelPopUpEdit.add(LabelPerihalEditPopUp);
        LabelPerihalEditPopUp.setBounds(20, 90, 80, 20);

        LabelDeskripsiEditPopUp.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelDeskripsiEditPopUp.setText("Deskripsi :");
        PanelPopUpEdit.add(LabelDeskripsiEditPopUp);
        LabelDeskripsiEditPopUp.setBounds(20, 140, 90, 20);

        LabelTanggalMasukEditPopUp.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelTanggalMasukEditPopUp.setText("Tanggal Keluar:");
        PanelPopUpEdit.add(LabelTanggalMasukEditPopUp);
        LabelTanggalMasukEditPopUp.setBounds(20, 190, 130, 20);

        ButtonBatalEditPopUp.setText("Batal");
        ButtonBatalEditPopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBatalEditPopUpActionPerformed(evt);
            }
        });
        PanelPopUpEdit.add(ButtonBatalEditPopUp);
        ButtonBatalEditPopUp.setBounds(280, 340, 80, 40);

        ButtonUpdateEditPopUp.setText("Update");
        ButtonUpdateEditPopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateEditPopUpActionPerformed(evt);
            }
        });
        PanelPopUpEdit.add(ButtonUpdateEditPopUp);
        ButtonUpdateEditPopUp.setBounds(180, 340, 80, 40);
        PanelPopUpEdit.add(TextFieldSuratEditPopUp);
        TextFieldSuratEditPopUp.setBounds(180, 40, 180, 30);
        PanelPopUpEdit.add(TextFieldPerihalEditPopUp);
        TextFieldPerihalEditPopUp.setBounds(180, 90, 180, 30);
        PanelPopUpEdit.add(TextFieldDeskripsiEditPopUp);
        TextFieldDeskripsiEditPopUp.setBounds(180, 140, 180, 30);
        PanelPopUpEdit.add(TextFieldTanggalMasukEditPopUp);
        TextFieldTanggalMasukEditPopUp.setBounds(180, 190, 180, 30);

        add(PanelPopUpEdit);
        PanelPopUpEdit.setBounds(260, 100, 400, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void TableSuratMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSuratMasukMouseClicked
    try{
        int baris = TableSuratMasuk.rowAtPoint(evt.getPoint());
          
        this.noSurat = TableSuratMasuk.getValueAt(baris,0 ).toString();
        this.perihal = TableSuratMasuk.getValueAt(baris,1 ).toString();
        this.deskripsi = TableSuratMasuk.getValueAt(baris,2 ).toString();
        this.tanggalDiterima = TableSuratMasuk.getValueAt(baris,3 ).toString();
        this.fileDigital = TableSuratMasuk.getValueAt(baris,4 ).toString();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Gagal memilih data" + e.getMessage());
    }
    }//GEN-LAST:event_TableSuratMasukMouseClicked

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        try{
            UIManager.put("OptionPane.yesButtonText", "Lanjutkan");
            UIManager.put("OptionPane.noButtonText", "Batalkan");
            
            if(this.noSurat != null){
                int option = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mendelete data pada baris ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    query.setNamaTabel("surat").setWhereId("id_surat", this.noSurat).delete();
                    bersihkanTextNull();
                } else {
                    throw new Exception("tidak jadi hapus data");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Tidak ada data yang dipilih");
            }
        }catch(Exception e){
            bersihkanTextNull();
        }
        menampilkanDataTableTerbaru();
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void ButtonBatalEditPopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBatalEditPopUpActionPerformed
        hideKomponenUpdateData();
    }//GEN-LAST:event_ButtonBatalEditPopUpActionPerformed

    private void ButtonUpdateEditPopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateEditPopUpActionPerformed
            UIManager.put("OptionPane.yesButtonText", "Lanjutkan");
            UIManager.put("OptionPane.noButtonText", "Batalkan");
            
            String getTextNoSurat = TextFieldSuratEditPopUp.getText();
            String getTextPerihalSurat = TextFieldPerihalEditPopUp.getText();
            String getTextPenerimaSurat = TextFieldDeskripsiEditPopUp.getText();
            String getTextTanggalMasukSurat = TextFieldTanggalMasukEditPopUp.getText();
            
            if(TextFieldSuratEditPopUp.getText() != null || TextFieldSuratEditPopUp.getText() != ""){
                int option = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Mengupdate data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if (option == JOptionPane.YES_OPTION) {
                    try{
                        String[] values = {getTextNoSurat,getTextPerihalSurat,getTextPenerimaSurat,getTextTanggalMasukSurat};
                        query.setNamaTabel("surat").setAtribut(this.atributs).setValue(values).setWhereId("id_surat", this.noSurat).update();
                        hideKomponenUpdateData();
                        bersihkanTextNull();
                        menampilkanDataTableTerbaru();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Gagal Melakukan Update Data, Pastikan semua data tersedia");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null,"Tidak jadi update data");
            }
    }//GEN-LAST:event_ButtonUpdateEditPopUpActionPerformed

    private void TextFieldCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCariActionPerformed
        menampilkanDataTableTerbaruPencarian();
    }//GEN-LAST:event_TextFieldCariActionPerformed

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        hideKomponenUtama();
        ambilText();
    }//GEN-LAST:event_ButtonEditActionPerformed

    private void ButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCetakActionPerformed

    }//GEN-LAST:event_ButtonCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBatalEditPopUp;
    private javax.swing.JButton ButtonCetak;
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonEdit;
    private javax.swing.JButton ButtonUpdateEditPopUp;
    private javax.swing.JComboBox<String> ComboBoxCari;
    private javax.swing.JLabel LabelCari;
    private javax.swing.JLabel LabelDashboardArsipMasuk;
    private javax.swing.JLabel LabelDeskripsiEditPopUp;
    private javax.swing.JLabel LabelFileEditPopUp;
    private javax.swing.JLabel LabelPerihalEditPopUp;
    private javax.swing.JLabel LabelSuratPopupEdit;
    private javax.swing.JLabel LabelTanggalMasukEditPopUp;
    private javax.swing.JPanel PanelPopUpEdit;
    private javax.swing.JTable TableSuratMasuk;
    private javax.swing.JTextField TextFieldCari;
    private javax.swing.JTextField TextFieldDeskripsiEditPopUp;
    private javax.swing.JTextField TextFieldPerihalEditPopUp;
    private javax.swing.JTextField TextFieldSuratEditPopUp;
    private javax.swing.JTextField TextFieldTanggalMasukEditPopUp;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
