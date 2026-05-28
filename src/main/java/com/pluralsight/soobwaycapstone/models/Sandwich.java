package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;

import java.util.List;

public class Sandwich extends Item{
    private final List<Topping> topping;
    public Sandwich(Size size, String type, List<Topping> topping, boolean specialOption) {
        super(size, type, specialOption);
        this.topping = topping;
    }

    public List<Topping> getTopping() {
        return topping;
    }

    public double getBaseCost(){
        return switch (size){
            case SMALL -> 3.50;
            case MEDIUM -> 6.50;
            case LARGE -> 9.50;
        };
    }

    public String getSandwichSize(){
        return switch (size){
            case SMALL -> "S";
            case MEDIUM -> "M";
            case LARGE -> "L";
        };
    }

    @Override
    public double calculatePrice() {
        double baseCost = switch (size){
            case SMALL -> 3.50;
            case MEDIUM -> 6.50;
            case LARGE -> 9.50;
        };

        double toppingCost = 0;
        for(Topping t: topping){
            toppingCost += t.calculateCost(size);
        }
        return baseCost + toppingCost;
    }
}
