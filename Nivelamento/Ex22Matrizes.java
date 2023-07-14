package Nivelamento;

import java.util.Scanner;

class Ex22Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        int linhas=0, colunas=0;
        System.out.println("Digite a quantidade de linhas: ");
        linhas = leia.nextInt();
        System.out.println("Digite a quantidade de colunas: ");
        colunas = leia.nextInt();

        int matriz1[][] = new int[linhas][colunas];
        int matriz2[][] = new int[linhas][colunas];

        for(int l=0; l<linhas; l++){
            for(int j=0; j<colunas; j++){
                System.out.println("Digite um numero (matriz1): ");
                matriz1[l][j] = leia.nextInt();
            }
        }
        for(int l=0; l<linhas; l++){
            for(int j=0; j<colunas; j++){
                System.out.println("Digite um numero (matriz2): ");
                matriz2[l][j] = leia.nextInt();
            }
        }

        for(int l=0; l<linhas; l++){
            for(int j=0; j<colunas; j++){
                System.out.print(" "+matriz1[l][j]+matriz2[l][j]);
            }
            System.out.print("\n");
        }
        leia.close();
    }
}