package TP1;
import java.io.*;

public class TP1EX9 { 
     public static void main (String[] args) throws IOException{
        RandomAccessFile raf = new RandomAccessFile("saida.txt", "rw"); //abre o arquivo
        int n;
        double resp1;
        int resp2;
    
        n = MyIO.readInt();  //leitura da quantidade de numeros que serao lidos sequencialmente

        for(int i=0; i<n; i++){
            raf.writeDouble(MyIO.readDouble());  //leitura de cada numero real
        }
        raf.close(); //fecha o arquivo

        RandomAccessFile rafL = new RandomAccessFile("saida.txt", "r"); //abre o arquivo novamente, mas so para leitura
        for(int i=(n-1)*8; i>=0; i-=8){  //le o arquivo de tras para frente
            rafL.seek(i);
            resp1 = rafL.readDouble();
            resp2 = (int)resp1;
            if(resp1==resp2){
                MyIO.println(resp2); 
            }else{
                MyIO.println(resp1); 
            }
            //imprime cada numero
        }
        rafL.close(); //fecha o arquivo
     }
}
