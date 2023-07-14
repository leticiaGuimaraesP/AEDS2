package TP1;
public class TP1EX13 {
    public static String ciframentoDeCesar(String str){
        return ciframentoDeCesar(str, str.length()-1);
    }

    public static String ciframentoDeCesar(String str, int i){
        String novaStr="";
        if(i==0){
            novaStr = novaStr + (char)(str.charAt(0)+3);
        }else{
            novaStr = ciframentoDeCesar(str, i-1) + (char)(str.charAt(i)+3);
        }
        return novaStr;
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