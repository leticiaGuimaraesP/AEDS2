package TP1;
import java.util.Random;

class TP1EX4 {
   public static String alteraStr (String str, char letra1, char letra2){ //faz a troca das letras geradas
      String resp = "";
      for(int i=0; i<str.length(); i++){
         if(str.charAt(i)==letra1){ //se for igual a primeira letra gerada, a nova String recebe a segunda letra gerada
            resp = resp + letra2;
         }else{
            resp = resp + str.charAt(i); //se nao for igual a primeira letra gerada, a nova String recebe a propria letra testada
         }
      }
      return resp;
   }

   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;
      char letra1, letra2;

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      Random gerador = new Random();
      gerador.setSeed(4);

      //gera e imprime nova String com as novas letras 
      for(int i = 0; i < numEntrada; i++){
         letra1 = ((char) ('a'+(Math.abs(gerador.nextInt())%26)));  //sorteia a primeira letra aleatoria 
         letra2 = ((char)('a'+(Math.abs(gerador.nextInt())%26)));  //sorteia a segunda letra aleatoria 
         MyIO.println(alteraStr(entrada[i], letra1, letra2));  //faz a impressao das nova String gerada
      }
   }
}