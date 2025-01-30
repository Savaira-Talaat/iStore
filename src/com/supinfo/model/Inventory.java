package com.supinfo.model;

import com.supinfo.database.ConnexionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private int inventoryId;
    List<Item> items;

    public Inventory(int inventoryId) {
        this.inventoryId = inventoryId;
        this.items = new ArrayList<>();
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addInventory(List<Item> items, Store store){
        String query = "INSERT INTO INVENTORY (storeId) VALUES (?) SELECT LAST_INSERT_ID()";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, store.getStoreId());
            ResultSet resultSet = preparedStatement.executeQuery();
            for(Item item: items) {
                addItemToInventory(resultSet.getInt("inventoryId"), item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addItemToInventory(int inventoryId, Item item){
        String query = "INSERT INTO INVENTORY_ITEMS (inventoryId, itemId) VALUES (?, ?)";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, inventoryId);
            preparedStatement.setInt(2, item.getItemId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteItemToInventory(int itemId) {
        String query = "DELETE FROM INVENTORY_ITEMS WHERE itemId = ?";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, itemId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateQuantityItem(int itemId, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("The value of quantity can't be negative.");
        }
        String query = "UPDATE INVENTORY_ITEMS SET quantity = ? WHERE itemId = ?)";
            try {
                Connection connection = ConnexionDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, quantity);
                preparedStatement.setInt(2, itemId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public List<Item> findAllItems(int inventoryId) {
        String query = """
            SELECT * FROM ITEMS WHERE itemId IN
            (SELECT itemId FROM INVENTORY_ITEMS WHERE inventoryId = ?)
        """;
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, inventoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Item> items = new ArrayList<>();
            while (resultSet.next()) {
                Item item = new Item(
                        resultSet.getInt("itemId"),
                        resultSet.getString("itemName"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("price")
                );
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
