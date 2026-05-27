package com.pluralsight.soobwaycapstone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://ep-tiny-art-ap64cj8u-pooler.c-7.us-east-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require";
    private static final String USER = "neondb_owner";
    private static final String PASSWORD = System.getenv("DB_PW");

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void testConnection() throws Exception {
        Connection connection = connect();
        if (connection != null) {
            System.out.println("Neon DB connected successfully");
            connection.close();
        }
    }

}