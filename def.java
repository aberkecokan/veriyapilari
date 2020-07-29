package veriyapilari;

class elemanlar{
	int sayi;
	eleman ileri;
	
		eleman(int sayi){
			this.sayi=sayi;
			ileri = null;
		}
		
	
	
	
}
public class def {

eleman bas;
eleman son;

public def(){
bas=null;
son=null;
}
void Basaekle(eleman yeni) {
	if(son==null) {
		bas=yeni;
		son=yeni;
			
	}else {
	yeni.ileri=bas;
	bas=yeni;
	}
}
void Sonaekle(eleman yeni) {
	if(bas == null) {
		son=yeni;
		bas=yeni;
	}else {
		yeni.ileri=son;
		son=yeni;
		
			}
		}
	void tum() {
		eleman tmp=bas;
		String s="";
		while(tmp!=null) {
			System.out.println(tmp.sayi);
			tmp.ileri=tmp;
		
			
		}
		
		
	}
	
public static void main(String []args) {
	eleman b=new eleman(8);
	def a=new def();
	a.Basaekle(b);
//	a.tum();
	
	
}

	}




