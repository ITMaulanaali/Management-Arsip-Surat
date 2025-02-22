package lib.algoritma;

/**
 * Algoritma untuk memisahkan atribut dan value database dalam satu input object arrayString.
 * Yang akan menghasilkan 2 object array dengan tipedata String(array1=atribut dan array2=value) dan 1 object array dengan tipedata int untuk value. Contoh:
 * 
 * inputnya:
 * String[] data = {"atribut1","atribut2","atribut3","value1","value2",valueInt3};
 * 
 * outputnya:
 * String[] dataString1 = {"atribut1","atribut2","atribut3"};
 * String[] dataString2 = {"value1","value2",null};
 * Int[] dataInt3 = {0,0,valueInt3};
 * 
 * array objArray{dataString1,dataString2,dataInt3};
 * 
 */
class PisahAtributValue {
    private String[] atribut;
    private String[] value;
    private int[] valueInt;
    
    PisahAtributValue(String[] atributDanValue){
        int panjangData = atributDanValue.length;
        
        this.atribut = new String[panjangData/2];
        this.value = new String[panjangData/2];
        this.valueInt = new int[panjangData/2];
        
        pisah(atributDanValue);
    }
    
    private void pisah(String[] atributDanValue){
        int banyakDatum = atributDanValue.length;
        int setengahBanyakDatum = (banyakDatum/2);
        
        //memisahkan atribut
        for(int i=0; i<setengahBanyakDatum; i++){
            this.atribut[i] = atributDanValue[i];
        }
        
        //memisahkan valueInt dan String
        for(int i=0; setengahBanyakDatum<banyakDatum; i++){
            try{
                this.valueInt[i] = Integer.parseInt(atributDanValue[setengahBanyakDatum]);
                this.value[i] = null;
            }catch(Exception e){
                this.value[i] = atributDanValue[setengahBanyakDatum];
            }
            setengahBanyakDatum++;
        }        
    }
    
    public String[] getAtribut(){
        return this.atribut;
    }
    
    public String[] getValueString(){
        return this.value;
    }
    
    public int[] getValueInt(){
        return this.valueInt;
    }
}
