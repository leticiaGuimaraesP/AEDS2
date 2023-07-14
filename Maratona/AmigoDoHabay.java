package RevisãoP2;
import java.util.Scanner;

public class AmigoDoHabay {
    public static boolean isFim(String entrada){
        boolean terminou = false;
        if(entrada.charAt(0)=='F' && entrada.charAt(0)=='I' && entrada.charAt(0)=='M'){
            terminou = true;
        }
        return terminou;
    }
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        
        String[] pessoa = new String[100];
        String[] escolha = new String[100];
        String teste;
        int n=0;
        do{
            pessoa[n] = leia.next();
            
            escolha[n] = leia.next();
        }while(isFim(pessoa[n++]) == false);
        n--;

        String[]validos = new String[n];
        String[]invalidos = new String[n];

        //controlador dos novos vetores;
        int x=0, y=0;

        for(int i=0; i<n; i++){
            if(escolha[i].compareTo("YES")==0){
                validos[x++]=escolha[0];
            }else{
                invalidos[y++]=escolha[0];
            }
            //System.out.println(escolha[i] +" - "+ pessoa[i]);
        }

         String venceu = validos[0];
         for(int j=1; j<x; j++){ 
            if(validos[j].length()>venceu.length()){
                venceu = validos[j];
            }else if(validos[j].length()==venceu.length()){
                if(validos[j].compareTo(venceu)<0){
                    venceu = validos[j];
                }
            }
         }

         //noems iguais 
         for(int k=0; k<x;k++){
            for(int j=k+1; j<x-1; j++){
                if(validos[k].equals(validos[j])){
                    validos[j]="";
                }
            }
         }

        //ordenação
         for (int i=0; i<(x-1); i++) {
            int menor = i;        
            for (int j = (i + 1); j < x; j++){         
                if (validos[menor].compareTo(validos[j]) > 0){           
                  menor = j;         
                }       
            }        
            String temp = validos[menor];
            validos[menor] = validos[i];
            validos[i] = temp;
        }

           //ordenação
        for (int i = 0; i < (y - 1); i++) {
            int menor = i;        
            for (int j = (i + 1); j < y; j++){         
                if (invalidos[menor].compareTo(invalidos[j]) > 0){           
                  menor = j;         
              }       
            }        
            String temp = invalidos[menor];
            invalidos[menor] = invalidos[i];
            invalidos[i] = temp;
        }

        //impressão
        for(int i=0; i< x;i++){
            if(validos[i].equals("")==false)
            System.out.println(validos[i]);
        }
        for(int i=0; i< y;i++){
            if(invalidos[i].equals("")==false)
            System.out.println(invalidos[i]);
        }
        System.out.println();
        System.out.print("Amigo do Habay:\n" + venceu);
        
        leia.close();
    }
}

