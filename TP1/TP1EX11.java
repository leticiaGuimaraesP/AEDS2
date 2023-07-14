package TP1;
class TP1EX11 {
    public static boolean isPolindromo (String str){
       return isPolindromo(str, 0);  //chama a funçao e zera o indice
    }

    public static boolean isPolindromo (String str, int i){
        boolean validou;
        if(i>=str.length()/2){  //se chegar ate a metade da String, siginifica que é um polidormo
            validou = true;
        }else if(str.charAt(i)!=str.charAt(str.length()-1-i)){  //se forem diferentes, encerra o loop e retorna falso
            validou = false;
        }else{
            validou = isPolindromo(str, i+1);
        }
       return validou;
    }
 
    public static boolean isFim(String s){
       return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
 
    public static void main (String[] args){
       String[] entrada = new String[1000];
       int numEntrada = 0;
 
       //Leitura da entrada padrao
       do {
          entrada[numEntrada] = MyIO.readLine();
       } while (isFim(entrada[numEntrada++]) == false);
       numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
 
       //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
       for(int i = 0; i < numEntrada; i++){
         if(isPolindromo(entrada[i])){ //Se o metodo retornar true imprime SIM, caso contrário imprime NAO
             MyIO.println("SIM");
         }else{
             MyIO.println("NAO");
         }    
       }
    }
 }