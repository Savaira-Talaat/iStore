package com.supinfo.model;

import com.supinfo.database.ConnexionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private int storeId;
    private String storeName;
    private String inventory;
    private List<User> employees;

    public Store(int storeId, String storeName) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.employees = new ArrayList<>();
    }

    public int getStoreId() {
        return storeId;
    }
    public String getStoreName(){
        return storeName;
    }
    public String getInventory(){
        return inventory;
    }
    public List<User> getEmployees() {
        return employees;
    }

    public void addEmployees(User user){
        String query = "INSERT INTO STORE_EMPLOYEES (userId, storeId) VALUE (?, ?)";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setInt(2, getStoreId());
            preparedStatement.executeUpdate();
            employees.add(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void findAllEmployees(int storeId) {
        String query = """
            SELECT * FROM USERS WHERE userId IN
            (SELECT userId FROM STORE_EMPLOYEES where storeId = ?)
        """;
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, storeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
