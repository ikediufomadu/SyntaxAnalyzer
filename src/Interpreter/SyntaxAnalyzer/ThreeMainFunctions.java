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
        else if (getIdentifier) {
            getIdentifier = false;
            match(identifier);
        }
        else if (getColon) {
            getColon = false;
            match(":");
            getBody = true;
        }
        // If body comes across the word 'end' it needs to go to the match end method
        else if (getBody) {
            body(munchedWord);
        }
        else if (getEnd) {
            getBody = false;
            getEnd = false;
            System.out.println(" FSFFEFEFEW");
            match("end");
        }
    }
    public static void match(String symbol) throws IOException {
        if (matchHelper(symbol)) {
            //next();
        }
        else {
            SyntaxError(symbol);
        }
    }
    public static void body (String munchedWord) throws IOException {
        if (!munchedWord.equals("") && !munchedWord.equals(" ") && !munchedWord.contains("\t")) {
            if (bodyHelper(munchedWord)) {
                //next();
            }
            else {
                SyntaxError(munchedWord);
            }
        }
    }
}
