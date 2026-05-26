package com.pluralsight.soobwaycapstone.models;

import com.pluralsight.soobwaycapstone.models.enums.Size;

import java.util.List;

public abstract class Item {
    Size size;
    String type;
    boolean specialOption;

    public Item(Size size, String type, boolean specialOption) {
        this.size = size;
        this.type = type;
        this.specialOption = specialOption;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public boolean isSpecialOption() {
        return specialOption;
    }

    public void setSpecialOption(boolean specialOption) {
        this.specialOption = specialOption;
    }

    public abstract double calculatePrice();

}
