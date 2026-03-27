package com.vaxsafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Provides singleton database connection instance
public class DBConnection {

    // SQLite database URL
    private static final String URL = "jdbc:sqlite:vaxsafe.db";

    // Shared connection instance
    private static Connection connection;

    // Private constructor
    private DBConnection() {}

    // Returns active database connection
    public static Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {

            try {
                // Ensures JDBC driver is loaded
                Class.forName("org.sqlite.JDBC");

            } catch (ClassNotFoundException e) {
                // Fails fast if driver is missing
                throw new SQLException("SQLite JDBC Driver not found", e);
            }

            connection = DriverManager.getConnection(URL);
        }

        return connection;
    }
}