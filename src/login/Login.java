package login;


import java.awt.event.KeyEvent;
import lib.Query;
import java.sql.ResultSet;
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
        String nama = null;
        String kredensial = null;
        String peran = null;
        
        try {
            ResultSet hasil = query.setNamaTabel("user").setAtribut(atributs).setWhereId("username", user).selectWhereIdDownload();
            while(hasil.next()){
                nama = hasil.getString("username");
                kredensial = hasil.getString("password");
                peran = hasil.getString("jenis_role");
                
                if(user.equals(nama) && password.equals(kredensial)){
                    if(peran.equals("Waka Kurikulum")){
                        Main.PanelWadah.removeAll();
                        Main.PanelWadah.add(new waka.DashboardUtama(peran));
                        Main.PanelWadah.revalidate();
                        Main.PanelWadah.repaint();
                    }else if(peran.equals("Waka Humas")){
                        Main.PanelWadah.removeAll();
                        Main.PanelWadah.add(new waka.DashboardUtama(peran));
                        Main.PanelWadah.revalidate();
                        Main.PanelWadah.repaint();
                    }else if(peran.equals("Waka Kesiswaan")){
                        Main.PanelWadah.removeAll();
                        Main.PanelWadah.add(new waka.DashboardUtama(peran));
                        Main.PanelWadah.revalidate();
                        Main.PanelWadah.repaint();
                    }else if(peran.equals("Waka Sarana dan Prasarana")){
                        Main.PanelWadah.removeAll();
                        Main.PanelWadah.add(new waka.DashboardUtama(peran));
                        Main.PanelWadah.revalidate();
                        Main.PanelWadah.repaint();
                    }else if(peran.equals("Waka Manajemen Mutu")){
                        Main.PanelWadah.removeAll();
                        Main.PanelWadah.add(new waka.DashboardUtama(peran));
                        Main.PanelWadah.revalidate();
                        Main.PanelWadah.repaint();
                    }else if(peran.equals("admin")){
                        Main.PanelWadah.removeAll();
                        Main.PanelWadah.add(new admin.DashboardUtama());
                        Main.PanelWadah.revalidate();
                        Main.PanelWadah.repaint();
                    }else if(peran.equals("kepala sekolah")){
                        Main.PanelWadah.removeAll();
                        Main.PanelWadah.add(new kepsek.DashboardUtama());
                        Main.PanelWadah.revalidate();
                        Main.PanelWadah.repaint();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "User atau Password salah");
                    return;
                }
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

        setBackground(new java.awt.Color(158, 158, 158));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 380));

        TextField_username.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
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
        jLabel2.setText("MASUK");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextField_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TexField_password))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TexField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel2.setBackground(new java.awt.Color(189, 189, 189));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bahan/WhatsApp Image 2025-04-23 at 20.45.24 (1) (1) (1).png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sistem Aplikasi Surat Menyurat");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SMK Antartika 1 Sidoarjo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Selamat Datang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(560, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(297, 297, 297)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(jLabel7)
                    .addContainerGap(461, Short.MAX_VALUE)))
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
