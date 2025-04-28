package lib;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

//Class untuk menampilkan file pdf a4 di jpanel
public class PdfDiJpanel {
    private PDDocument pdfFile;
    private PDFRenderer image;
    
    public PdfDiJpanel addFile(byte[] fileBloob) throws Exception {
        this.pdfFile = Loader.loadPDF(fileBloob);
        this.image = new PDFRenderer(this.pdfFile);
        return this;
    }
    
    public ImageIcon getIcon() throws Exception{
        BufferedImage fotoSurat = this.image.renderImageWithDPI(0, 150);
        return new ImageIcon(fotoSurat);
    }
}
