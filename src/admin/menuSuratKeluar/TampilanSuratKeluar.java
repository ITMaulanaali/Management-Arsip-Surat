
package admin.menuSuratKeluar;

import admin.menuKelolaAkun.TampilanKelolaAkun;
import admin.menuSuratMasuk.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import lib.Query;

public class TampilanSuratKeluar extends javax.swing.JPanel {

    Query query = new Query();
     String[] coloumn = {"no_surat","tanggal_surat","penerima","kategori","perihal","file_surat","status_pengiriman","alamat_tujuan"};
    
    
    public TampilanSuratKeluar() {
        initComponents();
         menampilkanSuratKeluar();
    }
    
    void menampilkanSuratKeluar(){
        try {
            ResultSet hasil = query.setNamaTabel("surat_keluar").setAtribut(this.coloumn).select();
            
            DefaultTableModel modelTable = new DefaultTableModel(); 
            modelTable.addColumn("no_surat");
            modelTable.addColumn("tanggal_surat");
            modelTable.addColumn("penerima");
            modelTable.addColumn("kategori");
            modelTable.addColumn("perihal");
            modelTable.addColumn("file_surat");
            modelTable.addColumn("status_pengiriman");
            modelTable.addColumn("alamat_tujuan");
            
            
            while(hasil.next()){
                String no = hasil.getString("no_surat");
                String tanggal = hasil.getString("tanggal_surat");
                String penerima = hasil.getString("penerima");
                String kategori = hasil.getString("kategori");
                String perihal = hasil.getString("perihal");
                String file_surat = hasil.getString("file_surat");
                String status_pengiriman = hasil.getString("status_pengiriman");
                String alamat_tujuan = hasil.getString("alamat_tujuan");
                
                modelTable.addRow(new Object[]{no, tanggal, penerima, kategori, perihal, file_surat, status_pengiriman, alamat_tujuan });
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        panel_arsipkan = new javax.swing.JPanel();
        iconPeriode1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panel_periode = new javax.swing.JPanel();
        iconPeriode = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_suratkeluar = new javax.swing.JTable();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Perihal", "Kategori", "Alamat", "Penerima", "Tanggal Dikirim", "Status Pengiriman", "File" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(80, 40));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("Cari");
        jTextField1.setMinimumSize(new java.awt.Dimension(0, 40));
        jTextField1.setPreferredSize(new java.awt.Dimension(600, 40));

        panel_arsipkan.setBackground(new java.awt.Color(217, 217, 217));
        panel_arsipkan.setPreferredSize(new java.awt.Dimension(100, 40));
        panel_arsipkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_arsipkanMouseClicked(evt);
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
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addContainerGap(20, Short.MAX_VALUE))
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_suratkeluarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_suratkeluar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel_arsipkan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_periode, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_periode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_arsipkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tabel_suratkeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_suratkeluarMouseClicked
      
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuSuratKeluar.LihatSurat());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint(); 
        
    }//GEN-LAST:event_tabel_suratkeluarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconPeriode;
    private javax.swing.JLabel iconPeriode1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panel_arsipkan;
    private javax.swing.JPanel panel_periode;
    private javax.swing.JTable tabel_suratkeluar;
    // End of variables declaration//GEN-END:variables
}
