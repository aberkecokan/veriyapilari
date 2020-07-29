package veriyapilari;

	
		class Elemanlarlar{
			int icerik;
			Elemanlarlar ileri;
				
				public Elemanlarlar(int icerik) {

						this.icerik=icerik;
						ileri=null;
						
						
				}
									}
			public class bliste2{
					Elemanlarlar bas;
					Elemanlarlar son;
					
					bliste2(){
						bas=null;
						son=null;
						
					}
					
				void basaekle(Elemanlarlar yeni) {
					if(bas==null) {
						bas=yeni;
						son=yeni;
					}
					else {
						yeni.ileri=bas;
						bas=yeni;
				
					}
					
					
				}
				
				void sonaekle(Elemanlarlar yeni) {
					Elemanlarlar tmp=bas;
				if(bas==null) {
						bas=null;
						son=null;
					}
					else {
					
						son.ileri=yeni;
						yeni=son;
						
					}
				}
				
				
				void tum() {
					Elemanlarlar tmp=bas;
					String x="";
					while(tmp!=null) {
						x=x+"-->"+tmp.icerik;
						tmp=tmp.ileri;
					}
					System.out.println(x);
				}
				void arayaekleme(Elemanlarlar yeni,int numara) {
					Elemanlarlar tmp=bas;
					int sayac=0;
					if(bas==null) {
						bas=null;
						son=null;
						
						
					}else {
						while(sayac!=numara) {
						tmp=tmp.ileri;
						sayac++;
						}
						yeni.ileri=tmp.ileri;
						tmp.ileri=yeni;
						
						
						
					}
				}
				
				void bastansilme() {
					if(bas==null) {
						bas=null;
						son=null;
						
					}else {
						bas=bas.ileri;
						
					}
					 
					
				}
				void sondansilme(){
					Elemanlarlar tmp=bas;
					Elemanlarlar once=null;
					if(bas==null) {
						bas=null;
						son=null;
					}
					else {
						while(tmp!=son) {
								once=tmp;
								tmp=tmp.ileri;
								if(once==null) {
									son=null;
									bas=null;
								}else {
									once.ileri=null;
									son=once;
								}
						}
					
								
						
					}
				}
				
				
				boolean arama(int sayi) {
					Elemanlarlar tmp=bas;
					while(tmp!=null) {
						if(tmp.icerik==sayi) {
						return true;	
						
						}else {
							tmp=tmp.ileri;
						}
						
						
					}
					return false;
					}
				
				double ortalama() {
					Elemanlarlar tmp=bas;
					double a=0.0;
					int sayac=0;
					double ort=0.0;
					while(tmp!=null) {
					a=(double)a+tmp.icerik;
					sayac++;
					tmp=tmp.ileri;
				}
					ort=a/sayac;
					
					return ort;
				}
				
				
				
				
				void gecenkalan() {
					Elemanlarlar tmp=bas;
					while(tmp!=null) {
						if(ortalama()>50) {
							System.out.println("geçti");
						}
						else {
							System.out.println("kaldý");
						}
						
						tmp=tmp.ileri;
						
					}
						
				}
				
				
				void hesaplama() {
					Elemanlarlar tmp=bas;
					int a=0;
					for(int i=0;i<3;i++) {
						a=(int) (a+tmp.icerik*Math.pow(2, i));
						
						tmp=tmp.ileri;
						

						
					}
					System.out.println(a);	
					
					
				}
				
				
				
				
				public static void main(String[]args) {
					Elemanlarlar a=new Elemanlarlar(0);
					Elemanlarlar b1=new Elemanlarlar(1);
					Elemanlarlar c=new Elemanlarlar(1);
					Elemanlarlar d=new Elemanlarlar(1);
					bliste2 b=new bliste2();
					b.basaekle(a);
				b.basaekle(b1);
				b.basaekle(c);
				b.arayaekleme(d,2);
			//	b.sondansilme();
				
			System.out.println(	b.arama(25));
				b.tum();
				b.hesaplama();
			//	System.out.println(b.ortalama());
			//	b.gecenkalan();
				
				}
				
				
				
				}
					
					
					
				
				
				
			

		