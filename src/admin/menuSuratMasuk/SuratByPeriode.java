
package admin.menuSuratMasuk;

import admin.menuSuratKeluar.*;
import admin.menuSuratKeluar.*;
import admin.menuSuratMasuk.*;
import static admin.menuSuratMasuk.TampilanSuratMasuk.tabel_suratMasuk;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
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
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class SuratByPeriode extends javax.swing.JPanel {

    private static final String DEFAULT_SEARCH_TEXT = "Cari";
    
    public SuratByPeriode() {
        initComponents();
        kustomTable();
        // Set total_surat dan total_disposisi menjadi tidak dapat diedit
        
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
    
        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon(getClass().getResource("/bahan/background/backgroundPanel800x483px.png"));
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    private void kustomTable() {
    // Transparansi JTable
    tabel_periode1.setOpaque(false);
    ((DefaultTableCellRenderer) tabel_periode1.getDefaultRenderer(Object.class)).setOpaque(false);
    jScrollPane2.setOpaque(false);
    jScrollPane2.getViewport().setOpaque(false);
    jScrollPane2.setBorder(null);
    tabel_periode1.setBorder(null);
    tabel_periode1.setShowGrid(false);
    tabel_periode1.setRowSelectionAllowed(true);
    tabel_periode1.setColumnSelectionAllowed(false);

    // Custom renderer untuk transparansi per baris
    tabel_periode1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Background transparan default
            c.setBackground(new Color(255, 255, 255, 150));

            if (isSelected) {
                c.setBackground(new Color(100, 10, 10));
            }

            if (c instanceof JComponent) {
                ((JComponent) c).setBorder(null);
            }

            return c;
        }
    });
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        pilih = new javax.swing.JComboBox<>();
        tampilkan_surat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_periode1 = new javax.swing.JTable();
        kembali = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cetak = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mulai_tanggal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        selesai_tanggal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(mulai_tanggal);

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(selesai_tanggal);

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Mulai Tanggal :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Selesai Tanggal :");

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_periode1.setRowHeight(30);
        jScrollPane2.setViewportView(tabel_periode1);

        kembali.setBackground(new java.awt.Color(255, 255, 255));
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

        cetak.setBackground(new java.awt.Color(255, 255, 255));
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

        mulai_tanggal.setBackground(new java.awt.Color(196, 196, 196));
        mulai_tanggal.setPreferredSize(new java.awt.Dimension(40, 30));

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        selesai_tanggal.setBackground(new java.awt.Color(196, 196, 196));
        selesai_tanggal.setPreferredSize(new java.awt.Dimension(40, 30));

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tampilkan_surat))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                                .addGap(159, 159, 159)
                                .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(mulai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(47, 47, 47)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(selesai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 199, Short.MAX_VALUE)))))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mulai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selesai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(tampilkan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addGap(13, 13, Short.MAX_VALUE)
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


            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }

        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Format tanggal tidak valid. Harap gunakan format yyyy-MM-dd.");
        }
        
    }//GEN-LAST:event_tampilkan_suratActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dateChooser2.showPopup();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private java.awt.Panel cetak;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Panel kembali;
    private javax.swing.JTextField mulai_tanggal;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTextField selesai_tanggal;
    private javax.swing.JTable tabel_periode1;
    private javax.swing.JButton tampilkan_surat;
    // End of variables declaration//GEN-END:variables
}
