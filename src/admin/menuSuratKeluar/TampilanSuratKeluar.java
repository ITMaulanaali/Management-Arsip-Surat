
package admin.menuSuratKeluar;

import admin.menuKelolaAkun.TampilanKelolaAkun;
import admin.menuSuratMasuk.*;
import java.io.File;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lib.Query;

public class TampilanSuratKeluar extends javax.swing.JPanel {
    
private String selectedNoSurat, selectedkodelembaga, selectednamainstansi, selectedbulan, selectedtahun;
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
            fileSurat = hasil.getString("file_surat"); // Mengambil path file
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
        edit = new javax.swing.JPanel();
        iconPeriode2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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
        });

        iconPeriode1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/Arsip.png"))); // NOI18N

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
            .addComponent(iconPeriode1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        });

        iconPeriode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/Periode.png"))); // NOI18N

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
                .addContainerGap(40, Short.MAX_VALUE))
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
        edit.setPreferredSize(new java.awt.Dimension(100, 40));
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editMouseExited(evt);
            }
        });

        iconPeriode2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/background/Edit.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Edit");

        javax.swing.GroupLayout editLayout = new javax.swing.GroupLayout(edit);
        edit.setLayout(editLayout);
        editLayout.setHorizontalGroup(
            editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconPeriode2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editLayout.setVerticalGroup(
            editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconPeriode2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

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
                                .addGap(310, 310, 310)
                                .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addGap(40, 40, 40)
                                .addComponent(panel_arsipkan, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_periode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_arsipkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void panel_arsipkanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_arsipkanMouseEntered
    panel_arsipkan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    panel_arsipkan.setBackground(new java.awt.Color(255, 255, 255)); // Ubah warna saat ditekan
    }//GEN-LAST:event_panel_arsipkanMouseEntered

    private void panel_arsipkanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_arsipkanMouseExited
    panel_arsipkan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    panel_arsipkan.setBackground(new java.awt.Color(217, 217, 217)); // Ubah warna saat ditekan
    }//GEN-LAST:event_panel_arsipkanMouseExited

    private void panel_periodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_periodeMouseEntered
    panel_periode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    panel_periode.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_panel_periodeMouseEntered

    private void panel_periodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_periodeMouseExited
    panel_periode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    panel_periode.setBackground(new java.awt.Color(217, 217, 217));
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

    private void tabel_suratkeluarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_suratkeluarMousePressed
        int baris = tabel_suratkeluar.rowAtPoint(evt.getPoint());
    if (baris < 0) {
        return; // Clicked outside table rows
    }

    if (evt.getClickCount() == 1) {
        // Single click: set selection on the clicked row
        tabel_suratkeluar.setRowSelectionInterval(baris, baris);
        
        // Simpan data yang dipilih
        selectedNoSurat = (String) tabel_suratkeluar.getValueAt(baris, 0);
        selectedTanggalSurat = (String) tabel_suratkeluar.getValueAt(baris, 1);
        selectedPenerima = (String) tabel_suratkeluar.getValueAt(baris, 2);
        selectedKategori = (String) tabel_suratkeluar.getValueAt(baris, 3);
        selectedPerihal = (String) tabel_suratkeluar.getValueAt(baris, 4);
        selectedStatusPengiriman = (String) tabel_suratkeluar.getValueAt(baris, 5);
        selectedAlamatTujuan = (String) tabel_suratkeluar.getValueAt(baris, 6);
        // Ambil file surat jika diperlukan
        selectedFileSurat = getFileSuratFromDatabase(selectedNoSurat);
        
        } else if (evt.getClickCount() == 2) {
            // Double click: open LihatSurat panel with selected row details
            String[] data = new String[7];
    
            data[0] = (String)tabel_suratkeluar.getValueAt(baris, 0);
            data[1] = (String)tabel_suratkeluar.getValueAt(baris, 1);
            data[2] = (String)tabel_suratkeluar.getValueAt(baris, 2);
            data[3] = (String)tabel_suratkeluar.getValueAt(baris, 3);
            data[4] = (String)tabel_suratkeluar.getValueAt(baris, 4);
            data[5] = (String)tabel_suratkeluar.getValueAt(baris, 5);
            data[6] = (String)tabel_suratkeluar.getValueAt(baris, 5);
    
            
            try {
                String[] atributs = {"no_surat","file_surat"};
                ResultSet hasil = query.setNamaTabel("surat_keluar").setAtribut(atributs).setWhereId("no_surat", data[0]).selectWhereIdDownload();
                while(hasil.next()){
                    this.file = hasil.getBytes("file_surat");
                }
            } catch (Exception ex) {
                Logger.getLogger(TampilanSuratMasuk.class.getName()).log(Level.SEVERE, null, ex);
            }
    
            admin.DashboardUtama.SubPanel.removeAll();
            admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.LihatSurat(data,file));
            admin.DashboardUtama.SubPanel.revalidate();
            admin.DashboardUtama.SubPanel.repaint(); 
        }
    
    }//GEN-LAST:event_tabel_suratkeluarMousePressed

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
               
    if (selectedNoSurat != null) {
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new ArsipkanSurat(
            selectedNoSurat,
            selectedTanggalSurat,
            selectedPenerima,
            selectedKategori,
            selectedPerihal,
            selectedStatusPengiriman,
            selectedAlamatTujuan
        ));
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
    } else {
        JOptionPane.showMessageDialog(this, "Silakan pilih data yang ingin diedit.", "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
    
    }//GEN-LAST:event_editMouseClicked

    private void editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseEntered
    edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Ubah kursor saat mouse masuk
    edit.setBackground(new java.awt.Color(255, 255, 255)); // Ubah warna saat ditekan
    }//GEN-LAST:event_editMouseEntered

    private void editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseExited
    edit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Kembalikan kursor saat mouse keluar
    edit.setBackground(new java.awt.Color(217, 217, 217));
    }//GEN-LAST:event_editMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JPanel edit;
    private javax.swing.JLabel iconPeriode;
    private javax.swing.JLabel iconPeriode1;
    private javax.swing.JLabel iconPeriode2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_arsipkan;
    private javax.swing.JPanel panel_periode;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTable tabel_suratkeluar;
    // End of variables declaration//GEN-END:variables
}
