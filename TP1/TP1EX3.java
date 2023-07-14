package TP1;
class TP1EX3 {
   public static String ciframentoDeCesar(String str){
      String resp = "";
      for(int i = 0; i < str.length(); i++){
         resp = resp + (char) (str.charAt(i) + 3);
      } 
      return resp;
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
         MyIO.println(ciframentoDeCesar(entrada[i]));
      }
   }
}