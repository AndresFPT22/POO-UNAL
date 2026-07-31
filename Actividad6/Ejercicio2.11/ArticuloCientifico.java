package co.unal.edu;

import java.util.Scanner;

public class ArticuloCientifico {

    String nombre_articulo;
    String autor;
    String palabras_claves;
    String nombre_publicacion;
    int anio;
    String resumen;

    public ArticuloCientifico (String nombre_articulo, String autor) {
        
        this.nombre_articulo = nombre_articulo;
        this.autor = autor;
        
    }

    public ArticuloCientifico (String nombre_articulo, String autor, String palabras_claves, String nombre_publicacion, int anio) {
        
        this(nombre_articulo, autor);
        this.palabras_claves = palabras_claves;
        this.nombre_publicacion = nombre_publicacion;
        this.anio = anio;
        
    }

    public ArticuloCientifico (String nombre_articulo, String autor, String palabras_claves, String nombre_publicacion, int anio, String resumen) {
        
        this(nombre_articulo, autor, palabras_claves, nombre_publicacion, anio);
        this.resumen = resumen;
        
    }

    public void imprimir_atributos () {
        
        try {
            
            System.out.println("Nombre: " + nombre_articulo);
            System.out.println("Autor: " + autor);
            System.out.println("Palabras Claves: " + palabras_claves);
            System.out.println("Publicacion: " + nombre_publicacion);
            System.out.println("Año: " + anio);
            System.out.println("Resumen: " + resumen);
            
        } catch (Exception e) {
            
            System.out.println("Error al imprimir los datos del articulo.");
            
        }
        
    }

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        try {
            
            System.out.print("Ingrese el nombre del articulo: ");
            String nombre = entrada.nextLine();
            
            System.out.print("Ingrese el autor: ");
            String autor = entrada.nextLine();
            
            System.out.print("Ingrese las palabras claves: ");
            String palabras_claves = entrada.nextLine();
            
            System.out.print("Ingrese el nombre de la publicacion: ");
            String publicacion = entrada.nextLine();
            
            System.out.print("Ingrese el año de publicacion: ");
            int anio = Integer.parseInt(entrada.nextLine());
            
            System.out.print("Ingrese el resumen: ");
            String resumen = entrada.nextLine();
            
            ArticuloCientifico mi_articulo = new ArticuloCientifico(nombre, autor, palabras_claves, publicacion, anio, resumen);
            
            System.out.println("\n--- DATOS DEL ARTICULO ---");
            mi_articulo.imprimir_atributos();
            
        } catch (Exception e) {
            
            System.out.println("Error al ingresar los datos.");
            
        }
        
        entrada.close();
    }
}
