package Nivelamento;

import java.util.Scanner;

class Ex4While {
    static long fibo(int n) {
        int F = 0;     
        int ant = 0;   
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                F = 1;
                ant = 0;
            } else {
                F += ant;
                ant = F - ant;
            }
        }
        return F;
    }

    public static void main (String[] args){
        Scanner leia = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int num = leia.nextInt();

        System.out.println(fibo(num));
        leia.close();
    
    }

}
