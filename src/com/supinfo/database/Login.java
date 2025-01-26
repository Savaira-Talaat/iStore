package com.supinfo.database;

import com.supinfo.model.Role;
import com.supinfo.ui.graphicalInterface.AdminBoard;
import com.supinfo.ui.graphicalInterface.UserBoard;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class Login {
    public static Role authenticate(String username, String password) {
        String query = "Select username, password, role from users where username = ?";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String hashedPwd = resultSet.getString("password");
                BCrypt.checkpw(password, hashedPwd);
                Role role = Role.valueOf(resultSet.getString("role"));
                if (role.equals(Role.EMPLOYEE)) {
                    return Role.EMPLOYEE;
                }
                else {
                    return Role.ADMIN;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
