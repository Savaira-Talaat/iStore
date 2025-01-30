package tableBoardUser;

import connexionPackage.ConnexionDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEmployeeTable extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;
    private int id;

    public UserEmployeeTable(){

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
        tableModel.addColumn("Email");
        tableModel.addColumn("Username");
        tableModel.addColumn("Role");

        tableModel.addRow(new Object[]{"titi@gmail.com", "Titi", "EMPLOYEE"});
        tableModel.addRow(new Object[]{"Savaira@Kahoot.fr", "Savaira", "EMPLOYEE"});
        tableModel.addRow(new Object[]{"Papi@quartsiecle.com", "Mathias", "EMPLOYEE"});
        tableModel.addRow(new Object[]{"helloworld@gmail.com", "World", "EMPLOYEE"});

        add(scrollPane);
    }
}
