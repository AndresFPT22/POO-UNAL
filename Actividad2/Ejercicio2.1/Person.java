package com.mycompany.ejercicio2_1;

public class Person {
    
    String name;
    String lastName;
    String document;
    int year;
    
    public Person(String name, String lastName, String document, int year){
        
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.year = year;
    }
    public void print(){
        System.out.println("Nombre: "+name);
        System.out.println("Apellidos: "+lastName);
        System.out.println("Número de documento: "+document);
        System.out.println("Año de nacimiento: "+year+"\n");
    }
}
