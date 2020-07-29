/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veriyapilari;


class yigit{


    int[] dizi;
    int ust;
    int N;

    public yigit(int N) {
        this.N = N;
        dizi = new int[N];
        ust = -1;
    }

    boolean bosmu() {
        return ust == -1;
    }

    boolean dolumu() {
        return ust == (N - 1);
    }

    void ekle(int yeni) {
        if (!dolumu()) {
            ust++;
            dizi[ust] = yeni;
        }
    }

     int pop()
    {
    ust--;
    return dizi[ust];
    }

    
    
    

    
    	public static void main(String[]args) {
    		yigit a=new yigit(4);
    		yigit e=new yigit(2);
    		a.ekle(4);
    		a.ekle(2);
    		a.ekle(3);
    		
    		for(int i=0;i<2;i++) {
    			int b=a.pop();
    			e.ekle(b);
        		System.out.println(b);
        			
    		}
    		int q;
    		for(int i=0;i<2;i++) {
    			q=e.pop();
    			System.out.println(q+"   :2.ci baðlý liste");
    		}
    		
    		
    		
    	}
    	
    	
    	
    	
    	}
    
    
    
    





    



