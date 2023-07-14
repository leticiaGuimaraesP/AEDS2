package Nivelamento;

import java.util.Scanner;

class Ex21Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        int linhas=0, colunas=0;
        System.out.println("Digite a quantidade de linhas: ");
        linhas = leia.nextInt();
        System.out.println("Digite a quantidade de colunas: ");
        colunas = leia.nextInt();

        int matriz[][] = new int[linhas][colunas];

        for(int l=0; l<linhas; l++){
            for(int j=0; j<colunas; j++){
                System.out.println("Digite um numero ");
                matriz[l][j] = leia.nextInt();
            }
        }

        for(int l=0; l<linhas; l++){
            for(int j=0; j<colunas; j++){
                System.out.print(" "+matriz[j][l]);
            }
            System.out.print("\n");
        }
        leia.close();
    }
}