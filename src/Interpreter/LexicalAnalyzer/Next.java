package Interpreter.LexicalAnalyzer;

import java.io.IOException;

import static Interpreter.LexicalAnalyzer.GlobalVariables.*;
import static Interpreter.LexicalAnalyzer.LexicalHelperFunctions.*;
import static Interpreter.LexicalAnalyzer.Reader.sb;
import static Interpreter.LexicalAnalyzer.LexicalThreeMainFunctions.*;
import static Interpreter.SyntaxAnalyzer.SyntaxHelperFunctions.*;
import static Interpreter.SyntaxAnalyzer.SyntaxThreeMainFunctions.program;

public class Next {
    static int j = 0;
    public static String munchedWord = "";
    public static char charToMunch;
    public static boolean firstWord = false;
    public static boolean getID = false;
    public static boolean getColon = false;
    private static String lastWord = "";

    //Gets next lexeme
    public static void next() throws IOException {
        //On chance an empty array is passed we return
        if (stringToChar(sb).length == 0) {
            return;
        }

        charToMunch = stringToChar(sb)[j];

        //Used in the LexicalThreeMainFunctions file to find the next char
        TokenInfo nextChar = new TokenInfo(stringToChar(sb), j);
        munchedWord = maxMunch(charToMunch, currentLine);

        if (munchedWord != null && !munchedWord.isBlank() && !munchedWord.isEmpty()) {
            //Prints characters attached and before an unaccepted symbol
            if (wrongInput) {
                program();
                System.out.println("\nIllegal character at " + position(currentLine, currentCharInLine) + ". Character is '" + charToMunch + "'.\nExiting program...");
                System.exit(0);
            }

            if (munchedWord.equalsIgnoreCase("program")) {
                firstWord = true;
                lastWord = munchedWord;
            }
            if (!firstWord && lastWord.equals("program")) {
                lastWord = "";
                getID = true;
            }
            program();
            stringReset();

            if (symbolNext) {
                munchedWord = String.valueOf(TokenInfo.currentChar);
                if (munchedWord.equals(":") && TokenInfo.nextChar != '=') {
                    getColon = true;
                }
                program();
                stringReset();
            }
        }
        j++;
        while (!TokenInfo.currentKeyword.equals("end-of-text")  && j <= stringToChar(sb).length - 1) {
            next();
        }
    }
}