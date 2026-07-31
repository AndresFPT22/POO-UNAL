package co.unal.edu;

public class ProfesorTitular2 extends Profesor {

    int anos = 0;

    protected void imprimir () {
        
        System.out.println("Es un profesor titular.");
        
    }
    
    protected void imprimirAnos () {
        
        System.out.println("Años = " + anos);
        
    }
    
}
