package Nivelamento;

import java.util.Scanner;

class Ex25Strings {
    public static void main (String[] args){
        Scanner leia = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String str = leia.nextLine();

        System.out.println("Tamanho = "+str.length());
        int cont=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                cont++;
            }
        }
        System.out.println("Quantidade de caracteres maiusculos = "+cont);
        leia.close();
    }
}
