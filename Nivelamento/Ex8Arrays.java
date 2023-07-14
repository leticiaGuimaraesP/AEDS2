package Nivelamento;

import java.util.Scanner;

class Ex8Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        System.out.println("Digite o tamanho do array: ");
        int n = leia.nextInt();
        int array[] = new int[n];
        int menor, aux;
        
        for(int i=0; i<n; i++){
            System.out.println("Digite um numero ");
            array[i] = leia.nextInt();
        }

        for(int i=0; i<n-1; i++){
            menor=i;
            for(int j=i+1; i<n; j++){
                if(array[menor]>array[j]){
                    menor=j;
                }
            }
            aux=array[menor];
            array[menor]=array[i];
            array[i]=aux;
        }
        leia.close();
    }
}
