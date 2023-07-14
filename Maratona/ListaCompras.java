package RevisãoP1;
import java.util.*;
public class ListaCompras {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n; i++){
            String s = sc.nextLine();
            String[] str = s.split("\\s+");
            for (int j=0;j<str.length-1; j++){
                for(int k=(j+1);k<str.length; k++){
                    if(str[j].equals(str[k])){
                        str[k]= "";
                    }
                }
            }
            Arrays.sort(str);
            for(int j=0; j<str.length;j++){
                if(!str[j].equals(""))
                System.out.print(str[j]+" ");            
            }
            System.out.print("\n");
        }
        sc.close();
    }
}
