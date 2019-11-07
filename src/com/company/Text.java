package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Text {
    List<String> textInListOfLines;
    LinkedList<String> answers = new LinkedList();
    List<String> textInLinesWithBlanks = new ArrayList<String>();
    public static List<String> fillTheBlank(List<String> textToFillBlank, LinkedList<String> anss, String ans){
        List<String> textWithABlankFilled= new ArrayList<>();
        for (String line:
             textToFillBlank) {
            String newLine=line.replaceAll("___"+anss.indexOf(ans)+"___", ans);
            textWithABlankFilled.add(newLine);
        }
        return textWithABlankFilled;
    }

    Text(String fileName, Settings settings) throws Exception {
        if (settings.isPrepped) {
            Scanner scanner= new Scanner(Paths.get(fileName));
            String answersLine=scanner.nextLine();
            String[] answersSplit=answersLine.split(",");
            for (String ans:answersSplit
                 ) {
                answers.add(ans);
            }
            scanner.nextLine();
            textInListOfLines=new ArrayList<>();
            while(scanner.hasNextLine()){
                textInListOfLines.add(scanner.nextLine());
            }
            for (String line:
                 textInListOfLines) {
                for (int i=1;i<answers.size();i++){
                    line=line.replaceAll("\\b"+answers.get(i)+"\\b","___"+(i)+"___"); //there's an empty string at index 0 due to loop not working for the first word

                }
                textInLinesWithBlanks.add(line);
            }
        } else {
            textInListOfLines = Files.readAllLines(Paths.get(fileName));
            int listIndex = 0;
            for (String line : textInListOfLines
            ) {
                String[] splitLine = line.split(" ");
                int randomIndex = (int) (Math.random() * splitLine.length);
                answers.add(splitLine[randomIndex]);
                splitLine[randomIndex] = "___" + (listIndex + 1) + "___";
                String joinedLine = "";
                for (int i = 0; i < splitLine.length; i++) {
                    joinedLine = joinedLine + splitLine[i] + " ";
                }
                textInLinesWithBlanks.add(joinedLine);
                listIndex++;
            }
        }
    }
}
