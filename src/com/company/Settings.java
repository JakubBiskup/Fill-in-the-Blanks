package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Settings {
    boolean isPrepped;
    boolean isGoingLineByLine;
    boolean isRenewingLives;
    int livesAtStart;
    public static void changeSettings() throws Exception{
        Scanner changeScanner=new Scanner(System.in);
        System.out.println("Type in 1 if you have your file prepared, type in 0 if you want to generate blanks randomly");
        String stringWithSettings="";
        String inputQ1=changeScanner.next();
        if (inputQ1.equals("1")){
            stringWithSettings="1 ";
        }
        if (inputQ1.equals("0")){
            stringWithSettings="0 ";
        }
        if (!inputQ1.equals("0")&&!inputQ1.equals("1")){
            System.out.println("Wrong input! Only type in 1 or 0 next time!");
            System.exit(0);
        }
        System.out.println("Type in 1 if you want to go one line at a time, type in 0 if you want to see the whole text every time");
        System.out.println("Note that going one line at a time with a prepared text is a bad idea if there is no new blank every line");
        String inputQ2=changeScanner.next();
        if (inputQ2.equals("1")){
            stringWithSettings+="1 ";
        }
        if (inputQ2.equals("0")){
            stringWithSettings+="0 ";
        }
        if (!inputQ2.equals("0")&&!inputQ2.equals("1")){
            System.out.println("Wrong input! Only type in 1 or 0 next time!");
            System.exit(0);
        }
        System.out.println("Type in 1 to renew lives after a correct guess, type in 0 if you don't want to renew lives");
        String inputQ3=changeScanner.next();
        if (inputQ3.equals("1")){
            stringWithSettings+="1 ";
        }
        if (inputQ3.equals("0")){
            stringWithSettings+="0 ";
        }
        if (!inputQ3.equals("0")&&!inputQ3.equals("1")){
            System.out.println("Wrong input! Only type in 1 or 0 next time!");
            System.exit(0);
        }
        System.out.println("Type in how many guesses you want to get at start (positive integer value)");
        try{
            int inputQ4=changeScanner.nextInt();
            //accepts negative values (user will loose before seeing the blanks)
            stringWithSettings+=Integer.toString(inputQ4);
        }catch (Exception e){
            System.out.println("Wrong input! Type in an integer next time!");
            System.exit(0);
        }
        FileWriter fw = new FileWriter("settings.txt");
        PrintWriter pw = new PrintWriter(fw);

        pw.println(stringWithSettings);
        pw.close();
    }
    public void display(){
        System.out.println("Current settings are:");
        if(this.isPrepped){
            System.out.println("-Prepared files");
        }else {
            System.out.println("-Random blanks (one per line)");
        }
        if(this.isGoingLineByLine){
            System.out.println("-Displaying single line");
        }else {
            System.out.println("-Displaying whole text");
        }
        System.out.println("-Guesses at start: "+this.livesAtStart);
        if(this.isRenewingLives){
            System.out.println("-Restoring guesses after correct guess");
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
