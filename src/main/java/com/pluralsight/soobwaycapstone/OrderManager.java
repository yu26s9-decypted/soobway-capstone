package com.pluralsight.soobwaycapstone;

import com.pluralsight.soobwaycapstone.models.*;
import com.pluralsight.soobwaycapstone.models.enums.Size;
import com.pluralsight.soobwaycapstone.models.enums.ToppingEnum;
import com.pluralsight.soobwaycapstone.ui.Console;
import com.pluralsight.soobwaycapstone.ui.IOrderUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OrderManager {
    boolean isOrdering = true;
    private final IOrderUI ui;
    int orderNumber = (int) (Math.random() * 9000 + 1000);

    public OrderManager(IOrderUI ui){
        this.ui = ui;
    }

    public void processNewOrder() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        Order order = new Order(new ArrayList<>(), timestamp);

        while (isOrdering) {
            switch (ui.askOrderChoice()) {
                case 1 -> addSandwich(order);
                case 2 -> addDrink(order);
                case 3 -> addSide(order);
                case 4 -> checkout(order);
                case 0 -> {
                    order.getItem().clear();
                    System.out.println("The order was cancelled.");
                    isOrdering = false;
                }
            }
        }
    }

    private void addSandwich(Order order){
        Size size = ui.askSize();
        String breadType = ui.askBreadType();
        boolean toasted = ui.askToasted();
        List<Topping> toppings = ui.askToppings();


        /**
         * key is the topping type, value is the Topping object.
         * If a topping is added twice, the original will marked as extra.
         */
        Map<ToppingEnum, Topping> checkDup = new HashMap<>();

        for(Topping t : toppings){
           if(checkDup.containsKey(t.getTopping())){
               Topping exist = checkDup.get(t.getTopping());
               exist.setExtra(true);
               exist.addCount();

           } else {
               checkDup.put(t.getTopping(), t);
           }
        }
        order.addItem(new Sandwich(size, breadType, new ArrayList<>(checkDup.values()), toasted));
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

    /**
     * This displays the full order summary to the customer such as sandwich
     * toppings, and etc. Prints a closing message when complete.
     *
     * @param order the current order containing all items to display
     */
    private void checkout(Order order){
        if(order.getItem().isEmpty()) {
            System.out.println("You have no items so far. Please add a drink or side before checking out.");
            return;
        }

        System.out.printf("Order #%d", orderNumber);
        double totalPrice = displayOrderedItem(order);

        String confirm = Console.askForString("Would you like to checkout with the following? (y/n)");
        if (confirm.equalsIgnoreCase("y")) {
            System.out.println("\t Thank you for choosing SOOBWAY!");
            System.out.println(Reciept.saveReciept(order, totalPrice));
            isOrdering = false;

        } else {
            System.out.println("Returning to order menu.");
        }
    }

    public double displayOrderedItem(Order order) {
        double totalPrice = 0;

        for (Item i : order.getItem()) {
            if (i instanceof Sandwich s) {
                System.out.printf("\t Sandwich (%s) - Total Cost: $%.2f%n", s.getType(), s.calculatePrice());
                System.out.println("\t your added toppings:");
                totalPrice += s.calculatePrice();
                for (Topping t : s.getTopping()) {
                    String count = t.getCount() > 1 ? " (x" + t.getCount() + ")" : "";
                    String eLabel = t.isExtra() ? "EXTRA " + t.getTopping().displayName() : t.getTopping().displayName();
                    System.out.printf("\t+ %-20s $%.2f%n", eLabel + count, t.calculateCost(s.getSize()));

                }
            } else if (i instanceof Drink d) {
                System.out.printf("\t Drink - %-15s $%.2f%n", d.getDrinkName(), d.calculatePrice());
                totalPrice += d.calculatePrice();
            } else if (i instanceof Side side) {
                System.out.printf("\t Side  - %-15s $%.2f%n", side.getName(), side.calculatePrice());
                totalPrice += side.calculatePrice();
            }
        }

        return totalPrice;
    }




}

