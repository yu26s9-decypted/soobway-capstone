package com.pluralsight.soobwaycapstone.models.enums;

public enum SideEnum {
    LAYS_CHIPS(1.00),
    DORITOS(1.00),
    CHOCOLATE_COOKIE(1.50),
    OATMEAL_COOKIE(1.50),
    APPLE_SLICES(0.75),
    YOGURT_PARFAIT(2.00);

    private final double price;

    SideEnum(double price) {
        this.price = price;
    }

    public double getPrice() { return price; }
    public String displayName() { return name(); }
}
