package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Method to get DB connection
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to database!");
            e.printStackTrace();
        }
        return null;
    }
    // public static void main(String[] args) {
    //     Connection conn = getConnection();
    //     if (conn != null) {
    //         System.out.println("Connection object: " + conn);
    //     }
    // }
}
