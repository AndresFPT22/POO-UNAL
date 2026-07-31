package co.unal.edu;

public class Prueba{

    public static void main(String[] args) {
        
        Profesor profesor_1 = new ProfesorTitular();
        
        try {
            
            profesor_1.imprimir();
            
        } catch (Exception e) {
            
            System.out.println("Error en la ejecucion.");
            
        }
        
    }
}
