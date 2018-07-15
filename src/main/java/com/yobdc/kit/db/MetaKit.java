package com.yobdc.kit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaKit {
    public static boolean testConnection(String jdbcUrl) {
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl);
            String dbProductName = connection.getMetaData().getDatabaseProductName();
            String dbProductVersion = connection.getMetaData().getDatabaseProductVersion();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
