package com.mycompany.ejercicio2_2;

public class Planeta {
    
    String name = null;
    int satellite = 0;
    double kilogram = 0;
    double cubicKilometer = 0;
    int diameter = 0;
    int distance = 0;
    enum TipoPlaneta{GASEOSO, TERRESTRE, ENANO}
    TipoPlaneta tipo;
    boolean observable=false;
    
    public Planeta(
            String name, 
            int satellite, 
            double kilogram, 
            double cubicKilometer, 
            int diameter, 
            int distance, 
            TipoPlaneta tipo, 
            boolean observable){
        
        this.name = name;
        this.satellite = satellite;
        this.kilogram = kilogram;
        this.cubicKilometer = cubicKilometer;
        this.diameter = diameter;
        this.distance = distance;
        this.tipo = tipo;
        this.observable = observable;
    }
    
    public void print(){
        
        System.out.println("Nombre del planeta: "+name);
        System.out.println("Cantidad de satelites: "+satellite);
        System.out.println("Masa del planeta: "+kilogram);
        System.out.println("Volumen del planeta: "+cubicKilometer);
        System.out.println("Diametro del planeta: "+diameter);
        System.out.println("Distancia al sol del planeta: "+distance);
        System.out.println("Tipo de planeta: "+tipo);
        System.out.println("Observable a simple vista: "+observable);
    }
    
    public void density(){
        
        System.out.println("La densidad de "+name+" es: "+kilogram/cubicKilometer);
        
    }
    
    public void exterior(){
        
        double limit = 149597870*3.4;
        
        if(distance>limit){
            System.out.println("El planeta es exterior");
        }
        else{
            System.out.println("No es planeta exterior");
        }
    }
}
