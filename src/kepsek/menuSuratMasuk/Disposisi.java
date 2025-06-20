package kepsek.menuSuratMasuk;

import admin.menuSuratMasuk.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.Timer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.sql.ResultSet;
import java.util.ArrayList;
import lib.Query;

public class Disposisi extends javax.swing.JPanel {

    private JPanel panelUtama;
    private static int sequence = 0; // Penghitung urutan nomor surat
    private static final String DIVISION = "SMK"; // Kode divisi (Kepala Sekolah)
    private static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yyyy");
    Query query; 
    String[] coloumn = {"No Surat Perihal", "Catatan"};
    
    private String[] dataAtributs;
    private byte[] fileBiner;
    ArrayList<String> usernameWaka;
    ArrayList<String> roleWaka;
    ArrayList<JCheckBox> cekBox;
    
    private String bulanAngka;
    private int tahun;
    private int naikan;
    
    public Disposisi(String[] data, byte[] fileBiner) {
        this.panelUtama = panelUtama;
        initComponents();
        kepsek.DashboardUtama.Judul.setText("Disposisi");
        tampilkanTanggalDanWaktu();
        this.query= new Query();
        this.usernameWaka = new ArrayList<>();
        this.roleWaka = new ArrayList<>();
        this.cekBox = new ArrayList<>();
        generateAutoLetterNumber(); // Generate nomor surat otomatis saat inisialisasi
        
        this.fileBiner = fileBiner;
        this.dataAtributs = data;
        String nomerSurat = this.dataAtributs[0];
        String perihal = this.dataAtributs[4];
        
        Perihal.setText(perihal);
        kumpulanWaka();
        getLastNoDisposisi();
    }
    
    private void generateAutoLetterNumber() {
        sequence++; // Increment nomor urut
        String year = LocalDate.now().format(YEAR_FORMATTER);
        String letterNumber = String.format("%03d/%s/%s", sequence, DIVISION, year);
//        no_disposisi.setText(letterNumber);
    }
    
