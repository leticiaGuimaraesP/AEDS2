import MyIO;

package TP4;
public class TP4EX7 {
   public static void main(String[] args) throws Exception{
      int qtdeTeste, qtdeLinhas=0, qtdeColunas=0;
      int elemento;

      qtdeTeste = MyIO.readInt();
      for(int i=0; i<qtdeTeste; i++){
         qtdeLinhas = MyIO.readInt();
         qtdeColunas = MyIO.readInt();

         Matriz matriz1 = new Matriz(qtdeLinhas, qtdeColunas);
         
         for(int j=0; j<qtdeLinhas; j++){
            for(int k=0; k<qtdeColunas; k++){
               elemento = MyIO.readInt();
               matriz1.inserir(j, k, elemento); 
            }
         }
         
         qtdeLinhas = MyIO.readInt();
         qtdeColunas = MyIO.readInt();

         Matriz matriz2 = new Matriz(qtdeLinhas, qtdeColunas);
         for(int j=0; j<qtdeLinhas; j++){
            for(int k=0; k<qtdeColunas; k++){
               elemento = MyIO.readInt();
               matriz2.inserir(j, k, elemento);
            }
         }
         
         matriz1.mostrarDiagonalPrincipal();
         matriz1.mostrarDiagonalSecundaria();
         Matriz resp = matriz1.soma(matriz2);
         resp.mostrar();
         resp = matriz1.multiplicacao(matriz2);
         resp.mostrar();         
      }
   }
}

class Celula {
   public int elemento;
   public Celula inf, sup, esq, dir;
   public Celula(){
      this(0);
   }
   public Celula(int elemento){
      this(elemento, null, null, null, null);
   }
   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }
}

class Matriz {
   private Celula inicio;
   private int linha, coluna;

   public Matriz(){
      inicio = null;
   }

   public Matriz(int linha, int coluna){
      inicio = new Celula();
      this.linha = linha;
      this.coluna = coluna;

      //primeira Linha da matriz
      Celula aux = inicio;
      for(int i = 0; i<coluna-1; i++) {
          Celula nova = new Celula();
          aux.dir = nova;
          nova.esq = aux;
          aux = aux.dir; //passa para o novo elemento criado (muda de posição)
      }
      aux = null;

      //proximas linhas
      aux = inicio;
      for(int i = 0; i < linha; i++) {
         Celula atual = aux; //auxiliar para percorrer linha superior
         for(int j = 0; j < coluna; j++) {
            Celula nova = new Celula();
            nova.sup = atual;
            atual.inf = nova;
            
            if(atual.esq != null) { //testa se tem elemento a esquerda
               nova.esq = atual.esq.inf; //a nova célula aponta para a celula anterior a ela
               atual.esq.inf.dir = nova; //a célula anterior a nova célula aponta para esta
            }  
   
            if(atual.dir != null) { //testa se pode ter elemento a direita
               atual = atual.dir;
            }  
         }
         aux = aux.inf; //desce para a proxima linha
      }
   }

   public void inserir(int linha, int coluna, int elemento) {
      if(linha >= 0 || linha <= this.linha || coluna >= 0 || coluna <= this.coluna) {
         Celula referencia = inicio;
         Celula atual = referencia;
         //percorre toda a matriz
         for(int i=0; i<=linha; i++) {
            atual = referencia;
            for(int j=0; j<coluna; j++) {
               if(atual.dir != null) {
                  atual = atual.dir; 
               }
            }
            referencia = referencia.inf;
         }
         //insere o valor na celula 
         atual.elemento = elemento;
         atual = referencia = null;
      }   
   }

   public void mostrar() {
      Celula ref = inicio;
      Celula atual;
      for(int i=0; i<linha; i++) {
          atual = ref;
          for(int j=0; j<coluna; j++) {
              System.out.print(atual.elemento + " ");
              atual = atual.dir;
          }
          System.out.print("\n");
          ref = ref.inf;
      }
      ref = null;
      atual = null;
   }

   public Matriz soma (Matriz m) { 
      Matriz resp = null;
      if(this.linha == m.linha && this.coluna == m.coluna){
         resp = new Matriz(this.linha, this.coluna);
         Celula ref=resp.inicio, ref1=inicio, ref2=m.inicio; //inicializa as referencias
         for(int i=0; i<linha; i++){
            Celula aux=ref, aux1=ref1, aux2=ref2; //atualiza as referencias
            for(int j=0; j<coluna; j++){
               //sendo c (pont em resp), a (em this) e b (em m)
               aux.elemento = aux1.elemento + aux2.elemento;
               if(aux1.dir!=null){ //se ainda tiver coluna
                  aux = aux.dir;
                  aux1 = aux1.dir;
                  aux2 = aux2.dir;
               }
            }
            if(ref1.inf!=null){
               ref = ref.inf;
               ref1 = ref1.inf;
               ref2 = ref2.inf;
            }  
         }
      }
      return resp;
   }

   public Matriz multiplicacao (Matriz m) { //linha x * coluna x = elemento x
      Matriz resp = null;
      int result = 0;

      if(this.linha == m.linha && this.coluna == m.coluna){
         resp = new Matriz(linha, coluna);
         Celula primeiraRef = inicio, segundaRef = m.inicio;
         Celula pAtual, sAtual;
         for(int i = 0; i < linha; i++) {
            sAtual = segundaRef;
            for(int j = 0; j < m.coluna; j++) {       
               pAtual = primeiraRef;       
               for(int k = 0; k < m.linha; k++) {
                  result += pAtual.elemento * sAtual.elemento;
                  pAtual = pAtual.dir;
                  sAtual = sAtual.inf;
               }
               resp.inserir(i, j, result);
               sAtual = segundaRef.dir;
               result = 0;
            }
            primeiraRef = primeiraRef.inf;
         }        
      }
      return resp;
   }

   public boolean isQuadrada(){
      return (this.linha == this.coluna);
   }

   public void mostrarDiagonalPrincipal(){
      if(isQuadrada() == true){
         Celula aux = inicio, ref = inicio;
         for(int i=0; i<linha; i++){
            aux = ref;
            for(int j=0; j<coluna; j++){
               if(i==j){
                  System.out.print(aux.elemento+" ");
               }
               if(aux.dir!=null){
                  aux = aux.dir;
               }
            }
            if(ref.inf!=null){
               ref = ref.inf;
            }
         }
         System.out.print("\n");
      }
   }

   public void mostrarDiagonalSecundaria (){
      if(isQuadrada() == true){
         Celula aux = inicio, ref = inicio;
         for(int i=0; i<linha; i++){
            aux = ref;
            for(int j=0; j<coluna; j++){
               if(i+j==(linha-1)){
                  System.out.print(aux.elemento+" ");
               }
               if(aux.dir!=null){
                  aux = aux.dir;
               }
            }
            if(ref.inf!=null){
               ref = ref.inf;
            }
         }
         System.out.print("\n");
      }
   }

   public boolean pesquisar(int elemento){
      boolean achou = false;
      if(isQuadrada() == true){
         Celula aux = inicio, ref = inicio;
         for(int i=0; i<linha; i++){
            aux = ref;
            for(int j=0; j<coluna; j++){
               if(aux.elemento==elemento){
                  achou=true;
                  j=coluna;
                  i=linha;
               }else{
                  aux = aux.dir;
               }
            }
            if(ref.inf!=null){
               ref = ref.inf;
            }
         }
      }
      return achou;
   }
}

