package Nivelamento;

import java.util.Scanner;

class Ex26Strings {
    public static void main (String[] args){
        Scanner leia = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String str = leia.nextLine();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='A'){
                System.out.println("Posiçao do primeiro A = "+i);
            }
        }
        leia.close();
    }
}
