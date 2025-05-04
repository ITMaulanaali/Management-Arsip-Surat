/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package waka.notifikasi;

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


public class LembarDisposisi extends javax.swing.JPanel {
    
    private String noDis;
    private String noSurat;
    private String perihall;
    private String tglDisposisi;
    private String catatanDisposisi;

    // Constructor
    public LembarDisposisi(String noDisposisi,String noSurat, String perihal, String tanggalDisposisi, String catatanDisposisi) {
        initComponents();
        this.noDis = noDisposisi;
        this.noSurat = noSurat;
        this.perihall = perihal;
        this.tglDisposisi = tanggalDisposisi;
        this.catatanDisposisi = catatanDisposisi;
        setLembar();
    }
    
    private void setLembar(){
        nosurat.setText(this.noSurat);
        jLabel20.setText(this.perihall);
        isiCatatan.setText(this.catatanDisposisi);
        tanggalDisposisi.setText(this.tglDisposisi);
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nosurat = new javax.swing.JLabel();
        tanggalDisposisi = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        isiCatatan = new javax.swing.JLabel();
        buttonLihat = new javax.swing.JButton();
        buttonLihat1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Lembar disposisi");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("No Surat.");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Perihal");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Lomba Lks");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Catatan");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Harap bapak/Ibu Waka mempersiapkan muridnya untuk lomba LKS...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Lihat Surrat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("12 Maret 2024");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("No Surat. 254/ADC/2024");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(368, 368, 368))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(453, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel10))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(260, 260, 260))
        );

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 480));
        setPreferredSize(new java.awt.Dimension(860, 480));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("12 Maret 2024");

        jLabel2.setFont(new java.awt.Font("C059", 1, 12)); // NOI18N
        jLabel2.setText("_____________________________________________________________________________________________________________________________________");

        jButton2.setBackground(new java.awt.Color(206, 31, 31));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Lihat Surat");
        jButton2.setPreferredSize(new java.awt.Dimension(80, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(" Lembar disposisi");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("No Surat.");

        nosurat.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nosurat.setText("no surat masuk");

        tanggalDisposisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tanggalDisposisi.setText("12 Maret 2024");

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
                .addContainerGap(709, Short.MAX_VALUE))
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

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Catatan");

        isiCatatan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        isiCatatan.setText("Harap bapak/Ibu Waka mempersiapkan muridnya untuk lomba LKS...");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiCatatan)
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(isiCatatan)
                .addContainerGap(18, Short.MAX_VALUE))
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

        buttonLihat1.setBackground(new java.awt.Color(206, 31, 31));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nosurat)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tanggalDisposisi))
                                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(buttonLihat1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonLihat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(nosurat))
                            .addComponent(tanggalDisposisi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonLihat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonLihat1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(349, 349, 349)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents
//    
//        private void initclumComponents() {
//        jPanelBackground = new JPanel();
//        jLabelNomorSurat = new JLabel();
//        jLabelPerihal = new JLabel();
//        jLabelCatatan = new JLabel();
//        jLabelTanggal = new JLabel();
//        jButtonLihatSurat = new JButton("Lihat Surat");
//        jButtonKembali = new JButton("Kembali");
//        scrollPane = new JScrollPane();
//
//        setLayout(new BorderLayout());
//        jPanelBackground.setBackground(new Color(245, 245, 245));
//        jPanelBackground.setLayout(new GridBagLayout());
//        
//        addComponentsToPanel();
//        
//        jButtonLihatSurat.addActionListener(evt -> bukaLihatSurat());
//        jButtonKembali.addActionListener(evt -> kembali());
//
//        add(jPanelBackground, BorderLayout.CENTER);
//    }
//
//    private void addComponentsToPanel() {
//         GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 10, 10);
//        gbc.anchor = GridBagConstraints.WEST;
//
//        // Add labels and buttons to jPanelBackground
//        // (omitted for brevity, similar structure to your original code)
//        
//        gbc.gridx = 0;
//        gbc.gridy++;
//        jPanelBackground.add(jButtonLihatSurat, gbc);
//
//        gbc.gridx = 1;
//        jPanelBackground.add(jButtonKembali, gbc);
//    }
//
//    public void setData(String nomorDisposisi, String nomorSurat, String perihal, String tanggal) {
//        jLabelNomorSurat.setText(nomorSurat);
//        jLabelPerihal.setText(perihal);
//        jLabelTanggal.setText(tanggal);
//    }
//     private void bukaLihatSurat() {
//        // Create content for the PDF-like view
//        JPanel pdfPanel = new JPanel();
//        pdfPanel.setLayout(new BoxLayout(pdfPanel, BoxLayout.Y_AXIS));
//        pdfPanel.add(new JLabel("Surat Permohonan Lomba LKS"));
//        pdfPanel.add(new JLabel("No. Surat: " + jLabelNomorSurat.getText()));
//        pdfPanel.add(new JLabel("Perihal: " + jLabelPerihal.getText()));
//        pdfPanel.add(new JLabel("Tanggal: " + jLabelTanggal.getText()));
//        pdfPanel.add(new JLabel("Sehubungan dengan lomba LKS"));
//        pdfPanel.add(new JLabel("Terimakasih"));
//        pdfPanel.add(new JLabel("Hormat,"));
//        pdfPanel.add(new JLabel("Nama"));
//
//        // Add the pdfPanel to the scrollPane
//        scrollPane.setViewportView(pdfPanel);
//        JScrollPane scrollPane = new JScrollPane(pdfPanel);
//        JOptionPane.showMessageDialog(this, scrollPane, "PDF View", JOptionPane.INFORMATION_MESSAGE);
//    }
//     
//     
//    private void kembali() {
//        // Your return logic goes here
//    }
//
//
//
//     
//     
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Kalau tombol kembali, mungkin kembali ke panel utama atau clear
        
        waka.DashboardUtama.SubPanel.removeAll();
        waka.DashboardUtama.SubPanel.add(new waka.notifikasi.TampilanSuratTerdisposisi());
        waka.DashboardUtama.SubPanel.revalidate();
        waka.DashboardUtama.SubPanel.repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         // Misal mau buka panel LihatSurat
         jPanel1.removeAll();
        jPanel1.add(new waka.notifikasi.LihatSurat());
        jPanel1.revalidate();
        jPanel1.repaint();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonLihatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLihatMouseClicked
        buttonLihat.setBackground(new Color(206,31,31));

        waka.DashboardUtama.SubPanel.removeAll();
        waka.DashboardUtama.SubPanel.add(new waka.notifikasi.LihatSurat(this.noDis,this.noSurat,this.perihall,this.tglDisposisi,this.catatanDisposisi));
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLihat;
    private javax.swing.JButton buttonLihat1;
    private javax.swing.JLabel isiCatatan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel nosurat;
    private javax.swing.JLabel tanggalDisposisi;
    // End of variables declaration//GEN-END:variables


}
