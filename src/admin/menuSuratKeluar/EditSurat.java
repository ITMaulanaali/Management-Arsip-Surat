/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin.menuSuratKeluar;

import admin.menuSuratMasuk.*;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import lib.Query;


public class EditSurat extends javax.swing.JPanel {
    
    private static final String DEFAULT_URUTAN_TEXT = "001";
    private static final String DEFAULT_KODE_LEMBAGA_TEXT = "HY";
    private static final String DEFAULT_NAMA_INSTANSI_TEXT = "SMK";
    private static final String DEFAULT_BULAN_TEXT = "II";
    private static final String DEFAULT_TAHUN_TEXT = "2025";

    private String noSurat;
    private String tanggalSurat;
    private String penerima1;
    private String kategori1;
    private String perihal1;
    private String statusPengiriman;
    private String alamatTujuan;
    private String fileSurat;

    
    public EditSurat(String noSurat, String tanggalSurat, String penerima, String kategori, String perihal, String statusPengiriman, String alamatTujuan) {
    initComponents();
    admin.DashboardUtama.Judul.setText("Edit Surat Keluar");
     this.noSurat = noSurat;
    this.tanggalSurat = tanggalSurat;
    this.penerima1 = penerima;
    this.kategori1 = kategori;
    this.perihal1 = perihal;
    this.statusPengiriman = statusPengiriman;
    this.alamatTujuan = alamatTujuan;

    // Populate the UI fields with the given data
    populateFields();

    // Disable all fields except for status
    disableFields();

    // Set perihal to not editable
    this.perihal.setEditable(false); // Atau gunakan this.perihal.setEnabled(false);

}
    
                  @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon(getClass().getResource("/bahan/background/backgroundPanel800x483px.png"));
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    private void disableFields() {
    // Disable all fields except for the status field
    urutan_surat.setEditable(false);
    kode_lembaga.setEditable(false);
    nama_instansi.setEditable(false);
    bulan.setEditable(false);
    tahun.setEditable(false);
    tanggal_surat_keluar.setEditable(false);
    penerima.setEditable(false);
    kategori.setEditable(false);
    alamat.setEditable(false);
    perihal.setEditable(false);
}
    
    private void populateFields() {
    // Split noSurat into parts
    String[] parts = noSurat.split("/");
    if (parts.length == 5) {
        urutan_surat.setText(parts[0]); // Fill urutan_surat
        kode_lembaga.setText(parts[1]); // Fill kode_lembaga
        nama_instansi.setText(parts[2]); // Fill nama_instansi
        bulan.setText(parts[3]); // Fill bulan
        tahun.setText(parts[4]); // Fill tahun
    } else {
        // Fallback if format noSurat is incorrect
        urutan_surat.setText("");
        kode_lembaga.setText("");
        nama_instansi.setText("");
        bulan.setText("");
        tahun.setText("");
    }

    // Fill other fields
    tanggal_surat_keluar.setText(tanggalSurat); // Fill tanggal surat
    penerima.setText(penerima1); // Fill penerima
    kategori.setText(kategori1); // Fill kategori
    perihal.setText(perihal1); // Fill perihal
    status.setSelectedItem(statusPengiriman); // Set status pengiriman
    alamat.setText(alamatTujuan); // Fill alamat tujuan
    // Do not set the file field
//     file.setText(fileSurat); // This line is removed
}
     
    String lokasiFileLengkap;
    Query query; 
    String[] coloumn = {"no_surat","tanggal_surat","penerima","kategori","perihal","file_surat","status_pengiriman","alamat_tujuan"};
    
    
    public EditSurat() {
        initComponents();
        tampilkanTanggalDanWaktu(); // Menampilkan tanggal dan waktu otomatis
         this.query= new Query();
         initializePlaceholders(); // Initialize the placeholders
    }
    
