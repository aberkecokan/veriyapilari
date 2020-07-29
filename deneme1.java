package veriyapilari;


	class ornek {
		int max;
		int top;
		int[]a;
		int sayac=0;	
	public ornek(int max) {
		top=-1;
		this.max=max;
		a=new int[max];
		
	}
	boolean isEmpty() {
		return (top<0);
		
	}
	void ekle(int x) {
		if(top>= max) {
			System.out.println("Boyut Aþýmý");
			
		}
		else {
			a[++top]=x;
			sayac++;
		}
	}
	
	int sil() {
		if(top<0) {
			System.out.println("Boyut Aþýmý");
		return 0;
		}else {
			int x=a[top--];
			sayac--;
			return x;
		}
	
	}
	int tepe() {
		return a[top];
		
	}
	void goster() {
		int y;
		for(int i=0;i<=top;i++) {
			y=a[i];
			System.out.println(y);
			
		}
	
		
	}
		
	}

public class deneme1 {
			public static void main(String[]args) {
				ornek d=new ornek(10);
				d.ekle(5);
				d.ekle(10);
				d.ekle(8);
				d.ekle(7);
				d.ekle(12);
				
				//System.out.println(d.tepe()+"silinen");
				 d.sil();
				//System.out.println(d.tepe());
				d.goster();
			}
}
