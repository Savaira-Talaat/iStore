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

public class UserSetInfoTable extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;
    private int id;

    public UserSetInfoTable(){

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
        tableModel.addColumn("Email");
        tableModel.addColumn("Username");
        tableModel.addColumn("Role");

        add(scrollPane);

        //Ici changez par le getuserId
        userData(8);
    }

    public int getSelectedRow(){
        return table.getSelectedRow();
    }

    private void userData(int userId){
        String query = "Select email, username, role from users WHERE userId = ?";

        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");

                tableModel.addRow(new Object[]{email, username, role});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUsername(int rowIndex, String newUsername) {
        String email = (String) tableModel.getValueAt(rowIndex, 0);

        String updateQuery = "UPDATE users SET username = ? WHERE email = ?";
        try (Connection connection = ConnexionDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, email);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                tableModel.setValueAt(newUsername, rowIndex, 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int rowIndex) {
        String email = (String) tableModel.getValueAt(rowIndex, 0);

        String deleteQuery = "DELETE FROM users WHERE email = ?";

        try (Connection connection = ConnexionDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setString(1, email);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                tableModel.removeRow(rowIndex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}



















