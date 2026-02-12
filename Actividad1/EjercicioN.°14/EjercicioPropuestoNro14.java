package com.mycompany.ejerciciopropuestonro14;

import java.util.Scanner;

public class EjercicioPropuestoNro14 {

    public static void main(String[] args) {
        
        double number;
        double cuadrado;
        double cubo;
        
        System.out.println("Ingrese un número: ");
        
        Scanner input = new Scanner(System.in);
        
        number = input.nextDouble();
        
        cuadrado = CalcularCuadradoCubo.cuadrado(number);
        cubo = CalcularCuadradoCubo.cubo(number);
        
        System.out.println("El cuadrado del número es: "+cuadrado+" y su cubo es: "+cubo);
    }
}
