package Nivelamento;

import java.util.Scanner;

class Ex12Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        System.out.println("Tamnho do array: ");
        int n = leia.nextInt();

        int numeros[] = new int[n];
        int cont = 0;        
        while(cont<n){
            System.out.println("Digite um numero: ");
            numeros[cont] = leia.nextInt();
            cont++;
        }
        if(n%2==0){
            for(int i=0; i<n; i+=2){
                System.out.println(numeros[i]+numeros[i+1]);
            }
        }
        leia.close();
    }
}