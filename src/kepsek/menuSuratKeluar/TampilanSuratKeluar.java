
package kepsek.menuSuratKeluar;

import admin.menuKelolaAkun.TampilanKelolaAkun;
import kepsek.menuSuratMasuk.*;
import admin.menuSuratMasuk.*;
import admin.menuSuratKeluar.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lib.Query;


public class TampilanSuratKeluar extends javax.swing.JPanel {

private String selectedNoSurat;
private String selectedTanggalSurat;
private String selectedPenerima;
private String selectedKategori;
private String selectedPerihal;
private String selectedStatusPengiriman;
private String selectedAlamatTujuan;
private byte[] file;

private ArrayList<String> status_notifikasi_surat;
private ArrayList<Object[]> baris;
    
  private String getFileSuratFromDatabase(String noSurat) {
    String fileSurat = "";
    try {
        ResultSet hasil = query.setNamaTabel("surat_keluar")
            .setAtribut(new String[]{"file_surat"})
            .setWhereId("no_surat", noSurat)
            .selectWhereLike();
        
        if (hasil.next()) {
            fileSurat = hasil.getString("file_surat");
        }
    } catch (Exception ex) {
        Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
    }
    return fileSurat;
}

    Query query = new Query();
    String[] coloumn = {"no_surat","tanggal_surat","penerima","kategori","perihal","status_pengiriman","alamat_tujuan"};
    
    
    public TampilanSuratKeluar() {
        initComponents();
        kepsek.DashboardUtama.Judul.setText("Home");
        this.status_notifikasi_surat = new ArrayList();
        this.baris = new ArrayList();
        menampilkanSuratKeluar();
        kustomTable();
        cari.setText("Cari");
        
        cari.setText("Cari");
        cari.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            // When the text field gains focus
            if (cari.getText().equals("Cari")) {
                cari.setText("");  // Clear text
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
            // When the text field loses focus
            if (cari.getText().isEmpty()) {
                cari.setText("Cari");  // Restore default text
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
    tableKeluar.setOpaque(false);
    ((DefaultTableCellRenderer) tableKeluar.getDefaultRenderer(Object.class)).setOpaque(false);
    jScrollPane2.setOpaque(false);
    jScrollPane2.getViewport().setOpaque(false);
    jScrollPane2.setBorder(null);
    tableKeluar.setBorder(null);
    tableKeluar.setShowGrid(false);
    tableKeluar.setRowSelectionAllowed(true);
    tableKeluar.setColumnSelectionAllowed(false);

    // Custom renderer untuk transparansi per baris
    tableKeluar.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

      void menampilkanSuratKeluar(){
        try {
            ResultSet hasil = query.setNamaTabel("surat_keluar").setAtribut(this.coloumn).select();
            
            DefaultTableModel modelTable = new DefaultTableModel(); 
            modelTable.addColumn("No Surat");
            modelTable.addColumn("Tanggal Surat");
            modelTable.addColumn("Penerima");
            modelTable.addColumn("Kategori");
            modelTable.addColumn("Perihal");
            modelTable.addColumn("Status Pengiriman");
            modelTable.addColumn("Alamat Tujuan");
            
            this.baris.clear();
            this.status_notifikasi_surat.clear();
            int index = 0;
            while(hasil.next()){
                String no = hasil.getString("no_surat");
                String tanggal = hasil.getString("tanggal_surat");
                String penerima = hasil.getString("penerima");
                String kategori = hasil.getString("kategori");
                String perihal = hasil.getString("perihal");
                String status_pengiriman = hasil.getString("status_pengiriman");
                String alamat_tujuan = hasil.getString("alamat_tujuan");
                
                this.status_notifikasi_surat.add(hasil.getString("status_pengiriman"));
                this.baris.add(new Object[]{no, tanggal, penerima, kategori, perihal, status_pengiriman, alamat_tujuan});
                index++;
//                modelTable.addRow(new Object[]{no, tanggal, penerima, kategori, perihal,status_pengiriman, alamat_tujuan });
            }
            Collections.reverse(this.baris);
            Collections.reverse(this.status_notifikasi_surat);
            for (Object[] row : this.baris) {
                modelTable.addRow(row);
            }
            tableKeluar.setRowHeight(30);
            tableKeluar.setModel(modelTable);
            
        }catch (Exception ex) {
            Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cari = new javax.swing.JTextField();
        pilih = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKeluar = new javax.swing.JTable();

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

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Surat", "Tanggal Surat", "Penerima", "Kategori", "Perihal", "Status Pengiriman", "Alamat Tujuan" }));
        pilih.setPreferredSize(new java.awt.Dimension(80, 40));

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        tableKeluar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tableKeluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableKeluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tableKeluarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableKeluarMousePressed(evt);
            }
        });
        tableKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeluarKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tableKeluar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                        .addGap(98, 98, 98)
                        .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
    // TODO add your handling code here:
  
    String searchText = cari.getText();
    String selectedOption = (String) pilih.getSelectedItem();
    menampilkanSuratKeluar(searchText, selectedOption);
    
    }
    
    void menampilkanSuratKeluar(String searchText, String selectedOption) {
    try {

        String queryCondition = "";
        switch (selectedOption) {
            case "No":
                queryCondition = coloumn[0];
                break;
            case "Tanggal Surat":
                queryCondition = "tanggal_surat";
                break;
            case "Penerima":
                queryCondition = "penerima";
                break;
            case "Kategori":
                queryCondition = "kategori ";
                break;
            case "Perihal":
                queryCondition = "perihal";
                break;
            case "Status Pengiriman":
                queryCondition = "status_pengiriman ";
                break;
            case "Alamat Tujuan":
                queryCondition = "alamat_tujuan ";
                break;
            default:
                break;
        }
        // Lakukan query dengan kondisi yang telah dibuat
        ResultSet hasil = query.setNamaTabel("surat_keluar").setAtribut(this.coloumn).setWhereId(queryCondition, searchText).selectWhereLike();

        DefaultTableModel modelTable = new DefaultTableModel(); 
        modelTable.addColumn("No Surat");
        modelTable.addColumn("Tanggal Surat");
        modelTable.addColumn("Penerima");
        modelTable.addColumn("Kategori");
        modelTable.addColumn("Perihal");
        modelTable.addColumn("Status Pengiriman");
        modelTable.addColumn("Alamat Tujuan");

        this.baris.clear();
            this.status_notifikasi_surat.clear();
            int index = 0;
            while(hasil.next()){
                String no = hasil.getString("no_surat");
                String tanggal = hasil.getString("tanggal_surat");
                String penerima = hasil.getString("penerima");
                String kategori = hasil.getString("kategori");
                String perihal = hasil.getString("perihal");
                String status_pengiriman = hasil.getString("status_pengiriman");
                String alamat_tujuan = hasil.getString("alamat_tujuan");
                
                this.status_notifikasi_surat.add(hasil.getString("status_pengiriman"));
                this.baris.add(new Object[]{no, tanggal, penerima, kategori, perihal, status_pengiriman, alamat_tujuan});
                index++;
//                modelTable.addRow(new Object[]{no, tanggal, penerima, kategori, perihal,status_pengiriman, alamat_tujuan });
            }
            Collections.reverse(this.baris);
            Collections.reverse(this.status_notifikasi_surat);
            for (Object[] row : this.baris) {
                modelTable.addRow(row);
            }
        tableKeluar.setRowHeight(30);
        tableKeluar.setModel(modelTable);

    } catch (Exception ex) {
        Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_cariActionPerformed

    private void tableKeluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKeluarMouseEntered
        tableKeluar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_tableKeluarMouseEntered

    private void tableKeluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKeluarMouseExited
        tableKeluar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_tableKeluarMouseExited

    private void tableKeluarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKeluarMousePressed
                                                                                      
    int baris = tableKeluar.rowAtPoint(evt.getPoint());
    if (baris < 0) {
        return; // Clicked outside table rows
    }

    // Simpan data yang dipilih
    selectedNoSurat = (String) tableKeluar.getValueAt(baris, 0);
    selectedTanggalSurat = (String) tableKeluar.getValueAt(baris, 1);
    selectedPenerima = (String) tableKeluar.getValueAt(baris, 2);
    selectedKategori = (String) tableKeluar.getValueAt(baris, 3);
    selectedPerihal = (String) tableKeluar.getValueAt(baris, 4);
    selectedStatusPengiriman = (String) tableKeluar.getValueAt(baris, 5);
    selectedAlamatTujuan = (String) tableKeluar.getValueAt(baris, 6);

    if (evt.getClickCount() == 2) {
        // Ambil file surat dari database di thread terpisah
        new Thread(() -> {
            try {
                String[] data = new String[7];
                data[0] = selectedNoSurat;
                data[1] = selectedTanggalSurat;
                data[2] = selectedPenerima;
                data[3] = selectedKategori;
                data[4] = selectedPerihal;
                data[5] = selectedStatusPengiriman;
                data[6] = selectedAlamatTujuan;

                // Ambil file surat dari database
                String[] atributs = {"no_surat", "file_surat"};
                ResultSet hasil = query.setNamaTabel("surat_keluar").setAtribut(atributs).setWhereId("no_surat", data[0]).selectWhereIdDownload();
                if (hasil.next()) {
                    this.file = hasil.getBytes("file_surat");
                }

                // Update UI di thread utama
                SwingUtilities.invokeLater(() -> {
                kepsek.DashboardUtama.SubPanel.removeAll();
                kepsek.DashboardUtama.SubPanel.add(new kepsek.menuSuratKeluar.LihatSurat(data, file));
                kepsek.DashboardUtama.SubPanel.revalidate();
                kepsek.DashboardUtama.SubPanel.repaint();
                });
            } catch (Exception ex) {
                Logger.getLogger(TampilanSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }   
        
    }//GEN-LAST:event_tableKeluarMousePressed

    private void tableKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeluarKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume(); // Mencegah enter berpindah ke baris bawah

            int baris = tableKeluar.getSelectedRow();
            if (baris >= 0) {
                String[] data = new String[6];
                data[0] = (String)tableKeluar.getValueAt(baris, 0);
                data[1] = (String)tableKeluar.getValueAt(baris, 1);
                data[2] = (String)tableKeluar.getValueAt(baris, 2);
                data[3] = (String)tableKeluar.getValueAt(baris, 3);
                data[4] = (String)tableKeluar.getValueAt(baris, 4);
                data[5] = (String)tableKeluar.getValueAt(baris, 5);

                byte[] file = null;
                try {
                    String[] atributs = {"no_surat","file_surat"};
                    ResultSet hasil = query.setNamaTabel("surat_keluar")
                                           .setAtribut(atributs)
                                           .setWhereId("no_surat", data[0])
                                           .selectWhereIdDownload();
                    while (hasil.next()) {
                        file = hasil.getBytes("file_surat");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TampilanSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
                }

                kepsek.DashboardUtama.SubPanel.removeAll();
                kepsek.DashboardUtama.SubPanel.add(new kepsek.menuSuratKeluar.LihatSurat(data, file));
                kepsek.DashboardUtama.SubPanel.revalidate();
                kepsek.DashboardUtama.SubPanel.repaint();
            }
        }
    }//GEN-LAST:event_tableKeluarKeyPressed
                                 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTable tableKeluar;
    // End of variables declaration//GEN-END:variables
}
