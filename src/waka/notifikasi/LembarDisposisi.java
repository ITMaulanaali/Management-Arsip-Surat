/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package waka.notifikasi;

import admin.menuKelolaAkun.TampilanKelolaAkun;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.Query;

public class LembarDisposisi extends javax.swing.JPanel {
    Query query;
    
    private String noDis;
    private String noSurat;
    private String perihall;
    private String tglDisposisi;
    private String catatanDisposisi;
    private String fileBiner;
    private String role;
    private String statusBaca;

    // Constructor
    public LembarDisposisi(String noDisposisi,String noSurat, String perihal, String tanggalDisposisi, String catatanDisposisi, String fileBiner, String role, String statusBaca) {
        initComponents();
        this.noDis = noDisposisi;
        this.noSurat = noSurat;
        this.perihall = perihal;
        this.tglDisposisi = tanggalDisposisi;
        this.catatanDisposisi = catatanDisposisi;
        this.fileBiner = fileBiner;
        this.role = role;
        this.statusBaca = statusBaca;
        this.query = new Query();
        setStatus();
        setLembar();
    }
    
        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon(getClass().getResource("/bahan/background/backgroundPanel800x483px.png"));
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    private void setLembar(){
        nosurat.setText(this.noSurat);
        jLabel20.setText(this.perihall);
        isiCatatan.setText(this.catatanDisposisi);
        tanggalDisposisi.setText(this.tglDisposisi);
        nomordisposisi.setText(this.noDis);
    }
    
    private void setStatus(){
        if("Sudah Dibaca".equals(this.statusBaca) && this.noDis != null){
            try{
            PreparedStatement statement = lib.Koneksi.Koneksi().prepareStatement("UPDATE surat_masuk SET status_notifikasi = 'Sudah Dibaca Waka' WHERE no_surat = ?");
            statement.setString(1, this.noSurat);
            boolean result = statement.execute();
            
                String totalNotif = waka.DashboardUtama.notifWaka.getText();
                int i = Integer.parseInt(totalNotif);
                waka.DashboardUtama.notifWaka.setText(Integer.toString(--i));
            
        }catch(Exception ex){
            Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                this.statusBaca = "Sudah Dibaca Waka";
            }
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomordisposisi = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nosurat = new javax.swing.JLabel();
        tanggalDisposisi = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        isiCatatan = new javax.swing.JTextArea();
        buttonLihat = new javax.swing.JButton();
        buttonLihat1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 480));
        setPreferredSize(new java.awt.Dimension(860, 480));

        nomordisposisi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nomordisposisi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomordisposisi.setText(" Lembar disposisi");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("No Surat.");

        nosurat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nosurat.setText("no surat masuk");

        tanggalDisposisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tanggalDisposisi.setText("12 Maret 2024");

        jPanel6.setBackground(new java.awt.Color(196, 196, 196));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Perihal");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Lomba Lks");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(196, 196, 196));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Catatan");

        isiCatatan.setEditable(false);
        isiCatatan.setBackground(new java.awt.Color(196, 196, 196));
        isiCatatan.setColumns(20);
        isiCatatan.setLineWrap(true);
        isiCatatan.setRows(5);
        isiCatatan.setWrapStyleWord(true);
        isiCatatan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(isiCatatan);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel21)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        buttonLihat.setBackground(new java.awt.Color(206, 31, 31));
        buttonLihat.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonLihat.setText("Lihat Surat");
        buttonLihat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLihatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonLihatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonLihatMouseExited(evt);
            }
        });

        buttonLihat1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonLihat1.setText("Kembali");
        buttonLihat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLihat1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonLihat1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonLihat1MouseExited(evt);
            }
        });
        buttonLihat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLihat1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(nomordisposisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(buttonLihat1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(380, 380, 380)
                .addComponent(buttonLihat, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nosurat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tanggalDisposisi)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(nomordisposisi, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(nosurat))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(tanggalDisposisi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonLihat1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLihat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLihatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLihatMouseClicked
        buttonLihat.setBackground(new Color(206,31,31));

        waka.DashboardUtama.SubPanel.removeAll();
        waka.DashboardUtama.SubPanel.add(new waka.notifikasi.LihatSuratv2(this.noDis,this.noSurat,this.perihall,this.tglDisposisi,this.catatanDisposisi, this.fileBiner, this.role, this.statusBaca));
        waka.DashboardUtama.SubPanel.revalidate();
        waka.DashboardUtama.SubPanel.repaint();
    }//GEN-LAST:event_buttonLihatMouseClicked

    private void buttonLihatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLihatMouseEntered
        buttonLihat.setBackground(new Color(255,255,255));
        buttonLihat.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonLihatMouseEntered

    private void buttonLihatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLihatMouseExited
        buttonLihat.setBackground(new Color(206,31,31));
        buttonLihat.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonLihatMouseExited

    private void buttonLihat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLihat1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLihat1MouseClicked

    private void buttonLihat1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLihat1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLihat1MouseEntered

    private void buttonLihat1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLihat1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonLihat1MouseExited

    private void buttonLihat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLihat1ActionPerformed
        waka.DashboardUtama.SubPanel.removeAll();
        waka.DashboardUtama.SubPanel.add(new waka.notifikasi.TampilanSuratTerdisposisiv2(this.role));
        waka.DashboardUtama.SubPanel.revalidate();
        waka.DashboardUtama.SubPanel.repaint();
    }//GEN-LAST:event_buttonLihat1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLihat;
    private javax.swing.JButton buttonLihat1;
    private javax.swing.JTextArea isiCatatan;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nomordisposisi;
    private javax.swing.JLabel nosurat;
    private javax.swing.JLabel tanggalDisposisi;
    // End of variables declaration//GEN-END:variables


}
