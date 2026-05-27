package com.pluralsight.soobwaycapstone.ui;

import com.pluralsight.soobwaycapstone.models.Side;
import com.pluralsight.soobwaycapstone.models.Topping;
import com.pluralsight.soobwaycapstone.models.enums.SideEnum;
import com.pluralsight.soobwaycapstone.models.enums.Size;
import com.pluralsight.soobwaycapstone.models.enums.ToppingEnum;

import java.util.ArrayList;
import java.util.List;

public class ConsoleOrderUI implements IOrderUI{
    public int askOrderChoice() {
        String prompt = """
            \t 1) Add Sandwich
            \t 2) Add Drink
            \t 3) Add Side
            \t 4) Checkout
            \t 0) Cancel
             > """;
        return Console.askForInt(prompt, 0, 4);
    }

    @Override
    public Size askSize() {
        String prompt = """
            \t Choose a size: Leave empty for medium.
            \t 1) Small  - $3.50
            \t 2) Medium - $6.50
            \t 3) Large  - $9.50
            >""";
        return switch (Console.askForInt(prompt, 1, 3)) {
            case 1 -> Size.SMALL;
            case 2 -> Size.MEDIUM;
            case 3 -> Size.LARGE;
            default -> Size.MEDIUM;
        };
    };

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
        List<Topping> toppings = new ArrayList<>();
        ToppingEnum[] listOfToppings = ToppingEnum.values();

        boolean addingTopping = true;
        for(int i = 0; i < listOfToppings.length; i++){
            System.out.printf("%2d) %s%n", i + 1, listOfToppings[i].displayName());
        }

        while (addingTopping){
            int userChoice = Console.askForInt("Enter your choice: (Enter 0 to finish customizing your sandwich)", 0, listOfToppings.length);


            if(userChoice == 0){
                addingTopping = false;
            } else {
                toppings.add(new Topping(listOfToppings[userChoice - 1]));

            }


        }
        return toppings;
    }

    @Override
    public boolean askToasted() {
        String choice = Console.askForString("Would you like it toasted? (y or empty for no)");
        return choice.equalsIgnoreCase("y");
    }

    @Override
    public String askDrinkName() {
        String prompt = """
            \t What drink would you like?
            \t 1) Water
            \t 2) Lemonade
            \t 3) Soda
            \t 4) Sprite
            \t 5) Lemon Ice Tea
             >""";
        return switch (Console.askForInt(prompt, 1, 5)) {
            case 1 -> "Water";
            case 2 -> "Lemonade";
            case 3 -> "Soda";
            case 4 -> "Sprite";
            case 5 -> "Lemon Ice Tea";
            default -> null;
        };
    }

    @Override
    public Size askDrinkSize() {
        String prompt = """
            \t What drink size would you like:
            \t 1) Small  - $1.50
            \t 2) Medium - $2.00
            \t 3) Large  - $2.50
             > """;
        return switch (Console.askForInt(prompt, 1, 3)) {
            case 1 -> Size.SMALL;
            case 2 -> Size.MEDIUM;
            default -> Size.LARGE;
        };
    }

    @Override
    public Side askSide() {
        SideEnum[] sides = SideEnum.values();

        for (int i = 0; i < sides.length; i++) {
            System.out.printf("\t %d) %-20s $%.2f%n", i + 1, sides[i].displayName(), sides[i].getPrice());
        }

        int choice = Console.askForInt("Enter your choice", 1, sides.length);
        SideEnum selected = sides[choice - 1];
        return new Side(selected.displayName(), selected.getPrice());
    }
}
