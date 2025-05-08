package login;

import java.awt.print.PrinterJob;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PdfBoxLoader {
    private static final String JAR_PATH = "src/lib/pdfbox-app-2.0.29.jar"; // Path ke JAR PDFBox
    private static final String PDF_PRINTER_CLASS = "org.apache.pdfbox.printing.PDFPrintable"; // Class PDFPrinter
    private static final String PD_DOCUMENT_CLASS = "org.apache.pdfbox.pdmodel.PDDocument"; // Class PDDocument
    private static Class<?> pdfPrinterClass;
    private static Class<?> pdDocumentClass;
    private static URLClassLoader loader;

    static {
        try {
            File jarFile = new File(JAR_PATH);
            URL jarUrl = jarFile.toURI().toURL();
            loader = new URLClassLoader(new URL[]{jarUrl}, null);

            // Memuat class PDFPrinter dan PDDocument menggunakan class loader
            pdfPrinterClass = loader.loadClass(PDF_PRINTER_CLASS);
            pdDocumentClass = loader.loadClass(PD_DOCUMENT_CLASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Class<?> getPdDocumentClass() {
        return pdDocumentClass;
    }
    
    public static Class<?> getPdfPrinterClass() {
        return pdfPrinterClass;
    }

    public static Object loadDocument(File file) {
        try {
            // Memuat PDF menggunakan PDDocument.load() di versi PDFBox 2.0.29
            Method loadMethod = pdDocumentClass.getMethod("load", File.class);
            return loadMethod.invoke(null, file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveDocument(Object pdDocumentInstance, String outPath) {
        try {
            Method saveMethod = pdDocumentClass.getMethod("save", String.class);
            saveMethod.invoke(pdDocumentInstance, outPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeDocument(Object pdDocumentInstance) {
        try {
            Method closeMethod = pdDocumentClass.getMethod("close");
            closeMethod.invoke(pdDocumentInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

       public static void printDocument(Object pdDocumentInstance) {
        try {
            // Membuat objek PDFPrinter menggunakan reflection
            // Mengambil konstruktor dari PDFPrinter yang membutuhkan parameter PDDocument
            Constructor<?> pdfPrinterConstructor = pdfPrinterClass.getConstructor(PDDocument.class);
            
            // Membuat instance PDFPrinter
            Object pdfPrinterInstance = pdfPrinterConstructor.newInstance(pdDocumentInstance);

            // Menyiapkan PrinterJob untuk mencetak PDF
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            Method setPrintableMethod = PrinterJob.class.getMethod("setPrintable", java.awt.print.Printable.class);
            setPrintableMethod.invoke(printerJob, pdfPrinterInstance);

            if (printerJob.printDialog()) {
                printerJob.print();
            } else {
                System.out.println("Print cancelled by user.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
