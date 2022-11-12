package Interpreter.SyntaxAnalyzer;

import java.io.IOException;

import static Interpreter.LexicalAnalyzer.Next.*;
import static Interpreter.SyntaxAnalyzer.SyntaxHelperFunctions.*;

public class ThreeMainFunctions {
    // Needs to request next word from Lexical Analyzer
    public static void program() throws IOException {
        match(program);
        match(identifier);
        match(colon);
        body(munchedWord);
        match(end);
    }
    public static void match(String symbol) throws IOException {
        if (matchHelper(symbol)) {
            System.out.println(symbol + " GHEHHHE");
            next();
        }
        else {
            SyntaxError(symbol);
        }
    }
    public static void body (String munchedWord) throws IOException {
        if (bodyHelper(munchedWord)) {
            System.out.println(munchedWord + " SISISISI");
            next();
        }
        else {
            SyntaxError(munchedWord);
        }
    }
}
