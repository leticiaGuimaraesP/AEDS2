package TP1;
class TP1EX6 {
   public static boolean isVogal (String str){
      boolean validou = true;    //espaço "" conta?????
      for(int i=0; i<str.length(); i++){
        if (((str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z')) ||  //testa se a String e formada por apenas letras
          ((str.charAt(i) >= 'a') && (str.charAt(i) <= 'z'))){
            if(((str.charAt(i)!='a') && (str.charAt(i)!='A')) &&   //se todas as condiçoes forem verdadeiras - a letra testada nao for vogal - validou recebe false 
              ((str.charAt(i)!='e') && (str.charAt(i)!='E')) &&
              ((str.charAt(i)!='i') && (str.charAt(i)!='I')) &&
              ((str.charAt(i)!='o') && (str.charAt(i)!='O')) &&
              ((str.charAt(i)!='u') && (str.charAt(i)!='U'))){
                validou = false;
                i = str.length()+1;
            }
          }else{
            validou = false;   
            i = str.length()+1;
          }   
      }    
      return validou;
   }

   public static boolean isConsoante (String str){
      boolean validou = true;
      for(int i=0; i<str.length(); i++){
        if (((str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z')) ||   //testa se a String e formada por apenas letras
          ((str.charAt(i) >= 'a') && (str.charAt(i) <= 'z'))) {
            if ((str.charAt(i) == 'A') || (str.charAt(i) == 'a') ||  //se uma das condiçoes for verdadeira, significa que exitem vogais na String
                (str.charAt(i) == 'E') || (str.charAt(i) == 'e') ||  //entao, validou recebe false e retorna esse resultado
                (str.charAt(i) == 'I') || (str.charAt(i) == 'i') ||
                (str.charAt(i) == 'O') || (str.charAt(i) == 'o') ||
                (str.charAt(i) == 'U') || (str.charAt(i) == 'u')) {
                    validou = false;
                    i = str.length()+1;
            }
        }else{
            validou = false;
            i = str.length()+1;
        }
      }
      return validou;
   }

   public static boolean isInteger (String str){
    boolean validou = true;
    for (int i = 0; i < str.length(); i++) {
      if ((str.charAt(i)<'0'||str.charAt(i)>'9')) {   //testa se a String tem apenas numeros
        validou = false;
        i = str.length()+1;
      }
    }
      return validou;
   }

   public static boolean isReal (String str){
    boolean validou = true;
    int cont = 0;
    for (int i = 0; i < str.length(); i++) {
      if ((str.charAt(i)>='0'&&str.charAt(i)<='9')||str.charAt(i)==','||str.charAt(i)=='.') {   //testa se a String tem apenas numeros ou ,
          if(str.charAt(i)=='.'||str.charAt(i)==','){ 
            cont++;     //faz a contagem de virgulas/pontos
            if(cont>1){    //se tiver mais de um ponto ou virgula, o metodo retorna false
              validou = false;  
              i = str.length()+1;
            }
          }
      }else{
        validou = false;
        i = str.length()+1;
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
          if(isVogal(entrada[i])){
            MyIO.print("SIM ");
          }else{
            MyIO.print("NAO ");
          }

          if(isConsoante(entrada[i])){
            MyIO.print("SIM ");
          }else{
            MyIO.print("NAO ");
          }

          if(isInteger(entrada[i])){
            MyIO.print("SIM ");
          }else{
            MyIO.print("NAO ");
          }

          if(isReal(entrada[i])){
            MyIO.println("SIM");
          }else{
            MyIO.println("NAO");
          }
      }
   }
}