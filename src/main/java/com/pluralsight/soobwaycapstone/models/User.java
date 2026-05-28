package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.Database.Database;
import com.pluralsight.soobwaycapstone.ui.Console;

import java.sql.SQLException;

public class User {
    String uuid;
    String username;
    String joinedAt;
    String email;
    String membershipTier;

    public User(String uuid, String username, String email, String joinedAt, String membershipTier) {
        this.uuid = uuid;
        this.username = username;
        this.email = email;
        this.joinedAt = joinedAt;
        this.membershipTier = membershipTier;

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoinedAt() {
        return joinedAt;
    }

    public String getMembershipTier() {
        return membershipTier;
    }

    public void setMembershipTier(String membershipTier) {
        this.membershipTier = membershipTier;
    }

    public void setJoinedAt(String createdAt) {
        this.joinedAt = joinedAt;
    }

    public static User promptForSignUp(String email) {
        System.out.println("Email not found. Would you like to create a free SOOBWAY account AND recieve a discount on us for your first order?");
        String signUp = Console.askForString("Sign up? (y/n)");
        if (!signUp.equalsIgnoreCase("y")) {
            System.out.println("Continuing without a discount.");
            return null;
        }

        String username = Console.askForString("Choose a username");
        try {
            User newUser = Database.registerNewUser(email, username);
            System.out.printf("Welcome to SOOBWAY %s! Your BASIC membership discount of 5%% has been applied.%n",
                    newUser.getUsername());
            return newUser;
        } catch (SQLException e) {
            System.out.println("We could not create your account. Perhaps try again later or report it to our support team at SOOBWAY! " + e.getMessage());
            return null;
        }
    }

    public static boolean checkIfValidEmail(String email) {
        return email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }


    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                ", joinedAt='" + joinedAt + '\'' +
                '}';
    }


}



