package co.unal.edu.Ejercicio6_6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class controladorEjercicio6_6 {

    @FXML
    private TextField numeroIngresado;

    @FXML
    private TextField resultado;

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
    private void calcularRaiz(ActionEvent evento){

        try {

            if(numeroIngresado.getText().trim().isEmpty()){

                avisarError("Dato incompleto", "Ingrese un número por favor.");
                return;

            }

            double numero = Double.parseDouble(numeroIngresado.getText().trim());
            resultado.setText(String.valueOf(CalculosNumericos.raizCuadrada(numero)));
            
        } catch (ArithmeticException error) {

            avisarError("Ingrese un número valido", error.getMessage());

        } catch(NumberFormatException error){

            avisarError("Ingrese solo números", "Ingrese solo números positivos, no letras ni caracteres especiales.");

        }catch(Exception error){

            avisarError("Error", "Ocurrió una excepción.");
            
        }

    }

    @FXML
    private void calcularLog(ActionEvent evento){

        try {

            if(numeroIngresado.getText().trim().isEmpty()){

                avisarError("Dato incompleto", "Ingrese un número por favor.");
                return;

            }

            double numero = Double.parseDouble(numeroIngresado.getText().trim());
            resultado.setText(String.valueOf(CalculosNumericos.logaritmoNeperiano(numero)));
            
        } catch(ArithmeticException error) {

            avisarError("Ingrese un número valido", error.getMessage());

        } catch(NumberFormatException error){

            avisarError("Ingrese solo números", "Ingrese solo números positivos, no letras ni caracteres especiales.");

        }catch(Exception error){

            avisarError("Error", "Ocurrió una excepción.");

        }
    }

    @FXML
    private void limpiar(ActionEvent evento){

        numeroIngresado.setText("");
        resultado.setText("");
        
    }

}
