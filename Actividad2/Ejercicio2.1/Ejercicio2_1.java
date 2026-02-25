package com.mycompany.ejercicio2_1;

import java.util.Scanner;

public class Ejercicio2_1 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //Primera persona:
        
        System.out.println("Ingrese el nombre de la primera persona:");
        String name1 = input.nextLine();
        
        System.out.println("Ingrese el apellido de la primera persona:");
        String lastName1 = input.nextLine();
        
        System.out.println("Ingrese el número de documento de la primera persona:");
        String document1 = input.nextLine();
        
        System.out.println("Ingrese el año de nacimiento de la primera persona:");
        int year1 = input.nextInt();
        
        System.out.println("\n");
        input.nextLine();
        
        //Segunda persona:
        
        System.out.println("Ingrese el nombre de la segunda persona:");
        String name2 = input.nextLine();
        
        System.out.println("Ingrese el apellido de la segunda persona:");
        String lastName2 = input.nextLine();
        
        System.out.println("Ingrese el número de documento de la segunda persona:");
        String document2 = input.next();
        
        System.out.println("Ingrese el año de nacimiento de la segunda persona:");
        int year2 = input.nextInt();
        
        System.out.println("\n");
        
        var person1 = new Person(name1, lastName1, document1, year1);
        var person2= new Person(name2, lastName2, document2, year2);
        
        person1.print();
        person2.print();
    }
}
