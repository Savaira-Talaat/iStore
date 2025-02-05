package com.supinfo.ui.graphicalInterface;

import com.supinfo.model.Role;

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

        JLabel createAccount = new JLabel("Login");
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 0;
        centralPanel.add(createAccount, gridBCCentralPanel);

        JLabel login = new JLabel("Username : ");
        JTextField loginField = new JTextField(20);
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 1;
        centralPanel.add(login, gridBCCentralPanel);
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 1;
        centralPanel.add(loginField, gridBCCentralPanel);

        JLabel password = new JLabel("Password : ");
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 2;
        centralPanel.add(password, gridBCCentralPanel);
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 2;
        centralPanel.add(passwordField, gridBCCentralPanel);

        JCheckBox passwordView = new JCheckBox("View Password");
        gridBCCentralPanel.gridx = 2;
        gridBCCentralPanel.gridy = 2;
        centralPanel.add(passwordView, gridBCCentralPanel);


        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 3;
        centralPanel.add(loginButton, gridBCCentralPanel);

        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 4;
        centralPanel.add(createAccountButton, gridBCCentralPanel);

        passwordView.addActionListener(e ->  {
            passwordField.setEchoChar((passwordView.isSelected() ? (char) 0 : '*'));
        });

        loginButton.addActionListener(e -> performLogin(loginField.getText(), new String(passwordField.getPassword())));

        createAccountButton.addActionListener(e -> {
            new CreateAccount();
            this.dispose();
        });

        this.getRootPane().setDefaultButton(loginButton);

        this.setContentPane(centralPanel);
        this.setVisible(true);
    }

    private void performLogin(String username, String password) {
        Role authenticate = com.supinfo.database.Login.authenticate(username, password);
        if (authenticate != null) {
            if (authenticate.equals(Role.EMPLOYEE)) {
                new UserBoard();
            } else if (authenticate.equals(Role.ADMIN)) {
                new AdminBoard();
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Authentication failed, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(authenticate);
    }
}
