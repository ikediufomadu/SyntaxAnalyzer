package SyntaxAnalyzer;

import java.io.IOException;

import static SyntaxAnalyzer.Driver.main;
import static SyntaxAnalyzer.LexicalAnalyzer.GlobalVariables.currentCharInLine;
import static SyntaxAnalyzer.LexicalAnalyzer.GlobalVariables.currentLine;
import static SyntaxAnalyzer.LexicalAnalyzer.LexicalHelperFunctions.position;
import static SyntaxAnalyzer.LexicalAnalyzer.Next.*;
import static SyntaxAnalyzer.ReservedWords.reservedForBody;
import static SyntaxAnalyzer.ReservedWords.reservedForMatch;

public class SyntaxHelperFunctions {

    public static void SyntaxError (String symbol) throws IOException {
        System.out.println("Bad symbol '" + symbol + "' at " + position(currentLine, currentCharInLine) + " expected " + symbol + " change this to actual expected result");
        main(new String[0]);
    }

    public static void programHelper (String munchedWord) {
        if (munchedWord.equalsIgnoreCase("program")) {
            program = munchedWord;
            identifier = munchedWord;
        }
        if (identifier.equalsIgnoreCase("program") && !munchedWord.equalsIgnoreCase("program")) {
            identifier = munchedWord;
            getColon = true;
        }
        if (getColon) {
            colon = munchedWord;
            getColon = false;
        }
        if (munchedWord.equalsIgnoreCase("end")) {
            end = munchedWord;
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
