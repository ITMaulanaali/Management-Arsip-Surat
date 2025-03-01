package lib.database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/arsip_surat";
    private static String username = "aku";
    private static String password = "123";
    
    public static Connection Koneksi(){
        if(connection == null){
            try{
                Koneksi.connection = DriverManager.getConnection(Koneksi.url,Koneksi.username,Koneksi.password);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Gagal terkoneksi Database: " + e.getMessage());
            }
        }
        return connection;
    }
}
