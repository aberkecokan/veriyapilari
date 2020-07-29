package veriyapilari;

public class deneme6 {
		
	public deneme6() {
		deneme6 ileri;
		
	}


class Elemanlar {

    int numara;
    String ad;
    int vize;
    int genel;
    Elemanlar ileri;

    public Elemanlar(int numara, String ad, int vize, int genel) {
        this.numara = numara;
        this.ad = ad;
        this.vize = vize;
        this.genel = genel;
        ileri = null;
    }
}
public class Son {

    Elemanlar bas;
    Elemanlar son;

    public Son() {
        bas = null;
        son = null;
    }

    boolean bosmu() {
        return bas == null;
        bas=bas.ileri;
        	
    }

    void basaekle(Elemanlar yeni) {
        if (bosmu()) {
            bas = yeni;
            son = yeni;

        } else {
            yeni.ileri=yeni;
            bas = yeni;
        }

    }

    void arayaekleme(Elemanlar yeni, int sayi) {
        Elemanlar tmp = bas.ileri;
        Elemanlar once = bas;
        int sayac = 1;
        if (bosmu()) {
            bas = yeni;
            son = yeni;
        } else {
            while (sayac != sayi) {
                tmp = tmp.ileri;
                once = once.ileri;
                sayac++;
            }
            yeni.ileri = tmp;
            once.ileri = yeni;
        }
    }

    void sonaekle(Elemanlar yeni) {
        if (bosmu()) {
            bas = yeni;
            son = yeni;
        } else {
            son.ileri = yeni;
            son = yeni;
        }
    }

    String bastansilme() {
        Elemanlar silinen = bas;
        bas = bas.ileri;
        if (bosmu()) {
            son = null;

        }
        return silinen.ad;

    }

    void aradansilme(int sayi) {
        if (bas == null) {
            return;
        }

        Elemanlar tmp = bas;
        if (sayi == 0) {
            bas = tmp.ileri;
            return;
        }
        for (int i = 0; tmp != null && i < sayi - 1; i++) {
            tmp = tmp.ileri;
        }
        if (tmp == null) {
            return;
        }

        Elemanlar ileri = tmp.ileri.ileri;
        tmp.ileri = ileri;

    }

    String sondansilme() {
        Elemanlar silinen = son;
        Elemanlar once = bas;
        Elemanlar tmp = bas.ileri;
        if (tmp == null) {
            bas = null;
            son = null;	
            return silinen.ad;
        } else {
            while (tmp == son) {
                tmp.ileri = tmp;
                once.ileri = once;

            }
            once = son;

            return silinen.ad;
        }
    }

    Elemanlar enyuksek() {
        Elemanlar tmp = bas;
        Elemanlar enbuyuk = bas;
        if (bosmu()) {
            return null;
        } else {
            while (tmp != null) {
                if (tmp.vize > enbuyuk.vize) {
                    enbuyuk = tmp;

                }
                tmp = tmp.ileri;

            }
        }

        return enbuyuk;

    }

    void tum() {
        Elemanlar tmp = bas;
        while (tmp != null) {
            System.out.println(tmp.ad + " " + tmp.vize + " " + tmp.numara + " " + tmp.genel);
            tmp = tmp.ileri;

        }

    }

    float notOrtalamasi() {
        Elemanlar tmp = bas;
        float ortNot = 0;
        float enbuyuk=0;
        while (tmp != null) {
            ortNot = (float) (tmp.vize * 0.4 + tmp.genel * 0.6);
            if(ortNot>enbuyuk) {
            	enbuyuk=ortNot;
            	
            }
            System.out.print(tmp.ad+"-->"+ortNot);
            
            int a=tmp.genel;
            tmp=tmp.ileri;
            
            if (a>=50 &&ortNot >= 50) {
           System.out.println(" =Geçti");
           
        } else {
            System.out.println(" =kaldý");
        }
        }
        System.out.println("En yüksek ortalama:"+enbuyuk);

        return ortNot;

    }
}

    public static void main(String[] args) {
        Son b = new Son();
        Son b2 = new Son();
        
        Elemanlar a = new Elemanlar(175260043, "Ahmet", 55, 60);
        Elemanlar q = new Elemanlar(175260047, "Berke", 40, 4);
        Elemanlar f = new Elemanlar(1752, "Ali", 12,23 );
        Elemanlar h = new Elemanlar(8454, "Ayþe", 55, 8);
        Elemanlar w = new Elemanlar(345, "srt", 23, 93);
        
        b.basaekle(a);
        b.sonaekle(q);
        b.basaekle(h);
        b.sonaekle(w);
        b.arayaekleme(f, 3);
        b.aradansilme(3);
        b.tum();

        System.out.println("///////////");
        b.notOrtalamasi();
        
        System.out.println("  ///////////////////7");
        System.out.println("En yuksek vize notu="+b.enyuksek().vize);
    
        
        System.out.println("/////////////////////////////////////////");
        
       
        
     
          
        
        
        
    
    }


}

