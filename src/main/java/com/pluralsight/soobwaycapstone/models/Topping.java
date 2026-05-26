package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;
import com.pluralsight.soobwaycapstone.models.enums.ToppingEnum;

public class Topping {
   private ToppingEnum topping;
   private boolean isExtra;

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

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public boolean isMeat() { return topping.isMeat(); }

    public double calculateCost(Size size) {
        if (topping.isMeat()) {
            if (isExtra) {
                return switch (size) {
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
        if (topping.isPremium()) {
            if (isExtra) {
                return switch (size) {
                    case SMALL -> 0.30;
                    case MEDIUM -> 0.60;
                    case LARGE -> 0.90;
                };
            }
            return switch (size) {
                case SMALL -> 0.75;
                case MEDIUM -> 1.50;
                case LARGE -> 2.25;
            };
        }
        return 0.00;
    }


}
