package admin.menuKelolaAkun;

import java.awt.Graphics;
import javax.swing.JOptionPane;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import lib.Query;

public class EditUser extends javax.swing.JPanel {

    Query query = new Query();
    
    public EditUser() {
        initComponents();
    }

    void clean(){
        TextField_nama.setText("");
        TextField_username.setText("");
        CmBox_kepalaSekolah.setSelectedIndex(0);
        TextField_passwd.setText("");
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon(getClass().getResource("/bahan/background/backgroundPanel800x483px.png"));
        g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));
        setLayout(null);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nama");
        add(jLabel5);
        jLabel5.setBounds(190, 10, 103, 23);

        TextField_nama.setPreferredSize(new java.awt.Dimension(40, 30));
        TextField_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_namaActionPerformed(evt);
            }
        });
        add(TextField_nama);
        TextField_nama.setBounds(190, 30, 430, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Username");
        add(jLabel4);
        jLabel4.setBounds(190, 70, 103, 23);

        TextField_username.setEditable(false);
        TextField_username.setPreferredSize(new java.awt.Dimension(40, 30));
        TextField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_usernameActionPerformed(evt);
            }
        });
        add(TextField_username);
        TextField_username.setBounds(190, 90, 430, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Role");
        add(jLabel6);
        jLabel6.setBounds(190, 130, 103, 23);

        CmBox_kepalaSekolah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Waka Kurikulum", "Waka Humas", "Waka Kesiswaan", "Waka Sarana dan Prasarana", "Waka Manajemen Mutu", "kepala sekolah" }));
        CmBox_kepalaSekolah.setEnabled(false);
        CmBox_kepalaSekolah.setPreferredSize(new java.awt.Dimension(76, 30));
        add(CmBox_kepalaSekolah);
        CmBox_kepalaSekolah.setBounds(190, 150, 430, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Password Lama");
        add(jLabel7);
        jLabel7.setBounds(190, 190, 160, 23);

        TextField_passwd.setEditable(false);
        TextField_passwd.setPreferredSize(new java.awt.Dimension(40, 30));
        add(TextField_passwd);
        TextField_passwd.setBounds(190, 210, 430, 30);

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
        add(batal);
        batal.setBounds(210, 390, 150, 50);

        Button_simpan.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        Button_simpan.setText("Simpan");
        Button_simpan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Button_simpan.setMaximumSize(new java.awt.Dimension(83, 40));
        Button_simpan.setPreferredSize(new java.awt.Dimension(70, 50));
        Button_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_simpanActionPerformed(evt);
            }
        });
        add(Button_simpan);
        Button_simpan.setBounds(450, 390, 150, 50);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Password Baru");
        add(jLabel8);
        jLabel8.setBounds(190, 250, 160, 23);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Konfirmasi Password");
        add(jLabel9);
        jLabel9.setBounds(190, 310, 220, 23);
        add(jPasswordField1);
        jPasswordField1.setBounds(190, 330, 430, 30);
        add(jPasswordField2);
        jPasswordField2.setBounds(190, 270, 430, 30);
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
            Logger.getLogger(EditUser.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }//GEN-LAST:event_Button_simpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_simpan;
    private javax.swing.JComboBox<String> CmBox_kepalaSekolah;
    private javax.swing.JTextField TextField_nama;
    private javax.swing.JTextField TextField_passwd;
    private javax.swing.JTextField TextField_username;
    private javax.swing.JButton batal;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    // End of variables declaration//GEN-END:variables
}
