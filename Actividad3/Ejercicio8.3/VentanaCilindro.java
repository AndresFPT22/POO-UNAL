import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaCilindro extends JFrame implements ActionListener{

    private JLabel textoRadio, textoAltura, resultadoVolumen, resultadoSuperficie;
    JTextField radioIngresado, alturaIngresada;
    private JButton btCalcular, btLimpiar;

    public VentanaCilindro(){

        setTitle("Cilindro");
        setSize(460, 335);
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

        textoRadio = new JLabel();
        textoRadio.setText("Ingrese el radio(cm):");
        textoRadio.setForeground(Color.BLACK);
        textoRadio.setFont(fuente);
        textoRadio.setHorizontalAlignment(JLabel.CENTER);

        textoAltura = new JLabel();
        textoAltura.setText("Ingrese la altura(cm):");
        textoAltura.setForeground(Color.BLACK);
        textoAltura.setFont(fuente);
        textoAltura.setHorizontalAlignment(JLabel.CENTER);

        radioIngresado = new JTextField();
        radioIngresado.setText("");
        radioIngresado.setForeground(Color.BLACK);
        radioIngresado.setFont(fuente);

        alturaIngresada = new JTextField();
        alturaIngresada.setText("");
        alturaIngresada.setForeground(Color.BLACK);
        alturaIngresada.setFont(fuente);

        resultadoSuperficie = new JLabel();
        resultadoSuperficie.setText("Superficie(cm2): ");
        resultadoSuperficie.setForeground(Color.BLACK);
        resultadoSuperficie.setFont(fuente);

        resultadoVolumen = new JLabel();
        resultadoVolumen.setText("Volumen(cm3): ");
        resultadoVolumen.setForeground(Color.BLACK);
        resultadoVolumen.setFont(fuente);

        ImageIcon imagenCilindro = new ImageIcon("src/imagenCilindro.png");
        Image imagenCilindroReal = imagenCilindro.getImage().getScaledInstance(300, 170, Image.SCALE_SMOOTH);
        ImageIcon imagenCilindroUtilizable = new ImageIcon(imagenCilindroReal);

        JLabel labelCilindro = new JLabel(imagenCilindroUtilizable);
        labelCilindro.setHorizontalAlignment(JLabel.CENTER);

        JPanel panelDatos = new JPanel(new GridLayout(2,2,5,5));
        panelDatos.add(textoRadio);
        panelDatos.add(radioIngresado);
        panelDatos.add(textoAltura);
        panelDatos.add(alturaIngresada);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btCalcular);
        panelBotones.add(btLimpiar);

        JPanel panelResultados = new JPanel(new GridLayout(1,2,5,5));
        panelResultados.add(resultadoVolumen);
        panelResultados.add(resultadoSuperficie);

        JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelImagen.add(labelCilindro);

        panelPrincipal.add(panelDatos);
        panelPrincipal.add(panelBotones);
        panelPrincipal.add(panelResultados);
        panelPrincipal.add(panelImagen);

        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        add(panelPrincipal);
    }

    public void actionPerformed(ActionEvent evento){

        if(evento.getSource()== btCalcular){

            if(radioIngresado.getText().trim().isEmpty()||alturaIngresada.getText().trim().isEmpty()){

                JOptionPane.showMessageDialog(this, "Ingrese los datos requeridos.", "Faltan datos", JOptionPane.ERROR_MESSAGE);
                
            }

            else{

                try{

                    double radio = Double.parseDouble(radioIngresado.getText().trim());
                    double altura = Double.parseDouble(alturaIngresada.getText().trim());

                    double volumenCilindro = Logica.Cilindro.volumenCilindro(radio, altura);
                    double superficieCilindro = Logica.Cilindro.superficieCilindro(radio, altura);

                    resultadoVolumen.setText("Volumen(cm3): "+ String.format("%.2f", volumenCilindro));
                    resultadoSuperficie.setText("Superficie(cm2): "+ String.format("%.2f", superficieCilindro));


                }catch(NumberFormatException error){

                    JOptionPane.showMessageDialog(this, "Llene todas las casillas solo con números.", "Datos erroneos", JOptionPane.ERROR_MESSAGE);

                }
                    
            }
        }

        else if(evento.getSource()==btLimpiar){

            radioIngresado.setText("");
            alturaIngresada.setText("");

            resultadoVolumen.setText("Volumen(cm3): ");
            resultadoSuperficie.setText("Superficie(cm2): ");

        }
    }

}
