
package admin.menuSuratMasuk;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import lib.Query;


public class ArsipkanSurat extends javax.swing.JPanel {

     Query query; 
     String[] coloumn = {"no_surat","tanggal_surat","pengirim","kategori","perihal","file_surat","status_notifikasi"};
    
    public ArsipkanSurat() {
        initComponents();
        tampilkanTanggalDanWaktu(); // Menampilkan tanggal dan waktu otomatis
        this.query= new Query();
    }

     private void tampilkanTanggalDanWaktu() {
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Timer timer = new Timer(1000, e -> {
            LocalDateTime sekarang = LocalDateTime.now();
            tanggal_surat_masuk.setText(sekarang.format(formatTanggal));
   
        });
        timer.start();
        
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        nomor_surat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tanggal_surat_masuk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kategori = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        upload_file = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        arsipkan = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        status_notifikasi = new javax.swing.JComboBox<>();
        pengirim = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        perihal = new javax.swing.JTextArea();
        Upload = new javax.swing.JButton();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nomor Surat");

        nomor_surat.setPreferredSize(new java.awt.Dimension(40, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tanggal Surat Masuk");

        tanggal_surat_masuk.setPreferredSize(new java.awt.Dimension(40, 30));
        tanggal_surat_masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggal_surat_masukActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Pengirim");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Kategori");

        kategori.setText("Personal");
        kategori.setPreferredSize(new java.awt.Dimension(40, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("File");

        upload_file.setText("Upload pdf");
        upload_file.setPreferredSize(new java.awt.Dimension(40, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Perihal");

        arsipkan.setBackground(new java.awt.Color(125, 10, 10));
        arsipkan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        arsipkan.setForeground(new java.awt.Color(255, 255, 255));
        arsipkan.setText("Arsipkan");
        arsipkan.setMinimumSize(new java.awt.Dimension(83, 40));
        arsipkan.setPreferredSize(new java.awt.Dimension(80, 40));
        arsipkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arsipkanActionPerformed(evt);
            }
        });

        kembali.setBackground(new java.awt.Color(196, 196, 196));
        kembali.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        kembali.setText("Kembali");
        kembali.setMinimumSize(new java.awt.Dimension(83, 40));
        kembali.setPreferredSize(new java.awt.Dimension(80, 40));
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Status Notifikasi");

        status_notifikasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Dibaca", "Sudah Terbaca", "Terdisposisi" }));
        status_notifikasi.setPreferredSize(new java.awt.Dimension(76, 30));

        pengirim.setText("Nama Instansi");
        pengirim.setPreferredSize(new java.awt.Dimension(40, 30));
        pengirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengirimActionPerformed(evt);
            }
        });

        jTextField8.setText("Nama Instansi");
        jTextField8.setPreferredSize(new java.awt.Dimension(40, 30));

        perihal.setColumns(20);
        perihal.setRows(5);
        jScrollPane1.setViewportView(perihal);

        Upload.setText("Upload File");
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(nomor_surat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(tanggal_surat_masuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80)
                .addComponent(upload_file, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(208, 208, 208)
                .addComponent(arsipkan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pengirim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(status_notifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(Upload)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(nomor_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(tanggal_surat_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(upload_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status_notifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(arsipkan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tanggal_surat_masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggal_surat_masukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggal_surat_masukActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
       
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratMasuk.TampilanSuratMasuk());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
        
    }//GEN-LAST:event_kembaliActionPerformed

    private void arsipkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arsipkanActionPerformed
      String nomerSurat = nomor_surat.getText();
      String tanggal = tanggal_surat_masuk.getText();
      String namapengirim = pengirim.getText();
      String personalkategori = kategori.getText();
      String catatanperihal = perihal.getText();
      String file_surat = upload_file.getText();
      String tandastatusnotifikasi = (String) status_notifikasi.getSelectedItem();
      String[] Value = {nomerSurat,tanggal,namapengirim,personalkategori,catatanperihal,file_surat,tandastatusnotifikasi};
    
         try {
             query.setNamaTabel("surat_masuk").setAtribut(coloumn).setValue(Value).insert();
             JOptionPane.showMessageDialog(this, "Berhasil Ditambahkan ");
             admin.DashboardUtama.SubPanel.removeAll();
             admin.DashboardUtama.SubPanel.add(new admin.menuSuratMasuk.TampilanSuratMasuk());
             admin.DashboardUtama.SubPanel.revalidate();
             admin.DashboardUtama.SubPanel.repaint();
             
         } catch (Exception ex) {
             Logger.getLogger(ArsipkanSurat.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(this, "Gagal Ditambahkan Ditambahkan ");
         }
        
    }//GEN-LAST:event_arsipkanActionPerformed

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed
        upload_file.setText(lib.PilihFile.getPath());
    }//GEN-LAST:event_UploadActionPerformed

    private void pengirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengirimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pengirimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Upload;
    private javax.swing.JButton arsipkan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField kategori;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField nomor_surat;
    private javax.swing.JTextField pengirim;
    private javax.swing.JTextArea perihal;
    private javax.swing.JComboBox<String> status_notifikasi;
    private javax.swing.JTextField tanggal_surat_masuk;
    private javax.swing.JTextField upload_file;
    // End of variables declaration//GEN-END:variables
}
