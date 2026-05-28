package com.pluralsight.soobwaycapstone.Database;

import com.pluralsight.soobwaycapstone.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    public static User getUser() throws SQLException {
        Connection connection = connect();
        try {
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM users LIMIT 1");
            System.out.println("Trying to fetch data from user table");

            if(result != null){
                System.out.println("Success.");
                if (result.next()) {
                    return new User(
                            result.getString("id"),
                            result.getString("username"),
                            result.getString("email"),
                            result.getString("joined_at"),
                            result.getString("tier")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occured" + e.getMessage());
        }
        connection.close();
        return null;
    }


    public static User getUserByEmail(String email) throws SQLException {
        Connection connection = connect();

        try {
            var statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            var result = statement.executeQuery();

            if (result.next()) {
                return new User(
                        result.getString("id"),
                        result.getString("username"),
                        result.getString("email"),
                        result.getString("joined_at"),
                        result.getString("tier")
                );
            }
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
    } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public static User registerNewUser(String email, String username) throws SQLException {
        String insertQuery = "INSERT INTO users (id, username, email, joined_at, tier) VALUES (gen_random_uuid(), ?, ?, NOW(), 'BASIC')";

        try (Connection connection = connect();
             PreparedStatement s = connection.prepareStatement(insertQuery)) {
                s.setString(1, username);
                s.setString(2, email);
                s.executeUpdate();
        }

        return getUserByEmail(email);
    }
}