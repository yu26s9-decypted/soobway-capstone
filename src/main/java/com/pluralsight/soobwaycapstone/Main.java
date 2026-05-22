package com.pluralsight.soobwaycapstone;


public class Main
{
    public static void main(String[] args)
    {
        boolean useGui = false;

        if(useGui)
        {
            Launcher.main(args);
        }
        else
        {
            UserInterface userInterface = new UserInterface();
            userInterface.display();
        }
    }
}