package com.supinfo.ui.graphicalInterface;


import com.supinfo.ui.userBoardComposant.InventoryManagPanel;
import com.supinfo.ui.userBoardComposant.SetUserInfoPanel;
import com.supinfo.ui.userBoardComposant.UserInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserBoard extends JFrame {

    public UserBoard(){
        this.setTitle("User Board");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(true);

        JTabbedPane userPane = new JTabbedPane();

        userPane.addTab("User Info", new UserInfoPanel());
        userPane.addTab("Set User Info", new SetUserInfoPanel());
        userPane.addTab("Inventory", new InventoryManagPanel());

        JPanel bottomPanel = getBottomPanel();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(userPane, BorderLayout.CENTER);
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
