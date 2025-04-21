package admin.menuKelolaAkun;

import lib.Query;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TampilanKelolaAkun extends javax.swing.JPanel {

    Query query = new Query();
    String[] atributs = {"nama","username","jenis_role"};
    
    public TampilanKelolaAkun() {
        initComponents();
        menampilkanUser();
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
                modelTable.addRow(new Object[]{nama, username, peran});
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
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

        TableUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Username", "Peran", "Aksi"
            }
        ));
        TableUser.setMinimumSize(new java.awt.Dimension(1200, 80));
        TableUser.setPreferredSize(new java.awt.Dimension(1200, 80));
        jScrollPane1.setViewportView(TableUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
