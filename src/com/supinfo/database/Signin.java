package com.supinfo.database;

import com.supinfo.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Signin {
    public boolean isWhitelisted(String email){
        String query = "SELECT COUNT(*) FROM WHITELIST WHERE email = ?";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void signIn(User user){
        String query = "INSERT INTO USERS (username, password, email, role) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            String salt = BCrypt.gensalt();
            String hashPwd = BCrypt.hashpw(user.getPassword(), salt);
            preparedStatement.setString(2, hashPwd);
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
