/**
 
 * @file Game.c
 * @author Pedro Lopes
 * @version 0.2
 * @date 2022-10-02
 * @copyright Copyright (c) 2022
 
**/

// -------------------------------------------------------------------------------- //

// Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

// -------------------------------------------------------------------------------- //

// Definitions
#define MAX_GAMES               9000
#define MAX_FIELD_SIZE          250
#define MAX_STRING_ARRAY_SIZE   100

// -------------------------------------------------------------------------------- //

// Structs
typedef struct {

    int year,
        month;
} Date; 

typedef struct {

    char name[MAX_FIELD_SIZE],
        owners[MAX_FIELD_SIZE],
        website[MAX_FIELD_SIZE], 
        developers[MAX_FIELD_SIZE],
        languages[MAX_STRING_ARRAY_SIZE][30],
        genres[MAX_STRING_ARRAY_SIZE][30];

    Date release_date;
    int app_id, age, dlcs, avg_playtime, count_languages, count_genres;
    float price, upvotes;
    bool windows_os, mac_os, linux_os;

} Game;

// -------------------------------------------------------------------------------- //

// Global variables
Game games[MAX_GAMES];
int n = 0;

// Functions
bool isFim(char* line) { return line[0] == 'F' && line[1] == 'I' && line[2] == 'M'; }

void substring(char *string, char *string_start, int length) {

    strncpy(string, string_start, length);
    string[length] = '\0';
}

char *getMonthName(int month) {

    switch(month) {

		case 1: return "Jan"; break;
        case 2: return "Feb"; break;
        case 3: return "Mar"; break;
        case 4: return "Apr"; break;
        case 5: return "May"; break;
        case 6: return "Jun"; break;
        case 7: return "Jul"; break;
        case 8: return "Aug"; break;
        case 9: return "Sep"; break;
        case 10: return "Oct"; break;
        case 11: return "Nov"; break;
        case 12: return "Dec"; break;
        
		default: return "N/A"; break;
    }        
}

int getMonthNumber(char* month) {

    if(!strcmp(month, "Jan")) return 1;
    else if(!strcmp(month, "Feb")) return 2;
    else if(!strcmp(month, "Mar")) return 3;
    else if(!strcmp(month, "Apr")) return 4;
    else if(!strcmp(month, "May")) return 5;
    else if(!strcmp(month, "Jun")) return 6;
    else if(!strcmp(month, "Jul")) return 7;
    else if(!strcmp(month, "Aug")) return 8;
    else if(!strcmp(month, "Sep")) return 9;
    else if(!strcmp(month, "Oct")) return 10;
    else if(!strcmp(month, "Nov")) return 11;
    else if(!strcmp(month, "Dec")) return 12;
}

// Class game functions
void game_start(Game *game) {

    strcpy(game -> name, "");
    strcpy(game -> owners, "");
    strcpy(game -> website, "");
    strcpy(game -> developers, "");

    for(int i = 0; i < MAX_STRING_ARRAY_SIZE; i++) {
        
        strcpy(game -> languages[i], "");
        strcpy(game -> genres[i], "");
    }

    game -> release_date.month = -1;
    game -> release_date.year = -1;
    game -> app_id = -1;
    game -> age = -1;
    game -> dlcs = -1;
    game -> avg_playtime = -1;
    game -> price = -1;
    game -> upvotes = -1;
    game -> windows_os = false;
    game -> mac_os = false;
    game -> linux_os = false;

    game -> count_languages = 0;
    game -> count_genres = 0;
}

void game_print(Game *game) {

    int hours = game -> avg_playtime / 60,
        minutes = game -> avg_playtime % 60;

    printf("%i %s %s/%04i %s %i %.2f %i [", game -> app_id, game -> name, getMonthName(game -> release_date.month), game -> release_date.year, game -> owners, game -> age, game -> price, game -> dlcs);

    for(int i = 0; i < game -> count_languages; i++) {

        printf("%s%s", game -> languages[i], i < game -> count_languages - 1 ? ", " : "");
    }

    printf("] %s %s %s %s ", game -> website, game -> windows_os ? "true" : "false", game -> mac_os ? "true" : "false", game -> linux_os ? "true" : "false");

    if(isnan(game -> upvotes)) printf("0.0%% ");
    else printf("%.0f%% ", game -> upvotes);

    if(hours > 0)
    {
        printf("%ih ", hours);

        if(minutes > 0) printf("%im ", minutes);
    }
    else {

        if(minutes > 0) printf("%im ", minutes);
        else printf("null ");
    }

    printf("%s [", game -> developers);

    for(int i = 0; i < game -> count_genres; i++) {

        printf("%s%s", game -> genres[i], i < game -> count_genres - 1 ? ", " : "");
    }

    printf("]");
}

