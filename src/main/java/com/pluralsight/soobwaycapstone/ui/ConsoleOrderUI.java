package com.pluralsight.soobwaycapstone.ui;

import com.pluralsight.soobwaycapstone.models.Side;
import com.pluralsight.soobwaycapstone.models.Topping;
import com.pluralsight.soobwaycapstone.models.enums.Size;

import java.util.List;

public class ConsoleOrderUI implements IOrderUI{
    @Override
    public Size askSize() {
        return null;
    }

    public int askOrderChoice() {
        String prompt = """
            \t 1) Add Sandwich
            \t 2) Add Drink
            \t 3) Add Side
            \t 4) Checkout
            \t 0) Cancel
             > """;
        return Console.askForInt(prompt, 1, 4);
    }

    @Override
    public String askBreadType() {
        String prompt = """
                \t What type of bread would you like?
                \t 1) White
                \t 2) Wheat
                \t 3) Flatbread
                \t 4) Artisan Italian
                \t Leave empty for Artisan Italian
                """;
        return switch (Console.askForInt(prompt, 1, 6)) {
            case 1 -> "Selected White";
            case 2 -> "Selected Wheat";
            case 3 -> "Selected Flatbread";
            case 4 -> "Selected Artisan Italian";
            default -> "Selected Artisan Italian";
        };

    }

    @Override
    public List<Topping> askToppings() {
        return List.of();
    }

    @Override
    public boolean askToasted() {
        return false;
    }

    @Override
    public String askDrinkName() {
        return "";
    }

    @Override
    public Size askDrinkSize() {
        return null;
    }

    @Override
    public Side askSide() {
        return null;
    }
}
