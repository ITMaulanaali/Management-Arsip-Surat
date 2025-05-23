package admin.menuKelolaAkun;

import static admin.menuSuratKeluar.TampilanSuratKeluar.tabel_suratkeluar;
import static admin.menuSuratMasuk.TampilanSuratMasuk.tabel_suratMasuk;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lib.Query;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import login.Main;


public class TampilanKelolaAkun extends javax.swing.JPanel{

    Query query = new Query();
    String[] atributs = {"nama","username","jenis_role"};
    
    public TampilanKelolaAkun() {
        initComponents();
        admin.DashboardUtama.Judul.setText("Home");
        diKlikHilang();
        menampilkanUser();
//        buttonTable();
//        klikIcon();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon(getClass().getResource("/bahan/background/backgroundPanel800x483px.png"));
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

private void kustomTable() {
    // === KONFIGURASI DASAR TABEL & TRANSPARANSI ===
    TableUser.setOpaque(false);
    TableUser.setFocusable(true);
    TableUser.setRowSelectionAllowed(true);
    TableUser.setColumnSelectionAllowed(false);
    TableUser.setCellSelectionEnabled(false);
    TableUser.setShowGrid(false);
    TableUser.setShowHorizontalLines(false);
    TableUser.setShowVerticalLines(false);
    TableUser.setIntercellSpacing(new Dimension(0, 0));
    TableUser.setSelectionBackground(new Color(100, 10, 10));
    TableUser.setSelectionForeground(Color.WHITE);

    ((DefaultTableCellRenderer) TableUser.getDefaultRenderer(Object.class)).setOpaque(false);
    jScrollPane2.setOpaque(false);
    jScrollPane2.getViewport().setOpaque(false);
    jScrollPane2.setBorder(null);
    TableUser.setBorder(null);

    // === RENDERER UNTUK KOLOM TOMBOL ===
    TableUser.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (column == table.getColumnCount() - 1) {
                JButton buttonUpdate = new JButton();
                buttonUpdate.setPreferredSize(new Dimension(100, 30));
                buttonUpdate.setContentAreaFilled(true);
                buttonUpdate.setBorder(new EmptyBorder(3, 3, 3, 3));
                buttonUpdate.setFocusPainted(false);
                buttonUpdate.setOpaque(true);
                buttonUpdate.setBackground(Color.WHITE);
                buttonUpdate.setIcon(new ImageIcon(getClass().getResource("/bahan/globalIcon/edit-30px.png")));

                JPanel panel = new JPanel(new GridBagLayout());
                panel.add(buttonUpdate);
                panel.setOpaque(true);
                panel.setBackground(isSelected ? new Color(100, 10, 10)
                                               : (row % 2 == 0 ? new Color(255, 255, 255, 150)
                                                               : new Color(255, 255, 255, 180)));


                return panel;
            }

            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected) {
                c.setBackground(new Color(100, 10, 10));
                c.setForeground(Color.WHITE);
            } else {
                c.setBackground(new Color(255, 255, 255, 150));
                c.setForeground(Color.BLACK);
            }

            if (c instanceof JComponent jc) {
                jc.setBorder(null);
            }

            return c;
        }
    });

    // === EDITOR UNTUK TOMBOL EDIT SAJA ===
    class ButtonCellEditor extends DefaultCellEditor {
        private final JButton buttonUpdate = new JButton();
        private final JPanel panel = new JPanel(new GridBagLayout());

        public ButtonCellEditor() {
            super(new JCheckBox()); // dummy
            buttonUpdate.setPreferredSize(new Dimension(100, 30));
            buttonUpdate.setContentAreaFilled(true);
            buttonUpdate.setBorder(new EmptyBorder(3, 3, 3, 3));
            buttonUpdate.setFocusPainted(false);
            buttonUpdate.setOpaque(true);
            buttonUpdate.setBackground(Color.WHITE);
            buttonUpdate.setIcon(new ImageIcon(getClass().getResource("/bahan/globalIcon/edit-30px.png")));

            panel.setOpaque(true);
            panel.add(buttonUpdate);

            buttonUpdate.addActionListener(e -> {
                int row = TableUser.getSelectedRow();
                if (row >= 0) {
                String nama = (String) TableUser.getValueAt(row, 0);
                String username = (String) TableUser.getValueAt(row, 1);
                String peran = (String) TableUser.getValueAt(row, 2);

                // Kirim data ke form EditUser
                admin.DashboardUtama.SubPanel.removeAll();
                admin.DashboardUtama.SubPanel.add(new admin.menuKelolaAkun.EditUser(nama, username, peran));
                admin.DashboardUtama.SubPanel.revalidate();
                admin.DashboardUtama.SubPanel.repaint();
                }
            });

        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            panel.setBackground(new Color(100, 10, 10));
            return panel;
        }
    }

    // === PASANG EDITOR KE KOLOM TOMBOL (TERAKHIR) ===
    int kolomTombol = TableUser.getColumnCount() - 1;
    TableColumn tombolColumn = TableUser.getColumnModel().getColumn(kolomTombol);
    tombolColumn.setCellEditor(new ButtonCellEditor());
}

    void menampilkanUser(){
        try {
            ResultSet hasil = query.setNamaTabel("user").setAtribut(this.atributs).select();
            
            DefaultTableModel modelTable = new DefaultTableModel(); 
            modelTable.addColumn("Nama");
            modelTable.addColumn("Username");
            modelTable.addColumn("Peran");
            modelTable.addColumn("Aksi");
            
            while(hasil.next()){
                String nama = hasil.getString("nama");
                String username = hasil.getString("username");
                String peran = hasil.getString("jenis_role");
                modelTable.addRow(new Object[]{nama, username, peran, "Aksi"});
            }
            TableUser.setRowHeight(30);
            TableUser.setModel(modelTable);
            kustomTable();
            TableUser.getColumn("Aksi").setMaxWidth(100);
            TableUser.getColumn("Aksi").setMinWidth(100);
            TableUser.getColumn("Aksi").setPreferredWidth(100);
        }catch (Exception ex) {
            Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void diKlikHilang(){
        cari.addFocusListener(new java.awt.event.FocusAdapter() {
    @Override
    public void focusGained(java.awt.event.FocusEvent evt) {
        if (cari.getText().equals("Cari")) {
            cari.setText("");
        }
    }

    @Override
    public void focusLost(java.awt.event.FocusEvent evt) {
        if (cari.getText().trim().isEmpty()) {
            cari.setText("Cari");
        }
    }
});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableUser = new javax.swing.JTable();
        tambah1 = new javax.swing.JButton();
        pilih = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        cari.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        cari.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cari.setText("Cari");
        cari.setMinimumSize(new java.awt.Dimension(0, 40));
        cari.setPreferredSize(new java.awt.Dimension(600, 40));
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        TableUser.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        TableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Nama", "Peran", "Aksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableUser.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TableUser);

        tambah1.setBackground(new java.awt.Color(238, 238, 238));
        tambah1.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        tambah1.setText("Tambah");
        tambah1.setPreferredSize(new java.awt.Dimension(131, 40));
        tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah1ActionPerformed(evt);
            }
        });

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Username", "Nama", "Peran", "Aksi" }));
        pilih.setPreferredSize(new java.awt.Dimension(80, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(80, 80, 80)
                                .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah1ActionPerformed
        
    }//GEN-LAST:event_tambah1ActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
             
    String searchText = cari.getText();
    String selectedOption = (String) pilih.getSelectedItem();
    menampilkanSuratKeluar(searchText, selectedOption);
}                                    

