import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GlownyView extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JLabel statusLabel;

    public GlownyView() {
        setTitle("System Logowania");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JPanel userPanel = new JPanel(new FlowLayout());
        userPanel.add(new JLabel("Login:"));
        userField = new JTextField(15);
        userPanel.add(userField);

        JPanel passPanel = new JPanel(new FlowLayout());
        passPanel.add(new JLabel("Hasło:"));
        passField = new JPasswordField(15);
        passPanel.add(passField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        loginButton = new JButton("Zaloguj");
        buttonPanel.add(loginButton);

        statusLabel = new JLabel("Wprowadź dane logowania", SwingConstants.CENTER);
        statusLabel.setForeground(Color.GRAY);

        add(userPanel);
        add(passPanel);
        add(buttonPanel);
        add(statusLabel);
    }

    public String getUsername() {
        return userField.getText();
    }

    public String getPassword() {
        return String.valueOf(passField.getPassword());
    }

    public void setStatusMessage(String message, Color color) {
        statusLabel.setText(message);
        statusLabel.setForeground(color);
    }

    public void setLoginButtonEnabled(boolean enabled) {
        loginButton.setEnabled(enabled);
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
}