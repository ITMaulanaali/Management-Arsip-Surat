
package admin.menuSuratMasuk;

import java.awt.Graphics;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import lib.Query;


public class ArsipkanSurat extends javax.swing.JPanel {
     
   private static final String DEFAULT_URUTAN_TEXT = "001";
    private static final String DEFAULT_KODE_LEMBAGA_TEXT = "HY";
    private static final String DEFAULT_NAMA_INSTANSI_TEXT = "SMK";
    private static final String DEFAULT_PENGIRIM_TEXT = "Nama Instansi";
    private static final String DEFAULT_KATEGORI_TEXT = "Personal";  
    int bulanAngka;
    int tahunAngka;
    String bulanRomawi;
    String urutanTerakhir;

    private void updateBulanDanTahun() {
        String tanggalInput = tanggal_surat_masuk.getText().trim();
        if (!tanggalInput.isEmpty()) {
            try {
                // Mengubah string tanggal menjadi LocalDate
                LocalDate tanggal = LocalDate.parse(tanggalInput);
                // Mengambil bulan dan tahun
                this.bulanAngka = tanggal.getMonthValue();
                this.tahunAngka = tanggal.getYear();

                // Set bulan dalam format romawi
                this.bulanRomawi = convertToRoman(bulanAngka);
            } catch (Exception e) {
                // Jika format tanggal tidak valid, Anda bisa menampilkan pesan kesalahan
                JOptionPane.showMessageDialog(this, "Format tanggal tidak valid! Gunakan format yyyy-MM-dd.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    String lokasiFileLengkap;
    Query query; 
    String[] coloumn = {"no_surat","tanggal_surat","pengirim","kategori","perihal","file_surat","status_notifikasi"};

    public ArsipkanSurat() {
        initComponents();
        admin.DashboardUtama.Judul.setText("Arsipkan Surat Masuk");
        tampilkanTanggalDanWaktu(); // Menampilkan tanggal dan waktu otomatis
        this.query= new Query();

        // Set placeholder untuk setiap JTextField
        setPlaceholder(pengirim, DEFAULT_PENGIRIM_TEXT);
        setPlaceholder(kode_lembaga, DEFAULT_KODE_LEMBAGA_TEXT);
        setPlaceholder(nama_instansi, DEFAULT_NAMA_INSTANSI_TEXT);

        int lastRowIndex = 0;

        // Ambil data dari kolom "No Surat"
        // Misalkan kolom "No Surat" adalah kolom ke-0
        if(lastRowIndex != -1){
            this.urutanTerakhir = (String) admin.menuSuratMasuk.TampilanSuratMasuk.tabel_suratMasuk.getValueAt(lastRowIndex, 0); // Ganti 0 dengan indeks kolom yang sesuai
            String data = this.urutanTerakhir;
            String[] parts = data.split("/"); // Memisahkan string berdasarkan '/'
            String angka = parts[0]; // Mengambil elemen pertama, yaitu "14"
            int angkaInt = Integer.parseInt(angka);
            // Jika Anda ingin mengonversi ke integer
            String angkaString;
            if (angkaInt + 1 < 100) {
                // Jika angka kurang dari 100, format dengan leading zeros
                angkaString = String.format("%03d", angkaInt + 1);
                urutan_surat.setText(angkaString);
            } else {
                // Jika angka lebih besar atau sama dengan 100, tampilkan tanpa leading zeros
                angkaString = Integer.toString(angkaInt + 1);
                urutan_surat.setText(angkaString);
            }
        }

        tanggal_surat_masuk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                updateBulanDanTahun();
            }
        });

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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon(getClass().getResource("/bahan/background/backgroundPanel800x483px.png"));
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    private void setPlaceholder(javax.swing.JTextField textField, String placeholder) {
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
        tanggal_surat_masuk.setText(sekarang.format(formatTanggal));

        // Ambil bulan dan tahun dari tanggal saat ini
        this.bulanAngka = sekarang.getMonthValue(); // Mendapatkan bulan dalam angka (1-12)
        this.tahunAngka = sekarang.getYear(); // Mendapatkan tahun

        // Set bulan dalam format romawi
        this.bulanRomawi = convertToRoman(bulanAngka);
    }

    private String convertToRoman(int month) {
        switch (month) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            case 11: return "XI";
            case 12: return "XII";
            default: return ""; // Jika bulan tidak valid
        }       
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jLabel5 = new javax.swing.JLabel();
        urutan_surat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        upload_file = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pengirim = new javax.swing.JTextField();
        Upload = new javax.swing.JButton();
        garis_miring1 = new javax.swing.JLabel();
        kode_lembaga = new javax.swing.JTextField();
        garis_miring2 = new javax.swing.JLabel();
        nama_instansi = new javax.swing.JTextField();
        statusNotifikasi = new javax.swing.JLabel();
        simpan = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kembali = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tanggal_surat_masuk = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        kategori = new javax.swing.JComboBox<>();
        perihal = new javax.swing.JTextField();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(tanggal_surat_masuk);

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nomor Surat");

        urutan_surat.setBackground(new java.awt.Color(196, 196, 196));
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

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Pengirim");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Kategori");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("File");

        upload_file.setEditable(false);
        upload_file.setBackground(new java.awt.Color(196, 196, 196));
        upload_file.setPreferredSize(new java.awt.Dimension(40, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Perihal");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Status Notifikasi");

        pengirim.setBackground(new java.awt.Color(196, 196, 196));
        pengirim.setText("Nama Instansi");
        pengirim.setPreferredSize(new java.awt.Dimension(40, 30));

        Upload.setText("Pilih File");
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });

