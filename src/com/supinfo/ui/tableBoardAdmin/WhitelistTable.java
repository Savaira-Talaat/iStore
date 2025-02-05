package com.supinfo.ui.tableBoardAdmin;

import com.supinfo.model.Admin;
import com.supinfo.model.Store;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class WhitelistTable extends JPanel {
    private DefaultTableModel tableModel;
    //Manque la class qui s'occupe de l'appel à la bse de donnée et récupère les données
    private JTable table;
    private int id;
    private JScrollPane scrollPane;

    public WhitelistTable(){
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
        tableModel.addColumn("email");

        displayWhitelist();

    }

    public void displayWhitelist() {
        tableModel.setRowCount(0);
        List<String> emails = Admin.findWhitelist();
        for(String email: emails) {
            tableModel.addRow(new Object[]{email});
        }
        add(scrollPane);
    }


}
