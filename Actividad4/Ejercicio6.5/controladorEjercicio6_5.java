package co.unal.edu.Ejercicio6_5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class controladorEjercicio6_5 {

    @FXML 
    private TextField nombresIngresado;

    @FXML
    private TextField apellidosIngresado;

    @FXML
    private TextField edadIngresada;

    private void avisarError(String titulo, String mensaje){

        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.setHeaderText(null);
        
        Stage stageAlerta = (Stage) alerta.getDialogPane().getScene().getWindow();
        stageAlerta.getIcons().add(new Image(getClass().getResourceAsStream("/co/unal/edu/icono error.png")));

        alerta.showAndWait();

    }

    private void avisarValidacion(String titulo, String mensaje){

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.setHeaderText(null);

        Stage stageAlerta = (Stage) alerta.getDialogPane().getScene().getWindow();
        stageAlerta.getIcons().add(new Image((getClass().getResourceAsStream("/co/unal/edu/icono validacion.png"))));

        alerta.showAndWait();

    } 

    @FXML
    private void validarEdad(ActionEvent evento){

        try {

            if(nombresIngresado.getText().trim().isEmpty() || apellidosIngresado.getText().trim().isEmpty() || edadIngresada.getText().trim().isEmpty()){

                String titulo = "Campos incompletos";
                String mensaje = "Introduzca todos los datos solicitados.";
                avisarError(titulo, mensaje);
                return;

            }

            String nombre = nombresIngresado.getText().trim();
            String apellidos = apellidosIngresado.getText().trim();
            long edad = Long.parseLong(edadIngresada.getText().trim());

            Vendedor.validarEdad(edad);
            Vendedor vendedor = new Vendedor(nombre, apellidos, edad);
            avisarValidacion("Datos registrados exitosamente", vendedor.imprimir());

        } catch(NumberFormatException error){

            String titulo = "Datos incorrectos";
            String mensaje = "Introduzca los datos en un formato correcto.";
            avisarError(titulo, mensaje);

        } catch (IllegalArgumentException error) {

            String titulo = "Edad invalida";
            String mensaje = error.getMessage();
            avisarError(titulo, mensaje);

        } 
    }

    @FXML
    private void limpiar(ActionEvent evento){

        nombresIngresado.setText("");
        apellidosIngresado.setText("");
        edadIngresada.setText("");
    }

}
