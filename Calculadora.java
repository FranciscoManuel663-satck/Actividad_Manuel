

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculadoraGrafica {

    private JFrame frame;
    private JTextField textField;
    private final CalculadoraLogica logica = new CalculadoraLogica();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalculadoraGrafica window = new CalculadoraGrafica();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CalculadoraGrafica() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 742, 469);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(233, 11, 279, 47);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton suma = new JButton("Suma");
        suma.setBounds(329, 179, 89, 20);
        frame.getContentPane().add(suma);
        suma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarOperacion("+");
            }
        });

        JButton resta = new JButton("Resta");
        resta.setBounds(423, 206, 89, 20);
        frame.getContentPane().add(resta);
        resta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarOperacion("-");
            }
        });

        JButton dividir = new JButton("Dividir");
        dividir.setBounds(329, 206, 89, 20);
        frame.getContentPane().add(dividir);
        dividir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarOperacion("/");
            }
        });

        JButton multiplicar = new JButton("Multiplicar");
        multiplicar.setBounds(233, 206, 91, 20);
        frame.getContentPane().add(multiplicar);
        multiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarOperacion("*");
            }
        });

        JButton borrar = new JButton("Borrar");
        borrar.setBounds(233, 179, 91, 20);
        frame.getContentPane().add(borrar);
        borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                logica.limpiar();
            }
        });

        JButton igual = new JButton("=");
        igual.setBounds(423, 179, 89, 20);
        frame.getContentPane().add(igual);
        crearBotonNumero("6", 423, 111);
        crearBotonNumero("1", 233, 145);
        crearBotonNumero("2", 329, 145);

    private void guardarOperacion(String operacion) {
        try {
            double num1 = Double.parseDouble(textField.getText());
            logica.setPrimerNumero(num1);
            logica.setOperacion(operacion);
            textField.setText("");
        } catch (Exception e) {
            textField.setText("Entrada no válida");
        }
    }

    private void crearBotonNumero(String numero, int x, int y) {
        crearBotonNumero(numero, x, y, 89, 23);
    }

    private void crearBotonNumero(final String numero, int x, int y, int ancho, int alto) {
        JButton boton = new JButton(numero);
        boton.setBounds(x, y, ancho, alto);
        frame.getContentPane().add(boton);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + numero);
            }
        });
    }
}
        crearBotonNumero("3", 423, 145);
        crearBotonNumero("0", 233, 237, 279, 23);
    }
        igual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        crearBotonNumero("5", 329, 111);
                try {
                    double num2 = Double.parseDouble(textField.getText());
        crearBotonNumero("4", 233, 111);
                    double resultado = logica.calcular(num2);
        crearBotonNumero("8", 329, 77);
        crearBotonNumero("9", 423, 77);
                    textField.setText(String.valueOf(resultado));

        crearBotonNumero("7", 233, 77);
                }
            }
        });
                    textField.setText("Error");
                } catch (Exception ex) {
                    textField.setText("Entrada no válida");
public class CalculadoraLogica {

    private double num1;
    private String operacion;

    public void setPrimerNumero(double num1) {
        this.num1 = num1;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public void limpiar() {
        this.num1 = 0;
        this.operacion = "";
    }

    public double calcular(double num2) {
        switch (operacion) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("No se puede dividir entre 0");
                }
                return num1 / num2;
            default:
                throw new IllegalStateException("No hay operación seleccionada");
        }
    }
}


