import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FixedApp extends JFrame {
    private JButton startButton;
    private JLabel statusLabel;

    public FixedApp() {
        setSize(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        startButton = new JButton("Start");
        statusLabel = new JLabel("Gotowy do pracy");

        startButton.addActionListener(e -> {
            startButton.setEnabled(false);

            SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {

                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        publish("Pracuję... " + (i + 1) + "s");
                    }
                    return null;
                }

                @Override
                protected void process(List<String> chunks) {
                    String latestStatus = chunks.get(chunks.size() - 1);
                    statusLabel.setText(latestStatus);
                }

                @Override
                protected void done() {
                    statusLabel.setText("Zakończono pomyślnie!");
                    startButton.setEnabled(true);
                }
            };
            worker.execute();
        });

        add(startButton);
        add(statusLabel);

        setVisible(true);
    }
}