package Nivelamento;

class Ex30Arquivo {
    public static void main (String[] args){
        String conteudo = "";

        Arq.openWrite(MyIO.readString("Digite o nome do arquivo: "));
        Arq.println(MyIO.readLine("Digite uma frase: "));
        Arq.close();

        Arq.openRead(MyIO.readLine("Digite o nome do arquivo para leitura: "));
        while(Arq.hasNext()==true){
            conteudo+=Arq.readLine();
        }
        MyIO.println(conteudo);
    }
}