package com.supinfo.ui.tableBoardUser;

import connexionPackage.ConnexionDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInventoryTable extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;
    private int id;

    public UserInventoryTable(){

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
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        //Table colon
        tableModel.addColumn("Store Name");
        tableModel.addColumn("Item Id");
        tableModel.addColumn("Item Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Quantity");

        tableModel.addRow(new Object[]{"Auchan", "1", "Bouteille", "23", "300"});
        tableModel.addRow(new Object[]{"Mono", "2", "Ketchup", "2", "30"});
        tableModel.addRow(new Object[]{"Carrefour", "3", "Salade", "0.45", "12"});
        tableModel.addRow(new Object[]{"Mont", "4", "Burger", "345", "45"});


        add(scrollPane);

    }

}


















