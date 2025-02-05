package com.supinfo.model;

import com.supinfo.database.ConnexionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    public Admin(String username, String password, String email, Role role) {
        super(username, password, email, role);
    }

    public static void addToWhitelist(String email) {
        String query = "insert into whitelist (email) values (?)";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<String> findWhitelist() {
        String query = """
            SELECT email FROM WHITELIST
        """;
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> emails = new ArrayList<>();
            while (resultSet.next()) {
                emails.add(resultSet.getString("email"));
            }
            return emails;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteFromWhitelist(int whitelistId) {
        String query = "delete from whitelist where whitelistId = ?";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, whitelistId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void deleteEmployeeFromStore(int userId) {
        String query = "DELETE FROM STORE_EMPLOYEES WHERE userId = ?";

        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
