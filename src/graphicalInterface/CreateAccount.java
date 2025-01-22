package graphicalInterface;

import javax.swing.*;
import java.awt.*;

public class CreateAccount extends JFrame {

    private JButton createAccountButton = new JButton("Create an account");
    private JButton loginButton = new JButton("Login");

    public CreateAccount() {
        this.setTitle("Create an account");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(true);

        JPanel centralPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBCCentralPanel = new GridBagConstraints();

        JLabel vide = new JLabel("");
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 0;
        centralPanel.add(vide);

        JLabel createAccount = new JLabel("Create an account");
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 0;
        centralPanel.add(createAccount);

        JLabel email = new JLabel("Email : ");
        JTextField emailField = new JTextField(20);
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 1;
        centralPanel.add(email, gridBCCentralPanel);
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 1;
        centralPanel.add(emailField, gridBCCentralPanel);

        JLabel password = new JLabel("Password : ");
        JTextField passwordField = new JTextField(20);
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 2;
        centralPanel.add(password, gridBCCentralPanel);
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 2;
        centralPanel.add(passwordField, gridBCCentralPanel);


        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 3;
        centralPanel.add(createAccountButton, gridBCCentralPanel);

        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 4;
        centralPanel.add(loginButton, gridBCCentralPanel);

        createAccountButton.addActionListener(e -> {});

        loginButton.addActionListener(e -> {
            new Login();
            this.dispose();
        });

        this.setContentPane(centralPanel);
        this.setVisible(true);
    }
}
