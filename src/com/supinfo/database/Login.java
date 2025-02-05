package com.supinfo.database;

import com.supinfo.model.Role;
import com.supinfo.model.User;
import com.supinfo.ui.graphicalInterface.AdminBoard;
import com.supinfo.ui.graphicalInterface.UserBoard;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class Login {
    public static Role authenticate(String username, String password) {
        String query = "Select * from users where username = ?";
        try {
            Connection connection = ConnexionDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String hashedPwd = resultSet.getString("password");
                boolean checkPw = BCrypt.checkpw(password, hashedPwd);
                if (!checkPw) {
                    return null;
                }
                int userId = resultSet.getInt("userId");
                String email = resultSet.getString("email");
                Role role = null;
                User user = new User(userId, email, role);
                user.setUsername(username);
                UserSession.setUser(user);
                role = Role.valueOf(resultSet.getString("role"));
                if (role.equals(Role.EMPLOYEE)) {
                    return Role.EMPLOYEE;
                } else {
                    return Role.ADMIN;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
