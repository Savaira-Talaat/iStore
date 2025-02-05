package com.supinfo.ui.tableBoardUser;

import com.supinfo.database.ConnexionDatabase;
import com.supinfo.database.UserSession;
import com.supinfo.model.User;

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

    public UserSetInfoTable() {
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

        tableModel.addColumn("Email");
        tableModel.addColumn("Username");
        tableModel.addColumn("Role");

        add(scrollPane);
        userData();
    }

    public int getSelectedRow(){
        return table.getSelectedRow();
    }

    private void userData() {
        int userId = UserSession.getUser().                                                         getUserId();  // Récupère l'ID de l'utilisateur connecté

        String query = "SELECT email, username, role FROM users WHERE userId = ?";

        try (Connection connection = ConnexionDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

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
            e.printStackTrace();
        }
    }

    public void updateUsername( String newUsername) {

        String updateQuery = "UPDATE users SET username = ? WHERE email = ?";
        try (Connection connection = ConnexionDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, UserSession.getEmail());
            preparedStatement.executeUpdate();
            tableModel.setRowCount(0);
            userData();
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
