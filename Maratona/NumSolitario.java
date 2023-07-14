package RevisãoP1;

import java.util.*;

public class NumSolitario {
    public static void numSolitario(String str){
        int cont=0;
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<str.length(); j++){
                if(str.charAt(i)==str.charAt(j)){
                    cont++;
                }
            }
            if(str.length()>1){//desconsiderar os vetores que possuem so um numero
                if(cont%2!=0){
                    System.out.println(str.charAt(i));
                    break;
                }
            }
            cont=0;
        }
    }

    public static boolean isFim(String str){
        if(str.length()==1 && str.charAt(0)=='0'){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        String[] entrada = new String[1000];
        int numEntrada=0;
  
        do{
            entrada[numEntrada]=leia.nextLine(); //o leia.next() so lê ate o primeiro espaço
        }while(isFim(entrada[numEntrada++])==false);
        numEntrada--;

        for(int i=0; i<numEntrada; i++){
            numSolitario((entrada[i]));
        }
        leia.close();
    }
}
