package TP2;
import java.util.*; 

public class TP1EX14 {

   public static boolean isFim(String s){
      if(s.length()==1){
         return true;
      }else{
         return false;
      }
   }
    
   public static String verifcador (String str) {
      str = str.replaceAll("\\s+","");
      StringBuffer buf = new StringBuffer(str);
      return verifcador(buf, 0);
   }

    public static String verifcador (StringBuffer buf, int i) {
      String resp;
      if (i == buf.length()) {
            buf.deleteCharAt(buf.length()-1); 
            String str = buf.toString();
            str = str.replaceAll("\\s+","");
            System.out.println(str);
            resp = str;
      }else if (buf.charAt(i) == ')') {
         for (int j = i; j > 0; j--) {
            // realizar operação caso not
            if (buf.charAt(j) == 't'){
                if(buf.charAt(j + 2) == '0') {
                    buf.replace(j - 2, i + 1, "1");
                } else {
                    buf.replace(j - 2, i + 1, "0");
                }
                j = 0;
            }
            // realizar operação caso and
            else if (buf.charAt(j) == 'd') {
                if (buf.charAt(j + 2) == '0' || buf.charAt(j + 4) == '0' || buf.charAt(j + 6) == '0') {
                buf.replace(j - 2, i + 1, "0");
            }
                else {
                buf.replace(j - 2, i + 1, "1");
            }
            j = 0;
            }
            // realizar operação caso or
            else if (buf.charAt(j) == 'r') {
                if (buf.charAt(j + 2) == '1' || buf.charAt(j + 4) == '1' || buf.charAt(j + 6) == '1') {
                    buf.replace(j - 1, i + 1, "1");
                }
                else {
                    buf.replace(j - 1, i + 1, "0");
                }  
                j = 0;  
            }
        }
         resp = verifcador(buf, 0);
      }else {
         resp = verifcador(buf, i + 1);
      }
      return resp;       
    }
    
    public static void arrumarEntrada (String texto) {
      int entrada = Character.getNumericValue(texto.charAt(0));
        char[] letras = new char[entrada];
        int cut = 0;
        // contar quantas casas até começar a algerbra booleana
        while (texto.charAt(cut) != 'o' && texto.charAt(cut) != 'a' && texto.charAt(cut) != 'n') {
         cut++;
        }
        // guardar os valores de a b e c
        for (int i = 2, j = 0; i < cut; i+=2) {
            letras[j++] = texto.charAt(i);
            }
        // criar substring
        char[] sub=new char[texto.length()-(cut-1)];
        for (int i=cut, index=0; i<texto.length(); i++) {
            if (texto.charAt(i) == 'A') {
               sub[index++] = letras[0];
            }else if (texto.charAt(i) == 'B') {
               sub[index++] = letras[1];
            }else if (texto.charAt(i) == 'C') {
               sub[index++] = letras[2]; 
            }else {
                sub[index++] = texto.charAt(i);
            }
        }
        verifcador(String.valueOf(sub));
    }

   public static void main (String[] args) {
      Scanner leia = new Scanner(System.in);
      String[] entrada = new String[1000];
      int cont = 0; 
      do {
         entrada[cont] = leia.nextLine(); 
      } while (isFim(entrada[cont++]));
      cont--; 

      for (int i = 0; i < cont; i++) {
         arrumarEntrada(entrada[i]);
      }
   }
}
