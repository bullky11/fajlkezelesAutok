package autoproject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Autoproject {

    private List<String> sorok;
    private AutoType[] autoadat;

    public static void main(String[] args) throws IOException {
        new Autoproject().feladatok();
    }

    public Autoproject() throws IOException {
        sorok = Files.readAllLines(Path.of("auto.txt"));
        autoadat = new AutoType[sorok.size() - 1];
        for (int i = 1; i < sorok.size(); i++) {

            autoadat[i - 1] = new AutoType(sorok.get(i));

        }
    }

    private void feladatok() {
        feladata();
        Linebreak();
        feladat1();
        Linebreak();
        feladat2();
        Linebreak();
        feladat3();
        Linebreak();
        feladat4();
        Linebreak();
        feladat5();
        Linebreak();    
        feladat6();
        Linebreak();
    }

    private void feladata() {
        System.out.println("1.feladat: Hány sort tartalmaz a fájlt?");
        int index = 0;
        for (int i = 0; i < autoadat.length; i++) {
            System.out.println(autoadat[i]);

        }
        System.out.println(sorok.size() + " soros a fájl");
    }

    private void Linebreak() {
        System.out.println("-------------------------");
    }

    private void feladat1() {
        System.out.println("1. feladat : melyik autó a legdrágább?(auto és típus) ");
        int index = 0;
        for (int i = 0; i < autoadat.length; i++) {
            if (autoadat[i].getAr() > autoadat[index].getAr()) {
                index = i;
            }

        }
        String marka = autoadat[index].getMarka();
        System.out.println(marka + " " + autoadat[index].getModell());
        assert marka.equals("Ford") : "1.hibás válasz";
    }

    private void feladat2() {
        System.out.println("2. feladat: Mennyi az autok átlagára:");
        int sum = 0;
        for (int i = 0; i < autoadat.length; i++) {
            sum += autoadat[i].getAr();
        }
        double atlag = sum / autoadat.length;
        System.out.println("Az autók átlagára " + atlag);
        assert atlag == 2308 : "3.feladat hibás átlag";

    }

    private void feladat3() {
        System.out.println("3.feladat: Minden auto fekete színű?");
        int i = 0, N = autoadat.length;

        while (i < N && autoadat[i].getSzin().equals("Fekete")) {
            i++;
        }
        boolean feketeMind = i > N;
        System.out.println(i + ". indexen " + feketeMind);

        assert !feketeMind : "3.feladat hibás rossz ciklus";
    }

    private void feladat4() {
        System.out.println("4.feladat: van autó ami Ford márkájú és drágább  mint 5000 dollár?");
        int i = 0, N = autoadat.length;
        boolean ford5000;
        while (i < N && !(autoadat[i].getMarka().equals("Ford") && autoadat[i].getAr() >= 5000)) {
            i++;
        }
        ford5000 = i < N;
        if (ford5000) {
            System.out.println(ford5000 + " " + autoadat[i].getMarka() + autoadat[i].getModell() + " ami " + autoadat[i].getAr()+"  dollár");
        } else {
            System.out.println("nincs");
        }
        assert ford5000 : "hibás válasz";
        System.out.println(i);
        assert i == 3 : " hibás prog tétel";
    }

    private void feladat5() {
        System.out.println("5.feladat: Milyen Márkák vannak eltárolva?");
        HashSet<String> autoMarkak=new HashSet<>();
        for (AutoType markak : autoadat) {
            autoMarkak.add(markak.getMarka());
            
        }
        System.out.println("Márkák"+autoMarkak.toString());
        assert autoMarkak.size()==4 : "hibás méret";
        assert autoMarkak.contains("Ford"):"hibás adat";
    }

    private void feladat6() {
        System.out.println("6.feladat: Melyik automárkából mennyi van?");
        Map<String,Integer> autoDB=new HashMap<>();
        for (AutoType markak : autoadat) {
            String kulcs=markak.getMarka();
            if (autoDB.containsKey(kulcs)) {
                int ertek=autoDB.get(kulcs);
                autoDB.put(kulcs, ++ertek);
                
            }else{
                autoDB.put(kulcs, 1);
                
            }
            
        }
        for (Map.Entry<String, Integer> entry : autoDB.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("%-11s: %4d db \n", key, value);
               
            
        }
    }

}
