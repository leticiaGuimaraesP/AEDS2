package Nivelamento;

import java.util.Scanner;

class Ex3While {
    public static void main (String[] args){
        Scanner leia = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int num = leia.nextInt();
        int cont = 0;
        int aux = 1;

        while(cont<num){
            if(cont%2!=0){
                System.out.println(aux);
                aux += 7;
            }else{
                System.out.println(aux);
                aux += 4;
            }
            cont++;
        }
        leia.close();
    }
}