Game game_clone(Game *game) {
    
    Game cloned;

    strcpy(cloned.name, game -> name);
    strcpy(cloned.owners, game -> owners);
    strcpy(cloned.website, game -> website);
    strcpy(cloned.developers, game -> developers);

    for(int i = 0; i < game -> count_languages; i++) strcpy(cloned.languages[i], game -> languages[i]);
    for(int i = 0; i < game -> count_genres; i++) strcpy(cloned.genres[i], game -> genres[i]);
    
    cloned.release_date.month = game -> release_date.month;
    cloned.release_date.year = game -> release_date.year;
    cloned.app_id = game -> app_id;
    cloned.age = game -> age;
    cloned.dlcs = game -> dlcs;
    cloned.avg_playtime = game -> avg_playtime;
    cloned.price = game -> price;
    cloned.upvotes = game -> upvotes;
    cloned.windows_os = game -> windows_os;
    cloned.mac_os = game -> mac_os;
    cloned.linux_os = game -> linux_os;
    return cloned;
}

void game_read(Game *game, char *line) {

    char c_search, sub[MAX_FIELD_SIZE];
    int index = 0, atr_index = 0;

    // ------------------------------------------------------------ //

    // Find "AppID"
    while(true) {

        index++;

        if(line[index] == ',') {
            
            substring(sub, &line[atr_index], index - atr_index);

            game -> app_id = atoi(sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Name"
    if(line[atr_index] != ',') {

        if(line[atr_index] == '\"') {
            
            atr_index++;
            c_search = '\"';
        }
        else c_search = ',';
        
        while(true) {

            index++;

            if(line[index] == c_search) {
                
                substring(sub, &line[atr_index], index - atr_index);
                strcpy(game -> name, sub);

                if(c_search == ',') index++;
                else if(c_search == '\"') index += 2;
                
                atr_index = index;
                break;
            }
        }
    }
    else {

        strcpy(game -> name, "null");

        atr_index = ++index;
    }

    // ------------------------------------------------------------ //
    
    // Find release date
    if(line[atr_index] != ',') {

        if(line[atr_index] == '\"') {
            
            atr_index++;
            c_search = '\"';
        }
        else c_search = ',';

        while(true) {

            index++;

            if(line[index] == c_search) {

                substring(sub, &line[atr_index], index - atr_index);

                char subDate[10];

                substring(subDate, &sub[0], 3);

                game -> release_date.month = getMonthNumber(subDate);

                if(c_search == ',') {
                    
                    substring(subDate, &sub[4], 4);

                    game -> release_date.year = atoi(subDate);

                    index++;
                }
                else if(c_search == '\"') {
                    
                    int nmbSpace = 0;

                    for(int i = 0; ; i++) {

                        if(sub[i] == ' ') nmbSpace++;

                        if(nmbSpace == 2) {

                            i++;

                            substring(subDate, &sub[i], 4);

                            game -> release_date.year = atoi(subDate);
                            break;
                        }
                    }

                    index += 2;
                }

                atr_index = index;
                break;
            }
        }
    }
    else {

        game -> release_date.month = 0;
        game -> release_date.year = 0;

        atr_index = ++index;
    }

    // ------------------------------------------------------------ //
    
    // Find "Owners"
    while(true) {

        index++;

        if(line[index] == ',') {
            
            substring(sub, &line[atr_index], index - atr_index);
            strcpy(game -> owners, sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Age"
    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            game -> age = atoi(sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Price"
    while(true) {

        index++;

        if(line[index] == ',') {
            
            substring(sub, &line[atr_index], index - atr_index);
            
            game -> price = atof(sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "DLCs"
    while(true) {

        index++;

        if(line[index] == ',') {
            
            substring(sub, &line[atr_index], index - atr_index);

            game -> dlcs = atoi(sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Languages"
    while(true) {

        index++;

        if(line[index] == ']') {

            index++;
            
            if(line[index] == ',') index++;
            else if(line[index] == '\"') index += 2;

            atr_index = index;
            break;
        }
        else if(line[index] == '\'') {

            int wordStart = index + 1;

            while(true) {

                index++;

                if(line[index] == '\'') {
                    
                    substring(sub, &line[wordStart], index - wordStart);
                    strcpy(game -> languages[game -> count_languages++], sub);
                    break;
                }
            }
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Website"
    if(line[atr_index] != ',') {

        if(line[atr_index] == '\"') {
            
            atr_index++;
            c_search = '\"';
        }
        else c_search = ',';
        
        while(true) {

            index++;

            if(line[index] == c_search) {
                
                substring(sub, &line[atr_index], index - atr_index);
                strcpy(game -> website, sub);

                atr_index = ++index;
                break;
            }
        }
    }
    else {

        strcpy(game -> website, "null");

        atr_index = ++index;
    }

    // ------------------------------------------------------------ //
    
    // Find "Windows"
    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            if(!strcmp(sub, "True")) game -> windows_os = true;

            atr_index = ++index;
            break;
        }
    }

    // Find "Mac"
    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            if(!strcmp(sub, "True")) game -> mac_os = true;

            atr_index = ++index;
            break;
        }
    }

    // Find "Linux"
    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            if(!strcmp(sub, "True")) game -> linux_os = true;

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Upvotes"
    int positives, negatives;

    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            positives = atoi(sub);
            atr_index = ++index;
            break;
        }
    }

    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            negatives = atoi(sub);
            atr_index = ++index;
            break;
        }
    }

    game -> upvotes = (float)(positives * 100) / (float)(positives + negatives);

    // ------------------------------------------------------------ //
    
    // Find "AVG Playtime"
    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            game -> avg_playtime = atoi(sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Developers"
    if(line[atr_index] != ',') {

        if(line[atr_index] == '\"') {
            
            atr_index++;
            c_search = '\"';
        }
        else c_search = ',';
        
        while(true) {

            index++;

            if(line[index] == c_search) {
                
                substring(sub, &line[atr_index], index - atr_index);
                strcpy(game -> developers, sub);

                atr_index = ++index;
                break;
            }
        }
    }
    else {

        strcpy(game -> developers, "null");

        atr_index = ++index;
    }

    // ------------------------------------------------------------ //
    
    // Find "Genres"
    if(index < strlen(line) - 1) {

        if(line[index] == ',') atr_index = ++index;                    

        if(line[atr_index] == '\"') {

            atr_index++;
            
            while(true) {

                index++;

                if(line[index] == ',') {
                    
                    substring(sub, &line[atr_index], index - atr_index);
                    strcpy(game -> genres[game -> count_genres++], sub);

                    atr_index = ++index;
                }
                else if(line[index] == '\"') {

                    substring(sub, &line[atr_index], strlen(line) - 1 - atr_index);

                    if(sub[strlen(sub) - 1] == '\"') sub[strlen(sub) - 1] = '\0';
                    else if(sub[strlen(sub) - 2] == '\"') sub[strlen(sub) - 2] = '\0';

                    strcpy(game -> genres[game -> count_genres++], sub);
                    break;
                }
            }
        }
        else {

            substring(sub, &line[atr_index], strlen(line) - 2 - atr_index);

            strcpy(game -> genres[game -> count_genres++], sub);   
        }
    }
}

void list_insert(Game x) {

    if(n >= MAX_GAMES) {

        printf("Insert error: MAX_GAMES reached");
        exit(1);
    } 

    games[n++] = x;
}

// ---------------------------------------------------------------------------------------------------------- //

Game removeGame(int position, Game ListGames[], int* currentPosition) {
    if(*currentPosition == 0 || position < 0 || position >= *currentPosition) {
        printf("Erro ao remover!");
        exit(1);
    }

    Game gameRemove;
    game_start(&gameRemove);

    gameRemove = ListGames[position];
    --*currentPosition;

    for(int i=position; i<*currentPosition; i++) {
        ListGames[i] = ListGames[i+1];
    }

    return gameRemove;
}

Game removeEnd(Game ListGames[], int* currentPosition) {
    if(*currentPosition == 0) {
        printf("Erro ao remover!");
        exit(1);
    }
    
    return ListGames[--*currentPosition];
}

Game removeStart(Game ListGames[], int* currentPosition) {
    if(*currentPosition == 0) {
        printf("Erro ao remover!");
        exit(1);
    }

    Game gameRemove;
    game_start(&gameRemove);

    gameRemove = ListGames[0];
    --*currentPosition;

    for(int i=0; i<*currentPosition; i++) {
        ListGames[i] = ListGames[i+1];
    }

    return gameRemove;
}

void insert(Game *game, int position, Game ListGames[], int* currentPosition) {
    if(*currentPosition >= 150 || position < 0 || position > *currentPosition) {
        printf("Erro ao inserir!");
        exit(1);
    }

    for(int i=*currentPosition; i > position; i--) {
        ListGames[i] = ListGames[i-1];
    }

    ListGames[position] = *game;
    ++*currentPosition;
}

void insertEnd(Game *game, Game ListGames[], int* currentPosition) {
    if(*currentPosition >= 150) {
        printf("Erro ao inserir!");
        exit(1);
    }

    ListGames[*currentPosition] = *game;
    ++*currentPosition;
}

void insertStart(Game *game, Game ListGames[], int* currentPosition) {
    if(*currentPosition >= 150) {
        printf("Erro ao inserir!");
        exit(1);
    }

    for(int i=*currentPosition; i>0; i--) {
        ListGames[i] = ListGames[i-1];
    }

    ListGames[0] = *game;
    ++*currentPosition;
}

Game searchGameInGameList(Game fileGamesList[], int idLine) {
    Game game;

    for(int i=0; i<4403; i++) {
        if(idLine == fileGamesList[i].app_id) {
            game = fileGamesList[i];
            i = 4403;
        }
    }
    
    return game;
}

void arrysList(Game fileGamesList[], Game gamesPubIn[], int numberOfPositions){
    Game ListGames[150];
    int currentPosition = 0;

    for(int i=0; i<numberOfPositions; i++) {
        game_start(&ListGames[currentPosition]);
        ListGames[currentPosition++] = gamesPubIn[i];
    }

    int size = 0;
    char pubIn[10];
    Game game;
    Game removedGames[50];
    int removedGamesPosition = 0;

    scanf("%d", &size);
    game_start(&game);

    for(int i=0; i<size; i++) {
        scanf("%s", pubIn);

        if((strcmp(pubIn, "II")) == 0) {
            int idLine = 0;
            scanf("%d", &idLine);
            
            game = searchGameInGameList(fileGamesList, idLine);

            insertStart(&game, ListGames, &currentPosition);
            // printf("II "); show(&ListGames[0]); printf("%d\n", currentPosition);
        } else if((strcmp(pubIn, "IF")) == 0) {
            int idLine = 0;
            scanf("%d", &idLine);

            game = searchGameInGameList(fileGamesList, idLine);

            insertEnd(&game, ListGames, &currentPosition);
            // printf("IF "); show(&ListGames[currentPosition]); printf("%d\n", currentPosition);
        } else if((strcmp(pubIn, "I*")) == 0) {
            int idLine = 0, futureGamePosition = 0;
            scanf("%d", &futureGamePosition);
            scanf("%d", &idLine);

            game = searchGameInGameList(fileGamesList, idLine);

            insert(&game, futureGamePosition, ListGames, &currentPosition);
            // printf("I* "); show(&ListGames[futureGamePosition]); printf("%d\n", currentPosition);
        } else if((strcmp(pubIn, "RI")) == 0) {
            removedGames[removedGamesPosition++] = removeStart(ListGames, &currentPosition);
            
        } else if((strcmp(pubIn, "RF")) == 0) {
            removedGames[removedGamesPosition++] = removeEnd(ListGames, &currentPosition);
        } else if((strcmp(pubIn, "R*")) == 0){
            int futureGamePosition = 0;
            scanf("%d", &futureGamePosition);

            removedGames[removedGamesPosition++] = removeGame(futureGamePosition, ListGames, &currentPosition);
        }
    }


    for(int i=0; i<removedGamesPosition; i++) {
        printf("(R) %s\n", removedGames[i].name);
    }

    printf("[0] ");
    game_print(&ListGames[0]);
    for(int i=1; i<currentPosition; i++) {
        printf("\n");
        game_print(&ListGames[i]);
    }
}

Game getMaior(){
    Game maior = array[0];
    int i;
    for(i=1; i<n; i++){
        if(array[i]>maior){
            maior = array[i];
        }
    }
    return maior;
}

//TROCAR O ARRAY
void countingSort(){
    int count[getMaior()+1];
    int ordenado[n];
    int i;
    for(i=0; i<(getMaio()+1); count[i]=0; i++);
    for(i=0; i<n; count[array[i]]++; i++);
    for(i=1; i<(getMaio()+1); count[i]+=count[i-1]; i++);
    for(i=n-1; i>=0; ordenado[count[array[i]]-1] = array[i], count[array[i]]--; i--);
}


int main() {
    FILE *fp;
    char *line = NULL;
    size_t len = 0;
    size_t read;
    Game *listGames;
    listGames = (Game*)malloc(4403*sizeof(Game));
    int counter = 0;

    fp = fopen("tmp/games.csv", "r");
    if(fp == NULL) {
        fp = fopen("/tmp/games.csv", "r");
    } 

    if(fp == NULL) exit(EXIT_FAILURE);
    
    // Fill games list
    while((read = getline(&line, &len, fp)) != -1) {
        game_start(listGames+counter); 
        game_read((listGames+counter), line);
        counter++;
    }

    fclose(fp);
    if(line) free(line);
    
    Game *pubIn;
    int counterPubIn=0;
    pubIn = (Game*)malloc(100*sizeof(Game));
    char in[15];
    scanf(" %[^\n]s", in);

    while(true) {

        if(isFim(in)) break;
        else {

            int app_id = atoi(in);

            for(int i = 0; i < counter; i++) {

                if(listGames[i].app_id == app_id) {
                    game_start(pubIn+counterPubIn);
                    pubIn[counterPubIn] = listGames[i];
                    // game_print(pubIn+counterPubIn);
                    counterPubIn++;
                    break;
                }
            }

            // ------------------------- //
    
            scanf(" %[^\n]s", in);
        }
    }

    arrysList(&listGames, pubIn, counterPubIn);

    return EXIT_SUCCESS;
}