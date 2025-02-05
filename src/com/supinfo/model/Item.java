package com.supinfo.model;

public class Item {
    private int itemId;
    private String itemName;
    private int quantity;
    private double price;
    private int inventoryId;

    public Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public Item(int itemId, String itemName, int quantity, double price, int inventoryId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.inventoryId = inventoryId;
    }


    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getInventoryId() {
        return inventoryId;
    }
}
