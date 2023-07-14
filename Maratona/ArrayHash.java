package Maratona;
import java.util.Scanner;

public class ArrayHash {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        int teste = Integer.parseInt(leia.nextLine());
        for(int i=0; i<teste; i++){
            int n = Integer.parseInt(leia.nextLine());

            String[] array = new String[n];
            for(int k=0; k<n; k++){
                array[k] = leia.nextLine();
            }

            int soma=0;
            for(int j=0; j<n; j++){
                for(int x=0; x<array[j].length(); x++){
                    char c = array[j].charAt(x);
                    int pos=0;
                    if(c>='A'&&c<='Z'){
                        pos = c-65;
                    }else{
                        pos = c-97;
                    }
                    soma += pos + i +j;
                }
           
            }
            System.out.println(soma);
        }
        leia.close();
    }
}
