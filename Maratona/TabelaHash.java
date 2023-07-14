package Maratona;
import java.util.Scanner;

public class TabelaHash {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        int testes = Integer.parseInt(leia.nextLine());
        for(int i=0; i<testes; i++){
            
            String varControle = leia.nextLine();
            String[] controle = varControle.split(" ");
            int tam = Integer.parseInt(controle[0]);
            int n = Integer.parseInt(controle[1]);

            String valores = leia.nextLine();
            String[] numeros = valores.split(" ");

    
            for(int j=0; j<tam; j++){
                System.out.print(j+" ");
                for(int x=0; x<n; x++){
                    int pos = h(numeros[x], tam);
                    if(pos==j){
                        System.out.print("-> "+numeros[x]+" ");
                    }
                }
                System.out.println("\\");
            }
        }
        leia.close();
    }
    public static int h(String elemento, int x){
        int y = Integer.parseInt(elemento);
        return y%x;
    }
}