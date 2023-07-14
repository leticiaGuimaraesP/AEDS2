package Maratona;
import java.util.Scanner;

public class PegadinhaEvergreen {
    public boolean isFim(String str){
        boolean validou=false;
        if(str.charAt(0)=='F' && str.charAt(0)=='I' && str.charAt(0)=='F' && str.length()==3){
            validou = true;
        }
        return validou;
    }
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        int teste;
        teste = Integer.parseInt(leia.nextLine());
        for(int i=0; i<teste; i++){
            String entrada1 = leia.nextLine();
            String entrada2 = leia.nextLine();
            String  saida="";
            for(int j=0; j<entrada1.length(); j=j+2){
                if(j==entrada2.length()-1){
                    saida += entrada1.substring(j, j+2) + entrada2.substring(j, j+1);
                }else if(j==entrada1.length()-1){
                    saida += entrada1.substring(j, entrada1.length()) + entrada2.substring(j, entrada2.length());
                }else{
                    saida += entrada1.substring(j, j+2) + entrada2.substring(j, j+2);
                }
            }
            System.out.println(saida);
        }
        leia.close();
    }
}
