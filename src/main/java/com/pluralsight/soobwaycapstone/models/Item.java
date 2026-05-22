package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;

import java.util.List;

public class Item {
    Size size;
    String type;
    List<Topping> topping;
    boolean specialOption;
}
