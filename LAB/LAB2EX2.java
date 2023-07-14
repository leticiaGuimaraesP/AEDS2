package LAB;
import java.util.Scanner;

class LAB2EX2 {
    public static void main (String[] args){
        Scanner leia = new Scanner(System.in);
        int num1, num2;
        while(leia.hasNext()){
          String saida1="", saida2="";
          num1 = leia.nextInt();
          num2 = leia.nextInt();
          for(int i=num1; i<=num2; i++){ 
            saida1+= i;
          }
          for(int i=saida1.length()-1; i>=0; i--){ 
            saida2+=saida1.charAt(i);
          }          
          System.out.println(saida1+saida2);
        }
        leia.close();
   }
}
