package com.yobdc.util.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetaUtil {

    public static List<String> showTables() {
        List<String> result = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dbmeta?user=root&password=root");
            st = conn.createStatement();
            rt = st.executeQuery("show tables");
            String columnNamePrefix = "Tables_in_" + conn.getCatalog();
            while (rt.next()) {
                result.add(rt.getString(columnNamePrefix));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rt != null) {
                try {
                    rt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

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
