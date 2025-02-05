package com.supinfo.ui.userBoardComposant;

import com.supinfo.ui.tableBoardUser.UserInventoryTable;

import javax.swing.*;
import java.awt.*;

public class InventoryManagPanel extends JPanel {

    private JButton updateButton = new JButton("Update");

    private UserInventoryTable userInventoryTable;

    private JTextField itemIdField = new JTextField(15);

    private JSpinner quantitySpinner;

    public InventoryManagPanel(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        JPanel topPanel = new JPanel(new BorderLayout());

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        GridBagConstraints gridBCBottom = new GridBagConstraints();
        gridBCBottom.insets = new Insets(5, 5, 25, 5);
        gridBCBottom.gridx = 1;
        bottomPanel.add(updateButton, gridBCBottom);

        JPanel leftPanel = new JPanel(new GridBagLayout());
        JPanel rightPanel = new JPanel(new GridBagLayout());

        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel, BorderLayout.EAST);

        GridBagConstraints leftConstraintsPanel = new GridBagConstraints();
        leftConstraintsPanel.insets = new Insets(5, 5, 5, 5);

        JLabel itemIdLabel = new JLabel("Item ID:");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(itemIdLabel, leftConstraintsPanel);

        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(itemIdField, leftConstraintsPanel);

        JLabel quantityLabel = new JLabel("Quantity");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 1;
        leftPanel.add(quantityLabel, leftConstraintsPanel);

        quantitySpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1)); // Minimum 0, pas de maximum, incrément de 1
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 1;
        leftPanel.add(quantitySpinner, leftConstraintsPanel);

        GridBagConstraints rightConstraintsPanel = new GridBagConstraints();
        rightConstraintsPanel.insets = new Insets(5, 5, 5, 5);
        rightConstraintsPanel.gridx = 0;
        rightConstraintsPanel.gridy = 0;
        userInventoryTable = new UserInventoryTable();
        rightPanel.add(userInventoryTable, rightConstraintsPanel);

        updateButton.addActionListener(e -> {
            String itemId = itemIdField.getText();
            int quantity = (int) quantitySpinner.getValue();
            System.out.println("Item ID: " + itemId);
            System.out.println("Quantity: " + quantity);
        });




        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }
}
