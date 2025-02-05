package com.supinfo.ui.tableBoardAdmin;

import com.supinfo.database.InventoryDatabase;
import com.supinfo.database.StoreDatabase;
import com.supinfo.model.Item;
import com.supinfo.model.Store;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class InventoryTable extends JPanel {
    private DefaultTableModel tableModel;
    //Manque la class qui s'occupe de l'appel à la bse de donnée et récupère les données
    private JTable table;
    private JScrollPane scrollPane;

    public InventoryTable(){
        //appel de la classe qui récupére la data
        //

        //Table Modèle
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        scrollPane = new JScrollPane(table);

        //Table colonne
        tableModel.addColumn("Item ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("InventoryID");

        displayInventory();
    }

    public void displayInventory() {
        tableModel.setRowCount(0);
        List<Item> allItems = InventoryDatabase.findAllItems();
        for(Item item: allItems) {
            tableModel.addRow(new Object[]{item.getItemId(), item.getItemName(), item.getPrice(), item.getQuantity(), item.getInventoryId()});
        }
        add(scrollPane);
    }
}
