package Maratona;
import java.util.Scanner;

public class Sanduiche {

    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        while(leia.hasNextLine()){
            Boolean validou = true;
            String entrada = leia.nextLine();
            String saida=entrada;
            for(int i=0; i<entrada.length(); i++){
                for(int j=i+1; j<entrada.length(); j++){
                    if(entrada.charAt(i)==entrada.charAt(j)){
                        int aux = i+1;
                        for(int k=j+1; k<entrada.length() && aux<j; k++, aux++){
                            if(entrada.charAt(aux)!=entrada.charAt(k)){
                                validou = false;
                                k = entrada.length();
                            }
                        }
                        if(validou){
                            saida = entrada.substring(0, j);
                            i = j = entrada.length();
                        }else{
                            validou = false;
                        }
                    }
                }
            }
            System.out.println(saida);
        }
        leia.close();
    }
}
