package Interpreter.SyntaxAnalyzer;

import java.io.IOException;

import static Interpreter.LexicalAnalyzer.Next.*;
import static Interpreter.SyntaxAnalyzer.SyntaxHelperFunctions.*;

public class ThreeMainFunctions {
    public static void program() throws IOException {
        if (getProgram) {
            getProgram = false;
            match("program");
        }
        // Need to send ID name to reservedKeywords
        if (getIdentifier) {
            getIdentifier = false;
            match(identifier);
        }
        if (getColon) {
            getColon = false;
            match(colon);
        }
        // If body comes across the word 'end' it needs to go to the match end method
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
