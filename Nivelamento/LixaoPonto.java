package Nivelamento;

class LixaoPonto {
    public static void main (String[] args){
        Ponto p1 = new Ponto(4,3);
        Ponto p2 = new Ponto(8,5);
        Ponto p3 = new Ponto(9.2,10);
        System.out.println("Distancia p1 entre e p2: " + p1.dist(p1,p2));
        System.out.println("Distancia p1 entre e (5,2): " + p1.dist(p1, 5,2));          
        System.out.println("Distancia (4,3) entre e (5,2): " + Ponto.dist(4,3,5,2));          
        System.out.println("P1, P2, P3 sao triangulo:" + Ponto.isTriangulo(p1,p2,p3)); 
        System.out.println("ID de P1: " + p1.getID());   
        System.out.println("ID de P2: " + p2.getID()); 
        System.out.println("ID de P3: " + p3.getID());
        System.out.println("Next ID: " + Ponto.getNextID());            
    }
}

class Ponto{
    private double x, y;
    private int id;
    private static int nextID=0;

    public int getID() {
        return id;
    }
    public static int getNextID() {
        return nextID;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public Ponto(){
        x=0;
        y=0;
    }
    public Ponto(double x, double y){
        this.x=x;
        this.y=y;
        id=nextID;
        nextID++;
    }
    
    public static double dist(int i, int j, int k, int l) {
        double val1 = Math.pow((i-k),2);
        double val2 = Math.pow((j-l),2);
        double dis = Math.sqrt((val1+val2));
        return dis;
    }
    public double dist(Ponto p1, int i, int j) {
        double val1 = Math.pow((p1.getX()-i),2);
        double val2 = Math.pow((p1.getY()-j),2);
        double dis = Math.sqrt((val1+val2));
        return dis;
    }
    public double dist(Ponto p1, Ponto p2) {
        double val1 = Math.pow((p1.getX()-p2.getX()),2);
        double val2 = Math.pow((p1.getY()-p2.getY()),2);
        double dis = Math.sqrt((val1+val2));
        return dis;
    }
    public static String isTriangulo(Ponto p1, Ponto p2, Ponto p3) {
        return null;
    }
}