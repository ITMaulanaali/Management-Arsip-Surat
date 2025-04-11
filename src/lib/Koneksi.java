package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection connection;
//    private static String url = "jdbc:mysql://localhost:3306/arsip_surat";
//    private static String username = "aku";
//    private static String password = "123";
    
    private static String url = "jdbc:mysql://arsipSurat_lifegiftgo:ef1d669241e7179cc85c533f83b03598be77ed66@4yxru.h.filess.io:61002/arsipSurat_lifegiftgo";
    private static String username = "arsipSurat_lifegiftgo";
    private static String password = "ef1d669241e7179cc85c533f83b03598be77ed66";
    
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
            }
        }
        return connection;
    }
}
//dari remote mobile
