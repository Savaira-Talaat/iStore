package com.supinfo.ui.adminBoardComposant;


import com.supinfo.database.StoreDatabase;
import com.supinfo.ui.tableBoardAdmin.StoreTable;

import javax.swing.*;
import java.awt.*;

public class StoreManagementPanel extends JPanel {

    private JButton createButton = new JButton("Create");
    private JButton assignedButton = new JButton("Assigned");
    private JButton deleteButton = new JButton("Delete");
    private StoreTable storeTable;

    private JTextField storeNameField = new JTextField(15);

    public StoreManagementPanel() {

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
        bottomPanel.add(assignedButton, gridBCBottom);

        gridBCBottom.gridx = 2;
        bottomPanel.add(deleteButton, gridBCBottom);

        JPanel leftPanel = new JPanel(new GridBagLayout());
        JPanel rightPanel = new JPanel(new GridBagLayout());

        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel, BorderLayout.EAST);

        GridBagConstraints leftConstraintsPanel = new GridBagConstraints();
        leftConstraintsPanel.insets = new Insets(5, 5, 5, 5);

        JLabel storeName = new JLabel("Store Name");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(storeName, leftConstraintsPanel);
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(storeNameField, leftConstraintsPanel);

        GridBagConstraints rightConstraintsPanel = new GridBagConstraints();
        rightConstraintsPanel.insets = new Insets(5, 5, 5, 5);
        rightConstraintsPanel.gridx = 0;
        rightConstraintsPanel.gridy = 0;
        storeTable = new StoreTable();
        rightPanel.add(storeTable, rightConstraintsPanel);

        createButton.addActionListener(e -> {
            StoreDatabase.createStore(
                    storeNameField.getText()
            );
            storeTable.displayStore();
        });
        assignedButton.addActionListener(e -> {});
        deleteButton.addActionListener(e -> {});

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

    }
}
