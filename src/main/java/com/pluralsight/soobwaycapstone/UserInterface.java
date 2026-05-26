package com.pluralsight.soobwaycapstone;
import com.pluralsight.soobwaycapstone.ui.Console;
import com.pluralsight.soobwaycapstone.ui.ConsoleOrderUI;

public class UserInterface {
    private final OrderManager orderManager = new OrderManager(new ConsoleOrderUI());
    public void display(){
        boolean running = true;
        while (running){
            String m = """
                   \t Welcome to SOOBWAY!
                   \t Fresh. Fast. Custom.®
                   
                   \t What would you like to do?
                   \t 1) New Order
                   \t 2) Exit
                   
                    Awaiting user input: >""";

            int userInput = Console.askForInt(m, 1, 2);

            if (userInput == 1) {
                orderManager.processNewOrder();
            } else {
                System.out.println("Thank you!");
                break;
            }
        }
    }

    public void processNewOrder(){
        System.out.println("What would you like to order?");
    }
}
