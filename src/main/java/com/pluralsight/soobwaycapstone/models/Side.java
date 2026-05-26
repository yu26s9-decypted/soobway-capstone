package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;

import java.util.List;

public class Side extends Item {
    String name;
    double price;

    public Side(Size size, String type, List<Topping> topping, boolean specialOption, String name, double price) {
        super(size, type, topping, specialOption);
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
        return 0;
    }
}
