package graphicalInterface;


import userBoardComposant.UserInfoPanel;
import userBoardComposant.InventoryManagPanel;

import javax.swing.*;

public class UserBoard extends JFrame {

    public UserBoard(){
        this.setTitle("User Board");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(true);

        JTabbedPane userPane = new JTabbedPane();

        userPane.addTab("User Info", new UserInfoPanel());
        userPane.addTab("Inventory", new InventoryManagPanel());



        this.setContentPane(userPane);
        this.setVisible(true);
    }

}
