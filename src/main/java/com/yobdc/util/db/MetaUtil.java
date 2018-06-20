package com.yobdc.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaUtil {
    public static void load() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dbmeta?user=root&password=root");
            conn.getMetaData();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
