package admin.menuKelolaAkun;

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
        menampilkanUser();
        kustomTable();
        TableUser.getColumn("Aksi").setMaxWidth(100);
        TableUser.getColumn("Aksi").setMinWidth(100);
        TableUser.getColumn("Aksi").setPreferredWidth(100);
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

                buttonUpdate.addActionListener(e -> {
                        admin.DashboardUtama.SubPanel.removeAll();
                        admin.DashboardUtama.SubPanel.add(new admin.menuKelolaAkun.EditUser());
                        admin.DashboardUtama.SubPanel.revalidate();
                        admin.DashboardUtama.SubPanel.repaint();
                });

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
                    admin.DashboardUtama.SubPanel.removeAll();
                    admin.DashboardUtama.SubPanel.add(new admin.menuKelolaAkun.EditUser());
                    admin.DashboardUtama.SubPanel.revalidate();
                    admin.DashboardUtama.SubPanel.repaint();
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
            
        }catch (Exception ex) {
            Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableUser = new javax.swing.JTable();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("Cari");
        jTextField1.setMinimumSize(new java.awt.Dimension(0, 40));
        jTextField1.setPreferredSize(new java.awt.Dimension(600, 40));

        tambah.setBackground(new java.awt.Color(238, 238, 238));
        tambah.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tambah.setText("Tambah");
        tambah.setPreferredSize(new java.awt.Dimension(80, 40));
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        TableUser.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(83, 83, 83)
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addGap(93, 93, 93))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuKelolaAkun.TambahUser());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
        
    }//GEN-LAST:event_tambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableUser;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}