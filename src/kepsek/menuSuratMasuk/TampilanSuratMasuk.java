/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kepsek.menuSuratMasuk;

import admin.menuKelolaAkun.TampilanKelolaAkun;
import admin.menuSuratMasuk.*;
import admin.menuSuratKeluar.*;
import admin.menuSuratMasuk.*;
import static admin.menuSuratMasuk.TampilanSuratMasuk.tabel_suratMasuk;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import lib.Query;
/**
 *
 * @author galang
 */
public class TampilanSuratMasuk extends javax.swing.JPanel {

    private Query query = new Query();
    private String[] coloumn = {"no_surat","tanggal_surat","pengirim","kategori","perihal","status_notifikasi"};
    private byte[] file;
    
    private static final String DEFAULT_SEARCH_TEXT = "Cari";
    private ArrayList<String> status_notifikasi_surat;
    private ArrayList<Object[]> baris;
    
    public TampilanSuratMasuk() {
       this.status_notifikasi_surat = new ArrayList();
       this.baris = new ArrayList();
       initComponents();
       kustomTable();
       menampilkanSuratMasuk();
        
        // Set default text and add focus listener
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
                } else {
                    // Refresh the table when focus is lost
                    String searchText = cari.getText();
                    String selectedOption = (String) pilih.getSelectedItem();
                    menampilkanSuratMasuk(searchText, selectedOption);
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
    tabel_suratMasuk.setOpaque(false);
    ((DefaultTableCellRenderer) tabel_suratMasuk.getDefaultRenderer(Object.class)).setOpaque(false);
    jScrollPane2.setOpaque(false);
    jScrollPane2.getViewport().setOpaque(false);
    jScrollPane2.setBorder(null);
    tabel_suratMasuk.setBorder(null);
    tabel_suratMasuk.setShowGrid(false);
    tabel_suratMasuk.setRowSelectionAllowed(true);
    tabel_suratMasuk.setColumnSelectionAllowed(false);

    // Custom renderer untuk transparansi per baris
    tabel_suratMasuk.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

private void setWarnaBaris() {
    TableCellRenderer customRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Cek kolom status
            int statusCol = -1;
            for (int i = 0; i < table.getColumnCount(); i++) {
                if ("Status".equalsIgnoreCase(table.getColumnName(i))) {
                    statusCol = i;
                    break;
                }
            }

            if (statusCol != -1) {
                Object statusValue = status_notifikasi_surat.get(row);
                if ("Belum Dibaca".equalsIgnoreCase(String.valueOf(statusValue))) {
                    c.setFont(new java.awt.Font("Liberation Sans", java.awt.Font.BOLD, 14));
                    c.setForeground(Color.BLACK); // Tetap hitam, tapi bisa kamu ubah kalau mau
                } else {
                    // Default font untuk baris lain
                    c.setFont(new java.awt.Font("Liberation Sans", java.awt.Font.PLAIN, 14));
                    c.setForeground(Color.BLACK);
                }
            }

            if (!isSelected) {
                c.setBackground(new Color(255, 255, 255, 150)); // transparan putih
            } else {
                c.setBackground(new Color(100, 10, 10));
                c.setForeground(table.getSelectionForeground());
            }

            return c;
        }
    };

