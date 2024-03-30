/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static String username = "sa";
    private static String password = "trungnghia282003";
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=DuLichVietNam;Encrypt=True;TrustServerCertificate=True";

    public static Connection getConnect() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    
//    public static void main(String[] args) {
//        Connection connection = getConnect();
//        if (connection != null) {
//            System.out.println("Connected successfully.");
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("Connection failed.");
//        }
//    }
}
