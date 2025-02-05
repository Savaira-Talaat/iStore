package com.supinfo.database;

import com.supinfo.model.Item;
import com.supinfo.model.Role;
import com.supinfo.model.Store;
import com.supinfo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDatabase {

    public static void addEmployees(int userId, int storeId){
        String query = "INSERT INTO STORE_EMPLOYEES (userId, storeId) VALUE (?, ?)";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, storeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<User> findAllEmployees() {
        String query = """
            SELECT u.userId, u.email, u.role, se.storeId FROM USERS u left join STORE_EMPLOYEES se
            on se.userId = u.userId
        """;
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("userId"),
                        resultSet.getString("email"),
                        Role.valueOf(resultSet.getString("role")),
                        resultSet.getInt("storeId")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createStore(String storeName) {
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

    public static List<Store> findAllStore() {
        String query = """
            SELECT * FROM STORES
        """;
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Store> stores = new ArrayList<>();
            while (resultSet.next()) {
                Store store = new Store(
                        resultSet.getInt("storeId"),
                        resultSet.getString("storeName")
                );
                stores.add(store);
            }
            return stores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
