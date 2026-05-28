package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;

import java.util.List;

public class Sandwich extends Item{
    private final List<Topping> topping;
    private boolean isToasted;
    public Sandwich(Size size, String type, List<Topping> topping, boolean specialOption, boolean isToasted) {
        super(size, type, specialOption);
        this.topping = topping;
        this.isToasted = false;
        setToasted(isToasted);

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

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
        type = type.replace("(Toasted) ", "");
        if(isToasted){
            type = String.format("(Toasted) %s", type);
        }

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

    public void addToTopping(Topping addedToppings){
        for (Topping exist : topping){
            if(exist.getTopping() == addedToppings.getTopping()){
                exist.setExtra(true);
                exist.addCount();
                return;
            }
        }
        topping.add(addedToppings);
    }

    public void removeTopping(int i){
        Topping t = topping.get(i);

        if(t.isExtra()){
            t.decreaseCount();
            if(t.getCount() == 1){
                t.setExtra(false);
            } else {
                topping.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s | %s", size, type, topping);
    }
}
