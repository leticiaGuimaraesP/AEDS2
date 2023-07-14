package ResumoProva3;

public class PrincipalAlvinegra {
    public static void main(String[] args) throws Exception{
        Alvinegra teste = new Alvinegra();
        teste.inserir(4);
        teste.inserir(35);
        teste.inserir(10);
        teste.inserir(13);
        teste.inserir(3);
        teste.inserir(30);
        teste.inserir(15);
        teste.inserir(12);
        teste.inserir(7);
        teste.inserir(40);
        teste.inserir(20);
        System.out.println(teste.qtdNoTipo4(teste.getRaiz(), 0)); 
    }
}

class No{
    public boolean cor;
    public int elemento;
    public No esq, dir;
  
    public No() {
      this(-1);
    }
  
    public No(int elemento) {
      this(elemento, false, null, null);
    }
  
    public No(int elemento, boolean cor) {
      this(elemento, cor, null, null);
    }
  
    public No(int elemento, boolean cor, No esq, No dir) {
      this.cor = cor;
      this.elemento = elemento;
      this.esq = esq;
      this.dir = dir;
    }
}

class Alvinegra {
    private No raiz; 
    public No getRaiz(){
        return raiz;
    }

    public Alvinegra() {
       raiz = null;
    }

    public void inserir(int elemento) throws Exception {
        if(raiz==null){ //se a arvore estiver vazia
            raiz = new No(elemento);
        }else if(raiz.esq==null && raiz.dir==null){ //se a arvore so possuir raiz
            if(elemento<raiz.elemento){ //testa em qual posiçao inserir
                raiz.esq = new No(elemento);
            }else if(elemento>raiz.elemento){
                raiz.dir = new No(elemento);
            }
        }else if(raiz.esq==null){ //se a arvore possui apenas 2 elementos iniciais
            if(elemento<raiz.elemento){ //testa se o elemento encaixa no raiz.esq que esta null
                raiz.esq= new No(elemento);
            }else if(elemento<raiz.dir.elemento){ //testa se o elemento é maior ou menor que o filho da direita
                raiz.esq = new No(raiz.elemento); // e depois balanceia o 3 elementos
                raiz.elemento =  elemento;
            }else if(elemento>raiz.dir.elemento){
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = false; //inicializa as cores dos elementos
        }else if(raiz.dir==null){ //se a arvore possui apenas 2 elementos iniciais
            if(elemento>raiz.elemento){
                raiz.dir= new No(elemento);
            }else if(elemento>raiz.esq.elemento){
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = elemento;
            }else if(elemento<raiz.esq.elemento){
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        }else{ //quando os 3 primeiros elementos já estão inseridos
            inserir(elemento, null, null, null, raiz);
        }
    }

    public void inserir(int elemento, No bisavo, No avo, No pai, No no) throws Exception {
        if(no==null){ //testa se o no é a folha 
            if(elemento<pai.elemento){ //se for folha, testa em qual posição o elemento deve ser inserido
                pai.esq = new No(elemento, true);
            }else if(elemento>pai.elemento){
                pai.dir = new No(elemento, true);
            }
            if(pai.cor==true){ //se o pai também possui a cor true, é necessário fazer o balancemaneto
                balancear(bisavo, avo, pai, no);
            }
        }else{ //se o no é interno
            if(no.dir!=null && no.esq!=null && no.dir.cor==true && no.esq.cor==true){ //se é um no do tipo 4 - com 3 elementos
                pai.cor = true; //inverte as cores
                no.dir.cor = no.esq.cor = false;
                //apos a inversão é necessário fazer 2 testes 
                if(no == raiz){ //o primeiro é na raiz, ja que a raiz não pode ser preta
                    no.cor = false;
                }else if(pai.cor==true){ //se o pai do no for preto tambem, é necessário balancear 
                    balancear(bisavo, avo, pai, no);
                }
            }else{ //continua a recursividade
                if(elemento<pai.elemento){
                    inserir(elemento, avo, pai, no, no.esq);
                }else if(elemento>pai.elemento){
                    inserir(elemento, avo, pai, no, no.dir);
                }

            }
        }
    }

    public void balancear(No bisavo, No avo, No pai, No no){
        if(pai.cor==true){
            if(pai.elemento<avo.elemento){ //Rotaçao a Direita
                if(no.elemento<pai.elemento){
                    avo = rotacionarEsq(avo);
                }
                avo = rotacionarDir(avo);
            }else{ //Rotação a Esquerda
                if(no.elemento<pai.elemento){
                    avo = rotacionarDir(avo);
                }
                avo = rotacionarEsq(avo);
            }
            //faz o no de fora (o que referiencia a subarvore apontar para a nova raiz da subarvore)
            if (bisavo == null) {
                raiz = avo;
            } else if (avo.elemento < bisavo.elemento) {
                bisavo.esq = avo;
            } else {
                bisavo.dir = avo;
            }
            // reestabelecer as cores apos a rotacao
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }

    public No rotacionarDir(No no){
        No noEsq = no.esq;
        No noEsqDir = noEsq.esq;

        noEsq.dir = no;
        no.esq = noEsqDir;
        return noEsq;
    }
    public No rotacionarEsq(No no){
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
    }

    public boolean isNoTipo4(No no){
        boolean resp = false;
        if(no.esq!=null && no.dir!=null && no.esq.cor==true && no.dir.cor==true){
            resp = true;
        }else{
            resp = false;
        }
        return resp;
    }

    public int qtdNoTipo4(No no, int soma){ //raiz
        if (no != null) {
            if(isNoTipo4(no)){
                soma += 1;
            }
			soma = qtdNoTipo4(no.esq, soma); // Elementos da esquerda.
			soma = qtdNoTipo4(no.dir, soma); // Elementos da direita.
		}
        return soma;
    }
}

