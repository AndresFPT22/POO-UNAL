package co.unal.edu.Ejercicio6_5;

public class Vendedor {

    private String nombre;
    private String apellidos;
    private long edad;

    Vendedor(String nombre, String apellidos, long edad){

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;

    } 

    public String getNombres(){return nombre;}
    public String getApellidos(){return apellidos;}
    public long getEdad(){return edad;}

    public static void validarEdad(long edad){

        if(edad>=0 && edad<18){

            throw new IllegalArgumentException("El vendedor debe ser mayor de edad.");

        }

        if(edad<0 || edad>120){

            throw new IllegalArgumentException("La edad no debe ser negativa ni mayor a 120.");

        }
    }

    public String imprimir(){

        return "Vendedor registrado con éxito:\nNombres: " + nombre + "\nApellidos: " + apellidos + "\nEdad: " + edad + " años.";

    }
}
