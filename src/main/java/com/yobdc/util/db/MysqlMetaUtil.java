package com.yobdc.util.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlMetaUtil {

    /**
     * @param jdbcUrl jdbc:mysql://localhost/dbmeta?user=root&password=root
     * @return
     */
    public List<String> showTables(String jdbcUrl) {
        List<String> result = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("");
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

    /**
     * @param jdbcUrl   jdbc:mysql://localhost/dbmeta?user=root&password=root
     * @param tableName db_table
     */
    public void showColumns(String jdbcUrl, String tableName) {
        Connection conn = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(jdbcUrl);
            DatabaseMetaData meta = conn.getMetaData();
            rs = meta.getColumns(null, "%", tableName, "%");
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");
                String columnType = rs.getString("TYPE_NAME");
                int datasize = rs.getInt("COLUMN_SIZE");
                int digits = rs.getInt("DECIMAL_DIGITS");
                int nullable = rs.getInt("NULLABLE");
                System.out.println(columnName + " " + columnType + " " + datasize + " " + digits + " " + nullable);
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
            if (rs != null) {
                try {
                    rs.close();
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
    }
}
