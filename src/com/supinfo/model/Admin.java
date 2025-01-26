package com.supinfo.model;

import com.supinfo.database.ConnexionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admin extends User {
    public Admin(String username, String password, String email, Role role) {
        super(username, password, email, role);
    }

    private void addToWhitelist(String email) {
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

    private void createStore(String storeName) {
        String query = "insert into stores (storeName) value (?)";

        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, storeName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void deleteStore(int storeId) {
        String query = "delete from stores where storeId = ?";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, storeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void assignEmployeeToStore(int storeId, int userId){
        String query = "INSERT INTO STORE_EMPLOYEES (storeId, userId) VALUES (?,?)";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, storeId);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void deleteEmployeeFromStore(int userId) {
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
