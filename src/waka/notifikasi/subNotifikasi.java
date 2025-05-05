package waka.notifikasi;

import java.awt.Color;
import java.awt.Cursor;

public class subNotifikasi extends javax.swing.JPanel {
    private String noDis;
    private String noSurat;
    private String perihall;
    private String tglDisposisi;
    private String catatanDisposisi;
    private String fileBiner;

    public subNotifikasi(String noDisposisi,String noSurat, String perihal, String tanggalDisposisi, String catatanDisposisi, String fileBiner) {
        initComponents();
        this.noDis = noDisposisi;
        this.noSurat = noSurat;
        this.perihall = perihal;
        this.tglDisposisi = tanggalDisposisi;
        this.catatanDisposisi = catatanDisposisi;
        this.fileBiner = fileBiner;
        setupData();
    }
    
    private void setupData(){
        noDisposisi.setText(this.noDis);
        noSuratMasuk.setText(this.noSurat);
        perihal.setText(this.perihall);
        tanggalDisposisi.setText(this.tglDisposisi);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        noDisposisi = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        noSuratMasuk = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        perihal = new javax.swing.JLabel();
        tanggalDisposisi = new javax.swing.JLabel();
        buttonLihat = new javax.swing.JButton();

        setBackground(new java.awt.Color(217, 217, 217));
        setPreferredSize(new java.awt.Dimension(800, 110));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setText("Disposisi No.");

        noDisposisi.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        noDisposisi.setText("isi no disposisi");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel3.setText("Surat No.");

        noSuratMasuk.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        noSuratMasuk.setText("ini no surat masuk");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setText("Perihal:");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel6.setText("Diterima:");

        perihal.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        perihal.setText("isi perihal surat masuk");

        tanggalDisposisi.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        tanggalDisposisi.setText("isi tanggal disposisi");

        buttonLihat.setBackground(new java.awt.Color(206, 31, 31));
        buttonLihat.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonLihat.setText("Lihat");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tanggalDisposisi)
                            .addComponent(noSuratMasuk)
                            .addComponent(noDisposisi)
                            .addComponent(perihal)))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 458, Short.MAX_VALUE)
                .addComponent(buttonLihat)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(noDisposisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(noSuratMasuk))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(perihal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(tanggalDisposisi, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonLihat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLihatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLihatMouseEntered
        buttonLihat.setBackground(new Color(255,255,255));
        buttonLihat.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_buttonLihatMouseEntered

    private void buttonLihatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLihatMouseExited
        buttonLihat.setBackground(new Color(206,31,31));
        buttonLihat.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_buttonLihatMouseExited

    private void buttonLihatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLihatMouseClicked
        buttonLihat.setBackground(new Color(206,31,31));
        
        waka.DashboardUtama.SubPanel.removeAll();
        waka.DashboardUtama.SubPanel.add(new waka.notifikasi.LembarDisposisi(this.noDis,this.noSurat,this.perihall,this.tglDisposisi,this.catatanDisposisi, this.fileBiner));
        waka.DashboardUtama.SubPanel.revalidate();
        waka.DashboardUtama.SubPanel.repaint();
    }//GEN-LAST:event_buttonLihatMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLihat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel noDisposisi;
    private javax.swing.JLabel noSuratMasuk;
    private javax.swing.JLabel perihal;
    private javax.swing.JLabel tanggalDisposisi;
    // End of variables declaration//GEN-END:variables
}
