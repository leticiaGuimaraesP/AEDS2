package RevisãoP1;

import java.util.*;

class BibliotecaSeverino {
   public static void ordenar(int[] array){
      int aux;
      for(int i=0; i<array.length-1; i++){
         int menor = i;
         for(int j=i+1; j<array.length; j++){
            if(array[menor]>array[j]){
               menor=j;
            }
         }
         aux = array[i];
         array[i] = array[menor];
         array[menor] = aux;
      }
      String[] str = new String[array.length];
      for(int i=0; i<array.length; i++){
         str[i] = ""+array[i];
         if(str[i].length()==1){
            System.out.println("000"+str[i]);
         }else if(str[i].length()==2){
            System.out.println("00"+str[i]);
         }else if(str[i].length()==3){
            System.out.println("0"+str[i]);
         }else{
            System.out.println(str[i]);
         }
      }
   }
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      while(sc.hasNext()){
         int x = sc.nextInt();	
         int[] livros = new int[x];

         for (int i=0; i<x; i++){
            livros[i] = sc.nextInt();
         }
         ordenar(livros);
      }
      sc.close(); 
   }
}