#include <stdio.h>
#include <stdlib.h>
#include <string.h>

 //Percorre toda a String e compara duas letras - a primeira com a ultima e sucessivamente
int isPalindromo(char str[]){
    int validou = 1;
    for(int i=0; i<strlen(str); i++){  //strlen retorna o tamanho da "String"
        if(str[i]!=str[strlen(str)-i-1]){  
            validou=0;   //Caso alguma letra seja diferente, ja pode encerrar o loop e, assim, o metodo retorna 0
        }
    }
    return validou;
}

//testa se a entrada chegou ao fim
int isFim(char s[100]){
    int validou = 0;
    if(strlen(s)==3 && s[0]=='F' && s[1]=='I' && s[2]=='M'){
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
    numEntrada--;//Desconsiderar ultima linha contendo a palavra FIM

    //Para cada linha de entrada, gerando uma de saida 
    for(int i=0; i<numEntrada; i++){
        if(isPalindromo(entrada[i])==1){  //Se o metodo retornar 1 imprime SIM, caso contrário imprime NAO
            printf("SIM\n");
        }
        else{
            printf("NAO\n");
        }
    }
  return 0;
}