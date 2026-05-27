import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaCubo extends JFrame implements ActionListener{

    private JLabel textoLongitud, resultadoSuperficie, resultadoVolumen;
    private JTextField longitudIngresada;
    private JButton btCalcular, btLimpiar;

    public VentanaCubo(){

        setTitle("Cubo");
        setSize(545, 365);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        Font fuente = new Font("Segoe UI", Font.BOLD, 16);

        textoLongitud = new JLabel();
        textoLongitud.setText("Ingrese la longitud del lado(cm): ");
        textoLongitud.setForeground(Color.BLACK);
        textoLongitud.setFont(fuente);
        textoLongitud.setHorizontalAlignment(JLabel.CENTER);

        longitudIngresada = new JTextField();
        longitudIngresada.setText("");
        longitudIngresada.setForeground(Color.BLACK);
        longitudIngresada.setFont(fuente);

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

        ImageIcon imagenCubo = new ImageIcon("src/imagenCubo.png");
        Image imagenCuboReal = imagenCubo.getImage().getScaledInstance(285, 270, Image.SCALE_SMOOTH);
        ImageIcon imagenUtilizable = new ImageIcon(imagenCuboReal);

        JLabel cuboLabel = new JLabel(imagenUtilizable);
        cuboLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelDatos = new JPanel(new GridLayout(1,2,5,5));
        panelDatos.add(textoLongitud);
        panelDatos.add(longitudIngresada);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btCalcular);
        panelBotones.add(btLimpiar);

        JPanel panelResultados = new JPanel(new GridLayout(1,2,5,5));
        panelResultados.add(resultadoVolumen);
        panelResultados.add(resultadoSuperficie);
        
        JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelImagen.add(cuboLabel);

        panelPrincipal.add(panelDatos);
        panelPrincipal.add(panelBotones);
        panelPrincipal.add(panelResultados);
        panelPrincipal.add(panelImagen);

        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        add(panelPrincipal);
    }

    public void actionPerformed(ActionEvent evento){

        if(evento.getSource()==btCalcular){

            if(longitudIngresada.getText().trim().isEmpty()){

                JOptionPane.showMessageDialog(this, "Ingrese los datos requeridos.", "Faltan datos", JOptionPane.ERROR_MESSAGE);

            }

            else{

                try {
                    
                    double longitud = Double.parseDouble(longitudIngresada.getText().trim());

                    double volumenCubo = Logica.Cubo.volumenCubo(longitud);
                    double superficieCubo = Logica.Cubo.superficieCubo(longitud);

                    resultadoVolumen.setText("Volumen(cm3): "+ String.format("%.2f", volumenCubo));
                    resultadoSuperficie.setText("Superficie(cm2): "+ String.format("%.2f", superficieCubo));

                } catch (NumberFormatException error) {

                    JOptionPane.showMessageDialog(this, "Llene todas las casillas solo con números.", "Datos erroneos", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

        else if(evento.getSource()==btLimpiar){

            longitudIngresada.setText("");

            resultadoVolumen.setText("Volumen(cm3): ");
            resultadoSuperficie.setText("Superficie(cm2): ");

        }
    }
}
