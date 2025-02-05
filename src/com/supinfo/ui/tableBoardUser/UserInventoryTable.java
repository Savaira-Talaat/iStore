package com.supinfo.ui.tableBoardUser;


import com.supinfo.database.InventoryDatabase;
import com.supinfo.database.StoreDatabase;
import com.supinfo.database.UserSession;
import com.supinfo.model.Item;
import com.supinfo.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
        items();

        add(scrollPane);

    }

    public void items() {
        tableModel.setRowCount(0);
        List<Item> allItems = InventoryDatabase.findAllItems(UserSession.getUserId());
        for(Item item: allItems) {
            tableModel.addRow(new Object[]{"Lego", item.getItemId(),item.getItemName(), item.getPrice(), item.getQuantity()});
        }
    }

}


















