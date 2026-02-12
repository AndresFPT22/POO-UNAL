package com.mycompany.ejercicioresueltonro5;

public class EjercicioResueltoNro5 {

    public static void main(String[] args) {
    double SUMA=0;
    double X=20;
    
    SUMA+=X;
    
    double Y=40;
    
    X+=Math.pow(Y, 2);
    SUMA+=X/Y;
    
    System.out.println("El valor de la suma es: "+SUMA);
    }
}
