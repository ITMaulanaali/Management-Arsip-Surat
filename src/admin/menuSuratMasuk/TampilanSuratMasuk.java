
package admin.menuSuratMasuk;

import admin.menuKelolaAkun.TampilanKelolaAkun;
import admin.menuSuratKeluar.*;
import admin.menuSuratMasuk.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lib.Query;

public class TampilanSuratMasuk extends javax.swing.JPanel {
    

    private Query query = new Query();
    private String[] coloumn = {"no_surat","tanggal_surat","pengirim","kategori","perihal","status_notifikasi"};
    private byte[] file;
    
    private static final String DEFAULT_SEARCH_TEXT = "Cari";
     
    public TampilanSuratMasuk() {
        initComponents();
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

   
    
    void menampilkanSuratMasuk(){
        try {
            ResultSet hasil = query.setNamaTabel("surat_masuk").setAtribut(this.coloumn).select();
            
            DefaultTableModel modelTable = new DefaultTableModel(); 
            modelTable.addColumn("No surat");
            modelTable.addColumn("Tanggal Surat");
            modelTable.addColumn("Pengirim");
            modelTable.addColumn("Kategori");
            modelTable.addColumn("Perihal");
            modelTable.addColumn("Status Notifikasi");
            
            
            while(hasil.next()){
                String no = hasil.getString("no_surat");
                String tanggal = hasil.getString("tanggal_surat");
                String pengirim = hasil.getString("pengirim");
                String kategori = hasil.getString("kategori");
                String perihal = hasil.getString("perihal");
                String status_notifikasi = hasil.getString("status_notifikasi");
                
                modelTable.addRow(new Object[]{no, tanggal, pengirim, kategori, perihal, status_notifikasi});
            }
            tabel_suratMasuk.setRowHeight(30);
            tabel_suratMasuk.setModel(modelTable);
            
        }catch (Exception ex) {
            Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cari = new javax.swing.JTextField();
        pilih = new javax.swing.JComboBox<>();
        arsipkan = new javax.swing.JPanel();
        iconPeriode1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        periode1 = new javax.swing.JPanel();
        iconPeriode = new javax.swing.JLabel();
        periode = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_suratMasuk = new javax.swing.JTable();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        cari.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cari.setText("Cari");
        cari.setMinimumSize(new java.awt.Dimension(0, 40));
        cari.setPreferredSize(new java.awt.Dimension(600, 40));
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Tanggal Surat", "Pengirim", "Kategori", "Perihal", "Status Notifikasi" }));
        pilih.setPreferredSize(new java.awt.Dimension(80, 40));
        pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihActionPerformed(evt);
            }
        });

