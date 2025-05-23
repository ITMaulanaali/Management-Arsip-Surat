
package admin.menuSuratMasuk;

import admin.menuSuratKeluar.*;
import admin.menuSuratKeluar.*;
import admin.menuSuratMasuk.*;
import static admin.menuSuratMasuk.TampilanSuratMasuk.tabel_suratMasuk;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.print.PrinterException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class SuratByPeriode extends javax.swing.JPanel {

    private static final String DEFAULT_SEARCH_TEXT = "Cari";
    
    public SuratByPeriode() {
        initComponents();
        admin.DashboardUtama.Judul.setText("Periode Surat Masuk");
        kustomTable();
    
    // Set default text for cari JTextField
    cari.setText(DEFAULT_SEARCH_TEXT);
    cari.setForeground(Color.GRAY); // Set the text color to gray for the placeholder
    cari.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (cari.getText().equals(DEFAULT_SEARCH_TEXT)) {
                cari.setText(""); // Clear the text when focused
                cari.setForeground(Color.BLACK); // Change text color to black
            }
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (cari.getText().isEmpty()) {
                cari.setText(DEFAULT_SEARCH_TEXT); // Reset to default text if empty
                cari.setForeground(Color.GRAY); // Change text color back to gray
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
        ganti_tabel = new javax.swing.JComboBox<>();

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "No Surat", "Pengirim", "Tanggal Surat", "Kategori", "Perihal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_periode1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tabel_periode1.setMaximumSize(new java.awt.Dimension(2147483647, 12000));
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

        ganti_tabel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Surat Masuk", "Disposisi" }));
        ganti_tabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ganti_tabelActionPerformed(evt);
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
                        .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(60, 60, 60)
                        .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ganti_tabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mulai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(selesai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tampilkan_surat))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ganti_tabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mulai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selesai_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(tampilkan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addGap(14, 14, 14)
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

        // Ambil pilihan dari ganti_tabel
        String selectedTable = (String) ganti_tabel.getSelectedItem();

        String query;
        DefaultTableModel model;

        if ("Surat Masuk".equals(selectedTable)) {
            // Siapkan model tabel untuk Surat Masuk
            String[] columnNames = {"No", "No Surat", "Tanggal Surat", "Pengirim", "Kategori", "Perihal"};
            model = new DefaultTableModel(columnNames, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Tabel tidak bisa diedit
                }
            };
            tabel_periode1.setModel(model);

            // Query untuk data surat_masuk tanpa join
            query = "SELECT no_surat,tanggal_surat, pengirim, kategori, perihal FROM surat_masuk WHERE tanggal_surat >= ? AND tanggal_surat <= ?";

        } else if ("Disposisi".equals(selectedTable)) {
            // Siapkan model tabel untuk Disposisi
            String[] columnNames = {"No", "No Disposisi", "Tanggal Disposisi", "Catatan", "Status Disposisi"};
            model = new DefaultTableModel(columnNames, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Tabel tidak bisa diedit
                }
            };
            tabel_periode1.setModel(model);

            // Query untuk data disposisi tanpa join
            query = "SELECT no_disposisi, tanggal_disposisi, catatan, status_disposisi FROM disposisi WHERE tanggal_disposisi >= ? AND tanggal_disposisi <= ?";

        } else {
            // Jika pilihan tidak valid, tampilkan pesan dan keluar
            JOptionPane.showMessageDialog(this, "Pilih tipe data yang benar!");
            return;
        }

        // Jalankan query dan isi data ke tabel
        try (PreparedStatement pstmt = lib.Koneksi.Koneksi().prepareStatement(query)) {
            pstmt.setString(1, mulaiTanggalSQL);
            pstmt.setString(2, selesaiTanggalSQL);

            ResultSet rs = pstmt.executeQuery();
            int no = 1;

            while (rs.next()) {
                Object[] row = new Object[6];
                row[0] = no++; // Nomor urut

                if ("Surat Masuk".equals(selectedTable)) {
                    row[1] = rs.getString("no_surat");
                    row[2] = rs.getString("tanggal_surat");
                    row[3] = rs.getString("pengirim");
                    row[4] = rs.getString("kategori");
                    row[5] = rs.getString("perihal");
                } else {
                    row[1] = rs.getString("no_disposisi");
                    row[2] = rs.getString("tanggal_disposisi");
                    row[3] = rs.getString("catatan");
                    row[4] = rs.getString("status_disposisi");
                }

                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saat mengambil data: " + e.getMessage());
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
        String selectedTable = (String) ganti_tabel.getSelectedItem();

        // Query SQL berdasarkan pilihan
        String query = "";
        
        if ("Surat Masuk".equals(selectedTable)) {
            query = "SELECT no_surat, tanggal_surat, pengirim, kategori, perihal FROM surat_masuk WHERE ";
        } else if ("Disposisi".equals(selectedTable)) {
            query = "SELECT no_disposisi, tanggal_disposisi, catatan, status_disposisi FROM disposisi WHERE ";
        } else {
            // Tidak ada pilihan yang valid
            JOptionPane.showMessageDialog(this, "Pilih tipe data yang benar!");
            return;
        }

        // Menentukan kolom yang dicari berdasarkan pilih
        switch (selectedItem) {
            case "No Surat":
                query += "no_surat LIKE ?";
                break;
            case "Pengirim":
                query += "pengirim LIKE ?";
                break;
            case "Kategori":
                query += "kategori LIKE ?";
                break;
            case "Perihal":
                query += "perihal LIKE ?";
                break;
            case "No Disposisi":
                query += "no_disposisi LIKE ?";
                break;
            case "Tanggal Disposisi":
                query += "tanggal_disposisi LIKE ?";
                break;
            case "Catatan":
                query += "catatan LIKE ?";
                break;
            case "Status Disposisi":
                query += "status_disposisi LIKE ?";
                break;
            default:
                JOptionPane.showMessageDialog(this, "Pilih kriteria pencarian yang valid!");
                return;
        }

        // Siapkan koneksi ke database dan eksekusi query
        try (PreparedStatement pstmt = lib.Koneksi.Koneksi().prepareStatement(query)) {
            pstmt.setString(1, "%" + searchText + "%"); // Menambahkan wildcard untuk pencarian

            ResultSet rs = pstmt.executeQuery();

            // Bersihkan tabel sebelum menampilkan data baru
            DefaultTableModel model = (DefaultTableModel) tabel_periode1.getModel();
            model.setRowCount(0); // Hapus semua baris

            boolean dataFound = false;
            while (rs.next()) {
                dataFound = true;
                Object[] row;

                if ("Surat Masuk".equals(selectedTable)) {
                    row = new Object[6];
                    row[0] = model.getRowCount() + 1; // Nomor urut
                    row[1] = rs.getString("no_surat");
                    row[2] = rs.getString("tanggal_surat");
                    row[3] = rs.getString("pengirim");
                    row[4] = rs.getString("kategori");
                    row[5] = rs.getString("perihal");
                } else {
                    row = new Object[5];
                    row[0] = model.getRowCount() + 1; // Nomor urut
                    row[1] = rs.getString("no_disposisi");
                    row[2] = rs.getString("tanggal_disposisi");
                    row[3] = rs.getString("catatan");
                    row[4] = rs.getString("status_disposisi");
                }
                model.addRow(row);
            }

            // Jika tidak ada data ditemukan, tampilkan pesan
            if (!dataFound) {
                JOptionPane.showMessageDialog(this, "Tidak ada data yang ditemukan.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saat mencari data: " + e.getMessage());
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
        kembali.setBackground(new java.awt.Color(255,255,255)); // Kembalikan warna saat dilepaskan
    }//GEN-LAST:event_kembaliMouseExited

    private void cetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseClicked
          try {
            tabel_periode1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(SuratByPeriode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cetakMouseClicked

    private void cetakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseEntered
        cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
        cetak.setBackground(new java.awt.Color(217, 217, 217));
    }//GEN-LAST:event_cetakMouseEntered

    private void cetakMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseExited
        cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
        cetak.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_cetakMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dateChooser2.showPopup();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ganti_tabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ganti_tabelActionPerformed
     
    // Set the table model based on the selected option
        String selectedTable = (String) ganti_tabel.getSelectedItem();
        DefaultTableModel model = null;

        if ("Surat Masuk".equals(selectedTable)) {
            // Set model for Surat Masuk
            String[] columnNames = {"No", "No Surat", "Tanggal Surat", "Pengirim", "Kategori", "Perihal"};
            model = new DefaultTableModel(columnNames, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Make the table non-editable
                }
            };
            // Update the 'pilih' JComboBox for Surat Masuk
            pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Surat", "Pengirim", "Kategori", "Perihal" }));
        } else if ("Disposisi".equals(selectedTable)) {
            // Set model for Disposisi
            String[] columnNames = {"No", "No Disposisi", "Tanggal Disposisi", "Catatan", "Status Disposisi"};
            model = new DefaultTableModel(columnNames, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Make the table non-editable
                }
            };
            // Update the 'pilih' JComboBox for Disposisi
            pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Disposisi", "Tanggal Disposisi", "Catatan", "Status Disposisi" }));
        }

        // Set the new model to the table
        tabel_periode1.setModel(model);
        pilih.setSelectedIndex(-1); // Clear previous selection
 
    }//GEN-LAST:event_ganti_tabelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private java.awt.Panel cetak;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JComboBox<String> ganti_tabel;
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
