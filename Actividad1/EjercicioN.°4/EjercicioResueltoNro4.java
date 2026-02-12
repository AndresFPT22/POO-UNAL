package com.mycompany.ejercicioresueltonro4;

import java.util.Scanner;

public class EjercicioResueltoNro4 {

    public static void main(String[] args) {
        
        double EdJuan;
        double EdAlber;
        double EdAna;
        double EdMama;
        
        System.out.println("Ingrese la edad de Juan:");
        
        Scanner input = new Scanner(System.in);
        
        EdJuan = input.nextDouble();
        
        EdAlber= CalcularEdades.CalcularEdAlber(EdJuan);
        EdAna= CalcularEdades.CalcularEdAna(EdJuan);
        EdMama = CalcularEdades.CalcularEdMama(EdAna, EdJuan, EdAlber);
        
        System.out.println("Las edades son: Alberto="+EdAlber+" Juan="+EdJuan+" Ana="+EdAna+" Mamá="+EdMama);
    }
}
