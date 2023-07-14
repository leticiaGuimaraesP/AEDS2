package TP5;
import java.util.Scanner;

public class TP5EX9 {
    public static void main(String[] args) throws Exception{
        Scanner leia = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();
        while(leia.hasNext()){
            String comando = leia.next();
            String elemento;
            if(comando.length()==1){
                elemento = leia.next();
                if(comando.equals("I")){
                    arvore.inserir(elemento);
                }else if(comando.equals("P")){
                    boolean achou = arvore.pesquisar(elemento);
                    if(achou){
                        System.out.println(elemento + " existe");
                    }else{
                        System.out.println(elemento + " nao existe");
                    }
                }
            }else{
                if(comando.equals("INFIXA")){
                    arvore.caminharCentral();
                    System.out.print("\n");
                }else if(comando.equals("PREFIXA")){
                    arvore.caminharPre();
                    System.out.print("\n");
                }else if(comando.equals("POSFIXA")){
                    arvore.caminharPos();
                    System.out.print("\n");
                }
            }
        }
        leia.close();
    }
}
class No {
    public String elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.
    
    public No(String elemento) {
        this(elemento, null, null);
    }
    public No(String elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }  
}

class ArvoreBinaria {
	private No raiz; // Raiz da arvore.

	public ArvoreBinaria() {
		raiz = null;
	}

	public boolean pesquisar(String x) {
		return pesquisar(x, raiz);
	}
	private boolean pesquisar(String x, No i) {
      boolean resp;
		if (i == null) {
         resp = false;

      } else if (x.equals(i.elemento)) {
         resp = true;

      } else if (x.compareTo(i.elemento) < 0) {
         resp = pesquisar(x, i.esq);

      } else {
         resp = pesquisar(x, i.dir);
      }
      return resp;
	}
    
	public void caminharCentral() {
		caminharCentral(raiz);
	}

	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.print(i.elemento + " "); // Conteudo do no.
			caminharCentral(i.dir); // Elementos da direita.
		}
	}

	public void caminharPre() {
		caminharPre(raiz);
	}

	private void caminharPre(No i) {
		if (i != null) {
			System.out.print(i.elemento + " "); // Conteudo do no.
			caminharPre(i.esq); // Elementos da esquerda.
			caminharPre(i.dir); // Elementos da direita.
		}
	}

	public void caminharPos() {
		caminharPos(raiz);
	}

	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq); // Elementos da esquerda.
			caminharPos(i.dir); // Elementos da direita.
			System.out.print(i.elemento + " "); // Conteudo do no.
		}
	}
    
	public void inserir(String x) throws Exception {
		raiz = inserir(x, raiz);
	}
	private No inserir(String x, No i) throws Exception {
		if (i == null) {
         i = new No(x);
        } else if (x.compareTo(i.elemento) < 0) {
            i.esq = inserir(x, i.esq);
        } else if (x.compareTo(i.elemento) > 0) {
            i.dir = inserir(x, i.dir);
        }
		return i;
	}

	
	public void remover(String x) throws Exception {
		raiz = remover(x, raiz);
	}
	private No remover(String x, No i) throws Exception {

		if (i == null) {
         throw new Exception("Erro ao remover!");

      } else if (x.compareTo(i.elemento) < 0) {
         i.esq = remover(x, i.esq);

      } else if (x.compareTo(i.elemento) > 0) {
         i.dir = remover(x, i.dir);

      // Sem no a direita.
      } else if (i.dir == null) {
         i = i.esq;

      // Sem no a esquerda.
      } else if (i.esq == null) {
         i = i.dir;

      // No a esquerda e no a direita.
      } else {
         i.esq = maiorEsq(i, i.esq);
		}

		return i;
	}
	private No maiorEsq(No i, No j) {

      // Encontrou o maximo da subarvore esquerda.
		if (j.dir == null) {
			i.elemento = j.elemento; // Substitui i por j.
			j = j.esq; // Substitui j por j.ESQ.

      // Existe no a direita.
		} else {
         // Caminha para direita.
			j.dir = maiorEsq(i, j.dir);
		}
		return j;
	}

   public String getRaiz() throws Exception {
      return raiz.elemento;
   }
}
