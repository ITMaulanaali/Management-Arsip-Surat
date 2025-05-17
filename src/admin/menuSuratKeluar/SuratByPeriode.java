
package admin.menuSuratKeluar;

import admin.menuSuratKeluar.*;
import admin.menuSuratMasuk.*;
import static admin.menuSuratMasuk.TampilanSuratMasuk.tabel_suratMasuk;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class SuratByPeriode extends javax.swing.JPanel {


    public SuratByPeriode() {
    initComponents();
    kustomTable();
        
        
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
    
                @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon(getClass().getResource("/bahan/background/backgroundPanel800x483px.png"));
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
        private void kustomTable() {
    // Transparansi JTable
    tabel_periode.setOpaque(false);
    ((DefaultTableCellRenderer) tabel_periode.getDefaultRenderer(Object.class)).setOpaque(false);
    jScrollPane2.setOpaque(false);
    jScrollPane2.getViewport().setOpaque(false);
    jScrollPane2.setBorder(null);
    tabel_periode.setBorder(null);
    tabel_periode.setShowGrid(false);
    tabel_periode.setRowSelectionAllowed(true);
    tabel_periode.setColumnSelectionAllowed(false);

    // Custom renderer untuk transparansi per baris
    tabel_periode.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        mulai_tanggal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        selesai_tanggal = new javax.swing.JTextField();
        cari = new javax.swing.JTextField();
        pilih = new javax.swing.JComboBox<>();
        tampilkan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_periode = new javax.swing.JTable();
        cetak = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kembali = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        mulai_tanggal.setBackground(new java.awt.Color(196, 196, 196));
        mulai_tanggal.setPreferredSize(new java.awt.Dimension(40, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Selesai Tanggal :");

        selesai_tanggal.setBackground(new java.awt.Color(196, 196, 196));
        selesai_tanggal.setPreferredSize(new java.awt.Dimension(40, 30));

        cari.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cari.setText("Cari");
        cari.setMinimumSize(new java.awt.Dimension(0, 40));
        cari.setPreferredSize(new java.awt.Dimension(600, 40));
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Surat", "Penerima", "Kategori", "Perihal" }));
        pilih.setPreferredSize(new java.awt.Dimension(80, 40));

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "No Surat", "Penerima", "Kategori", "Perihal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_periode.setRowHeight(30);
        jScrollPane2.setViewportView(tabel_periode);

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
                .addComponent(jLabel13)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        kembaliLayout.setVerticalGroup(
            kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kembaliLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(89, 89, 89))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(mulai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addGap(40, 40, 40))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(selesai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 69, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                                .addGap(106, 106, 106)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tampilkan, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
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
                    .addComponent(selesai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(tampilkan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cetak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

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
        String query = "SELECT sk.no_surat, sk.penerima, sk.kategori, sk.perihal, d.status_disposisi " +
                       "FROM surat_keluar sk " +
                       "LEFT JOIN disposisi d ON sk.no_surat = d.no_disposisi " +
                       "WHERE sk.tanggal_surat >= ? AND sk.tanggal_surat <= ?";

        // Siapkan koneksi ke database
        try (PreparedStatement pstmt = lib.Koneksi.Koneksi().prepareStatement(query)) {
            // Set parameter tanggal
            pstmt.setString(1, mulaiTanggalSQL);
            pstmt.setString(2, selesaiTanggalSQL);

            // Eksekusi query
            ResultSet rs = pstmt.executeQuery();

            // Bersihkan tabel sebelum menampilkan data baru
            DefaultTableModel model = (DefaultTableModel) tabel_periode.getModel();
            model.setRowCount(0); // Menghapus semua baris

            // Tambahkan data ke tabel
            int no = 1; // Nomor urut
            while (rs.next()) {
                Object[] row = new Object[5]; // Adjusted to match the number of columns
                row[0] = no++; // Menambahkan nomor urut
                row[1] = rs.getString("no_surat"); 
                row[2] = rs.getString("penerima");
                row[3] = rs.getString("kategori");
                row[4] = rs.getString("perihal");
                
                model.addRow(row);
            }

            // Hitung total surat dan tampilkan di total_surat
            int totalSurat = model.getRowCount(); // Menghitung jumlah baris

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    } catch (ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Format tanggal tidak valid. Harap gunakan format yyyy-MM-dd.");
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
        String query = "SELECT sk.no_surat, sk.penerima, sk.kategori, sk.perihal, d.status_disposisi " +
                       "FROM surat_keluar sk " +
                       "LEFT JOIN disposisi d ON sk.no_surat = d.no_disposisi " +
                       "WHERE ";

        // Menentukan kolom mana yang akan dicari berdasarkan pilihan
        switch (selectedOption) {
            case "No Surat":
                query += "sk.no_surat LIKE ?";
                break;
            case "Penerima":
                query += "sk.penerima LIKE ?";
                break;
            case "Kategori":
                query += "sk.kategori LIKE ?";
                break;
            case "Perihal":
                query += "sk.perihal LIKE ?";
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
                Object[] row = new Object[5]; // Adjusted to match the number of columns
                row[0] = rs.getString("no_surat");
                row[1] = rs.getString("penerima");
                row[2] = rs.getString("kategori");
                row[3] = rs.getString("perihal");

                model.addRow(row);
            }

            // Jika tidak ada data ditemukan, tampilkan pesan
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Tidak ada data yang ditemukan.");
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

    private void cetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseClicked

        
    }//GEN-LAST:event_cetakMouseClicked

    private void cetakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseEntered
        cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
        cetak.setBackground(new java.awt.Color(217, 217, 217));
    }//GEN-LAST:event_cetakMouseEntered

    private void cetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseExited
        cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
        cetak.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_cetakMouseExited

    private void kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseClicked

        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.TampilanSuratKeluar());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
    }//GEN-LAST:event_kembaliMouseClicked

    private void kembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseEntered
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
        kembali.setBackground(new java.awt.Color(217, 217, 217));
    }//GEN-LAST:event_kembaliMouseEntered

    private void kembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseExited
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
        kembali.setBackground(new java.awt.Color(255,255,255)); // Kembalikan warna saat dilepaskan
    }//GEN-LAST:event_kembaliMouseExited

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
    private javax.swing.JTable tabel_periode;
    private javax.swing.JButton tampilkan;
    // End of variables declaration//GEN-END:variables
}
