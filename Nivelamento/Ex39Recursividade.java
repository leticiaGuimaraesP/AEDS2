package Nivelamento;

public class Ex39Recursividade {
    public static void main (String[] args){
        mostrar(0);
    }

    void mostrar(){
        mostrar(0);
    }
    static void mostrar(int i){
        if(i<4){
            System.out.println(i);
            mostrar(i+1);
        }
    }
}
