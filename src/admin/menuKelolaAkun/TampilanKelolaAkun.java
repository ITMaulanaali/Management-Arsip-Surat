package admin.menuKelolaAkun;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JTextField;


public class TampilanKelolaAkun extends javax.swing.JPanel{

    Query query = new Query();
    String[] atributs = {"nama","username","jenis_role"};
    
    public TampilanKelolaAkun() {
        initComponents();
        menampilkanUser();
        TableUser.getColumn("Aksi").setCellRenderer(new CustomDesainTable());
        TableUser.getColumn("Aksi").setCellEditor(new CustomEditTable());
        TableUser.getColumn("Aksi").setMaxWidth(100);
        TableUser.getColumn("Aksi").setMinWidth(100);
        TableUser.getColumn("Aksi").setPreferredWidth(100);
//        buttonTable();
//        klikIcon();
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
    
    //versi label biasa
//    void buttonTable(){
//        TableUser.getColumn("Aksi").setCellRenderer((table1, value, isSelected, hasFocus, row, column) -> {
//                JLabel label = new JLabel();
//
//                label.setHorizontalAlignment(SwingConstants.CENTER);
//                label.setOpaque(true);
//                label.setBackground(isSelected ? table1.getSelectionBackground() : Color.WHITE);
//                label.setToolTipText("Klik untuk hapus");
//
//                Icon icon = new ImageIcon(getClass().getResource("/bahan/globalIcon/cari40px.png"));
//                label.setIcon(icon);
//                return label;
//            });
//    }
    
    
//    void buttonTable() {
//    Icon icon = new ImageIcon(getClass().getResource("/bahan/globalIcon/cari40px.png"));
//
//    // Renderer untuk menampilkan tombol
//    TableUser.getColumn("Aksi").setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
//        JButton button = new JButton(icon);
//        button.setOpaque(true);
//        button.setContentAreaFilled(true); // Isi area tombol agar lebih terlihat
//        button.setBackground(Color.WHITE); // Background normal
//        button.setBorderPainted(false);  // Menghilangkan border pada button
//
//        // Mouse listener untuk efek hover
//        button.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                button.setBackground(Color.RED); // Mengubah warna background menjadi merah saat hover
//            }
//
//            @Override
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                button.setBackground(Color.WHITE); // Kembalikan ke latar belakang normal saat mouse keluar
//            }
//        });
//
//        button.setHorizontalAlignment(SwingConstants.CENTER); // Set alignment ke tengah
//        button.setToolTipText("Klik untuk hapus"); // Tooltip saat hover
//
//        return button;
//    });
//
//    // Editor untuk menangani klik tombol
//    TableUser.getColumn("Aksi").setCellEditor(new DefaultCellEditor(new JCheckBox()) {
//        private final JButton button = new JButton(icon);
//        private int currentRow;
//
//        {
//            button.setOpaque(true);
//            button.setBorderPainted(false);  // Menghilangkan border pada button
//            button.setContentAreaFilled(true); // Isi area tombol agar lebih terlihat
//            button.setBackground(Color.WHITE); // Background normal
//            button.setHorizontalAlignment(SwingConstants.CENTER);
//
//            button.addActionListener(e -> {
//                System.out.println("Hallo dari baris ke-" + currentRow);
//
//                int confirm = JOptionPane.showConfirmDialog(button, "Hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
//                if (confirm == JOptionPane.YES_OPTION) {
//                    ((DefaultTableModel) TableUser.getModel()).removeRow(currentRow);
//                }
//
//                fireEditingStopped(); // Wajib agar cell editor selesai
//            });
//        }
//
//        @Override
//        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
//                                                     int row, int column) {
//            currentRow = row;
//            return button;
//        }
//
//        @Override
//        public Object getCellEditorValue() {
//            return null;
//        }
//    });
//}




    
//    void klikIcon(){
//        TableUser.addMouseListener(new java.awt.event.MouseAdapter() {
//    @Override
//    public void mouseClicked(java.awt.event.MouseEvent evt) {
//        int row = TableUser.rowAtPoint(evt.getPoint());
//        int column = TableUser.columnAtPoint(evt.getPoint());
//
//        // Pastikan klik terjadi di dalam tabel
//        if (row >= 0 && column >= 0) {
//            // Cek apakah kolom yang diklik adalah kolom "Aksi"
//            int aksiColumnIndex = TableUser.getColumnModel().getColumnIndex("Aksi");
//            if (column == aksiColumnIndex) {
//                System.out.println("Hallo dari baris ke-" + row);
//            }
//        }
//    }
//});
//
//    }
    
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(30, Short.MAX_VALUE))
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

class CustomDesainTable extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        // Komponen default untuk warna background
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Buat tombol hanya untuk tampilan
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(100,30));
        button.setContentAreaFilled(true);
        button.setBorder(new EmptyBorder(3, 3, 3, 3));
        button.setFocusPainted(false);
        button.setIcon(new ImageIcon(getClass().getResource("/bahan/globalIcon/kembali-30px.png"))); // ganti dengan path ikon kamu
        button.setEnabled(true); // karena ini hanya renderer

        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(button);

        if (!isSelected && row % 2 == 0) {
            panel.setBackground(Color.WHITE);
        } else {
            panel.setBackground(comp.getBackground());
        }

        return panel;
    }
}

class CustomEditTable extends DefaultCellEditor {
    private final JButton button;
    private final JPanel panel;
    private JTable currentTable;
    private int currentRow;

    public CustomEditTable() {
        super(new JCheckBox());
        Query query = new Query();

        button = new JButton();
        button.setPreferredSize(new Dimension(100,30));
        button.setContentAreaFilled(true);
        button.setBorder(new EmptyBorder(3, 3, 3, 3));
        button.setFocusPainted(false);
        button.setIcon(new ImageIcon(getClass().getResource("/bahan/globalIcon/kembali-30px.png"))); // ganti dengan path ikon kamu

        panel = new JPanel(new GridBagLayout());
        panel.add(button);

        // Aksi klik tombol
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(admin.DashboardUtama.SubPanel,"Lihat password?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    DefaultTableModel model = (DefaultTableModel) currentTable.getModel();
                    if (currentRow >= 0 && currentRow < model.getRowCount()) {
                        try{
                            String[] atributs = {"username","password",};
                            ResultSet hasil = query.setNamaTabel("user").setAtribut(atributs).setWhereId("username", (String) currentTable.getValueAt(currentRow, 1)).selectWhereIdDownload();
                            String password = "";
                            while(hasil.next()){
                                password = hasil.getString("password");
                            }
//                            model.removeRow(currentRow);
                            JOptionPane.showMessageDialog(admin.DashboardUtama.SubPanel, "password anda: "+password);
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(admin.DashboardUtama.SubPanel, "Gagal dihapus!");
                            System.out.println(ex);
                        }
                    }
                }

                fireEditingStopped(); // Wajib untuk menyelesaikan mode editing
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        currentTable = table;
        currentRow = row;

        panel.setBackground(table.getSelectionBackground());
        return panel;
    }
}