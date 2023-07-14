package Nivelamento;

class Ex29Recursividade {
    public static void main (String[] args){
        int x=0;
        System.out.println(fat(x));
        System.out.println(fib(x));
    }

    public static int fat(int n){
        int resp;
        if(n==1){
            resp=1;
        }else{
            resp=n*fat(n-1);
        }
        return resp;
    }
    public static int fib(int n){
        int resp;
        if(n==0||n==1){
            resp=1;
        }else{
            resp=fib(n-1)+fib(n-2);
        }
        return resp;
    }
}
