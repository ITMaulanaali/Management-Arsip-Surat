package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import lib.database.Query;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import penghubungPanel.Penghubung;


public class DashboardArsipMasuk extends javax.swing.JPanel implements Penghubung{
    //Data subPanelTable
    String[] valuesTable;
    //Data subPanelEdit
    String[] valuesEdit;
    
    JPanel PanelTable, PanelEdit;
    
    public DashboardArsipMasuk() {
        initComponents();
        PanelTable = new SubPanelTableArsipMasuk(this);
        setPanel();
    }
    
    public void setPanel(){
        PanelPopUpEdit.removeAll();
        PanelPopUpEdit.add(this.PanelTable);
        PanelPopUpEdit.setVisible(true);
        PanelPopUpEdit.revalidate();
        PanelPopUpEdit.repaint();
    }
    
    @Override
    public void pindahToSubPanelEdit(){
        PanelPopUpEdit.removeAll();
        if(PanelTable != null){
            PanelPopUpEdit.remove(PanelTable);
            PanelTable = null;
        }
        this.PanelEdit = new SubPanelEdit(this);
        PanelPopUpEdit.add(this.PanelEdit);
        PanelPopUpEdit.revalidate();
        PanelPopUpEdit.repaint();
    }
    
    @Override
    public void pindahToSubPanelTable(){
        PanelPopUpEdit.removeAll();
        if(PanelEdit != null){
            PanelPopUpEdit.remove(PanelEdit);
            PanelEdit = null;
        }
        this.PanelTable = new SubPanelTableArsipMasuk(this);
        PanelPopUpEdit.add(this.PanelTable);
        PanelPopUpEdit.revalidate();
        PanelPopUpEdit.repaint();
    }
    
    @Override
    public void getValuesPanelTable(String[] values){
        this.valuesTable = values;
    }
    
    @Override
    public String[] giveValuesPanelTable(){
        return this.valuesTable;
    }
    

    //set textField ke kosong
//    void setTextEdit(String[] valuePerBaris){
//        OutputLabelNoSurat.setText(valuePerBaris[1]);
//        TextFieldPerihalEditPopUp.setText(valuePerBaris[2]);
//        TextFieldDeskripsiEditPopUp.setText(valuePerBaris[3]);
//        TextFieldTanggalDiterimaEditPopUp.setText(valuePerBaris[4]);
//        OutputFileEditPopUp.setText(valuePerBaris[5]); //harusnya 5 untuk nama
//        //untuk file digital
//        
//    }
    
    //Untuk Rolling panel
//    void hideKomponenUtama(){
//        TableSuratMasuk.setVisible(false);
//        jScrollPane1.setVisible(false);
//        ButtonDelete.setVisible(false);
//        ButtonCetak.setVisible(false);
//        ComboBoxCari.setVisible(false);
//        TextFieldCari.setVisible(false);
//        ButtonEdit.setVisible(false);
//        ButtonDownload.setVisible(false);
//        PanelPopUpEdit.setVisible(true);
//    }
//    void hideKomponenUpdateData(){
//        PanelPopUpEdit.setVisible(false);
//        TableSuratMasuk.setVisible(true);
//        jScrollPane1.setVisible(true);
//        ButtonDelete.setVisible(true);
//        ButtonCetak.setVisible(true);
//        ComboBoxCari.setVisible(true);
//        ButtonEdit.setVisible(true);
//        ButtonDownload.setVisible(true);
//        TextFieldCari.setVisible(true);
//    }
//    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelDashboardArsipMasuk = new javax.swing.JLabel();
        LabelCari = new javax.swing.JLabel();
        PanelPopUpEdit = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAlignmentX(0.0F);
        setAlignmentY(100.0F);
        setMaximumSize(new java.awt.Dimension(950, 950));
        setMinimumSize(new java.awt.Dimension(950, 600));
        setLayout(null);

        LabelDashboardArsipMasuk.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        LabelDashboardArsipMasuk.setText("Dashboard Arsip Masuk");
        add(LabelDashboardArsipMasuk);
        LabelDashboardArsipMasuk.setBounds(337, 5, 275, 28);

        LabelCari.setText("Cari Berdasarkan: ");
        add(LabelCari);
        LabelCari.setBounds(550, 80, 130, 20);

        PanelPopUpEdit.setLayout(new java.awt.BorderLayout());
        add(PanelPopUpEdit);
        PanelPopUpEdit.setBounds(70, 100, 800, 440);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCari;
    private javax.swing.JLabel LabelDashboardArsipMasuk;
    private javax.swing.JPanel PanelPopUpEdit;
    // End of variables declaration//GEN-END:variables
}
