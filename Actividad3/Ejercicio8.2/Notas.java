import java.util.HashMap;
import java.util.Map;

public class Notas {

    Map<String, Float> notas = new HashMap<>();
    
    public void agregarNotas(String nota, float valor){

        notas.put(nota, valor);

    }

    public void limpiarNotas(){

        notas.clear();

    }
    
    public float promedio(){
        
        if(notas.isEmpty()) return 0;
        
        float suma = 0;
        
        for(float nota: notas.values()){
            
            suma= suma+nota;
        }
        return suma/notas.size();
    }
    
    public float desviacionEstandar(){
        
        float promedio = promedio();
        float sumatoria=0;
        
        for(float nota: notas.values()){
            
            sumatoria+=Math.pow((nota-promedio),2);
            
        }
        
        return (float) Math.sqrt(sumatoria/notas.size());
    }
    
    public float notaMenor(){
        
        float menor = Float.POSITIVE_INFINITY;
        
        for(float nota: notas.values()){
            
            if (nota<=menor){
                
                menor=nota;
                
            }
        }
        
        return menor;
    }
    
    public float notaMayor(){
        
        float mayor = Float.NEGATIVE_INFINITY;
        
        for(float nota: notas.values()){
            
            if(nota>=mayor){
                
                mayor = nota;
            }
        }
        
        return mayor;
    }
}
