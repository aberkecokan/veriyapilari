package veriyapilari;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


class Eleman{
        int sayi;
        Eleman(int sayi){
            this.sayi=sayi;
        }
    }



    class odev4{
         int bas,son,elemansayisi,ikincison;
         int [][]d;
         int n;
        private static final int matris1=10;
        private static final int matris2=10;
        
         public odev4(int n){
        this.n=n;
        d=new int[n][n];
        bas=0;
        son=0;
        ikincison=0;
        elemansayisi=0;
    }
         boolean bosmu(){
        return elemansayisi==0;
    }
    boolean dolumu(){
        return elemansayisi==n;
    }
    public void ekle(int yeni){
        if(dolumu()){
            System.out.println("Dolu");
        }
        else{
          
            d[son][ikincison]=yeni;
            ikincison++;
            if(ikincison==10){
                ikincison=0;
                son++;
                elemansayisi++;
            }
        }
        
        
    }
    
     public void goster(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
          
                System.out.print(d[i][j]);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        private static boolean gidilebirmi(int mat[][],int gidilenmatris[][],int x,int y){
                
            return!(mat[x][y]==0  || gidilenmatris[x][y]!=0  );
            
        }
        
        private static boolean gecerlidegermi(int x,int y){
            return(x<matris1 && y<matris2 && x>=0 && y>=0 );
            
        
        }
        
            public static int enkisayolubulma(int mat[][],int gidilenmatris[][],int baslangic1, int baslangic2, int gidilecekdeger1, int gidilecekdeger2, int min_dist, int dist){
                
                if(baslangic1==gidilecekdeger1 && baslangic2==gidilecekdeger2){
                    return Integer.min(dist,min_dist);
                }
                gidilenmatris[baslangic1][baslangic2]=1;
                //aþaðý gitme
                if(gecerlidegermi(baslangic1+1,baslangic2) && gidilebirmi(mat,gidilenmatris,baslangic1+1,baslangic2)){
                    min_dist=enkisayolubulma(mat,gidilenmatris,baslangic1+1,baslangic2,gidilecekdeger1,gidilecekdeger2,min_dist,dist+1);
                    
                }
                //saða gitme
                if(gecerlidegermi(baslangic1,baslangic2+1) && gidilebirmi(mat,gidilenmatris,baslangic1,baslangic2+1)){
                    min_dist=enkisayolubulma(mat,gidilenmatris,baslangic1,baslangic2+1,gidilecekdeger1,gidilecekdeger2,min_dist,dist+1);
                }
                //yukarý gitme
                if(gecerlidegermi(baslangic1-1,baslangic2) && gidilebirmi(mat,gidilenmatris,baslangic1-1,baslangic2)){
                    min_dist=enkisayolubulma(mat,gidilenmatris,baslangic1-1,baslangic2,gidilecekdeger1,gidilecekdeger2,min_dist,dist+1);
                    
                }
                //sola gitme
                if(gecerlidegermi(baslangic1,baslangic2-1) && gidilebirmi(mat,gidilenmatris,baslangic1,baslangic2-1)){
                    min_dist=enkisayolubulma(mat,gidilenmatris,baslangic1,baslangic2-1,gidilecekdeger1,gidilecekdeger2,min_dist,dist+1);
                } 
                
                //ziyaret eden matrisi kaldýrma
                gidilenmatris[baslangic1][baslangic2]=0;
                return min_dist;
                
            }
            public static void main(String[] args) {
            
                int matrisim[][]={
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
		};
                odev4 d=new odev4(10);
                d.ekle(1);
                d.ekle(1);
                d.ekle(1);
                d.ekle(1);
                d.ekle(1);
                d.ekle(0);
                d.ekle(0);
                d.ekle(1);
                d.ekle(1);
                d.ekle(1);
                d.ekle(0);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(0);d.ekle(1);d.ekle(0);d.ekle(1);
                d.ekle(0);d.ekle(0);d.ekle(1);d.ekle(0);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(0);d.ekle(0);d.ekle(1);
                d.ekle(1);d.ekle(0);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(0);d.ekle(1);d.ekle(1);d.ekle(0);d.ekle(1);
                d.ekle(0);d.ekle(0);d.ekle(0);d.ekle(1);d.ekle(0);d.ekle(0);d.ekle(0);d.ekle(1);d.ekle(0);d.ekle(1);
                d.ekle(1);d.ekle(0);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(0);d.ekle(0);d.ekle(1);d.ekle(1);d.ekle(0);
                d.ekle(0);d.ekle(0);d.ekle(0);d.ekle(0);d.ekle(1);d.ekle(0);d.ekle(0);d.ekle(1);d.ekle(0);d.ekle(1);
                d.ekle(0);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(0);d.ekle(0);
                d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(1);d.ekle(0);d.ekle(0);d.ekle(1);d.ekle(1);d.ekle(1);
                d.ekle(0);d.ekle(0);d.ekle(1);d.ekle(0);d.ekle(0);d.ekle(1);d.ekle(1);d.ekle(0);d.ekle(0);d.ekle(1);
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                int gezicimatris[][]=new int[matris1][matris2];
                int min_dist=enkisayolubulma(matrisim,gezicimatris,0,0,7,5,Integer.MAX_VALUE,0);
                if(min_dist!=Integer.MAX_VALUE){
                    System.out.println("Gidebileceðimiz En Kýsa Yol:"+min_dist);
                    
                }else{
                    System.out.println("Hedefe Kaynaktan Eiþilemiyor");
                }
        }
        
    }
    
    
