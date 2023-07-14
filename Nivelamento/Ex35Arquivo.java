package Nivelamento;

public class Ex35Arquivo {
    public static void main (String[] args){
        String conteudo="";
        
        Arq.openRead(MyIO.readLine("Digite o nome do arquivo para leitura: "));
        while(Arq.hasNext()==true){
            conteudo+=Arq.readLine();
        }
        Arq.close();

        Arq.openWrite(MyIO.readString("Digite o nome de outro arquivo: "));
        for(int i=conteudo.length()-1; i>=0; i--){
            Arq.print(conteudo.charAt(i));
        }
        Arq.close();
    }
}
