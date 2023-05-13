package com.nhom13.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {

    public static Connection openConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connect = "jdbc:sqlserver://localhost:1433;databaseName=BANTRASUA;user=sa;password=123456;encrypt=false";
        Connection con = DriverManager.getConnection(connect);
        return con;
    }
//    
//    public static Connection openConnection() {
//        Connection conn = null;
//
//        try {
//            String userName = "root";
//            String password = "123456789";
//            String url = "jdbc:mysql://localhost:3306/TRASUA";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(url, userName, password);
//            System.out.println("Database connection successful");
//        } catch (Exception e) {
//            System.err.println("Cannot connect to database server");
//            System.err.println(e.getMessage());
//            e.printStackTrace();
//        }
//        return conn;
//    }
}
