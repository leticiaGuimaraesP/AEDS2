package TP4;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import MyIO;


public class TP4EX4 {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String args[]) throws Exception{
        //Leitura do pub.in
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

        CListaDup listaDeGame = new CListaDup(); //criação da lista
        int index = 0;
        String app_id;

        //Formação da lista com os Games listados
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
                    listaDeGame.insereFim(auxGame); ;//insere esse objeto em uma lista 
                    j=cont;
                }
            }            
        }

        //Ordenação por Seleção
        listaDeGame.quicksort(1, listaDeGame.quantidade());     
        
        //Saida
        listaDeGame.imprimeInvFor();
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

class CCelulaDup {

	public Game item; // O Item armazendo pela clula
	public CCelulaDup ant; // Referencia a celula anterior
	public CCelulaDup prox; // Referencia a proxima celula

	public CCelulaDup() {
		item = null;
		ant = null;
		prox = null;
	}

	public CCelulaDup(Game valorItem) {
		item = valorItem;
		ant = null;
		prox = null;
	}

	public CCelulaDup(Game valorItem, CCelulaDup celulaAnt, CCelulaDup proxCelula) {
		item = valorItem;
		ant = celulaAnt;
		prox = proxCelula;
	}
}

class CListaDup {
	private CCelulaDup primeira; // Referencia a primeira celula da lista (celula cabeca)
	private CCelulaDup ultima; // Referencia a ultima celula da lista
	private int qtde;

	// Aloca a celula cabeca e faz todas as referencias
	// apontarem para ela.
	public CListaDup() {
		primeira = new CCelulaDup();
		ultima = primeira;
        qtde = 0;
	}

	// Verifica se a lista esta vazia.
	public boolean vazia() {
		return primeira == ultima;
	}

	// Insere um novo elemento no fim da lista.
	public void insereFim(Game valorItem) {
		ultima.prox = new CCelulaDup(valorItem, ultima, null);
		ultima = ultima.prox;
		qtde++;
	}

	// Insere um novo elemento no comeco da lista.
	public void insereComeco(Game valorItem) {
		if (primeira == ultima) { // Se a lista estiver vazia insere no fim
			ultima.prox = new CCelulaDup(valorItem, ultima, null);
			ultima = ultima.prox;
		} else { // senao insere no comeco
			primeira.prox = new CCelulaDup(valorItem, primeira, primeira.prox);
			primeira.prox.prox.ant = primeira.prox;
		}
		qtde++;
	}

	// Imprime todos os elementos da lista duplamente encadeada usando o comando
	// for.
	public void imprimeFor() {
		for (CCelulaDup aux = primeira.prox; aux != null; aux = aux.prox)
            aux.item.imprimir();
	}

	// Imprime todos os elementos da lista duplamente encadeada em sentido inverso
	// usando o comando for.
	public void imprimeInvFor() {
		for (CCelulaDup aux = ultima; aux.ant != null; aux = aux.ant)
			aux.item.imprimir();
	}

	// Verifica se o Item passado como parametro esta contido na lista. (Obs: usa o
	// comando FOR)
	public boolean contemFor(Game elemento) {
		boolean achou = false;
		for (CCelulaDup aux = primeira.prox; aux != null && !achou; aux = aux.prox)
			achou = aux.item.equals(elemento);
		return achou;
	}

	// Retorna o primeiro elemento da lista.
	public Game retornaPrimeiro() {
		if (primeira != ultima)
			return primeira.prox.item;
		return null;
	}

	// Retorna o Item contido na posicao p da lista.
	public Game retornaIndice(int posicao) {
		// EXERCÃ CIO : deve retornar o elemento da posicao p passada por parametro
		// [cabeca]->[7]->[21]->[13]->null
		// retornaIndice(2) deve retornar o elemento 21. retornaIndice de uma posicao
		// inexistente deve retornar null.
		// Se e uma posicao valida e a lista possui elementos
		if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {
			CCelulaDup aux = primeira.prox;
			// Procura a posicao a ser inserido
			for (int i = 1; i < posicao; i++, aux = aux.prox)
				;
			if (aux != null)
				return aux.item;
		}
		return null;
	}

	// Remove e retorna o primeiro elemento da lista.
	public Game removeRetornaComeco() {
		if (primeira != ultima) {
			CCelulaDup aux = primeira.prox;
			primeira = primeira.prox;
			primeira.ant = null;
			qtde--;
			return aux.item;
		}
		return null;
	}

	// Remove e retorna o ultimo elemento da lista.
	public Game removeRetornaFim() {
		if (primeira != ultima) {
			CCelulaDup aux = ultima;
			ultima = ultima.ant;
			ultima.prox = null;
			qtde--;
			return aux.item;
		}
		return null;
	}

	// Metodo que retorna a quantidade de elementos da lista.
	public int quantidade() {
		return qtde;
	}

    /**
    * Retorna o elemento na pos x, sem alterar a lista dupla
    * @param pos int posicao do elemento a ser retornado
    */
   public CCelulaDup elementoNaPosicao(int pos) throws Exception{   
       if(pos < 0 || pos > qtde)
           throw new Exception("Erro ao remover (posicao " + pos + " / " + qtde + " invalida!");
   
       // Caminhar ate a posicao anterior a desejada
       CCelulaDup i = primeira.prox;
       for(int j=1; j<pos; j++, i=i.prox);
       return i;
   }

    void quicksort(int esq, int dir) throws Exception {
        int i = esq, j = dir;
        CCelulaDup pivo = primeira.prox;
        for(int k = 1; k < (dir+esq)/2 && pivo.prox != null; k++, pivo = pivo.prox); //chega ate o pivo

        while (i <= j) {
            CCelulaDup aux1=primeira.prox;
            CCelulaDup aux2=ultima;
            for(aux1 = elementoNaPosicao(i); aux1.item.getReleaseDate().after(pivo.item.getReleaseDate()); aux1 = aux1.prox, i++);
            for(aux2 = elementoNaPosicao(j); aux2.item.getReleaseDate().before(pivo.item.getReleaseDate()); aux2 = aux2.ant, j--);
        
            if (i<=j) {
                Game tmp = aux1.item;
                aux1.item = aux2.item;
                aux2.item = tmp;
                i++;
                j--;
            }
        }
        if (esq < j){
            quicksort(esq, j);
        }  
        if (i < dir){
            quicksort(i, dir);
        }  
    }
}