/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kepsek.menuSuratMasuk;

import admin.menuSuratMasuk.*;
import admin.menuSuratKeluar.*;
import admin.menuSuratMasuk.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lib.Query;
/**
 *
 * @author galang
 */
public class TampilanSuratMasuk extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Query query = new Query();
    
    public TampilanSuratMasuk() {
        initComponents();
        setupSearchField();
        setupTable();
    }
    
    void TampilakanTable(){
    String [] kolom_database = {"no_surat","tanggal_surat","pengirim","kategori","perihal","file_surat","status_notifikasi"};
    ResultSet hasil = query.setNamaTabel()
            
            
            
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
    }
        
    private void setupTable() {
        // Create a custom table model with the correct column order from UI definition
        tableModel = new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "No.Surat", "Tanggal Surat", "Pengirim", "Kategori", "Perihal", "File Surat", "Tandai"
            }
        ) {
            // Define column types correctly with all 7 columns
            Class<?>[] types = new Class<?>[] {
                String.class, String.class, String.class, String.class,
                String.class, String.class, Boolean.class
            };
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6; // Only the "Tandai" column is editable
            }
        };
        
        jTable1.setModel(tableModel);
        
        // Set up table appearance
        jTable1.setRowHeight(40);
        jTable1.setFont(new Font("Arial", Font.PLAIN, 12));
        jTable1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.LIGHT_GRAY);
        
        // Adjust column widths if we have all the expected columns
        if (jTable1.getColumnCount() >= 7) {
            TableColumn noColumn = jTable1.getColumnModel().getColumn(0);
            noColumn.setPreferredWidth(80);
            
            TableColumn tanggalColumn = jTable1.getColumnModel().getColumn(1);
            tanggalColumn.setPreferredWidth(100);
            
            TableColumn pengirimColumn = jTable1.getColumnModel().getColumn(2);
            pengirimColumn.setPreferredWidth(120);
            
            TableColumn kategoriColumn = jTable1.getColumnModel().getColumn(3);
            kategoriColumn.setPreferredWidth(100);
            
            TableColumn perihalColumn = jTable1.getColumnModel().getColumn(4);
            perihalColumn.setPreferredWidth(200);
            
            TableColumn fileColumn = jTable1.getColumnModel().getColumn(5);
            fileColumn.setPreferredWidth(100);
            
            TableColumn tandaiColumn = jTable1.getColumnModel().getColumn(6);
            tandaiColumn.setPreferredWidth(60);
        }
        
        // Add mouse listener to handle file opening
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTable1.rowAtPoint(e.getPoint());
                int col = jTable1.columnAtPoint(e.getPoint());
                
                if (col == 5 && row >= 0) { // File Surat column (index 5)
                    String fileName = (String) jTable1.getValueAt(row, col);
                    openFile(fileName);
                }
            }
        });
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
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
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

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.rowAtPoint(evt.getPoint());
    int col = jTable1.columnAtPoint(evt.getPoint());

    // Ensure a valid row and column are clicked
    if (row >= 0 && col >= 0) {
        // Handle click on "File Surat" column (index 5)
        if (col == 5) {
            String fileName = (String) jTable1.getValueAt(row, col);
            openFile(fileName);
        }
        // Handle click on "Tandai" column (index 6)
        else if (col == 6) {
            Boolean currentValue = (Boolean) jTable1.getValueAt(row, col);
            // Toggle the checkbox value
            jTable1.setValueAt(!currentValue, row, col);
        }
    }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
