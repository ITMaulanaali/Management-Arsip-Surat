package lib;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;


public class PilihFile {
    
    public static String getPath(){
        String pathFile = "";
        String originalLAF = UIManager.getLookAndFeel().getClass().getName();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".pdf", "pdf");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            pathFile = selectedFile.getAbsolutePath();
            
            try {
                UIManager.setLookAndFeel(originalLAF);
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
            
            return pathFile;
        }
        try {
                UIManager.setLookAndFeel(originalLAF);
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
        return pathFile;
    }
}
