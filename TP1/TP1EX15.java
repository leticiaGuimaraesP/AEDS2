package TP1;
public class TP1EX15 {
    public static boolean isVogal (String str){
        return isVogal(str, 0);
    }

    public static boolean isVogal (String str, int i){
        boolean validou;  
        if(i>=str.length()){
            validou = true;
        }else if(str.charAt(i)=='a' || str.charAt(i)=='A' || 
                str.charAt(i)=='e' || str.charAt(i)=='E' ||
                str.charAt(i)=='i' || str.charAt(i)=='I' ||
                str.charAt(i)=='o' || str.charAt(i)=='O' ||
                str.charAt(i)=='u' || str.charAt(i)=='U'){
            validou = isVogal(str, i+1);
        }else{
            validou = false;
        }
        return validou;
    }
  
    public static boolean isConsoante (String str){
        return isConsoante(str, 0);
    }

    public static boolean isConsoante (String str, int i){
        boolean validou;
        if(i>=str.length()){
            validou = true;
        }else if((str.charAt(i) == 'A') || (str.charAt(i) == 'a') ||  //se uma das condiçoes for verdadeira, significa que exitem vogais na String
            (str.charAt(i) == 'E') || (str.charAt(i) == 'e') ||  //entao, validou recebe false e retorna esse resultado
            (str.charAt(i) == 'I') || (str.charAt(i) == 'i') ||
            (str.charAt(i) == 'O') || (str.charAt(i) == 'o') ||
            (str.charAt(i) == 'U') || (str.charAt(i) == 'u')){
            validou = false;
        }else if((str.charAt(i)>='b' && str.charAt(i)<='z') || 
            (str.charAt(i)>='B' && str.charAt(i)<='Z')){
            validou = isConsoante(str, i+1);
        }else{
            validou = false;
        }
        return validou;
    }

     public static boolean isInteger (String str){
        return isInteger(str, 0);
     }

     public static boolean isInteger (String str, int i){
        boolean validou;
        if(i>=str.length()){
            validou = true;
        }else if((str.charAt(i)>='0'&&str.charAt(i)<='9')){
            validou = isInteger(str, i+1);
        }else{
            validou = false;
        }
        return validou;
    }
  
    public static boolean isReal (String str){
        int cont = 0;
        return isReal(str, 0, cont);
    }
     public static boolean isReal (String str, int i, int cont){
        boolean validou;
        if(i>=str.length()){
            validou = true;
        }else if(str.charAt(i)==','||str.charAt(i)=='.'){
            cont++;     //faz a contagem de virgulas/pontos
            if(cont>1){    //se tiver mais de um ponto ou virgula, o metodo retorna false
                validou = false;  
            }else{
                validou = isReal(str, i+1, cont);
            }    
        }else if(str.charAt(i)>='0' && str.charAt(i)<='9'){
            validou = isReal(str, i+1, cont);
        }else{
            validou = false;
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
