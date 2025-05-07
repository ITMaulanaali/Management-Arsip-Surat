package admin.menuKelolaAkun;

import javax.swing.JOptionPane;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.Query;

public class TambahUser extends javax.swing.JPanel {

    Query query = new Query();
    
    public TambahUser() {
        initComponents();
        admin.DashboardUtama.Judul.setText("Tambahkan User");
    }

    void clean(){
        TextField_nama.setText("");
        TextField_username.setText("");
        CmBox_kepalaSekolah.setSelectedIndex(0);
        TextField_passwd.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextField_nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TextField_username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CmBox_kepalaSekolah = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        TextField_passwd = new javax.swing.JTextField();
        batal = new javax.swing.JButton();
        Button_simpan = new javax.swing.JButton();

        setBackground(new java.awt.Color(195, 184, 184));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tambahkan User");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nama");

        TextField_nama.setPreferredSize(new java.awt.Dimension(40, 30));
        TextField_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_namaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Username");

        TextField_username.setPreferredSize(new java.awt.Dimension(40, 30));
        TextField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_usernameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Role");

        CmBox_kepalaSekolah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Waka Kurikulum", "Waka Humas", "Waka Kesiswaan", "Waka Sarana dan Prasarana", "Waka Manajemen Mutu", "kepala sekolah" }));
        CmBox_kepalaSekolah.setPreferredSize(new java.awt.Dimension(76, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Password");

        TextField_passwd.setPreferredSize(new java.awt.Dimension(40, 30));

        batal.setBackground(new java.awt.Color(196, 196, 196));
        batal.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        batal.setText("Batal");
        batal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        batal.setMaximumSize(new java.awt.Dimension(83, 40));
        batal.setPreferredSize(new java.awt.Dimension(70, 50));
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        Button_simpan.setBackground(new java.awt.Color(125, 10, 10));
        Button_simpan.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        Button_simpan.setForeground(new java.awt.Color(255, 255, 255));
        Button_simpan.setText("Simpan");
        Button_simpan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Button_simpan.setMaximumSize(new java.awt.Dimension(83, 40));
        Button_simpan.setPreferredSize(new java.awt.Dimension(70, 50));
        Button_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(208, 208, 208))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(batal, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(Button_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(260, 260, 260))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextField_nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CmBox_kepalaSekolah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField_passwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(TextField_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(TextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(CmBox_kepalaSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(TextField_passwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TextField_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_namaActionPerformed

    private void TextField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_usernameActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        admin.DashboardUtama.Judul.setText("Home");
        clean();
        
        admin.DashboardUtama.SubPanel.removeAll();
        admin.DashboardUtama.SubPanel.add(new admin.menuKelolaAkun.TampilanKelolaAkun());
        admin.DashboardUtama.SubPanel.revalidate();
        admin.DashboardUtama.SubPanel.repaint();
        
    }//GEN-LAST:event_batalActionPerformed

    private void Button_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_simpanActionPerformed
        String nama = TextField_nama.getText();
        String username = TextField_username.getText();
        String role = CmBox_kepalaSekolah.getItemAt(CmBox_kepalaSekolah.getSelectedIndex());
        String password = TextField_passwd.getText();
        
        String[] atributs = {"username","password","nama","jenis_role"};
        String[] values = {username,password,nama,role};
        
        try{
            query.setNamaTabel("user").setAtribut(atributs).setValue(values).insert();
            JOptionPane.showMessageDialog(null, "Berhasil menambahkan data");
            
            admin.DashboardUtama.SubPanel.removeAll();
            admin.DashboardUtama.SubPanel.add(new admin.menuKelolaAkun.TampilanKelolaAkun());
            admin.DashboardUtama.SubPanel.revalidate();
            admin.DashboardUtama.SubPanel.repaint();
        }catch(SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "Username sudah digunakan");
        } catch (Exception e) {
            Logger.getLogger(TambahUser.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }//GEN-LAST:event_Button_simpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_simpan;
    private javax.swing.JComboBox<String> CmBox_kepalaSekolah;
    private javax.swing.JTextField TextField_nama;
    private javax.swing.JTextField TextField_passwd;
    private javax.swing.JTextField TextField_username;
    private javax.swing.JButton batal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
