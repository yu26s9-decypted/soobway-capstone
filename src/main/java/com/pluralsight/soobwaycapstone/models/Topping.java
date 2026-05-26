package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;

public class Topping {
    String name;
    boolean isPremium;
    boolean isExtra;
    boolean isMeat;

    public Topping(String name, boolean isPremium, boolean isExtra, boolean isMeat) {
        this.name = name;
        this.isPremium = isPremium;
        this.isExtra = isExtra;
        this.isMeat = isMeat;
    }

    public double calculateCost(Size size){
        if(isMeat){
            if(isExtra){
                return switch (size){
                    case SMALL -> 0.50;
                    case MEDIUM -> 1.00;
                    case LARGE -> 1.50;
                };
            }
            return switch (size) {
                case SMALL -> 1.00;
                case MEDIUM -> 2.00;
                case LARGE -> 3.00;
            };
        }
        return 0.00;
    }

}
