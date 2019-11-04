package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Text {
    List<String> textInListOfLines;
    LinkedList<String> answers=new LinkedList();
    List<String> textInLinesWithBlanks= new ArrayList<String>();

    Text(String fileName) throws Exception{
        textInListOfLines= Files.readAllLines(Paths.get(fileName));
        int listIndex=0;
        for (String line:textInListOfLines
             ) {
            String [] splitLine =line.split(" ");
            int randomIndex=(int) (Math.random()*splitLine.length);
            answers.add(splitLine[randomIndex]);
            splitLine[randomIndex]="___"+ (listIndex + 1) +"___";
            String joinedLine = "";
            for (int i=0;i<splitLine.length;i++) {
                joinedLine = joinedLine + splitLine[i] + " ";
            }
            textInLinesWithBlanks.add(joinedLine);
            listIndex++;
        }
    }
}

