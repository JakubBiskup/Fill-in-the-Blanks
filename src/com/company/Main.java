package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Settings settings= new Settings();
        Scanner inScan = new Scanner(System.in);
        System.out.println("Please choose a file by typing in its name");
        Text chosenText = new Text(inScan.nextLine()+".txt",settings);
        for (String line : chosenText.textInListOfLines
        )
            System.out.println(line);
        System.out.println(settings.livesAtStart);
        System.out.println(chosenText.answers);
        for (String line : chosenText.textInLinesWithBlanks
        )
            System.out.println(line);
        for (String ans:
             chosenText.answers) {

            System.out.println(ans);
        }
    }
}