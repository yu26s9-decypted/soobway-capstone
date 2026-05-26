package com.pluralsight.soobwaycapstone.models;

import java.util.List;

public class Order {
    List<Item> item;
    String orderDateTime;

    public Order(List<Item> item, String orderDateTime) {
        this.item = item;
        this.orderDateTime = orderDateTime;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public void addItem(Item item){
        this.item.add(item);
    }
}
