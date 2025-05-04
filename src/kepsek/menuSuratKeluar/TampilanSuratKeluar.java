/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kepsek.menuSuratKeluar;

import admin.menuKelolaAkun.TampilanKelolaAkun;
import kepsek.menuSuratMasuk.*;
import admin.menuSuratMasuk.*;
import admin.menuSuratKeluar.*;
import java.io.File;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lib.Query;

/**
 *
 * @author lan
 */
public class TampilanSuratKeluar extends javax.swing.JPanel {

private String selectedNoSurat;
private String selectedTanggalSurat;
private String selectedPenerima;
private String selectedKategori;
private String selectedPerihal;
private String selectedStatusPengiriman;
private String selectedAlamatTujuan;
private String selectedFileSurat;
private byte[] file;
    
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
        menampilkanSuratKeluar();
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
            
            
            while(hasil.next()){
                String no = hasil.getString("no_surat");
                String tanggal = hasil.getString("tanggal_surat");
                String penerima = hasil.getString("penerima");
                String kategori = hasil.getString("kategori");
                String perihal = hasil.getString("perihal");
                String status_pengiriman = hasil.getString("status_pengiriman");
                String alamat_tujuan = hasil.getString("alamat_tujuan");
                
                modelTable.addRow(new Object[]{no, tanggal, penerima, kategori, perihal,status_pengiriman, alamat_tujuan });
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
        jScrollPane1 = new javax.swing.JScrollPane();
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

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Perihal", "Kategori", "Alamat", "Penerima", "Tanggal Dikirim", "Status Pengiriman", "File" }));
        pilih.setPreferredSize(new java.awt.Dimension(80, 40));

        tableKeluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Perihal", "Kategori", "Alamat", "Penerima", "Tanggal Dikirim", "Status Pengiriman", "File"
            }
        ));
        tableKeluar.setMinimumSize(new java.awt.Dimension(1200, 80));
        tableKeluar.setPreferredSize(new java.awt.Dimension(1200, 80));
        tableKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableKeluarMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableKeluar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGap(98, 98, 98)
                        .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addGap(64, 64, 64))
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

        while (hasil.next()) {
            String no = hasil.getString("no_surat");
            String tanggal = hasil.getString("tanggal_surat");
            String pengirim = hasil.getString("penerima");
            String kategori = hasil.getString("kategori");
            String perihal = hasil.getString("perihal");
            String status_pengiriman = hasil.getString("status_pengiriman");
            String alamat_tujuan = hasil.getString("alamat_tujuan");

            modelTable.addRow(new Object[]{no, tanggal, pengirim, kategori, perihal, status_pengiriman, alamat_tujuan });
        }
        tableKeluar.setRowHeight(30);
        tableKeluar.setModel(modelTable);

    } catch (Exception ex) {
        Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_cariActionPerformed

    private void tableKeluarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKeluarMousePressed
         int baris = tableKeluar.rowAtPoint(evt.getPoint());
    if (baris < 0) {
        return; // Clicked outside table rows
    }

    if (evt.getClickCount() == 1) {
        // Single click: set selection on the clicked row
        tableKeluar.setRowSelectionInterval(baris, baris);
        
        // Logika untuk klik satu kali
        String noSurat = (String) tableKeluar.getValueAt(baris, 0);
        // Panggil metode atau lakukan aksi yang diinginkan
        System.out.println("Satu kali klik pada No Surat: " + noSurat);
        // Misalnya, Anda bisa memanggil metode lain di sini
        // ppilih(noSurat); // Contoh pemanggilan metode

    } else if (evt.getClickCount() == 2) {
        // Double click: open LihatSurat panel with selected row details
        String[] data = new String[7];

        data[0] = (String) tableKeluar.getValueAt(baris, 0);
        data[1] = (String) tableKeluar.getValueAt(baris, 1);
        data[2] = (String) tableKeluar.getValueAt(baris, 2);
        data[3] = (String) tableKeluar.getValueAt(baris, 3);
        data[4] = (String) tableKeluar.getValueAt(baris, 4);
        data[5] = (String) tableKeluar.getValueAt(baris, 5);
        data[6] = (String) tableKeluar.getValueAt(baris, 6); // Pastikan ini adalah kolom yang benar

        try {
            String[] atributs = {"no_surat", "file_surat"};
            ResultSet hasil = query.setNamaTabel("surat_keluar").setAtribut(atributs).setWhereId("no_surat", data[0]).selectWhereIdDownload();
            while (hasil.next()) {
                this.file = hasil.getBytes("file_surat");
            }
        } catch (Exception ex) {
            Logger.getLogger(TampilanSuratKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }

        kepsek.DashboardUtama.SubPanel.removeAll();
        kepsek.DashboardUtama.SubPanel.add(new kepsek.menuSuratKeluar.LihatSurat(data, file));
        kepsek.DashboardUtama.SubPanel.revalidate();
        kepsek.DashboardUtama.SubPanel.repaint(); 
    }
    }//GEN-LAST:event_tableKeluarMousePressed
                                 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTable tableKeluar;
    // End of variables declaration//GEN-END:variables
}
