package ResumoProva3;
public class PrincipalHash {
    public static void main(String[] Args) throws Exception{
        HashIndiretoLista tabela = new HashIndiretoLista(7);
        tabela.inserir(5);
        tabela.inserir(7);
        tabela.inserir(14);
        tabela.inserir(21);
        tabela.inserir(19);
        tabela.inserir(3);
        
        tabela.mostrar();
        System.out.println(tabela.remover(7));
        System.out.println(tabela.remover(21));
        System.out.println(tabela.remover(5));
        tabela.mostrar();
    } 
}

class Hash {
    int tabela[]; //tabela hash
    int m1, m2, m, reserva; //m1 = area normal, m2 = area reserva, m = m1+m2, reserva = qtde de elementos
    final int NULO = -1;
 
    public Hash() {
       this(13, 7);
    }
 
    public Hash(int m1, int m2) {
        this.m1 = m1;
        this.m2 = m2;
        this.m = m1 + m2;
        this.tabela = new int[this.m]; //inicializar a tabela com a quantidade correta
        for (int i = 0; i < m1; i++) { //preenche toda a area normal com o elemento -1;
            tabela[i] = NULO;
        }
        reserva = 0; //inicializa o contador da reserva
    }
 
    public int h(int elemento) {
       return elemento % m1; //função utilizada para calcular cada posição
    }
 
    public boolean inserir(int elemento) {
        boolean resp = false; 
        if (elemento != NULO) {
            int pos = h(elemento); //acha a posição de acordo com a função
            if (tabela[pos] == NULO) { //testa se ja possui algum elemento 
                tabela[pos] = elemento;
                resp = true; //valida a inserção
            } else if (reserva < m2) { //se ja existir algum elemento na posição calcula, testa se cabe algum elemento na reserva
                tabela[m1 + reserva] = elemento; //insere o elemento na posição sequencial 
                reserva++; //incrementar o contador 
                resp = true; //valida a inserção
            }
        }
        return resp;
    }
 
    public boolean pesquisar(int elemento) {
       boolean resp = false;
       int pos = h(elemento); //acha a posição do elemento
       if (tabela[pos] == elemento) { //testa se é o elemento procurado
          resp = true; 
       } else if (tabela[pos] != NULO) { //se não for o elemento procurado, vai para a area de reserva
          for (int i = 0; i < reserva; i++) {
             if (tabela[m1 + i] == elemento) {
                resp = true;
                i = reserva; //se achar o elemento, é necessário encerrar o for
             }
          }
       }
       return resp;
    }

    public void mostrar() {
       for(int i=0; i<m; i++){
            System.out.println(tabela[i]);
       }
    }
 
    boolean remover(int elemento) {
        boolean resp = false;
        int pos = h(elemento);
        if(tabela[pos]==elemento){ //testa se o elemento da posição encontrada é o elemento procurado
            tabela[pos]=NULO; //se for o elemento, a posição recebe null
            resp = true;
            for(int i=m1; i<m; i++){ //após a exclusão é necessário testar se existe outro elemento com o mesmo valor hash
                if(h(tabela[i])==pos){ //se existir esse elemento na area de reserva, é necessário voltar com ele para a area normal 
                    tabela[pos]=tabela[i];
                    tabela[i]=tabela[m1+(--reserva)];
                    tabela[m1+reserva]=NULO;
                    i=m;
                }
            }
        }else if(tabela[pos]!=NULO){ //se não for o elemento procurado, tem que procurar ele na area de reserva
            for(int i=m1; i<m; i++){
                if(tabela[i]==elemento){
                    tabela[i]=tabela[m1+(--reserva)];
                    tabela[m1+reserva]=NULO;
                    resp = true;
                    i=m;
                }
            }
        }
        return resp;
    }
 } 

class HashR {
    int tabela[];
    int m; //tamanho da tabela 
    final int NULO = -1;
 
    public HashR() {
       this(13);
    }
 
    public HashR(int m) {
       this.m = m;
       this.tabela = new int[this.m];
       for (int i = 0; i < m; i++) {
          tabela[i] = NULO;
       }
    }
 
    public int h(int elemento) { //função hash
       return elemento % m;
    }
 
    public int reh(int elemento) { //função rehash
       return ++elemento % m;
    }
 
