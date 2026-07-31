package co.unal.edu;

public class PruebaAnimales {

    public static void main(String[] args) {
        
        Animal[] animales = new Animal[4];
        
        animales[0] = new Perro();
        animales[1] = new Lobo();
        animales[2] = new Leon();
        animales[3] = new Gato();
        
        try {
            
            for (int i = 0; i < animales.length; i++) {
                
                System.out.println("Nombre Cientifico: " + animales[i].getNombreCientifico());
                System.out.println("Sonido: " + animales[i].getSonido());
                System.out.println("Alimentos: " + animales[i].getAlimentos());
                System.out.println("Habitat: " + animales[i].getHabitat());
                System.out.println();
                
            }
            
        } catch (Exception e) {
            
            System.out.println("Error al imprimir los datos de los animales.");
            
        }
        
    }
}