    private void initializePlaceholders() {
        
    setPlaceholder(penerima, "Nama Penerima");
    setPlaceholder(alamat, "Nama Instansi");
    setPlaceholder(kategori, "Lomba");
    setPlaceholder(urutan_surat, DEFAULT_URUTAN_TEXT);
    setPlaceholder(kode_lembaga, DEFAULT_KODE_LEMBAGA_TEXT);
    setPlaceholder(nama_instansi, DEFAULT_NAMA_INSTANSI_TEXT);
    setPlaceholder(bulan, DEFAULT_BULAN_TEXT);
    setPlaceholder(tahun, DEFAULT_TAHUN_TEXT);
}

private void setPlaceholder(JTextField textField, String placeholder) {

    textField.setText(placeholder);
    textField.setForeground(new java.awt.Color(105, 105, 105)); // Set warna teks menjadi abu-abu gelap

    textField.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (textField.getText().equals(placeholder)) {
                textField.setText("");
                textField.setForeground(java.awt.Color.BLACK); // Kembalikan warna teks ke hitam saat fokus
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
            if (textField.getText().isEmpty()) {
                textField.setText(placeholder);
                textField.setForeground(new java.awt.Color(105, 105, 105)); // Set warna teks kembali menjadi abu-abu gelap
            }
        }
    });
}

   private void tampilkanTanggalDanWaktu() {
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDateTime sekarang = LocalDateTime.now();
            tanggal_surat_keluar.setText(sekarang.format(formatTanggal));

        
     }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tanggal_surat_keluar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kategori = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        penerima = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        perihal = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        urutan_surat = new javax.swing.JTextField();
        garis_miring1 = new javax.swing.JLabel();
        kode_lembaga = new javax.swing.JTextField();
        garis_miring2 = new javax.swing.JLabel();
        nama_instansi = new javax.swing.JTextField();
        garis_miring3 = new javax.swing.JLabel();
        bulan = new javax.swing.JTextField();
        garis_miring4 = new javax.swing.JLabel();
        tahun = new javax.swing.JTextField();
        update = new java.awt.Panel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        kembali = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nomor Surat");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tanggal Surat Keluar");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        tanggal_surat_keluar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tanggal_surat_keluar.setPreferredSize(new java.awt.Dimension(40, 30));
        tanggal_surat_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggal_surat_keluarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Alamat Tujuan");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Kategori");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        kategori.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        kategori.setText("Lomba");
        kategori.setPreferredSize(new java.awt.Dimension(40, 30));
        kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Penerima");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        penerima.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        penerima.setText("Nama Penerima");
        penerima.setPreferredSize(new java.awt.Dimension(40, 30));
        penerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penerimaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Status Pengiriman");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        status.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Dikirim", "Sedang Dikirim", "Sampai Ditujuan" }));
        status.setToolTipText("");
        status.setPreferredSize(new java.awt.Dimension(76, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Perihal");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        perihal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        perihal.setPreferredSize(new java.awt.Dimension(40, 30));
        perihal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perihalActionPerformed(evt);
            }
        });

        alamat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        alamat.setText("Nama Instansi");
        alamat.setPreferredSize(new java.awt.Dimension(40, 30));

        urutan_surat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        urutan_surat.setText("001");
        urutan_surat.setPreferredSize(new java.awt.Dimension(40, 30));
        urutan_surat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urutan_suratActionPerformed(evt);
            }
        });

        garis_miring1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        garis_miring1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        garis_miring1.setText("/");

        kode_lembaga.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        kode_lembaga.setText("HY");
        kode_lembaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_lembagaActionPerformed(evt);
            }
        });

        garis_miring2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        garis_miring2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        garis_miring2.setText("/");

        nama_instansi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nama_instansi.setText("SMK");
        nama_instansi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_instansiActionPerformed(evt);
            }
        });

        garis_miring3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        garis_miring3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        garis_miring3.setText("/");

        bulan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bulan.setText("II");
        bulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulanActionPerformed(evt);
            }
        });

        garis_miring4.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        garis_miring4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        garis_miring4.setText("/");

        tahun.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tahun.setText("2025");
        tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/edit-30px.png"))); // NOI18N

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel14.setText("Update");

        javax.swing.GroupLayout updateLayout = new javax.swing.GroupLayout(update);
        update.setLayout(updateLayout);
        updateLayout.setHorizontalGroup(
            updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        updateLayout.setVerticalGroup(
            updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(updateLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jLabel13.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
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
                .addContainerGap(24, Short.MAX_VALUE))
        );
        kembaliLayout.setVerticalGroup(
            kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(kembaliLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(perihal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(penerima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tanggal_surat_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kategori, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(urutan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(garis_miring1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kode_lembaga, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(garis_miring2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nama_instansi, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(garis_miring3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(garis_miring4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kode_lembaga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nama_instansi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(garis_miring3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(garis_miring4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(garis_miring2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(urutan_surat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(garis_miring1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggal_surat_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(penerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(perihal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tanggal_surat_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggal_surat_keluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggal_surat_keluarActionPerformed

    private void penerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penerimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penerimaActionPerformed

    private void perihalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perihalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perihalActionPerformed

    private void urutan_suratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urutan_suratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urutan_suratActionPerformed

    private void kode_lembagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_lembagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_lembagaActionPerformed

    private void nama_instansiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_instansiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_instansiActionPerformed

    private void bulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bulanActionPerformed

    private void tahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
    
   // Get the selected status
    String newStatus = (String) status.getSelectedItem();

    // Check if the status is empty
    if (newStatus == null || newStatus.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Status pengiriman harus diisi!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if the status has been modified
    if (newStatus.equals(statusPengiriman)) {
        JOptionPane.showMessageDialog(this, "Tidak ada perubahan pada status pengiriman!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        return; // Stop the update process if no change
    }

    // Construct the no_surat from the parts
    String nomerSurat = urutan_surat.getText() + "/" + kode_lembaga.getText() + "/" + 
                        nama_instansi.getText() + "/" + bulan.getText() + "/" + tahun.getText();

    try {
        if (query == null) {
            query = new Query();
        }

        String[] Value = { newStatus };

        // Update the database
        query.setNamaTabel("surat_keluar")
             .setAtribut(new String[]{"status_pengiriman"})
             .setValue(Value)
             .setWhereId("no_surat", nomerSurat)
             .update();

        JOptionPane.showMessageDialog(this, "Data berhasil diupdate");

        // Refresh the view
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.TampilanSuratKeluar());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
    } catch (Exception ex) {
        Logger.getLogger(EditSurat.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Gagal mengupdate data: " + ex.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }  
    
    }//GEN-LAST:event_updateMouseClicked

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
    update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    update.setBackground(new java.awt.Color(217, 217, 217));
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
    update.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    update.setBackground(new java.awt.Color(255,255,255)); // Kembalikan warna saat dilepaskan
    }//GEN-LAST:event_updateMouseExited

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

    private void kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kategoriActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField bulan;
    private javax.swing.JLabel garis_miring1;
    private javax.swing.JLabel garis_miring2;
    private javax.swing.JLabel garis_miring3;
    private javax.swing.JLabel garis_miring4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField kategori;
    private java.awt.Panel kembali;
    private javax.swing.JTextField kode_lembaga;
    private javax.swing.JTextField nama_instansi;
    private javax.swing.JTextField penerima;
    private javax.swing.JTextField perihal;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField tahun;
    private javax.swing.JTextField tanggal_surat_keluar;
    private java.awt.Panel update;
    private javax.swing.JTextField urutan_surat;
    // End of variables declaration//GEN-END:variables
}
