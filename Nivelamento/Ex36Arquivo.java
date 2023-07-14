package Nivelamento;

public class Ex36Arquivo {
    public static void main (String[] args){
        String conteudo="", str="";
        
        Arq.openRead(MyIO.readLine("Digite o nome do arquivo para leitura: "));
        while(Arq.hasNext()==true){
            conteudo+=Arq.readLine();
        }
        Arq.close();
        for(int i = 0; i < conteudo.length(); i++){
            str = str + (char) (conteudo.charAt(i) + 3);
         } 
        MyIO.println(str);
    }
}
