package co.unal.edu.Ejercicio6_7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controladorEjercicio6_7 {

    @FXML
    private TextField txtNombreEquipo;

    @FXML
    private TextField txtUniversidad;

    @FXML
    private TextField txtLenguaje;

    @FXML
    private TextField txtTamano;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private Label lblContador;

    private EquipoMaratonProgramacion equipoActual;
    private int tamanoMaximo = 3;

    @FXML
    void agregarProgramador(ActionEvent event) {
        try {
            if (equipoActual == null) {
                tamanoMaximo = Integer.parseInt(txtTamano.getText());
                
                equipoActual = new EquipoMaratonProgramacion(
                    txtNombreEquipo.getText(),
                    txtUniversidad.getText(),
                    txtLenguaje.getText(),
                    tamanoMaximo
                );

                if (!equipoActual.validarEquipo(tamanoMaximo)) {
                    equipoActual = null;
                    throw new Exception("El tamaño del equipo debe ser 2 o 3.");
                }

                txtNombreEquipo.setDisable(true);
                txtUniversidad.setDisable(true);
                txtLenguaje.setDisable(true);
                txtTamano.setDisable(true);
            }

            equipoActual.validarCampo(txtNombres.getText());
            equipoActual.validarCampo(txtApellidos.getText());
            equipoActual.añadirParticipante(txtNombres.getText(), txtApellidos.getText());
            
            lblContador.setText("Programadores añadidos: " + equipoActual.listaProgramadores.size() + "/" + tamanoMaximo);
            
            mostrarAlerta(AlertType.INFORMATION, "Éxito", "Programador agregado.");
            txtNombres.clear();
            txtApellidos.clear();

        } catch (NumberFormatException e) {
            mostrarAlerta(AlertType.ERROR, "Error", "El tamaño del equipo debe ser numérico.");
        } catch (Exception e) {
            mostrarAlerta(AlertType.ERROR, "Error", e.getMessage());
        }
    }

    @FXML
    void imprimir(ActionEvent event) {
        if (equipoActual != null) {
            String datos = "Equipo: " + txtNombreEquipo.getText() + "\n" +
                           "Universidad: " + txtUniversidad.getText() + "\n" +
                           "Lenguaje: " + txtLenguaje.getText() + "\n" +
                           "Programadores:\n";
            for (String p : equipoActual.listaProgramadores) {
                datos += "- " + p + "\n";
            }
            mostrarAlerta(AlertType.INFORMATION, "Datos del Equipo", datos);
        }
    }

    @FXML
    void limpiarDatos(ActionEvent event) {
        txtNombreEquipo.clear();
        txtUniversidad.clear();
        txtLenguaje.clear();
        txtTamano.clear();
        txtNombres.clear();
        txtApellidos.clear();
        
        txtNombreEquipo.setDisable(false);
        txtUniversidad.setDisable(false);
        txtLenguaje.setDisable(false);
        txtTamano.setDisable(false);

        lblContador.setText("Programadores añadidos: 0/3");

        equipoActual = null;
    }

    private void mostrarAlerta(AlertType tipo, String titulo, String contenido) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
