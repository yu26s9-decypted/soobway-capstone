package com.pluralsight.soobwaycapstone;

import com.pluralsight.soobwaycapstone.models.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reciept {
    public static String saveReciept(Order order, double priceOfOrder){
        LocalDateTime now = LocalDateTime.now();
        String displayDate = now.format(DateTimeFormatter.ofPattern("M/d/yy - hh:mma"));
        String fn = now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        File file = new File("reciepts");
        if(!file.exists()) {
            boolean isFileCreated = file.mkdir();
            if (!isFileCreated) {
                return "Failed to create the reciepts dir";
            }
        }

        File newRecieptFile = new File(file, fn);

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Subway Order Reciept ");
            sb.append(String.format("Order Date: %s", displayDate));

            for (Item i : order.getItem()) {
                if (i instanceof Sandwich s){
                    sb.append(String.format("Sandwich (%s) - $%,.2f%n", s.getType(), s.calculatePrice()));
                    for(Topping t: s.getTopping()){
                        sb.append(String.format("+ %s - $%,.2f%n", t.getTopping().displayName(), t.calculateCost(s.getSize())));
                    }
                } else if ( i instanceof Drink d){
                    sb.append(String.format("Drink (%s) - $%,.2f%n", d.getDrinkName(), d.calculatePrice()));
                } else if (i instanceof Side side){
                    sb.append(String.format("Side (%s) - $%,.2f%n", side.getName(), side.calculatePrice()));
                }
            }

            sb.repeat("-", 35);
            sb.append("%n");
            sb.append(String.format("Total: $%,.2f%n", priceOfOrder));

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newRecieptFile));
            bufferedWriter.write(sb.toString());
            bufferedWriter.close();
            return String.format("Receipt was saved: %s. Path: %s%n", newRecieptFile.getName(), newRecieptFile.getPath());
        } catch (IOException e) {
            return "Failed to save the receipt in Receipt Class%n" + e.getMessage();
        }
    }
}
