
package admin.menuSuratMasuk;

import admin.menuSuratKeluar.*;
import admin.menuSuratKeluar.*;
import admin.menuSuratMasuk.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lib.Koneksi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SuratByPeriode extends javax.swing.JPanel {

    
    public SuratByPeriode() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        mulai_tanggal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        selesai_tanggal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        pilih = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_periode = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        total_surat = new javax.swing.JTextField();
        total_disposisi = new javax.swing.JTextField();
        tampilkan_surat = new javax.swing.JButton();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Mulai Tanggal :");

        mulai_tanggal.setPreferredSize(new java.awt.Dimension(40, 30));
        mulai_tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mulai_tanggalActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Selesai Tanggal :");

        selesai_tanggal.setPreferredSize(new java.awt.Dimension(40, 30));
        selesai_tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesai_tanggalActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Total Surat :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Total Disposisi :");

        cari.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cari.setText("Cari");
        cari.setMinimumSize(new java.awt.Dimension(0, 40));
        cari.setPreferredSize(new java.awt.Dimension(600, 40));
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Perihal", "File", "Disposisi" }));
        pilih.setPreferredSize(new java.awt.Dimension(80, 40));
        pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihActionPerformed(evt);
            }
        });

        tabel_periode.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Perihal", "File", "Disposisi"
            }
        ));
        tabel_periode.setMinimumSize(new java.awt.Dimension(1200, 80));
        tabel_periode.setPreferredSize(new java.awt.Dimension(1200, 80));
        jScrollPane1.setViewportView(tabel_periode);

        jButton1.setBackground(new java.awt.Color(196, 196, 196));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Kembali");
        jButton1.setMinimumSize(new java.awt.Dimension(83, 40));
        jButton1.setPreferredSize(new java.awt.Dimension(80, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(125, 10, 10));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cetak");
        jButton4.setMinimumSize(new java.awt.Dimension(83, 40));
        jButton4.setPreferredSize(new java.awt.Dimension(80, 40));

        total_surat.setPreferredSize(new java.awt.Dimension(40, 30));
        total_surat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_suratActionPerformed(evt);
            }
        });

        total_disposisi.setPreferredSize(new java.awt.Dimension(40, 30));
        total_disposisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_disposisiActionPerformed(evt);
            }
        });

        tampilkan_surat.setBackground(new java.awt.Color(196, 196, 196));
        tampilkan_surat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tampilkan_surat.setText("Tampilkan Surat");
        tampilkan_surat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilkan_suratActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addGap(162, 162, 162)
                .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addGap(211, 211, 211)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mulai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selesai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(total_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(total_disposisi, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tampilkan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mulai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selesai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(total_disposisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tampilkan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratMasuk.TampilanSuratMasuk());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tampilkan_suratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilkan_suratActionPerformed
   // Ambil tanggal mulai dan selesai dari text field
    String mulaiTanggalStr = mulai_tanggal.getText();
    String selesaiTanggalStr = selesai_tanggal.getText();

    // Format untuk parsing tanggal
    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

    try {
        // Mengonversi string tanggal ke Date
        Date mulaiTanggal = inputFormat.parse(mulaiTanggalStr);
        Date selesaiTanggal = inputFormat.parse(selesaiTanggalStr);

        // Mengonversi Date ke string dalam format yang sesuai untuk SQL
        String mulaiTanggalSQL = outputFormat.format(mulaiTanggal);
        String selesaiTanggalSQL = outputFormat.format(selesaiTanggal);

        // Query SQL untuk mengambil data berdasarkan rentang tanggal
        String query = "SELECT sm.no_surat, sm.perihal, sm.file_surat, " +
                       "d.status_disposisi " +
                       "FROM surat_masuk sm " +
                       "LEFT JOIN disposisi d ON sm.no_surat = d.no_surat " +
                       "WHERE sm.tanggal_surat >= ? AND sm.tanggal_surat <= ?";

        // Siapkan koneksi ke database
        PreparedStatement pstmt = lib.Koneksi.Koneksi().prepareStatement(query);
        
        // Set parameter tanggal
        pstmt.setString(1, mulaiTanggalSQL);
        pstmt.setString(2, selesaiTanggalSQL);
        
        // Eksekusi query
        ResultSet rs = pstmt.executeQuery();
        
        // Bersihkan tabel sebelum menampilkan data baru
        DefaultTableModel model = (DefaultTableModel) tabel_periode.getModel();
        model.setRowCount(0); // Menghapus semua baris
        
        // Inisialisasi total disposisi
        int totalDisposisi = 0; 
        
        // Tambahkan data ke tabel
        while (rs.next()) {
            Object[] row = new Object[4];
            row[0] = rs.getString("no_surat"); 
            row[1] = rs.getString("perihal");
            row[2] = rs.getString("file_surat");
            row[3] = rs.getString("status_disposisi"); // Ambil status_disposisi dari hasil query
            
            model.addRow(row);
            
            // Hitung total disposisi jika status_disposisi adalah "terdisposisi"
            if ("terdisposisi".equalsIgnoreCase(rs.getString("status_disposisi"))) {
                totalDisposisi++;
            }
        }

        // Hitung total surat dan tampilkan di total_surat
        int totalSurat = model.getRowCount(); // Menghitung jumlah baris
        total_surat.setText(String.valueOf(totalSurat)); // Menampilkan total surat
        total_disposisi.setText(String.valueOf(totalDisposisi)); // Menampilkan total disposisi

    } catch (ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Format tanggal tidak valid. Harap gunakan format yyyy-MM-dd.");
    } catch (SQLException e) {
        e.printStackTrace();
        // Tampilkan pesan kesalahan jika ada
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
        
    }//GEN-LAST:event_tampilkan_suratActionPerformed

    private void mulai_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mulai_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mulai_tanggalActionPerformed

    private void total_suratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_suratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_suratActionPerformed

    private void selesai_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesai_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selesai_tanggalActionPerformed

    private void total_disposisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_disposisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_disposisiActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
       
         // Ambil nilai dari cari dan pilih
        String searchText = cari.getText();
        String selectedItem = (String) pilih.getSelectedItem();

        // Query SQL berdasarkan pilihan
        String query = "SELECT sm.no_surat, sm.perihal, sm.file_surat, " +
                       "d.status_disposisi " +
                       "FROM surat_masuk sm " +
                       "LEFT JOIN disposisi d ON sm.no_surat = d.no_surat " +
                       "WHERE ";

        // Menentukan kolom yang dicari
        switch (selectedItem) {
            case "No":
                query += "sm.no_surat LIKE ?";
                break;
            case "Perihal":
                query += "sm.perihal LIKE ?";
                break;
            case "File":
                query += "sm.file_surat LIKE ?";
                break;
            case "Disposisi":
                query += "d.status_disposisi LIKE ?";
                break;
            default:
                return; // Jika tidak ada pilihan yang valid
        }

        // Siapkan koneksi ke database
        try (PreparedStatement pstmt = lib.Koneksi.Koneksi().prepareStatement(query)) {
            pstmt.setString(1, "%" + searchText + "%"); // Menambahkan wildcard untuk pencarian

            // Eksekusi query
            ResultSet rs = pstmt.executeQuery();

            // Bersihkan tabel sebelum menampilkan data baru
            DefaultTableModel model = (DefaultTableModel) tabel_periode.getModel();
            model.setRowCount(0); // Menghapus semua baris

            // Tambahkan data ke tabel
            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("no_surat");
                row[1] = rs.getString("perihal");
                row[2] = rs.getString("file_surat");
                row[3] = rs.getString("status_disposisi");

                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        
    }//GEN-LAST:event_cariActionPerformed

    private void pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mulai_tanggal;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTextField selesai_tanggal;
    private javax.swing.JTable tabel_periode;
    private javax.swing.JButton tampilkan_surat;
    private javax.swing.JTextField total_disposisi;
    private javax.swing.JTextField total_surat;
    // End of variables declaration//GEN-END:variables
}
