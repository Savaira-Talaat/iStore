package tableBoardAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeTable extends JPanel {
    private DefaultTableModel tableModel;
    //Manque la class qui s'occupe de l'appel à la bse de donnée et récupère les données
    private JTable table;
    private int id;

    public EmployeeTable(){
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

        JScrollPane scrollPane = new JScrollPane(table);

        //Table colonne
        tableModel.addColumn("User ID");
        tableModel.addColumn("Email");
        tableModel.addColumn("Password");
        tableModel.addColumn("Username");
        tableModel.addColumn("Role");

        add(scrollPane);
    }


















}
