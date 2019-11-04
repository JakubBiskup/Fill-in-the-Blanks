package com.company;

import java.io.File;
import java.util.Scanner;

public class Settings {
    boolean isPrepped;
    boolean isReplacingOneOccurence;
    boolean isGoingLineByLine;
    boolean isRenewingLives;
    int livesAtStart;

    Settings() throws Exception{
        File settingsFile=new File("settings.txt");
        Scanner scanner= new Scanner(settingsFile);
        isPrepped=(scanner.next().equals("1"));
        isGoingLineByLine=(scanner.next().equals("1"));
        isRenewingLives=(scanner.next().equals("1"));
        livesAtStart=scanner.nextInt();
    }

}
