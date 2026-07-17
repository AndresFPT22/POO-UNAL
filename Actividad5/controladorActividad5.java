package unal.edu.co;

import java.io.File;
import java.io.RandomAccessFile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class controladorActividad5 {

    @FXML
    private TextField entry_name;

    @FXML
    private TextField entry_number;

    @FXML
    private ListView<String> lista_contactos;

    private final String FILENAME = "friendsContact.txt";

    private void avisarError(String titulo, String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.setHeaderText(null);
        alerta.showAndWait();

    }

    private void avisarExito(String titulo, String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.setHeaderText(null);
        alerta.showAndWait();

    }

    @FXML
    public void initialize() {
        cargarLista();
    }

    private void cargarLista() {

        lista_contactos.getItems().clear();

        try {

            File file = new File(FILENAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            String linea;
            
            while ((linea = raf.readLine()) != null) {

                String[] partes = linea.split("!");

                if (partes.length == 2) {
                    lista_contactos.getItems().add(partes[0]);
                }

            }

            raf.close();

        } catch (Exception e) {
            avisarError("Error", "No se pudo leer el archivo de contactos.");
        }
    }

    @FXML
    private void boton_seleccionar(ActionEvent evento) {

        String seleccionado = lista_contactos.getSelectionModel().getSelectedItem();
        
        if (seleccionado == null) {
            avisarError("Advertencia", "Por favor, seleccione un contacto de la lista.");
            return;
        }

        try {

            File file = new File(FILENAME);
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            String linea;
            
            while ((linea = raf.readLine()) != null) {

                String[] partes = linea.split("!");
                if (partes[0].equals(seleccionado)) {

                    entry_name.setText(partes[0]);
                    entry_number.setText(partes[1]);
                    break;

                }
            }

            raf.close();

        } catch (Exception e) {
            avisarError("Error", "Error al buscar el contacto.");
        }
    }

    @FXML
    private void boton_crear(ActionEvent evento) {

        String nombre = entry_name.getText().trim();
        String numero = entry_number.getText().trim();

        if (nombre.isEmpty() || numero.isEmpty()) {
            avisarError("Campos vacíos", "Por favor, llene ambos campos (Name y Number)");
            return;
        }
        if (nombre.contains("!") || numero.contains("!")) {
            avisarError("Error", "El carácter '!' no está permitido en los campos");
            return;
        }

        try {

            File file = new File(FILENAME);
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean existe = false;
            String linea;

            while ((linea = raf.readLine()) != null) {

                String[] partes = linea.split("!");

                if (partes[0].equals(nombre)) {
                    existe = true;
                    break;

                }
            }

            if (existe) {

                avisarError("Contacto duplicado", "El contacto '" + nombre + "' ya existe. Use 'Update' si desea modificarlo.");
                raf.close();
                return;

            }

            raf.seek(raf.length());
            raf.writeBytes(nombre + "!" + numero + System.lineSeparator());
            raf.close();

            avisarExito("Éxito", "Contacto '" + nombre + "' creado correctamente");
            limpiar_campos(null);
            cargarLista();

        } catch (Exception e) {
            avisarError("Error", "Ocurrió un error al guardar el contacto.");
        }
    }

    @FXML
    private void boton_update(ActionEvent evento) {

        String nombre = entry_name.getText().trim();
        String numero = entry_number.getText().trim();

        if (nombre.isEmpty() || numero.isEmpty()) {
            avisarError("Campos vacíos", "Asegúrese de que los campos Name y Number tengan datos.");
            return;

        }

        try {

            File file = new File(FILENAME);
            File tmpFile = new File("temp.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

            boolean encontrado = false;
            String linea;

            while ((linea = raf.readLine()) != null) {

                String[] partes = linea.split("!");
                if (partes[0].equals(nombre)) {

                    encontrado = true;
                    tmpraf.writeBytes(nombre + "!" + numero + System.lineSeparator());

                } else {
                    tmpraf.writeBytes(linea + System.lineSeparator());
                }
            }
            raf.close();
            tmpraf.close();

            if (encontrado) {

                file.delete();
                tmpFile.renameTo(file);
                avisarExito("Éxito", "Contacto '" + nombre + "' actualizado");
                cargarLista();
                limpiar_campos(null);

            } else {
                tmpFile.delete();
                avisarError("Error", "El contacto '" + nombre + "' no existe. No se puede actualizar.");
            }

        } catch (Exception e) {
            avisarError("Error", "Error al actualizar el archivo.");
        }
    }

    @FXML
    private void boton_delete(ActionEvent evento) {

        String nombre = entry_name.getText().trim();

        if (nombre.isEmpty()) {
            avisarError("Campo vacío", "Escriba o seleccione el Name del contacto que desea eliminar");
            return;
        }

        try {

            File file = new File(FILENAME);
            File tmpFile = new File("temp.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

            boolean encontrado = false;
            String linea;

            while ((linea = raf.readLine()) != null) {

                String[] partes = linea.split("!");
                if (partes[0].equals(nombre)) {
                    encontrado = true;
                } else {
                    tmpraf.writeBytes(linea + System.lineSeparator());
                }

            }

            raf.close();
            tmpraf.close();

            if (encontrado) {

                file.delete();
                tmpFile.renameTo(file);
                avisarExito("Éxito", "Contacto '" + nombre + "' eliminado");
                cargarLista();
                limpiar_campos(null);

            } else {

                tmpFile.delete();
                avisarError("Error", "El contacto '" + nombre + "' no se encuentra en el archivo");

            }

        } catch (Exception e) {
            avisarError("Error", "Error al eliminar el contacto.");
        }
    }

    @FXML
    private void limpiar_campos(ActionEvent evento) {

        entry_name.setText("");
        entry_number.setText("");
        lista_contactos.getSelectionModel().clearSelection();
        
    }
}