    // Terapkan renderer ke semua kolom
    for (int i = 0; i < tabel_suratMasuk.getColumnCount(); i++) {
        tabel_suratMasuk.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
    }
}

    
     void menampilkanSuratMasuk(){
        try {
            PreparedStatement stm = lib.Koneksi.Koneksi().prepareStatement("SELECT surat_masuk.no_surat, surat_masuk.tanggal_surat, surat_masuk.pengirim, surat_masuk.kategori, surat_masuk.perihal, surat_masuk.status_notifikasi, IFNULL(disposisi.status_disposisi, 'Belum Terdisposisi') AS status_disposisi FROM surat_masuk LEFT JOIN (SELECT no_surat, MIN(no_disposisi) AS min_no_disposisi FROM disposisi WHERE status_disposisi = 'terdisposisi' GROUP BY no_surat) AS disposisi_terpilih ON surat_masuk.no_surat = disposisi_terpilih.no_surat LEFT JOIN disposisi ON disposisi.no_disposisi = disposisi_terpilih.min_no_disposisi");
            ResultSet hasil = stm.executeQuery();
            
            DefaultTableModel modelTable = new DefaultTableModel(); 
            modelTable.addColumn("No Surat");
            modelTable.addColumn("Tanggal Diterima");
            modelTable.addColumn("Pengirim");
            modelTable.addColumn("Kategori");
            modelTable.addColumn("Perihal");
            modelTable.addColumn("Status");
            
            int index = 0;
            while(hasil.next()){
                String no = hasil.getString("surat_masuk.no_surat");
                String tanggal = hasil.getString("tanggal_surat");
                String pengirim = hasil.getString("pengirim");
                String kategori = hasil.getString("kategori");
                String perihal = hasil.getString("perihal");
                String status_notifikasi_disposisi = hasil.getString("status_disposisi");
                
                this.status_notifikasi_surat.add(hasil.getString("surat_masuk.status_notifikasi"));
                this.baris.add(new Object[]{no, tanggal, pengirim, kategori, perihal, status_notifikasi_disposisi});
                index++;
            }
            Collections.reverse(this.baris);
            Collections.reverse(this.status_notifikasi_surat);
            for (Object[] row : this.baris) {
                modelTable.addRow(row);
            }
            
            tabel_suratMasuk.setRowHeight(30);
            tabel_suratMasuk.setModel(modelTable);
            setWarnaBaris();
            
        }catch (Exception ex) {
            Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
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

        cari = new javax.swing.JTextField();
        pilih = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_suratMasuk = new javax.swing.JTable();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        cari.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cari.setText("Cari");
        cari.setMinimumSize(new java.awt.Dimension(0, 40));
        cari.setPreferredSize(new java.awt.Dimension(600, 40));
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Perihal", "Kategori", "Tanggal Diterima" }));
        pilih.setToolTipText("");
        pilih.setPreferredSize(new java.awt.Dimension(80, 40));

        tabel_suratMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_suratMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabel_suratMasukMousePressed(evt);
            }
        });
        tabel_suratMasuk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabel_suratMasukKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_suratMasuk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                        .addGap(98, 98, 98)
                        .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
        // TODO add your handling code here:
        String searchText = cari.getText();
    String selectedOption = (String) pilih.getSelectedItem();
    menampilkanSuratMasuk(searchText, selectedOption);
}                                    