    public boolean inserir(int elemento) {
        boolean resp = false;
        if (elemento != NULO) {
            int pos = h(elemento);
            if (tabela[pos] == NULO) {
                tabela[pos] = elemento;
                resp = true;
            } else {
                pos = reh(elemento);
                if (tabela[pos] == NULO) {
                    tabela[pos] = elemento;
                    resp = true;
                }
            }
        }
        return resp;
    }
 
    public boolean pesquisar(int elemento) {
       boolean resp = false;
       int pos = h(elemento);
        if (tabela[pos] == elemento) {
            resp = true;
        } else if (tabela[pos] != NULO) {
            pos = reh(elemento);
            if (tabela[pos] == elemento) {
                resp = true;
            }
        }
       return resp;
    }

    public void mostrar() {
        for(int i=0; i<m; i++){
             System.out.println(tabela[i]);
        }
     }
 
    public boolean remover(int elemento) {
        boolean resp = false;
        int pos = h(elemento);
        if(tabela[pos]==elemento){
            tabela[pos]=NULO;
            resp=true;
            int pos2 = reh(elemento);
            int elemento2 = tabela[pos2];
            if(h(elemento2)==pos){
                tabela[pos]=elemento2;
                rehashRec(pos2);
            }
        }else if(tabela[pos]!=NULO){
            int pos2 = reh(elemento);
            if(tabela[pos2]==elemento){
                rehashRec(pos2);
                resp=true;
            } 
            /*Exemplo:
             HashR tabela = new HashR(7);
            tabela.inserir(5);
            tabela.inserir(7);
            tabela.inserir(14);
            tabela.inserir(21);
            tabela.inserir(19);
            tabela.inserir(1);
            
            tabela.mostrar();
            System.out.println(tabela.remover(7));
            tabela.mostrar();
            System.out.println(tabela.pesquisar(1));
             */
        }
        return resp;
    }

    public void rehashRec(int pos){
        int pos2 = h(tabela[pos] + 2);
        if(h(tabela[pos2])==pos){
            tabela[pos]=tabela[pos2];
            rehashRec(pos2);
        }else{
            tabela[pos]=NULO;
        }
    }
 }

class HashIndiretoLista {
    Lista tabela[];
    int tamanho;
    final int NULO = -1;
 
    public HashIndiretoLista() {
        this(7);
    }
 
    public HashIndiretoLista(int tamanho) {
        this.tamanho = tamanho;
        tabela = new Lista[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new Lista();
        }
    }

    public int h(int elemento) {
       return elemento % tamanho;
    }
 
    boolean pesquisar(int elemento) {
       int pos = h(elemento);
       return tabela[pos].pesquisar(elemento);
    }
 
    void mostrar() {
        for(int i=0; i<tamanho; i++){
            tabela[i].mostrar();
        }
    }

    public void inserir(int elemento) {
       int pos = h(elemento);
       tabela[pos].inserirInicio(elemento);
    }
 
    public boolean remover(int elemento) throws Exception {
        boolean resp=false;
        if (pesquisar(elemento) == false) {
            throw new Exception("Erro ao remover!");
        } else {
            int pos = h(elemento);
            resp = tabela[pos].remover(elemento);
        }
       return resp;
    }
 }

class Celula {
	public int elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.

	Celula(int elemento) {
		this.elemento = elemento;
		this.prox = null;
	}
	Celula(int elemento, Celula prox) {
		this.elemento = elemento;
		this.prox = prox;
	}
}

class Lista {
	private Celula primeiro; // Primeira celula: SEM elemento valido.
	private Celula ultimo; // Ultima celula: COM elemento valido.

	public Lista() {
		primeiro = new Celula(-1);
		ultimo = primeiro;
	}

	public void mostrar() { 
		System.out.print("[ "); // Comeca a mostrar.
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] "); // Termina de mostrar.
	}

	public boolean pesquisar(int x) {
		boolean retorno = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if(i.elemento == x){
                retorno = true;
                i = ultimo;
            }
		}
		return retorno;
	}

	public void inserirInicio(int elemento) {
		Celula tmp = new Celula(elemento);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
	}

	public boolean remover(int x) throws Exception {
        boolean achou = false;
        if(primeiro!=ultimo){
            Celula aux = primeiro;
            while(aux.prox!=null && !achou){
                if(aux.prox.elemento==x){
                    achou = true;
                }
                if(!achou){
                    aux = aux.prox;
                }
            }
            if(achou){
                aux.prox = aux.prox.prox;
                if(aux.prox==null){
                    ultimo=aux;
                }
            }
        }
		return achou;
	}
}