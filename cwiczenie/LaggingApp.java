import javax.swing.*;
import java.awt.*;

public class LaggingApp extends JFrame {
    private JButton startButton;
    private JLabel statusLabel;

    public LaggingApp() {
        setSize(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        startButton = new JButton("Start");
        statusLabel = new JLabel("Gotowy do pracy");

        startButton.addActionListener(e -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    statusLabel.setText("Pracuję... " + (i + 1) + "s");
                }
                statusLabel.setText("Zakończono blokadę.");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        add(startButton);
        add(statusLabel);

        setVisible(true);
    }
}