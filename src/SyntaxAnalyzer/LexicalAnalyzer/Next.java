package SyntaxAnalyzer.LexicalAnalyzer;

import static SyntaxAnalyzer.LexicalAnalyzer.GlobalVariables.currentCharInLine;
import static SyntaxAnalyzer.LexicalAnalyzer.LexicalHelperFunctions.position;
import static SyntaxAnalyzer.LexicalAnalyzer.LexicalHelperFunctions.stringReset;
import static SyntaxAnalyzer.LexicalAnalyzer.Printer.printer;
import static SyntaxAnalyzer.LexicalAnalyzer.ThreeMainFunctions.*;

public class Next {
    static int j = 0;
    static String munchedWord;
    //Gets next lexeme
    public static void next(char[] charHolder, int currentLine) {
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
                System.out.println("\nIllegal character at " + position(currentLine, currentCharInLine) + ". Character is '" + charToMunch + "'.\nExiting program...");
                System.exit(0);
            }

            printer(currentLine, munchedWord, kind(munchedWord), value(munchedWord));
            stringReset();

            if (symbolNext) {
                munchedWord = String.valueOf(TokenInfo.currentChar);
                printer(currentLine, munchedWord, kind(munchedWord), value(munchedWord));
                stringReset();
            }
        }
        j++;
        while (TokenInfo.currentKeyword != "end-of-text" && j <= charHolder.length - 1) {
            next(charHolder, currentLine);
        }
    }
}