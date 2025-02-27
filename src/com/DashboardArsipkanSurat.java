package com;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import lib.database.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DashboardArsipkanSurat extends javax.swing.JPanel {
    Query query;
    String[] atributsSuratMasuk = {"no_surat","perihal","deskripsi","tanggal_diterima","nama_surat","file_digital"};
    String[] atributsSuratKeluar = {"no_surat","perihal","deskripsi","tanggal_dikeluarkan","penerima","nama_surat","file_digital"};
    String pathFile;

//    String noSurat, perihal, deskripsi, fileDigital, tanggalDiterima, tanggalDikeluarkan, penerima;
    
    public DashboardArsipkanSurat() {
        initComponents();
        this.query = new Query();
        PanelSuratKeluar.setVisible(false);
        PanelSuratMasuk.setVisible(false);
    }
    
    void bersihkanTextKosong(){
        InputNoSurat.setText("");
        inputPerihal.setText("");
        inputDeskripsi.setText("");
        NamaFile.setText(""); //ganti dengan format file
        inputTanggalMasuk.setText("");
        inputTanggalKeluar.setText("");
        inputPenerima.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonArsipkan = new javax.swing.JButton();
        LabelDashboardArsipkanSurat = new javax.swing.JLabel();
        LabelDeskripsi = new javax.swing.JLabel();
        LabelNoSurat = new javax.swing.JLabel();
        LabelPerihal = new javax.swing.JLabel();
        RadioButtonSuratKeluar = new javax.swing.JRadioButton();
        RadioButtonSuratMasuk = new javax.swing.JRadioButton();
        InputNoSurat = new javax.swing.JTextField();
        inputPerihal = new javax.swing.JTextField();
        inputDeskripsi = new javax.swing.JTextField();
        LabelFile1 = new javax.swing.JLabel();
        NamaFile = new javax.swing.JTextField();
        PanelSuratMasuk = new javax.swing.JPanel();
        PanelSuratMasukLabelTanggalMasuk = new javax.swing.JLabel();
        inputTanggalMasuk = new javax.swing.JTextField();
        PanelSuratKeluar = new javax.swing.JPanel();
        PanelSuratKeluarLabelPenerima = new javax.swing.JLabel();
        PanelSuratKeluarLabelTanggalKeluar = new javax.swing.JLabel();
        inputPenerima = new javax.swing.JTextField();
        inputTanggalKeluar = new javax.swing.JTextField();
        ButtonFileUpload = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(950, 6000));
        setPreferredSize(new java.awt.Dimension(950, 600));
        setLayout(null);

        ButtonArsipkan.setText("Tambahkan");
        ButtonArsipkan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ButtonArsipkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonArsipkanActionPerformed(evt);
            }
        });
        add(ButtonArsipkan);
        ButtonArsipkan.setBounds(60, 490, 810, 50);

        LabelDashboardArsipkanSurat.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        LabelDashboardArsipkanSurat.setText("Dashboard Arsipkan Surat");
        add(LabelDashboardArsipkanSurat);
        LabelDashboardArsipkanSurat.setBounds(337, 5, 310, 28);

        LabelDeskripsi.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelDeskripsi.setText("Deskripsi :");
        add(LabelDeskripsi);
        LabelDeskripsi.setBounds(70, 220, 90, 30);

        LabelNoSurat.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelNoSurat.setText("No. Surat :");
        add(LabelNoSurat);
        LabelNoSurat.setBounds(70, 100, 90, 30);

        LabelPerihal.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelPerihal.setText("Perihal :");
        add(LabelPerihal);
        LabelPerihal.setBounds(70, 160, 70, 30);

        RadioButtonSuratKeluar.setText("Surat Keluar");
        RadioButtonSuratKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadioButtonSuratKeluarMouseClicked(evt);
            }
        });
        add(RadioButtonSuratKeluar);
        RadioButtonSuratKeluar.setBounds(70, 420, 114, 22);

        RadioButtonSuratMasuk.setText("Surat Masuk");
        RadioButtonSuratMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadioButtonSuratMasukMouseClicked(evt);
            }
        });
        add(RadioButtonSuratMasuk);
        RadioButtonSuratMasuk.setBounds(70, 380, 104, 22);

        InputNoSurat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        InputNoSurat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputNoSuratActionPerformed(evt);
            }
        });
        add(InputNoSurat);
        InputNoSurat.setBounds(170, 100, 700, 30);

        inputPerihal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inputPerihal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPerihalActionPerformed(evt);
            }
        });
        add(inputPerihal);
        inputPerihal.setBounds(170, 160, 700, 30);

        inputDeskripsi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inputDeskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDeskripsiActionPerformed(evt);
            }
        });
        add(inputDeskripsi);
        inputDeskripsi.setBounds(170, 220, 700, 30);

        LabelFile1.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        LabelFile1.setText("File :");
        add(LabelFile1);
        LabelFile1.setBounds(70, 280, 80, 30);

        NamaFile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        NamaFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaFileActionPerformed(evt);
            }
        });
        add(NamaFile);
        NamaFile.setBounds(170, 280, 700, 30);

        PanelSuratMasuk.setLayout(null);

        PanelSuratMasukLabelTanggalMasuk.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        PanelSuratMasukLabelTanggalMasuk.setText("Tanggal Masuk :");
        PanelSuratMasuk.add(PanelSuratMasukLabelTanggalMasuk);
        PanelSuratMasukLabelTanggalMasuk.setBounds(0, 0, 140, 30);

        inputTanggalMasuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inputTanggalMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTanggalMasukActionPerformed(evt);
            }
        });
        PanelSuratMasuk.add(inputTanggalMasuk);
        inputTanggalMasuk.setBounds(0, 30, 410, 30);

        add(PanelSuratMasuk);
        PanelSuratMasuk.setBounds(460, 330, 410, 60);

        PanelSuratKeluar.setLayout(null);

        PanelSuratKeluarLabelPenerima.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        PanelSuratKeluarLabelPenerima.setText("Penerima :");
        PanelSuratKeluar.add(PanelSuratKeluarLabelPenerima);
        PanelSuratKeluarLabelPenerima.setBounds(0, 0, 140, 30);

        PanelSuratKeluarLabelTanggalKeluar.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        PanelSuratKeluarLabelTanggalKeluar.setText("Tanggal Keluar :");
        PanelSuratKeluar.add(PanelSuratKeluarLabelTanggalKeluar);
        PanelSuratKeluarLabelTanggalKeluar.setBounds(0, 70, 140, 30);

        inputPenerima.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inputPenerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPenerimaActionPerformed(evt);
            }
        });
        PanelSuratKeluar.add(inputPenerima);
        inputPenerima.setBounds(0, 30, 410, 30);

        inputTanggalKeluar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inputTanggalKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTanggalKeluarActionPerformed(evt);
            }
        });
        PanelSuratKeluar.add(inputTanggalKeluar);
        inputTanggalKeluar.setBounds(0, 100, 410, 30);

        add(PanelSuratKeluar);
        PanelSuratKeluar.setBounds(460, 330, 410, 130);

        ButtonFileUpload.setText("Pilih File");
        ButtonFileUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFileUploadActionPerformed(evt);
            }
        });
        add(ButtonFileUpload);
        ButtonFileUpload.setBounds(170, 320, 130, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void InputNoSuratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputNoSuratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputNoSuratActionPerformed

    private void inputPerihalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPerihalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPerihalActionPerformed

    private void inputDeskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDeskripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDeskripsiActionPerformed

    private void inputTanggalKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTanggalKeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTanggalKeluarActionPerformed

    private void NamaFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaFileActionPerformed

    private void inputPenerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPenerimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPenerimaActionPerformed

    private void ButtonArsipkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonArsipkanActionPerformed
        if(RadioButtonSuratMasuk.isSelected() == true){
            String[] values = {InputNoSurat.getText(),inputPerihal.getText(),inputDeskripsi.getText(),inputTanggalMasuk.getText(),NamaFile.getText(),this.pathFile};
            int hasil = query.setNamaTabel("surat").setAtribut(this.atributsSuratMasuk).setValue(values).insert();
            
                if(hasil == 1){
                    JOptionPane.showMessageDialog(null,"Berhasil mengarsipkan Surat Masuk");
                    new DashboardArsipMasuk();
                    bersihkanTextKosong();
                    PanelSuratKeluar.setVisible(false);
                    PanelSuratMasuk.setVisible(false);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Gagal mengarsipkan Surat");
                }
                
        }else if(RadioButtonSuratKeluar.isSelected() == true){
            
            String[] atributs = {"no_surat","perihal","deskripsi","tanggal_dikeluarkan","penerima","nama_surat","file_digital"};
            System.out.println(this.pathFile);
            String[] values = {InputNoSurat.getText(),inputPerihal.getText(),inputDeskripsi.getText(),inputTanggalKeluar.getText(),inputPenerima.getText(),NamaFile.getText(),this.pathFile};
            int hasil = query.setNamaTabel("surat").setAtribut(atributs).setValue(values).setValuePath(this.pathFile).insert();

                if(hasil == 1){
                    JOptionPane.showMessageDialog(null,"Berhasil mengarsipkan Surat Masuk");
                    new DashboardArsipMasuk();
                    bersihkanTextKosong();
                    PanelSuratKeluar.setVisible(false);
                    PanelSuratMasuk.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Gagal mengarsipkan Surat");
                }
        }
    }//GEN-LAST:event_ButtonArsipkanActionPerformed

    private void inputTanggalMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTanggalMasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTanggalMasukActionPerformed

    private void RadioButtonSuratMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadioButtonSuratMasukMouseClicked
        if(RadioButtonSuratMasuk.isSelected()){
            RadioButtonSuratKeluar.setSelected(false);
            
            PanelSuratKeluar.setVisible(false);
            PanelSuratMasuk.setVisible(true);
        }else{
            RadioButtonSuratMasuk.setSelected(false);
            
            PanelSuratMasuk.setVisible(false);
            PanelSuratKeluar.setVisible(true);
        }
    }//GEN-LAST:event_RadioButtonSuratMasukMouseClicked

    private void RadioButtonSuratKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadioButtonSuratKeluarMouseClicked
        if(RadioButtonSuratKeluar.isSelected()){
            RadioButtonSuratMasuk.setSelected(false);
            
            PanelSuratMasuk.setVisible(false);
            PanelSuratKeluar.setVisible(true);            

        }else{
            RadioButtonSuratMasuk.setSelected(false);
            
            PanelSuratKeluar.setVisible(false);
            PanelSuratMasuk.setVisible(true);
        }
    }//GEN-LAST:event_RadioButtonSuratKeluarMouseClicked

    private void ButtonFileUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFileUploadActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter("pdf", "pdf"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("docx", "doc","docx"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("jpg", "jpg","jpeg"));
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String pathLengkap = selectedFile.getAbsolutePath();
            
            String[] fileDigital = pathLengkap.split("/");
            String namaFile = fileDigital[fileDigital.length-1];
            NamaFile.setText(namaFile);
            this.pathFile = pathLengkap;
        }
    }//GEN-LAST:event_ButtonFileUploadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonArsipkan;
    private javax.swing.JButton ButtonFileUpload;
    private javax.swing.JTextField InputNoSurat;
    private javax.swing.JLabel LabelDashboardArsipkanSurat;
    private javax.swing.JLabel LabelDeskripsi;
    private javax.swing.JLabel LabelFile1;
    private javax.swing.JLabel LabelNoSurat;
    private javax.swing.JLabel LabelPerihal;
    private javax.swing.JTextField NamaFile;
    private javax.swing.JPanel PanelSuratKeluar;
    private javax.swing.JLabel PanelSuratKeluarLabelPenerima;
    private javax.swing.JLabel PanelSuratKeluarLabelTanggalKeluar;
    private javax.swing.JPanel PanelSuratMasuk;
    private javax.swing.JLabel PanelSuratMasukLabelTanggalMasuk;
    private javax.swing.JRadioButton RadioButtonSuratKeluar;
    private javax.swing.JRadioButton RadioButtonSuratMasuk;
    private javax.swing.JTextField inputDeskripsi;
    private javax.swing.JTextField inputPenerima;
    private javax.swing.JTextField inputPerihal;
    private javax.swing.JTextField inputTanggalKeluar;
    private javax.swing.JTextField inputTanggalMasuk;
    // End of variables declaration//GEN-END:variables
}
