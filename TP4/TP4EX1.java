package TP4;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TP4EX1 {

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception{
       //Leitura da primeira parte da entrada
        String[] entrada = new String[1000];
        int numEntrada = 0;
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   

        
        //Leitura do arquivo csv
        //Scanner leia = new Scanner (new File("./tmp/games.csv"));
        Scanner leia = new Scanner (new File("/tmp/games.csv"));
        String[] entradaGames = new String[5000];  //criando outro vetor, onde cada posição guarda todas as infos de um jogo
        int cont = 0;
        while(leia.hasNext()){
            entradaGames[cont] = leia.nextLine();
            cont++;
        }

        
        CLista listaDeGame = new CLista(); //criação da lista dinâmica
        int index = 0;
        String app_id;

        //Formação de uma lista com a primeira parte da entrada
        for(int i=0; i<numEntrada; i++){
            for(int j=0; j<cont; j++){
                while (true) {  //separa o id de cada jogo do arquvio
                    index++;
                    if (entradaGames[j].charAt(index) == ',') {
                        app_id = entradaGames[j].substring(0, index);
                        break;
                    }
                }
                index=0;
                if(entrada[i].equals(app_id)){ //confere se é o jogo procurado
                    Game auxGame = new Game(); //cria um objeto game
                    auxGame.ler(entradaGames[j]); //preenche os atributos desse objeto
                    listaDeGame.insereFim(auxGame); //insere esse objeto em uma lista 
                    j=cont;
                }
            }            
        }
        //Leitura da segunda parte da entrada (NOMES DOS JOGOS - CHAVE)
        int numEntrada2 = MyIO.readInt();
        String comando, id;
        int posi=0;
        for(int i=0; i<numEntrada2; i++){
            comando=MyIO.readLine();
            if(comando.charAt(0)=='I'){ //se for para inserir
                if(comando.charAt(1)=='*'){
                    posi = Integer.parseInt(comando.substring(3,5)); //posição que será inserido um jogo
                    id = comando.substring(6, comando.length());
                }else{
                    id = comando.substring(3, comando.length()); //id do jogo a ser inserido
                }

                for(int j=0; j<cont; j++){
                    while (true) {  //separa o id de cada jogo do arquvio
                        index++;
                        if (entradaGames[j].charAt(index) == ',') {
                            app_id = entradaGames[j].substring(0, index);
                            break;
                        }
                    }
                    index=0;
                    if(id.equals(app_id)){ //confere se é o jogo procurado
                        Game auxGame = new Game(); //cria um objeto game
                        auxGame.ler(entradaGames[j]); //preenche os atributos desse objeto

                        if(comando.charAt(1)=='I'){ //Inserir no Inicio
                            listaDeGame.insereComeco(auxGame);
                        }else if(comando.charAt(1)=='F'){ //Inserir no Fim
                            listaDeGame.insereFim(auxGame);
                        }else if(comando.charAt(1)=='*'){ //Inserir na Posição
                            listaDeGame.inserir(auxGame, posi);
                        }
                        j=cont;
                    }
                }    

            }else if(comando.charAt(0)=='R'){
                Game auxGame = new Game(); //cria um objeto game
                if(comando.charAt(1)=='I'){ //Remover no Inicio
                    auxGame = listaDeGame.removeRetornaComeco();
                }else if(comando.charAt(1)=='F'){ //Remover no Fim
                    auxGame = listaDeGame.removeRetornaFim();
                }else if(comando.charAt(1)=='*'){  //Remover na Posição
                    posi = Integer.parseInt(comando.substring(3,5));
                    auxGame = listaDeGame.removeRetornaIndice(posi);
                }
                System.out.println("(R) "+auxGame.getName());
            }
        }
        listaDeGame.imprime(); //impressão dos elementos da lista
    }
}

class Game {

