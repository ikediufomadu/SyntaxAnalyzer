package SyntaxAnalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static SyntaxAnalyzer.ThreeMainFunctions.program;

public class Driver{
    public static void main(String[] args) throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter a file to analyze or type \"quit\" to exit the program\nEG: \"hello.txt\" ");
        String fileName = userInput.readLine();
        if (fileName.equalsIgnoreCase("quit")) {
            System.out.println("Exiting program...");
            System.exit(0);
        }
        program();
        System.out.println("Concluded syntax analysis on " + fileName);
        main(new String[0]);
    }
}
