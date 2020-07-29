package veriyapilari;


	class Elemanlar{
		
		String numara;
		String ad;
		String soyad;
		String sinif;
		Elemanlar ileri;
		Elemanlar ileri2;
		
			public Elemanlar(String numara,String ad,String soyad,String sinif){
				
				this.numara=numara;
				this.ad=ad;
				this.soyad=soyad;
				this.sinif=sinif;
				ileri=null;
				ileri2=null;
							}
			
			
	}

	public class odev2 {
	
		Elemanlar bas;
		
			Elemanlar son;
		
			odev2(){
				bas=null;
				son=null;
			}
			
			void sonaekleme(Elemanlar yeni) {
					if(bas==null) {
						bas=yeni;
						son=yeni;
						
					}else {
						
						son.ileri=yeni;
						yeni=son;
						
						
					}
			}
	
			void sonaekleme2(Elemanlar yeni) {
				if(bas==null) {
					bas=yeni;
					son=yeni;
				}
				else {
					son.ileri2=yeni;
					yeni=son;
					
				}
				
				
			}
			void tum() {
				Elemanlar tmp=bas;
				Elemanlar tmp2=bas;
				String b="";
				String c="1";
				while(tmp.ileri!=null) {
					b=tmp.ad+" ";
					
				}
				while(tmp.ileri2!=null) {
					c=tmp.ad+" ";
				}
				System.out.println("1. Baðlý Liste"+b);
				System.out.println("2. Baðlý Liste"+c);
				
			}
			
			public static void main(String[]args) {
				odev2 b=new odev2();
				Elemanlar a=new Elemanlar("175","Ahmet","Cokan","2");
				b.sonaekleme(a);

				b.tum();
				
				
				
			}
			
			
}
	
