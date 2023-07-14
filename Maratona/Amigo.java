package RevisãoP2;
import java.util.*;

public class Amigo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pessoa = new String[100];
        int n =0;
        do{
            pessoa[n] = sc.nextLine();
        }while(isEnd(pessoa[n++]) == false);
        n--;

        String[]validos = new String[n];
        String[]invalidos = new String[n];

        int x=0, y=0;

        for(int i=0; i<n;i++){
            String[] escolha = pessoa[i].split("\\s+");
            if(escolha[1].equals("YES")) validos[x++]=escolha[0];
            else if (escolha[1].equals("NO"))invalidos[y++]=escolha[0];
         }

         String venceu = validos[0];
         for(int i=1; i< x;i++){
             if(validos[i].length()>venceu.length())venceu = validos[i];
             //else if(validos[i].length()==venceu.length()) venceu = (validos[i].compareTo(venceu)<0)? validos[i]: venceu;
         }

         for(int i=0;i<x; i++){
            String nome = validos[i];
            for(int j=i+1;j<x-1;j++){
                if(validos[j].equals(nome)) validos[j]="";
            }
         }

         
         for(int i=0;i<y; i++){
            String nome = invalidos[i];
            for(int j=i+1;j<y-1;j++){
                if(invalidos[j].equals(nome)) invalidos[j]="";
            }
         }

         for (int i = 0; i < (x - 1); i++) {
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
        sc.close();
    }

    private static boolean isEnd(String s) {
        return (s.length()==3 && s.charAt(0) =='F' && s.charAt(1)=='I' && s.charAt(2)=='M');
    }
}