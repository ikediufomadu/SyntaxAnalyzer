package SyntaxAnalyzer;

import static SyntaxAnalyzer.LexicalAnalyzer.GlobalVariables.currentCharInLine;
import static SyntaxAnalyzer.LexicalAnalyzer.GlobalVariables.currentLine;
import static SyntaxAnalyzer.LexicalAnalyzer.LexicalHelperFunctions.position;
import static SyntaxAnalyzer.LexicalAnalyzer.Next.*;
import static SyntaxAnalyzer.ReservedWords.reserved;

public class SyntaxHelperFunctions {

    public static void SyntaxError (String symbol) {
        System.out.println("Bad symbol '" + symbol + "' at " + position(currentLine, currentCharInLine) + " expected ");
    }

    public static Boolean matchHelper (String symbol) {
        for (String s : reserved) {
            if (symbol.equals(s)){
                return true;
            }
        }
        return false;
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
}
