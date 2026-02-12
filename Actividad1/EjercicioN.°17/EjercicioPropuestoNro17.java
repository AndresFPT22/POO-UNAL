package com.mycompany.ejerciciopropuestonro17;

import java.util.Scanner;

public class EjercicioPropuestoNro17 {

    public static void main(String[] args) {

        double radio;
        double area;
        double longitud;
        
        System.out.println("Ingrese el radio:");
        
        Scanner input = new Scanner(System.in);
        
        radio = input.nextDouble();
        
        area = CalcularAreaLongitud.area(radio);
        longitud = CalcularAreaLongitud.longitud(radio);
        
        System.out.println("El area de un circulo de radio: "+radio+" es "+ area+" y su longitud es "+longitud);
    }
}
