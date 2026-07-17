package co.unal.edu.Ejercicio6_7;

import java.util.ArrayList;
import java.util.List;

public class EquipoMaratonProgramacion {

    private String nombreEquipo;
    private String nombreUniversidad;
    private String lenguajeProgramacion;
    private int tamañoEquipo;
    List<String> listaProgramadores;

    public EquipoMaratonProgramacion(String nombreEquipo, String nombreUniversidad, String lenguajeProgramacion, int tamañoEquipo) {

        this.nombreEquipo = nombreEquipo;
        this.nombreUniversidad = nombreUniversidad;
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.tamañoEquipo = 0;
        this.listaProgramadores = new ArrayList<>();

    }

    boolean validarEquipo(int tamañoEquipo) {

        if(tamañoEquipo >= 2 && tamañoEquipo <= 3) {

            return true;

        } 
        
        else {

            return false;

        }
    }

    void añadirParticipante(String nombre, String apellidos) throws Exception {

        validarCampo(nombre);
        validarCampo(apellidos);

        if(listaProgramadores.size() < 3) {

            listaProgramadores.add(nombre + " " + apellidos);
            tamañoEquipo++;

        } 
        
        else {

            throw new Exception("El equipo está completo. No se pueden agregar más de 3 programadores.");

        }
    }

    void validarCampo(String campo) throws Exception {

        for(byte i = 0; i < campo.length(); i++) {

            char caracter = campo.charAt(i);

            if(Character.isDigit(caracter)) {

                throw new Exception("El nombre o apellido no puede tener dígitos.");

            }
        }
        
        if(campo.length() > 20) {

            throw new Exception("La longitud no debe ser mayor a 20 caracteres.");

        }
    }

    public String obtenerDatosEquipo() {

        StringBuilder datos = new StringBuilder();
        datos.append("Equipo: ").append(nombreEquipo).append("\n");
        datos.append("Universidad: ").append(nombreUniversidad).append("\n");
        datos.append("Lenguaje: ").append(lenguajeProgramacion).append("\n");
        datos.append("Integrantes (").append(tamañoEquipo).append("):\n");

        for (String prog : listaProgramadores) {

            datos.append("- ").append(prog).append("\n");

        }

        return datos.toString();

    }
}
