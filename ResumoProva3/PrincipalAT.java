package ResumoProva3;
public class PrincipalAT {
    public static void main(String[] args){
        ArvoreTrie arvore = new ArvoreTrie();
        arvore.inserir("bear");
        arvore.inserir("bell");
        arvore.inserir("bid");
        arvore.inserir("bull");
        arvore.inserir("buy");
        arvore.inserir("sell");
        arvore.inserir("stock");
        arvore.inserir("stop");
        arvore.mostrar();
    }
}

class No{
    char elemento; 
    int tamanho=255;
    No[] prox;
    boolean folha;

    public No (){
        this(' ');
    }

    public No(char elemento){
        this.elemento = elemento;
        prox = new No[tamanho];
        for(int i=0; i<tamanho; i++){
            prox[i] = null;
        }
        folha = false;
    }

    public static int hash (char x){
        return (int)x;
    }
}

class ArvoreTrie{
    No raiz;

    public ArvoreTrie(){
        raiz = new No();
    }

    public void inserir(String str){
        inserir(str, raiz, 0);
    }
    public void inserir(String str, No no, int i){
        if(no.prox[str.charAt(i)]==null){
            no.prox[str.charAt(i)] = new No(str.charAt(i));
            
            if(str.length()-1 == i){
                no.prox[str.charAt(i)].folha = true;
            }else{
                inserir(str, no.prox[str.charAt(i)], i+1);
            }
        }else if(no.prox[str.charAt(i)].folha==false && i<str.length()-1){
            inserir(str, no.prox[str.charAt(i)], i+1);
        }else{
            System.out.println("Erro ao inserir, prefixo existente");
        }
    }

    public boolean pesquisar(String str){
        boolean resp = pesquisar(str, raiz, 0);
        return resp;
    }
    public boolean pesquisar(String str, No no, int i){
        boolean resp = false;
        if(no.prox[str.charAt(i)]==null){
            resp = false;
        }else if(no.prox[str.charAt(i)]!=null && i<str.length()-1){
            if(no.prox[str.charAt(i)].folha==false){
               resp = pesquisar(str, no.prox[str.charAt(i)],i+1);
            }
        }else if(no.prox[str.charAt(i)]!=null && i==str.length()-1){
            if(no.prox[str.charAt(i)].folha==true){
                resp = true;
            }
        }else{
            System.out.println("Erro ao pesquisar");
        }
        return resp;
    }

    public void mostrar(){
        mostrar("", raiz);
    }
    public void mostrar(String str, No no) {
        if(no.folha == true){
            System.out.println("Palavra: " + (str+no.elemento));
        } else {
            for(int i = 0; i < no.prox.length; i++){ //um for para cada no, ai quando acaba uma recursividade, pula para o proximo no
                if(no.prox[i] != null){ //no prox pode ter inumeras posições vazias, essas tem que ser ignoradas
                    mostrar(str + no.elemento, no.prox[i]);
                }
            }
        }
    }
    public int contarAs(){
        int resp = 0;
        if(raiz != null){
            resp = contarAs(raiz);
        }
        return resp;
    }
    public int contarAs(No no) {
        int resp = (no.elemento == 'A') ? 1 : 0;

        if(no.folha == false){
            for(int i = 0; i < no.prox.length; i++){
                if(no.prox[i] != null){
                    resp += contarAs(no.prox[i]);
                }
            }
        }
        return resp;
    }
    
    public int contB(No no, int soma){
        if(no.elemento=='B'){
            soma+=1;
        }
        if(no.folha==false){
            for(int i=0; i<no.prox.length; i++){
                if(no.prox[i]!=null){
                    soma = contB(no.prox[i], soma);
                }
            }
        }
        return soma;
    }
}

