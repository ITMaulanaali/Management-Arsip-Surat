package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection connection;
//    private static String url = "jdbc:mysql://localhost:3306/arsip_surat";
//    private static String username = "aku";
//    private static String password = "123";
    
    private static String url = "jdbc:mysql://n5ne6.h.filess.io:3307/lanalagi_nearlyfast";
    private static String username = "lanalagi_nearlyfast";
    private static String password = "aa564f946f6133e119fc4f4f34201e192a980ab5";
    
//    private static String url = "jdbc:postgresql://eo591.h.filess.io:5432/postgrearsipsurat_coffeeiron";
//    private static String username = "postgrearsipsurat_coffeeiron";
//    private static String password = "a311aeb058fbaf2d26233550fe1a42b7247f451c";
//    export PGPASSWORD='61258e96561b0d44581c93eeb63f7dcaac1c7382'; psql -U arsipsurat_bestporch -h ot8k6.h.filess.io -w arsipsurat_bestporch
    
    public static Connection Koneksi(){
        if(connection == null){
            try{
//                Class.forName("org.postgresql.Driver");
                Koneksi.connection = DriverManager.getConnection(Koneksi.url,Koneksi.username,Koneksi.password);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Gagal terkoneksi Database: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }
}
//dari remote mobile
