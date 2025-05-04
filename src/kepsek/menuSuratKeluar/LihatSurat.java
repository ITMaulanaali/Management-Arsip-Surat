/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kepsek.menuSuratKeluar;

import admin.menuSuratMasuk.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.PdfDiJpanel;

public class LihatSurat extends javax.swing.JPanel {
    String[] data;
    byte[] pdfBiner;
    public LihatSurat(String[] data, byte[] pdfBiner) {
        initComponents();
        this.data = data;
        try {
            imageLabel.setIcon(new PdfDiJpanel().addByteFile(pdfBiner).getIcon());
        } catch (Exception ex) {
            Logger.getLogger(admin.menuSuratKeluar.LihatSurat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        imageLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        Kembali.setBackground(new java.awt.Color(214, 203, 203));
        Kembali.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Kembali.setText("Kembali");
        Kembali.setMinimumSize(new java.awt.Dimension(83, 40));
        Kembali.setPreferredSize(new java.awt.Dimension(80, 40));
        Kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KembaliMouseClicked(evt);
            }
        });
        Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(imageLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 400, Short.MAX_VALUE)
                        .addComponent(Kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void KembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliActionPerformed
        // TODO add your handling code here:
        kepsek.DashboardUtama.SubPanel.removeAll();
        kepsek.DashboardUtama.SubPanel.add(new kepsek.menuSuratKeluar.TampilanSuratKeluar());
        kepsek.DashboardUtama.SubPanel.revalidate();
        kepsek.DashboardUtama.SubPanel.repaint();
    }//GEN-LAST:event_KembaliActionPerformed

    private void KembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KembaliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_KembaliMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kembali;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