/*
class No(){
    char letra;
    int tamanho = 255;
    No[] prox;
    boolean folha;

    public No(){
        this.letra = " ";
    }
    public No(char letra){
        this.letra = letra;
        prox = new No[tamanho];
        for(int i=0; i<tamanho; i++){
            prox[i] = null;
        }
        folha = false;
    }
    public int h(char letra){
        return (int)letra;
    }
}
class ArvoreTrie(){
    No raiz;
    public ArvoreTrie(){
        raiz = new No();
    }
    public void inserir(String str){
        inserir(str, raiz, 0);
    }
    public void inserir(String str, No no, int i){
        if(no.prox[str.charAt(i)]==null){ //existem duas grandes opções no inserir: 1°- o elemento não existe
            no.prox[str.charAt(i)] = new No(str.charAt(i)); //cria-se o no
            if(i==str.length()-1){ //se for o ultimo, a folha tem que receber true
                no.prox[str.charAt(i)].folha = true;
            }else{
                inserir(str, no.prox[str.charAt(i)], i+1);
            }
        }else if(no.prox[str.charAt(i)].folha==false && i<str.length()-1){ //2° - o elemento existe, a folha tem que ser false e o i tem que ser menor que o tamanho da string
            inserir(str, no.prox[str.charAt(i)], i+1); 
        }else{
            sysout(erro);
        }
    }
    public void pesquisar(String str){
        pesquisar(str, raiz, 0);
    }
    public boolean pesquisar(String str, No no, int i){
        boolean resp = false;
        if(no.prox[str.charAt(i)]!=null){ //existem 2 grandes opções, mas antes o no tem que existir - a posição na tabela
            if(i==str.length()-1){ //se o i estiver no final, tem que testar se aquele no é uma folha
                if(no.prox[str.charAt(i)].folha = true){
                    resp=true;
                }
            }else{
                if(no.prox[str.charAt(i)].folha = false){ //se não estiver no final, tem que testar se o nó não é uma folha
                    pesquisar(str, no.prox[str.charAt(i)], i+1);
                }
            }
        }else{
            erro;
        }
        return resp;
    }
    public void mostrar(){
        mostrar("", raiz);
    }
    public void mostrar(String str, No no){
        if(no.folha==true){ //1° acha a condição que para a recursividade
            System.out.println(str+no.elemento);
        }else{
            for(int i=0; i<no.prox.length; i++){ //percorre os próximos 
                if(no.prox[i]!=null){ //se o prox ecistir, tem que chamar a recursividade para ele
                    str+=no.elemento;
                    mostrar(str, no.prox[i]);
                }
            }
        }
    }
}*/

/*/
class no{
    char elemento;
    int tam = 255;
    No[] prox;
    boolean folha;

    public no(char elemento){
        this.elemento = elemento;
        prox = new No[tam];
        for(int i=0; i<tam; i++){
            prox[i] = null;
        }
        folha = false;
    }

    public static int hash (char x){
        return (int)x;
     }
}
class arvoreTrie{
    No raiz;
    public arvoreTrie(){
        raiz = null;
    }
    public void inserir(String str){
        inserir(str, raiz, 0);
    }
    public void inserir(String str, No no, int i){
        if(no.prox[str.charAt(i)]==null){
            no.prox[str.charAt(i)] = new No(str.charAt(i));
            if(i==str.length()-1){
                no.folha=true;
            }else{
                inserir(str, no.prox[str.charAt(i)], i+1);
            }
        }else if(no.prox[str.charAt(i)]!=null && i<str.length()-1){ //
            inserir(str, no.prox[str.charAt(i)], i+1);
        }
    }
    public boolean search(String str){
        boolean resp = search(str, raiz, 0);
        return resp;
    }
    public boolean search(String str, No no, int i){
        boolean resp = false;
        if(no.prox[str.charAt(i)]!=null){
            if(i == str.length()-1){
                if(no.folha==true){
                    resp = true;
                }
            }else{
                if(no.folha==false){
                    resp = search(str, no.prox[str.charAt(i)], i+1);
                }
            }      
        }
        return resp;
    }
}*/
