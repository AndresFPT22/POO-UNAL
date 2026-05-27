import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Pantalla extends JFrame implements ActionListener{

    private JTextField nota1Ingresada, nota2Ingresada, nota3Ingresada, nota4Ingresada, nota5Ingresada;
    private JButton btCalcular, btLimpiar;
    private JLabel textoNota1, textoNota2, textoNota3, textoNota4, textoNota5, textoPromedio, textoDesviacion, textoNotaMenor, textoNotaMayor;

    public Pantalla(){

        setTitle("Notas");
        setSize(250, 308);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contenedorPrincipal = new JPanel();

        contenedorPrincipal.setLayout(new BoxLayout(contenedorPrincipal, BoxLayout.Y_AXIS));
        Font fuente = new Font("Segoe UI", Font.BOLD, 12);

        nota1Ingresada = new JTextField(10);
        nota1Ingresada.setFont(fuente);

        nota2Ingresada = new JTextField(10);
        nota2Ingresada.setFont(fuente);

        nota3Ingresada = new JTextField(10);
        nota3Ingresada.setFont(fuente);
        
        nota4Ingresada = new JTextField(10);
        nota4Ingresada.setFont(fuente);

        nota5Ingresada = new JTextField(10);
        nota5Ingresada.setFont(fuente);

        btCalcular = new JButton("Calcular");
        btCalcular.setBackground(new Color(255, 220, 220));
        btCalcular.setForeground(Color.BLACK);
        btCalcular.setFont(fuente);
        btCalcular.addActionListener(this);

        btLimpiar = new JButton("Limpiar");
        btLimpiar.setBackground(new Color(255, 220, 220));
        btLimpiar.setForeground(Color.BLACK);
        btLimpiar.setFont(fuente);
        btLimpiar.addActionListener(this);

        textoNota1 = new JLabel("Nota 1:");
        textoNota1.setHorizontalAlignment(SwingConstants.CENTER);
        textoNota1.setForeground(Color.BLACK);
        textoNota1.setFont(fuente);

        textoNota2 = new JLabel("Nota 2:");
        textoNota2.setHorizontalAlignment(SwingConstants.CENTER);
        textoNota2.setForeground(Color.BLACK);
        textoNota2.setFont(fuente);

        textoNota3 = new JLabel("Nota 3:");
        textoNota3.setHorizontalAlignment(SwingConstants.CENTER);
        textoNota3.setForeground(Color.BLACK);
        textoNota3.setFont(fuente);

        textoNota4 = new JLabel("Nota 4:");
        textoNota4.setHorizontalAlignment(SwingConstants.CENTER);
        textoNota4.setForeground(Color.BLACK);
        textoNota4.setFont(fuente);
        
        textoNota5 = new JLabel("Nota 5:");
        textoNota5.setHorizontalAlignment(SwingConstants.CENTER);
        textoNota5.setForeground(Color.BLACK);
        textoNota5.setFont(fuente);

        textoPromedio = new JLabel("Promedio: ");
        textoPromedio.setForeground(Color.BLACK);
        textoPromedio.setFont(fuente);

        textoDesviacion = new JLabel("Desviación estandar: ");
        textoDesviacion.setForeground(Color.BLACK);
        textoDesviacion.setFont(fuente);

        textoNotaMayor = new JLabel("Nota mayor:");
        textoNotaMayor.setForeground(Color.BLACK);
        textoNotaMayor.setFont(fuente);

        textoNotaMenor = new JLabel("Nota menor: ");
        textoNotaMenor.setForeground(Color.BLACK);
        textoNotaMenor.setFont(fuente);

        JPanel panelNotas = new JPanel();
        panelNotas.setLayout(new GridLayout(5, 2,8,5));

        panelNotas.add(textoNota1);
        panelNotas.add(nota1Ingresada);

        panelNotas.add(textoNota2);
        panelNotas.add(nota2Ingresada);

        panelNotas.add(textoNota3);
        panelNotas.add(nota3Ingresada);

        panelNotas.add(textoNota4);
        panelNotas.add(nota4Ingresada);

        panelNotas.add(textoNota5);
        panelNotas.add(nota5Ingresada);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        panelBotones.add(btCalcular);
        panelBotones.add(btLimpiar);

        JPanel panelResultados = new JPanel();
        panelResultados.setLayout(new GridLayout(4, 1, 5, 5));

        panelResultados.add(textoPromedio);
        panelResultados.add(textoDesviacion);
        panelResultados.add(textoNotaMayor);
        panelResultados.add(textoNotaMenor);

        contenedorPrincipal.add(panelNotas);
        contenedorPrincipal.add(panelBotones);
        contenedorPrincipal.add(panelResultados);
        
        contenedorPrincipal.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        add(contenedorPrincipal);

    }

    public void actionPerformed(ActionEvent event){

            if(event.getSource() == btCalcular){

                if(nota1Ingresada.getText().trim().isEmpty() || 
                nota2Ingresada.getText().trim().isEmpty() || 
                nota3Ingresada.getText().trim().isEmpty() || 
                nota4Ingresada.getText().trim().isEmpty() ||
                nota5Ingresada.getText().trim().isEmpty()){

                    JOptionPane.showMessageDialog(this, "Debe ingresar las 5 notas.", "Faltan datos", JOptionPane.ERROR_MESSAGE);
                }
            
            else{

                try{
                    Notas notaEstudiante = new Notas();

                    float nota1 = Float.parseFloat(nota1Ingresada.getText().trim());
                    notaEstudiante.agregarNotas("Nota 1:", nota1);

                    float nota2 = Float.parseFloat(nota2Ingresada.getText().trim());
                    notaEstudiante.agregarNotas("Nota 2:", nota2);

                    float nota3 = Float.parseFloat(nota3Ingresada.getText().trim());
                    notaEstudiante.agregarNotas("Nota 3:", nota3);

                    float nota4 = Float.parseFloat(nota4Ingresada.getText().trim());
                    notaEstudiante.agregarNotas("Nota 4:", nota4);

                    float nota5 = Float.parseFloat(nota5Ingresada.getText().trim());
                    notaEstudiante.agregarNotas("Nota 5:", nota5);

                    textoPromedio.setText("Promedio: "+ notaEstudiante.promedio());
                    textoDesviacion.setText("Desviación estandar: " + notaEstudiante.desviacionEstandar());
                    textoNotaMayor.setText("Nota mayor: "+ notaEstudiante.notaMayor());
                    textoNotaMenor.setText(("Nota menor: "+ notaEstudiante.notaMenor()));

                } catch (NumberFormatException error){

                    JOptionPane.showMessageDialog(this, "Llene todas las casillas solo con números.", "Datos erroneos", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

            else if(event.getSource()==btLimpiar){

                textoPromedio.setText("Promedio: ");
                textoDesviacion.setText("Desviación estandar: ");
                textoNotaMayor.setText("Nota mayor: ");
                textoNotaMenor.setText("Nota menor: ");

                nota1Ingresada.setText("");
                nota2Ingresada.setText("");
                nota3Ingresada.setText("");
                nota4Ingresada.setText("");
                nota5Ingresada.setText("");
                
            }
        }
}
