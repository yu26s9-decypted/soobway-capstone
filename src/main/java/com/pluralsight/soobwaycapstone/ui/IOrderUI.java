package com.pluralsight.soobwaycapstone.ui;

import com.pluralsight.soobwaycapstone.models.Side;
import com.pluralsight.soobwaycapstone.models.Topping;
import com.pluralsight.soobwaycapstone.models.enums.Size;


import java.util.List;

public interface IOrderUI {
    int askOrderChoice();
    Size askSize();
    String askBreadType();
    List<Topping> askToppings();
    boolean askToasted();
    String askDrinkName();
    Size askDrinkSize();
    Side askSide();
}