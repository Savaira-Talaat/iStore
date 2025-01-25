package com.supinfo.model;

public class Admin extends User {
    public Admin(int employeeId, String username, String password, String email, Role role) {
        super(employeeId, username, password, email, role);
    }

    private void whitelist(String email) {

    }
    private void createStore(String storeName, int storeId) {

    }
    private void deleteStore(int storeId) {

    }
    private void assignEmployeeToStore(int employeeId, int storeId){

    }
}
