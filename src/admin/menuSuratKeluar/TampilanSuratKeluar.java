
package admin.menuSuratKeluar;

import admin.menuKelolaAkun.TampilanKelolaAkun;
import admin.menuSuratMasuk.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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
private String selectedFileSurat;

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
            tabel_suratkeluar.setRowHeight(30);
            tabel_suratkeluar.setModel(modelTable);
            
        }catch (Exception ex) {
            Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pilih = new javax.swing.JComboBox<>();
        cari = new javax.swing.JTextField();
        panel_arsipkan = new javax.swing.JPanel();
        iconPeriode1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panel_periode = new javax.swing.JPanel();
        iconPeriode = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_suratkeluar = new javax.swing.JTable();
        edit = new javax.swing.JButton();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Tanggal Surat", "Penerima", "Kategori", "Perihal", "Status Pengiriman", "Alamat Tujuan" }));
        pilih.setPreferredSize(new java.awt.Dimension(80, 40));

        cari.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cari.setText("Cari");
        cari.setMinimumSize(new java.awt.Dimension(0, 40));
        cari.setPreferredSize(new java.awt.Dimension(600, 40));
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        panel_arsipkan.setBackground(new java.awt.Color(217, 217, 217));
        panel_arsipkan.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_arsipkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_arsipkanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_arsipkanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_arsipkanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel_arsipkanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panel_arsipkanMouseReleased(evt);
            }
        });

        iconPeriode1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/tambah-surat50px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Arsipkan");

        javax.swing.GroupLayout panel_arsipkanLayout = new javax.swing.GroupLayout(panel_arsipkan);
        panel_arsipkan.setLayout(panel_arsipkanLayout);
        panel_arsipkanLayout.setHorizontalGroup(
            panel_arsipkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_arsipkanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconPeriode1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_arsipkanLayout.setVerticalGroup(
            panel_arsipkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconPeriode1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panel_periode.setBackground(new java.awt.Color(217, 217, 217));
        panel_periode.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_periode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_periodeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_periodeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_periodeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel_periodeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panel_periodeMouseReleased(evt);
            }
        });

        iconPeriode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/periode50px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Periode");

        javax.swing.GroupLayout panel_periodeLayout = new javax.swing.GroupLayout(panel_periode);
        panel_periode.setLayout(panel_periodeLayout);
        panel_periodeLayout.setHorizontalGroup(
            panel_periodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_periodeLayout.createSequentialGroup()
                .addComponent(iconPeriode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_periodeLayout.setVerticalGroup(
            panel_periodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_periodeLayout.createSequentialGroup()
                .addGroup(panel_periodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabel_suratkeluar.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_suratkeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabel_suratkeluarMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_suratkeluar);

        edit.setBackground(new java.awt.Color(217, 217, 217));
        edit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        edit.setText("Edit");
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editMouseReleased(evt);
            }
        });
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(324, 324, 324)
                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(panel_arsipkan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pilih, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_periode, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel_periode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel_arsipkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panel_arsipkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_arsipkanMouseClicked
      
    admin.DashboardUtama.SubPanel.removeAll();
    admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.ArsipkanSurat());
    admin.DashboardUtama.SubPanel.revalidate();
    admin.DashboardUtama.SubPanel.repaint();
        
    }//GEN-LAST:event_panel_arsipkanMouseClicked

    private void panel_periodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_periodeMouseClicked
       
    admin.DashboardUtama.SubPanel.removeAll();
    admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.SuratByPeriode());
    admin.DashboardUtama.SubPanel.revalidate();
    admin.DashboardUtama.SubPanel.repaint();
        
    }//GEN-LAST:event_panel_periodeMouseClicked

    private void panel_arsipkanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_arsipkanMousePressed
    panel_arsipkan.setBackground(new java.awt.Color(200, 200, 200)); // Ubah warna saat ditekan
    }//GEN-LAST:event_panel_arsipkanMousePressed

    private void panel_arsipkanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_arsipkanMouseReleased
    panel_arsipkan.setBackground(new java.awt.Color(217, 217, 217)); // Kembalikan warna saat dilepaskan
    // Tambahkan logika untuk mengarsipkan surat
    admin.DashboardUtama.SubPanel.removeAll();
    admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.ArsipkanSurat());
    admin.DashboardUtama.SubPanel.revalidate();
    admin.DashboardUtama.SubPanel.repaint();
    }//GEN-LAST:event_panel_arsipkanMouseReleased

    private void panel_periodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_periodeMousePressed
         panel_periode.setBackground(new java.awt.Color(200, 200, 200)); // Ubah warna saat ditekan
    }//GEN-LAST:event_panel_periodeMousePressed

    private void panel_periodeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_periodeMouseReleased
    panel_periode.setBackground(new java.awt.Color(217, 217, 217)); // Kembalikan warna saat dilepaskan
    // Tambahkan logika untuk menampilkan surat berdasarkan periode
    admin.DashboardUtama.SubPanel.removeAll();
    admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.SuratByPeriode());
    admin.DashboardUtama.SubPanel.revalidate();
    admin.DashboardUtama.SubPanel.repaint();
    }//GEN-LAST:event_panel_periodeMouseReleased

    private void panel_arsipkanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_arsipkanMouseEntered
    panel_arsipkan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    }//GEN-LAST:event_panel_arsipkanMouseEntered

    private void panel_arsipkanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_arsipkanMouseExited
    panel_arsipkan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    }//GEN-LAST:event_panel_arsipkanMouseExited

    private void panel_periodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_periodeMouseEntered
    panel_periode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    }//GEN-LAST:event_panel_periodeMouseEntered

    private void panel_periodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_periodeMouseExited
    panel_periode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    }//GEN-LAST:event_panel_periodeMouseExited

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
     
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
        tabel_suratkeluar.setRowHeight(30);
        tabel_suratkeluar.setModel(modelTable);

    } catch (Exception ex) {
        Logger.getLogger(TampilanKelolaAkun.class.getName()).log(Level.SEVERE, null, ex);
    }     
        
    }//GEN-LAST:event_cariActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        
   // Pastikan data yang dipilih tidak null
    if (selectedNoSurat != null) {
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.ArsipkanSurat(
            selectedNoSurat, 
            selectedTanggalSurat, 
            selectedPenerima, 
            selectedKategori, 
            selectedPerihal, 
            selectedStatusPengiriman, 
            selectedAlamatTujuan,
            selectedFileSurat // Menggunakan file_surat yang diambil dari database
        ));
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();    
    } else {
        // Tampilkan pesan kesalahan jika tidak ada surat yang dipilih
        javax.swing.JOptionPane.showMessageDialog(this, "Silakan pilih data yang ingin diedit.", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_editActionPerformed

    private void editMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_editMousePressed

    private void editMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_editMouseReleased

    private void editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseEntered
    edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    }//GEN-LAST:event_editMouseEntered

    private void editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseExited
    edit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    }//GEN-LAST:event_editMouseExited

    private void tabel_suratkeluarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_suratkeluarMousePressed
     int row = tabel_suratkeluar.getSelectedRow(); // Ambil baris yang dipilih
    if (row != -1) { // Pastikan ada baris yang dipilih
        if (evt.getClickCount() == 1) {
            // Ambil data dari baris yang dipilih
            selectedNoSurat = tabel_suratkeluar.getValueAt(row, 0).toString();
            selectedTanggalSurat = tabel_suratkeluar.getValueAt(row, 1).toString();
            selectedPenerima = tabel_suratkeluar.getValueAt(row, 2).toString();
            selectedKategori = tabel_suratkeluar.getValueAt(row, 3).toString();
            selectedPerihal = tabel_suratkeluar.getValueAt(row, 4).toString();
            selectedStatusPengiriman = tabel_suratkeluar.getValueAt(row, 5).toString();
            selectedAlamatTujuan = tabel_suratkeluar.getValueAt(row, 6).toString();
            
            // Ambil file_surat dari database
            selectedFileSurat = getFileSuratFromDatabase(selectedNoSurat);
        } else if (evt.getClickCount() == 2) {
            // Tampilkan tampilan LihatSurat
            admin.DashboardUtama.SubPanel.removeAll();
            admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.LihatSurat());
            admin.DashboardUtama.SubPanel.revalidate();
            admin.DashboardUtama.SubPanel.repaint();
        }
    }
    
    }//GEN-LAST:event_tabel_suratkeluarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JButton edit;
    private javax.swing.JLabel iconPeriode;
    private javax.swing.JLabel iconPeriode1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_arsipkan;
    private javax.swing.JPanel panel_periode;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTable tabel_suratkeluar;
    // End of variables declaration//GEN-END:variables
}
