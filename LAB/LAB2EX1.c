#include <stdio.h>
#include <string.h>

int main(){
    //strtok
    //3 5  11223345
    char primeira[1000];
    char segunda[1000];
    int i, tamanho;

    while(scanf("%s %s", primeira, segunda)!=EOF){
        int tamP=strlen(primeira);
        int tamS=strlen(segunda);
        if(tamP>tamS){
            tamanho=tamP;
        }else{
            tamanho=tamS;
        }
        for(int i=0; i<tamanho; i++) {
            if(i<tamP) {
                printf("%c", primeira[i]);
            }
            if(i<tamS) {
                printf("%c", segunda[i]);
            }
        }
        printf("\n");
    } 
    return 0;
}