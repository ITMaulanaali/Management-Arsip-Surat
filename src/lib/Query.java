package lib;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import lib.Koneksi;

public class Query {
    private String namaTabel;
    private ArrayList<String> whereId;
    private ArrayList<String> atribut;
    private ArrayList<String> valueString;
    private ArrayList<Integer> valueInt;
    private String path;
    File file = null;
    
    private void refreshDataArray(){
        this.namaTabel = null;
        this.path = null;
        this.file = null;
        this.whereId.clear();
        this.atribut.clear();
        this.valueString.clear();
        this.valueInt.clear();
    }
    
    public Query(){
        
        this.atribut = new ArrayList<>();
        this.valueString = new ArrayList<>();
        this.valueInt = new ArrayList<>();
        this.whereId = new ArrayList<>();
    }
    
    public Query setNamaTabel(String namaTable){
        this.namaTabel = namaTable;
        return this;
    }
    
    public Query setAtribut(String[] atribut){
        for(String i : atribut){
            this.atribut.add(i);
        }
        return this;
    }
    
    public Query setValue(String[] value){
        for(String i : value){
            if(i.contains("/") || i.contains("\\")){
                this.path = i;
                this.valueString.add("path");
                System.out.println(i);
            }else{
                try{
                    this.valueInt.add(Integer.parseInt(i));
                    this.valueString.add(null);
                }catch(Exception e){
                    this.valueString.add(i);
                    this.valueInt.add(null);
                }
            }
        }
        return this;
    }
    
    public Query setWhereId(String atributId, String valueId){
        this.whereId.add(atributId);
        this.whereId.add(valueId);
        return this;
    }
    
    public Query setValuePath(String path){
        this.path = path;
        return this;
    }
    
    private String setQueryInsert(String[] atribut){
        String hasilQuery ="";
        for(int i=0; i<atribut.length; i++){
            hasilQuery += atribut[i]+",";
        }
        hasilQuery = hasilQuery.substring(0, hasilQuery.length()-1);
        return hasilQuery;
    }
    
    private String setQueryInsertValue(String[] atribut){
        String hasilQuery ="";
        for(int i=0; i<atribut.length; i++){
            hasilQuery += "?,";
        }
        hasilQuery = hasilQuery.substring(0, hasilQuery.length()-1);
        return hasilQuery;
    }
    
    private String setQueryUpdate(String[] atribut){
        String hasilQuery ="";
        for(int i=0; i<atribut.length; i++){
            hasilQuery += atribut[i] + " = ?,";
        }
        hasilQuery = hasilQuery.substring(0, hasilQuery.length()-1);
        return hasilQuery;
    }
    
    
    //CRUD
    public int insert() throws Exception{
        PreparedStatement statement;
        String[] atributLiteral = this.atribut.toArray(new String[0]);
        String atributs = setQueryInsert(atributLiteral);
        String values = setQueryInsertValue(atributLiteral);
        int hasil = 0;  
        
        
        statement = Koneksi.Koneksi().prepareStatement("INSERT INTO "+this.namaTabel+" ("+atributs+") VALUES ("+values+")");
        if(this.path != null){
            this.file = new File(this.path);
        }
            
        for(int i=0; i<this.atribut.size(); i++){
            if("path".equals(this.valueString.get(i))){
                statement.setBinaryStream(i+1, new FileInputStream(this.file), (int)this.file.length());
            }else if(this.valueString.get(i) != null){
                statement.setString(i+1, valueString.get(i));
            }else{
                statement.setInt(i+1, valueInt.get(i));         
            }
        }
            
//            for(int i=0; i<this.atribut.size(); i++){
//                    if(this.valueString.get(i) != null){
//                        statement.setString(i+1, valueString.get(i));
//                    }else{
//                        statement.setInt(i+1, valueInt.get(i));
//                    }
//                }
        hasil = statement.executeUpdate();
        refreshDataArray();
        return hasil;
    }
    
