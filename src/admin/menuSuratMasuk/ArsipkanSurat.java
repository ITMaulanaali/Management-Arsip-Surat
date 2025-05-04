
package admin.menuSuratMasuk;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import lib.Query;


public class ArsipkanSurat extends javax.swing.JPanel {
     
    private static final String DEFAULT_URUTAN_TEXT = "001";
    private static final String DEFAULT_KODE_LEMBAGA_TEXT = "HY";
    private static final String DEFAULT_NAMA_INSTANSI_TEXT = "SMK";
    private static final String DEFAULT_BULAN_TEXT = "II";
    private static final String DEFAULT_TAHUN_TEXT = "2025";
    private static final String DEFAULT_PENGIRIM_TEXT = "Nama Instansi";
    private static final String DEFAULT_KATEGORI_TEXT = "Personal";   

     Query query; 
     String[] coloumn = {"no_surat","tanggal_surat","pengirim","kategori","perihal","file_surat","status_notifikasi"};
    
    public ArsipkanSurat() {
        initComponents();
        tampilkanTanggalDanWaktu(); // Menampilkan tanggal dan waktu otomatis
        this.query= new Query();
        
    // Set default text and add focus listener for pengirim
    pengirim.setText(DEFAULT_PENGIRIM_TEXT);
    pengirim.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (pengirim.getText().equals(DEFAULT_PENGIRIM_TEXT)) {
                pengirim.setText("");
            }
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (pengirim.getText().isEmpty()) {
                pengirim.setText(DEFAULT_PENGIRIM_TEXT);
            }
        }
    });

    // Set default text and add focus listener for kategori
    kategori.setText(DEFAULT_KATEGORI_TEXT);
    kategori.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (kategori.getText().equals(DEFAULT_KATEGORI_TEXT)) {
                kategori.setText("");
            }
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (kategori.getText().isEmpty()) {
                kategori.setText(DEFAULT_KATEGORI_TEXT);
            }
        }
    });

    // Set default text and add focus listener for urutan_surat
    urutan_surat.setText(DEFAULT_URUTAN_TEXT);
    urutan_surat.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (urutan_surat.getText().equals(DEFAULT_URUTAN_TEXT)) {
                urutan_surat.setText("");
            }
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (urutan_surat.getText().isEmpty()) {
                urutan_surat.setText(DEFAULT_URUTAN_TEXT);
            }
        }
    });

    // Set default text and add focus listener for kode_lembaga
    kode_lembaga.setText(DEFAULT_KODE_LEMBAGA_TEXT);
    kode_lembaga.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (kode_lembaga.getText().equals(DEFAULT_KODE_LEMBAGA_TEXT)) {
                kode_lembaga.setText("");
            }
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (kode_lembaga.getText().isEmpty()) {
                kode_lembaga.setText(DEFAULT_KODE_LEMBAGA_TEXT);
            }
        }
    });

    // Set default text and add focus listener for nama_instansi
    nama_instansi.setText(DEFAULT_NAMA_INSTANSI_TEXT);
    nama_instansi.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (nama_instansi.getText().equals(DEFAULT_NAMA_INSTANSI_TEXT)) {
                nama_instansi.setText("");
            }
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (nama_instansi.getText().isEmpty()) {
                nama_instansi.setText(DEFAULT_NAMA_INSTANSI_TEXT);
            }
        }
    });

    // Set default text and add focus listener for bulan
    bulan.setText(DEFAULT_BULAN_TEXT);
    bulan.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (bulan.getText().equals(DEFAULT_BULAN_TEXT)) {
                bulan.setText("");
            }
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (bulan.getText().isEmpty()) {
                bulan.setText(DEFAULT_BULAN_TEXT);
            }
        }
    });

        // Set default text and add focus listener for tahun
    tahun.setText(DEFAULT_TAHUN_TEXT);
    tahun.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (tahun.getText().equals(DEFAULT_TAHUN_TEXT)) {
                tahun.setText("");
            }
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (tahun.getText().isEmpty()) {
                tahun.setText(DEFAULT_TAHUN_TEXT);
            }
        }
    });
    
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
        urutan_surat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tanggal_surat_masuk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kategori = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        upload_file = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pengirim = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        perihal = new javax.swing.JTextArea();
        Upload = new javax.swing.JButton();
        garis_miring1 = new javax.swing.JLabel();
        kode_lembaga = new javax.swing.JTextField();
        tahun = new javax.swing.JTextField();
        garis_miring4 = new javax.swing.JLabel();
        garis_miring2 = new javax.swing.JLabel();
        nama_instansi = new javax.swing.JTextField();
        garis_miring3 = new javax.swing.JLabel();
        bulan = new javax.swing.JTextField();
        statusNotifikasi = new javax.swing.JLabel();
        simpan = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kembali = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nomor Surat");

        urutan_surat.setText("001");
        urutan_surat.setPreferredSize(new java.awt.Dimension(40, 30));
        urutan_surat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urutan_suratActionPerformed(evt);
            }
        });

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

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Status Notifikasi");

        pengirim.setText("Nama Instansi");
        pengirim.setPreferredSize(new java.awt.Dimension(40, 30));

        perihal.setColumns(20);
        perihal.setRows(5);
        jScrollPane1.setViewportView(perihal);

        Upload.setText("Upload File");
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });

        garis_miring1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        garis_miring1.setText("/");

        kode_lembaga.setText("HY");
        kode_lembaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_lembagaActionPerformed(evt);
            }
        });

        tahun.setText("2025");
        tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunActionPerformed(evt);
            }
        });

        garis_miring4.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        garis_miring4.setText("/");

        garis_miring2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        garis_miring2.setText("/");

        nama_instansi.setText("SMK");
        nama_instansi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_instansiActionPerformed(evt);
            }
        });

        garis_miring3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        garis_miring3.setText("/");

        bulan.setText("II");
        bulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulanActionPerformed(evt);
            }
        });

        statusNotifikasi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        statusNotifikasi.setText("Belum Dibaca");

        simpan.setBackground(new java.awt.Color(125, 10, 10));
        simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                simpanMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/Arsip.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Simpan");

        javax.swing.GroupLayout simpanLayout = new javax.swing.GroupLayout(simpan);
        simpan.setLayout(simpanLayout);
        simpanLayout.setHorizontalGroup(
            simpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simpanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        simpanLayout.setVerticalGroup(
            simpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(simpanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kembaliMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                kembaliMouseReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/Kembali (1).png"))); // NOI18N

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel11.setText("Kembali");

        javax.swing.GroupLayout kembaliLayout = new javax.swing.GroupLayout(kembali);
        kembali.setLayout(kembaliLayout);
        kembaliLayout.setHorizontalGroup(
            kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kembaliLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kembaliLayout.setVerticalGroup(
            kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(kembaliLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                .addComponent(statusNotifikasi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(95, 95, 95)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(382, 382, 382)
                        .addComponent(simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(urutan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(garis_miring1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(kode_lembaga, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(garis_miring2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(nama_instansi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(garis_miring3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(garis_miring4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tanggal_surat_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(upload_file, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pengirim, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(Upload))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(garis_miring2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urutan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(garis_miring1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kode_lembaga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama_instansi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(garis_miring3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(garis_miring4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggal_surat_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upload_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(pengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(statusNotifikasi))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed
        upload_file.setText(lib.PilihFile.getPath());
    }//GEN-LAST:event_UploadActionPerformed

    private void tanggal_surat_masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggal_surat_masukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggal_surat_masukActionPerformed

    private void urutan_suratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urutan_suratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urutan_suratActionPerformed

    private void kode_lembagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_lembagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_lembagaActionPerformed

    private void tahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunActionPerformed

    private void nama_instansiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_instansiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_instansiActionPerformed

    private void bulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bulanActionPerformed

    private void simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseClicked
        
    // Mengambil nilai dari setiap field
    String nomerSurat = urutan_surat.getText() + "/" + kode_lembaga.getText() + "/" + nama_instansi.getText() 
                        + "/" + bulan.getText() + "/" + tahun.getText();
    String tanggal = tanggal_surat_masuk.getText();
    String namapengirim = pengirim.getText();
    String personalkategori = kategori.getText();
    String catatanperihal = perihal.getText();
    String file_surat = upload_file.getText();
    String tandastatusnotifikasi = statusNotifikasi.getText();

    // Validasi: Cek apakah ada field yang kosong
    if (nomerSurat.isEmpty() || tanggal.isEmpty() || namapengirim.equals(DEFAULT_PENGIRIM_TEXT) || 
        personalkategori.equals(DEFAULT_KATEGORI_TEXT) || catatanperihal.isEmpty() || 
        file_surat.isEmpty()) {
        
        // Tampilkan pesan kesalahan jika ada field yang kosong
        JOptionPane.showMessageDialog(this, "Data Harus Diisi Semua!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        return; // Keluar dari metode jika ada field yang kosong
    }

    String[] Value = {nomerSurat, tanggal, namapengirim, personalkategori, catatanperihal, file_surat, tandastatusnotifikasi};

    try {
        query.setNamaTabel("surat_masuk").setAtribut(coloumn).setValue(Value).insert();
        JOptionPane.showMessageDialog(this, "Data Berhasil Di Simpan ");
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratMasuk.TampilanSuratMasuk());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
        
    } catch (Exception ex) {
        Logger.getLogger(ArsipkanSurat.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Gagal Ditambahkan");
    }
        
    }//GEN-LAST:event_simpanMouseClicked

    private void simpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseEntered
    simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    simpan.setBackground(new java.awt.Color(172, 10, 10));
    
    }//GEN-LAST:event_simpanMouseEntered

    private void simpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseExited
    simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    simpan.setBackground(new java.awt.Color(125, 10, 10));
    }//GEN-LAST:event_simpanMouseExited

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

    private void kembaliMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMousePressed

    }//GEN-LAST:event_kembaliMousePressed

    private void kembaliMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseReleased
  
    }//GEN-LAST:event_kembaliMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Upload;
    private javax.swing.JTextField bulan;
    private javax.swing.JLabel garis_miring1;
    private javax.swing.JLabel garis_miring2;
    private javax.swing.JLabel garis_miring3;
    private javax.swing.JLabel garis_miring4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kategori;
    private java.awt.Panel kembali;
    private javax.swing.JTextField kode_lembaga;
    private javax.swing.JTextField nama_instansi;
    private javax.swing.JTextField pengirim;
    private javax.swing.JTextArea perihal;
    private java.awt.Panel simpan;
    private javax.swing.JLabel statusNotifikasi;
    private javax.swing.JTextField tahun;
    private javax.swing.JTextField tanggal_surat_masuk;
    private javax.swing.JTextField upload_file;
    private javax.swing.JTextField urutan_surat;
    // End of variables declaration//GEN-END:variables
}
