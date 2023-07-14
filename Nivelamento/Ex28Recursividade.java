package Nivelamento;

import java.util.Scanner;

class Ex28Recursividade {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        System.out.println("Digite um numero: ");
        int num = leia.nextInt();
        System.out.println(metodo1(num));

        leia.close();
    }

    public static int metodo1(int num){
        int result; 
        if(num==0){
            return 1;
        }else{
            result = (int) Math.pow(metodo1(num-1),2);
            return result;
        }
    } 
}
