import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ExperimentManagerApp {

    public static void main(String[] args) {
        ExperimentManagerUI experimentManagerUI = new ExperimentManagerUI();
        experimentManagerUI.createAndShowGUI();
    }
}

class ExperimentManagerUI {
    private ArrayList<Experiment> experiments = new ArrayList<>();
    private Experiment currentExperiment;

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Gestor de Experimentos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JButton newExperimentButton = new JButton("Crear Nuevo Experimento");
        newExperimentButton.setBounds(50, 50, 300, 30);
        newExperimentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createNewExperiment();
            }
        });
        frame.add(newExperimentButton);

        JButton openExperimentButton = new JButton("Abrir Experimento");
        openExperimentButton.setBounds(50, 100, 300, 30);
        openExperimentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openExperiment();
            }
        });
        frame.add(openExperimentButton);

        JButton addBacteriaPopulationButton = new JButton("Agregar Población de Bacterias");
        addBacteriaPopulationButton.setBounds(50, 150, 300, 30);
        addBacteriaPopulationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBacteriaPopulation();
            }
        });
        frame.add(addBacteriaPopulationButton);

        JButton viewBacteriaPopulationsButton = new JButton("Visualizar Poblaciones de Bacterias");
        viewBacteriaPopulationsButton.setBounds(50, 200, 300, 30);
        viewBacteriaPopulationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewBacteriaPopulations();
            }
        });
        frame.add(viewBacteriaPopulationsButton);

        frame.setVisible(true);
    }

    private void createNewExperiment() {
        // Implementación para crear un nuevo experimento
    }

    private void openExperiment() {
        // Implementación para abrir un experimento existente desde un archivo
    }

    private void addBacteriaPopulation() {
        // Implementación para agregar una población de bacterias al experimento actual
    }

    private void viewBacteriaPopulations() {
        if (currentExperiment == null) {
            JOptionPane.showMessageDialog(null, "No hay experimento actual. Crea un nuevo experimento primero.");
            return;
        }

        StringBuilder populations = new StringBuilder();
        for (BacteriaPopulation population : currentExperiment.getPopulations()) {
            populations.append(population.getName()).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Poblaciones de bacterias en el experimento actual:\n" + populations.toString());
    }
}

class Experiment {
    private ArrayList<BacteriaPopulation> populations = new ArrayList<>();

    public ArrayList<BacteriaPopulation> getPopulations() {
        return populations;
    }

    public void addPopulation(BacteriaPopulation population) {
        populations.add(population);
    }
}

class BacteriaPopulation {
    private String name;

    public BacteriaPopulation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
