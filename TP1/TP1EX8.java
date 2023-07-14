package TP1;
import java.io.*;
import java.net.*;

public class TP1EX8 {
   public static String getHtml(String endereco, String nome){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;
      int[] cont = new int[26];
      String respCont="";

      for(int i=0; i<26; i++){ //inicializando os contadores com 0
        cont[i]=0; 
      }

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }

         for (int i=0; i<resp.length(); i++){
            if (resp.charAt (i) == 97){
                cont[1]++;
            }else if (resp.charAt (i) == 101){
                cont[2]++;
            }else if (resp.charAt (i) == 105){
                cont[3]++;
            }else if (resp.charAt (i) == 111){
                cont[4]++;
            }else if (resp.charAt (i) == 117){
                cont[5]++;
            }else  if (resp.charAt (i) == 225){
                cont[6]++;
            }else if (resp.charAt (i) == 233){
                cont[7]++;
            }else if (resp.charAt (i) == 237){
                cont[8]++;
            }else if (resp.charAt (i) == 243){
                cont[9]++;
            }else if (resp.charAt (i) == 250){
                cont[10]++;
            }else if (resp.charAt (i) == 224){
                cont[11]++;
            }else if (resp.charAt (i) == 232){
                cont[12]++;
            }else if (resp.charAt (i) == 236){
                cont[13]++;
            }else if (resp.charAt (i) == 242){
                cont[14]++;
            }else if (resp.charAt (i) == 249){
                cont[15]++;   
            }else if (resp.charAt (i) == 227){
                cont[16]++;
            }else if (resp.charAt (i) == 245){
                cont[17]++;
            }else if (resp.charAt (i) == 226){
                cont[18]++;
            }else if (resp.charAt (i) == 234){
                cont[19]++;
            }else if (resp.charAt (i) == 238){
                cont[20]++;
            }else if (resp.charAt (i) == 244){
                cont[21]++;   
            }else if (resp.charAt (i) == 251){
                cont[22]++;
            } else if (resp.charAt (i) >= 97 && resp.charAt (i) <= 122){
                cont[23]++;
            }else if (resp.charAt (i) == 60){
                if (i+3<resp.length()){
                    if (resp.charAt(i+1)==98 && resp.charAt(i+2)==114 && resp.charAt(i+3)==62){
                        cont[24]++;
                        cont[23] = cont[23] - 2; //substrai o B e o R do contador de consoantes 
                    }
                }
                if (i+5<resp.length()){
                    if (resp.charAt(i+1)==116 && resp.charAt(i+2)==97 && resp.charAt(i+3)==98 &&
                        resp.charAt(i+4)==108 && resp.charAt(i+5)==101 && resp.charAt(i+6)==62){
                            cont[25]++;
                            cont[23] = cont [23] - 3; //substrai o T, B e o L do contador de consoantes 
                            cont[1]--; //tira a letra A do contador 
                            cont[2]--; //tira a letra E do contador 
                    }
                }
            } 
         }
         respCont = "a("+cont[1]+") e("+cont[2]+") i("+cont[3]+") o("+cont[4]+") u("+cont[5]+
         ") á("+cont[6]+") é("+cont[7]+") í("+cont[8]+") ó("+cont[9]+") ú("+cont[10]+
         ") à("+cont[11]+") è("+cont[12]+") ì("+cont[13]+") ò("+cont[14]+") ù("+cont[15]+
         ") ã("+cont[16]+") õ("+cont[17]+") â("+cont[18]+") ê("+cont[19]+") î("+cont[20]+
         ") ô("+cont[21]+") û("+cont[22]+") consoante("+cont[23]+
         ") <br>("+cont[24]+") <table>("+cont[25]+ ") "+nome;

      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here
      }

      return respCont;
   }

   public static boolean isFim(String s){
    return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

   public static void main(String[] args) {
    String[] endereco = new String[1000];
    int numEntrada = 0;
    String resp;

    do {
        endereco[numEntrada] = MyIO.readLine();       
    } while (isFim(endereco[numEntrada++]) == false);
    numEntrada--;   

    for (int i=1; i<numEntrada; i+=2) {
        resp = getHtml(endereco[i], endereco[i-1]);
        MyIO.println(resp);
    }
   }
}
