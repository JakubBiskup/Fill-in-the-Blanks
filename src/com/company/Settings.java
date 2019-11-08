package com.company;

import java.io.File;
import java.util.Scanner;

public class Settings {
    boolean isPrepped;
    boolean isGoingLineByLine;
    boolean isRenewingLives;
    int livesAtStart;
    public void display(){
        System.out.println("Current settings are:");
        if(this.isPrepped){
            System.out.println("-Prepared files");
        }else {
            System.out.println("-Random blanks");
        }
        if(this.isGoingLineByLine){
            System.out.println("-Displaying single line");
        }else {
            System.out.println("-Displaying whole text");
        }
        System.out.println("-Guesses at start: "+this.livesAtStart);
        if(this.isRenewingLives){
            System.out.println("-Restoring available guesses after correct guess");
        }else {
            System.out.println("-Guesses are never restored");
        }
    }
    Settings() throws Exception{
        File settingsFile=new File("settings.txt");
        Scanner scanner= new Scanner(settingsFile);
        isPrepped=(scanner.next().equals("1"));
        isGoingLineByLine=(scanner.next().equals("1"));
        isRenewingLives=(scanner.next().equals("1"));
        livesAtStart=scanner.nextInt();
    }

}
