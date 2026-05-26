package com.pluralsight.soobwaycapstone.models.enums;

public enum ToppingEnum {
    // Meats
    BACON(true, false),
    CHICKEN(true, false),
    HAM(true, false),
    PEPPERONI(true, false),
    ROAST_BEEF(true, false),
    SALAMI(true, false),
    STEAK(true, false),
    TUNA(true, false),
    TURKEY(true, false),
    // Cheese (premium)
    AMERICAN(false, true),
    CHEDDAR(false, true),
    MOZZARELLA(false, true),
    PEPPER_JACK(false, true),
    PROVOLONE(false, true),
    SWISS(false, true),
    // Veggies (premium)
    AVOCADO(false, true),
    GUACAMOLE(false, true),
    ROASTED_PEPPERS(false, true),
    SUN_DRIED_TOMATOES(false, true),
    // Veggies (regular)
    BANANA_PEPPERS(false, false),
    BLACK_OLIVES(false, false),
    CUCUMBER(false, false),
    GREEN_PEPPERS(false, false),
    JALAPENOS(false, false),
    LETTUCE(false, false),
    ONION(false, false),
    PICKLES(false, false),
    SPINACH(false, false),
    TOMATO(false, false),
    // Sauces (regular)
    BUFFALO(false, false),
    HONEY_MUSTARD(false, false),
    MAYO(false, false),
    MUSTARD(false, false),
    RANCH(false, false),
    SWEET_ONION(false, false);
    public final boolean isMeat;
    private final boolean isPremium;

    ToppingEnum(boolean isMeat, boolean isPremium) {
        this.isMeat = isMeat;
        this.isPremium = isPremium;
    }

    public boolean isMeat() { return isMeat; }
    public boolean isPremium() { return isPremium; }

    public String displayName(){
        return name();
    }


}
