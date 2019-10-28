package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        Text test = new Text("FRACTAL.txt");
        for (String line : test.textInListOfLines
        ) {


            System.out.println(line);
        }
        System.out.println(test.answers);
    }
}