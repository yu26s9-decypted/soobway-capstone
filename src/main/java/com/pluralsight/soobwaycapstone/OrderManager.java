package com.pluralsight.soobwaycapstone;

import com.pluralsight.soobwaycapstone.models.Order;
import com.pluralsight.soobwaycapstone.ui.Console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderManager {
    public void processNewOrder(){

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        Order order = new Order(new ArrayList<>(), timestamp);
        boolean isOrdering = true;
        while (isOrdering){
            String menu = """
                    \t 1) Add Sandwich
                    \t 2) Add Drink
                    \t 3) Add Side
                    \t 4) Checkout
                    \t 0) Cancel
                     >""";

            int userOption = Console.askForInt(menu, 1,4);
            switch (userOption){

            }
        }
}
