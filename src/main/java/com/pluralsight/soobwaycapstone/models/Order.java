package com.pluralsight.soobwaycapstone.models;

import java.util.List;

public class Order {
    List<Item> item;
    List<Drink> drink;
    List<Side> side;
    String orderDateTime;

    public Order(List<Item> item, List<Drink> drink, List<Side> side, String orderDateTime) {
        this.item = item;
        this.drink = drink;
        this.side = side;
        this.orderDateTime = orderDateTime;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public List<Drink> getDrink() {
        return drink;
    }

    public void setDrink(List<Drink> drink) {
        this.drink = drink;
    }

    public List<Side> getSide() {
        return side;
    }

    public void setSide(List<Side> side) {
        this.side = side;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }
}
