package RevisãoP1;


import java.util.*;
public class Assassinos {    
    public static boolean isFim(String str){
        if(str.length()==3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){
            return true;
        }else{
            return false;
        }
    }

    public static void main (String[] args){
        Scanner leia = new Scanner(System.in);
        //String[] entrada = new String[1000];
        String[] assassino = new String[1000];
        String[] assassinado = new String[1000];
        int numEntrada = 0;

        //Primeira forma de entrada com os dados
        /*do{
            entrada[numEntrada]=leia.nextLine();
        }while(isFim(entrada[numEntrada++])==false);
        numEntrada--;

        for(int i=0; i<numEntrada; i++){
            assassino[i] = "";
            assassinado[i] = "";
        }

        for(int i=0; i<numEntrada; i++){
            for(int j=0; j<entrada[i].length(); j++){
                if(entrada[i].charAt(j)==' '){
                    for(int g=0; g<j; g++){
                        assassino[i] = assassino[i] + entrada[i].charAt(g);
                    }
                    for(int g=j+1; g<entrada[i].length(); g++){
                        assassinado[i] = assassinado[i] + entrada[i].charAt(g);
                    }
                }
            }
        }*/

        //Segunda opção de entrada com os dados
        do{
            assassino[numEntrada]=leia.next();
            if(isFim(assassino[numEntrada])==false){
                assassinado[numEntrada]=leia.next();
            }
        }while(isFim(assassino[numEntrada++])==false);
        numEntrada--;

        String[] saida = new String[numEntrada];
        int cont=0;
        for(int i=0; i<numEntrada; i++){
            for(int j=0; j<numEntrada; j++){
                if(assassino[i].equals(assassino[j]) ){
                    cont++;
                } 
                if(assassino[i].equals(assassinado[j])){ //se o nome estiver entre os assassinados, o assassino e ignorado
                    cont=0;
                    j=numEntrada;
                }               
            }
            if(cont>0){
                saida[i]=assassino[i]+" "+cont;
                //System.out.println(assassino[i]+" "+cont);
            }else{
                saida[i]=" ";
            }
            cont=0;
        }

        for(int i=0; i<numEntrada; i++){
            if(!saida[i].equals(" ")){
                for(int x=i+1; x<numEntrada; x++){
                    if(saida[i].equals(saida[x])){ //se tiver dois iguais, substitui o segudo por " "
                        saida[x]=" ";
                    }
                }
                System.out.println(saida[i]); //so imprime o que for diferente de " "
            }
        }
        leia.close();
    }
}