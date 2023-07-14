#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int isVogal(char str[]){
    int validou = 1;
    int i;
    for(i=0; i<strlen(str); i++){
        if (((str[i] >= 'A') && (str[i] <= 'Z')) ||  //testa se a String e formada por apenas letras
          ((str[i] >= 'a') && (str[i] <= 'z'))){
            if(((str[i]!='a') && (str[i]!='A')) &&   //se todas as condiçoes forem verdadeiras - a letra testada nao for vogal - validou recebe 0 
              ((str[i]!='e') && (str[i]!='E')) &&
              ((str[i]!='i') && (str[i]!='I')) &&
              ((str[i]!='o') && (str[i]!='O')) &&
              ((str[i]!='u') && (str[i]!='U'))){
                validou = 0;
                i = strlen(str)+1;
            }
          }else{
            validou = 0;    
            i = strlen(str)+1;   //se uma das letras nao for vogal, ja pode encerrar o loop
          }   
      }    
      return validou;
}

int isConsoante (char str[]){
    int validou = 1;
    int i;
    for(i=0; i<strlen(str); i++){
        if (((str[i] >= 'A') && (str[i] <= 'Z')) ||   //testa se a String e formada por apenas letras
          ((str[i] >= 'a') && (str[i] <= 'z'))) {
            if ((str[i] == 'A') || (str[i]== 'a') ||  //se uma das condiçoes forem verdadeiras, significa que exitem vogais na String
                (str[i] == 'E') || (str[i] == 'e') ||  //entao, validou recebe false e retorna esse resultado
                (str[i] == 'I') || (str[i] == 'i') ||
                (str[i] == 'O') || (str[i] == 'o') ||
                (str[i] == 'U') || (str[i] == 'u')) {
                    validou = 0;
                    i = strlen(str)+1;
            }
        }else{
            validou = 0;
            i = strlen(str)+1;
        }
      }
      return validou;
}

int isInteger (char str[]){
    int validou = 1;
    int i;
    for (i=0; i<strlen(str); i++) {
        if ((str[i]<'0'||str[i]>'9')) {   //testa se a String tem apenas numeros
            validou = 0;
            i = strlen(str)+1;
        }
    }
    return validou;
} 

int isReal (char str[]){
    int validou = 1;
    int i, cont=0;
    for (int i = 0; i < strlen(str); i++) {
      if ((str[i]>='0'&&str[i]<='9')||str[i]==','||str[i]=='.') {   //testa se a String tem apenas numeros ou ,
          if(str[i]=='.'||str[i]==','){ 
            cont++;     //faz a contagem de virgulas/pontos
            if(cont>1){    //se tiver mais de um ponto ou virgula, o metodo retorna false
              validou = 0;
              i = strlen(str)+1;
            }
          }
      }else{
        validou = 0;
        i = strlen(str)+1;
      }
    }
      return validou;
}


//testa se a entrada chegou ao fim
int isFim(char s[]){
    int validou = 0;
    if(strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M'){
        validou = 1; //encerrar leitura
    }
    return validou;
}

int main(){
    char entrada[1000][1000];
    int numEntrada=0;

    //Leitura da entrada padrao
    do {
        scanf(" %[^\n]", entrada[numEntrada]); 
    } while (isFim(entrada[numEntrada++])==0);
    numEntrada--; //Desconsiderar ultima linha contendo a palavra FIM

    int i=0;
    //Para cada linha de entrada, gerando uma de saida 
    for(i=0; i<numEntrada; i++){
          if(isVogal(entrada[i])){
            printf("SIM ");
          }else{
            printf("NAO ");
          }

          if(isConsoante(entrada[i])){
            printf("SIM ");
          }else{
            printf("NAO ");
          }

          if(isInteger(entrada[i])){
            printf("SIM ");
          }else{
            printf("NAO ");
          }

          if(isReal(entrada[i])){
            printf("SIM\n");
          }else{
            printf("NAO\n");
          }
    }
  return 0;
}