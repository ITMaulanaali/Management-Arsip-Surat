package com;
import lib.database.Query;

public class DashboardHistory extends javax.swing.JPanel {
    Query query = new Query();
    
    public DashboardHistory() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelDashboardHistory = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setAlignmentX(0.0F);
        setAlignmentY(100.0F);
        setMaximumSize(new java.awt.Dimension(950, 600));
        setMinimumSize(new java.awt.Dimension(950, 600));
        setLayout(null);

        LabelDashboardHistory.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        LabelDashboardHistory.setText("Dashboard History");
        add(LabelDashboardHistory);
        LabelDashboardHistory.setBounds(337, 5, 220, 28);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(340, 170, 190, 70);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelDashboardHistory;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
