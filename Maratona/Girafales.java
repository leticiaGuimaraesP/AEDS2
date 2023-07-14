package RevisãoP1;

import java.util.*;
public class Girafales {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        String[] nomes = new String[10];
        String[] assinaturas = new String[10];
        String[] entrada1 = new String[10];
        String[] entrada2 = new String[10];
        int n1, n2, cont=0;

        do{
            n1=leia.nextInt();
            if(n1!=0){
                for(int i=0; i<n1; i++){
                    nomes[i]=leia.next();
                    assinaturas[i]=leia.next();
                }
                n2=leia.nextInt();
                for(int i=0; i<n2; i++){
                    entrada1[i]=leia.next();
                    entrada2[i]=leia.next();
                }
    
                for(int i=0; i<n2; i++){
                    for(int x=0; x<n1; x++){
                        if(entrada1[i].equals(nomes[x])){
                            if(!entrada2[i].equals(assinaturas[x])){
                                System.out.println(entrada2[i]+" "+assinaturas[x]);
                                cont++;
                                x=n1;
                            }
                        }
                    }
                }
                System.out.println(cont);
                cont=0;
            }
        }while(n1!=0);
        leia.close();
    }
}
