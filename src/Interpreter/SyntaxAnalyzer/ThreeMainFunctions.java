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
        else if (getBody) {
            body(munchedWord);
        }
        else if (getEnd) {
//            getEnd = false;
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
            if (!bodyHelper(munchedWord)) {
                SyntaxError(munchedWord);
            }
        }
    }
}
