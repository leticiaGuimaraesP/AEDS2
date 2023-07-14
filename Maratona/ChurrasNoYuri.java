package RevisãoP2;
import java.util.Scanner;

public class ChurrasNoYuri {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);

        while(leia.hasNext()){
            int n = Integer.parseInt(leia.next());
            String[] carnes = new String[n];
            int[] datas = new int[n];
    
            for(int i=0; i<n; i++){
                carnes[i] = leia.next();
                datas[i] = Integer.parseInt(leia.next());
            }
    
            for(int i=0; i<n; i++){
                int menor = i;
                for(int j=(i+1); j<n; j++){
                    if(datas[menor]>datas[j]){
                        menor = j;
                    }
                }
                int tmp1 = datas[menor];
                String tmp2 = carnes[menor];
                datas[menor] = datas[i];
                carnes[menor] = carnes[i];
                datas[i] = tmp1;
                carnes[i] = tmp2;
            }
    
            for(int j=0; j<n; j++){
                System.out.print(carnes[j]+" ");
            } 
            System.out.print("\n");
        }
        leia.close();
    }
}
