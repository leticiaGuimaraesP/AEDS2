#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int isPalindromo(char str[], int i){
    int validou; 
    if(i>=strlen(str)/2){  //se chegar ate a metade da String, siginifica que é um polidormo
            validou = 1;
        }else if(str[i]!=str[strlen(str)-i-1]){  //se forem diferentes, encerra o loop e retorna falso
            validou = 0;
        }else{
            validou = isPalindromo(str, i+1);
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
        if(isPalindromo(entrada[i], 0)==1){  //Se o metodo retornar 1 imprime SIM, caso contrário imprime NAO
            printf("SIM\n");
        }
        else{
            printf("NAO\n");
        }
    }
  return 0;
}