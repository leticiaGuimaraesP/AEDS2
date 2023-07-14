package TP1;
class TP1EX5 {
   public static String substituiExpressaoBoo (String str){    
      String novaStr="";
      char qnt;
      qnt = str.charAt(0);
      if(qnt=='2'){
         for(int i=5; i<str.length(); i++){  //ignora os primeiros carcteres da String
            if(str.charAt(i)=='A'){
               novaStr=novaStr+str.charAt(2);  //Alteraçao dos valores da String
            }else if(str.charAt(i)=='B'){
               novaStr=novaStr+str.charAt(4);
            }else if(str.charAt(i)=='C'){
               novaStr=novaStr+str.charAt(6);
            }else{
               novaStr=novaStr+str.charAt(i);
            }
         }
      }else if(qnt=='3'){
         for(int i=7; i<str.length(); i++){  //ignora os primeiros carcteres da String
            if(str.charAt(i)=='A'){
               novaStr=novaStr+str.charAt(2);  //Alteraçao dos valores da String
            }else if(str.charAt(i)=='B'){
               novaStr=novaStr+str.charAt(4);
            }else if(str.charAt(i)=='C'){
               novaStr=novaStr+str.charAt(6);
            }else{
               novaStr=novaStr+str.charAt(i);
            }
         }
      }
      return novaStr;
   }

   public static int retornarUltimoParentese (String str){    
      int posi=-1; //se nao achar (, retorna um numero negativo
      for(int i=0; i<str.length(); i++){ 
         if(str.charAt(i)=='('){  //se achar (, retorna a posiçao do ultimo parentese
            posi=i;
         }
      }
      return posi;
   }
      
   public static String resolveExpressaoBoo (String str, int posi){    
      String novaStr="";
      char result;
      int j;
      int posiParentese=0;

      if(str.charAt(posi-1)=='t'){ //not
         //resolve a expressao e arruma a nova String formada
         for(int i=0;i<str.length();i++){
            if(i==posi-3){
               if(str.charAt(posi+1)=='1'){
                  novaStr=novaStr+'0';
               }else{
                  novaStr=novaStr+'1';
               }
               for(j=posi-2; j<str.length(); j++){
                  if(str.charAt(j)==')'){ //acha a posiçao do primeiro parentese fechado
                     novaStr=novaStr+"";
                     posiParentese=j;
                     j=str.length();
                  }
               }
               i=posiParentese;
            }else{
               novaStr=novaStr+str.charAt(i);
            }   
         }


      }else if(str.charAt(posi-1)=='d'){ //and
         //resolvendo a expressao
         result='1';
         for(int i=posi ;i<str.length(); i++){
            if(str.charAt(i)==')'){  //chegou no fim da expressao AND
               i=str.length();
            }else if(str.charAt(i)=='0'){
               result='0';
               i=str.length();
            }
         }
         //formando nova String com o resultado
         for(int i=0 ;i<str.length(); i++){
            if(i==posi-3){
               novaStr=novaStr+result;
               for(j=posi-2; j<str.length(); j++){
                  if(str.charAt(j)==')'){ //acha a posiçao do primeiro parentese fechado
                     novaStr=novaStr+"";
                     posiParentese=j;
                     j=str.length();
                  }
               }
               i=posiParentese; //passa a copiar a String a partir do primeiro parentese )
            }else{
               novaStr=novaStr+str.charAt(i);
            }
         }

      }else{  //or

         //resolvendo a expressao
         result='0';
         for(int i=posi; i<str.length(); i++){
            if(str.charAt(i)==')'){  //chegou no fim da expressao OR
               i=str.length();
            }else if(str.charAt(i)=='1'){
               result='1';
               i=str.length();
            }
         }
         //formando nova String com o resultado
         for(int i=0 ;i<str.length(); i++){
            if(i==posi-2){
               novaStr=novaStr+result;
               for(j=posi-1; j<str.length(); j++){
                  if(str.charAt(j)==')'){ //acha a posiçao do primeiro parentese fechado
                     novaStr=novaStr+"";
                     posiParentese=j;
                     j=str.length();
                  }
               }
               i=posiParentese; //passa a copiar a String a partir do primeiro parentese )
            }else{
               novaStr=novaStr+str.charAt(i);
            }
         }
      }
      return novaStr;
   }

   public static boolean isFim(String s){
      if(s.charAt(0) == '0'){
         return true;
      }else{
         return false;
      }
   }

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;
      String novaStr, strAux;
      int posicao;

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo 0
       
      //NAO ESTA PASSANDO DESSA LINHA
      for(int i = 0; i < numEntrada; i++){ 
         novaStr = substituiExpressaoBoo(entrada[i]); //chama o metodo que trocara as letras A, B e C por numeros
         do{
            posicao = retornarUltimoParentese(novaStr); //chama o metodo que retorna aposicçao do ultimo (
            if(posicao>0){
               strAux = resolveExpressaoBoo(novaStr, posicao); //chama o metodos que resolvera a expressao
               novaStr = strAux;
            }
         }while(posicao>0);
         MyIO.println(novaStr);
      }
   }
}