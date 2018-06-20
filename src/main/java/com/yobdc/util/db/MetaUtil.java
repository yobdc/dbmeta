package com.yobdc.util.db;

import java.sql.*;

public class MetaUtil {
    public static void showColumns() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dbmeta?user=root&password=root");
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getColumns(null, "%", "db_table", "%");
            rs.toString();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
