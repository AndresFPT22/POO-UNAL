package co.unal.edu;

public class Prueba3 {

    public static void main(String[] args) {
        
        Profesor profesor_1 = new ProfesorTitular();
        
        try {
            
            ((ProfesorTitular2) profesor_1).imprimirAnos();
            
        } catch (Exception e) {
            
            System.out.println("Error en la ejecucion.");
            
        }
        
    }
}