void TampilanSuratMasuk(String searchText, String selectedOption) {
    try {

        String queryCondition = "";
        switch (selectedOption) {
            case "No":
                queryCondition = coloumn[0];
                break;
            case "Tanggal Surat":
                queryCondition = "tanggal_surat";
                break;
            case "Pengirim":
                queryCondition = "pengirim";
                break;
            case "Kategori":
                queryCondition = "kategori ";
                break;
            case "Perihal":
                queryCondition = "perihal";
                break;
            default:
                break;
        }
        // Lakukan query dengan kondisi yang telah dibuat
            PreparedStatement stm = lib.Koneksi.Koneksi().prepareStatement("SELECT surat_masuk.no_surat, surat_masuk.tanggal_surat, surat_masuk.pengirim, surat_masuk.kategori, surat_masuk.perihal, IFNULL(disposisi.status_disposisi, 'Belum Terdisposisi') AS status_disposisi FROM surat_masuk LEFT JOIN (SELECT no_surat, MIN(no_disposisi) AS min_no_disposisi FROM disposisi WHERE status_disposisi = 'terdisposisi' GROUP BY no_surat) AS disposisi_terpilih ON surat_masuk.no_surat = disposisi_terpilih.no_surat LEFT JOIN disposisi ON disposisi.no_disposisi = disposisi_terpilih.min_no_disposisi");
            ResultSet hasil = stm.executeQuery();
            
            DefaultTableModel modelTable = new DefaultTableModel(); 
            modelTable.addColumn("No Surat");
            modelTable.addColumn("Tanggal Diterima");
            modelTable.addColumn("Pengirim");
            modelTable.addColumn("Kategori");
            modelTable.addColumn("Perihal");
            modelTable.addColumn("Status");
            
            
            while(hasil.next()){
                String no = hasil.getString("surat_masuk.no_surat");
                String tanggal = hasil.getString("tanggal_surat");
                String pengirim = hasil.getString("pengirim");
                String kategori = hasil.getString("kategori");
                String perihal = hasil.getString("perihal");
                String status_notifikasi = hasil.getString("status_disposisi");
                
                modelTable.addRow(new Object[]{no, tanggal, pengirim, kategori, perihal, status_notifikasi});
            }
            tabel_suratMasuk.setRowHeight(30);
            tabel_suratMasuk.setModel(modelTable);
            

    } catch (Exception ex) {
        Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_cariKeyPressed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
     String searchText = cari.getText();
        String selectedOption = (String) pilih.getSelectedItem();
        menampilkanSuratMasuk(searchText, selectedOption);
}                                    

void menampilkanSuratMasuk(String searchText, String selectedOption) {
    try {
            String queryCondition = "";
            switch (selectedOption) {
                case "No":
                    queryCondition = coloumn[0];
                    break;
                case "Tanggal Surat":
                    queryCondition = "tanggal_surat";
                    break;
                case "Pengirim":
                    queryCondition = "pengirim";
                    break;
                case "Kategori":
                    queryCondition = "kategori ";
                    break;
                case "Perihal":
                    queryCondition = "perihal";
                    break;
                case "File Surat":
                    queryCondition = "file_surat ";
                    break;
                case "Status Notifikasi":
                    queryCondition = "status_notifikasi ";
                    break;
                default:
                    break;
            }
            // Lakukan query dengan kondisi yang telah dibuat
            PreparedStatement stm = lib.Koneksi.Koneksi().prepareStatement("SELECT surat_masuk.no_surat, surat_masuk.tanggal_surat, surat_masuk.pengirim, surat_masuk.kategori, surat_masuk.perihal, IFNULL(disposisi.status_disposisi, 'Belum Terdisposisi') AS status_disposisi FROM surat_masuk LEFT JOIN (SELECT no_surat, MIN(no_disposisi) AS min_no_disposisi FROM disposisi WHERE status_disposisi = 'terdisposisi' GROUP BY no_surat) AS disposisi_terpilih ON surat_masuk.no_surat = disposisi_terpilih.no_surat LEFT JOIN disposisi ON disposisi.no_disposisi = disposisi_terpilih.min_no_disposisi;");
            ResultSet hasil = stm.executeQuery();
            
            DefaultTableModel modelTable = new DefaultTableModel(); 
            modelTable.addColumn("No Surat");
            modelTable.addColumn("Tanggal Diterima");
            modelTable.addColumn("Pengirim");
            modelTable.addColumn("Kategori");
            modelTable.addColumn("Perihal");
            modelTable.addColumn("Status");
            
            
            while(hasil.next()){
                String no = hasil.getString("surat_masuk.no_surat");
                String tanggal = hasil.getString("tanggal_surat");
                String pengirim = hasil.getString("pengirim");
                String kategori = hasil.getString("kategori");
                String perihal = hasil.getString("perihal");
                String status_notifikasi = hasil.getString("status_disposisi");
                
                modelTable.addRow(new Object[]{no, tanggal, pengirim, kategori, perihal, status_notifikasi});
            }
            tabel_suratMasuk.setRowHeight(30);
            tabel_suratMasuk.setModel(modelTable);
            

        } catch (Exception ex) {
            Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_cariActionPerformed

    private void tabel_suratMasukMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_suratMasukMousePressed
       int baris = tabel_suratMasuk.rowAtPoint(evt.getPoint());
    if (baris < 0) {
        return; // Clicked outside table rows
    }

    if (evt.getClickCount() == 1) {
        // Single click: set selection on the clicked row
        tabel_suratMasuk.setRowSelectionInterval(baris, baris);
        
        // Logika untuk klik satu kali
        String noSurat = (String) tabel_suratMasuk.getValueAt(baris, 0);
        // Panggil metode atau lakukan aksi yang diinginkan
        System.out.println("Satu kali klik pada No Surat: " + noSurat);
        // Misalnya, Anda bisa memanggil metode lain di sini
        // ppilih(noSurat); // Contoh pemanggilan metode

    } else if (evt.getClickCount() == 2) {
        // Double click: open LihatSurat panel with selected row details
        String[] data = new String[6];

        data[0] = (String) tabel_suratMasuk.getValueAt(baris, 0);
        data[1] = (String) tabel_suratMasuk.getValueAt(baris, 1);
        data[2] = (String) tabel_suratMasuk.getValueAt(baris, 2);
        data[3] = (String) tabel_suratMasuk.getValueAt(baris, 3);
        data[4] = (String) tabel_suratMasuk.getValueAt(baris, 4);
        data[5] = (String) tabel_suratMasuk.getValueAt(baris, 5);

        try {
            String[] atributs = {"no_surat", "file_surat"};
            ResultSet hasil = query.setNamaTabel("surat_masuk").setAtribut(atributs).setWhereId("no_surat", data[0]).selectWhereIdDownload();
            while (hasil.next()) {
                this.file = hasil.getBytes("file_surat");
            }
        } catch (Exception ex) {
            Logger.getLogger(admin.menuSuratMasuk.TampilanSuratMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }

        kepsek.DashboardUtama.SubPanel.removeAll();
        kepsek.DashboardUtama.SubPanel.add(new kepsek.menuSuratMasuk.LihatSurat(data, file));
        kepsek.DashboardUtama.SubPanel.revalidate();
        kepsek.DashboardUtama.SubPanel.repaint(); 
    }
        
    }//GEN-LAST:event_tabel_suratMasukMousePressed

    private void tabel_suratMasukKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabel_suratMasukKeyPressed
                tabel_suratMasuk.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            e.consume(); // Mencegah enter berpindah ke baris bawah

            int baris = tabel_suratMasuk.getSelectedRow();
            if (baris >= 0) {
                String[] data = new String[6];
                data[0] = (String)tabel_suratMasuk.getValueAt(baris, 0);
                data[1] = (String)tabel_suratMasuk.getValueAt(baris, 1);
                data[2] = (String)tabel_suratMasuk.getValueAt(baris, 2);
                data[3] = (String)tabel_suratMasuk.getValueAt(baris, 3);
                data[4] = (String)tabel_suratMasuk.getValueAt(baris, 4);
                data[5] = (String)tabel_suratMasuk.getValueAt(baris, 5);

                byte[] file = null;
                try {
                    String[] atributs = {"no_surat","file_surat"};
                    ResultSet hasil = query.setNamaTabel("surat_masuk")
                                           .setAtribut(atributs)
                                           .setWhereId("no_surat", data[0])
                                           .selectWhereIdDownload();
                    while (hasil.next()) {
                        file = hasil.getBytes("file_surat");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(admin.menuSuratMasuk.TampilanSuratMasuk.class.getName()).log(Level.SEVERE, null, ex);
                }

                kepsek.DashboardUtama.SubPanel.removeAll();
                kepsek.DashboardUtama.SubPanel.add(new kepsek.menuSuratMasuk.LihatSurat(data, file));
                kepsek.DashboardUtama.SubPanel.revalidate();
                kepsek.DashboardUtama.SubPanel.repaint();
            }
        }
    }
});
    }//GEN-LAST:event_tabel_suratMasukKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTable tabel_suratMasuk;
    // End of variables declaration//GEN-END:variables
}
