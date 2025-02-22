package lib.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Query {
    private String namaTabel;
    private ArrayList<String> whereUpdate;
    private ArrayList<String> atribut;
    private ArrayList<String> valueString;
    private ArrayList<Integer> valueInt;
    
    public Query(){
        
        this.atribut = new ArrayList<>();
        this.valueString = new ArrayList<>();
        this.valueInt = new ArrayList<>();
        this.whereUpdate = new ArrayList<>();
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
            try{
                this.valueInt.add(Integer.parseInt(i));
                this.valueString.add(null);
            }catch(Exception e){
                this.valueString.add(i);
            }
        }
        return this;
    }
    
    public Query setWhereIdUpdate(String atributId, String valueId){
        this.whereUpdate.add(atributId);
        this.whereUpdate.add(valueId);
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
    public void insert(){
        PreparedStatement statement;
        String[] atributLiteral = this.atribut.toArray(new String[0]);
        String atributs = setQueryInsert(atributLiteral);
        String values = setQueryInsertValue(atributLiteral);
        
        try{
            statement = Koneksi.Koneksi().prepareStatement("INSERT INTO "+this.namaTabel+" ("+atributs+") VALUES ("+values+")");
            
            for(int i=0; i<this.atribut.size(); i++){
                    if(this.valueString.get(i) != null){
                        statement.setString(i+1, valueString.get(i));
                    }else{
                        statement.setInt(i+1, valueInt.get(i));
                    }
                }
            statement.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal melakukan insert data: " + e.getMessage());
            System.out.println("Insert gagal: " + e);
        }
    }
    
    public void update(){
        PreparedStatement statement;
        String[] atributLiteral = this.atribut.toArray(new String[0]);
        String atributUpdate = setQueryUpdate(atributLiteral);
        
        try{
            statement = Koneksi.Koneksi().prepareStatement("UPDATE "+this.namaTabel+" SET "+atributUpdate+" WHERE "+this.whereUpdate.get(0)+" = ?");
            
            for(int i=0; i<this.atribut.size(); i++){
                if(this.valueString.get(i) != null){
                    statement.setString(i+1, valueString.get(i));
                }else{
                    statement.setInt(i+1, valueInt.get(i));
                }
            }
            
            try{
                statement.setInt(this.atribut.size()+1, Integer.parseInt(this.whereUpdate.get(1)));
            }catch(Exception e){
                statement.setString(this.atribut.size()+1, this.whereUpdate.get(1));
            }
            statement.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal melakukan update data: " + e.getMessage());
            System.out.println(e);
        }
    }
}
