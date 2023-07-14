package RevisãoP2;
import java.util.Scanner;

public class FigurinhasRepetidas {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        int qtde = Integer.parseInt(leia.nextLine());
        int[] figurinhas = new int[qtde];
        for(int i=0; i<qtde; i++){
            figurinhas[i] = Integer.parseInt(leia.nextLine());
        }
        int cont=0, contD=0, contR=0;
        for(int i=0; i<qtde; i++){
            for(int j=0; j<qtde; j++){
                if(figurinhas[i] == figurinhas[j]){
                    cont++;
                }     
            }
            if(cont>1){
                contR++;
            }
            cont=0;
        }
        contD=qtde-contR;
        System.out.println("repetidos: "+contR);
        System.out.println("diferentes: "+contD);
    }
}
