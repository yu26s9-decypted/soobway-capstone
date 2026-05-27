package com.pluralsight.soobwaycapstone;

import com.pluralsight.soobwaycapstone.models.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecieptManager {
    public static String saveReciept(Order order, double total, double subtotal, int orderNumber, Discount discount, User user) {
        LocalDateTime now = LocalDateTime.now();
        String displayDate = now.format(DateTimeFormatter.ofPattern("M/d/yy - hh:mma"));
        String fn = now.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        File dir = new File("receipts");
        if (!dir.exists() && !dir.mkdir()) {
            return "Failed to create the receipts directory.";
        }

        File receiptFile = new File(dir, fn);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(receiptFile))) {
            bw.write(buildReceipt(order, total, subtotal, displayDate, orderNumber, discount, user));
            return String.format("Receipt saved: %s  (path: %s)%n", receiptFile.getName(), receiptFile.getPath());
        } catch (IOException e) {
            return "Failed to save receipt: " + e.getMessage();
        }
    }

    public static String buildReceipt(Order order, double total, double subtotal, String date, int orderNumber, Discount discount, User user) {
        StringBuilder sb = new StringBuilder();

        sb.append("=".repeat(50)).append("\n");
        sb.append("                S O O B W A Y\n");
        sb.append("=".repeat(50)).append("\n");
        sb.append(String.format("  Order #%d%n", orderNumber));
        sb.append("=".repeat(50)).append("\n");
        sb.append("  ").append(date).append("\n");
        sb.append("=".repeat(50)).append("\n\n");

        for (Item i : order.getItem()) {
            if (i instanceof Sandwich s) {
                sb.append(String.format("  Sandwich%n"));
                sb.append(String.format("    + (%s)%-28s $%.2f%n", s.getSandwichSize(), s.getType(), s.getBaseCost()));
                for (Topping t : s.getTopping()) {
                    String eLabel = t.isExtra()
                            ? t.getTopping().displayName() + " + extra (x" + (t.getCount() - 1) + ")"
                            : t.getTopping().displayName();
                    sb.append(String.format("    + %-28s $%.2f%n", eLabel, t.calculateCost(s.getSize())));
                }
                sb.append(String.format("  %-30s $%.2f%n", "Total -", s.calculatePrice()));
            } else if (i instanceof Drink d) {
                sb.append(String.format("  %-30s $%.2f%n", "Drink - " + d.getDrinkName(), d.calculatePrice()));
            } else if (i instanceof Side side) {
                sb.append(String.format("  %-30s $%.2f%n", "Side  - " + side.getName(), side.calculatePrice()));
            }
            sb.append("\n");
        }
        if (discount != null && discount.getPercentage() > 0) {
            double originalCost = total / (1 - discount.getPercentage());
            sb.append(String.format("  %-30s $%.2f%n", "Total", originalCost));
            sb.append("  ").append("-".repeat(40)).append("\n");

            if (user != null) {
                sb.append(String.format("  Member: %-22s %s%n", user.getUsername(), user.getEmail()));
                sb.append(String.format("  Tier:   %-22s%n", user.getMembershipTier()));
            }
            sb.append(String.format("  %-30s -%.0f%% (-$%.2f)%n",
                    discount.getType(),
                    discount.getPercentage() * 100,
                    originalCost - total));
        }

        sb.append("=".repeat(50)).append("\n");
        sb.append(String.format("  %-30s $%.2f%n", "ORDER TOTAL", total));
        sb.append("=".repeat(50)).append("\n");
        sb.append("    Thanks for choosing SOOBWAY!\n");
        sb.append("=".repeat(50)).append("\n");

        return sb.toString();
    }
}