package com;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import lib.database.Query;
import penghubungPanel.Penghubung;

public class SubPanelEdit extends javax.swing.JPanel{
    Penghubung DashboardUtama;
    Query query;
    String[] atributs = {"id_surat","no_surat","perihal","deskripsi","tanggal_diterima","nama_surat","file_digital"};
    String[] valuesTable;
    String hasil;

    SubPanelEdit(Penghubung jembatan) {
        initComponents();
        this.DashboardUtama = jembatan;
        this.valuesTable = jembatan.giveValuesPanelTable();
        setText();
        for(String i : this.valuesTable){
            System.out.println(i);
        }
    }
    
    void onDataReceived(String data){
        System.out.println(data);
    }
    
    String dataBawaan(){
        System.out.println("Harusnya ada data");
        return this.hasil;
    }
    
   void setText(){
       valueIdSurat.setText(this.valuesTable[0]);
       OutputLabelNoSurat.setText(this.valuesTable[1]);
       TextFieldPerihalEditPopUp.setText(this.valuesTable[2]);
       TextFieldDeskripsiEditPopUp.setText(this.valuesTable[3]);
       TextFieldTanggalDiterimaEditPopUp.setText(this.valuesTable[4]);
       OutputFileEditPopUp.setText(this.valuesTable[5]);
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelFileEditPopUp = new javax.swing.JLabel();
        OutputLabelNoSurat = new javax.swing.JLabel();
        LabelPerihalEditPopUp = new javax.swing.JLabel();
        LabelDeskripsiEditPopUp = new javax.swing.JLabel();
        LabelTanggalDiterimaEditPopUp = new javax.swing.JLabel();
        ButtonBatalEditPopUp = new javax.swing.JButton();
        ButtonUpdateEditPopUp = new javax.swing.JButton();
        TextFieldPerihalEditPopUp = new javax.swing.JTextField();
        TextFieldDeskripsiEditPopUp = new javax.swing.JTextField();
        TextFieldTanggalDiterimaEditPopUp = new javax.swing.JTextField();
        LabelSuratPopupEdit = new javax.swing.JLabel();
        OutputFileEditPopUp = new javax.swing.JLabel();
        ButtonFileUploadEditPopUp = new javax.swing.JButton();
        LabelIdSurat = new javax.swing.JLabel();
        valueIdSurat = new javax.swing.JLabel();

        setLayout(null);

        LabelFileEditPopUp.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelFileEditPopUp.setText("File:");
        add(LabelFileEditPopUp);
        LabelFileEditPopUp.setBounds(70, 270, 60, 30);

        OutputLabelNoSurat.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        OutputLabelNoSurat.setText("No. Surat:");
        add(OutputLabelNoSurat);
        OutputLabelNoSurat.setBounds(250, 70, 480, 30);

        LabelPerihalEditPopUp.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelPerihalEditPopUp.setText("Perihal:");
        add(LabelPerihalEditPopUp);
        LabelPerihalEditPopUp.setBounds(70, 120, 80, 30);

        LabelDeskripsiEditPopUp.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelDeskripsiEditPopUp.setText("Deskripsi :");
        add(LabelDeskripsiEditPopUp);
        LabelDeskripsiEditPopUp.setBounds(70, 170, 90, 30);

        LabelTanggalDiterimaEditPopUp.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelTanggalDiterimaEditPopUp.setText("Tanggal Diterima:");
        add(LabelTanggalDiterimaEditPopUp);
        LabelTanggalDiterimaEditPopUp.setBounds(70, 220, 150, 30);

        ButtonBatalEditPopUp.setText("Batal");
        ButtonBatalEditPopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBatalEditPopUpActionPerformed(evt);
            }
        });
        add(ButtonBatalEditPopUp);
        ButtonBatalEditPopUp.setBounds(560, 320, 180, 40);

        ButtonUpdateEditPopUp.setText("Update");
        ButtonUpdateEditPopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateEditPopUpActionPerformed(evt);
            }
        });
        add(ButtonUpdateEditPopUp);
        ButtonUpdateEditPopUp.setBounds(560, 370, 180, 40);
        add(TextFieldPerihalEditPopUp);
        TextFieldPerihalEditPopUp.setBounds(250, 120, 480, 30);
        add(TextFieldDeskripsiEditPopUp);
        TextFieldDeskripsiEditPopUp.setBounds(250, 170, 480, 30);
        add(TextFieldTanggalDiterimaEditPopUp);
        TextFieldTanggalDiterimaEditPopUp.setBounds(250, 220, 480, 30);

        LabelSuratPopupEdit.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelSuratPopupEdit.setText("No. Surat:");
        add(LabelSuratPopupEdit);
        LabelSuratPopupEdit.setBounds(70, 70, 80, 30);

        OutputFileEditPopUp.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        OutputFileEditPopUp.setText("File:");
        add(OutputFileEditPopUp);
        OutputFileEditPopUp.setBounds(250, 270, 480, 30);

        ButtonFileUploadEditPopUp.setText("Pilih File");
        ButtonFileUploadEditPopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFileUploadEditPopUpActionPerformed(evt);
            }
        });
        add(ButtonFileUploadEditPopUp);
        ButtonFileUploadEditPopUp.setBounds(250, 320, 90, 30);

        LabelIdSurat.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelIdSurat.setText("No. Surat:");
        add(LabelIdSurat);
        LabelIdSurat.setBounds(70, 30, 80, 30);

        valueIdSurat.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        valueIdSurat.setText("No. Surat:");
        add(valueIdSurat);
        valueIdSurat.setBounds(250, 30, 480, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBatalEditPopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBatalEditPopUpActionPerformed
        this.DashboardUtama.pindahToSubPanelTable();
    }//GEN-LAST:event_ButtonBatalEditPopUpActionPerformed

    private void ButtonUpdateEditPopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateEditPopUpActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Lanjutkan");
        UIManager.put("OptionPane.noButtonText", "Batalkan");

        //input data dari halaman edit Data(pikir kembali apakah harus diglobal karena setelah update harusnya data tidak digunakan kembali)
        //Belum ditambahkan tambah File yang type data blob
        String[] valueEdit = new String[this.atributs.length];

        valueEdit[0] = valueIdSurat.getText();
        valueEdit[1] = OutputLabelNoSurat.getText();
        valueEdit[2] = TextFieldPerihalEditPopUp.getText();
        valueEdit[4] = TextFieldDeskripsiEditPopUp.getText();
        valueEdit[3] = TextFieldTanggalDiterimaEditPopUp.getText();
        valueEdit[4] = OutputFileEditPopUp.getText();

        if(valueEdit[0] != null || valueEdit[0] != ""){
            int option = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Mengupdate data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (option == JOptionPane.YES_OPTION) {
                try{
                    //                        String[] values = {getTextNoSurat,getTextPerihalSurat,getTextDeskripsiSurat,dataFile,getTextTanggalMasukSurat};
                    query.setNamaTabel("surat").setAtribut(this.atributs).setValue(valueEdit).setWhereId(this.atributs[0], this.valuesTable[0]).update();
//                    hideKomponenUpdateData();
//                    bersihkanTextNull(this.valuePerBaris);
                      this.DashboardUtama.pindahToSubPanelTable();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Gagal Melakukan Update Data, Pastikan semua data tersedia");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Tidak jadi update data");
        }
    }//GEN-LAST:event_ButtonUpdateEditPopUpActionPerformed

    private void ButtonFileUploadEditPopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFileUploadEditPopUpActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter("pdf", "pdf"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("doc", "doc","docx"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("jpg", "jpg","jpeg"));
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            OutputFileEditPopUp.setText(filePath);
        }
    }//GEN-LAST:event_ButtonFileUploadEditPopUpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBatalEditPopUp;
    private javax.swing.JButton ButtonFileUploadEditPopUp;
    private javax.swing.JButton ButtonUpdateEditPopUp;
    private javax.swing.JLabel LabelDeskripsiEditPopUp;
    private javax.swing.JLabel LabelFileEditPopUp;
    private javax.swing.JLabel LabelIdSurat;
    private javax.swing.JLabel LabelPerihalEditPopUp;
    private javax.swing.JLabel LabelSuratPopupEdit;
    private javax.swing.JLabel LabelTanggalDiterimaEditPopUp;
    private javax.swing.JLabel OutputFileEditPopUp;
    private javax.swing.JLabel OutputLabelNoSurat;
    private javax.swing.JTextField TextFieldDeskripsiEditPopUp;
    private javax.swing.JTextField TextFieldPerihalEditPopUp;
    private javax.swing.JTextField TextFieldTanggalDiterimaEditPopUp;
    private javax.swing.JLabel valueIdSurat;
    // End of variables declaration//GEN-END:variables
}
