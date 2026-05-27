package com.pluralsight.soobwaycapstone;

import com.pluralsight.soobwaycapstone.models.*;
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
                case 2 -> addDrink(order);
                case 3 -> addSide(order);
                case 4 -> checkout(order);
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
        System.out.println("Drink was added");
    }

    private void addSide(Order order){
        order.addItem(ui.askSide());
        System.out.println("Side was added");
    }


//    checkout


    /**
     * This displays the full order summary to the customer such as sandwich
     * toppings, and etc. Prints a closing message when complete.
     *
     * @param order the current order containing all items to display
     */
    private void checkout(Order order){
        double totalPrice = 0;
        for (Item i : order.getItem()) {
            if (i instanceof Sandwich s) {
                System.out.printf("\t Sandwich (%s) - Total Cost: $%.2f%n", s.getType(), s.calculatePrice());
                System.out.println("your added toppings:");
                totalPrice += s.calculatePrice();
                for (Topping t : s.getTopping()) {
                    System.out.printf("\t   + %-20s $%.2f%n", t.getTopping().displayName(), t.calculateCost(s.getSize()));
                    totalPrice += s.calculatePrice();
                }
            } else if (i instanceof Drink d) {
                System.out.printf("\t Drink - %-15s $%.2f%n", d.getDrinkName(), d.calculatePrice());
                totalPrice += d.calculatePrice();
            } else if (i instanceof Side side) {
                System.out.printf("\t Side  - %-15s $%.2f%n", side.getName(), side.calculatePrice());
                totalPrice += side.calculatePrice();
            }


        }

        System.out.println("\t ---------------------------");
        System.out.println("\t  Thank you for choosing SOOBWAY!");
        Reciept.saveReciept(order, totalPrice);
    }
}

