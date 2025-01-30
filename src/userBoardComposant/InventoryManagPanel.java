package userBoardComposant;

import tableBoardUser.UserInventoryTable;

import javax.swing.*;
import java.awt.*;

public class InventoryManagPanel extends JPanel {

    private JButton updateButton = new JButton("Update");

    private UserInventoryTable userInventoryTable;

    private JTextField quantityField = new JTextField(15);


    public InventoryManagPanel(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        JPanel topPanel = new JPanel(new BorderLayout());

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        //Bottom panel with the button
        GridBagConstraints gridBCBottom = new GridBagConstraints();
        gridBCBottom.insets = new Insets(5, 5, 25, 5);
        gridBCBottom.gridx = 1;
        bottomPanel.add(updateButton, gridBCBottom);

        //Child panel from the Top Panel
        JPanel leftPanel = new JPanel(new GridBagLayout());
        JPanel rightPanel = new JPanel(new GridBagLayout());

        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel, BorderLayout.EAST);

        GridBagConstraints leftConstraintsPanel = new GridBagConstraints();
        leftConstraintsPanel.insets = new Insets(5, 5, 5, 5);

        JLabel quantity = new JLabel("Quantity");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(quantity, leftConstraintsPanel);
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(quantityField, leftConstraintsPanel);


        //Table Right Panel
        GridBagConstraints rightConstraintsPanel = new GridBagConstraints();
        rightConstraintsPanel.insets = new Insets(5, 5, 5, 5);
        rightConstraintsPanel.gridx = 0;
        rightConstraintsPanel.gridy = 0;
        userInventoryTable = new UserInventoryTable();
        rightPanel.add(userInventoryTable, rightConstraintsPanel);

        updateButton.addActionListener(e -> {
        });

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }
}
