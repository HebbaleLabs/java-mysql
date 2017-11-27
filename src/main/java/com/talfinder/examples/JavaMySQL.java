package com.talfinder.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaMySQL {

    public static final String MYSQL_SERVER_URL    = "jdbc:mysql://localhost:3306/world";
    public static final String MYSQL_USER          = "demo";
    public static final String MYSQL_USER_PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            
            System.out.println("Starting !!!");
            conn = DriverManager.getConnection(MYSQL_SERVER_URL, MYSQL_USER, MYSQL_USER_PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM city where Name='Delhi'");
            System.out.println("Printin Output !!!");
            while (rs.next()) {
                System.out.println("ID:" + rs.getInt("ID"));
                System.out.println("Name:" + rs.getString("Name"));
                System.out.println("District:" + rs.getString("District"));
                System.out.println("Population:" + rs.getString("Population"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
                conn = null;
            }
        }
    }
}