    static SimpleDateFormat default_dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);

    private String name, owners, website, developers;
    private ArrayList<String> languages, genres;
    private Date release_date;
    private int app_id, age, dlcs, avg_playtime;
    private float price, upvotes;
    private boolean windows, mac, linux;

    public Game() {
        this.name = this.owners = this.website = this.developers = null;
        this.languages = new ArrayList<String>();
        this.genres = new ArrayList<String>();
        this.release_date = null;
        this.app_id = this.age = this.dlcs = this.avg_playtime = -1;
        this.price = this.upvotes = -1;
        this.windows = this.mac = this.linux = false;
    }

    public Game(String name, String owners, String website, String developers, ArrayList<String> languages,
            ArrayList<String> genres, Date release_date, int app_id, int age, int dlcs, int upvotes, int avg_playtime,
            float price, boolean windows, boolean mac, boolean linux) {
        this.name = name;
        this.owners = owners;
        this.website = website;
        this.developers = developers;
        this.languages = languages;
        this.genres = genres;
        this.release_date = release_date;
        this.app_id = app_id;
        this.age = age;
        this.dlcs = dlcs;
        this.upvotes = upvotes;
        this.avg_playtime = avg_playtime;
        this.price = price;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    public void setAppId(int app_id) {
        this.app_id = app_id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void setAvgPlaytime(int avg_playtime) {
        this.avg_playtime = avg_playtime;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    public void setMac(boolean mac) {
        this.mac = mac;
    }

    public void setLinux(boolean linux) {
        this.linux = linux;
    }

    public String getName() {
        return this.name;
    }

    public String getOwners() {
        return this.owners;
    }

    public String getWebsite() {
        return this.website;
    }

    public String getDevelopers() {
        return this.developers;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public ArrayList<String> getGenres() {
        return this.genres;
    }

    public Date getReleaseDate() {
        return this.release_date;
    }

    public int getAppId() {
        return this.app_id;
    }

    public int getAge() {
        return this.age;
    }

    public int getDlcs() {
        return this.dlcs;
    }

    public int getAvgPlaytime() {
        return this.avg_playtime;
    }

    public float getPrice() {
        return this.price;
    }

    public float getUpvotes() {
        return this.upvotes;
    }

    public boolean getWindows() {
        return this.windows;
    }

    public boolean getMac() {
        return this.mac;
    }

    public boolean getLinux() {
        return this.linux;
    }

    public Game clone() {
        Game cloned = new Game();
        cloned.name = this.name;
        cloned.owners = this.owners;
        cloned.website = this.website;
        cloned.developers = this.developers;
        cloned.languages = this.languages;
        cloned.genres = this.genres;
        cloned.release_date = this.release_date;
        cloned.app_id = this.app_id;
        cloned.age = this.age;
        cloned.dlcs = this.dlcs;
        cloned.avg_playtime = this.avg_playtime;
        cloned.price = this.price;
        cloned.upvotes = this.upvotes;
        cloned.windows = this.windows;
        cloned.mac = this.mac;
        cloned.linux = this.linux;
        return cloned;
    }

    public void ler(String line) {
        char c_search;
        int index = 0, atr_index = 0;

        // ---------------------------------- //
        // Find "AppID"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.app_id = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Name"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.name = line.substring(atr_index, index);
                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //
        // Find release date
        if (line.charAt(atr_index) != ',') {
            SimpleDateFormat df;
            if (line.charAt(atr_index) == '\"') {
                df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                atr_index++;
                c_search = '\"';
            } else {
                df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
                c_search = ',';
            }
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    try {
                        this.release_date = df.parse(line.substring(atr_index, index));
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                    if (c_search == ',')
                        index++;
                    else if (c_search == '\"')
                        index += 2;
                    atr_index = index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //
        // Find "Owners"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.owners = line.substring(atr_index, index);
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Age"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.age = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Price"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.price = Float.parseFloat(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "DLCs"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.dlcs = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Languages"
        while (true) {
            index++;
            if (line.charAt(index) == ']') {
                index++;
                if (line.charAt(index) == ',')
                    index++;
                else if (line.charAt(index) == '\"')
                    index += 2;
                atr_index = index;
                break;
            } else if (line.charAt(index) == '\'') {
                int wordStart = index + 1;
                while (true) {
                    index++;
                    if (line.charAt(index) == '\'') {
                        this.languages.add(line.substring(wordStart, index));
                        break;
                    }
                }
            }
        }

        // ---------------------------------- //
        // Find "Website"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';

            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.website = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;

        // ---------------------------------- //

        // Find "Windows"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.windows = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // Find "Mac"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.mac = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // Find "Linux"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.linux = Boolean.parseBoolean(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Upvotes"
        int positives, negatives;
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                positives = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                negatives = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }
        this.upvotes = (float) (positives * 100) / (float) (positives + negatives);

        // ---------------------------------- //
        // Find "AVG Playtime"
        while (true) {
            index++;
            if (line.charAt(index) == ',') {
                this.avg_playtime = Integer.parseInt(line.substring(atr_index, index));
                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        // Find "Developers"
        if (line.charAt(atr_index) != ',') {
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                c_search = '\"';
            } else
                c_search = ',';
            while (true) {
                index++;
                if (line.charAt(index) == c_search) {
                    this.developers = line.substring(atr_index, index);
                    atr_index = ++index;
                    break;
                }
            }
        } else
            atr_index = ++index;
        // ---------------------------------- //

        // Find "Genres"
        if (index < line.length() - 1) {
            if (line.charAt(index) == ',')
                atr_index = ++index;
            if (line.charAt(atr_index) == '\"') {
                atr_index++;
                while (true) {
                    index++;
                    if (line.charAt(index) == ',') {
                        this.genres.add(line.substring(atr_index, index));
                        atr_index = ++index;
                    } else if (line.charAt(index) == '\"') {
                        this.genres.add(line.substring(atr_index, line.length() - 1));
                        break;
                    }
                }
            } else
                this.genres.add(line.substring(atr_index, line.length()));
        }
    }

    public void imprimir() {
        String avg_pt = null;
        if (this.avg_playtime == 0)
            avg_pt = "null ";
        else if (this.avg_playtime < 60)
            avg_pt = this.avg_playtime + "m ";
        else {
            if (this.avg_playtime % 60 == 0)
                avg_pt = this.avg_playtime / 60 + "h ";
            else
                avg_pt = (this.avg_playtime / 60) + "h " + (this.avg_playtime % 60) + "m ";
        }

        DecimalFormat df = new DecimalFormat("##");
        System.out.println(this.app_id + " " + this.name + " " + default_dateFormat.format(this.release_date) + " "
                + this.owners + " " + this.age + " " + String.format("%.2f", this.price) + " " + this.dlcs + " "
                + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " "
                + (Float.isNaN(this.upvotes) ? "0.0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers
                + " " + this.genres);
    }
}

class CCelula {
	public Game item;
	public CCelula prox;    	
    public CCelula(Game valorItem, CCelula proxCelula){
        item = valorItem;
        prox = proxCelula;
    }    			
    public CCelula(Game valorItem){
        item = valorItem;
        prox = null;
    }    			        	
    public CCelula(){
    	item = null;
        prox = null;
    }    			        	
}

class CLista {

	private CCelula primeira; // Referencia a célula cabeça
	private CCelula ultima; // Referencia a última célula da lista
	private int qtde; // Contador de itens na lista. Deve ser incrementado sempre que um item for
						// inserido e decrementado quando um item for excluído.

	// Função construtora. Aloca a célula cabeça e faz todas as referências
	// apontarem para ela.
	public CLista() {
		primeira = new CCelula();
		ultima = primeira;
	}

	// Verifica se a lista está vazia. Retorna TRUE se a lista estiver vazia e FALSE
	// se ela tiver elementos.
	public boolean vazia() {
		return primeira == ultima;
	}

	// Insere um novo Item no fim da lista.
	public void insereFim(Game valorItem) {
		ultima.prox = new CCelula(valorItem);
		ultima = ultima.prox;
		qtde++;
	}

	// Insere um novo Item no começo da lista
	public void insereComeco(Game valorItem) {
		CCelula aux = primeira.prox;
		primeira.prox = new CCelula(valorItem, aux);
		if (aux == null)
			ultima = primeira.prox;
		qtde++;
	}

	public void inserir(Game x, int pos) throws Exception {

        if(pos < 0 || pos > qtde){
              throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + qtde + ") invalida!");
        } else if (pos == 0){
           insereComeco(x);
        } else if (pos == qtde){
           insereFim(x);
        } else {
           CCelula i = primeira;
           for(int j = 0; j < pos; j++, i = i.prox);
          
           CCelula tmp = new CCelula(x);
           tmp.prox = i.prox;
           i.prox = tmp;
           tmp = i = null;
        }
     }

	// Imprime todos os elementos da lista usando o comando for
	public void imprime() {
        int cont=0;
		for (CCelula aux = primeira.prox; aux != null; aux = aux.prox){
            System.out.print("["+cont+"] ");
            aux.item.imprimir();
            cont++;
        }	
	}

	// Verifica se o elemento passado como parâmetro está contido na lista. (Obs:
	// usando o comando FOR)
	// O parâmetro "elemento" é o item a ser localizado. O método retorna TRUE caso
	// o Item esteja presente na lista.
	public boolean contemFor(Game elemento) {
		boolean achou = false;
		for (CCelula aux = primeira.prox; aux != null && !achou; aux = aux.prox)
			achou = aux.item.equals(elemento);
		return achou;
	}

	// Retorna um Object contendo o primeiro Item da lista. Se a lista estiver vazia
	// a função retorna null.
	public Game retornaPrimeiro() {
		if (primeira != ultima)
			return primeira.prox.item;
		else
			return null;
	}

	// Retorna um Object contendo o último Item da lista. Se a lista estiver vazia a
	// função retorna null.
	public Game retornaUltimo() {
		if (primeira != ultima)
			return ultima.item;
		else
			return null;
	}

	// Retorna o Item contido na posição passada por parâmetro
	public Game retornaIndice(int posicao) {
		// EXERCÍCIO : deve retornar o elemento da posição p passada por parâmetro
		// [cabeça]->[7]->[21]->[13]->null
		// retornaIndice(2) deve retornar o elemento 21. retornaIndice de uma posiçao
		// inexistente deve retornar null.
		// Verifica se é uma posição válida e se a lista possui elementos
		if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {

			// Procura a posicao a ser retornada
			CCelula aux = primeira.prox;
			for (int i = 1; i < posicao; i++, aux = aux.prox)
				;
			return aux.item;
		}
		return null;
	}

	// Remove e retorna o primeiro item da lista (remoção física, ou seja, elimina a
	// célula que contém o elemento).
	// Retorna um Object contendo o Item removido ou null caso a lista esteja vazia.
	public Game removeRetornaComeco() {
		// Verifica se há elementos na lista
		if (primeira != ultima) {
			CCelula aux = primeira.prox;
			primeira.prox = aux.prox;
			if (primeira.prox == null) // Se a célula cabeça está apontando para null, significa que o único elemento
										// da lista foi removido
				ultima = primeira;
			qtde--;
			return aux.item;
		}
		return null;
	}

	// Remove o último Item da lista.
	// Retorna um Object contendo o Item removido ou null caso a lista esteja vazia.
	public Game removeRetornaFim() {
		if (primeira != ultima) {
			CCelula aux = primeira;
			while (aux.prox != ultima)
				aux = aux.prox;
			CCelula aux2 = aux.prox;
			ultima = aux;
			ultima.prox = null;
			qtde--;
			return aux2.item;
		}
		return null;
	}


	public Game remove(int pos) throws Exception {
        Game resp;
  
          if (primeira == ultima){
              throw new Exception("Erro ao remover (vazia)!");
  
        } else if(pos < 0 || pos >= qtde){
              throw new Exception("Erro ao remover (posicao " + pos + " / " + qtde + " invalida!");
        } else if (pos == 0){
           resp = removeRetornaComeco();
        } else if (pos == qtde - 1){
           resp = removeRetornaFim();
        } else {
             // Caminhar ate a posicao anterior a insercao
           CCelula i = primeira;
           for(int j = 0; j < pos; j++, i = i.prox);
          
           CCelula tmp = i.prox;
           resp = tmp.item;
           i.prox = tmp.prox;
           tmp.prox = null;
           i = tmp = null;
        }
  
          return resp;
      }
  

	// Remove o elemento na posição passada como parâmetro.
	// O parâmetro "posicao" é a posição a ser removida. OBS: o primeiro elemento
	// está na posição 1, e assim por diante.
	// O método retorna TRUE se a posição existe e foi removida com sucesso, e FALSE
	// caso a posição não exista.
	public boolean removeIndice(int posicao) {
		// Verifica se é uma posição válida e se a lista possui elementos
		if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {
			int i = 0;
			CCelula aux = primeira;
			while (i < posicao - 1) {
				aux = aux.prox;
				i++;
			}
			aux.prox = aux.prox.prox;
			if (aux.prox == null)
				ultima = aux;
			qtde--;
			return true;
		}
		return false;
	}

	// Remove e retorna o elemento na posição passada como parâmetro.
	// O parâmetro "posicao" é a posição a ser removida. OBS: o primeiro elemento
	// está na posição 1, e assim por diante.
	// O método retorna um object contendo o elemento removido da lista. Caso a
	// posição seja inválida, retorna null.
	public Game removeRetornaIndice(int posicao) {
		// Verifica se é uma posição válida e se a lista possui elementos
		if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {
			int i = 0;
			CCelula aux = primeira;
			while (i < posicao - 1) {
				aux = aux.prox;
				i++;
			}
			CCelula aux2 = aux.prox;
			aux.prox = aux.prox.prox;
			if (aux.prox == null)
				ultima = aux;
			qtde--;
			return aux2.item;
		}
		return null;
	}

	// Método(getter) que retorna a quantidade de itens da lista.
	public int quantidade() {
		return qtde;
	}

}