package com.pluralsight.soobwaycapstone;

import com.pluralsight.soobwaycapstone.Database.Database;
import com.pluralsight.soobwaycapstone.models.*;
import com.pluralsight.soobwaycapstone.models.enums.PresetSandwichEnum;
import com.pluralsight.soobwaycapstone.models.enums.Size;
import com.pluralsight.soobwaycapstone.models.enums.ToppingEnum;
import com.pluralsight.soobwaycapstone.ui.Console;
import com.pluralsight.soobwaycapstone.ui.IOrderUI;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
        isOrdering = true;
        while (isOrdering) {
            switch (ui.askOrderChoice()) {
                case 1 -> addSandwich(order);
                case 2 -> addDrink(order);
                case 3 -> addSide(order);
                case 4 -> checkout(order);
                case 5 -> editSandwich(order);
                case 0 -> {
                    order.getItem().clear();
                    System.out.println("The order was cancelled.");
                    isOrdering = false;
                }
            }
        }
    }

    private void addSandwich(Order order){
        Size size =  ui.askSize();
        boolean toasted = false;
        boolean selectedPreset = ui.askIsPreset();
        String breadType;
        List<Topping> toppings;

        if(selectedPreset){
            PresetSandwichEnum presetSandwichEnum = ui.askPreset();
            breadType = presetSandwichEnum.displayName + " | " + presetSandwichEnum.bread;
            toppings = presetSandwichEnum.toppings.stream().map(Topping::new).collect(Collectors.toList());
        } else {
            breadType = ui.askBreadType();
            toasted = ui.askToasted();
            toppings = ui.askToppings();
        }


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

        order.addItem(new Sandwich(size, breadType, new ArrayList<>(checkDup.values()), false, toasted ));
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
        User user = null;
        double totalPrice;
        Discount discount = Discount.none();

        if(order.getItem().isEmpty()) {
            System.out.println("You have no items so far. Please add a drink or side before checking out.");
            return;
        }

        String promptForEmail = Console.askForString("Would you like to enter your email for member discounts (or press Enter to skip)");

        if(!promptForEmail.isBlank()){
            if(!User.checkIfValidEmail(promptForEmail)) {
                System.out.println("REGEX validation for email failed.");
                return;
            }
            try {
                user = Database.getUserByEmail(promptForEmail);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }


            if (user != null) {
                discount = Discount.forUser(user);
                System.out.printf("Welcome back %s! Your %.0f%% discount has been applied.%n",
                        user.getUsername(), discount.getPercentage() * 100);
            } else {
                user = User.promptForSignUp(promptForEmail);
                if (user != null) {
                    discount = Discount.forUser(user);
                } else {
                    System.out.println("Email was not found in the database. No discount was applied.");
                }
            }
        }
         double subtotal = order.getItem().stream()
                .mapToDouble(Item::calculatePrice)
                .sum();

         totalPrice = discount.applyDiscount(subtotal);


        System.out.println(RecieptManager.buildReceipt(order, totalPrice,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("M/d/yy - hh:mma")), orderNumber, discount, user));


        String confirm = Console.askForString("Would you like to checkout with the following? (y/n)");
        if (confirm.equalsIgnoreCase("y")) {
            System.out.println("\t Thank you for choosing SOOBWAY!");
            System.out.println(RecieptManager.saveReciept(order, totalPrice, orderNumber, discount, user));
            isOrdering = false;

        } else {
            System.out.println("Returning to order menu.");
        }
    }

    public static void addPresetSandwich(Order order, PresetSandwichEnum preset, Size size) {
        String breadType = preset.displayName + " | " + preset.bread;
        List<Topping> toppings = preset.toppings.stream()
                .map(Topping::new)
                .toList();

        Map<ToppingEnum, Topping> checkDup = new HashMap<>();
        for (Topping t : toppings) {
            if (checkDup.containsKey(t.getTopping())) {
                Topping exist = checkDup.get(t.getTopping());
                exist.setExtra(true);
                exist.addCount();
            } else {
                checkDup.put(t.getTopping(), t);
            }
        }

        order.addItem(new Sandwich(size, breadType, new ArrayList<>(checkDup.values()), false, preset.toasted));
    }

    public void editSandwich(Order order){
        List<Sandwich> sandwiches = order.getItem().stream()
                .filter(item -> item instanceof Sandwich)
                .map(item -> (Sandwich) item)
                .toList();

        int choice = ui.askSandwichToEdit(sandwiches);
        if(choice == 0){
            System.out.println("Exiting.");
            return;
        }
        Sandwich selected = sandwiches.get((choice) - 1);

        System.out.println(selected);
        boolean isModifyingSandwich = true;
        while (isModifyingSandwich){
        switch (ui.askSandwichToEditChoices()){
            case 1 -> {
                Size updatedSize =ui.askSize();
                selected.setSize(updatedSize);
                System.out.println("%s size has been switched to " + updatedSize);
            }
            case 2 -> {
                String breadType = ui.askBreadType();
                selected.setType(breadType);
                System.out.println("%s size has been switched to " + breadType);
            }
            case 3 -> {
                int count = 0;
                for (Topping t : selected.getTopping()){
                    System.out.printf("%d), %s", count, t);
                    count++;
               }

            boolean isEditingToppingChoice = true;

            while (isEditingToppingChoice){
                    switch (ui.askEditToppingChoices()) {
                        case 1 -> {
                            List<Topping> addNewTopping = ui.askToppings();
                            for (Topping t : addNewTopping) {
                                selected.addToTopping(t);
                            }
                        }

                        case 2 -> {
                            int promptForChoice = Console.askForInt("Which topping would you like to remove?", 0, selected.getTopping().size() - 1);
                            Topping t = selected.getTopping().get(promptForChoice);

                            if (t.isExtra()) {
                                int promptChoice2 = Console.askForInt("Would you like to remove all, one? (1 for all, 2 for one)", 1, 3);
                                if (promptChoice2 == 1) {
                                    selected.getTopping().remove(promptForChoice);
                                } else if (promptChoice2 == 2) {
                                    selected.removeTopping(promptForChoice);
                                }

                            } else {
                                selected.getTopping().remove(promptForChoice);
                            }
                        }

                        case 3 -> isEditingToppingChoice = false;
                    }
                }
            }
            case 4 -> {
                boolean toast = ui.askToasted();
                selected.setToasted(toast);


            }
            case 5 -> isModifyingSandwich = false;
        }
    }



    }
}


