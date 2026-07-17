package co.unal.edu.Ejercicio6_8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerArchivo {

    public static String leerContenido(String rutaArchivo) throws IOException {

        StringBuilder contenidoCompleto = new StringBuilder();

        try (

            FileInputStream fis = new FileInputStream(rutaArchivo);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr)
        ) 
        
        {
            String linea;
            
            while ((linea = br.readLine()) != null) {

                contenidoCompleto.append(linea).append("\n");

            }
        } 
        
        return contenidoCompleto.toString();
    }
}
