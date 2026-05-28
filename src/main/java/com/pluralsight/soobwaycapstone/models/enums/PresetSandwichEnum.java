package com.pluralsight.soobwaycapstone.models.enums;

import com.pluralsight.soobwaycapstone.models.Topping;

import java.util.List;

public enum PresetSandwichEnum {

    ANDYS_SPECIAL("Andy's Special", BreadType.ARTISAN_ITALIAN,
            "The man, the myth, the sandwich. Spicy, stacked, and suspiciously good.",
            List.of(ToppingEnum.BACON, ToppingEnum.CHICKEN, ToppingEnum.RANCH,
                    ToppingEnum.JALAPENOS, ToppingEnum.LETTUCE), true),

    THE_SAM_I_AM("The Sam-I-Am", BreadType.HONEY_WHEAT,
            "Would you eat it in a house? Would you eat it with a mouse? You will.",
            List.of(ToppingEnum.HAM, ToppingEnum.TURKEY, ToppingEnum.SWISS,
                    ToppingEnum.LETTUCE, ToppingEnum.TOMATO, ToppingEnum.MAYO, ToppingEnum.AVOCADO), true),

    MATTS_DEBUGGER("Matt's Debugger", BreadType.WHITE_ITALIAN,
            "So loaded it crashes on first bite. No stack trace provided.",
            List.of(ToppingEnum.STEAK, ToppingEnum.BACON, ToppingEnum.PEPPERONI,
                    ToppingEnum.CHEDDAR, ToppingEnum.RANCH, ToppingEnum.JALAPENOS), false),

    THE_TUSHAR_404("The Tushar 404", BreadType.HONEY_WHEAT,
            "Sandwich not found. Just kidding, here it is. Fresh and clean.",
            List.of(ToppingEnum.CHICKEN, ToppingEnum.PROVOLONE, ToppingEnum.LETTUCE,
                    ToppingEnum.TOMATO, ToppingEnum.CUCUMBER, ToppingEnum.SWEET_ONION), false),
    JAYLN_DA_GOAT("Jayln Da Goat", BreadType.ARTISAN_ITALIAN,
            "The GOAT needs no explanation. A goated sandwich for a goated person who lets us play her nintendo.",
            List.of(ToppingEnum.STEAK, ToppingEnum.BACON, ToppingEnum.CHEDDAR,
                    ToppingEnum.LETTUCE, ToppingEnum.TOMATO, ToppingEnum.RANCH), false),
    SAYEDS_FIRE_HAZARD("Sayed's Fire Hazard", BreadType.FLATBREAD,
            "Not responsible for any injuries. Sign the waiver before ordering.",
            List.of(ToppingEnum.STEAK, ToppingEnum.JALAPENOS, ToppingEnum.BUFFALO,
                    ToppingEnum.PEPPER_JACK, ToppingEnum.BANANA_PEPPERS, ToppingEnum.ONION), true),

    THE_NULL_POINTER("The NullPointerException", BreadType.WHITE_ITALIAN,
            "Something went wrong in the kitchen. We dont know what dont ask us.",
            List.of(ToppingEnum.RANCH, ToppingEnum.MAYO), false),

    THE_STACK_OVERFLOW("The StackOverflow", BreadType.ARTISAN_ITALIAN,
            "Every topping we have. Yes, all of them. Do not attempt alone.",
            List.of(ToppingEnum.HAM, ToppingEnum.TURKEY, ToppingEnum.BACON,
                    ToppingEnum.STEAK, ToppingEnum.CHICKEN, ToppingEnum.PEPPERONI,
                    ToppingEnum.CHEDDAR, ToppingEnum.SWISS, ToppingEnum.PEPPER_JACK,
                    ToppingEnum.LETTUCE, ToppingEnum.TOMATO, ToppingEnum.ONION), false),

    MAYO_IS_LIFE("Mayo Is Life", BreadType.FLATBREAD,
            "Inspired by a certain papas game. We don't judge.",
            List.of(ToppingEnum.MAYO, ToppingEnum.MAYO, ToppingEnum.MAYO,
                    ToppingEnum.MAYO, ToppingEnum.MAYO, ToppingEnum.MAYO,
                    ToppingEnum.MAYO, ToppingEnum.MAYO, ToppingEnum.MAYO,
                    ToppingEnum.MAYO, ToppingEnum.MAYO, ToppingEnum.MAYO), false),

    SAHAR_SUPREME("Sahar's Supreme", BreadType.ARTISAN_ITALIAN,
                           "It's giving supreme. Stacked, dripped out, and delicious!",
                   List.of(ToppingEnum.BACON, ToppingEnum.STEAK, ToppingEnum.MOZZARELLA,
                   ToppingEnum.GUACAMOLE, ToppingEnum.ROASTED_PEPPERS, ToppingEnum.LETTUCE,
                   ToppingEnum.TOMATO, ToppingEnum.PICKLES, ToppingEnum.RANCH), false),

    JOFFRES_FOREHEAD("Joffre's Forehead", BreadType.FLATBREAD,
            "Legend has it no one has seen the full Joffre. This sandwich pays tribute.",
            List.of(ToppingEnum.ROASTED_PEPPERS, ToppingEnum.SUN_DRIED_TOMATOES,
                    ToppingEnum.AVOCADO, ToppingEnum.GUACAMOLE,
                    ToppingEnum.PROVOLONE, ToppingEnum.MOZZARELLA), false),
    JANICE_ESCOBAR("Janice Sandwich", BreadType.ARTISAN_ITALIAN, "Janice made this sandwich",
            List.of(ToppingEnum.STEAK, ToppingEnum.MAYO, ToppingEnum.AVOCADO), false);

    public final String displayName;
    public final BreadType bread;
    public final String description;
    public final List<ToppingEnum> toppings;
    public final boolean toasted;

    PresetSandwichEnum(String displayName, BreadType bread, String description, List<ToppingEnum> toppings, boolean toasted) {
        this.displayName = displayName;
        this.bread = bread;
        this.description = description;
        this.toppings = toppings;
        this.toasted = toasted;

    }

    public enum BreadType {
        ARTISAN_ITALIAN("Artisan Italian"),
        HONEY_WHEAT("Honey Wheat"),
        WHITE_ITALIAN("White Italian"),
        FLATBREAD("Flatbread");

        public final String displayName;

        BreadType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString(){
            return displayName;
        }
    }
}