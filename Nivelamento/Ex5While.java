package Nivelamento;

import java.util.Scanner;

class Ex5While {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        System.out.println("Nota max: ");
        int notaMax = leia.nextInt();

        int notas[] = new int[20];
        int cont = 0;
        double mediaAlunos = 0;
        double mediaNotas = notaMax*0.60;
        int alunosReprovados = 0;
        
        while(cont<20){
            System.out.println("Digite a nota: ");
            notas[cont] = leia.nextInt();
            mediaAlunos += notas[cont];
            if(notas[cont]<=mediaNotas){
                alunosReprovados++;
            }
            cont++;
        }
        mediaAlunos = mediaAlunos/20;
        System.out.println("Media = "+ mediaAlunos +" Total de alunos reprovados = "+ alunosReprovados);
        leia.close();
    }
}
