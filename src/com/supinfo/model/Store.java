package com.supinfo.model;

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

}
