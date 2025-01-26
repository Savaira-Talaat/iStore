package com.supinfo.ui.graphicalInterface;


import com.supinfo.ui.adminBoardComposant.EmployeeManagementPanel;
import com.supinfo.ui.adminBoardComposant.InventoryManagementPanel;
import com.supinfo.ui.adminBoardComposant.StoreManagementPanel;

import javax.swing.*;

public class AdminBoard extends JFrame {

    public AdminBoard() {
        this.setTitle("Admin Board");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(true);

        JTabbedPane adminPane = new JTabbedPane();

        adminPane.addTab("Employee Management", new EmployeeManagementPanel());
        adminPane.addTab("Store Management", new StoreManagementPanel());
        adminPane.addTab("Inventory Management", new InventoryManagementPanel());


        this.setContentPane(adminPane);
        this.setVisible(true);

    }


}
