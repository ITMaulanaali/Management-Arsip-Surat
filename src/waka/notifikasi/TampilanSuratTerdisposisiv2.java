
package waka.notifikasi;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.MatteBorder;


public class TampilanSuratTerdisposisiv2 extends javax.swing.JPanel {
    ArrayList<JPanel> panel;
    String[][] data;
    
    public TampilanSuratTerdisposisiv2() {
        initComponents();
        this.panel = new ArrayList();
        this.data = getData();
        scrollPanel.setViewportView(setupPanel());
        filterdata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
    "Disposisi No.",  // data[0]
    "Surat No.",      // data[4]
    "Perihal:",       // data[5]
    "Diterima"        // data[1]
}));
    }   
    
    private String[][] getData(){
        ArrayList<String> nodisposisi = new ArrayList();
        ArrayList<String> tgldisposisi = new ArrayList();
        ArrayList<String> catatandisposisi = new ArrayList();
        ArrayList<String> statusdisposisi = new ArrayList();
        ArrayList<String> nosuratmasuk = new ArrayList();
        ArrayList<String> perihalsuratmasuk = new ArrayList();
        ArrayList<byte[]> fileBiner = new ArrayList();
        
        String[][] data = null;
        
        try {
            PreparedStatement query = lib.Koneksi.Koneksi().prepareStatement("select disposisi.no_disposisi as nodisposisi, disposisi.tanggal_disposisi, disposisi.catatan, disposisi.status_disposisi, surat_masuk.no_surat as nosuratmasuk, surat_masuk.perihal, surat_masuk.file_surat from disposisi inner join surat_masuk on(disposisi.no_surat = surat_masuk.no_surat) inner join user on(disposisi.username = user.username)");
            ResultSet hasil = query.executeQuery();
            
            while(hasil.next()){
                nodisposisi.add(hasil.getString("nodisposisi"));
                tgldisposisi.add(hasil.getString("tanggal_disposisi"));
                catatandisposisi.add(hasil.getString("catatan"));
                statusdisposisi.add(hasil.getString("status_disposisi"));
                nosuratmasuk.add(hasil.getString("nosuratmasuk"));
                perihalsuratmasuk.add(hasil.getString("perihal"));
                fileBiner.add(hasil.getBytes("surat_masuk.file_surat"));
            }
            
            data = new String[7][nodisposisi.size()];
            
            for(int i=0; i<nodisposisi.size(); i++){
                data[0][i] = nodisposisi.get(i);
            }
            
            for(int i=0; i<nodisposisi.size(); i++){
                data[1][i] = tgldisposisi.get(i);
            }
            
            for(int i=0; i<nodisposisi.size(); i++){
                data[2][i] = catatandisposisi.get(i);
            }
            
            for(int i=0; i<nodisposisi.size(); i++){
                data[3][i] = statusdisposisi.get(i);
            }
            
            for(int i=0; i<nodisposisi.size(); i++){
                data[4][i] = nosuratmasuk.get(i);
            }
            
            for(int i=0; i<nodisposisi.size(); i++){
                data[5][i] = perihalsuratmasuk.get(i);
            }
            
            for(int i=0; i<nodisposisi.size(); i++){
                String s = Base64.getEncoder().encodeToString(fileBiner.get(i));
                data[6][i] = s;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TampilanSuratTerdisposisiv2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    private JPanel setupPanel(){
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
            
             
        for(int i=0; i<data[0].length; i++){
            JPanel panel = new subNotifikasi(this.data[0][i], this.data[4][i], this.data[5][i], this.data[1][i], this.data[2][i], this.data[6][i]);
            panel.setBorder(new MatteBorder(0, 0, 10, 0, new Color(158,158,158)));
        
            container.setBackground(new Color(158,158,158));
            container.add(panel);
        }
        
        return container;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cari = new javax.swing.JTextField();
        scrollPanel = new javax.swing.JScrollPane();
        filterdata = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(158, 158, 158));
        setMinimumSize(new java.awt.Dimension(860, 483));
        setPreferredSize(new java.awt.Dimension(860, 483));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        cari.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cari.setText("Cari");
        cari.setMinimumSize(new java.awt.Dimension(0, 40));
        cari.setPreferredSize(new java.awt.Dimension(600, 40));
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });

        scrollPanel.setBackground(new java.awt.Color(158, 158, 158));

        filterdata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disposisi No.", "Surat No.", "Perihal:", "Diterima" }));
        filterdata.setPreferredSize(new java.awt.Dimension(80, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(filterdata, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                    .addGap(25, 25, 25)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(423, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGap(24, 24, 24)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
     
     if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(new Color(158, 158, 158));

        String keyword = cari.getText().trim().toLowerCase();

        // Mapping pilihan filter ke kolom array data
        int selectedIndex = filterdata.getSelectedIndex();
        int kolom;
        switch (selectedIndex) {
            case 0: kolom = 0; break; // Disposisi No.
            case 1: kolom = 4; break; // Surat No.
            case 2: kolom = 5; break; // Perihal
            case 3: kolom = 1; break; // Tanggal (Diterima)
            default: kolom = 0;
        }

        scrollPanel.setViewportView(null);
        boolean ditemukan = false;

        for (int i = 0; i < data[0].length; i++) {
            if (data[kolom][i].toLowerCase().contains(keyword)) {
                JPanel panel = new subNotifikasi(
                    data[0][i], data[4][i], data[5][i],
                    data[1][i], data[2][i], data[6][i]
                );
                panel.setBorder(new MatteBorder(0, 0, 10, 0, new Color(158,158,158)));
                container.add(panel);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            JPanel kosong = new JPanel();
            kosong.add(new javax.swing.JLabel("Data tidak ditemukan."));
            kosong.setBackground(new Color(158,158,158));
            container.add(kosong);
        }

        scrollPanel.setViewportView(container);
        scrollPanel.revalidate();
        scrollPanel.repaint();
    }
         
    }//GEN-LAST:event_cariKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> filterdata;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
