package Maratona;

import java.util.*;
public class QuadroMedalhas {
    public static void ordenarOuro(int n, String[] paises, int[] ouro, int[] prata, int[] bronze){
        String aux;
        int menor=0;
        
        for(int i=0; i<(n-1); i++){
            menor=i;
            for(int j=(i+1); j<n; j++){
                if(ouro[j]<ouro[menor]){
                    menor = j;
                } 
            }
            //organiando as medalhas de ouro
            ouro = trocar(ouro, i, menor);
            //organiando as medalhas de prata
            prata = trocar(prata, i, menor);
            //organiando as medalhas de bronze
            bronze = trocar(bronze, i, menor);
            //organiando os paises
            aux = paises[i];
            paises[i] = paises[menor];
            paises[menor] = aux;
        }

        
        for(int i=0; i<n; i++){
            if(ouro[i]==ouro[i+1]){
                if(prata[i]>prata[i+1]){
                    menor=i+1;
                    //organiando as medalhas de ouro
                    ouro = trocar(ouro, i, menor);
                    //organiando as medalhas de prata
                    prata = trocar(prata, i, menor);
                    //organiando as medalhas de bronze
                    bronze = trocar(bronze, i, menor);
                    //organiando os paises
                    aux = paises[i];
                    paises[i] = paises[menor];
                    paises[menor] = aux;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(ouro[i]==ouro[i+1] && prata[i]==prata[i+1]){
                if(bronze[i]>bronze[i+1]){
                    menor=i+1;
                    //organiando as medalhas de ouro
                    ouro = trocar(ouro, i, menor);
                    //organiando as medalhas de prata
                    prata = trocar(prata, i, menor);
                    //organiando as medalhas de bronze
                    bronze = trocar(bronze, i, menor);
                    //organiando os paises
                    aux = paises[i];
                    paises[i] = paises[menor];
                    paises[menor] = aux;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(ouro[i]==ouro[i+1] && prata[i]==prata[i+1] && bronze[i]==bronze[i+1]){
                if(paises[i].charAt(0)<paises[i+1].charAt(0)){
                    menor=i+1;
                    //organiando as medalhas de ouro
                    ouro = trocar(ouro, i, menor);
                    //organiando as medalhas de prata
                    prata = trocar(prata, i, menor);
                    //organiando as medalhas de bronze
                    bronze = trocar(bronze, i, menor);
                    //organiando os paises
                    aux = paises[i];
                    paises[i] = paises[menor];
                    paises[menor] = aux;
                }
            }
        }

        for(int j=n-1; j>=0; j--){
            System.out.println(paises[j]+" "+ouro[j]+" "+prata[j]+" "+bronze[j]);
        }
    }

    public static int[] trocar(int[] vetor, int i, int menor){
        int aux;
        aux = vetor[i];
        vetor[i] = vetor[menor];
        vetor[menor] = aux;
        return vetor;
    }
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        String[] pais = new String[100];
        int[] ouro = new int[100];
        int[] prata = new int[100];
        int[] bronze = new int[100];
        int n;
        
        n=leia.nextInt();
        for(int i=0; i<n; i++){
            pais[i]=leia.next();
            ouro[i]=leia.nextInt();
            prata[i]=leia.nextInt();
            bronze[i]=leia.nextInt();
        }
        ordenarOuro(n, pais, ouro, prata, bronze);
        leia.close();
    }
}
