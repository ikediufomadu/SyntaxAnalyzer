package Interpreter.SyntaxAnalyzer;

import Interpreter.LexicalAnalyzer.TokenInfo;

import java.io.IOException;

import static Interpreter.LexicalAnalyzer.Next.*;
import static Interpreter.SyntaxAnalyzer.SyntaxHelperFunctions.*;

public class ThreeMainFunctions {
    public static boolean startBody;
    public static void program() throws IOException {
        if (munchedWord.equalsIgnoreCase("program")) {
            match("program");
        }
        if (munchedWord.equalsIgnoreCase("program") && TokenInfo.nextChar == ':') {
            match(munchedWord);
        }
        else if (munchedWord.equalsIgnoreCase(":")) {
            match(":");
            startBody = true;
        }
        else if (startBody && !munchedWord.equals("end")) {
            body(munchedWord);
        }
        else if (munchedWord.equalsIgnoreCase("end")) {
            startBody = false;
            match("end");
        }
    }
    public static void match(String symbol) throws IOException {
        if (!matchHelper(symbol)) {
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
