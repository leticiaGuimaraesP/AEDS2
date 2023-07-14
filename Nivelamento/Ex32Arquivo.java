package Nivelamento;

class Ex32Arquivo {
    public static void main (String[] args){
        String conteudo="";
        
        Arq.openRead(MyIO.readLine("Digite o nome do arquivo para leitura: "));
        while(Arq.hasNext()==true){
            conteudo+=Arq.readLine();
        }
        MyIO.println(conteudo.toUpperCase());
        Arq.close();
    }
}