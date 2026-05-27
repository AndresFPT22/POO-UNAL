import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaEsfera extends JFrame implements ActionListener{

    private JLabel textoRadio, resultadoSuperficie, resultadoVolumen;
    private JTextField radioIngresado;
    private JButton btCalcular, btLimpiar;

    public VentanaEsfera(){

        setTitle("Esfera");
        setSize(440, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        Font fuente = new Font("Segoe UI", Font.BOLD, 16);

        textoRadio = new JLabel();
        textoRadio.setText("Ingrese el radio(cm): ");
        textoRadio.setForeground(Color.BLACK);
        textoRadio.setFont(fuente);
        textoRadio.setHorizontalAlignment(JLabel.CENTER);

        radioIngresado = new JTextField();
        radioIngresado.setText("");
        radioIngresado.setForeground(Color.BLACK);
        radioIngresado.setFont(fuente);

        btCalcular = new JButton();
        btCalcular.setText("Calcular");
        btCalcular.setForeground(Color.BLACK);
        btCalcular.setBackground(new Color(255, 253, 214));
        btCalcular.setFont(fuente);
        btCalcular.addActionListener(this);
        
        btLimpiar = new JButton();
        btLimpiar.setText("Limpiar");
        btLimpiar.setForeground(Color.BLACK);
        btLimpiar.setBackground(new Color(255, 253, 214));
        btLimpiar.setFont(fuente);
        btLimpiar.addActionListener(this);

        resultadoSuperficie = new JLabel();
        resultadoSuperficie.setText("Superficie(cm2): ");
        resultadoSuperficie.setForeground(Color.BLACK);
        resultadoSuperficie.setFont(fuente);

        resultadoVolumen = new JLabel();
        resultadoVolumen.setText("Volumen(cm3): ");
        resultadoVolumen.setForeground(Color.BLACK);
        resultadoVolumen.setFont(fuente);

        ImageIcon imagenEsfera = new ImageIcon("src/imagenEsfera.png");
        Image imagenEsferaReal = imagenEsfera.getImage().getScaledInstance(205,205, Image.SCALE_SMOOTH);
        ImageIcon imagenEsferaUtilizable = new ImageIcon(imagenEsferaReal);

        JLabel labelEsfera = new JLabel(imagenEsferaUtilizable);
        labelEsfera.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelDatos = new JPanel(new GridLayout(1,2,5,5));
        panelDatos.add(textoRadio);
        panelDatos.add(radioIngresado);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btCalcular);
        panelBotones.add(btLimpiar);

        JPanel panelResultados = new JPanel(new GridLayout(1,2,5,5));
        panelResultados.add(resultadoVolumen);
        panelResultados.add(resultadoSuperficie);

        JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelImagen.add(labelEsfera);

        panelPrincipal.add(panelDatos);
        panelPrincipal.add(panelBotones);
        panelPrincipal.add(panelResultados);
        panelPrincipal.add(panelImagen);

        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        add(panelPrincipal);
    }

    public void actionPerformed(ActionEvent evento){

        if(evento.getSource()==btCalcular){

            if(radioIngresado.getText().trim().isEmpty()){

                JOptionPane.showMessageDialog(this, "Ingrese los datos requeridos.", "Faltan datos", JOptionPane.ERROR_MESSAGE);
            }

            else{

                try {
                    
                    double radio = Double.parseDouble(radioIngresado.getText().trim());

                    double volumenEsfera = Logica.Esfera.volumenEsfera(radio);
                    double superficieEsfera = Logica.Esfera.superficieEsfera(radio);

                    resultadoVolumen.setText("Volumen(cm3): "+ String.format("%.2f", volumenEsfera));
                    resultadoSuperficie.setText("Superficie(cm2): "+ String.format("%.2f", superficieEsfera));

                } catch (NumberFormatException error) {

                    JOptionPane.showMessageDialog(this, "Llene todas las casillas solo con números.", "Datos erroneos", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

        else if(evento.getSource()==btLimpiar){

            radioIngresado.setText("");

            resultadoVolumen.setText("Volumen(cm3): ");
            resultadoSuperficie.setText("Superficie(cm2): ");
        }
    }
}
