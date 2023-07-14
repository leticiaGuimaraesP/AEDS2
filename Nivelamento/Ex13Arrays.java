package Nivelamento;

import java.util.Scanner;

class Ex13Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        System.out.println("Tamnho do array: ");
        int n = leia.nextInt();
        int menor=10000, posi=0;

        int numeros[] = new int[n];
        int cont = 0;        
        while(cont<n){
            System.out.println("Digite um numero: ");
            numeros[cont] = leia.nextInt();
            if(numeros[cont]<=menor){
                posi=cont;
            }
            cont++;
        }
        System.out.println("Posiçao do mneor valor: "+posi);
        leia.close();
    }
}