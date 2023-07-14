package Maratona;
import java.util.Scanner;

public class StackGame {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        int entrada;
        do{
            entrada = Integer.parseInt(leia.nextLine());
            if(entrada==0){
                break;
            }
            int soma1=0, soma2=0, soma3=0, soma4;

            boolean[] resp = new boolean[entrada];
            for(int i=0; i<entrada; i++){
                resp[i] = false;
                String entrada2 = leia.nextLine();
                soma1 = Character.digit(entrada2.charAt(0), 10) + Character.digit(entrada2.charAt(2), 10) + Character.digit(entrada2.charAt(4), 10)  ;
                soma2 = Character.digit(entrada2.charAt(0), 10) + Character.digit(entrada2.charAt(2), 10);
                soma3 = Character.digit(entrada2.charAt(4), 10) + Character.digit(entrada2.charAt(2), 10);
                soma4 = Character.digit(entrada2.charAt(0), 10) + Character.digit(entrada2.charAt(4), 10);
                System.out.println(soma1);
                System.out.println(soma2);
                System.out.println(soma3);
                System.out.println(soma4);
               
                if(soma1%3==0||soma2%3==0||soma3%3==0||soma4%3==0){
                    if(soma1>=3||soma2>=3||soma3>=3||soma4>=3){ //não validar 0%3=0
                        resp[i] = true;
                    }
                }
            }
            boolean validou = true; //se em todas as linhas forem true, valida a resposta
            for(int i=0; i<entrada; i++){
                if(resp[i]==false){
                    validou = false;
                }
            }
            System.out.println(validou);
        }while(entrada!=0);
        leia.close();
    }
}
