package Nivelamento;

import java.util.Scanner;

class Ex23Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        int linhas=0;
        System.out.println("Digite a quantidade de linhas: ");
        linhas = leia.nextInt();

        int matriz[][] = new int[linhas][linhas];

        for(int l=0; l<linhas; l++){
            for(int j=0; j<linhas; j++){
                System.out.println("Digite um numero ");
                matriz[l][j] = leia.nextInt();
            }
        }

        for(int l=0; l<linhas; l++){
            for(int j=0; j<linhas; j++){
                if(l==j){
                     System.out.print(" "+matriz[l][j]);
                }
            }
        }
        leia.close();
    }
}