/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kepsek.menuSuratKeluar;

import admin.menuSuratMasuk.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LihatSurat extends javax.swing.JPanel {

    private JPanel parentPanel;
    private CardLayout parentLayout;
    private String previousPanel;
    private int suratId;
    
    public LihatSurat() {
         initComponents();
        setupUI();
    }

    public LihatSurat(JPanel parent, CardLayout layout, String previous) {
        initComponents();
        this.parentPanel = parent;
        this.parentLayout = layout;
        this.previousPanel = previous;
        setupUI();
    }
    
     public void setSuratId(int id) {
        this.suratId = id;
        loadSuratContent(id);
    }
     
     private void setupUI() {
        // Create and set up the text area for displaying letter content
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textArea);
        
        // Add a title label
        JLabel titleLabel = new JLabel("Lihat Detail Surat");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Add the label to the layout
        GroupLayout layout = (GroupLayout) getLayout();
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                        .addGap(150, 150, 150))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titleLabel)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 360, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(23, 23, 23))
        );
        
        // Set up the back button action
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
        });
    }
    
    /**
     * Load letter content from database or data source
     * @param id ID of the letter to load
     */
    private void loadSuratContent(int id) {
        // This method would connect to your data source to retrieve the letter content
        // For demonstration, we'll just set some placeholder text
        JTextArea textArea = (JTextArea) jScrollPane1.getViewport().getView();
        
        StringBuilder sampleContent = new StringBuilder();
        sampleContent.append("NOMOR SURAT: ").append(String.format("SK/00%d/IV/2025\n\n", id));
        sampleContent.append("PERIHAL: Sample Surat Keluar\n\n");
        sampleContent.append("Kepada Yth.\nBapak/Ibu Penerima\nDi Tempat\n\n");
        sampleContent.append("Dengan hormat,\n\n");
        sampleContent.append("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ");
        sampleContent.append("ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco ");
        sampleContent.append("laboris nisi ut aliquip ex ea commodo consequat.\n\n");
        sampleContent.append("Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. ");
        sampleContent.append("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n\n");
        sampleContent.append("Demikian surat ini kami sampaikan. Atas perhatian dan kerjasamanya kami ucapkan terima kasih.\n\n");
        sampleContent.append("Hormat kami,\n\n\n\n");
        sampleContent.append("Kepala Sekolah");
        
        textArea.setText(sampleContent.toString());
        textArea.setCaretPosition(0); // Scroll to top
    }
    
    /**
     * Navigate back to previous panel
     */
    private void goBack() {
        if (parentPanel != null && parentLayout != null && previousPanel != null) {
            parentLayout.show(parentPanel, previousPanel);
        } else {
            // Fallback behavior if parent references not set
            Container parent = getParent();
            if (parent != null) {
                parent.remove(this);
                ((JComponent) parent).revalidate();
                parent.repaint();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jButton1.setBackground(new java.awt.Color(214, 203, 203));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Kembali");
        jButton1.setMinimumSize(new java.awt.Dimension(83, 40));
        jButton1.setPreferredSize(new java.awt.Dimension(80, 40));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
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
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
