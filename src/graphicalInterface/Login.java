package graphicalInterface;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JButton loginButton = new JButton("Login");
    private JButton createAccountButton = new JButton("Create an account");

    public Login() {
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(true);

        JPanel centralPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBCCentralPanel = new GridBagConstraints();

        JLabel vide = new JLabel("");
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 0;
        centralPanel.add(vide);

        JLabel createAccount = new JLabel("Login");
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 0;
        centralPanel.add(createAccount);

        JLabel login = new JLabel("Login : ");
        JTextField loginField = new JTextField(20);
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 1;
        centralPanel.add(login, gridBCCentralPanel);
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 1;
        centralPanel.add(loginField, gridBCCentralPanel);

        JLabel password = new JLabel("Mot de passe : ");
        JTextField passwordField = new JTextField(20);
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 2;
        centralPanel.add(password, gridBCCentralPanel);
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 2;
        centralPanel.add(passwordField, gridBCCentralPanel);


        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 3;
        centralPanel.add(loginButton, gridBCCentralPanel);

        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 4;
        centralPanel.add(createAccountButton, gridBCCentralPanel);

        loginButton.addActionListener(e -> {});

        createAccountButton.addActionListener(e -> {
            new CreateAccount();
            this.dispose();
        });

        this.setContentPane(centralPanel);
        this.setVisible(true);

    }
}
