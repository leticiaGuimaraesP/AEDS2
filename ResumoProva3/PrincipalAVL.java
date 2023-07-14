package ResumoProva3;

public class PrincipalAVL {
    
}

class No{
    int elemento;
    int nivel;
    No dir, esq;

	public No(int elemento) {
		this(elemento, null, null, 1);
	}

	public No(int elemento, No esq, No dir, int nivel) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.nivel = nivel;
	}
    //Métodos para setar o nivel criado
    public void setNivel(){
        this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
    }
    public int getNivel(No no){
        if(no==null){
            return 0;
        }else{
            return no.nivel;
        }
    }
}

class ArvoreBinaria{
    No raiz;
    
    public ArvoreBinaria(){
        raiz = null;
    }

    public void inserir(int elemento){
        raiz = inserir(elemento, raiz);
    }
    private No inserir(int elemento, No no){
        if(no==null){
            no = new No(elemento);
            System.out.println("elemento inserido");
        }else if(elemento<raiz.elemento){
            no.esq = inserir(elemento, no.esq);
        }else if(elemento>raiz.elemento){
            no.dir = inserir(elemento, no.dir);
        }else{
            System.out.println("elemento repetido");
        }
        return no;
    }

    public boolean pesquisar(int elemento){
        boolean resp = pesquisar(elemento, raiz);
        return resp;
    }
    private boolean pesquisar(int elemento, No no){
        boolean resp;
        if(no==null){
            resp = false;
            System.out.println("elemento NÃO encontrado");
        }else if(elemento < raiz.elemento){
            resp = pesquisar(elemento, no.esq);
        }else if(elemento > raiz.elemento){
            resp = pesquisar(elemento, no.dir);
        }else{
            resp = true;
            System.out.println("elemento encontrado");
        }
        return resp;
    }

    public No remover(int elemento){
        return remover(elemento, raiz);
    }
    private No remover(int elemento, No no){
        if(no==null){
            System.out.println("elemento inexistente");
        }else if(elemento < raiz.elemento){
            no.esq = remover(elemento, no.esq);
        }else if(elemento > raiz.elemento){
            no.dir = remover(elemento, no.dir);
        }else{ //achou o elemento
            if(no.dir==null){ //se o elemento da direita for null, recebe o elemento da esquerda
                no = no.esq;
            }else if(no.esq==null){ //se o elemento da esquerda for null, recebe o elemento da direita
                no = no.dir;
            }else{ //se o no possuir os 2 filhos
                no.esq = maiorEsq(no, no.esq);
            }
        }
        return no;
    }
    private No maiorEsq(No no, No filho){
		if (filho.dir == null) {  //Se não existir o no a direita.
			no.elemento = filho.elemento; // Substitui o elemento do noo pelo elemento do filho
			filho = filho.esq; // Substitui j por j.ESQ.
		} else {  //Existe no a direita.
			filho.dir = maiorEsq(no, filho.dir);
		}
		return filho;
    }
}


class ArvoreAVL{
    No raiz;
    
    public ArvoreAVL(){
        raiz = null;
    }

    public void inserir(int elemento){
        raiz = inserir(elemento, raiz);
    }
    private No inserir(int elemento, No no){
        if(no==null){
            no = new No(elemento);
        }else if(elemento<raiz.elemento){
            no.esq = inserir(elemento, no.esq);
        }else if(elemento>raiz.elemento){
            no.dir = inserir(elemento, no.dir);
        }else{
            System.out.println("elemento repetido");
        }
        return balancear(no); //esse método de balancear vai passar por todos os nos do caminho
    }


    public boolean pesquisar(int elemento){
        boolean resp = pesquisar(elemento, raiz);
        return resp;
    }
    private boolean pesquisar(int elemento, No no){
        boolean resp;
        if(no==null){
            resp = false;
        }else if(elemento < raiz.elemento){
            resp = pesquisar(elemento, no.esq);
        }else if(elemento > raiz.elemento){
            resp = pesquisar(elemento, no.dir);
        }else{
            resp = true;
        }
        return resp;
    }


    public No remover(int elemento){
        return remover(elemento, raiz);
    }
    private No remover(int elemento, No no){
        if(no==null){
            System.out.println("elemento inexistente");
        }else if(elemento < raiz.elemento){
            no.esq = remover(elemento, no.esq);
        }else if(elemento > raiz.elemento){
            no.dir = remover(elemento, no.dir);
        }else{ //achou o elemento
            if(no.dir==null){ //se o elemento da direita for null, recebe o elemento da esquerda
                no = no.esq;
            }else if(no.esq==null){ //se o elemento da esquerda for null, recebe o elemento da direita
                no = no.dir;
            }else{ //se o no possuir os 2 filhos
                no.esq = maiorEsq(no, no.esq);
            }
        }
        return balancear(no); //esse método de balancear vai passar por todos os nos do caminho
    }
    private No maiorEsq(No no, No filho){
		if (filho.dir == null) {  //Se não existir o no a direita.
			no.elemento = filho.elemento; // Substitui o elemento do noo pelo elemento do filho
			filho = filho.esq; // Substitui j por j.ESQ.
		} else {  //Existe no a direita.
			filho.dir = maiorEsq(no, filho.dir);
		}
		return filho;
    }

    public No balancear(No no){
        if(no!=null){ //primeira coisa a fazer é testar se a arvore existe
            int fator = no.getNivel(no.dir) - no.getNivel(no.esq);
            //se estiver balanceada
            if(Math.abs(fator)<=1){ //Math.abs retorna o valor absoluto
                no.setNivel();
            } else if(fator == 2){ //Desbalanceada para direita - necessita da rotação simples a esquerda (RSE)
                int fatorFilhoDir = no.getNivel(no.dir.dir) - no.getNivel(no.dir.esq); 
				if (fatorFilhoDir == -1) { //Testa se o filho a direita tambem esta desbalanceado (formar um joelho apontando para a direita)
					no.dir = rotacionarDir(no.dir);
				}
				no = rotacionarEsq(no); //RSE
            } else if(fator == -2){ //Desbalanceada para esquerda - necessita da rotação simples a direira (RSD)
                int fatorFilhoEsq = no.getNivel(no.esq.dir) - no.getNivel(no.esq.esq);
                if (fatorFilhoEsq == 1) { //Testa se o filho a direita tambem esta desbalanceado (formar um joelho apontando para a direita)
					no.esq = rotacionarEsq(no.esq);
				}
				no = rotacionarDir(no); //RSD
            }else{
                System.out.println("Erro no No(" + no.elemento + ") com fator de balanceamento (" + fator + ") invalido!");
            }
        }
        return no;
    }

    private No rotacionarDir(No no) {
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;

		noEsq.dir = no;
		no.esq = noEsqDir;
		no.setNivel(); // Atualizar o nivel do no
		noEsq.setNivel(); // Atualizar o nivel do noEsq

		return noEsq;
	}
	private No rotacionarEsq(No no) {
		No noDir = no.dir;
		No noDirEsq = noDir.esq;

		noDir.esq = no;
		no.dir = noDirEsq;

		no.setNivel(); // Atualizar o nivel do no
		noDir.setNivel(); // Atualizar o nivel do noDir
		return noDir;
	}
}
