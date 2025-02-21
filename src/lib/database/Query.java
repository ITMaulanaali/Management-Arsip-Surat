package lib.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Query {
    private String namaTabel;
    private String[] whereUpdate;
    private String[] atribut;
    private String[] valueString;
    private int[] valueInt;
    
    public Query setNamaTabel(String namaTable){
        this.namaTabel = namaTable;
        return this;
    }
    
    public Query setAtribut(String[] atribut){
        this.atribut = atribut;
        return this;
    }
    
    public Query setValue(String[] value){
        for(int i=0; i<value.length; i++){
            try{
                this.valueInt[i] = Integer.parseInt(value[i]);
                this.valueString[i] = null;
            }catch(Exception e){
                this.valueString[i] = value[i];
            }
        }
        return this;
    }
    
    public Query setWhereIdUpdate(String atributId, String valueId){
        this.whereUpdate[0] = atributId;
        this.whereUpdate[1] = valueId;
        return this;
    }
    
    private String setQueryInsert(String[] atribut){
        String hasilQuery ="";
        for(int i=0; i<atribut.length; i++){
            hasilQuery += atribut[i]+",";
        }
        hasilQuery.substring(0, hasilQuery.length()-1);
        return hasilQuery;
    }
    
    private String setQueryUpdate(String[] atribut){
        String hasilQuery ="";
        for(int i=0; i<atribut.length; i++){
            hasilQuery += atribut[i] + " = ?";
        }
        hasilQuery.substring(0, hasilQuery.length()-1);
        return hasilQuery;
    }
    
    //CRUD
    public void insert(){
        PreparedStatement statement;
        String atribut = setQueryInsert(this.atribut);
        
        try{
            statement = Koneksi.Koneksi().prepareStatement("INSERT INTO "+this.namaTabel+" ("+atribut+") VALUES (?,?,?)");
            
            for(int i=0; i<this.atribut.length; i++){
                    if(this.valueString[i] != null){
                        statement.setString(i+1, valueString[i]);
                    }else{
                        statement.setInt(i+1, valueInt[i]);
                    }
                }
            statement.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal melakukan insert data: " + e.getMessage());
        }
    }
    
    public void update(){
        PreparedStatement statement;
        String atributUpdate = setQueryUpdate(this.atribut);
        
        try{
            statement = Koneksi.Koneksi().prepareStatement("UPDATE "+this.namaTabel+" SET ("+atributUpdate+") WHERE "+this.whereUpdate[0]+" = ?");
            
            for(int i=0; i<this.atribut.length; i++){
                if(this.valueString[i] != null){
                    statement.setString(i+1, valueString[i]);
                }else{
                    statement.setInt(i+1, valueInt[i]);
                }
            }
            
            try{
                statement.setInt(1, Integer.parseInt(this.whereUpdate[1]));
            }catch(Exception e){
                statement.setString(1, this.whereUpdate[1]);
            }
            statement.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal melakukan insert data: " + e.getMessage());
        }
    }
}
