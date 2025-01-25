package userBoardComposant;

import tableBoardUser.UserEmployeeTable;

import javax.swing.*;
import java.awt.*;

public class UserInfoPanel extends JPanel {

    private UserEmployeeTable userEmployeeTable;

    public UserInfoPanel(){

        JPanel mainPanel = new JPanel();

        GridBagConstraints rightConstraintsPanel = new GridBagConstraints();
        rightConstraintsPanel.insets = new Insets(5, 5, 5, 5);
        rightConstraintsPanel.gridx = 0;
        rightConstraintsPanel.gridy = 0;
        userEmployeeTable = new UserEmployeeTable();
        mainPanel.add(userEmployeeTable, rightConstraintsPanel);

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }
}