        arsipkan.setBackground(new java.awt.Color(217, 217, 217));
        arsipkan.setPreferredSize(new java.awt.Dimension(100, 40));
        arsipkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arsipkanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                arsipkanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                arsipkanMouseExited(evt);
            }
        });

        iconPeriode1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/Arsip.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Arsipkan");

        javax.swing.GroupLayout arsipkanLayout = new javax.swing.GroupLayout(arsipkan);
        arsipkan.setLayout(arsipkanLayout);
        arsipkanLayout.setHorizontalGroup(
            arsipkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arsipkanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconPeriode1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        arsipkanLayout.setVerticalGroup(
            arsipkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arsipkanLayout.createSequentialGroup()
                .addGroup(arsipkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconPeriode1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        periode1.setBackground(new java.awt.Color(217, 217, 217));
        periode1.setPreferredSize(new java.awt.Dimension(100, 40));
        periode1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                periode1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                periode1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                periode1MouseExited(evt);
            }
        });

        iconPeriode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/Periode.png"))); // NOI18N

        periode.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        periode.setText("Periode");

        javax.swing.GroupLayout periode1Layout = new javax.swing.GroupLayout(periode1);
        periode1.setLayout(periode1Layout);
        periode1Layout.setHorizontalGroup(
            periode1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(periode1Layout.createSequentialGroup()
                .addComponent(iconPeriode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(periode)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        periode1Layout.setVerticalGroup(
            periode1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(periode1Layout.createSequentialGroup()
                .addGroup(periode1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jScrollPane2.setViewportView(tabel_suratMasuk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(458, 458, 458)
                                .addComponent(arsipkan, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                            .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(periode1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(pilih, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pilih, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(periode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arsipkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void periode1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_periode1MouseClicked
       
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratMasuk.SuratByPeriode());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
        
    }//GEN-LAST:event_periode1MouseClicked

    private void arsipkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arsipkanMouseClicked
       
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratMasuk.ArsipkanSurat());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
        
    }//GEN-LAST:event_arsipkanMouseClicked

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
       
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
                case "Status Notifikasi":
                    queryCondition = "status_notifikasi ";
                    break;
                default:
                    break;
            }
            // Lakukan query dengan kondisi yang telah dibuat
            ResultSet hasil = query.setNamaTabel("surat_masuk").setAtribut(this.coloumn).setWhereId(queryCondition, searchText).selectWhereLike();

            DefaultTableModel modelTable = new DefaultTableModel(); 
            modelTable.addColumn("No surat");
            modelTable.addColumn("Tanggal Surat");
            modelTable.addColumn("Pengirim");
            modelTable.addColumn("Kategori");
            modelTable.addColumn("Perihal");
            modelTable.addColumn("Status Notifikasi");

            while (hasil.next()) {
                String no = hasil.getString("no_surat");
                String tanggal = hasil.getString("tanggal_surat");
                String pengirim = hasil.getString("pengirim");
                String kategori = hasil.getString("kategori");
                String perihal = hasil.getString("perihal");
                String status_notifikasi = hasil.getString("status_notifikasi");

                modelTable.addRow(new Object[]{no, tanggal, pengirim, kategori, perihal, status_notifikasi });
            }
            tabel_suratMasuk.setRowHeight(30);
            tabel_suratMasuk.setModel(modelTable);

        } catch (Exception ex) {
            Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
        
    }//GEN-LAST:event_cariActionPerformed

    private void pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihActionPerformed
           
    }//GEN-LAST:event_pilihActionPerformed

    private void arsipkanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arsipkanMouseEntered
    arsipkan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    arsipkan.setBackground(new java.awt.Color(255, 255, 255)); // Ubah warna saat ditekan
    }//GEN-LAST:event_arsipkanMouseEntered

    private void arsipkanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arsipkanMouseExited
    arsipkan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    arsipkan.setBackground(new java.awt.Color(217, 217, 217)); // Ubah warna saat ditekan
    }//GEN-LAST:event_arsipkanMouseExited

    private void periode1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_periode1MouseEntered
    periode1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    periode1.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_periode1MouseEntered

    private void periode1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_periode1MouseExited
    periode1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    periode1.setBackground(new java.awt.Color(217, 217, 217));
    }//GEN-LAST:event_periode1MouseExited

    private void tabel_suratMasukMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_suratMasukMousePressed
        
   int baris = tabel_suratMasuk.rowAtPoint(evt.getPoint());
        if (baris < 0) {
            return; // Clicked outside table rows
        }

        if (evt.getClickCount() == 1) {
            // Single click: set selection on the clicked row
            tabel_suratMasuk.setRowSelectionInterval(baris, baris);
            // Additional logic for single click can be added here if needed
        } else if (evt.getClickCount() == 2) {
            // Double click: open LihatSurat panel with selected row details
            String[] data = new String[6];
    
            data[0] = (String)tabel_suratMasuk.getValueAt(baris, 0);
            data[1] = (String)tabel_suratMasuk.getValueAt(baris, 1);
            data[2] = (String)tabel_suratMasuk.getValueAt(baris, 2);
            data[3] = (String)tabel_suratMasuk.getValueAt(baris, 3);
            data[4] = (String)tabel_suratMasuk.getValueAt(baris, 4);
            data[5] = (String)tabel_suratMasuk.getValueAt(baris, 5);
    
    
            try {
                String[] atributs = {"no_surat","file_surat"};
                ResultSet hasil = query.setNamaTabel("surat_masuk").setAtribut(atributs).setWhereId("no_surat", data[0]).selectWhereIdDownload();
                while(hasil.next()){
                    this.file = hasil.getBytes("file_surat");
                }
            } catch (Exception ex) {
                Logger.getLogger(TampilanSuratMasuk.class.getName()).log(Level.SEVERE, null, ex);
            }
    
            admin.DashboardUtama.SubPanel.removeAll();
            admin.DashboardUtama.SubPanel.add(new admin.menuSuratMasuk.LihatSurat(data,this.file));
            admin.DashboardUtama.SubPanel.revalidate();
            admin.DashboardUtama.SubPanel.repaint(); 
        }
        
    }//GEN-LAST:event_tabel_suratMasukMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel arsipkan;
    private javax.swing.JTextField cari;
    private javax.swing.JLabel iconPeriode;
    private javax.swing.JLabel iconPeriode1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel periode;
    private javax.swing.JPanel periode1;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTable tabel_suratMasuk;
    // End of variables declaration//GEN-END:variables
}
