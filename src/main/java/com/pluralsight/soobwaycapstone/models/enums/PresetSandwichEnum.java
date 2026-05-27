package com.pluralsight.soobwaycapstone.models.enums;

import java.util.List;

public enum PresetSandwichEnum {
    ANDYS_SPECIAL("Andy's Special", "Artisan Italian",
            "The man, the myth, the sandwich. Spicy, stacked, and suspiciously good.",
            List.of(ToppingEnum.BACON, ToppingEnum.CHICKEN, ToppingEnum.RANCH,
                    ToppingEnum.JALAPENOS, ToppingEnum.LETTUCE)),

    THE_SAM_I_AM("The Sam-I-Am", "Honey Wheat",
            "Would you eat it in a house? Would you eat it with a mouse? You will.",
            List.of(ToppingEnum.HAM, ToppingEnum.TURKEY, ToppingEnum.SWISS,
                    ToppingEnum.LETTUCE, ToppingEnum.TOMATO, ToppingEnum.MAYO, ToppingEnum.AVOCADO)),

    MATTS_DEBUGGER("Matt's Debugger", "White Italian",
            "So loaded it crashes on first bite. No stack trace provided.",
            List.of(ToppingEnum.STEAK, ToppingEnum.BACON, ToppingEnum.PEPPERONI,
                    ToppingEnum.CHEDDAR, ToppingEnum.RANCH, ToppingEnum.JALAPENOS)),

    THE_TUSHAR_404("The Tushar 404", "Flatbread",
            "Sandwich not found. Just kidding, here it is. Fresh and clean.",
            List.of(ToppingEnum.CHICKEN, ToppingEnum.PROVOLONE, ToppingEnum.LETTUCE,
                    ToppingEnum.TOMATO, ToppingEnum.CUCUMBER, ToppingEnum.SWEET_ONION)),
    JAYLN_DA_GOAT("Jayln Da Goat", "Artisan Italian",
            "The GOAT needs no explanation. A goated sandwich for a goated person who lets us play her nintendo.",
            List.of(ToppingEnum.STEAK, ToppingEnum.BACON, ToppingEnum.CHEDDAR,
                    ToppingEnum.LETTUCE, ToppingEnum.TOMATO, ToppingEnum.RANCH)),
    SAYEDS_FIRE_HAZARD("Sayed's Fire Hazard", "Flatbread",
            "Not responsible for any injuries. Sign the waiver before ordering.",
            List.of(ToppingEnum.STEAK, ToppingEnum.JALAPENOS, ToppingEnum.BUFFALO,
                    ToppingEnum.PEPPER_JACK, ToppingEnum.BANANA_PEPPERS, ToppingEnum.ONION)),

    THE_NULL_POINTER("The NullPointerException", "White Italian",
            "Something went wrong in the kitchen. We dont know what dont ask us.",
            List.of(ToppingEnum.RANCH, ToppingEnum.MAYO)),

    THE_STACK_OVERFLOW("The StackOverflow", "Artisan Italian",
            "Every topping we have. Yes, all of them. Do not attempt alone.",
            List.of(ToppingEnum.HAM, ToppingEnum.TURKEY, ToppingEnum.BACON,
                    ToppingEnum.STEAK, ToppingEnum.CHICKEN, ToppingEnum.PEPPERONI,
                    ToppingEnum.CHEDDAR, ToppingEnum.SWISS, ToppingEnum.PEPPER_JACK,
                    ToppingEnum.LETTUCE, ToppingEnum.TOMATO, ToppingEnum.ONION)),

    MAYO_IS_LIFE("Mayo Is Life", "White Italian",
            "Inspired by a certain papas game. We don't judge.",
            List.of(ToppingEnum.MAYO, ToppingEnum.MAYO, ToppingEnum.MAYO,
                    ToppingEnum.MAYO, ToppingEnum.MAYO, ToppingEnum.MAYO,
                    ToppingEnum.MAYO, ToppingEnum.MAYO, ToppingEnum.MAYO,
                    ToppingEnum.MAYO, ToppingEnum.MAYO, ToppingEnum.MAYO)),

    SAHAR_SUPREME("Sahar's Supreme", "Artisan Italian",
                           "It's giving supreme. Stacked, dripped out, and delicious!",
                   List.of(ToppingEnum.BACON, ToppingEnum.STEAK, ToppingEnum.MOZZARELLA,
                   ToppingEnum.GUACAMOLE, ToppingEnum.ROASTED_PEPPERS, ToppingEnum.LETTUCE,
                   ToppingEnum.TOMATO, ToppingEnum.PICKLES, ToppingEnum.RANCH));

    public final String displayName;
    public final String bread;
    public final String description;
    public final List<ToppingEnum> toppings;

    PresetSandwichEnum(String displayName, String bread, String description, List<ToppingEnum> toppings) {
        this.displayName = displayName;
        this.bread = bread;
        this.description = description;
        this.toppings = toppings;
    }
}