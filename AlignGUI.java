import javax.swing.*;
import java.awt.*;

public class AlignGUI {
    public static void main(String[] args) {
        // Creating the Frame
        JFrame frame = new JFrame("Align");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel labelX = new JLabel("X:");
        JLabel labelY = new JLabel("Y:");
        JTextField tfX = new JTextField("8", 5);
        JTextField tfY = new JTextField("8", 5);
        JButton btnOk = new JButton("Ok");
        JButton btnCancel = new JButton("Cancel");
        JButton btnHelp = new JButton("Help");

        // Checkboxes
        JCheckBox checkSnap = new JCheckBox("Snap to Grid");
        JCheckBox checkShow = new JCheckBox("Show Grid");

        // Adding Components to the frame.
        panel.add(checkSnap);
        panel.add(labelX);
        panel.add(tfX);
        panel.add(checkShow);
        panel.add(labelY);
        panel.add(tfY);
        panel.add(btnOk);
        panel.add(btnCancel);
        panel.add(btnHelp);

        // Adjusting panel layout
        GridLayout gl = new GridLayout(3, 3);
        gl.setHgap(5);
        gl.setVgap(5);
        panel.setLayout(gl);

        // Adding Panel to Frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // Setting the frame visibility
        frame.setVisible(true);
    }
}
