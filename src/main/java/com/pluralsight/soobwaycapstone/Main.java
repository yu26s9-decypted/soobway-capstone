package com.pluralsight.soobwaycapstone;


import com.pluralsight.soobwaycapstone.Database.Database;
import com.pluralsight.soobwaycapstone.ui.Console;

public class Main
{
    public static void main(String[] args)
    {
        boolean useGui = false;
        boolean selected = false;
        while (!selected) {
            String option = Console.askForString("This Capstone features a GUI that is unfinished due to CORPORATE BUDGET CUTS ):. Would you like to launch the GUI version? (y/n)");
            if (option.equalsIgnoreCase("y")) {
                useGui = true;
            }

            if (useGui) {
                Launcher.main(args);
                selected = true;
            } else if (option.equalsIgnoreCase("n")) {
                UserInterface userInterface = new UserInterface();
                userInterface.display();
                selected = true;
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}