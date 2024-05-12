import java.security.SecureRandom;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrapsGUI extends JFrame {
    private static final SecureRandom randomNumbers = new SecureRandom();

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    private enum Status {
        CONTINUE, WON, LOST
    }

    // GUI components
    private final JTextField die1Field = new JTextField(10);
    private final JTextField die2Field = new JTextField(10);
    private final JTextField sumField = new JTextField(10);
    private final JTextField pointField = new JTextField(10);
    private final JButton rollButton = new JButton("Roll Dice");

    private int myPoint = 0;
    private Status gameStatus;

    // Constructor
    public CrapsGUI() {
        super("Craps Game");

        // Set layout for the panel
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.add(new JLabel("Die 1"));
        panel.add(die1Field);
        panel.add(new JLabel("Die 2"));
        panel.add(die2Field);
        panel.add(new JLabel("Sum"));
        panel.add(sumField);
        panel.add(new JLabel("Point"));
        panel.add(pointField);
        panel.add(rollButton);

        // Add action listener for the roll button
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sumOfDice = rollDice();
                updateFields(sumOfDice);

                if (gameStatus == Status.CONTINUE) {
                    pointField.setText(String.valueOf(myPoint));
                } else {
                    rollButton.setEnabled(false); // Disable button after game ends
                    pointField.setText(gameStatus == Status.WON ? "Player Wins" : "Player Loses");
                }
            }
        });

        // Add panel to frame
        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    // Main method to create the frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CrapsGUI();
            }
        });
    }

    public int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);
        int sum = die1 + die2;

        if (gameStatus == null || gameStatus == Status.CONTINUE) {
            switch (sum) {
                case SNAKE_EYES: // 'Craps.' removed
                case TREY: // 'Craps.' removed
                case BOX_CARS: // 'Craps.' removed
                    gameStatus = Status.LOST;
                    break;
                case SEVEN: // 'Craps.' removed
                case YO_LEVEN: // 'Craps.' removed
                    gameStatus = Status.WON;
                    break;
                default:
                    gameStatus = Status.CONTINUE;
                    myPoint = sum;
                    break;
            }
        } else if (sum == myPoint) {
            gameStatus = Status.WON;
        } else if (sum == SEVEN) { // 'Craps.' removed
            gameStatus = Status.LOST;
        }
        return sum;
    }

    private void updateFields(int sumOfDice) {
        int die1 = (sumOfDice - 2) % 6 + 1; // Just a quick way to get a possible die value
        int die2 = sumOfDice - die1;
        die1Field.setText(String.valueOf(die1));
        die2Field.setText(String.valueOf(die2));
        sumField.setText(String.valueOf(sumOfDice));
    }
}
