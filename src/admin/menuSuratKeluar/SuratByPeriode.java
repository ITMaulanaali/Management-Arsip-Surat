
package admin.menuSuratKeluar;

import admin.menuSuratKeluar.*;
import admin.menuSuratMasuk.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class SuratByPeriode extends javax.swing.JPanel {


    public SuratByPeriode() {
        initComponents();
        
        
 // Tambahkan event listener di constructor atau initComponents
cari.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        cariMouseClicked(evt);
    }
});

cari.addFocusListener(new java.awt.event.FocusAdapter() {
    public void focusLost(java.awt.event.FocusEvent evt) {
        cariFocusLost(evt);
    }
    });  
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
        kembali = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        total_surat = new javax.swing.JTextField();
        total_disposisi = new javax.swing.JTextField();
        tampilkan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_periode = new javax.swing.JTable();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Mulai Tanggal :");

        mulai_tanggal.setPreferredSize(new java.awt.Dimension(40, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Selesai Tanggal :");

        selesai_tanggal.setPreferredSize(new java.awt.Dimension(40, 30));

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

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Surat", "Perihal", "File", "Disposisi" }));
        pilih.setPreferredSize(new java.awt.Dimension(80, 40));

        kembali.setBackground(new java.awt.Color(196, 196, 196));
        kembali.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        kembali.setText("Kembali");
        kembali.setMinimumSize(new java.awt.Dimension(83, 40));
        kembali.setPreferredSize(new java.awt.Dimension(80, 40));
        kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kembaliMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kembaliMouseExited(evt);
            }
        });
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        cetak.setBackground(new java.awt.Color(125, 10, 10));
        cetak.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cetak.setForeground(new java.awt.Color(255, 255, 255));
        cetak.setText("Cetak");
        cetak.setMinimumSize(new java.awt.Dimension(83, 40));
        cetak.setPreferredSize(new java.awt.Dimension(80, 40));
        cetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cetakMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cetakMouseExited(evt);
            }
        });

        total_surat.setPreferredSize(new java.awt.Dimension(40, 30));

        total_disposisi.setPreferredSize(new java.awt.Dimension(40, 30));

        tampilkan.setBackground(new java.awt.Color(196, 196, 196));
        tampilkan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tampilkan.setText("Tampilkan Surat");
        tampilkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tampilkanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tampilkanMouseExited(evt);
            }
        });
        tampilkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilkanActionPerformed(evt);
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
                "No Surat", "Perihal", "File Surat", "Disposisi"
            }
        ));
        jScrollPane2.setViewportView(tabel_periode);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338)
                .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(169, 169, 169))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(89, 89, 89))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(total_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(mulai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(40, 40, 40))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(158, 158, 158))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(selesai_tanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(total_disposisi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                                .addGap(106, 106, 106)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tampilkan, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane2))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mulai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selesai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(total_disposisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(tampilkan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(total_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.TampilanSuratKeluar());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
        
    }//GEN-LAST:event_kembaliActionPerformed

    private void kembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseEntered
    kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    }//GEN-LAST:event_kembaliMouseEntered

    private void kembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseExited
    kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    }//GEN-LAST:event_kembaliMouseExited

    private void cetakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseEntered
    cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    }//GEN-LAST:event_cetakMouseEntered

    private void cetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseExited
    cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    }//GEN-LAST:event_cetakMouseExited

    private void tampilkanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tampilkanMouseEntered
       tampilkan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    }//GEN-LAST:event_tampilkanMouseEntered

    private void tampilkanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tampilkanMouseExited
        tampilkan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    }//GEN-LAST:event_tampilkanMouseExited

    private void tampilkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilkanActionPerformed
      // Ambil tanggal mulai dan selesai dari text field
    String mulaiTanggalStr = mulai_tanggal.getText();
    String selesaiTanggalStr = selesai_tanggal.getText();

    // Format untuk parsing tanggal
    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

    try {
        // Mengonversi string tanggal ke Date
        Date mulaiTanggal = inputFormat.parse(mulaiTanggalStr);
        Date selesaiTanggal = inputFormat.parse(selesaiTanggalStr);

        // Mengonversi Date ke string dalam format yang sesuai untuk SQL
        String mulaiTanggalSQL = inputFormat.format(mulaiTanggal);
        String selesaiTanggalSQL = inputFormat.format(selesaiTanggal);

        // Query SQL untuk mengambil data berdasarkan rentang tanggal
        String query = "SELECT sk.no_surat, sk.perihal, sk.file_surat, " +
                       "d.status_disposisi " +
                       "FROM surat_keluar sk " +
                       "LEFT JOIN disposisi d ON sk.no_surat = d.no_disposisi " +
                       "WHERE sk.tanggal_surat >= ? AND sk.tanggal_surat <= ?";

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
    
    }//GEN-LAST:event_tampilkanActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
      
     // Ambil teks pencarian dan pilihan
    String searchText = cari.getText();
    String selectedOption = (String) pilih.getSelectedItem();

    // Bersihkan tabel sebelum menampilkan data baru
    DefaultTableModel model = (DefaultTableModel) tabel_periode.getModel();
    model.setRowCount(0); // Menghapus semua baris

    // Query SQL untuk mencari data berdasarkan pilihan
    String query = "SELECT sk.no_surat, sk.perihal, sk.file_surat, " +
                   "d.status_disposisi " +
                   "FROM surat_keluar sk " +
                   "LEFT JOIN disposisi d ON sk.no_surat = d.no_disposisi " +
                   "WHERE ";

    // Menentukan kolom mana yang akan dicari berdasarkan pilihan
    switch (selectedOption) {
        case "No Surat":
            query += "sk.no_surat LIKE ?";
            break;
        case "Perihal":
            query += "sk.perihal LIKE ?";
            break;
        case "File":
            query += "sk.file_surat LIKE ?";
            break;
        case "Disposisi":
            query += "d.status_disposisi LIKE ?";
            break;
        default:
            return; // Jika tidak ada pilihan yang valid, keluar dari metode
    }

    try {
        // Siapkan koneksi ke database
        PreparedStatement pstmt = lib.Koneksi.Koneksi().prepareStatement(query);
        pstmt.setString(1, "%" + searchText + "%"); // Menambahkan wildcard untuk pencarian

        // Eksekusi query
        ResultSet rs = pstmt.executeQuery();

        // Tambahkan data ke tabel
        while (rs.next()) {
            Object[] row = new Object[4];
            row[0] = rs.getString("no_surat"); 
            row[1] = rs.getString("perihal");
            row[2] = rs.getString("file_surat");
            row[3] = rs.getString("status_disposisi"); // Ambil status_disposisi dari hasil query
            
            model.addRow(row);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        // Tampilkan pesan kesalahan jika ada
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}

    // Event listener untuk menghilangkan teks saat diklik
    private void cariMouseClicked(java.awt.event.MouseEvent evt) {
    if (cari.getText().equals("Cari")) {
        cari.setText(""); // Menghapus teks saat diklik
    }
}

    // Event listener untuk menampilkan kembali teks jika tidak berfokus
    private void cariFocusLost(java.awt.event.FocusEvent evt) {
    if (cari.getText().isEmpty()) {
        cari.setText("Cari"); // Menampilkan kembali teks jika tidak berfokus
        // Kosongkan tabel saat kembali ke teks "Cari"
        DefaultTableModel model = (DefaultTableModel) tabel_periode.getModel();
        model.setRowCount(0); // Menghapus semua baris
    }
}

    // Event listener untuk mengosongkan tabel saat mulai mengetik
    private void cariKeyTyped(java.awt.event.KeyEvent evt) {
    DefaultTableModel model = (DefaultTableModel) tabel_periode.getModel();
    model.setRowCount(0); // Menghapus semua baris saat mulai mengetik

   
    }//GEN-LAST:event_cariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JButton cetak;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField mulai_tanggal;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTextField selesai_tanggal;
    private javax.swing.JTable tabel_periode;
    private javax.swing.JButton tampilkan;
    private javax.swing.JTextField total_disposisi;
    private javax.swing.JTextField total_surat;
    // End of variables declaration//GEN-END:variables
}
