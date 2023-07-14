/*package Nivelamento;

import java.util.Scanner;

class Ex26Strings {
    public static void main (String[] args){
        Scanner leia = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String str = leia.nextLine();

        int caracteres = str.length();
        int contL=0, contNL=0, contC=0, contV=0;
        for(int i=0; i<str.length(); i++){
            if((str.charAt(i)>='A'&&str.charAt(i)<='Z')||(str.charAt(i)>='a'&&str.charAt(i)<='z')){
                contL++;
                if(str.charAt(i)=='A'||str.charAt(i)=='E'||str.charAt(i)=='I'||str.charAt(i)=='O'||str.charAt(i)=='U'||
                str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                    contV++;
                }else{
                    contC++;
                }
            }else{
                contNL++;
            }
        }

        System.out.println("Caracteres = "+caracteres);
        System.out.println("Nao Letras = "+contNL);
        System.out.println("Letras = "+contL);
        System.out.println("Vogais = "+contV);
        System.out.println("Consoantes = "+contC);
        leia.close();
    }
}*/