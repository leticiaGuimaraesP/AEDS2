#include <stdio.h>
#include <stdlib.h>

int main(){
    FILE *arq1=fopen("saida.txt", "w"); //abre o arquivo
    int n, i, posi;
    double resp1;
    int resp2;
    double d;

    scanf("%d", &n);  //leitura da quantidade de numeros que serao lidos
    for(i=0; i<n; i++){
        scanf("%lf", &d);
        fprintf(arq1, "%lf\n", d);
        posi = (i+1)*sizeof(double);
        fseek(arq1,posi,SEEK_SET);
    }
    fclose(arq1);

    FILE *arq2=fopen("saida.txt", "r"); //abre o arquivo novamente, mas so para leitura
    
    posi = (n-1)*sizeof(double);
    for(i=0; i<n; i++){  
        fseek (arq2,posi,SEEK_SET);
        fscanf(arq2, "%lf", &d);
        resp1 = d;
        resp2 = resp1;  //testa se o numero convertido a inteiro continua sendo o mesmo
        if(resp1==resp2){
            printf("%d\n", resp2);
        }else{
            printf("%g\n", resp1);
        }
        posi = posi-sizeof(double);
    }
    fclose(arq2);  //fecha o arquivo
    return 0;
}