import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ExperimentManagerAppCustom {

    public static void main(String[] args) {
        CustomExperimentManagerUI experimentManagerUI = new CustomExperimentManagerUI();
        experimentManagerUI.createAndShowGUI();
    }
}

class CustomExperimentManagerUI {
    private ArrayList<ExperimentCustom> experiments = new ArrayList<>();
    private ExperimentCustom currentExperiment;

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Gestor de Experimentos Personalizado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
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

        JButton deleteBacteriaPopulationButton = new JButton("Borrar Población de Bacterias");
        deleteBacteriaPopulationButton.setBounds(50, 250, 300, 30);
        deleteBacteriaPopulationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteBacteriaPopulation();
            }
        });
        frame.add(deleteBacteriaPopulationButton);

        JButton detailedPopulationInfoButton = new JButton("Información Detallada de Población");
        detailedPopulationInfoButton.setBounds(50, 300, 300, 30);
        detailedPopulationInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDetailedPopulationInfo();
            }
        });
        frame.add(detailedPopulationInfoButton);

        JButton saveExperimentButton = new JButton("Guardar Experimento");
        saveExperimentButton.setBounds(50, 350, 300, 30);
        saveExperimentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveExperiment();
            }
        });
        frame.add(saveExperimentButton);

        JButton saveAsExperimentButton = new JButton("Guardar como...");
        saveAsExperimentButton.setBounds(50, 400, 300, 30);
        saveAsExperimentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveAsExperiment();
            }
        });
        frame.add(saveAsExperimentButton);

        frame.setVisible(true);
    }

    private void createNewExperiment() {

        currentExperiment = new ExperimentCustom();
        experiments.add(currentExperiment);
        JOptionPane.showMessageDialog(null, "Nuevo experimento creado con éxito.");
    }

    private void openExperiment() {

        JOptionPane.showMessageDialog(null, "Funcionalidad 'Abrir Experimento' aún no implementada.");
    }

    private void addBacteriaPopulation() {

        if (currentExperiment == null) {
            JOptionPane.showMessageDialog(null, "No hay experimento actual. Crea un nuevo experimento primero.");
            return;
        }
        String populationName = JOptionPane.showInputDialog(null, "Ingrese el nombre de la población de bacterias:");
        if (populationName != null && !populationName.isEmpty()) {
            currentExperiment.addPopulation(new BacteriaPopulationCustom(populationName));
            JOptionPane.showMessageDialog(null, "Población de bacterias '" + populationName + "' agregada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El nombre de la población de bacterias no puede estar vacío.");
        }
    }


    private void viewBacteriaPopulations() {
        if (currentExperiment == null) {
            JOptionPane.showMessageDialog(null, "No hay experimento actual. Crea un nuevo experimento primero.");
            return;
        }

        StringBuilder populations = new StringBuilder();
        for (BacteriaPopulationCustom population : currentExperiment.getPopulations()) {
            populations.append(population.getName()).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Poblaciones de bacterias en el experimento actual:\n" + populations.toString());
    }

    private void deleteBacteriaPopulation() {
        if (currentExperiment == null) {
            JOptionPane.showMessageDialog(null, "No hay experimento actual. Crea un nuevo experimento primero.");
            return;
        }

        String[] populationNames = new String[currentExperiment.getPopulations().size()];
        for (int i = 0; i < populationNames.length; i++) {
            populationNames[i] = currentExperiment.getPopulations().get(i).getName();
        }

        String selectedPopulation = (String) JOptionPane.showInputDialog(null, "Seleccione la población de bacterias a borrar:",
                "Borrar Población de Bacterias", JOptionPane.PLAIN_MESSAGE, null, populationNames, null);

        if (selectedPopulation != null) {
            for (int i = 0; i < currentExperiment.getPopulations().size(); i++) {
                if (currentExperiment.getPopulations().get(i).getName().equals(selectedPopulation)) {
                    currentExperiment.getPopulations().remove(i);
                    JOptionPane.showMessageDialog(null, "Población de bacterias '" + selectedPopulation + "' borrada exitosamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "La población de bacterias seleccionada no existe en el experimento actual.");
        }
    }

    private void showDetailedPopulationInfo() {
        if (currentExperiment == null) {
            JOptionPane.showMessageDialog(null, "No hay experimento actual. Crea un nuevo experimento primero.");
            return;
        }

        String[] populationNames = new String[currentExperiment.getPopulations().size()];
        for (int i = 0; i < populationNames.length; i++) {
            populationNames[i] = currentExperiment.getPopulations().get(i).getName();
        }

        String selectedPopulation = (String) JOptionPane.showInputDialog(null, "Seleccione la población de bacterias para ver la información detallada:",
                "Información Detallada de Población", JOptionPane.PLAIN_MESSAGE, null, populationNames, null);

        if (selectedPopulation != null) {
            StringBuilder detailedInfo = new StringBuilder();
            for (BacteriaPopulationCustom population : currentExperiment.getPopulations()) {
                if (population.getName().equals(selectedPopulation)) {
                    detailedInfo.append("Nombre: ").append(population.getName()).append("\n");

                    break;
                }
            }

            JOptionPane.showMessageDialog(null, "Información detallada de la población de bacterias '" + selectedPopulation + "':\n" + detailedInfo.toString());
        }
    }

    private void saveExperiment() {

        JOptionPane.showMessageDialog(null, "Funcionalidad 'Guardar Experimento' aún no implementada.");
    }

    private void saveAsExperiment() {

        JOptionPane.showMessageDialog(null, "Funcionalidad 'Guardar como...' aún no implementada.");
    }
}

class ExperimentCustom {
    private ArrayList<BacteriaPopulationCustom> populations = new ArrayList<>();

    public ArrayList<BacteriaPopulationCustom> getPopulations() {
        return populations;
    }

    public void addPopulation(BacteriaPopulationCustom population) {
        populations.add(population);
    }
}

class BacteriaPopulationCustom {
    private String name;

    public BacteriaPopulationCustom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
