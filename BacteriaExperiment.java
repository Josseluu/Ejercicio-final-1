import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

public class BacteriaExperiment {
    private static ArrayList<Experimento> experimentos = new ArrayList<>();
    private static Experimento experimentoActual;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestor de Experimentos de Bacterias");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JButton nuevoExperimentoButton = new JButton("Crear Nuevo Experimento");
        nuevoExperimentoButton.setBounds(50, 50, 300, 30);
        nuevoExperimentoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearNuevoExperimento();
            }
        });
        frame.add(nuevoExperimentoButton);

        JButton abrirExperimentoButton = new JButton("Abrir Experimento");
        abrirExperimentoButton.setBounds(50, 100, 300, 30);
        abrirExperimentoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirExperimento();
            }
        });
        frame.add(abrirExperimentoButton);

        JButton agregarPoblacionButton = new JButton("Agregar Población de Bacterias");
        agregarPoblacionButton.setBounds(50, 150, 300, 30);
        agregarPoblacionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarPoblacionBacterias();
            }
        });
        frame.add(agregarPoblacionButton);

        frame.setVisible(true);
    }

    private static void crearNuevoExperimento() {

        experimentoActual = new Experimento();
        experimentos.add(experimentoActual);
        JOptionPane.showMessageDialog(null, "Se ha creado un nuevo experimento.");
    }

    private static void abrirExperimento() {

    }

    private static void agregarPoblacionBacterias() {
        if (experimentoActual == null) {
            JOptionPane.showMessageDialog(null, "No hay experimento actual. Crea un nuevo experimento primero.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la población de bacterias:");
        Date fechaInicio = new Date();
        Date fechaFin = new Date(); // Debes implementar la lógica para ingresar la fecha
        int numBacterias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de bacterias iniciales:"));
        double temperatura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la temperatura:"));
        String luminosidad = JOptionPane.showInputDialog("Ingrese las condiciones de luminosidad (Alta, Media, Baja):");
        int comidaInicial = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad inicial de comida:"));
        int diaIncremento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día hasta el cual se incrementará la cantidad de comida:"));
        int comidaIncremento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de comida para el día de incremento:"));
        int comidaFinal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad final de comida en el día 30:"));


        PoblacionBacterias poblacion = new PoblacionBacterias(nombre, fechaInicio, fechaFin, numBacterias,
                temperatura, luminosidad, comidaInicial, diaIncremento, comidaIncremento, comidaFinal);
        experimentoActual.agregarPoblacion(poblacion);

        JOptionPane.showMessageDialog(null, "Se ha agregado una población de bacterias al experimento actual.");
    }

    // Clase para representar un experimento
    static class Experimento {
        private ArrayList<PoblacionBacterias> poblaciones = new ArrayList<>();

        public void agregarPoblacion(PoblacionBacterias poblacion) {
            poblaciones.add(poblacion);
        }
    }

    // Clase para representar una población de bacterias
    static class PoblacionBacterias {
        private String nombre;
        private Date fechaInicio;
        private Date fechaFin;
        private int numBacterias;
        private double temperatura;
        private String luminosidad;
        private int comidaInicial;
        private int diaIncremento;
        private int comidaIncremento;
        private int comidaFinal;

        public PoblacionBacterias(String nombre, Date fechaInicio, Date fechaFin, int numBacterias,
                                  double temperatura, String luminosidad, int comidaInicial, int diaIncremento,
                                  int comidaIncremento, int comidaFinal) {
            this.nombre = nombre;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
            this.numBacterias = numBacterias;
            this.temperatura = temperatura;
            this.luminosidad = luminosidad;
            this.comidaInicial = comidaInicial;
            this.diaIncremento = diaIncremento;
            this.comidaIncremento = comidaIncremento;
            this.comidaFinal = comidaFinal;
        }
    }
}
