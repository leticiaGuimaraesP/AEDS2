package Nivelamento;

import java.util.Scanner;

class Ex11Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        System.out.println("Tamnho do array: ");
        int n = leia.nextInt();

        int notas[] = new int[n];
        int cont = 0;
        double media = 0;
        
        while(cont<n){
            System.out.println("Digite a nota: ");
            notas[cont] = leia.nextInt();
            media += notas[cont];
            cont++;
        }
        media = media/n;
        System.out.println("Media = "+ media);

        for(int i=0; i<n; i++){
            if(notas[i]>=media){
                System.out.println(notas[i]);
            }
        }
        
        leia.close();
    }
}