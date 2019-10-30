package com.company;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Text {
    List<String> textInListOfLines;
    LinkedList<String> answers=new LinkedList();

    Text(String fileName) throws Exception{
        textInListOfLines= Files.readAllLines(Paths.get(fileName));
        int listIndex=0;
        for (String line:textInListOfLines
             ) {
            String [] splitLine =line.split(" ");
            int randomIndex=(int) (Math.random()*splitLine.length);
            answers.add(splitLine[randomIndex]);
            textInListOfLines.set(listIndex, line.replaceAll("\\b"+splitLine[randomIndex]+"\\b", "___"+(listIndex+1)+"___"));
            listIndex++;



        }


        }

    }

