package com.pluralsight.soobwaycapstone.models;

public class Side extends Item {
    String name;
    double price;

    public Side(String name, double price) {
        super(null, name, false);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    public String toString() {
        return name;
    }
}
