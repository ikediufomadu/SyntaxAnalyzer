package SyntaxAnalyzer;

import static SyntaxAnalyzer.LexicalAnalyzer.LexicalHelperFunctions.position;

public class SyntaxHelperFunctions {
    public static void SyntaxError (String symbol) {
        System.out.println("Bad symbol '" + symbol + "' at " + position() + " expected ");
    }
}
