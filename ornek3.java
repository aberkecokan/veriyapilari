package veriyapilari;


	class ogrenci{
		int no;
		String ad;
		int vize,genel;
		
		public ogrenci(int no,String ad,int vize,int genel) {
		//THÝS üstteki deðiþkene atýlmasý	
			this.no=no;
			this.ad=ad;
			this.vize=vize;
			this.genel=genel;
			
			
			
		}
		double notortalamasi() {
			return vize*0.4+genel*0.6;
			
		}
		
		
		
		String gecmedurumu() {
			if(notortalamasi()>=50) {
				return "Geçti";
				
				
			}
			else {
				return "kaldi";
			}
			
		}
		public String toString() {
			return no+" "+ad+" "+vize+" "+genel;
			
		}
	
	
	}
	



public class ornek3 {

		public static void main(String[]args) {
			ogrenci[] liste=new ogrenci[3];
			liste[0]=new ogrenci(1,"Ali KENAN",50,60);
			liste[1]=new ogrenci(2,"Ayþe DEMÝR",30,45);
			liste[2]=new ogrenci(3,"Burak SUNAR",70,55);
	//		System.out.println(liste[0]+" "+liste[0].notortalamasi()+" "+liste[0].gecmedurumu());
		//	for(ogrenci o:liste) {
				
			//	System.out.println(o+"/t"+o.notortalamasi()+"/t"+o.gecmedurumu());
				for(int i=0;i<3;i++) {
					System.out.println(liste[i].toString()+" "+liste[i].notortalamasi()+" "+liste[i].gecmedurumu());
			}
		}
	
}
