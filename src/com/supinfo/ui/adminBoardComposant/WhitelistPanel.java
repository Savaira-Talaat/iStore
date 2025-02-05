package com.supinfo.ui.adminBoardComposant;

import com.supinfo.model.Admin;
import com.supinfo.ui.tableBoardAdmin.WhitelistTable;

import javax.swing.*;
import java.awt.*;

public class WhitelistPanel extends JPanel {
    private JButton createButton = new JButton("Create");
    private JButton deleteButton = new JButton("Delete");
    private JTextField emailField = new JTextField(15);

    public WhitelistPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        JPanel topPanel = new JPanel(new BorderLayout());

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        GridBagConstraints gridBCBottom = new GridBagConstraints();
        gridBCBottom.insets = new Insets(5, 5, 25, 5);
        gridBCBottom.gridx = 0;
        gridBCBottom.gridy = 0;
        bottomPanel.add(createButton, gridBCBottom);

        gridBCBottom.gridx = 1;
        bottomPanel.add(deleteButton, gridBCBottom);

        JPanel leftPanel = new JPanel(new GridBagLayout());
        JPanel rightPanel = new JPanel(new GridBagLayout());

        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel, BorderLayout.EAST);

        GridBagConstraints leftConstraintsPanel = new GridBagConstraints();
        leftConstraintsPanel.insets = new Insets(5, 5, 5, 5);

        JLabel email = new JLabel("Email");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(email, leftConstraintsPanel);
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(emailField, leftConstraintsPanel);

        GridBagConstraints rightConstraintsPanel = new GridBagConstraints();
        rightConstraintsPanel.insets = new Insets(5, 5, 5, 5);
        rightConstraintsPanel.gridx = 0;
        rightConstraintsPanel.gridy = 0;
        WhitelistTable whitelistTable = new WhitelistTable();
        rightPanel.add(whitelistTable, rightConstraintsPanel);

        createButton.addActionListener(e -> {
            Admin.addToWhitelist(
                    emailField.getText()
            );
            whitelistTable.displayWhitelist();
        });

        deleteButton.addActionListener(e -> {});

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }
}
