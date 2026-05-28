package com.pluralsight.soobwaycapstone.models.enums;

public enum DrinkEnum {
    WATER("Water", Size.SMALL, 1.50),
    LEMONADE("Lemonade", Size.MEDIUM, 2.00),
    SODA("Soda", Size.MEDIUM, 2.00),
    SPRITE("Sprite", Size.MEDIUM, 2.00),
    LEMON_ICE_TEA("Lemon Ice Tea", Size.LARGE, 2.50);

    public final String displayName;
    public final Size defaultSize;
    public final double price;

    DrinkEnum(String displayName, Size defaultSize, double price) {
        this.displayName = displayName;
        this.defaultSize = defaultSize;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Size getDefaultSize() {
        return defaultSize;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return defaultSize + displayName;
    }
}
