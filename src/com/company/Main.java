package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        Settings lastSettings=new Settings();
        lastSettings.display();
        Settings settings= new Settings();
        Game game=new Game(settings);
    }
}