package Interpreter.SyntaxAnalyzer;

import java.io.IOException;

import static Interpreter.LexicalAnalyzer.Next.*;
import static Interpreter.SyntaxAnalyzer.SyntaxHelperFunctions.*;

public class ThreeMainFunctions {
    public static void program() throws IOException {
        if (getProgram) {
            System.out.println("WE ARE IN THE PROGRAM BOOLEAN");
            getProgram = false;
            match("program");
        }
        else if (getIdentifier) {
            System.out.println("WE ARE IN THE IDENTIFIER BOOLEAN");
            getIdentifier = false;
            match(identifier);
        }
        else if (getColon) {
            System.out.println("WE ARE IN THE COLON BOOLEAN");
            getColon = false;
            getBody = true;
            match(":");
        }
        // If body comes across the word 'end' it needs to go to the match end method
        else if (getBody) {
            System.out.println("WE ARE IN THE BODY BOOLEAN");
            body(munchedWord);
        }
        else if (getEnd) {
            System.out.println("WE ARE IN THE END BOOLEAN");
            getBody = false;
            getEnd = false;
            match("end");
        }
    }
    public static void match(String symbol) throws IOException {
        if (matchHelper(symbol)) {
            System.out.println(symbol + " THIS IS THE SYMBOL");
            //next();
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
