package Nivelamento;

import java.util.Scanner;

class Ex7Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        System.out.println("Quantos numeros serao digitados: ");
        int n = leia.nextInt();
        int array[] = new int[n];
        int menor=100000;
        int posiM=0;
        
        for(int i=0; i<n; i++){
            System.out.println("Digite um numero ");
            array[i] = leia.nextInt();
            if(array[i]<=menor){
                menor=array[i];
                posiM=i;
            }
        }
        System.out.println("O menor numero esta na posiçao "+posiM);
        leia.close();
    }
}
