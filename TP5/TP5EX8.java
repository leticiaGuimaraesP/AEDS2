package TP5;
import java.util.Scanner;

public class TP5EX8 {
    public static void main(String[] args) throws Exception{
        Scanner leia = new Scanner(System.in);
        int teste = leia.nextInt();
        for(int i=0; i<teste; i++){
            int qtde = leia.nextInt();
            ArvoreBinaria arvore = new ArvoreBinaria();
            for(int j=0; j<qtde; j++){
                int valor = Integer.parseInt(leia.next());
                arvore.inserir(valor);
            }
            System.out.println("Case "+(i+1)+":");
            System.out.print("Pre.: ");
            arvore.caminharPre();
            System.out.print("\n");
            System.out.print("In..: ");
            arvore.caminharCentral();
            System.out.print("\n");
            System.out.print("Post: ");
            arvore.caminharPos();
            System.out.print("\n\n");
        }
        leia.close();
    }
}
class No {
    public int elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.
    
    public No(int elemento) {
        this(elemento, null, null);
    }
    public No(int elemento, No esq, No dir) {
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

	public boolean pesquisar(int x) {
		return pesquisar(x, raiz);
	}
	private boolean pesquisar(int x, No i) {
      boolean resp;
		if (i == null) {
         resp = false;

      } else if (x == i.elemento) {
         resp = true;

      } else if (x < i.elemento) {
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
    
	public void inserir(int x) throws Exception {
		raiz = inserir(x, raiz);
	}
	private No inserir(int x, No i) throws Exception {
		if (i == null) {
         i = new No(x);
        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
        }
		return i;
	}

	
	public void remover(int x) throws Exception {
		raiz = remover(x, raiz);
	}
	private No remover(int x, No i) throws Exception {

		if (i == null) {
         throw new Exception("Erro ao remover!");

      } else if (x < i.elemento) {
         i.esq = remover(x, i.esq);

      } else if (x > i.elemento) {
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

   public int getRaiz() throws Exception {
      return raiz.elemento;
   }
}

