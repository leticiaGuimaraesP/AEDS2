package Nivelamento;

import java.util.Scanner;

class Ex9Arrays {
    public static void main (String[] args){
        Scanner leia = new Scanner (System.in);

        int array[] = {10, 5, 8, 2, 8};
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }

        leia.close();
    }
}
