package lib;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

//Class untuk menampilkan file pdf a4 di jpanel
public class PdfDiJpanel {
    private PDDocument pdfFile;
    private PDFRenderer image;
    private float dpi = 48;
    private final float maxDpi = 100;
    
    public PdfDiJpanel addByteFile(byte[] fileBloob) throws Exception {
        this.pdfFile = Loader.loadPDF(fileBloob);
        this.image = new PDFRenderer(this.pdfFile);
        return this;
    }
    
    public ImageIcon getIcon() throws Exception{
        BufferedImage fotoSurat = this.image.renderImageWithDPI(0, this.dpi);
        return new ImageIcon(fotoSurat);
    }
    
    public void zoomOut() {
        if (dpi + 10 <= maxDpi) {
            dpi += 10;
            try {
                getIcon();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Terlalu banyak memperlebar");
            }
        }
    }

    public void zoomIn() {
        if (dpi - 10 >= 48) {
            dpi -= 10;
            try {
                getIcon();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Terlalu banyak memperkecil");
            }
        }
    }
}
