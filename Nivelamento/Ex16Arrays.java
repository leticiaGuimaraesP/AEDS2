package Nivelamento;

import java.util.Scanner;

class Ex16Arrays {
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

        System.out.println("Divisiveis por 3: ");
        for(int i=0; i<n; i++){
            if(numeros[i]%3==0){
                System.out.println(numeros[i]);
            }
        }
        leia.close();
    }
}