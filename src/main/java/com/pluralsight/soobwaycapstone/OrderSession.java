package com.pluralsight.soobwaycapstone;

import com.pluralsight.soobwaycapstone.models.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderSession {
    private static Order currentOrder = new Order(new ArrayList<>(),
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")));

    public static Order getOrder() { return currentOrder; }

    public static void resetOrder(){
        currentOrder = new Order(new ArrayList<>(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")));
    }
}
