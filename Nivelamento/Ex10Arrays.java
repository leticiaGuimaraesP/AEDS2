package Nivelamento;

import java.util.Scanner;

class Ex10Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        double notas[] = new double[5];
        int cont = 0;
        double mediaAlunos = 0, soma = 0, menor = 1000;
        
        while(cont<5){
            System.out.println("Digite a nota: ");
            notas[cont] = leia.nextDouble();
            soma += notas[cont];
            cont++;
        }

        for(int i=0; i<5; i++){
            if(notas[i]<menor){
                menor=notas[i];
            }
        }
        
        mediaAlunos = soma/20;
        System.out.println("Soma = "+ soma);
        System.out.println("Media = "+ mediaAlunos);
        System.out.println("Menor nota = "+ menor);
        leia.close();
    }
}