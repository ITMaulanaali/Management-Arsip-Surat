
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

    Query query = new Query();
     String[] coloumn = {"no_surat","tanggal_surat","pengirim","kategori","perihal","file_surat","status_notifikasi"};
    
    public TampilanSuratMasuk() {
        initComponents();
        menampilkanSuratMasuk();
        
    }

   
    
    void menampilkanSuratMasuk(){
        try {
            ResultSet hasil = query.setNamaTabel("surat_masuk").setAtribut(this.coloumn).select();
            
            DefaultTableModel modelTable = new DefaultTableModel(); 
            modelTable.addColumn("no_surat");
            modelTable.addColumn("tanggal_surat");
            modelTable.addColumn("pengirim");
            modelTable.addColumn("kategori");
            modelTable.addColumn("perihal");
            modelTable.addColumn("file_surat");
            modelTable.addColumn("status_notifikasi");
            
            
            while(hasil.next()){
                String no = hasil.getString("no_surat");
                String tanggal = hasil.getString("tanggal_surat");
                String pengirim = hasil.getString("pengirim");
                String kategori = hasil.getString("kategori");
                String perihal = hasil.getString("perihal");
                String file_surat = hasil.getString("file_surat");
                String status_notifikasi = hasil.getString("status_notifikasi");
                
                modelTable.addRow(new Object[]{no, tanggal, pengirim, kategori, perihal, file_surat, status_notifikasi });
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

        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        periode1 = new javax.swing.JPanel();
        iconPeriode = new javax.swing.JLabel();
        periode = new javax.swing.JLabel();
        arsipkan = new javax.swing.JPanel();
        iconPeriode1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_suratMasuk = new javax.swing.JTable();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("Cari");
        jTextField1.setMinimumSize(new java.awt.Dimension(0, 40));
        jTextField1.setPreferredSize(new java.awt.Dimension(600, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Perihal", "Kategori", "Tanggal Diterima", "File" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(80, 40));

        periode1.setBackground(new java.awt.Color(217, 217, 217));
        periode1.setPreferredSize(new java.awt.Dimension(100, 40));
        periode1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                periode1MouseClicked(evt);
            }
        });

        iconPeriode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/periode50px.png"))); // NOI18N

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
                .addContainerGap(20, Short.MAX_VALUE))
        );
        periode1Layout.setVerticalGroup(
            periode1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(periode1Layout.createSequentialGroup()
                .addGroup(periode1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        arsipkan.setBackground(new java.awt.Color(217, 217, 217));
        arsipkan.setPreferredSize(new java.awt.Dimension(100, 40));
        arsipkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arsipkanMouseClicked(evt);
            }
        });

        iconPeriode1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/globalIcon/tambah-surat50px.png"))); // NOI18N

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
                .addContainerGap(15, Short.MAX_VALUE))
        );
        arsipkanLayout.setVerticalGroup(
            arsipkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arsipkanLayout.createSequentialGroup()
                .addGroup(arsipkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconPeriode1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_suratMasukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_suratMasuk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(arsipkan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(periode1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(periode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arsipkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tabel_suratMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_suratMasukMouseClicked
      
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratMasuk.LihatSurat());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
        
    }//GEN-LAST:event_tabel_suratMasukMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel arsipkan;
    private javax.swing.JLabel iconPeriode;
    private javax.swing.JLabel iconPeriode1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel periode;
    private javax.swing.JPanel periode1;
    private javax.swing.JTable tabel_suratMasuk;
    // End of variables declaration//GEN-END:variables
}
