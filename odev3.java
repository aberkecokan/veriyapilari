package veriyapilari;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class odev3 {
    String[] kelimeler;
    int n, tepe;
    public odev3(int n){
        this.n = n;
        kelimeler = new String[n];
        tepe = -1;
    }
    public boolean bosMu(){
        return tepe == -1;
    }
    public boolean doluMu(){
        return tepe == n-1;
    }
    public void ekle(String yeni){
        if(!doluMu()){
            tepe++;
            kelimeler[tepe] = yeni;
        }
        else{
            System.out.println("Dizi Dolu!!!");
        }
    }
    public String sil(){
        if(!bosMu()){
            String s = kelimeler[tepe];
            tepe--;
            return s;
        }
        else{
            System.out.println("Dizi Boş!!!");
            return null;
        }
    }
    public String tepeEleman(){
        if(!bosMu()){
            return kelimeler[tepe];
        }
        else{
            System.out.println("Dizi Boş!!!");
            return null;
        }
    }
    public void goster(){
        for (int i = 0; i <= tepe; i++) {
            System.out.println(kelimeler[i]);
        }
    }
    /*
    public String cevirString(){
        String kelime = "";
        for (int i = 0; i < this.n; i++) {
            if(this.kelimeler[i] != null){
                kelime = kelime+"\n"+kelimeler[i];
            }
        }
        return kelime;
    }
    */
    
}

class Gui extends JFrame {
    static odev3 redo=new odev3(10);
    static	odev3 undo=new odev3(10);
    JButton ileri, geri, kaydet, ekle;
    JLabel kan;
    JTextField metin;
    int sayac = 0; 
    
    Gui(){
        
        setLayout(new FlowLayout());
        ileri = new JButton("İleri");
        geri = new JButton("Geri");
        ekle = new JButton("Ekle");
        kaydet = new JButton("Kaydet");
        metin = new JTextField(100);
        add(metin);add(kaydet);
        add(ileri);add(geri);add(ekle);
        
        
        ekle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String cumle = ""; String kelime = "";
                if(sayac <= metin.getText().length()){
                    cumle = metin.getText().substring(sayac);
                    kelime = "";    
                }
                if(cumle.length()<1){
                    System.out.println("Eklenecek yeni kelime yok!!!");
                }
                else{
                    for (int i = 0; i < cumle.length(); i++) {
                        if(cumle.charAt(i) != ' '){
                            kelime = kelime+cumle.charAt(i);
                        }
                        else{
                            sayac = sayac + kelime.length()+1;
                            if(!redo.doluMu()){
                                redo.ekle(kelime);
                            }
                            else{
                                System.out.println("�leri yakalama doldu!!!");
                            }
                            kelime = "";
                        }
                    }
                    System.out.println("�leri yakalad�:");
                    redo.goster();
                    
                }
                
            }
        });
        geri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kelime = "";
                String kelime2 = "";
                String cumle = metin.getText();
                boolean sayacgeri = true;
                if(cumle.length() > 0){
                    while(sayacgeri){
                        int i = cumle.length()-1;
                        if(i < 0){
                                sayacgeri = false;
                        }
                        else if(cumle.charAt(i) != ' '){
                            kelime = kelime+cumle.charAt(i);
                            cumle = ""+cumle.substring(0,i);
                        }
                        else{
                            cumle = ""+cumle.substring(0,i);
                            sayacgeri = false;
                        }
                    }
                    for (int i = kelime.length()-1; i >= 0; i--) {
                        kelime2 = kelime2+kelime.charAt(i);
                    }

                    if(kelime2 == ""){
                        System.out.println("Kelime yok");
                        metin.setText(cumle);
                    }
                    else if(kelime2.equals(redo.tepeEleman())){
                        if(!undo.doluMu()){
                            undo.ekle(redo.tepeEleman());
                            redo.sil();
                            System.out.println("Geri Yığıtı: ");
                            undo.goster();
                            System.out.println("İleri Yığıtı: ");
                            redo.goster();
                            metin.setText(cumle);
                            if(metin.getText().length() == 0){
                                sayac= 0;
                            }
                            else{
                                sayac = metin.getText().length()+1;
                            }
                        }
                        else{
                            System.out.println("Geri Alma yığıtı dolu.");
                        }
                        
                    }
                    else{
                        System.out.println("Son kelime yığıta eklenmemiş!!!");
                    }
                }
                else{
                    System.out.println("Metin alanına bilgi giriniz.");
                }
            }
        });
        ileri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String cumle = metin.getText();
                if(!undo.bosMu()){
                    redo.ekle(undo.tepeEleman());
                    undo.sil();
                    if(cumle.length() != 0){
                        cumle = cumle+" "+redo.tepeEleman();
                    }
                    else{
                        cumle = redo.tepeEleman();
                    }
                    metin.setText(cumle);
                    System.out.println("İleri Yığıtı: ");
                    redo.goster();
                    System.out.println("Geri Yığıtı: ");
                    undo.goster();
                    sayac = metin.getText().length()+1;
                }
                else{
                    System.out.println("İleri alınabilecek eleman yok.");
                }
            }
        });
        kaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                while(!redo.bosMu()){
                    redo.sil();
                }
                while(!undo.bosMu()){
                    undo.sil();
                }
                System.out.println("Kayıt Başarlılı. Yığıtlar Boşaltıldı.");
            }
        });
        
    }
    public static void main(String[] args) {
        
        Gui g = new Gui();
        g.setTitle("Kelime Yığıtı");
        g.setSize(1200, 300);
        g.setDefaultCloseOperation(EXIT_ON_CLOSE);
        g.setVisible(true);
    }
}
    



