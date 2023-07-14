package Nivelamento;

public class Ex40Recursividade {
    public static void main (String[] args){
        printRecursivo(0);
    }

    void printRecursivo(){
        printRecursivo(2);
    }
    static void printRecursivo(int i){
        System.out.println(i);
        if(i>0){
            printRecursivo(i-1);
        }
        System.out.print(i);
    }
}
