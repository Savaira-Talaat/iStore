package com.supinfo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDatabase {
    private static String database = "istore_db";
    private static final String URL = "jdbc:mysql://localhost:3306/" + database;
    private static final String USER = "root";
    private static  final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}