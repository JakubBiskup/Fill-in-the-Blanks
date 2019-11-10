package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner inScan=new Scanner(System.in);
        Settings lastSettings=new Settings();
        lastSettings.display();
        System.out.println("Do you want to change settings? (Type in Y or N)");
        String input=inScan.next();
        while (!input.equalsIgnoreCase("N")){
            if (input.equalsIgnoreCase("y")){
                Settings.changeSettings();
            }else{
                System.out.println("The program only accepts Y or N answer");
            }
            lastSettings=new Settings();
            lastSettings.display();
            System.out.println("Do you want to change settings? (Type in Y or N)");
            input=inScan.next();
        }
        Settings settings= new Settings();
        Game game=new Game(settings);
    }
}