    private void tampilkanTanggalDanWaktu() {
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime sekarang = LocalDateTime.now();
            tanggal_disposisi.setText(sekarang.format(formatTanggal));
    }
      
      
    private void kumpulanWaka(){
        String atributs[] = {"username","jenis_role"};
        try {
            ResultSet hasil = query.setNamaTabel("user").setAtribut(atributs).select();
            
            while(hasil.next()){
                 String role = hasil.getString("jenis_role");
    String username = hasil.getString("username");

    if (role.equals("admin") || role.equals("kepala sekolah")) {
        continue;
    }

    usernameWaka.add(username);
    roleWaka.add(role);

    JCheckBox cb = new JCheckBox(role); // gunakan langsung variabel 'role'
    cb.setBorder(new EmptyBorder(5, 2, 10, 0));

    cekBox.add(cb);
    panelWaka.add(cb);
            }
            panelWaka.add(Box.createRigidArea(new Dimension(0,10)));
            panelWaka.setLayout(new BoxLayout(panelWaka, BoxLayout.Y_AXIS));
        } catch (Exception ex) {
            Logger.getLogger(Disposisi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void getLastNoDisposisi(){
        String noDis = "";
        try {
            PreparedStatement stm = lib.Koneksi.Koneksi().prepareStatement("SELECT * from disposisi");
            ResultSet hasil = stm.executeQuery();
            
            while(hasil.next()){
                    noDis = hasil.getString("no_disposisi");
            }

             // Ambil data dari kolom "No Surat"
            // Misalkan kolom "No Surat" adalah kolom ke-0
            if(!noDis.equals("")){
                String data = noDis;
                String[] parts = data.split("/"); // Memisahkan string berdasarkan '/'
                String angka = parts[0]; // Mengambil elemen pertama, yaitu "14"
                int angkaInt = Integer.parseInt(angka);
                // Jika Anda ingin mengonversi ke integer
                String angkaString;
                if (angkaInt + 1 < 100) {
                    // Jika angka kurang dari 100, format dengan leading zeros
                    angkaString = String.format("%03d", angkaInt + 1);
                    no_disposisi.setText(angkaString);
                } else {
                    // Jika angka lebih besar atau sama dengan 100, tampilkan tanpa leading zeros
                angkaString = Integer.toString(angkaInt + 1);
                no_disposisi.setText(angkaString);
                }
        }
        
    }   catch (Exception ex) {
            Logger.getLogger(Disposisi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jLabel5 = new javax.swing.JLabel();
        no_disposisi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Perihal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Kirim = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Catatan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelWaka = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        tanggal_disposisi = new javax.swing.JTextField();
        kembali = new java.awt.Panel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(tanggal_disposisi);

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nomor Disposisi");

        no_disposisi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        no_disposisi.setText("001");
        no_disposisi.setPreferredSize(new java.awt.Dimension(40, 30));
        no_disposisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_disposisiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tanggal Disposisi");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Disposisi Kepada");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Perihal");

        Perihal.setEditable(false);
        Perihal.setBackground(new java.awt.Color(255, 255, 255));
        Perihal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Perihal.setPreferredSize(new java.awt.Dimension(40, 30));
        Perihal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerihalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Catatan");

        Kirim.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Kirim.setText("Kirim");
        Kirim.setMinimumSize(new java.awt.Dimension(83, 40));
        Kirim.setPreferredSize(new java.awt.Dimension(80, 40));
        Kirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KirimMouseClicked(evt);
            }
        });
        Kirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KirimActionPerformed(evt);
            }
        });

        Catatan.setColumns(20);
        Catatan.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Catatan.setRows(5);
        jScrollPane1.setViewportView(Catatan);

        panelWaka.setBackground(new java.awt.Color(255, 255, 255));
        panelWaka.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        panelWaka.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        panelWaka.setLayout(new javax.swing.BoxLayout(panelWaka, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane2.setViewportView(panelWaka);
        panelWaka.getAccessibleContext().setAccessibleName("");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tanggal_disposisi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tanggal_disposisi.setPreferredSize(new java.awt.Dimension(40, 30));

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/kembali-30px.png"))); // NOI18N

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel14.setText("Kembali");

        javax.swing.GroupLayout kembaliLayout = new javax.swing.GroupLayout(kembali);
        kembali.setLayout(kembaliLayout);
        kembaliLayout.setHorizontalGroup(
            kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kembaliLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        kembaliLayout.setVerticalGroup(
            kembaliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kembaliLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tanggal_disposisi, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(289, 289, 289)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(294, 294, 294)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(no_disposisi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Kirim, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Perihal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(no_disposisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tanggal_disposisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Perihal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Kirim, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void KirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KirimMouseClicked
        // TODO add your handling code here:
  
    }//GEN-LAST:event_KirimMouseClicked

    private void no_disposisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_disposisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_disposisiActionPerformed

    private void PerihalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerihalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerihalActionPerformed
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
    private void KirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KirimActionPerformed
        // TODO add your handling code here:
       //Get the values from the form
       
       boolean anySelected = false;
    for (JCheckBox checkBox : this.cekBox) {
        if (checkBox.isSelected()) {
            anySelected = true;
            break;
        }
    }

    // Show error message if no checkbox is selected
    if (!anySelected) {
        JOptionPane.showMessageDialog(this, "Pilih minimal satu tujuan disposisi!", 
                "Validasi Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if no checkbox is selected
    }
       
        String tahun = tanggal_disposisi.getText().substring(0, 4);
        String bulan = tanggal_disposisi.getText().substring(5, 7);
        this.naikan = Integer.parseInt(no_disposisi.getText());
               
        String noDisposisi = this.naikan + "/DISP-KS" + "/" + convertToRoman(Integer.parseInt(bulan)) + "/" + tahun;
        String tanggal = tanggal_disposisi.getText();
        String catatan = Catatan.getText();
        String status = "Terdisposisi";
        String nomerSurat = this.dataAtributs[0];
        
//        for(JCheckBox i : cekBox){
//            if(i.isSelected()){
//                this.disposisiKepada.add(this.usernameWaka.get(i));
//            }
//        }
        
        // Get selected disposisi recipients
        
        // Check if any required fields are empty
        if (noDisposisi.isEmpty() || tanggal.isEmpty() || Perihal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nomor surat, tanggal, dan perihal harus diisi!", 
                    "Validasi Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if validation fails
        }
        
Connection conn = null;
PreparedStatement stmt = null;

try {
    // 1. Ambil koneksi dan matikan auto-commit
    conn = lib.Koneksi.Koneksi();
    conn.setAutoCommit(false); // Mulai transaksi manual

    String sql = "INSERT INTO disposisi (no_disposisi, tanggal_disposisi, catatan, status_disposisi, username, no_surat) VALUES (?, ?, ?, ?, ?, ?)";
    stmt = conn.prepareStatement(sql);

    // 2. Loop dan lakukan insert
    for (int i = 0; i < this.cekBox.size(); i++) {
        if (this.cekBox.get(i).isSelected()) {
            String angkaFormatted = String.format("%03d", this.naikan);
            String noDis = angkaFormatted + "/DISP-KS/" + convertToRoman(Integer.parseInt(bulan)) + "/" + tahun;
            
            stmt.setString(1, noDis);
            stmt.setString(2, tanggal);
            stmt.setString(3, catatan);
            stmt.setString(4, status);
            stmt.setString(5, this.usernameWaka.get(i));
            stmt.setString(6, this.dataAtributs[0]);
            stmt.addBatch(); // Tambahkan ke batch
            this.naikan++;
        }
    }

    // 3. Eksekusi batch
    stmt.executeBatch();

    // 4. Commit transaksi jika semua berhasil
    conn.commit();
    JOptionPane.showMessageDialog(this, "Disposisi berhasil disimpan");
                
                // Navigate to the next view
                kepsek.DashboardUtama.SubPanel.removeAll();
                kepsek.DashboardUtama.SubPanel.add(new kepsek.menuSuratMasuk.TampilanSuratMasuk());
                kepsek.DashboardUtama.SubPanel.revalidate();
                kepsek.DashboardUtama.SubPanel.repaint();
} catch (SQLException ex) {
    try {
        if (conn != null) conn.rollback(); // Rollback kalau ada error
        Logger.getLogger(Disposisi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), 
                    "Database Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    Logger.getLogger(Disposisi.class.getName()).log(Level.SEVERE, null, ex);
} finally {
    // 5. Tutup koneksi & statement
    try {
        if (stmt != null) stmt.close();
        if (conn != null) conn.setAutoCommit(true); // Balikkan ke mode auto
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    }//GEN-LAST:event_KirimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseClicked

        kepsek.DashboardUtama.SubPanel.removeAll();
        kepsek.DashboardUtama.SubPanel.add(new kepsek.menuSuratMasuk.LihatSurat(this.dataAtributs, this.fileBiner));
        kepsek.DashboardUtama.SubPanel.revalidate();
        kepsek.DashboardUtama.SubPanel.repaint();
    }//GEN-LAST:event_kembaliMouseClicked

    private void kembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseEntered
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
        kembali.setBackground(new java.awt.Color(217, 217, 217));
    }//GEN-LAST:event_kembaliMouseEntered

    private void kembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseExited
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
        kembali.setBackground(new java.awt.Color(255,255,255)); // Kembalikan warna saat dilepaskan
    }//GEN-LAST:event_kembaliMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Catatan;
    private javax.swing.JButton Kirim;
    private javax.swing.JTextField Perihal;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Panel kembali;
    private javax.swing.JTextField no_disposisi;
    private javax.swing.JPanel panelWaka;
    private javax.swing.JTextField tanggal_disposisi;
    // End of variables declaration//GEN-END:variables
}
