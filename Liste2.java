package liste2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


class ders {

    String derskodu;
    int sinifi;
    ders ileri;

    ders(String derskodu, int sinifi) {
        this.derskodu = derskodu;
        this.sinifi = sinifi;
        ileri = null;
    }

}

class ogrenci {

    String adý;
    String soyadý;
    int no;
    int sinifi;
    ogrenci ileri;
    ders bas, son;

    ogrenci(String adý, String soyadý, int no, int sinifi) {
        this.adý = adý;
        this.soyadý = soyadý;
        this.no = no;
        this.sinifi = sinifi;
        ileri = null;
        bas = null;
        son = null;

    }

    public void dersekle(ders yeni) {
        if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            son.ileri = yeni;
            son = yeni;
        }
    }

    public void derssil(ders silinecekders) {
        if (silinecekders.derskodu.equals(bas.derskodu)) {
            bas = bas.ileri;
        } else if (silinecekders.equals(son.derskodu)) {
            ders tmp = bas;
            while (tmp.ileri != son) {
                tmp = tmp.ileri;

            }
            tmp.ileri = null;
            son = tmp;

        } else {
            ders tmp = bas;
            while (tmp.ileri != silinecekders) {
                tmp = tmp.ileri;

            }
            tmp.ileri = silinecekders.ileri;

        }

    }

    public void dersgoster() {
        ders tmp = bas;
        while (tmp != null) {
            System.out.println(tmp.derskodu + " " + tmp.sinifi + " ");

            tmp = tmp.ileri;

        }

    }

}

public class Liste2 {

    ogrenci bas = null;
    ogrenci son = null;

    public void ogrenciekle(ogrenci yeni) {
        if (bas == null) {
            bas = yeni;
            son = yeni;

        } else {
            son.ileri = yeni;
            son = yeni;

        }

    }

    public void ogrokuekle(File f) {
        try {
            ogrenci tmp;
            String s = "";
            String okunan;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int numara1;
            String adý1;
            String soyadý1;
            int sinifi;
            String[] bilgiler = new String[4];
            int sayac = 0;
            while (br.ready()) {
                okunan = br.readLine();
                for (int i = 0; i < okunan.length(); i++) {
                    if (okunan.charAt(i) != ' ') {
                        s = s + okunan.charAt(i);
                    } else {
                        bilgiler[sayac] = s;
                        sayac++;
                        s = "";

                    }

                }
                bilgiler[sayac] = s;
                adý1 = bilgiler[0];
                soyadý1 = bilgiler[1];
                numara1 = Integer.parseInt(bilgiler[2]);
                sinifi = Integer.parseInt(bilgiler[3]);
                tmp = new ogrenci(adý1, soyadý1, numara1, sinifi);
                ogrenciekle(tmp);
                sayac = 0;
                s = "";

            }
            fr.close();
            br.close();

        } catch (Exception ex) {

        }
    }

    public void ogrencidersekle(File f) {
        ders tmp;
        String okunan;
        String s = "";
        String c[] = new String[2];
        int sayac = 0;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                okunan = br.readLine();
                for (int i = 0; i < okunan.length(); i++) {
                    if (okunan.charAt(i) != ' ') {
                        s += okunan.charAt(i);

                    } else {
                        c[sayac] = s;
                        sayac++;
                        s = "";
                    }
                }
                c[sayac] = s;
                sayac = 0;
                s = "";
                int sinifi = Integer.parseInt(c[1]);
                String derskodu = c[0];
                tmp = new ders(derskodu, sinifi);
                ogrenci tmp2 = bas;
                while (tmp2 != null) {
                    if (tmp2.sinifi == tmp.sinifi) {
                        tmp2.dersekle(tmp);

                    }
                    tmp2 = tmp2.ileri;

                }

            }
            fr.close();
            br.close();

        } catch (Exception ex) {

        }

    }

    public void ogrenciderslist() {
        ogrenci tmp = bas;
        while (tmp != null) {
            System.out.println(tmp.adý + " " + tmp.soyadý + " " + tmp.no + " " + tmp.sinifi + " ");
            tmp.dersgoster();
            tmp = tmp.ileri;
        }

    }

    public void ogrkontrol(ogrenci aranan) {
        ogrenci tmp = bas;
        while (tmp != null) {
            if (tmp.adý.equals(aranan.adý)) {
                System.out.println("1öðrencinin adý" +tmp.adý );
                tmp.dersgoster();
                break;
            }
            tmp = tmp.ileri;
        }
        if (tmp == null) {
            System.out.println("öðrenci bulunamadý");
        }

    }

    public static void main(String[] args) {
        File f = new File("C:/Users/berke/Desktop/odev2/ogrenciler.txt");
        File fr = new File("C:/Users/berke/Desktop/odev2/dersler.txt");
        Liste2 l = new Liste2();
      l.ogrokuekle(f);
        l.ogrencidersekle(fr);
       // l.ogrenciderslist();
            ogrenci o=new ogrenci("NUR","AZRA",162,4);
          //  l.ogrenciekle(o);
           l.ogrkontrol(o);
           l.ogrenciderslist();
     //    ders d=new ders("BMÜ322",3);
       //     l.bas.derssil(d);
        //    l.ogrkontrol(l.bas);

    }

}

