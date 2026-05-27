import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPiramide extends JFrame implements ActionListener{

    private JLabel textoAncho, textoAltura, textoApotema, textoLargo, resultadoVolumen, resultadoSuperficie;
    private JTextField anchoIngresado, largoIngresado, alturaIngresada, apotemaIngresado;
    private JButton btCalcular, btLimpiar;

    public VentanaPiramide(){

        setTitle("Piramide");
        setSize(530, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        Font fuente = new Font("Segoe UI", Font.BOLD, 16);

        btCalcular = new JButton();
        btCalcular.setText("Calcular");
        btCalcular.setBackground(new Color(255, 253, 214));
        btCalcular.setForeground(Color.BLACK);
        btCalcular.setFont(fuente);
        btCalcular.addActionListener(this);

        btLimpiar = new JButton();
        btLimpiar.setText("Limpiar");
        btLimpiar.setBackground(new Color(255, 253, 214));
        btLimpiar.setForeground(Color.BLACK);
        btLimpiar.setFont(fuente);
        btLimpiar.addActionListener(this);

        textoAncho = new JLabel();
        textoAncho.setText("Ingrese el ancho de la base(cm):");
        textoAncho.setForeground(Color.BLACK);
        textoAncho.setFont(fuente);
        textoAncho.setHorizontalAlignment(JLabel.CENTER);

        textoLargo = new JLabel();
        textoLargo.setText("Ingrese el largo de la base(cm):");
        textoLargo.setForeground(Color.BLACK);
        textoLargo.setFont(fuente);
        textoLargo.setHorizontalAlignment(JLabel.CENTER);

        textoAltura = new JLabel();
        textoAltura.setText("Ingrese la altura(cm):");
        textoAltura.setForeground(Color.BLACK);
        textoAltura.setFont(fuente);
        textoAltura.setHorizontalAlignment(JLabel.CENTER);

        textoApotema = new JLabel();
        textoApotema.setText("Ingrese el apotema(cm): ");
        textoApotema.setForeground(Color.BLACK);
        textoApotema.setFont(fuente);
        textoApotema.setHorizontalAlignment(JLabel.CENTER);

        anchoIngresado = new JTextField();
        anchoIngresado.setText("");
        anchoIngresado.setForeground(Color.BLACK);
        anchoIngresado.setFont(fuente);

        largoIngresado = new JTextField();
        largoIngresado.setText("");
        largoIngresado.setForeground(Color.BLACK);
        largoIngresado.setFont(fuente);

        alturaIngresada = new JTextField();
        alturaIngresada.setText("");
        alturaIngresada.setForeground(Color.BLACK);
        alturaIngresada.setFont(fuente);

        apotemaIngresado = new JTextField();
        apotemaIngresado.setText("");
        apotemaIngresado.setForeground(Color.BLACK);
        apotemaIngresado.setFont(fuente);

        resultadoSuperficie = new JLabel();
        resultadoSuperficie.setText("Superficie(cm2): ");
        resultadoSuperficie.setForeground(Color.BLACK);
        resultadoSuperficie.setFont(fuente);

        resultadoVolumen = new JLabel();
        resultadoVolumen.setText("Volumen(cm3): ");
        resultadoVolumen.setForeground(Color.BLACK);
        resultadoVolumen.setFont(fuente);

        ImageIcon imagenPiramide = new ImageIcon("src/imagenPiramide.png");
        Image imagenPiramideReal = imagenPiramide.getImage().getScaledInstance(170, 155, Image.SCALE_SMOOTH);
        ImageIcon imagenPiramideUtilizable = new ImageIcon(imagenPiramideReal);

        JLabel labelPiramide = new JLabel(imagenPiramideUtilizable);

        JPanel panelDatos = new JPanel(new GridLayout(4,2,5,5));
        panelDatos.add(textoAncho);
        panelDatos.add(anchoIngresado);
        panelDatos.add(textoLargo);
        panelDatos.add(largoIngresado);
        panelDatos.add(textoAltura);
        panelDatos.add(alturaIngresada);
        panelDatos.add(textoApotema);
        panelDatos.add(apotemaIngresado);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btCalcular);
        panelBotones.add(btLimpiar);

        JPanel panelResultados = new JPanel(new GridLayout(1,2,5,5));
        panelResultados.add(resultadoVolumen);
        panelResultados.add(resultadoSuperficie);

        JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelImagen.add(labelPiramide);

        panelPrincipal.add(panelDatos);
        panelPrincipal.add(panelBotones);
        panelPrincipal.add(panelResultados);
        panelPrincipal.add(panelImagen);

        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        add(panelPrincipal);
    }

    public void actionPerformed(ActionEvent evento){

        if(evento.getSource()==btCalcular){

            if(anchoIngresado.getText().trim().isEmpty() || largoIngresado.getText().trim().isEmpty() || alturaIngresada.getText().trim().isEmpty() || apotemaIngresado.getText().trim().isEmpty()){

                JOptionPane.showMessageDialog(this, "Ingrese los datos requeridos.", "Faltan datos", JOptionPane.ERROR_MESSAGE);

            }

            else{

                try {
                    
                    double ancho = Double.parseDouble(anchoIngresado.getText().trim());
                    double largo = Double.parseDouble(largoIngresado.getText().trim());
                    double altura = Double.parseDouble(alturaIngresada.getText().trim());
                    double apotema = Double.parseDouble(apotemaIngresado.getText().trim());

                    double volumenPiramide = Logica.Piramide.volumenPiramide(ancho, largo, altura);
                    double superficiePiramide = Logica.Piramide.superficiePiramide(ancho, largo, apotema);

                    resultadoVolumen.setText("Volumen(cm3): "+ String.format("%.2f", volumenPiramide));
                    resultadoSuperficie.setText("Superficie(cm2): "+ String.format("%.2f", superficiePiramide));

                } catch (NumberFormatException error) {

                    JOptionPane.showMessageDialog(this, "Llene todas las casillas solo con números.", "Datos erroneos", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

        else if(evento.getSource()==btLimpiar){

            anchoIngresado.setText("");
            largoIngresado.setText("");
            alturaIngresada.setText("");
            apotemaIngresado.setText("");

            resultadoVolumen.setText("Volumen(cm3): ");
            resultadoSuperficie.setText("Superficie(cm2): ");
        }
    }
}
