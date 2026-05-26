package com.pluralsight.soobwaycapstone;

import com.pluralsight.soobwaycapstone.models.Drink;
import com.pluralsight.soobwaycapstone.models.Order;
import com.pluralsight.soobwaycapstone.models.Sandwich;
import com.pluralsight.soobwaycapstone.ui.IOrderUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class OrderManager {
    private IOrderUI ui;

    public OrderManager(IOrderUI ui){
        this.ui = ui;
    }

    public void processNewOrder() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        Order order = new Order(new ArrayList<>(), timestamp);
        boolean isOrdering = true;

        while (isOrdering) {
            switch (ui.askOrderChoice()) {
                case 1 -> addSandwich(order);
                case 2 -> addDrink
                case 3 -> {break;}
                case 4 -> {break;}
                case 0 -> {break;}
            }
        }
    }

    private void addSandwich(Order order){
        order.addItem(new Sandwich(ui.askSize(), ui.askBreadType(), ui.askToppings(), ui.askToasted()));
        System.out.println("Order was added.");
    }

    private void addDrink(Order order){
        order.addItem(new Drink(ui.askDrinkSize(), ui.askDrinkName()));
    }
}

