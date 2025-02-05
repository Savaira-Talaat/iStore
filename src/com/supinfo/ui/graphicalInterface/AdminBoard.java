package com.supinfo.ui.graphicalInterface;


import com.supinfo.ui.adminBoardComposant.EmployeeManagementPanel;
import com.supinfo.ui.adminBoardComposant.InventoryManagementPanel;
import com.supinfo.ui.adminBoardComposant.StoreManagementPanel;
import com.supinfo.ui.adminBoardComposant.WhitelistPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        adminPane.addTab("Whitelist Management", new WhitelistPanel());

        JPanel bottomPanel = getBottomPanel();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(adminPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    private JPanel getBottomPanel() {
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                    new Login();
                }
            }
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(logoutButton);
        return bottomPanel;
    }
}
