package com.supinfo.database;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class Login {
    public static boolean authenticate(String username, String password) {
        String query = "Select username, password from users where username = ?";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String hashedPwd = resultSet.getString("password");
                return BCrypt.checkpw(password, hashedPwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