void menampilkanSuratKeluar(String searchText, String selectedOption) {
    try {

        String queryCondition = "";
        switch (selectedOption) {
            case "Username":
                queryCondition = "username";
                break;
            case "Nama":
                queryCondition = "nama";
                break;
            case "Peran":
                queryCondition = "jenis_role";
                break;
            default:
                break;
        }
        // Lakukan query dengan kondisi yang telah dibuat
        ResultSet hasil = query.setNamaTabel("user").setAtribut(this.atributs).setWhereId(queryCondition, searchText).selectWhereLike();

        DefaultTableModel modelTable = new DefaultTableModel(); 
        modelTable.addColumn("Nama");
        modelTable.addColumn("Username");
        modelTable.addColumn("Peran");
        modelTable.addColumn("Aksi");

        while(hasil.next()){
                String nama = hasil.getString("nama");
                String username = hasil.getString("username");
                String peran = hasil.getString("jenis_role");
                modelTable.addRow(new Object[]{nama, username, peran, "Aksi"});
            }
        TableUser.setRowHeight(30);
        TableUser.setModel(modelTable);
        kustomTable();
        TableUser.getColumn("Aksi").setMaxWidth(100);
        TableUser.getColumn("Aksi").setMinWidth(100);
        TableUser.getColumn("Aksi").setPreferredWidth(100);
    } catch (Exception ex) {
        Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
    }     
        
    }//GEN-LAST:event_cariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableUser;
    private javax.swing.JTextField cari;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JButton tambah1;
    // End of variables declaration//GEN-END:variables
}