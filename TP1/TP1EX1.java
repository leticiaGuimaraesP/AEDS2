package TP1;
class TP1EX1 {
   public static boolean isPolindromo (String str){
      boolean validou = true;

       //Percorre toda a String e compara duas letras - a primeira com a ultima e sucessivamente
      for(int i=0; i<(str.length())/2; i++){
        if(str.charAt(i)!=str.charAt(str.length()-1-i)){    //lenght() retorna a quantidade de letras da String, mas as posiçoes começam no 0
            validou = false;                                //por isso o -1 depois do str.length()-1
            i = str.length();             //Caso alguma letra seja diferente, encerra o loop e retorna false
        }
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