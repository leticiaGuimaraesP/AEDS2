package Maratona;
import java.util.Scanner;

public class ListaTelefonica {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        while(leia.hasNext()){
            int n = Integer.parseInt(leia.nextLine());
            String[] entrada = new String[n];
            for(int i=0; i<n; i++){
                entrada[i] = leia.nextLine();
            }

            int cont1=0, cont2=0, cont=0;
            for(int i=1; i<n; i++){
                for(int j=0; j<entrada[i].length(); j++){
                    if(entrada[i].charAt(j)==entrada[i-1].charAt(j)){
                        cont1++;
                        System.out.println(entrada[i].charAt(j)+" "+cont1);
                    }
                    if(i>1){
                        if(entrada[i].charAt(j)==entrada[i-2].charAt(j)){
                            cont2++;
                        }
                        cont=cont1-cont2;  
                    }else{
                        cont=cont1;
                    }  
                }
                if(n>2){
                    cont += cont;
                }
            }
            System.out.println(cont);
        }
        leia.close();
        /*Scanner leia = new Scanner(System.in);
        while(leia.hasNext()){
            int n = Integer.parseInt(leia.nextLine());
            String[] entrada = new String[n];
            for(int i=0; i<n; i++){
                entrada[i] = leia.nextLine();
            }

            int cont=0, pos=0;
            for(int i=0; i<n-1; i++){
                for(int j=i+pos; j<entrada[i].length(); j++){
                    if(entrada[i+1].charAt(j)==entrada[i].charAt(j)){
                        cont++;
                        pos = j;
                    }
                }
            }
            System.out.println(cont);
        }
        leia.close();*/
    }
}
