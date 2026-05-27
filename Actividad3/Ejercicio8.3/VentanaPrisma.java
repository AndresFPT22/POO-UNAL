import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrisma extends JFrame implements ActionListener{

    private JLabel textoArea, textoAltura, resultadoVolumen, resultadoSuperficie;
    private JTextField areaIngresada, alturaIngresada;
    private JButton btCalcular, btLimpiar;

    public VentanaPrisma(){

        setTitle("Prisma");
        setSize(500, 430);
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

        textoArea = new JLabel();
        textoArea.setText("Ingrese el área de la base(cm):");
        textoArea.setForeground(Color.BLACK);
        textoArea.setFont(fuente);
        textoArea.setHorizontalAlignment(JLabel.CENTER);

        textoAltura = new JLabel();
        textoAltura.setText("Ingrese la altura(cm):");
        textoAltura.setForeground(Color.BLACK);
        textoAltura.setFont(fuente);
        textoAltura.setHorizontalAlignment(JLabel.CENTER);

        areaIngresada = new JTextField();
        areaIngresada.setText("");
        areaIngresada.setForeground(Color.BLACK);
        areaIngresada.setFont(fuente);

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

        ImageIcon imagenPrisma = new ImageIcon("src/imagenPrisma.png");
        Image imagenPrismaReal = imagenPrisma.getImage().getScaledInstance(205, 205, Image.SCALE_SMOOTH);
        ImageIcon imagenPrismaUtilizable = new ImageIcon(imagenPrismaReal);

        JLabel labelPrisma = new JLabel(imagenPrismaUtilizable);

        JPanel panelDatos = new JPanel(new GridLayout(2,2,5,5));
        panelDatos.add(textoArea);
        panelDatos.add(areaIngresada);
        panelDatos.add(textoAltura);
        panelDatos.add(alturaIngresada);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btCalcular);
        panelBotones.add(btLimpiar);

        JPanel panelResultados = new JPanel(new GridLayout(1,2,5,5));
        panelResultados.add(resultadoVolumen);
        panelResultados.add(resultadoSuperficie);

        JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelImagen.add(labelPrisma);

        panelPrincipal.add(panelDatos);
        panelPrincipal.add(panelBotones);
        panelPrincipal.add(panelResultados);
        panelPrincipal.add(panelImagen);

        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        add(panelPrincipal);
    }

    public void actionPerformed(ActionEvent evento){

        if(evento.getSource()==btCalcular){

            if(areaIngresada.getText().trim().isEmpty() || alturaIngresada.getText().trim().isEmpty()){

                JOptionPane.showMessageDialog(this, "Ingrese los datos requeridos.", "Faltan datos", JOptionPane.ERROR_MESSAGE);

            }

            else{
                
                try{
                    
                    double area = Double.parseDouble(areaIngresada.getText().trim());
                    double altura = Double.parseDouble(alturaIngresada.getText().trim());

                    double volumenPrisma = Logica.Prisma.volumenPrisma(area, altura);
                    double superficiePrisma = Logica.Prisma.SuperficiePrisma(area, altura);

                    resultadoVolumen.setText("Volumen(cm3): "+ String.format("%.2f", volumenPrisma));
                    resultadoSuperficie.setText("Superficie(cm2): "+ String.format("%.2f", superficiePrisma));

                }catch(NumberFormatException error){

                    JOptionPane.showMessageDialog(this, "Llene todas las casillas solo con números.", "Datos erroneos", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

        else if(evento.getSource()==btLimpiar){

            areaIngresada.setText("");
            alturaIngresada.setText("");

            resultadoVolumen.setText("Volumen(cm3): ");
            resultadoSuperficie.setText("Superficie(cm2): ");
            
        }
    }
}
