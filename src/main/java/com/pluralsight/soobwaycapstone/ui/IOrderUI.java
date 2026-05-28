package com.pluralsight.soobwaycapstone.ui;

import com.pluralsight.soobwaycapstone.models.Sandwich;
import com.pluralsight.soobwaycapstone.models.Side;
import com.pluralsight.soobwaycapstone.models.Topping;
import com.pluralsight.soobwaycapstone.models.enums.PresetSandwichEnum;
import com.pluralsight.soobwaycapstone.models.enums.Size;


import java.util.List;

public interface IOrderUI {
    Size askSize();
    int askOrderChoice();
    String askBreadType();
    List<Topping> askToppings();
    boolean askToasted();
    String askDrinkName();
    Size askDrinkSize();
    Side askSide();
    boolean askIsPreset();
    PresetSandwichEnum askPreset();
    int askSandwichToEdit(List<Sandwich> sandwiches);
    int askSandwichToEditChoices();
    int askEditToppingChoices();
}