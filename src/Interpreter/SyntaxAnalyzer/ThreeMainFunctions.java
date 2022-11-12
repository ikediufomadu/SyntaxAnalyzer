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
            match(":");
        }
        // If body comes across the word 'end' it needs to go to the match end method
        if (getBody) {
            body(munchedWord);
        }
        if (getEnd) {
            getBody = false;
            getEnd = false;
            match("end");
        }
    }
    public static void match(String symbol) throws IOException {
        if (matchHelper(symbol)) {
            System.out.println(symbol + " THIS IS THE SYMBOL");
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
