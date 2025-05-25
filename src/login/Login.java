package login;


import java.awt.event.KeyEvent;
import lib.Query;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public class Login extends javax.swing.JPanel {
    
    Query query = new Query();
    String[] data;
    
    public Login() {
        initComponents();
        
    }

    private void cekUser(String user, String password){
        String[] atributs = {"username","password","nama","jenis_role"};
        String nama = "";
        String kredensial = "";
        String peran = "";
        
        try {
            PreparedStatement stm = lib.Koneksi.Koneksi().prepareStatement("SELECT username, password, jenis_role from user WHERE username = '"+user+"' OR password = '"+password+"'");
            ResultSet hasil = stm.executeQuery();
            while(hasil.next()){
                
                if(user.equals(hasil.getString("username")) && password.equals(hasil.getString("password"))){
                    nama = hasil.getString("username");
                    kredensial = hasil.getString("password");
                    peran = hasil.getString("jenis_role");
                }else if(user.equals(hasil.getString("username"))){
                    nama = hasil.getString("username");
                    kredensial = hasil.getString("password");
                    peran = hasil.getString("jenis_role");
                }else if(password.equals(hasil.getString("password"))){
                    kredensial = hasil.getString("password");
                    peran = hasil.getString("jenis_role");
                }
            }
            
                if(user.equals(nama)){
                    if(password.equals(kredensial)){
                        switch (peran) {
                        case "admin":
                            Main.PanelWadah.removeAll();
                            Main.PanelWadah.add(new admin.DashboardUtama());
                            Main.PanelWadah.revalidate();
                            Main.PanelWadah.repaint();
                            return;
                        case "kepala sekolah":
                            Main.PanelWadah.removeAll();
                            Main.PanelWadah.add(new kepsek.DashboardUtama());
                            Main.PanelWadah.revalidate();
                            Main.PanelWadah.repaint();
                            return;
                        default:
                            Main.PanelWadah.removeAll();
                            Main.PanelWadah.add(new waka.DashboardUtama(peran));
                            Main.PanelWadah.revalidate();
                            Main.PanelWadah.repaint();
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Password Salah");
                        return;
                    }
                }else if(!user.equals(nama) && !password.equals(kredensial)){
                    JOptionPane.showMessageDialog(this, "Pastikan username dan password sudah benar");
                    return;
                }else{
                    JOptionPane.showMessageDialog(this, "Username salah");
                    return;
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
        } 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TextField_username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TexField_password = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 380));

        TextField_username.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        TextField_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        TextField_username.setPreferredSize(new java.awt.Dimension(64, 35));
        TextField_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextField_usernameKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Password");

        jButton1.setBackground(new java.awt.Color(125, 10, 10));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Masuk");
        jButton1.setMaximumSize(new java.awt.Dimension(83, 40));
        jButton1.setMinimumSize(new java.awt.Dimension(70, 24));
        jButton1.setPreferredSize(new java.awt.Dimension(70, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Username");

        TexField_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        TexField_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TexField_passwordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(TextField_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TexField_password))
                        .addGap(39, 39, 39)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TexField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        jPanel2.setBackground(new java.awt.Color(189, 189, 189));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/background/LogoMenu-200x200px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sistem Aplikasi Surat Menyurat");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SMK Antartika 1 Sidoarjo");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Selamat Datang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(176, 176, 176))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String user = TextField_username.getText();
        String password = TexField_password.getText();

        cekUser(user,password);


        
//        switch(user){
//            case "tu":
//            Main.PanelWadah.removeAll();
//            Main.PanelWadah.add(new admin.DashboardUtama());
//            Main.PanelWadah.revalidate();
//            Main.PanelWadah.repaint();
//            break;
//            case "ks":
//            Main.PanelWadah.removeAll();
//            Main.PanelWadah.add(new kepsek.DashboardUtama());
//            Main.PanelWadah.revalidate();
//            Main.PanelWadah.repaint();
//            break;
//            case "wk":
//            Main.PanelWadah.removeAll();
//            Main.PanelWadah.add(new waka.DashboardUtama());
//            Main.PanelWadah.revalidate();
//            Main.PanelWadah.repaint();
//            break;
//        }

        //String[] dataLogin = cekUser(user,password);
        //String nama = dataLogin[0];
        //String kredensial = dataLogin[1];
        //String peran = dataLogin[2];
        //
        //if("Wali Kurikulum".equals(peran)){
            //            if(user.equals(nama) && password.equals(kredensial)){
                //                Main.PanelWadah.removeAll();
                //                Main.PanelWadah.add(new waka.DashboardUtama());
                //                Main.PanelWadah.revalidate();
                //                Main.PanelWadah.repaint();
                //            }
            //        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TextField_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_usernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton1.doClick();
        }
    }//GEN-LAST:event_TextField_usernameKeyPressed

    private void TexField_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TexField_passwordKeyPressed
      
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton1.doClick();
        }
    }//GEN-LAST:event_TexField_passwordKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField TexField_password;
    private javax.swing.JTextField TextField_username;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
