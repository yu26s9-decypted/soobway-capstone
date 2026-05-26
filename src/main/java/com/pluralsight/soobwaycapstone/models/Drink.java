package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;

import java.util.List;

public class Drink extends Item{
    Size size;
    String drinkName;
    double price;

    public Drink(Size size, String type, List<Topping> topping, boolean specialOption, Size size1, String drinkName, double price) {
        super(size, type, topping, specialOption);
        this.size = size1;
        this.drinkName = drinkName;
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

}


