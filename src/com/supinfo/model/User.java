package com.supinfo.model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private Role role;
    private int storeId;

    public User(String username, String password, String email, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public User(int id, String email, Role role, int storeId) {
        this.userId = id;
        this.email = email;
        this.role = role;
        this.storeId = storeId;
    }
    public User(int id, String email, Role role) {
        this.userId = id;
        this.email = email;
        this.role = role;
    }
    public int getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public String getRole() {
        return role.name();
    }

    public int getStoreId() {
        return storeId;
    }

    public boolean createAccount(String username, String password, String email) {
        if (isEmailValid(email) && isPasswordValid(password)) {
            this.username = username;
            this.password = password;
            this.email = email;
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isEmailValid(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*[A-Z].*");
    }
}
