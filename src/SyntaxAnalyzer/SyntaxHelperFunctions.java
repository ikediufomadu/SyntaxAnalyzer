package SyntaxAnalyzer;

import static SyntaxAnalyzer.LexicalAnalyzer.GlobalVariables.currentCharInLine;
import static SyntaxAnalyzer.LexicalAnalyzer.GlobalVariables.currentLine;
import static SyntaxAnalyzer.LexicalAnalyzer.LexicalHelperFunctions.position;
import static SyntaxAnalyzer.ReservedWords.reserved;

public class SyntaxHelperFunctions {
    public static void SyntaxError (String symbol) {
        System.out.println("Bad symbol '" + symbol + "' at " + position(currentLine, currentCharInLine) + " expected ");
    }

    public static Boolean matchHelper(String symbol) {
        for (String s : reserved) {
            if (symbol.equals(s)){
                return true;
            }
        }
        return false;
    }
}
