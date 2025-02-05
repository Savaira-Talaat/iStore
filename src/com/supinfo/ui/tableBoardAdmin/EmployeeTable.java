package com.supinfo.ui.tableBoardAdmin;

import com.supinfo.database.StoreDatabase;
import com.supinfo.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class EmployeeTable extends JPanel {
    private static DefaultTableModel tableModel;
    private static JTable table;
    private int id;


    public EmployeeTable(){
        //Table Modèle
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table.getSelectedRow();
                if (row != -1) {
                    id = (int) table.getValueAt(row, 0);
                    //System.out.println("Selected Customer ID: " + id);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        //Table colonne
        tableModel.addColumn("Id");
        tableModel.addColumn("Email");
        tableModel.addColumn("Role");
        tableModel.addColumn("storeId");
        add(scrollPane);
        searchEmployee();
    }

    public static void searchEmployee() {
        tableModel.setRowCount(0);
        List<User> allEmployees = StoreDatabase.findAllEmployees();
        for(User user: allEmployees) {
            tableModel.addRow(new Object[]{user.getUserId(), user.getEmail(),user.getRole(), user.getStoreId()});
        }
    }

}
