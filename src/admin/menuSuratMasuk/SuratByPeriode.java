
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

    private static final String DEFAULT_SEARCH_TEXT = "Cari";
    
    public SuratByPeriode() {
        initComponents();
        // Set total_surat dan total_disposisi menjadi tidak dapat diedit
        total_surat.setEditable(false);
        total_disposisi.setEditable(false);
        
        // Set default text for cari JTextField
        cari.setText(DEFAULT_SEARCH_TEXT);
        cari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (cari.getText().equals(DEFAULT_SEARCH_TEXT)) {
                    cari.setText("");
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (cari.getText().isEmpty()) {
                    cari.setText(DEFAULT_SEARCH_TEXT);
                }
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
        total_surat = new javax.swing.JTextField();
        total_disposisi = new javax.swing.JTextField();
        tampilkan_surat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_periode1 = new javax.swing.JTable();
        kembali = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cetak = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Surat", "Pengirim", "Kategori", "Perihal", "Disposisi" }));
        pilih.setPreferredSize(new java.awt.Dimension(80, 40));
        pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihActionPerformed(evt);
            }
        });

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
        tampilkan_surat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tampilkan_suratMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tampilkan_suratMouseExited(evt);
            }
        });
        tampilkan_surat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilkan_suratActionPerformed(evt);
            }
        });

        tabel_periode1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No Surat", "Pengirim", "Kategori", "Perihal", "Disposisi"
            }
        ));
        tabel_periode1.setRowHeight(30);
        jScrollPane2.setViewportView(tabel_periode1);
        if (tabel_periode1.getColumnModel().getColumnCount() > 0) {
            tabel_periode1.getColumnModel().getColumn(2).setResizable(false);
        }

        kembali.setBackground(new java.awt.Color(196, 196, 196));
        kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kembaliMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kembaliMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kembaliMouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/kembali-30px.png"))); // NOI18N

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel13.setText("Kembali");

        javax.swing.GroupLayout kembaliLayout = new javax.swing.GroupLayout(kembali);
        kembali.setLayout(kembaliLayout);
        kembaliLayout.setHorizontalGroup(
            kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kembaliLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        kembaliLayout.setVerticalGroup(
            kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(kembaliLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cetak.setBackground(new java.awt.Color(125, 10, 10));
        cetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cetakMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cetakMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cetakMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/print-30px.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cetak");

        javax.swing.GroupLayout cetakLayout = new javax.swing.GroupLayout(cetak);
        cetak.setLayout(cetakLayout);
        cetakLayout.setHorizontalGroup(
            cetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cetakLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        cetakLayout.setVerticalGroup(
            cetakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(cetakLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(700, Short.MAX_VALUE)
                        .addComponent(tampilkan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                                .addGap(159, 159, 159)
                                .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(mulai_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(total_surat, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                        .addGap(133, 133, 133)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(378, 378, 378))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(selesai_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                                .addComponent(total_disposisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(289, 289, 289))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))))
                .addGap(31, 31, 31))
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
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mulai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selesai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(total_disposisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(tampilkan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(total_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tampilkan_suratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilkan_suratActionPerformed
   
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
            String query = "SELECT sm.no_surat, sm.pengirim, sm.kategori, sm.perihal, d.status_disposisi " +
                           "FROM surat_masuk sm " +
                           "LEFT JOIN disposisi d ON sm.no_surat = d.no_surat " +
                           "WHERE sm.tanggal_surat >= ? AND sm.tanggal_surat <= ?";

            // Siapkan koneksi ke database
            try (PreparedStatement pstmt = lib.Koneksi.Koneksi().prepareStatement(query)) {
                // Set parameter tanggal
                pstmt.setString(1, mulaiTanggalSQL);
                pstmt.setString(2, selesaiTanggalSQL);

                // Eksekusi query
                ResultSet rs = pstmt.executeQuery();

                // Bersihkan tabel sebelum menampilkan data baru
                DefaultTableModel model = (DefaultTableModel) tabel_periode1.getModel();
                model.setRowCount(0); // Menghapus semua baris

                // Tambahkan data ke tabel
                int totalDisposisi = 0; // Variabel untuk menghitung total disposisi
                while (rs.next()) {
                    Object[] row = new Object[5]; // Adjusted to match the number of columns
                    row[0] = rs.getString("no_surat"); 
                    row[1] = rs.getString("pengirim");
                    row[2] = rs.getString("kategori");
                    row[3] = rs.getString("perihal");
                    row[4] = rs.getString("status_disposisi"); // Ambil status_disposisi dari hasil query

                    model.addRow(row);
                    
                    // Hitung total disposisi jika status_disposisi tidak null
                    if (rs.getString("status_disposisi") != null) {
                        totalDisposisi++;
                    }
                }

                // Hitung total surat
                int totalSurat = model.getRowCount(); // Jumlah baris di tabel

        // Tampilkan total surat dan total disposisi
        // Tampilkan total surat dan total disposisi
                total_surat.setText(String.valueOf(totalSurat));
                total_disposisi.setText(String.valueOf(totalDisposisi));

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }

        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Format tanggal tidak valid. Harap gunakan format yyyy-MM-dd.");
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
        String query = "SELECT sm.no_surat, sm.pengirim, sm.kategori, sm.perihal, d.status_disposisi " +
                       "FROM surat_masuk sm " +
                       "LEFT JOIN disposisi d ON sm.no_surat = d.no_surat " +
                       "WHERE ";

        // Menentukan kolom yang dicari
        switch (selectedItem) {
            case "No Surat":
                query += "sm.no_surat LIKE ?";
                break;
            case "Pengirim":
                query += "sm.pengirim LIKE ?";
                break;
            case "Kategori":
                query += "sm.kategori LIKE ?";
                break;
            case "Perihal":
                query += "sm.perihal LIKE ?";
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
            DefaultTableModel model = (DefaultTableModel) tabel_periode1.getModel();
            model.setRowCount(0); // Menghapus semua baris

            // Tambahkan data ke tabel
            boolean dataFound = false; // Flag untuk memeriksa apakah data ditemukan
            while (rs.next()) {
                dataFound = true; // Data ditemukan
                Object[] row = new Object[5]; // Adjusted to match the number of columns
                row[0] = rs.getString("no_surat");
                row[1] = rs.getString("pengirim");
                row[2] = rs.getString("kategori");
                row[3] = rs.getString("perihal");
                row[4] = rs.getString("status_disposisi");

                model.addRow(row);
            }

            // Jika tidak ada data ditemukan, tampilkan pesan
            if (!dataFound) {
                JOptionPane.showMessageDialog(this, "Tidak ada data yang ditemukan.");
                model.setRowCount(0); // Kosongkan tabel jika tidak ada data
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        
    }//GEN-LAST:event_cariActionPerformed

    private void pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihActionPerformed

    private void tampilkan_suratMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tampilkan_suratMouseEntered
    tampilkan_surat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    }//GEN-LAST:event_tampilkan_suratMouseEntered

    private void tampilkan_suratMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tampilkan_suratMouseExited
    tampilkan_surat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    }//GEN-LAST:event_tampilkan_suratMouseExited

    private void kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseClicked

        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratMasuk.TampilanSuratMasuk());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
    }//GEN-LAST:event_kembaliMouseClicked

    private void kembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseEntered
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
        kembali.setBackground(new java.awt.Color(217, 217, 217));
    }//GEN-LAST:event_kembaliMouseEntered

    private void kembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseExited
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
        kembali.setBackground(new java.awt.Color(196, 196, 196)); // Kembalikan warna saat dilepaskan
    }//GEN-LAST:event_kembaliMouseExited

    private void cetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseClicked

    }//GEN-LAST:event_cetakMouseClicked

    private void cetakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseEntered
        cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
        cetak.setBackground(new java.awt.Color(172, 10, 10));
    }//GEN-LAST:event_cetakMouseEntered

    private void cetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseExited
        cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
        cetak.setBackground(new java.awt.Color(125, 10, 10));
    }//GEN-LAST:event_cetakMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private java.awt.Panel cetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Panel kembali;
    private javax.swing.JTextField mulai_tanggal;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTextField selesai_tanggal;
    private javax.swing.JTable tabel_periode1;
    private javax.swing.JButton tampilkan_surat;
    private javax.swing.JTextField total_disposisi;
    private javax.swing.JTextField total_surat;
    // End of variables declaration//GEN-END:variables
}
