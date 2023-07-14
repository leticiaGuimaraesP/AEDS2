package Nivelamento;

import java.util.Scanner;

class Ex6Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        System.out.println("Quantos numeros serao digitados: ");
        int n = leia.nextInt();
        int array[] = new int[n];
        int cont=0;
        double media=0;

        while(cont<n){
            System.out.println("Digite um numero ");
            array[cont] = leia.nextInt();
            media += array[cont];
            cont++;
        }
        media = media/n;

        for(int i=0; i<n; i++){
            if(array[i]>=media){
                System.out.println(array[i]);
            }
        }
        leia.close();
    }
}
