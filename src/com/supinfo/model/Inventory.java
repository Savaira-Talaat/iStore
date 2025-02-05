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

}
