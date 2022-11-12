package Interpreter.SyntaxAnalyzer;

import java.io.IOException;

import static Interpreter.SyntaxAnalyzer.Driver.main;
import static Interpreter.LexicalAnalyzer.GlobalVariables.currentCharInLine;
import static Interpreter.LexicalAnalyzer.GlobalVariables.currentLine;
import static Interpreter.LexicalAnalyzer.LexicalHelperFunctions.position;
import static Interpreter.LexicalAnalyzer.Next.*;
import static Interpreter.SyntaxAnalyzer.ThreeMainFunctions.program;

public class SyntaxHelperFunctions {

    public static boolean skip = false;
    static String[] reservedForMatch = {"program", "",":", "end"};

    static String[] reservedForBody = {"bool", "identifier", "int", "end", "bool", "int", ";", ":=", "if", "then", "else", "fi",
            "while", "do", "od", "print", "<", "=<", "=", "!=", ">=", ">", "+", "or", "*", "/", "and", "not",
            "false", "true", "_", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"
            , "l", "m", "n", "o", "p", "q", "u", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static void SyntaxError (String symbol) throws IOException {
        System.out.println("\nBad symbol '" + symbol + "' at " + position(currentLine, currentCharInLine) + " expected '" + identifier + "' CHANGE THIS TO ACTUAL EXPECTED RESULT"
        + "\nResetting program\n.........\n");
        main(new String[0]);
    }

    public static void programHelper (String munchedWord) throws IOException {
        if (munchedWord.equalsIgnoreCase("program")) {
            identifier = munchedWord;
            getProgram = true;
            getIdentifier = true;
            return;
        }

        if (identifier.equalsIgnoreCase("program") && !munchedWord.equalsIgnoreCase("program")) {
            reservedForMatch[1] = munchedWord;
            identifier = reservedForMatch[1];
            skip = true;
            // Find another way to do this
            program();
            return;
        }

        if (munchedWord.equals(":")) {
            getColon = true;
            getBody = true;
            return;
        }
        if (munchedWord.equalsIgnoreCase("end")) {
            getEnd = true;
        }
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
        for (String s : reservedForBody) {
            if (symbol.toLowerCase().equals(s) || s.contains(symbol.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static char[] stringToChar (StringBuilder sb) {
        return sb.toString().toCharArray();
    }
}
