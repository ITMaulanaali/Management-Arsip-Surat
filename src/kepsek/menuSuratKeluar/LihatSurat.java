/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kepsek.menuSuratKeluar;

import admin.menuKelolaAkun.TampilanKelolaAkun;
import admin.menuSuratMasuk.*;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import lib.PdfDiJpanel;

public class LihatSurat extends javax.swing.JPanel {
    private PdfDiJpanel pdf;
    String[] data;
    private byte[] fileBiner;
    
    public LihatSurat(String[] data, byte[] pdfBiner) {
       initComponents();
        this.data = data;
        this.fileBiner = fileBiner;
        this.pdf = new PdfDiJpanel();
        
        setupContent();
        refreshNotif();
    }
    
        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon(getClass().getResource("/bahan/background/backgroundPanel800x483px.png"));
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    private void refreshNotif(){
        if(!this.data[5].equals("Sudah Dibaca")){
            try{
            PreparedStatement statement = lib.Koneksi.Koneksi().prepareStatement("UPDATE surat_masuk SET status_notifikasi = 'Sudah Dibaca' WHERE no_surat = ?");
            statement.setString(1, this.data[0]);
            boolean result = statement.execute();
            
                String totalNotif = kepsek.DashboardUtama.notif.getText();
                int i = Integer.parseInt(totalNotif);
                kepsek.DashboardUtama.notif.setText(Integer.toString(--i));
            
        }catch(Exception ex){
            Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    private void setupContent() {
        // Create a panel to hold the content
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setLayout(new java.awt.BorderLayout());

        // Create the label for "Lombah sekolah jatim"
        javax.swing.JLabel contentLabel = new javax.swing.JLabel();
        contentLabel.setFont(new java.awt.Font("Times New Roman", 0, 16));
        contentLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        contentLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        
                
        try {
            contentLabel.setIcon(pdf.addByteFile(this.fileBiner).getIcon());
        } catch (Exception ex) {
            Logger.getLogger(kepsek.menuSuratMasuk.LihatSurat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Add the label to the content panel
        contentPanel.add(contentLabel, java.awt.BorderLayout.CENTER);
        
        // Set the content panel as the view for the scroll pane
        jScrollPane1.setViewportView(contentPanel);
        jScrollPane1.setBorder(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        perbesar = new javax.swing.JLabel();
        perkecil = new javax.swing.JLabel();

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

        perbesar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/memperbesar-30px.png"))); // NOI18N
        perbesar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perbesarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                perbesarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                perbesarMouseExited(evt);
            }
        });

        perkecil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/memperkecil-30px.png"))); // NOI18N
        perkecil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perkecilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                perkecilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                perkecilMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(perbesar)
                    .addComponent(perkecil))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(perbesar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(perkecil, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
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

    private void perbesarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perbesarMouseClicked
        // TODO add your handling code here:
       try {
            this.pdf.zoomOut();
            setupContent();
        } catch (Exception ex) {
            Logger.getLogger(kepsek.menuSuratKeluar.LihatSurat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_perbesarMouseClicked

    private void perbesarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perbesarMouseEntered
    perbesar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    }//GEN-LAST:event_perbesarMouseEntered

    private void perbesarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perbesarMouseExited
    perbesar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    }//GEN-LAST:event_perbesarMouseExited

    private void perkecilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perkecilMouseClicked
    
        try {
            this.pdf.zoomIn();
             setupContent();
        } catch (Exception ex) {
            Logger.getLogger(kepsek.menuSuratMasuk.LihatSurat.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_perkecilMouseClicked

    private void perkecilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perkecilMouseEntered
    perkecil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    }//GEN-LAST:event_perkecilMouseEntered

    private void perkecilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perkecilMouseExited
    perkecil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse
    }//GEN-LAST:event_perkecilMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kembali;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel perbesar;
    private javax.swing.JLabel perkecil;
    // End of variables declaration//GEN-END:variables
}