        garis_miring1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        garis_miring1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        garis_miring1.setText("/");

        kode_lembaga.setBackground(new java.awt.Color(196, 196, 196));
        kode_lembaga.setText("KL");
        kode_lembaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_lembagaActionPerformed(evt);
            }
        });

        garis_miring2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        garis_miring2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        garis_miring2.setText("/");

        nama_instansi.setBackground(new java.awt.Color(196, 196, 196));
        nama_instansi.setText("Kode Lembaga");
        nama_instansi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_instansiActionPerformed(evt);
            }
        });

        statusNotifikasi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        statusNotifikasi.setText("Belum Dibaca");

        simpan.setBackground(new java.awt.Color(255, 255, 255));
        simpan.setPreferredSize(new java.awt.Dimension(180, 40));
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/arsip-30px.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setText("Simpan");

        javax.swing.GroupLayout simpanLayout = new javax.swing.GroupLayout(simpan);
        simpan.setLayout(simpanLayout);
        simpanLayout.setHorizontalGroup(
            simpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simpanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        simpanLayout.setVerticalGroup(
            simpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(simpanLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        kembali.setBackground(new java.awt.Color(255, 255, 255));
        kembali.setPreferredSize(new java.awt.Dimension(180, 40));
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
                .addComponent(jLabel11)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        kembaliLayout.setVerticalGroup(
            kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kembaliLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tanggal_surat_masuk.setBackground(new java.awt.Color(196, 196, 196));
        tanggal_surat_masuk.setPreferredSize(new java.awt.Dimension(40, 30));

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Umum", "Segera", "Penting" }));

        perihal.setBackground(new java.awt.Color(196, 196, 196));
        perihal.setPreferredSize(new java.awt.Dimension(40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(urutan_surat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(garis_miring1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kode_lembaga, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(garis_miring2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nama_instansi))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tanggal_surat_masuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(perihal, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pengirim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(statusNotifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(kategori, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(350, 350, 350)
                                        .addComponent(Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(upload_file, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 439, Short.MAX_VALUE)
                                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
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
                            .addComponent(nama_instansi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanggal_surat_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(perihal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addComponent(pengirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(statusNotifikasi, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(upload_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed
        this.lokasiFileLengkap = lib.PilihFile.getPath();
        String namaFilePdf = lokasiFileLengkap.substring(lokasiFileLengkap.lastIndexOf('\\') + 1);
        upload_file.setText(namaFilePdf);
       
    }//GEN-LAST:event_UploadActionPerformed

    private void urutan_suratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urutan_suratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urutan_suratActionPerformed

    private void kode_lembagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_lembagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_lembagaActionPerformed

    private void nama_instansiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_instansiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_instansiActionPerformed

    private void simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseClicked
        
    // Mengambil nilai komponen nomor surat terpisah dulu
        String urutanSurat = urutan_surat.getText().trim();
        String kodeLembaga = kode_lembaga.getText().trim();
        String namaInstansiText = nama_instansi.getText().trim();

        // Cek nomor surat harus valid, tidak boleh kosong atau placeholder
        boolean isNomorSuratValid = !urutanSurat.isEmpty() && !urutanSurat.equals(DEFAULT_URUTAN_TEXT)
                                  && !kodeLembaga.isEmpty() && !kodeLembaga.equals(DEFAULT_KODE_LEMBAGA_TEXT)
                                  && !namaInstansiText.isEmpty() && !namaInstansiText.equals(DEFAULT_NAMA_INSTANSI_TEXT);

        // Bentuk nomor surat lengkap
        String nomerSurat = "";
        if(isNomorSuratValid){
            nomerSurat = urutanSurat + "/" + kodeLembaga + "/" + namaInstansiText 
                        + "/" + this.bulanRomawi + "/" + this.tahunAngka;
        }

        String tanggal = tanggal_surat_masuk.getText().trim();
        String namapengirim = pengirim.getText().trim();
        String personalkategori = kategori.getSelectedItem().toString().trim(); // Mengambil kategori dari JComboBox
        String catatanperihal = perihal.getText().trim();
        String file_surat = "";
        if(this.lokasiFileLengkap != null){
            file_surat = this.lokasiFileLengkap;
        }
        String tandastatusnotifikasi = statusNotifikasi.getText().trim();

        // Validasi: Cek apakah ada field yang kosong dan file berformat PDF
        StringBuilder errorMessage = new StringBuilder("Harap isi data yang masih kosong:\n");
        boolean isValid = true;

        if (!isNomorSuratValid) {
            errorMessage.append("- Nomor Surat (urutan, kode lembaga, dan nama instansi harus diisi )\n");
            isValid = false;
        }
        if (tanggal.isEmpty()) {
            errorMessage.append("- Tanggal Surat Masuk\n");
            isValid = false;
        }
        if (namapengirim.isEmpty() || namapengirim.equals(DEFAULT_PENGIRIM_TEXT)) {
            errorMessage.append("- Pengirim\n");
            isValid = false;
        }
        if (personalkategori.isEmpty() || personalkategori.equals(DEFAULT_KATEGORI_TEXT)) {
            errorMessage.append("- Kategori\n");
            isValid = false;
        }
        if (catatanperihal.isEmpty()) {
            errorMessage.append("- Perihal\n");
            isValid = false;
        }
        if (file_surat.isEmpty() || !file_surat.toLowerCase().endsWith(".pdf")) {
            errorMessage.append("- File harus berformat PDF\n");
            isValid = false;
        }

        if (!isValid) {
            // Tampilkan pesan kesalahan jika ada field yang kosong
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return; // Keluar dari metode jika ada kesalahan validasi
        }

        String[] Value = {nomerSurat, tanggal, namapengirim, personalkategori, catatanperihal, file_surat, tandastatusnotifikasi};

        try {
            query.setNamaTabel("surat_masuk").setAtribut(coloumn).setValue(Value).insert();
            JOptionPane.showMessageDialog(this, "Data Berhasil Di Simpan ");

            // Memperbarui tampilan dengan menampilkan TampilanSuratMasuk
            admin.DashboardUtama.SubPanel.removeAll();
            admin.DashboardUtama.SubPanel.add(new admin.menuSuratMasuk.TampilanSuratMasuk());
            admin.DashboardUtama.SubPanel.revalidate();
            admin.DashboardUtama.SubPanel.repaint();

        } catch (Exception ex) {
            Logger.getLogger(ArsipkanSurat.class.getName()).log(Level.SEVERE, "Gagal memasukkan data: " + ex.getMessage(), ex);
            JOptionPane.showMessageDialog(this, "Gagal Ditambahkan");
        }
        
    }//GEN-LAST:event_simpanMouseClicked

    private void simpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseEntered
    simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    simpan.setBackground(new java.awt.Color(217, 217, 217));
    
    }//GEN-LAST:event_simpanMouseEntered

    private void simpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseExited
    simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    simpan.setBackground(new java.awt.Color(255,255,255)); // Kembalikan warna saat dilepaskan
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
    kembali.setBackground(new java.awt.Color(255,255,255)); // Kembalikan warna saat dilepaskan
    }//GEN-LAST:event_kembaliMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Upload;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel garis_miring1;
    private javax.swing.JLabel garis_miring2;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JComboBox<String> kategori;
    private java.awt.Panel kembali;
    private javax.swing.JTextField kode_lembaga;
    private javax.swing.JTextField nama_instansi;
    private javax.swing.JTextField pengirim;
    private javax.swing.JTextField perihal;
    private java.awt.Panel simpan;
    private javax.swing.JLabel statusNotifikasi;
    private javax.swing.JTextField tanggal_surat_masuk;
    private javax.swing.JTextField upload_file;
    private javax.swing.JTextField urutan_surat;
    // End of variables declaration//GEN-END:variables
}
