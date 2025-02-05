package com.supinfo.ui.graphicalInterface;

import com.supinfo.database.Signin;
import com.supinfo.model.Role;
import com.supinfo.model.User;
import com.supinfo.ui.graphicalInterface.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JLabel createAccount = new JLabel("Create an account");
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 0;
        gridBCCentralPanel.gridwidth = 2;
        gridBCCentralPanel.anchor = GridBagConstraints.CENTER;
        centralPanel.add(createAccount, gridBCCentralPanel);

        JLabel email = new JLabel("Email : ");
        JTextField emailField = new JTextField(20);
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 1;
        gridBCCentralPanel.gridwidth = 1;
        gridBCCentralPanel.anchor = GridBagConstraints.EAST;
        centralPanel.add(email, gridBCCentralPanel);
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.anchor = GridBagConstraints.WEST;
        centralPanel.add(emailField, gridBCCentralPanel);

        JLabel password = new JLabel("Password : ");
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 2;
        gridBCCentralPanel.anchor = GridBagConstraints.EAST;
        centralPanel.add(password, gridBCCentralPanel);
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.anchor = GridBagConstraints.WEST;
        centralPanel.add(passwordField, gridBCCentralPanel);

        JCheckBox passwordView = new JCheckBox("View Password");
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.gridy = 3;
        centralPanel.add(passwordView, gridBCCentralPanel);

        JLabel username = new JLabel("Username : ");
        JTextField usernameField = new JTextField(20);
        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 4;
        gridBCCentralPanel.anchor = GridBagConstraints.EAST;
        centralPanel.add(username, gridBCCentralPanel);
        gridBCCentralPanel.gridx = 1;
        gridBCCentralPanel.anchor = GridBagConstraints.WEST;
        centralPanel.add(usernameField, gridBCCentralPanel);

        gridBCCentralPanel.gridx = 0;
        gridBCCentralPanel.gridy = 5;
        gridBCCentralPanel.gridwidth = 2;
        gridBCCentralPanel.anchor = GridBagConstraints.CENTER;
        centralPanel.add(createAccountButton, gridBCCentralPanel);

        gridBCCentralPanel.gridy = 6;
        centralPanel.add(loginButton, gridBCCentralPanel);

        passwordView.addActionListener(e ->  {
            passwordField.setEchoChar((passwordView.isSelected() ? (char) 0 : '*'));
        });

        createAccountButton.addActionListener(e -> {
            Signin.signIn(
                    new User(
                            usernameField.getText(),
                            passwordField.getText(),
                            emailField.getText(),
                            Role.EMPLOYEE
                    )
            );
            new Login();
            this.dispose();
        });

        loginButton.addActionListener(e -> {
            new Login();
            this.dispose();
        });

        this.setContentPane(centralPanel);
        this.setVisible(true);
    }
}
