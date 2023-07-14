package TP2;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TP2EX7 {

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
        
        FilaCircular filaDeGame = new FilaCircular(5); //criação da lista
        int index = 0;
        String app_id;
        float somatorio=0, media=0, tam=0;

        //formação de uma lista com a primeira parte da entrada
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
                    if(tam<5){ 
                        tam++; //controla a quantidade de elementos na fila
                    }else{
                        Game removido = filaDeGame.desenfileira(); //se a fila estiver cheia, remove um elemento antes de inserir
                        somatorio -= removido.getAvgPlaytime();
                        //System.out.println("   valor removido do somatorio): "+removido.getAvgPlaytime()+"   valor a ser inserido:"+auxGame.getAvgPlaytime());
                    }
                    filaDeGame.enfileira(auxGame);
                    somatorio += auxGame.getAvgPlaytime();
                    media = somatorio/tam;
                    //System.out.println("valor do avg do novo elemento da lista:"+auxGame.getAvgPlaytime()+" - Somatorio: "+somatorio +" / " + tam + " = " + media);
                    System.out.println(Math.round(media)); //arredonda o numero

                    
                    j=cont; //sair do for
                }
            }            
        }
        //Leitura da segunda parte da entrada (NOMES DOS JOGOS - CHAVE)
        int numEntrada2 = MyIO.readInt();
        String comando, id;
        
        for(int i=0; i<numEntrada2; i++){
            comando=MyIO.readLine();
            if(comando.charAt(0)=='I'){ //se for para inserir
                id = comando.substring(2, comando.length()); //id do jogo a ser inserido
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
                        if(tam<5){
                            tam++; //controla a quantidade de elementos na fila
                        }else{
                            Game removido = filaDeGame.desenfileira();
                            somatorio -= removido.getAvgPlaytime(); //subtrai do total o id que esta sendo removido da fila
                        }
                        filaDeGame.enfileira(auxGame);
                        somatorio += auxGame.getAvgPlaytime();  //adiciona o novo id no somatório
                        media = somatorio/tam;
                        System.out.println("I "+id);
                        System.out.println(Math.round(media)); //arredonda o numero 
                        j=cont;
                    }
                }    
            }else if(comando.charAt(0)=='R'){
                Game auxGame = new Game(); //cria um objeto game
                auxGame = filaDeGame.desenfileira();
                tam--; //controla a quantidade de elementos na fila
                somatorio -= filaDeGame.retornaAvgPt(); //subtrai do total o id que esta sendo removido da fila
                System.out.println("R");
                System.out.println("(R) "+auxGame.getName());
            }
        }
        filaDeGame.mostrar(); //impressão dos elementos da lista
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

class FilaCircular {
    private Game[] array;
    private int frente; // Aponta para a posição do vetor que armazena o primeiro elemento da fila
    private int tras;   // Aponta para a posição do vetor que armazena o último elemento da fila

 
    public FilaCircular(int tamanho){
       array = new Game[tamanho];
       frente = tras = 0;
    }
 
    public boolean enfileira(Game item) {
        array[tras % array.length] = item;
        tras++;
        //System.out.print("EM - F: "+frente);System.out.println("   T: "+tras);
        return true;
    }
 
    public Game desenfileira() {
       //validar remocao
       if (frente == tras){
        return null;
       }
        Game resp = array[frente]; 
        frente = (frente+1)%array.length;
        //System.out.print("DES - F: "+frente);System.out.println("  T: "+tras);
        return resp;
    }
  
    public void mostrar() { 
        if(frente>tras){
            for (int i=frente; i<array.length; i++) {
                System.out.print("["+i+"] ");
                array[(i%array.length)].imprimir();
            }
            for (int i=0; i<(tras%array.length); i++) {
                System.out.print("["+i+"] ");
                array[(i%array.length)].imprimir();
            }
        }else{
            for (int i=frente; i<(tras%array.length); i++) {
                System.out.print("["+i+"] ");
                array[(i%array.length)].imprimir();
            }
        }
		
	}
 
    public boolean vazia() {
       return frente == tras; 
    }

    public int retornaAvgPt(){
        return array[frente].getAvgPlaytime();
    }

}