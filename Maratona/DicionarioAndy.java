package Maratona;
import java.util.Scanner;

public class DicionarioAndy {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        String entrada = "";
        while(leia.hasNext()){
            String palavra = leia.next();
            palavra = transformaPalavra(palavra); //elimina os carcteres inuteis
            entrada += palavra+" ";   
        }

        //separa a String 
        String[] palavras = entrada.split(" ");
        
        //ordena o vetor 
        for (int i=0; i<(palavras.length-1); i++) {
            int menor = i;
            for (int j = (i + 1); j < palavras.length; j++){
               if (palavras[menor].compareTo( palavras[j]) > 0){
                  menor = j;
               }
            }
            String tmp = palavras[menor];
            palavras[menor] = palavras[i];
            palavras[i] = tmp;
        }
        //Arrays.sort(palavras);
            
        //elimina as palavras já existentes
        boolean repete = false;
        for(int i=0; i<palavras.length; i++){
            for(int j=i+1; j<palavras.length; j++){
                if(palavras[i].compareTo(palavras[j])==0){
                    repete = true;
                    j=palavras.length;
                }        
            } 
            if(!repete){
                System.out.println(palavras[i]);
            }else{
                repete=false;
            }  
        }
        leia.close();
    }
    public static String transformaPalavra(String str){
        String resp = "";
        for(int i=0; i<str.length(); i++){
            if((str.charAt(i)>='a'&&str.length()<='z')||(str.charAt(i)>='A'&&str.length()<='Z')){
                resp+=str.charAt(i);
            }
        }
        resp = resp.toLowerCase();
        return resp;
    }
}