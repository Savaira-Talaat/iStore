package adminBoardComposant;

import tableBoardAdmin.EmployeeTable;

import javax.swing.*;
import java.awt.*;

public class EmployeeManagementPanel extends JPanel {

    private JButton creatButton = new JButton("Create");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");
    private EmployeeTable employeeTable;

    private JTextField employeeEmailField = new JTextField(15);
    private JTextField employeeRoleField = new JTextField(15);

    public EmployeeManagementPanel(){

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        JPanel topPanel = new JPanel(new BorderLayout());

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        //Bottom panel with the button
        GridBagConstraints gridBCBottom = new GridBagConstraints();
        gridBCBottom.insets = new Insets(5,5,25,5);
        gridBCBottom.gridx = 1;
        bottomPanel.add(creatButton, gridBCBottom);

        gridBCBottom.gridx = 2;
        bottomPanel.add(updateButton, gridBCBottom);

        gridBCBottom.gridx = 3;
        bottomPanel.add(deleteButton, gridBCBottom);

        //Child panel from the Top Panel
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
        leftPanel.add(employeeEmailField, leftConstraintsPanel);

        JLabel role = new JLabel("Role");
        leftConstraintsPanel.gridx = 0;
        leftConstraintsPanel.gridy = 3;
        leftPanel.add(role, leftConstraintsPanel);
        leftConstraintsPanel.gridx = 1;
        leftConstraintsPanel.gridy = 3;
        leftPanel.add(employeeRoleField, leftConstraintsPanel);

        //Table Right Panel
        GridBagConstraints rightConstraintsPanel = new GridBagConstraints();
        rightConstraintsPanel.insets = new Insets(5, 5, 5, 5);
        rightConstraintsPanel.gridx = 0;
        rightConstraintsPanel.gridy = 0;
        employeeTable = new EmployeeTable();
        rightPanel.add(employeeTable, rightConstraintsPanel);

        creatButton.addActionListener(e -> {

        });

        updateButton.addActionListener(e -> {
        });


        deleteButton.addActionListener(e -> {
        });

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }
}
