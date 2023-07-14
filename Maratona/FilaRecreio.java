package RevisãoP2;
import java.util.Scanner;

public class FilaRecreio {
    
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        int teste = Integer.parseInt(leia.nextLine());
        for(int i=0; i<teste; i++){
            int qtdAlunos = leia.nextInt();
            int[] notas1 = new int[qtdAlunos];
            int[] notas2 = new int[qtdAlunos];
            for(int j=0; j<qtdAlunos; j++){
                notas1[j]=Integer.parseInt(leia.next());
                notas2[j]=notas1[j];
            }
            for(int k=1; k<qtdAlunos; k++){
                int tmp = notas1[k];
                int j = k-1;
                while(j>=0 && notas1[j]<tmp){
                    notas1[j+1]=notas1[j];
                    j--;
                }
                notas1[j+1]=tmp;
            }
            int cont=0;
            for(int j=0; j<qtdAlunos; j++){
                //System.out.println(notas1[j] +" - "+ notas2[j]);
                if(notas1[j]==notas2[j]){
                    cont++;
                }
            }
            System.out.println(cont);
        }
        leia.close();
    }
}
