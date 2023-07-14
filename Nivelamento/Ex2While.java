package Nivelamento;

import java.util.Scanner;

class Ex2While {
    public static void main (String[] args){
        Scanner leia = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int cont = leia.nextInt();
        int num = 1;

        while(cont>0){
            System.out.println(num);
            num += 2;
            cont--;
        }
        leia.close();
    }
}
