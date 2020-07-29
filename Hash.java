


import java.util.Arrays;

class Dugum{
    int no ;
    Dugum ileri;
    Dugum(int no){
        this.no = no;
        ileri = null;
    }
}

class Liste{
    Dugum bas;
    Dugum son;
    Liste(){
        bas = null;
        son = null;
    }
    void ekle(Dugum yeni){
        if(bas == null){
            bas = yeni;
            son = yeni;
        }
        else{
            son.ileri = yeni;
            son = yeni;
        }
    }
    Dugum arama(Dugum aranan){
        Dugum tmp = bas;
        while(tmp != null){
            if(aranan == tmp){
                return tmp;
            }
            else{
                tmp = tmp.ileri;
            }   
        }
        System.out.println("Aranan eleman listede yok");
        return null;
    }
    void goster(){
        Dugum tmp = bas;
        while(tmp != null){
            System.out.println(tmp.no);
            tmp = tmp.ileri;
        }
    }
}

public class Hash {
    Liste l = new Liste() ;
    Dugum[] d ;
    int esay;
    int n;
    public Hash(int n){
        this.n = n;
        d = new Dugum[n];
        
        esay = -1;
    }
    void DogrusalEkle(Dugum yeni){
        int i = 0;
        int indis = ((yeni.no % n)+i) % n;
        int indisbas = indis;
        boolean doluMu = false;
        while(doluMu == false){
            if(d[indis] == null){
                esay++;
                d[indis] = yeni;
                doluMu = true;
            }
            else{
                i++;
                indis = ((yeni.no % n)+i) % n;
            }
            if(indis == indisbas){
                doluMu = true;
            }
        }
    }
    int DogrusalAra(Dugum yeni){
        int indis = yeni.no % n;
        int indisbas = indis;
        boolean doluMu = false;
        while(doluMu == false){
            
            if(d[indis] == null){
                return -1;
            }
            if(d[indis].no == yeni.no){
                return indis;
            }
            else if(n - indis == 1){
                indis = 0;
            }
            else{
                indis++;
            }
            if(indis == indisbas){
                doluMu = true;
            }
            
        }
        return -1;
    }
    void ZincirEkle(Dugum yeni){
        int indis = yeni.no % n;
        if(d[indis] == null){
            esay++;
            d[indis] = yeni;
        }
        else{
            esay++;
            l.ekle(yeni);
        }
    }
    Dugum ZincirAra(Dugum yeni){
        int indis = yeni.no % n;
        
        if(d[indis].no == yeni.no){
            return d[indis];
        }
        else{
            return l.arama(yeni);
        }
    }
    void Goster(){
        for (int i = 0; i < n; i++) {
            if(d[i] != null){
                System.out.println(d[i].no );
            }
            
        }
        System.out.println("Listedeki Elemanlar : ");
        l.goster();
    }
    
    boolean Anagram(String s, String s1){
        char[] SHarfDizisi = s.replaceAll("[s]", "").toCharArray();
        char[] S1HarfDizisi = s1.replaceAll("[s]", "").toCharArray();
        Arrays.sort(SHarfDizisi);
        Arrays.sort(S1HarfDizisi);
        return Arrays.equals(SHarfDizisi, S1HarfDizisi);
    }
    
}
class test{
    public static void main(String[] args) {
        Hash h = new Hash(5);
        
        
        Dugum d0=new Dugum(6);
        Dugum d1=new Dugum(19);
        Dugum d2=new Dugum(16);
        Dugum d3=new Dugum(10);
        Dugum d4=new Dugum(14);
        
        
        h.DogrusalEkle(d0);
        h.DogrusalEkle(d1);
        h.DogrusalEkle(d2);
        h.DogrusalEkle(d3);
        h.DogrusalEkle(d4);
        
        /*
        System.out.println(h.DogrusalAra(d2));
        System.out.println("*************************");
        h.Goster();
        */
        
        
        /*
        h.ZincirEkle(d0);
        h.ZincirEkle(d1);
        h.ZincirEkle(d2);
        h.ZincirEkle(d3);
        h.ZincirEkle(d4);
        
        
        h.Goster();
        */
        
        /* Anagram Karşılaştırması.
        String s1 = "kaban";
        String s2 = "bakan";
        if(h.Anagram(s1,s2) == true){
            System.out.println("Bu İki Kelime Anagramdır.");
        }
        else{
            System.out.println("Bu İki Kelime Anagram Değildir.");
        }
        */
    }
}

