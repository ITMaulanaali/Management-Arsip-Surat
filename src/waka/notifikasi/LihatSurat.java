/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package waka.notifikasi;

import javax.swing.*;


/**
 *
 * @author lan
 */
public class LihatSurat extends javax.swing.JPanel {
    
    private javax.swing.JLabel jLabelNoSurat;
    private javax.swing.JLabel jLabelTanggal;
    private javax.swing.JLabel jLabelPerihal;




   
    public LihatSurat() {
         initComponents();
    
    }
    // In the initComponents method
    public void setIsiSurat(String noSurat, String tanggal, String perihal) {
        
    JLabel jLabelNoSurat = new JLabel("No. Surat: " + noSurat);
    JLabel jLabelTanggal = new JLabel("Tanggal: " + tanggal);
    JLabel jLabelPerihal = new JLabel("Perihal: " + perihal);

    JPanel panel = new JPanel();
    panel.setLayout(new java.awt.GridLayout(0, 1));
    panel.add(jLabelNoSurat);
    panel.add(jLabelTanggal);
    panel.add(jLabelPerihal);

    jScrollPane1.setViewportView(panel);
}


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jButton1.setBackground(new java.awt.Color(214, 203, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(152, 152, 152)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(434, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1)))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // Kembali ke lembar disposisi
        jScrollPane1.setViewportView(new waka.notifikasi.LembarDisposisi());
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
       
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
