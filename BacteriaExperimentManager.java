import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class BacteriaExperimentManager {
    private static ArrayList<Experimento> experimentos = new ArrayList<>();

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

        frame.setVisible(true);
    }

    private static void crearNuevoExperimento() {

        Experimento nuevoExperimento = new Experimento();
        experimentos.add(nuevoExperimento);
        JOptionPane.showMessageDialog(null, "Se ha creado un nuevo experimento.");
    }

    private static void abrirExperimento() {

        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();

            JOptionPane.showMessageDialog(null, "Se ha abierto un experimento desde el archivo: " + archivoSeleccionado.getName());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún archivo.");
        }
    }


    static class Experimento {

    }
}
