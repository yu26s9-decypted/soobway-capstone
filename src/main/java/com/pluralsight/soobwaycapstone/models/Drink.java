package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;

public class Drink extends Item{
    private String drinkName;
    private double price;

    public Drink(Size size, String drinkName) {
       super(size, "Drink", false );
       this.drinkName = drinkName;
    }



    @Override
    public double calculatePrice() {
        return switch (size) {
            case SMALL -> 1.50;
            case MEDIUM -> 2.00;
            case LARGE -> 2.50;
        };
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

}


