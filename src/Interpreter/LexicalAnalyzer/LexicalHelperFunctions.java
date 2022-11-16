package Interpreter.LexicalAnalyzer;

import java.io.IOException;

import static Interpreter.LexicalAnalyzer.Driver.main;
import static Interpreter.LexicalAnalyzer.GlobalVariables.currentCharInLine;
import static Interpreter.LexicalAnalyzer.GlobalVariables.currentLine;
import static Interpreter.LexicalAnalyzer.LexicalThreeMainFunctions.*;
import static Interpreter.SyntaxAnalyzer.SyntaxThreeMainFunctions.*;

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
    public static void reset() {
        currentLine = 0;
        currentCharInLine = 0;
        Next.j = 0;
        startBody = false;
        startEnd = false;
        skipError1 = true;
        skipError2 = true;
        skipError3 = true;
        skipError4 = true;
        skipError5 = true;
        skip1Syntax = false;
        skip2Syntax = false;
        skip3Syntax = false;
        skip4Syntax = false;
        skip5Syntax = false;
        munchedString = "";
        munchedNumber = "";
        munchedSymbol = "";
        wrongInput = false;
        symbolNext = false;
        attachLostParent = false;
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
