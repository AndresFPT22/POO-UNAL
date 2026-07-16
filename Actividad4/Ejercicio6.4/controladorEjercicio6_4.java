package co.unal.edu.Ejercicio6_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class controladorEjercicio6_4 {

    @FXML
    private TextField dividendoIngresado;

    @FXML
    private TextField divisorIngresado;

    @FXML
    private Label textoResultadoNumero;

    private void avisarError(String titulo, String mensaje){

        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.setHeaderText(null);
        
        Stage stageAlerta = (Stage) alerta.getDialogPane().getScene().getWindow();
        stageAlerta.getIcons().add(new Image(getClass().getResourceAsStream("/co/unal/edu/icono error.png")));

        alerta.showAndWait();

    }

    @FXML
    private void calcularDivision(ActionEvent evento){

        try{

            if(dividendoIngresado.getText().strip().isEmpty() || divisorIngresado.getText().strip().isEmpty()){

                String titulo = "Datos incompletos";
                String mensaje = "No deje casillas vacias";
                avisarError(titulo, mensaje);
                return;
            }

            double dividendo = Double.parseDouble(dividendoIngresado.getText().strip());
            double divisor = Double.parseDouble(divisorIngresado.getText().strip());


            if(divisor!=0){

                double resultado = Calculadora.dividir(dividendo, divisor);

                textoResultadoNumero.setText(String.valueOf(resultado));

            }

            else{

                String titulo = "División por cero";
                String mensaje = "Error matematico, ¡no se puede dividir por cero!";
                avisarError(titulo, mensaje);

            }

        } catch(NumberFormatException error){

            String titulo = "Formato incorrecto";
            String mensaje = "Ingrese solo números no letras ni caracteres especiales.";
            avisarError(titulo, mensaje);

        }   

    }

    @FXML
    private void limpiar(ActionEvent evento){

        dividendoIngresado.setText("");
        divisorIngresado.setText("");
        textoResultadoNumero.setText("");

    }

}
