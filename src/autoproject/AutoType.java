package autoproject;

public class AutoType {

    private String marka;
    private String modell;
    private String szin;
    private int ar;

    public AutoType(String sor) {
        sor = sor.replace(',', '.');
        String[] s =sor.split(";");
        this.marka =s[0];
        this.modell = s[1];
        this.szin = s[2];
        this.ar = Integer.parseInt(s[3]);
    }

    public AutoType(String marka, String modell, String szin, int ar) {
        this.marka = marka;
        this.modell = modell;
        this.szin = szin;
        this.ar = ar;
    }

    public String getMarka() {
        return marka;
    }

    public String getModell() {
        return modell;
    }

    public String getSzin() {
        return szin;
    }

    public int getAr() {
        return ar;
    }

    @Override
    public String toString() {
        return "AutoType{" + "marka=" + marka + ", modell=" + modell + ", szin=" + szin + ", ar=" + ar + '}';
    }
    

}
