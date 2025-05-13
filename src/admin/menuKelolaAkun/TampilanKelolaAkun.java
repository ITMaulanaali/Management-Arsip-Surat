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
    TableUser.setFocusable(true); // AGAR BISA DISELEKSI DENGAN KEYBOARD
    TableUser.setRowSelectionAllowed(true); // Mengizinkan seleksi baris
    TableUser.setColumnSelectionAllowed(false); // Tidak ada seleksi kolom
    TableUser.setCellSelectionEnabled(false); // Tidak ada seleksi sel
    TableUser.setShowGrid(false); // Hilangkan grid di dalam tabel
    TableUser.setShowHorizontalLines(false); // Hilangkan garis horizontal
    TableUser.setShowVerticalLines(false); // Hilangkan garis vertikal
    TableUser.setIntercellSpacing(new Dimension(0, 0)); // Tidak ada jarak antar sel
    TableUser.setSelectionBackground(new Color(100, 10, 10)); // Warna seleksi baris
    TableUser.setSelectionForeground(Color.WHITE); // Warna font seleksi

    ((DefaultTableCellRenderer) TableUser.getDefaultRenderer(Object.class)).setOpaque(false);
    jScrollPane2.setOpaque(false);
    jScrollPane2.getViewport().setOpaque(false);
    jScrollPane2.setBorder(null);
    TableUser.setBorder(null);

    // === RENDERER UNTUK TRANSPARANSI DAN TOMBOL ===
    TableUser.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (column == table.getColumnCount() - 1) {
                // TOMBOL (KOLUM TERAKHIR) untuk "Lihat"
                JButton buttonLihat = new JButton();
                buttonLihat.setPreferredSize(new Dimension(100, 30));
                buttonLihat.setContentAreaFilled(true);
                buttonLihat.setBorder(new EmptyBorder(3, 3, 3, 3));
                buttonLihat.setFocusPainted(false);
                buttonLihat.setOpaque(true);
                buttonLihat.setBackground(Color.WHITE);
                buttonLihat.setIcon(new ImageIcon(getClass().getResource("/bahan/globalIcon/kembali-30px.png")));

                JButton buttonUpdate = new JButton();
                buttonUpdate.setPreferredSize(new Dimension(100, 30));
                buttonUpdate.setContentAreaFilled(true);
                buttonUpdate.setBorder(new EmptyBorder(3, 3, 3, 3));
                buttonUpdate.setFocusPainted(false);
                buttonUpdate.setOpaque(true);
                buttonUpdate.setBackground(Color.WHITE);
                buttonUpdate.setIcon(new ImageIcon(getClass().getResource("/bahan/globalIcon/edit-30px.png"))); // Ganti dengan ikon Update

                JPanel panel = new JPanel(new GridBagLayout());
                panel.add(buttonLihat);
                panel.add(buttonUpdate); // Menambahkan tombol Update

                panel.setOpaque(true);
                // Menetapkan warna latar belakang berdasarkan status seleksi baris
                panel.setBackground(isSelected ? new Color(100, 10, 10)
                                               : (row % 2 == 0 ? new Color(255, 255, 255, 150)
                                                               : new Color(255, 255, 255, 180)));

                // Mengatur aksi pada tombol Lihat
                buttonLihat.addActionListener(e -> {
                    // Tambahkan kode untuk aksi tombol "Lihat" di sini
                    JOptionPane.showMessageDialog(admin.DashboardUtama.SubPanel, "Tombol Lihat diklik");
                });

                // Mengatur aksi pada tombol Update
                buttonUpdate.addActionListener(e -> {
                    // Tambahkan kode untuk aksi tombol "Update" di sini
                    JOptionPane.showMessageDialog(admin.DashboardUtama.SubPanel, "Tombol Update diklik");
                    // Misalnya, membuka dialog untuk melakukan update data
                });

                return panel;
            }

            // RENDERER UNTUK KOLOM LAIN
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected) {
                c.setBackground(new Color(100, 10, 10)); // Warna merah saat dipilih
                c.setForeground(Color.WHITE); // Teks putih
            } else {
                c.setBackground(new Color(255, 255, 255, 150)); // Transparan jika tidak dipilih
                c.setForeground(Color.BLACK); // Teks hitam jika tidak dipilih
            }

            if (c instanceof JComponent jc) {
                jc.setBorder(null); // Hilangkan border
            }

            return c;
        }
    });

    // === EDITOR UNTUK TOMBOL SAAT DIKLIK ===
    class ButtonCellEditor extends DefaultCellEditor {
        private final JButton buttonLihat = new JButton();
        private final JButton buttonUpdate = new JButton();
        private final JPanel panel = new JPanel(new GridBagLayout());
        private JTable currentTable;
        private int currentRow;

        public ButtonCellEditor() {
            super(new JCheckBox()); // dummy
            buttonLihat.setPreferredSize(new Dimension(100, 30));
            buttonLihat.setContentAreaFilled(true);
            buttonLihat.setBorder(new EmptyBorder(3, 3, 3, 3));
            buttonLihat.setFocusPainted(false);
            buttonLihat.setOpaque(true);
            buttonLihat.setBackground(Color.WHITE);
            buttonLihat.setIcon(new ImageIcon(getClass().getResource("/bahan/globalIcon/kembali-30px.png")));

            buttonUpdate.setPreferredSize(new Dimension(100, 30));
            buttonUpdate.setContentAreaFilled(true);
            buttonUpdate.setBorder(new EmptyBorder(3, 3, 3, 3));
            buttonUpdate.setFocusPainted(false);
            buttonUpdate.setOpaque(true);
            buttonUpdate.setBackground(Color.WHITE);
            buttonUpdate.setIcon(new ImageIcon(getClass().getResource("/bahan/globalIcon/edit-30px.png"))); // Ganti dengan ikon Update

            panel.setOpaque(true);
            panel.add(buttonLihat);
            panel.add(buttonUpdate); // Menambahkan tombol Update

            // Menambahkan aksi pada tombol Lihat
            buttonLihat.addActionListener(e -> {
                JOptionPane.showMessageDialog(admin.DashboardUtama.SubPanel, "Tombol Lihat diklik");
            });

            // Menambahkan aksi pada tombol Update
            buttonUpdate.addActionListener(e -> {
                JOptionPane.showMessageDialog(admin.DashboardUtama.SubPanel, "Tombol Update diklik");
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.currentTable = table;
            this.currentRow = row;

            panel.setBackground(new Color(100, 10, 10)); // SESUAI WARNA SELEKSI
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