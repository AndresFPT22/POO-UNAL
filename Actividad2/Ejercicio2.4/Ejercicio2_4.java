package com.mycompany.ejercicio2_4;

import java.util.Scanner;

public class Ejercicio2_4 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingrese el radio del círculo en centímetros:");
        double radio = input.nextDouble();
        
        System.out.println("Ingrese la base del rectángulo en centímetros:");
        double baseR = input.nextDouble();
        
        System.out.println("Ingrese la altura del rectángulo en centímetros:");
        double heightR = input.nextDouble();
        
        System.out.println("Ingrese la longitud de los lados del cuadrado en centimetros:");
        double side = input.nextDouble();
        
        System.out.println("Ingrese la base del triángulo rectángulo en centímetros:");
        double baseT = input.nextDouble();
        
        System.out.println("Ingrese la altura del triángulo  rectángulo en centímetros:");
        double heightT = input.nextDouble();
        
        System.out.println("\n");
        
        var circulo = new Figuras.Circulo(radio);
        var rectangulo = new Figuras.Rectangulo(baseR, heightR);    
        var cuadrado = new Figuras.Cuadrado(side);
        var trianguloR = new Figuras.TrianguloRectangulo(baseT, heightT);
        
        System.out.println("El área del círculo es: "+circulo.CalcularArea()+" cm^2 y su perímetro es: "+circulo.CalcularPerimetro()+" cm");
        System.out.println("El área del rectángulo es: "+rectangulo.CalcularArea()+" cm^2 y su perímetro es: "+rectangulo.CalcularPerimetro()+" cm");
        System.out.println("El área del cuadrado es: "+cuadrado.CalcularArea()+" cm^2 y su perímetro es: "+cuadrado.CalcularPerimetro()+" cm");
        System.out.println("El área del triángulo rectángulo es: "+trianguloR.CalcularArea()+" cm^2, su perímetro es: "+trianguloR.CalcularPerimetro()+" cm y su hipotenusa vale: "+trianguloR.CalcularHipotenusa()+" cm");
        trianguloR.DeterminarTipoTriangulo();
        
    }
}
