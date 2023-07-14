package RevisãoP2;
import java.util.Scanner;

public class MaxFotografo {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        int teste = Integer.parseInt(leia.nextLine());
        for(int i=0; i<teste; i++){
            boolean validou = true;
            int nPessoas = Integer.parseInt(leia.next());
            int diferenca = Integer.parseInt(leia.next());
            int[] altura = new int[2*nPessoas];
            for(int j=0; j<2*nPessoas; j++){
                altura[j] = Integer.parseInt(leia.next());
            }
            for(int j=0; j<nPessoas && validou; j++){
                //System.out.println(j + nPessoas);
                int result = altura[j+nPessoas]-altura[j];
                //System.out.println(result);
                if(result<diferenca){
                    validou = false;
                }   
            }
            if(validou){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }
        }
    }
}
