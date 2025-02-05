package com.supinfo.ui.adminBoardComposant;


import com.supinfo.database.InventoryDatabase;
import com.supinfo.database.ItemDatabase;
import com.supinfo.ui.tableBoardAdmin.InventoryTable;

import javax.swing.*;
import java.awt.*;

public class InventoryManagementPanel extends JPanel {

    private JButton saveButton = new JButton("Save");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");
    private InventoryTable inventoryTable;

    private JTextField inventoryIdField = new JTextField(15);
    private JTextField nameField = new JTextField(15);
    private JTextField priceField = new JTextField(15);
    private JTextField quantityField = new JTextField(15);
    private JTextField storeIdField = new JTextField(15);

    public InventoryManagementPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        JPanel topPanel = new JPanel(new BorderLayout());

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        GridBagConstraints gridBCBottom = new GridBagConstraints();
        gridBCBottom.insets = new Insets(5, 5, 25, 5);
        gridBCBottom.gridx = 0;
        gridBCBottom.gridy = 0;
        bottomPanel.add(saveButton, gridBCBottom);

        gridBCBottom.gridx = 1;
        bottomPanel.add(updateButton, gridBCBottom);

        gridBCBottom.gridx = 2;
        bottomPanel.add(deleteButton, gridBCBottom);

        JPanel leftPanel = new JPanel(new GridBagLayout());
        JPanel rightPanel = new JPanel(new GridBagLayout());

        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel, BorderLayout.EAST);

        GridBagConstraints leftConstraintsPanel = new GridBagConstraints();
        leftConstraintsPanel.insets = new Insets(5, 5, 5, 5);

        JLabel inventoryId = new JLabel("InventoryId");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(inventoryId, leftConstraintsPanel);
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(inventoryIdField, leftConstraintsPanel);

        JLabel name = new JLabel("Name");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 1;
        leftPanel.add(name, leftConstraintsPanel);
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 1;
        leftPanel.add(nameField, leftConstraintsPanel);

        JLabel price = new JLabel("Price");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 2;
        leftPanel.add(price, leftConstraintsPanel);
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 2;
        leftPanel.add(priceField, leftConstraintsPanel);

        JLabel quantity = new JLabel("Quantity");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 3;
        leftPanel.add(quantity, leftConstraintsPanel);
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 3;
        leftPanel.add(quantityField, leftConstraintsPanel);

        JLabel storeId = new JLabel("storeId");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 4;
        leftPanel.add(storeId, leftConstraintsPanel);
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 4;
        leftPanel.add(storeIdField, leftConstraintsPanel);

        GridBagConstraints rightConstraintsPanel = new GridBagConstraints();
        rightConstraintsPanel.insets = new Insets(5, 5, 5, 5);
        rightConstraintsPanel.gridx = 0;
        rightConstraintsPanel.gridy = 0;
        inventoryTable = new InventoryTable();
        rightPanel.add(inventoryTable, rightConstraintsPanel);

        saveButton.addActionListener(e -> {
            int inventoryIdToCreate = 0;
            try {
                inventoryIdToCreate = Integer.parseInt(inventoryIdField.getText());
            } catch (NumberFormatException e1) {
                inventoryIdToCreate = InventoryDatabase.createInventory(Integer.parseInt(storeIdField.getText()));
            }
            int itemId = ItemDatabase.createItem(nameField.getText(), Integer.parseInt(quantityField.getText()), Double.parseDouble(priceField.getText()));
            InventoryDatabase.addItemToInventory(inventoryIdToCreate, itemId);
            inventoryTable.displayInventory();
        });
        updateButton.addActionListener(e -> {});
        deleteButton.addActionListener(e -> {});

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

    }
}