    //hanya dapat update satu record data
    public void update() throws Exception{
        PreparedStatement statement;
        String[] atributLiteral = this.atribut.toArray(new String[0]);
        String atributUpdate = setQueryUpdate(atributLiteral);

        statement = Koneksi.Koneksi().prepareStatement("UPDATE "+this.namaTabel+" SET "+atributUpdate+" WHERE "+this.whereId.get(0)+" = ?");
            
//            for(int i=0; i<this.atribut.size(); i++){
//                if(this.valueString.get(i) != null){
//                    statement.setString(i+1, valueString.get(i));
//                }else{
//                    statement.setInt(i+1, valueInt.get(i));
//                }
//            }
            
        for(int i=0; i<this.atribut.size(); i++){
            if(this.valueString.get(i).equals("path")){
                byte[] dataByte = new byte[(int) this.path.length()];
                FileInputStream inputStream = new FileInputStream(this.file);
                inputStream.read(dataByte);
                statement.setBytes(i+1, dataByte);
            }else if(this.valueString.get(i) != null){
                statement.setString(i+1, valueString.get(i));
            }else{
                statement.setInt(i+1, valueInt.get(i));
            }
        }

        try{
            statement.setInt(this.atribut.size()+1, Integer.parseInt(this.whereId.get(1)));
        }catch(Exception e){
            statement.setString(this.atribut.size()+1, this.whereId.get(1));
        }
        statement.execute();
        refreshDataArray();
    }
    
    //hanya dapat delete satu record data
    public void delete() throws Exception{
        PreparedStatement statement;
        
        statement = Koneksi.Koneksi().prepareStatement("DELETE FROM "+this.namaTabel+" WHERE "+this.whereId.get(0)+" = ?");
            
        try{
            statement.setInt(1, Integer.parseInt(this.whereId.get(1)));
        }catch(Exception e){
            statement.setString(1, this.whereId.get(1));
        }
        statement.execute();
    }
    
    public ResultSet select() throws Exception{
        PreparedStatement statement;
        String[] atributLiteral = this.atribut.toArray(new String[0]);
        String atributs = setQueryInsert(atributLiteral);
        ResultSet hasil = null;
        
        statement = Koneksi.Koneksi().prepareStatement("SELECT "+atributs+" FROM "+this.namaTabel+"");
        hasil = statement.executeQuery();
        refreshDataArray();
        return hasil;
    }
    
    public ResultSet selectWhereLike() throws Exception{
        PreparedStatement statement;
        String[] atributLiteral = this.atribut.toArray(new String[0]);
        String atributs = setQueryInsert(atributLiteral);
        ResultSet hasil = null;


        statement = Koneksi.Koneksi().prepareStatement("SELECT "+atributs+" FROM "+this.namaTabel+" WHERE "+this.whereId.get(0)+" LIKE ?");
            
//            try{
//                statement.setInt(1, Integer.parseInt(this.whereId.get(1)));
//            }catch(Exception e){
                statement.setString(1, "%"+this.whereId.get(1)+"%");
//            }

        hasil = statement.executeQuery();
        refreshDataArray();
        return hasil;
    }
    
    public ResultSet selectWhereIdDownload() throws Exception{
        PreparedStatement statement;
        String[] atributLiteral = this.atribut.toArray(new String[0]);
        String atributs = setQueryInsert(atributLiteral);
        ResultSet hasil = null;


            statement = Koneksi.Koneksi().prepareStatement("SELECT "+atributs+" FROM "+this.namaTabel+" WHERE "+this.whereId.get(0)+" = ?");
            
//            try{
//                statement.setInt(1, Integer.parseInt(this.whereId.get(1)));
//            }catch(Exception e){
                statement.setString(1, this.whereId.get(1));
//            }

        hasil = statement.executeQuery();
        refreshDataArray();
        return hasil;
    }
}

/**
 * Fomat insert:
 * 
 * String[] atributs = {"namaKolomId1","namaKolom2","namaKolom3"};
 * String[] values = {"74","keren","rumah"};
 * query.setNamaTabel("namaTable").setAtribut(atributs).setValue(values).insert();
 * 
 * format update:
 * 
 * String[] atributs = {"namaKolomId1","namaKolom2","namaKolom3"};
 * String[] values = {"74","keren","rumah"};
 * query.setNamaTabel("namaTable").setAtribut(atributs).setValue(values).setWhereId(atributs[0], values[0]).update();
 * 
 * format delete:
 * 
 * query.setNamaTabel("namaTable").setWhereId("namaKolomId", "valueKolomId").delete();
 * 
 * format Select:
 * 
 * String[] atributs = {"no_reg","nama","alamat","tgl_lahir","jam_daftar"};
 * ResultSet hasilQuery = query.setNamaTabel("nama_table").setAtribut(atributs).select();
 * 
 * format SelectWhereLike:
 * 
 * * String[] atributs = {"no_reg","nama","alamat","tgl_lahir","jam_daftar"};
 * query.setNamaTabel("namaTable").setAtribut(this.atributs).setWhereId("namaKolom", TextFieldCari.getText()).selectWhereLike();
 */