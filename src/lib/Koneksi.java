package lib.database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection connection;
//    private static String url = "jdbc:mysql://localhost:3306/arsip_surat";
//    private static String username = "aku";
//    private static String password = "123";
    
//    private static String url = "jdbc:mysql://project_stovefunny:1035790129012485324edba85b29c877307139e0@d5ymf.h.filess.io:3307/project_stovefunny";
//    private static String username = "project_stovefunny";
//    private static String password = "1035790129012485324edba85b29c877307139e0";
    
    private static String url = "jdbc:postgresql://eo591.h.filess.io:5432/postgrearsipsurat_coffeeiron";
    private static String username = "postgrearsipsurat_coffeeiron";
    private static String password = "a311aeb058fbaf2d26233550fe1a42b7247f451c";
//    export PGPASSWORD='61258e96561b0d44581c93eeb63f7dcaac1c7382'; psql -U arsipsurat_bestporch -h ot8k6.h.filess.io -w arsipsurat_bestporch
    
    public static Connection Koneksi(){
        if(connection == null){
            try{
                Class.forName("org.postgresql.Driver");
                Koneksi.connection = DriverManager.getConnection(Koneksi.url,Koneksi.username,Koneksi.password);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Gagal terkoneksi Database: " + e.getMessage());
            }
        }
        return connection;
    }
}
