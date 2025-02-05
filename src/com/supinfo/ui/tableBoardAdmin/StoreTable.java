package com.supinfo.ui.tableBoardAdmin;

import com.supinfo.database.StoreDatabase;
import com.supinfo.model.Store;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class    StoreTable extends JPanel {
    private DefaultTableModel tableModel;
    //Manque la class qui s'occupe de l'appel à la bse de donnée et récupère les données
    private JTable table;
    private int id;
    private JScrollPane scrollPane;

    public StoreTable(){
        //appel de la classe qui récupére la data
        //

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

        scrollPane = new JScrollPane(table);

        //Table colonne
        tableModel.addColumn("Store ID");
        tableModel.addColumn("Name");

        displayStore();

    }

    public void displayStore() {
        tableModel.setRowCount(0);
        List<Store> allStore = StoreDatabase.findAllStore();
        for(Store store: allStore) {
            tableModel.addRow(new Object[]{store.getStoreId(), store.getStoreName()});
        }
        add(scrollPane);
    }


}
