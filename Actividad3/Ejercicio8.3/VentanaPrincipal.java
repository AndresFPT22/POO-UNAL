import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener{

    private JButton btCilindro, btEsfera, btPrisma, btCubo, btPiramide;
    private JLabel textoIndicaciones;

    public VentanaPrincipal(){

        setTitle("Figuras");
        setSize(420, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        Font fuente = new Font("Segoe UI", Font.BOLD, 16);

        btCilindro = new JButton();
        btCilindro.setText("Cilindro");
        btCilindro.setBackground(new Color(255, 253, 214));
        btCilindro.setForeground(Color.BLACK);
        btCilindro.setFont(fuente);
        btCilindro.addActionListener(this);

        btEsfera = new JButton();
        btEsfera.setText("Esfera");
        btEsfera.setBackground(new Color(255, 253, 214));
        btEsfera.setForeground(Color.BLACK);
        btEsfera.setFont(fuente);
        btEsfera.addActionListener(this);

        btPrisma = new JButton();
        btPrisma.setText("Prisma");
        btPrisma.setBackground(new Color(255, 253, 214));
        btPrisma.setForeground(Color.BLACK);
        btPrisma.setFont(fuente);
        btPrisma.addActionListener(this);

        btCubo = new JButton();
        btCubo.setText("Cubo");
        btCubo.setBackground((new Color(255, 253, 214)));
        btCubo.setForeground(Color.BLACK);
        btCubo.setFont(fuente);
        btCubo.addActionListener(this);

        btPiramide = new JButton();
        btPiramide.setText("Piramide");
        btPiramide.setBackground(new Color(255, 253, 214));
        btPiramide.setForeground(Color.BLACK);
        btPiramide.setFont(fuente);
        btPiramide.addActionListener(this);

        textoIndicaciones = new JLabel();
        textoIndicaciones.setText("Seleccione una de las siguientes figuras:");
        textoIndicaciones.setForeground(Color.BLACK);
        textoIndicaciones.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JPanel panelIndicacion = new JPanel();
        panelIndicacion.setLayout(new FlowLayout());
        panelIndicacion.add(textoIndicaciones);

        JPanel panelBotones1 = new JPanel();
        panelBotones1.setLayout(new FlowLayout());
        panelBotones1.add(btCilindro);
        panelBotones1.add(btEsfera);
        panelBotones1.add(btPiramide);

        JPanel panelBotones2 = new JPanel(new FlowLayout());
        panelBotones2.add(btCubo);
        panelBotones2.add(btPrisma);
        

        panelPrincipal.add(panelIndicacion);
        panelPrincipal.add(panelBotones1);
        panelPrincipal.add(panelBotones2);

        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        add(panelPrincipal);
    }

    public void actionPerformed(ActionEvent event){

        if(event.getSource()==btCilindro){

            VentanaCilindro ventanaCilindro = new VentanaCilindro();
            ventanaCilindro.setVisible(true);

        }

        else if(event.getSource()==btEsfera){

            VentanaEsfera ventanaEsfera = new VentanaEsfera();
            ventanaEsfera.setVisible(true);
        }

        else if(event.getSource()==btPiramide){

            VentanaPiramide ventanaPiramide = new VentanaPiramide();
            ventanaPiramide.setVisible(true);
        }

        else if(event.getSource()==btCubo){

            VentanaCubo ventanaCubo = new VentanaCubo();
            ventanaCubo.setVisible(true);
        }

        else if(event.getSource()==btPrisma){

            VentanaPrisma ventanaPrisma = new VentanaPrisma();
            ventanaPrisma.setVisible(true);
        }
    }

}
