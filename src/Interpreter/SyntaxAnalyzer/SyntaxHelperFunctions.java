package Interpreter.SyntaxAnalyzer;

import java.io.IOException;

import static Interpreter.LexicalAnalyzer.Driver.main;
import static Interpreter.LexicalAnalyzer.LexicalHelperFunctions.reset;
import static Interpreter.LexicalAnalyzer.GlobalVariables.currentCharInLine;
import static Interpreter.LexicalAnalyzer.GlobalVariables.currentLine;
import static Interpreter.LexicalAnalyzer.LexicalHelperFunctions.position;
import static Interpreter.LexicalAnalyzer.Next.*;
import static Interpreter.SyntaxAnalyzer.SyntaxThreeMainFunctions.*;

public class SyntaxHelperFunctions {
    public static String copyMunch = "";
    static String[] reservedForMatch = {"program", "",":", "end"};

    static String[] reservedForBody = {"bool", "identifier", "int", "bool", "int", ";", ":=", "if", "then", "else", "fi",
            "while", "do", "od", "print", "<", "=<", "=", "!=", ">=", ">", "+", "or", "*", "/", "(", ")","and", "not",
            "false", "true", "-","_", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"
            , "l", "m", "n", "o", "p", "q", "u", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static void SyntaxError (String symbol) throws IOException {
        if (skip1Syntax) {
            System.out.println("\nBad symbol '" + symbol + "' at " + position(currentLine, currentCharInLine) + " expected 'program'.\nResetting program\n.........\n");
        }
        else if (skip2Syntax) {
            System.out.println("\nBad symbol '" + symbol + "' at " + position(currentLine, currentCharInLine) + " expected an identifier.\nResetting program\n.........\n");
        }
        else if (skip3Syntax) {
            System.out.println("\nBad symbol '" + symbol + "' at " + position(currentLine, currentCharInLine) + " expected ':'.\nResetting program\n.........\n");
        }
        else if (skip4Syntax) {
            System.out.println("\nBad symbol '" + symbol + "' at " + position(currentLine, currentCharInLine) + " expected CHANGE THIS TO WHATEVER THE CASE IS.\nResetting program\n.........\n");
        }
        else if (skip5Syntax) {
            System.out.println("\nBad symbol '" + symbol + "' at " + position(currentLine, currentCharInLine) + " expected 'end'.\nResetting program\n.........\n");
        }
        reset();
        main(new String[0]);
    }

    public static void whatIdentifier (String munchedWord)  {
        getID = false;
        for (int i = 0; i < munchedWord.length(); i++) {
            copyMunch += munchedWord.charAt(i);
        }
        reservedForMatch[1] = copyMunch;
        copyMunch = "";
    }

    public static Boolean matchHelper (String symbol) {
        for (String s : reservedForMatch) {
            if (symbol.equals(s)){
                return true;
            }
        }
        return false;
    }

    public static Boolean bodyHelper (String symbol) {
        if (symbol != null && !symbol.isEmpty() && !symbol.isBlank()&& !symbol.equals(" ") && !munchedWord.contains("\t")) {
            for (String s : reservedForBody) {
                if (symbol.toLowerCase().equals(s) || s.contains(symbol.toLowerCase())) {
                    System.out.println("Found match for " + symbol);
                    return true;
                }
            }
            System.out.println("Failed to match " + symbol);
            return false;
        }
        return false;
    }

    public static char[] stringToChar (StringBuilder sb) {
        return sb.toString().toCharArray();
    }
}
