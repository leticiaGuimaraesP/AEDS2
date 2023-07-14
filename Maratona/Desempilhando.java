package Maratona;
import java.util.Scanner;

public class Desempilhando {
    public static void main(String[] args){
        Scanner leia = new Scanner(System.in);
        int n,p;
        do{
            String aux = leia.nextLine();
            n = Character.digit(aux.charAt(0), 10);
            p = Character.digit(aux.charAt(2), 10);
            if(n==0 && p==0){
                break;
            }
    
            String[] info = new String[p];
            int linha=0, coluna=0;
    
            for(int i=0; i<p; i++){
                info[i] = leia.nextLine();     
            }
    
            for(int i=0; i<p; i++){
                for(int j=2; j<info[i].length(); j+=2){
                    if(Character.digit(info[i].charAt(j), 10)==1){ //achar a posição da caixa
                        linha = i;
                        coluna = j; // coluna = posição na String
                                    // coluna/2 = posição na pilha
                        break;
                    }
                }
            }
    
            //caixas em cima
            int qtd = Character.digit(info[linha].charAt(0), 10)-(coluna/2); 
            
            //caixas na lateral
            int num1=0, num2=0;
            if(linha>0){
                if(Character.digit(info[linha-1].charAt(0), 10)>=coluna/2){
                    num1 += Character.digit(info[linha-1].charAt(0), 10)-Character.digit(info[linha].charAt(coluna), 10)+1;
                }
            }else{//se a pilha for da ponta
                System.out.println(qtd);
            }
            
            if(linha<p){
                if(Character.digit(info[linha+1].charAt(0), 10)>=coluna/2){
                    num2 += Character.digit(info[linha-1].charAt(0), 10)-Character.digit(info[linha].charAt(coluna), 10)+1;
                }
            }else{//se a pilha for da ponta
                System.out.println(qtd);
            }
    
            //se a pilha estiver no meio
            if(num1>num2){
                qtd+=num2;
                System.out.println(qtd);
            }else{
                qtd+=num1;
                System.out.println(qtd);
            }    

        }while(n!=0 && p!=0);

        leia.close();
    }
}