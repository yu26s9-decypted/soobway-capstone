package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;

public class Drink extends Item{
    private String drinkName;

    public Drink(Size size, String drinkName) {
       super(size, "Drink", false );
       this.drinkName = drinkName;
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


