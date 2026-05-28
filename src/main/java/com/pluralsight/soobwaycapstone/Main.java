package com.pluralsight.soobwaycapstone;


import com.pluralsight.soobwaycapstone.Database.Database;
import com.pluralsight.soobwaycapstone.ui.Console;

public class Main
{
    public static void main(String[] args)
    {
        boolean useGui = false;
        String option = Console.askForString("This Capstone features a GUI that is unfinished. Would you like to launch the GUI version? (y/n)");
        if(option.equalsIgnoreCase("y")){
             useGui = true;
        }

        if(useGui)
        {
            Launcher.main(args);
        }
        else
        {
            try {
                Database.testConnection();
                System.out.println(Database.getUser());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            UserInterface userInterface = new UserInterface();
            userInterface.display();
        }
    }
}