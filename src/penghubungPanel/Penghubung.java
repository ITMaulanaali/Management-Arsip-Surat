package penghubungPanel;

import com.DashboardArsipMasuk;
import com.SubPanelTableArsipMasuk;
import javax.swing.JPanel;

public interface Penghubung {
    
    //Untuk berpindah ke Lain
    void pindahToSubPanelEdit();
    void pindahToSubPanelTable();
    
    //mengambil data dari SubPanel dan disimpan terlebih dahulu ke PanelUtama
    void getValuesPanelTable(String[] values);
    //mengambil data dari PanelUtama ke SubPanel Lain
    String[] giveValuesPanelTable();
}
