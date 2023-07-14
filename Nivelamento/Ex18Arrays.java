/*package Nivelamento;

import java.util.Scanner;

class Ex17Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        System.out.println("Tamnho do array: ");
        int n = leia.nextInt();
        System.out.println("Tamnho do array: ");
        int m = leia.nextInt();
        int num1[] = new int[n];
        int num2[] = new int[m];
        int cont = 0;

        while(cont<n){
            System.out.println("Digite um numero (array1): ");
            num1[cont] = leia.nextInt();
            cont++;
        }

        cont=0;
        while(cont<m){
            System.out.println("Digite um numero (array2): ");
            num2[cont] = leia.nextInt();
            cont++;
        }
        if(n>m){
            for(int j=0; j<m; j++){
                System.out.println(num1[j]);
                System.out.println(num2[j]);
            }
            for(int i=m; i<n; i++){
                System.out.println(num1[i]);
            }
        }else{
            for(int j=0; j<m; j++){
                System.out.println(num1[j]);
                System.out.println(num2[j]);
            }
            for(int i=m; i<n; i++){
                System.out.println(num2[i]);
            }
        }
       
        leia.close();
    }
}*/