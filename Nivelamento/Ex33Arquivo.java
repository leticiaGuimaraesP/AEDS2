package Nivelamento;

public class Ex33Arquivo {
    public static void main (String[] args){
        String conteudo="";
        
        Arq.openRead(MyIO.readLine("Digite o nome do arquivo para leitura: "));
        while(Arq.hasNext()==true){
            conteudo+=Arq.readLine();
        }
        Arq.close();

        Arq.openWrite(MyIO.readString("Digite o nome de outro arquivo: "));
        Arq.println(conteudo);
        Arq.close();
    }
}
