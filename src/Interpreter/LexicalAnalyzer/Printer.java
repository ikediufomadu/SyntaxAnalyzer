package Interpreter.LexicalAnalyzer;

import static Interpreter.LexicalAnalyzer.LexicalHelperFunctions.position;

public class Printer {
    public static void printer(int  currentLine, String munchedWord, String kindValue, String value) {
        int intPassed = 1;

        for (int i = 1; i < munchedWord.length(); i++) {
            if (i == munchedWord.length() - 1) {
                intPassed = i;
            }
        }
        if (!munchedWord.equals("") && !munchedWord.equals(" ") && !munchedWord.contains("\t")) {
            if (!kindValue.equals("'ID'") && !kindValue.equals("'NUM'")){
                System.out.println(position(currentLine, intPassed) + " " + "'" + munchedWord + "'");
            }
            else {
                System.out.println(position(currentLine, intPassed) + " " + kindValue + " " + value);
            }
        }
    }
}
