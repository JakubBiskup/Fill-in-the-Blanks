package com.company;

import java.util.List;
import java.util.Scanner;

public class Game {
    int startingLives;
    Text text;
    List<String> currentTextInLines;
    int blank;
    int lineIndex;

    Game(Settings settings) throws Exception{
        Scanner inputScanner=new Scanner(System.in);
        int lives=startingLives=settings.livesAtStart;
        Scanner inScan = new Scanner(System.in);
        System.out.println("Please choose a file by typing in its name");
        text= new Text(inScan.nextLine()+".txt",settings);
        currentTextInLines=text.textInLinesWithBlanks;
        blank=1;
        if(settings.isPrepped){
            lineIndex=2;
        }else {
            lineIndex=0;
        }
        while(blank<=text.answers.size()){
                if (lives<=0){
                    System.out.println("no more guesses. GAME OVER");
                    System.exit(0);
                }
                if(settings.isGoingLineByLine){
                    System.out.println(currentTextInLines.get(lineIndex));}
                else {
                    for (String line:
                            currentTextInLines)
                        System.out.println(line);
                }
                    System.out.println("What is ___"+blank+"___?");
                    System.out.println("Guesses left: "+lives);
                    String guess=inputScanner.next();
                    if(guess.equals(text.answers.get(blank-1))){
                        currentTextInLines=Text.fillTheBlank(currentTextInLines,text.answers,guess);
                        lineIndex++;
                        blank++;
                        if (settings.isRenewingLives){
                            lives=startingLives;
                        }
                    }else{
                        lives--;
                    }




            }
        System.out.println("Congratulations, you got all of it right!");
        System.exit(0);
        }
    }

