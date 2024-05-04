import javax.swing.*;
import java.io.*;

public class AbrirExperimento {
    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);


        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();

            try {

                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String experimentData = "";
                String line;
                while ((line = reader.readLine()) != null) {
                    experimentData += line + "\n";
                }
                reader.close();

                // Mostrar el contenido del archivo
                JOptionPane.showMessageDialog(null, "Contenido del archivo:\n" + experimentData);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.");
        }
    }
}
