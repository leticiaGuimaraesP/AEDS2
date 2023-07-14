package Nivelamento;

import java.util.Scanner;

class Ex14Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        System.out.println("Tamnho do array: ");
        int n = leia.nextInt();
        int numeros[] = new int[n];
        int cont = 0, pares=0, divisiveis3=0;     

        while(cont<n){
            System.out.println("Digite um numero: ");
            numeros[cont] = leia.nextInt();
            if(numeros[cont]%2==0){
                pares++;
            }
            if(numeros[cont]%3==0){
                divisiveis3++;
            }
            cont++;
        }
        System.out.println("Pares: "+pares);
        System.out.println("Divisiveis por 3: "+divisiveis3);
        leia.close();
    }
}