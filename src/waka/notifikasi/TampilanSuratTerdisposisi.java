
package waka.notifikasi;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import lib.Query;
import java.sql.Connection; // Import Connection
import java.sql.ResultSet; // Import ResultSet
import java.sql.Statement; // Import Statement
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.Koneksi;


public class TampilanSuratTerdisposisi extends javax.swing.JPanel {
    Query query = new Query();
    String[] atributs = {"No_surrat","Dari","Diterima","Perihal"};

    
    
    public TampilanSuratTerdisposisi() {
        initComponents();
        menampilkanDisposisi();
                
        
        DefaultTableModel model = (DefaultTableModel) tabel_suratkeluar.getModel();
        rowSorter = new TableRowSorter<>(model);
        tabel_suratkeluar.setRowSorter(rowSorter);



        
    }
    
    void menampilkanDisposisi(){
        Connection connection = null;
        Statement statement = null;
        ResultSet hasil = null;

        try {
    // Menggunakan JOIN untuk menggabungkan data dari tiga tabel
    String sql = "SELECT sm.no_surat, sm.perihal, d.tanggal_disposisi, u.username " +
                         "FROM arsipSurat_lifegiftgo.surat_masuk AS sm " +
                         "JOIN arsipSurat_lifegiftgo.disposisi AS d ON sm.no_surat = d.no_surat " +
                         "JOIN arsipSurat_lifegiftgo.user AS u ON d.username = u.username"; // Pastikan ini benar

    // Membuat statement untuk mengeksekusi query
    statement = lib.Koneksi.Koneksi().createStatement();
    hasil = statement.executeQuery(sql);

    DefaultTableModel modelTable = new DefaultTableModel();
    modelTable.addColumn("No Surat");
    modelTable.addColumn("Dari");
    modelTable.addColumn("Diterima");
    modelTable.addColumn("Perihal");

    if (!hasil.next()) {
        System.out.println("Tidak ada data yang ditemukan.");
    } else {
        do {
            String no = hasil.getString("no_surat");
            String dari = hasil.getString("username");
            String diterima = hasil.getString("tanggal_disposisi");
            String perihal = hasil.getString("perihal");

            modelTable.addRow(new Object[]{no, dari, diterima, perihal});
        } while (hasil.next());
    }

            tabel_suratkeluar.setRowHeight(30);
            tabel_suratkeluar.setModel(modelTable);

        } catch (Exception ex) {
            Logger.getLogger(TampilanSuratTerdisposisi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Menutup koneksi dan statement
            try {
                if (hasil != null) hasil.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                Logger.getLogger(TampilanSuratTerdisposisi.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
        
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_suratkeluar = new javax.swing.JTable();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No_surat", "Dari", "Diterima", "Perihal" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(80, 40));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("Cari");
        jTextField1.setMinimumSize(new java.awt.Dimension(0, 40));
        jTextField1.setPreferredSize(new java.awt.Dimension(600, 40));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        tabel_suratkeluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No_surat", "Perihal", "Diterima", "Dari"
            }
        ));
        tabel_suratkeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_suratkeluarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_suratkeluar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(80, 80, 80)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed

      String text = jTextField1.getText(); // ambil teks dari input
    int selectedColumn = jComboBox1.getSelectedIndex(); // ambil index kolom yang dipilih di combo box

    if (text.trim().length() == 0) {
        rowSorter.setRowFilter(null); // kalau teks kosong, hapus filter
    } else {
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, selectedColumn)); // filter berdasarkan input
    }

    }//GEN-LAST:event_jTextField1KeyPressed

    private void tabel_suratkeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_suratkeluarMouseClicked
       
       int selectedRowView = tabel_suratkeluar.getSelectedRow();
    
    if (selectedRowView >= 0) {
        int selectedRowModel = tabel_suratkeluar.convertRowIndexToModel(selectedRowView); // ini penting kalau sudah pakai filter
        
        String No_Surat = tabel_suratkeluar.getModel().getValueAt(selectedRowModel, 0).toString();
        String Dari = tabel_suratkeluar.getModel().getValueAt(selectedRowModel, 1).toString();
        String Diterima = tabel_suratkeluar.getModel().getValueAt(selectedRowModel, 2).toString();
        String Perihal = tabel_suratkeluar.getModel().getValueAt(selectedRowModel, 3).toString();
        
        // Kalau mau simpan ke global variable atau lanjut ke form berikutnya, bisa disini:
        System.out.println("Klik Surat: " + No_Surat + ", Dari: " + Dari + ", Diterima: " + Diterima + ", Perihal: " + Perihal);
        
        // Pindah ke panel LembarDisposisi
        waka.DashboardUtama.SubPanel.removeAll(); 
        waka.DashboardUtama.SubPanel.add(new waka.notifikasi.LembarDisposisi());
        waka.DashboardUtama.SubPanel.revalidate();
        waka.DashboardUtama.SubPanel.repaint();
        
    } else {
        System.out.println("Belum ada baris yang dipilih");
    }

    }//GEN-LAST:event_tabel_suratkeluarMouseClicked

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
   String text = jTextField1.getText();
    int selectedColumn = jComboBox1.getSelectedIndex() - 1; // karena index 0 = Semua

    if (text.trim().length() == 0) {
        rowSorter.setRowFilter(null);
    } else {
        if (selectedColumn == -1) { 
            // Kalau pilih "Semua", filter semua kolom
            RowFilter<DefaultTableModel, Object> rf = new RowFilter<DefaultTableModel, Object>() {
                @Override
                public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                    for (int i = 0; i < entry.getValueCount(); i++) {
                        if (entry.getStringValue(i).toLowerCase().contains(text.toLowerCase())) {
                            return true;
                        }
                    }
                    return false;
                }
            };
            rowSorter.setRowFilter(rf);
        } else {
            // Kalau pilih kolom tertentu
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, selectedColumn));
        }
    }



        
    }//GEN-LAST:event_jComboBox1MouseClicked



private TableRowSorter<DefaultTableModel> rowSorter;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabel_suratkeluar;
    // End of variables declaration//GEN-END:variables
}
