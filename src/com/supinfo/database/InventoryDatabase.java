package com.supinfo.database;

import com.supinfo.model.Item;
import com.supinfo.model.Store;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDatabase {

    public static int createInventory(int storeId) {
        String query = "INSERT INTO INVENTORY (storeId) VALUES (?)";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, storeId);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Récupère l'itemId généré
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static void addItemToInventory(int inventoryId, int itemId){
        String query = "INSERT INTO INVENTORY_ITEMS (inventoryId, itemId) VALUES (?, ?)";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, inventoryId);
            preparedStatement.setInt(2, itemId);
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

    public static List<Item> findAllItems() {
        String query = """
            SELECT * FROM ITEMS I LEFT JOIN INVENTORY_ITEMS II on II.itemId = I.itemId
        """;
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Item> items = new ArrayList<>();
            while (resultSet.next()) {
                Item item = new Item(
                        resultSet.getInt("itemId"),
                        resultSet.getString("itemName"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("inventoryId")
                );
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Item> findAllItems(int userId) {
        String query = """
            SELECT * FROM ITEMS I
            LEFT JOIN INVENTORY_ITEMS II on II.itemId = I.itemId
            LEFT JOIN INVENTORY INV on INV.inventoryId = II.inventoryID
            LEFT JOIN STORES S on S.storeId = INV.storeId
            LEFT JOIN STORE_EMPLOYEES SE on SE.storeId = S.storeId
            where SE.userId = ?
        """;
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Item> items = new ArrayList<>();
            while (resultSet.next()) {
                Item item = new Item(
                        resultSet.getInt("itemId"),
                        resultSet.getString("itemName"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("inventoryId")
                );
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
