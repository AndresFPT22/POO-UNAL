package com.mycompany.ejercicio2_4;

public class Figuras{
    
    public static class Circulo{
        
        double radio;
        
        public Circulo(double radio){
            
            this.radio = radio;
            
        }
        
        public double CalcularArea(){
            
            return Math.PI*(Math.pow(radio, 2));
            
        }
        public double CalcularPerimetro(){
            
            return Math.PI*2*radio;
            
        }
    }
    
    public static class Rectangulo{
        
        double baseR;
        double heightR;
        
        public Rectangulo(double baseR, double heightR){
            
            this.baseR = baseR;
            this.heightR = heightR;
            
        }
        
        public double CalcularArea(){
            
            return baseR*heightR;
            
        }
        
        public double CalcularPerimetro(){
            
            return baseR*2+heightR*2;
            
        }
    }
    
    public static class Cuadrado{
        
        double side;
        
        public Cuadrado(double side){
            
            this.side = side;
            
        }
        
        public double CalcularArea(){
            
            return Math.pow(side, 2);
            
        }
        
        public double CalcularPerimetro(){
            
            return side*4;
            
        }
    }
    
    public static class TrianguloRectangulo{
        
        double baseT;
        double heightT;
        
        public TrianguloRectangulo(double baseT, double heightT){
            
            this.baseT = baseT;
            this.heightT = heightT;
            
        }
        
        public double CalcularHipotenusa(){
            
            return Math.sqrt((Math.pow(baseT, 2)+Math.pow(heightT, 2)));
        }
        
        public double CalcularArea(){
            
            return (baseT*heightT)/2;
            
        }
        
        public double CalcularPerimetro(){
            
            return baseT + heightT + CalcularHipotenusa();
            
        }
        
        //Así esta en el ejercicio pero un trángulo rectángulo nunca podra ser equilatero
        
        public void DeterminarTipoTriangulo(){
            
            if(baseT==heightT && baseT==CalcularHipotenusa()){
                System.out.println("Es un triángulo equilatero");
            }
            
            else if(baseT!=heightT && baseT!=CalcularHipotenusa()){
                System.out.println("Es un triángulo escaleno");
            }
            
            else{
                System.out.println("Es un triángulo isoceles");
            }
            
        }
    }
}
