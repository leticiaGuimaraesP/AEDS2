package Nivelamento;

import java.util.Scanner;

class Ex15Arrays {
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
        for(int i=0; i<n; i++){
            System.out.println(numeros[i]+numeros[n-1-i]);
        }
        leia.close();
    }
}