package com.pluralsight.soobwaycapstone.models;

public class Discount {
    private final String type;
    private final double percentage;
    private final User user;

    public Discount(String type, double percentage, User user) {
        this.type = type;
        this.percentage = percentage;
        this.user = user;
    }

    public double getPercentage() { return percentage; }
    public String getType() { return type; }
    public User getUser() { return user; }

    public double applyDiscount(double total){
        return total * ( 1 - percentage);
    }

    public double getSavingsTotal(double total){
        return total * percentage;
    }

    public static Discount forUser(User user) {
        double discountType = switch (user.getMembershipTier()) {
            case "BASIC" -> 0.03;
            case "REWARDS" -> 0.15;
            default -> 0.00;
        };
        return new Discount(user.getMembershipTier() + " Member", discountType, user);
    }

    public static Discount none() {
        return new Discount("None", 0.00, null);
    }





}
