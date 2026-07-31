package co.unal.edu;

import java.util.Scanner;

public class Pedido {

    public double calcular_pedido (String nombre_primer_plato, double valor_primer_plato, String nombre_bebida, double valor_bebida) {

        double total = 0;

        try {

            total = valor_primer_plato + valor_bebida;
            System.out.println("Orden: " + nombre_primer_plato + " + " + nombre_bebida);

        } catch (Exception e) {

            System.out.println("Error al calcular.");

        }

        return total;
    }

    public double calcular_pedido (String nombre_primer_plato, double valor_primer_plato, String nombre_segundo_plato, double valor_segundo_plato, String nombre_bebida, double valor_bebida) {
        
        System.out.println("Orden: " + nombre_primer_plato + " + " + nombre_segundo_plato + " + " + nombre_bebida);
        return valor_primer_plato + valor_segundo_plato + valor_bebida;

    }

    public double calcular_pedido (String nombre_primer_plato, double valor_primer_plato, String nombre_segundo_plato, double valor_segundo_plato, String nombre_bebida, double valor_bebida, String nombre_postre, double valor_postre) {
        
        System.out.println("Orden: " + nombre_primer_plato + " + " + nombre_segundo_plato + " + " + nombre_bebida + " + " + nombre_postre);
        return valor_primer_plato + valor_segundo_plato + valor_bebida + valor_postre;
    }

    public static void main(String[] args) {

        Pedido mi_pedido = new Pedido();
        Scanner entrada = new Scanner(System.in);

        try {

            System.out.print("Ingrese nombre del primer plato: ");
            String plato_1 = entrada.nextLine();
            System.out.print("Ingrese valor del primer plato: ");
            double valor_1 = Double.parseDouble(entrada.nextLine());

            System.out.print("Ingrese nombre de la bebida: ");
            String bebida = entrada.nextLine();
            System.out.print("Ingrese valor de la bebida: ");
            double valor_bebida = Double.parseDouble(entrada.nextLine());

            System.out.println("\n--- PEDIDO 1 ---");
            double total_1 = mi_pedido.calcular_pedido(plato_1, valor_1, bebida, valor_bebida);
            System.out.println("Total a pagar: $" + total_1 + "\n");

            System.out.print("Ingrese nombre del segundo plato: ");
            String plato_2 = entrada.nextLine();
            System.out.print("Ingrese valor del segundo plato: ");
            double valor_2 = Double.parseDouble(entrada.nextLine());

            System.out.println("\n--- PEDIDO 2 ---");
            double total_2 = mi_pedido.calcular_pedido(plato_1, valor_1, plato_2, valor_2, bebida, valor_bebida);
            System.out.println("Total a pagar: $" + total_2 + "\n");

            System.out.print("Ingrese nombre del postre: ");
            String postre = entrada.nextLine();
            System.out.print("Ingrese valor del postre: ");
            double valor_postre = Double.parseDouble(entrada.nextLine());

            System.out.println("\n--- PEDIDO 3 ---");
            double total_3 = mi_pedido.calcular_pedido(plato_1, valor_1, plato_2, valor_2, bebida, valor_bebida, postre, valor_postre);
            System.out.println("Total a pagar: $" + total_3 + "\n");
            

        } catch (Exception e) {

            System.out.println("Error al ingresar los datos.");
            
        }
        
        entrada.close();
    }
}
