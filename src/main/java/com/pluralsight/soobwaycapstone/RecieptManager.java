package com.pluralsight.soobwaycapstone;

import com.pluralsight.soobwaycapstone.models.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecieptManager {
    public static String saveReciept(Order order, double priceOfOrder) {
        LocalDateTime now = LocalDateTime.now();
        String displayDate = now.format(DateTimeFormatter.ofPattern("M/d/yy - hh:mma"));
        String fn = now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        File dir = new File("receipts");
        if (!dir.exists() && !dir.mkdir()) {
            return "Failed to create the receipts directory.";
        }

        File receiptFile = new File(dir, fn);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(receiptFile))) {
            bw.write(buildReceipt(order, priceOfOrder, displayDate));
            return String.format("Receipt saved: %s  (path: %s)%n", receiptFile.getName(), receiptFile.getPath());
        } catch (IOException e) {
            return "Failed to save receipt: " + e.getMessage();
        }
    }

    private static String buildReceipt(Order order, double total, String date) {
        StringBuilder sb = new StringBuilder();

        sb.append("=\n".repeat(50));
        sb.append("        SOOBWAY\n");
        sb.append("=\n".repeat(50));
        sb.append("  ").append(date).append("\n");
        sb.append("=\n".repeat(50));

        for (Item i : order.getItem()) {
            if (i instanceof Sandwich s) {
                sb.append(String.format("  Sandwich (%s)%n", s.getType()));
                for (Topping t : s.getTopping()) {
                    String count = t.getCount() > 1 ? " (x" + t.getCount() + ")" : "";
                    String eLabel = t.isExtra() ? "EXTRA " + t.getTopping().displayName() : t.getTopping().displayName();
                    sb.append(String.format("    + %-18s $%.2f%n", eLabel + count, t.calculateCost(s.getSize())));
                }
                sb.append(String.format("  %-20s $%.2f%n", "Sandwich Total", s.calculatePrice()));
            } else if (i instanceof Drink d) {
                sb.append(String.format("  Drink - %-14s $%.2f%n", d.getDrinkName(), d.calculatePrice()));
            } else if (i instanceof Side side) {
                sb.append(String.format("  Side  - %-14s $%.2f%n", side.getName(), side.calculatePrice()));
            }
        }

        sb.append("=\n".repeat(50));
        sb.append(String.format("  %-20s $%.2f%n", "ORDER TOTAL", total));
        sb.append("=\n".repeat(50));
        sb.append("  Thanks for choosing SOOBWAY!\n");
        sb.append("=\n".repeat(50));

        return sb.toString();
    }
}