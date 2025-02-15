package Figuras;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  


public class VentanaCilindro extends JFrame implements ActionListener {

private Container contenedor;

private JLabel radio, altura, volumen, superficie;
private JTextField campoRadio, campoAltura;
private JButton calcular;

public VentanaCilindro() {
inicio();
setTitle("Cilindro"); // Establece el título de la ventana
setSize(280,210); // Establece el tamaño de la ventana
setLocationRelativeTo(null); 
setResizable(false); 
}

private void inicio() {
    contenedor = getContentPane(); 
    contenedor.setLayout(null); 
    radio = new JLabel();
    radio.setText("Radio (cms):");
    radio.setBounds(20, 20, 135, 23); 
    campoRadio = new JTextField();
    campoRadio.setBounds(100, 20, 135, 23);
    altura = new JLabel();
    altura.setText("Altura (cms):");
    altura.setBounds(20, 50, 135, 23); 
    campoAltura = new JTextField();
    campoAltura.setBounds(100, 50, 135, 23);
    calcular = new JButton();
    calcular.setText("Calcular");
    calcular.setBounds(100, 80, 135, 23);
    calcular.addActionListener(this);
    volumen = new JLabel();
    volumen.setText("Volumen (cm3):");
    volumen.setBounds(20, 110, 135, 23);

    superficie = new JLabel();
    superficie.setText("Superficie (cm2):");
    // Establece la posición de la etiqueta de superficie del cilindro
    superficie.setBounds(20, 140, 135, 23);
    // Se añade cada componente gráfico al contenedor de la ventana
    contenedor.add(radio);
    contenedor.add(campoRadio);
    contenedor.add(altura);
    contenedor.add(campoAltura);
    contenedor.add(calcular);
    contenedor.add(volumen);
    contenedor.add(superficie);
    }
    /**
    * Método que gestiona los eventos generados en la ventana del  
   * cilindro throws Exception Excepción al ingresar un campo nulo o  
   * error en formato de número
    */
    public void actionPerformed(ActionEvent event) {
    // Se inicializan el radio y la altura del cilindro
    boolean error = false; /* Se inicializa variable para determinar si 
   ocurre un error */
    double radio = 0;
    double altura = 0;
    try {
    // Se obtiene el radio del cilindro ingresado
    radio  = Double.parseDouble(campoRadio.getText());
    // Se obtiene la altura del cilindro ingresada
    altura  = Double.parseDouble(campoAltura.getText());
    Cilindro cilindro = new Cilindro(radio, altura); /* Se crea un 
   objeto Cilindro */
    // Se calcula y muestra el volumen
    volumen.setText("Volumen (cm3): " + String.format("%.2f", 
   cilindro.calcularVolumen()));
    // Se calcula y muestra la superficie
    superficie.setText("Superficie (cm2): " + String.format("%.2f", 
   cilindro.calcularSuperficie()));
    } catch (Exception e){
    error = true; } 
    
    finally {
    if(error) { /* Si ocurre una excepción, se muestra un mensaje 
   de error */
    JOptionPane.showMessageDialog(null,"Campo nulo o error en formato de numero",
    "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    }
    }