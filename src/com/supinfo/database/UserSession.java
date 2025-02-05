package com.supinfo.database;

import com.supinfo.model.User;

public class UserSession {
    private static User currentUser;

    public static void setUser(User user) {
        currentUser = user;
    }

    public static User getUser() {
        return currentUser;
    }


    public static int getUserId() {
        return currentUser != null ? currentUser.getUserId() : -1;
    }

    public static String getUsername() {
        return currentUser != null ? currentUser.getUsername() : null;
    }

    public static String getEmail() {
        return currentUser != null ? currentUser.getEmail() : null;
    }
}
