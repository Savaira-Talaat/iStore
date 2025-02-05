package com.supinfo.ui.userBoardComposant;

import com.supinfo.database.UserSession;
import com.supinfo.ui.tableBoardUser.UserSetInfoTable;

import javax.swing.*;
import java.awt.*;

public class SetUserInfoPanel extends JPanel {

    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");

    private UserSetInfoTable userSetInfoTable;

    private JTextField usernameField = new JTextField(15);

    public SetUserInfoPanel(){
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

        gridBCBottom.gridx = 2;
        bottomPanel.add(deleteButton, gridBCBottom);

        //Child panel from the Top Panel
        JPanel leftPanel = new JPanel(new GridBagLayout());
        JPanel rightPanel = new JPanel(new GridBagLayout());

        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel, BorderLayout.EAST);

        GridBagConstraints leftConstraintsPanel = new GridBagConstraints();
        leftConstraintsPanel.insets = new Insets(5, 5, 5, 5);

        JLabel Username = new JLabel("Username");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(Username, leftConstraintsPanel);
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 0;
        leftPanel.add(usernameField, leftConstraintsPanel);

        //Table Right Panel
        GridBagConstraints rightConstraintsPanel = new GridBagConstraints();
        rightConstraintsPanel.insets = new Insets(5, 5, 5, 5);
        rightConstraintsPanel.gridx = 0;
        rightConstraintsPanel.gridy = 0;
        userSetInfoTable = new UserSetInfoTable();
        rightPanel.add(userSetInfoTable, rightConstraintsPanel);
        usernameField.setText(UserSession.getUsername());


        updateButton.addActionListener(e -> {
            String newUsername = usernameField.getText();
            if (!newUsername.equals(UserSession.getUsername())) {
                userSetInfoTable.updateUsername(newUsername);
                usernameField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = userSetInfoTable.getSelectedRow();
            if (selectedRow != -1) {
                int confirmation = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete the user ?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirmation == JOptionPane.YES_OPTION) {
                    userSetInfoTable.deleteUser(selectedRow);
                }
            }
        });

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }

}
