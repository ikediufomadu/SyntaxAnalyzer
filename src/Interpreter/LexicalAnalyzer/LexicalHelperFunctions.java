package Interpreter.LexicalAnalyzer;

import java.io.IOException;

import static Interpreter.LexicalAnalyzer.Driver.main;
import static Interpreter.LexicalAnalyzer.GlobalVariables.currentCharInLine;
import static Interpreter.LexicalAnalyzer.GlobalVariables.currentLine;
import static Interpreter.LexicalAnalyzer.ThreeMainFunctions.*;

public class LexicalHelperFunctions {
    static String lostChar = "";
    //Report syntax errors
    public static boolean reportLexicalError(char c) {
        if (c == '!' && TokenInfo.nextChar == '=') {
            return false;
        }
        return c == '@' || c == '!' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '`' || c == '~' || c == ',' || c == '\"' || c == '?' || c == '\'' || c == '[' || c == ']' || c == '{' || c == '}';
    }

    //Reruns program after successful tokenization of a file
    public static void sequenceKeepRunning() {
        try {
            reset();
            main(new String[0]);
        } catch (IOException e) {
            System.out.println("Could not continue program...quitting program");
            System.exit(0);
        }
    }

    //Reset variables to analyze next file
    private static void reset() {
        currentLine = 0;
        currentCharInLine = 0;
        Next.j = 0;
    }
    public static void stringReset(){
        if (munchedString.length() == 1) {
            if (Character.isLetter(TokenInfo.currentChar)){
                if (Character.isLetter(TokenInfo.nextChar)) {
                    lostChar = String.valueOf(TokenInfo.currentChar);
                }
            }
        }
        munchedString = "";
        munchedNumber = "";
        munchedSymbol = "";
    }
    public static String position(int currentLine, int currentCharInLine) {
        return (currentLine) + ":" + (currentCharInLine);
    }
}
