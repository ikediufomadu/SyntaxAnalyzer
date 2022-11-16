package Interpreter.SyntaxAnalyzer;

import Interpreter.LexicalAnalyzer.TokenInfo;

import java.io.IOException;

import static Interpreter.LexicalAnalyzer.Next.*;
import static Interpreter.SyntaxAnalyzer.SyntaxHelperFunctions.*;

public class SyntaxThreeMainFunctions {
    public static boolean startBody;
    public static boolean startEnd;
    public static boolean skipError1 = true;
    public static boolean skipError2 = true;
    public static boolean skipError3 = true;
    public static boolean skipError4 = true;
    public static boolean skipError5 = true;

    public static boolean skip1Syntax = false;
    public static boolean skip2Syntax = false;
    public static boolean skip3Syntax = false;
    public static boolean skip4Syntax = false;
    public static boolean skip5Syntax = false;


    public static void program() throws IOException {
        if (firstWord) {
            skipError1 = false;
            firstWord = false;
            match("program");
            return;
        }
        else if (skipError1) {
            skip1Syntax = true;
            SyntaxError(munchedWord);
        }

        if (getID) {
            skipError2 = false;
            getID = false;
            whatIdentifier(munchedWord);
            match(munchedWord);
            if (TokenInfo.currentChar != ':') {
                skip3Syntax = true;
                SyntaxError(Character.toString(TokenInfo.currentChar));
            }
            return;
        }
        else if (skipError2) {
            skip2Syntax = true;
            SyntaxError(munchedWord);
        }

        if (getColon) {
            skipError3 = false;
            getColon = false;
            match(":");
            startBody = true;
            return;
        }
        else if (skipError3) {
            skip3Syntax = true;
            SyntaxError(munchedWord);
        }

        if (startBody && !munchedWord.equals("end")) {
            skipError4 = false;
            body(munchedWord);
            return;
        }
        else if (skipError4) {
            skip4Syntax = true;
            SyntaxError(munchedWord);
        }

        if (munchedWord.equalsIgnoreCase("end")) {
            startEnd = true;
            startBody = false;
            match("end");
            return;
        }
        else if (skipError5){
            skip5Syntax = true;
            SyntaxError(munchedWord);
        }
        System.out.println("Critical error has occurred. Program will shut down immediately");
        System.exit(0);
    }
    public static void match(String symbol) throws IOException {
        if (!matchHelper(symbol)) {
            SyntaxError(symbol);
        }
        else {
            System.out.println("Matched " + symbol);
        }
    }
    public static void body (String munchedWord) throws IOException {
        if (!munchedWord.equals("") && !munchedWord.equals(" ") && !munchedWord.contains("\t") && !munchedWord.equals(":")) {
            if (!bodyHelper(munchedWord)) {
                SyntaxError(munchedWord);
            }
        }
    }
}
