package SyntaxAnalyzer.LexicalAnalyzer;

import java.io.IOException;

import static SyntaxAnalyzer.LexicalAnalyzer.GlobalVariables.*;
import static SyntaxAnalyzer.LexicalAnalyzer.LexicalHelperFunctions.*;
import static SyntaxAnalyzer.LexicalAnalyzer.Printer.printer;
import static SyntaxAnalyzer.LexicalAnalyzer.ThreeMainFunctions.*;
import static SyntaxAnalyzer.SyntaxHelperFunctions.programHelper;
import static SyntaxAnalyzer.ThreeMainFunctions.program;

public class Next {
    static int j = 0;
    public static String munchedWord = "";
    public static String program = "";
    public static String identifier = "";
    public static String colon = "";
    public static String end = "";
    public static boolean getColon = false;
    //Gets next lexeme
    public static void next(char[] charHolder) throws IOException {
        //On chance an empty array is passed we return
        if (charHolder.length == 0) {
            return;
        }
        char charToMunch = charHolder[j];

        //Used in the ThreeMainFunctions file to find the next char
        TokenInfo nextChar = new TokenInfo(charHolder, j);

        munchedWord = maxMunch(charToMunch, currentLine);
        if (munchedWord != null) {
            //Prints characters attached and before an unaccepted symbol
            if (wrongInput) {
                printer(currentLine, munchedWord, kind(munchedWord), value(munchedWord));
                program();
                System.out.println("\nIllegal character at " + position(currentLine, currentCharInLine) + ". Character is '" + charToMunch + "'.\nExiting program...");
                System.exit(0);
            }

            programHelper(munchedWord);
            program();

            printer(currentLine, munchedWord, kind(munchedWord), value(munchedWord));
            program();
            stringReset();

            if (symbolNext) {
                munchedWord = String.valueOf(TokenInfo.currentChar);
                printer(currentLine, munchedWord, kind(munchedWord), value(munchedWord));
                program();
                stringReset();
            }
        }
        j++;
        while (!TokenInfo.currentKeyword.equals("end-of-text")  && j <= charHolder.length - 1) {
            next(charHolder);
        }
    }
}