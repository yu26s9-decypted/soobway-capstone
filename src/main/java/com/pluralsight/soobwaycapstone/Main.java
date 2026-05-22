package com.pluralsight.soobwaycapstone;


public class Main
{
    public static void main(String[] args)
    {
        boolean useGui = true;

        if(useGui)
        {
            Launcher.main(args);
        }
        else
        {
            System.out.println("Test");
        }
    }
}