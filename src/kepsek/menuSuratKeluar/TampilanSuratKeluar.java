/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kepsek.menuSuratKeluar;

import admin.menuKelolaAkun.TampilanKelolaAkun;
import kepsek.menuSuratMasuk.*;
import admin.menuSuratMasuk.*;
import admin.menuSuratKeluar.*;
import admin.menuSuratMasuk.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author lan
 */
public class TampilanSuratKeluar extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public TampilanSuratKeluar() {
        initComponents();
        setupSearchField();
        setupTable();
        loadDummyData();
    }

     private void setupSearchField() {
        // Set placeholder text
        cari.setText("Cari");
        cari.setForeground(Color.GRAY);
        
        // Add focus listener to handle placeholder behavior
        cari.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cari.getText().equals("Cari")) {
                    cari.setText("");
                    cari.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (cari.getText().isEmpty()) {
                    cari.setText("Cari");
                    cari.setForeground(Color.GRAY);
                }
            }
        });
        
        // Add action listener for search
        cari.addActionListener(e -> performSearch());
    }
        
    private void setupTable() {
        // Create a custom table model with correct column names
        tableModel = new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "No.Surat", "Perihal", "Kategori", "Alamat", "Penerima", "Tanggal Dikirim", "Status Pengiriman", "File"
            }
        ) {
            // Make columns have appropriate types
            Class<?>[] types = new Class<?>[] {
                String.class, String.class, String.class, String.class, String.class, 
                String.class, String.class, String.class
            };
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // None editable for now
            }
        };
        
        tabelsuratkeluar.setModel(tableModel);
        
        // Set up table appearance
        tabelsuratkeluar.setRowHeight(40);
        tabelsuratkeluar.setFont(new Font("Arial", Font.PLAIN, 12));
        tabelsuratkeluar.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tabelsuratkeluar.setShowGrid(true);
        tabelsuratkeluar.setGridColor(Color.LIGHT_GRAY);
        
        // Adjust column widths
        if (tabelsuratkeluar.getColumnCount() >= 8) {
            TableColumn noColumn = tabelsuratkeluar.getColumnModel().getColumn(0);
            noColumn.setPreferredWidth(100);
            
            TableColumn perihalColumn = tabelsuratkeluar.getColumnModel().getColumn(1);
            perihalColumn.setPreferredWidth(200);
            
            TableColumn kategoriColumn = tabelsuratkeluar.getColumnModel().getColumn(2);
            kategoriColumn.setPreferredWidth(80);
            
            TableColumn alamatColumn = tabelsuratkeluar.getColumnModel().getColumn(3);
            alamatColumn.setPreferredWidth(120);
            
            TableColumn penerimaColumn = tabelsuratkeluar.getColumnModel().getColumn(4);
            penerimaColumn.setPreferredWidth(120);
            
            TableColumn tanggalColumn = tabelsuratkeluar.getColumnModel().getColumn(5);
            tanggalColumn.setPreferredWidth(100);
            
            TableColumn statusColumn = tabelsuratkeluar.getColumnModel().getColumn(6);
            statusColumn.setPreferredWidth(120);
            
            TableColumn fileColumn = tabelsuratkeluar.getColumnModel().getColumn(7);
            fileColumn.setPreferredWidth(100);
        }
        
        // Add mouse listener to handle file opening
        tabelsuratkeluar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabelsuratkeluar.rowAtPoint(e.getPoint());
                int col = tabelsuratkeluar.columnAtPoint(e.getPoint());
                
                if (col == 7 && row >= 0) { // File column
                    String fileName = (String) tabelsuratkeluar.getValueAt(row, col);
                    openFile(fileName);
                }
            }
        });
    }
           
    private void loadDummyData() {
        // Clear existing table data
        tableModel.setRowCount(0);
        
        // Add dummy data with all 8 columns
        //addRow("01.001.SMK.04.2025", "Undangan Rapat Dinas", "Penting", "Dinas Pendidikan", 
             // "Kepala Dinas", "12-04-2025", "Terkirim", "undangan_rapat.pdf");//
        
       // addRow("02.002.SMK.04.2025", "Permohonan Bantuan Dana", "Umum", "Bank Indonesia", 
             // "Manager CSR", "10-04-2025", "Diproses", "permohonan_dana.pdf");
        
        //addRow("03.003.SMK.04.2025", "Surat Keputusan Kepala Sekolah", "Rahasia", "Internal", 
              //"Guru dan Staff", "05-04-2025", "Terkirim", "sk_kepala_sekolah.pdf");
        
        //addRow("04.004.SMK.04.2025", "Undangan Pertemuan Orang Tua", "Segera", "Rumah Siswa", 
              //"Orang Tua Siswa", "03-04-2025", "Terkirim", "undangan_ortu.pdf");
        
       // addRow("05.005.SMK.04.2025", "Laporan Keuangan Bulanan", "Umum", "Yayasan Pendidikan", 
              //"Bendahara Yayasan", "01-04-2025", "Terkirim", "laporan_keuangan.pdf");//
    }
    
    private void addRow(String no, String perihal, String kategori, String alamat, 
                       String penerima, String tanggal, String status, String filePath) {
        Object[] row = {no, perihal, kategori, alamat, penerima, tanggal, status, filePath};
        tableModel.addRow(row);
    }
    
    private void performSearch() {
        String searchText = cari.getText().trim();
        if (searchText.equals("Cari") || searchText.isEmpty()) {
            loadDummyData(); // Reset to show all data
            return;
        }
        
        // Create a filtered table model
        tableModel.setRowCount(0);
        String searchColumn = (String) pilih.getSelectedItem();
        int columnIndex;
        
        // Map UI column names to column indices
        switch (searchColumn) {
            case "No":
                columnIndex = 0;
                break;
            case "Perihal":
                columnIndex = 1;
                break;
            case "Kategori":
                columnIndex = 2;
                break;
            case "Alamat":
                columnIndex = 3;
                break;
            case "Penerima":
                columnIndex = 4;
                break;
            case "Tanggal Dikirim":
                columnIndex = 5;
                break;
            case "Status Pengiriman":
                columnIndex = 6;
                break;
            case "File":
                columnIndex = 7;
                break;
            default:
                columnIndex = 1; // Default to "Perihal"
                break;
        }
        
        // Load dummy data based on search
      
    }
    

    
    private void openFile(String filePath) {
        try {
            if (filePath == null || filePath.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "File path is empty or not available", 
                    "File Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // In a real application, we would open the file
            // Since this is a mock-up, we just show a message
            JOptionPane.showMessageDialog(this, 
                "Opening file: " + filePath, 
                "File Operation", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            System.err.println("Error opening file: " + e.getMessage());
            JOptionPane.showMessageDialog(this, 
                "Error opening file: " + e.getMessage(), 
                "File Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cari = new javax.swing.JTextField();
        pilih = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelsuratkeluar = new javax.swing.JTable();

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

        tabelsuratkeluar.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelsuratkeluar.setMinimumSize(new java.awt.Dimension(1200, 80));
        tabelsuratkeluar.setPreferredSize(new java.awt.Dimension(1200, 80));
        jScrollPane1.setViewportView(tabelsuratkeluar);

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

    }//GEN-LAST:event_cariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTable tabelsuratkeluar;
    // End of variables declaration//GEN-END:variables
}
