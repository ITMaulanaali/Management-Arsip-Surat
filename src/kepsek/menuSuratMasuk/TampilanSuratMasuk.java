/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kepsek.menuSuratMasuk;

import admin.menuSuratMasuk.*;
import admin.menuSuratKeluar.*;
import admin.menuSuratMasuk.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.TableColumn;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.awt.Desktop;
/**
 *
 * @author lan
 */
public class TampilanSuratMasuk extends javax.swing.JPanel {

    private Connection conn;
    private DefaultTableModel tableModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public TampilanSuratMasuk() {
        initComponents();
        setupSearchField();
        setupTable();
        loadDummyData();
        
    }

        private void setupSearchField() {
        // Set placeholder text
        jTextField1.setText("Cari");
        jTextField1.setForeground(Color.GRAY);
        
        // Add focus listener to handle placeholder behavior
        jTextField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField1.getText().equals("Cari")) {
                    jTextField1.setText("");
                    jTextField1.setForeground(Color.BLACK);
                }
            }
    @Override
            public void focusLost(FocusEvent e) {
                if (jTextField1.getText().isEmpty()) {
                    jTextField1.setText("Cari");
                    jTextField1.setForeground(Color.GRAY);
                }
            }
        });
        
        // Add action listener for search
        jTextField1.addActionListener(e -> performSearch());
    }
        
           private void setupTable() {
        // Create a custom table model
        tableModel = new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "No.Surat", "Perihal", "Kategori", "Tanggal Diterima", "File", "Tandai"
            }
        ) {
            // Make checkbox column editable
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; // Only the "Tandai" column is editable
            }
        };
        
          jTable1.setModel(tableModel);
        
        // Set up table appearance
        jTable1.setRowHeight(40);
        jTable1.setFont(new Font("Arial", Font.PLAIN, 12));
        jTable1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.LIGHT_GRAY);
        
        // Adjust column widths
        TableColumn noColumn = jTable1.getColumnModel().getColumn(0);
        noColumn.setPreferredWidth(50);
        
        TableColumn perihalColumn = jTable1.getColumnModel().getColumn(1);
        perihalColumn.setPreferredWidth(200);
        
        TableColumn kategoriColumn = jTable1.getColumnModel().getColumn(2);
        kategoriColumn.setPreferredWidth(100);
        
        TableColumn tanggalColumn = jTable1.getColumnModel().getColumn(3);
        tanggalColumn.setPreferredWidth(120);
        
        TableColumn fileColumn = jTable1.getColumnModel().getColumn(4);
        fileColumn.setPreferredWidth(100);
        
        TableColumn tandaiColumn = jTable1.getColumnModel().getColumn(5);
        tandaiColumn.setPreferredWidth(60);
        
        // Add mouse listener to handle file opening
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTable1.rowAtPoint(e.getPoint());
                int col = jTable1.columnAtPoint(e.getPoint());
                
                if (col == 4 && row >= 0) { // File column
                    String fileName = (String) jTable1.getValueAt(row, col);
                    openFile(fileName);
                }
            }
        });
    }
           
 private void loadDummyData() {
        // Clear existing table data
        tableModel.setRowCount(0);
        
        // Add dummy data
        addRow("1", "Undangan Rapat Dinas", "Penting", "12-04-2025", "undangan_rapat.pdf", false);
        addRow("2", "Permohonan Bantuan Dana", "Umum", "10-04-2025", "permohonan_dana.pdf", false);
        addRow("3", "Surat Keputusan Kepala Sekolah", "Rahasia", "05-04-2025", "sk_kepala_sekolah.pdf", false);
        addRow("4", "Undangan Pertemuan Orang Tua", "Segera", "03-04-2025", "undangan_ortu.pdf", false);
        addRow("5", "Laporan Keuangan Bulanan", "Umum", "01-04-2025", "laporan_keuangan.pdf", false);
    }
    
    private void addRow(String no, String perihal, String kategori, String tanggal, String filePath, boolean tandai) {
        Object[] row = {no, perihal, kategori, tanggal, filePath, tandai};
        tableModel.addRow(row);
    }
    
    private void performSearch() {
        String searchText = jTextField1.getText().trim();
        if (searchText.equals("Cari") || searchText.isEmpty()) {
            loadDummyData(); // Reset to show all data
            return;
        }
        
        // Create a filtered table model
        tableModel.setRowCount(0);
        String searchColumn = (String) jComboBox1.getSelectedItem();
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
            case "Tanggal Diterima":
                columnIndex = 3;
                break;
            case "File":
                columnIndex = 4;
                break;
            default:
                columnIndex = 1; // Default to "Perihal"
                break;
        }
        
        // Load dummy data for filtered search
        if (columnIndex == 1) { // Perihal
            if ("Undangan".toLowerCase().contains(searchText.toLowerCase())) {
                addRow("1", "Undangan Rapat Dinas", "Penting", "12-04-2025", "undangan_rapat.pdf", false);
                addRow("4", "Undangan Pertemuan Orang Tua", "Segera", "03-04-2025", "undangan_ortu.pdf", false);
            }
            if ("Permohonan".toLowerCase().contains(searchText.toLowerCase())) {
                addRow("2", "Permohonan Bantuan Dana", "Umum", "10-04-2025", "permohonan_dana.pdf", false);
            }
            if ("Surat Keputusan".toLowerCase().contains(searchText.toLowerCase())) {
                addRow("3", "Surat Keputusan Kepala Sekolah", "Rahasia", "05-04-2025", "sk_kepala_sekolah.pdf", false);
            }
            if ("Laporan".toLowerCase().contains(searchText.toLowerCase())) {
                addRow("5", "Laporan Keuangan Bulanan", "Umum", "01-04-2025", "laporan_keuangan.pdf", false);
            }
        } else if (columnIndex == 2) { // Kategori
            if ("Penting".toLowerCase().contains(searchText.toLowerCase())) {
                addRow("1", "Undangan Rapat Dinas", "Penting", "12-04-2025", "undangan_rapat.pdf", false);
            }
            if ("Umum".toLowerCase().contains(searchText.toLowerCase())) {
                addRow("2", "Permohonan Bantuan Dana", "Umum", "10-04-2025", "permohonan_dana.pdf", false);
                addRow("5", "Laporan Keuangan Bulanan", "Umum", "01-04-2025", "laporan_keuangan.pdf", false);
            }
            if ("Rahasia".toLowerCase().contains(searchText.toLowerCase())) {
                addRow("3", "Surat Keputusan Kepala Sekolah", "Rahasia", "05-04-2025", "sk_kepala_sekolah.pdf", false);
            }
            if ("Segera".toLowerCase().contains(searchText.toLowerCase())) {
                addRow("4", "Undangan Pertemuan Orang Tua", "Segera", "03-04-2025", "undangan_ortu.pdf", false);
            }
        } else if (columnIndex == 3) { // Tanggal
            if ("12-04-2025".contains(searchText)) {
                addRow("1", "Undangan Rapat Dinas", "Penting", "12-04-2025", "undangan_rapat.pdf", false);
            }
            if ("10-04-2025".contains(searchText)) {
                addRow("2", "Permohonan Bantuan Dana", "Umum", "10-04-2025", "permohonan_dana.pdf", false);
            }
            if ("05-04-2025".contains(searchText)) {
                addRow("3", "Surat Keputusan Kepala Sekolah", "Rahasia", "05-04-2025", "sk_kepala_sekolah.pdf", false);
            }
            if ("03-04-2025".contains(searchText)) {
                addRow("4", "Undangan Pertemuan Orang Tua", "Segera", "03-04-2025", "undangan_ortu.pdf", false);
            }
            if ("01-04-2025".contains(searchText)) {
                addRow("5", "Laporan Keuangan Bulanan", "Umum", "01-04-2025", "laporan_keuangan.pdf", false);
            }
            // Also handle searching by month or year
            if ("04-2025".contains(searchText)) {
                loadDummyData(); // All entries are from April 2025
            }
        }
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


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("Cari");
        jTextField1.setMinimumSize(new java.awt.Dimension(0, 40));
        jTextField1.setPreferredSize(new java.awt.Dimension(600, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Perihal", "Kategori", "Tanggal Diterima", "File" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(80, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Perihal", "Kategori", "Tanggal Diterima", "File", "Tandai"
            }
        ));
        jTable1.setMinimumSize(new java.awt.Dimension(1200, 80));
        jTable1.setPreferredSize(new java.awt.Dimension(1200, 80));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGap(98, 98, 98)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
