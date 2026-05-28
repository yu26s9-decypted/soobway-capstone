package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;
import com.pluralsight.soobwaycapstone.models.enums.ToppingEnum;

public class Topping {
   private ToppingEnum topping;
   private boolean isExtra;
   private int count;

    public Topping(ToppingEnum topping) {
       this.topping = topping;
       this.isExtra = false;
    }


    public ToppingEnum getTopping() {
        return topping;
    }

    public void setTopping(ToppingEnum topping) {
        this.topping = topping;
    }

    public int getCount() {
        return count;
    }

    public void setCountAdded(int countAdded) {
        this.count = countAdded;
    }

    public int addCount(){
        return count++;
    }

    public int decreaseCount(){
        return count--;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public boolean isMeat() { return topping.isMeat(); }

    public double calculateCost(Size size) {
        double baseCost = 0;
        double extraCost = 0;

        if (topping.isMeat()) {
            baseCost = switch (size) {
                case SMALL -> 1.00;
                case MEDIUM -> 2.00;
                case LARGE -> 3.00;
            };
            extraCost = switch (size) {
                case SMALL -> 0.50;
                case MEDIUM -> 1.00;
                case LARGE -> 1.50;
            };
        } else if (topping.isPremium()) {
            baseCost = switch (size) {
                case SMALL -> 0.75;
                case MEDIUM -> 1.50;
                case LARGE -> 2.25;
            };
            extraCost = switch (size) {
                case SMALL -> 0.30;
                case MEDIUM -> 0.60;
                case LARGE -> 0.90;
            };
        }

        return isExtra ? baseCost + extraCost : baseCost;
    }

    @Override
    public String toString() {
        return  topping + (isExtra ?  "Extra: " + count : "" );
    }
}
