package com.mycompany.ejercicio2_2;

import java.util.Scanner;

public class Ejercicio2_2 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //Primer planeta:
        
        System.out.println("Ingrese el nombre del primer planeta:");
        String name1 = input.nextLine();
        
        System.out.println("Ingrese la cantidad de satelites de " +name1+":");
        int satellite1 = input.nextInt();
        
        System.out.println("Ingrese la masa en kilogramos de "+name1+":");
        double kilogram1 = input.nextDouble();
        
        System.out.println("Ingrese el volumen en kilómetros cúbicos de "+name1+":");
        double cubicKilometer1 = input.nextDouble();
        
        System.out.println("Ingrese el diametro en kilómetros de "+name1+":");
        int diameter1 = input.nextInt();
        
        System.out.println("Ingrese la distancia media al Sol en millones de kilómetros de "+name1+":");
        int distance1 = input.nextInt()*1000000;
        
        System.out.println("Ingrese el tipo de planeta de "+name1+" (gaseoso, terrestre o enano):");
        String type1 = input.next().toUpperCase();
        Planeta.TipoPlaneta tipo1 = Planeta.TipoPlaneta.valueOf(type1);
        
        System.out.println("Ingrese 'true' si "+name1+" es observable a simple vista, 'false' de lo contrario:");
        boolean observable1 = input.nextBoolean();
        
        input.nextLine();
        System.out.println("\n");
        
        //Segundo planeta:
        
        System.out.println("Ingrese el nombre del segundo planeta:");
        String name2 = input.nextLine();
        
        System.out.println("Ingrese la cantidad de satelites de " +name2+":");
        int satellite2 = input.nextInt();
        
        System.out.println("Ingrese la masa en kilogramos de "+name2+":");
        double kilogram2 = input.nextDouble();
        
        System.out.println("Ingrese el volumen en kilómetros cúbicos de "+name2+":");
        double cubicKilometer2 = input.nextDouble();
        
        System.out.println("Ingrese el diametro en kilómetros de "+name2+":");
        int diameter2 = input.nextInt();
        
        System.out.println("Ingrese la distancia media al Sol en millones de kilómetros de "+name2+":");
        int distance2 = input.nextInt()*1000000;
        
        System.out.println("Ingrese el tipo de planeta de "+name2+" (gaseoso, terrestre o enano):");
        String type2 = input.next().toUpperCase();
        Planeta.TipoPlaneta tipo2 = Planeta.TipoPlaneta.valueOf(type2);
        
        System.out.println("Ingrese 'true' si "+name2+" es observable a simple vista, 'false' de lo contrario:");
        boolean observable2 = input.nextBoolean();
        
        System.out.println("\n");
        
        var planet1 = new Planeta(name1, satellite1, kilogram1, cubicKilometer1, diameter1, distance1, tipo1, observable1);
        var planet2 = new Planeta(name2, satellite2, kilogram2, cubicKilometer2, diameter2, distance2, tipo2, observable2);
        
        planet1.print();
        planet1.density();
        planet1.exterior();
        
        System.out.println("\n");
        
        planet2.print();
        planet2.density();
        planet2.exterior();
    }
}
