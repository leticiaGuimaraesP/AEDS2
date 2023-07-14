package Maratona;
import java.util.Scanner;

public class Telefone {
    public static String retornaNum(String str){
        String saida="";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                if(str.charAt(i)=='A'||str.charAt(i)=='B'||str.charAt(i)=='C'){
                    saida = saida + "2";
                }else if(str.charAt(i)=='D'||str.charAt(i)=='E'||str.charAt(i)=='F'){
                    saida = saida + "3";
                }else if(str.charAt(i)=='G'||str.charAt(i)=='H'||str.charAt(i)=='I'){
                    saida = saida + "4";
                }else if(str.charAt(i)=='J'||str.charAt(i)=='K'||str.charAt(i)=='L'){
                    saida = saida + "5";
                }else if(str.charAt(i)=='M'||str.charAt(i)=='N'||str.charAt(i)=='O'){
                    saida = saida + "6";
                }else if(str.charAt(i)=='P'||str.charAt(i)=='Q'||str.charAt(i)=='R'||str.charAt(i)=='S'){
                    saida = saida + "7";
                }else if(str.charAt(i)=='T'||str.charAt(i)=='U'||str.charAt(i)=='V'){
                    saida = saida + "8";
                }else if(str.charAt(i)=='W'||str.charAt(i)=='X'||str.charAt(i)=='W'||str.charAt(i)=='Z'){
                    saida = saida + "9";
                }
            }else if((str.charAt(i)>='0'&&str.charAt(i)<='9')||str.charAt(i)=='-'){
                saida = saida + str.charAt(i);
            }
        }
        return saida;
    }

    public static boolean isFim(String str){
        if(str.length()==3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        String[] entrada = new String[1000];
        int numEntrada = 0;


        do{
            entrada[numEntrada]=leia.nextLine();
        }while(isFim(entrada[numEntrada++])==false);
        numEntrada--;

        for(int i=0;i<numEntrada;i++){
            System.out.println(retornaNum(entrada[i]));
        }
        leia.close();
    }
}
