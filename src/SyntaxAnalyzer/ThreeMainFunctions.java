package SyntaxAnalyzer;

import java.io.IOException;

import static SyntaxAnalyzer.LexicalAnalyzer.Next.*;
import static SyntaxAnalyzer.LexicalAnalyzer.Reader.sb;
import static SyntaxAnalyzer.SyntaxHelperFunctions.*;

public class ThreeMainFunctions {

    // Call this within your printer or kind function
    public static void program() throws IOException {
        match (program);
        match (identifier);
        match (colon);
        body (munchedWord);
        match (end);
    }
    // Do second
    public static void match(String symbol) throws IOException {
        if (matchHelper(symbol)) {
            //Might have to bypass this by just taking the string from the printer or kind function and then checking it with reserved strings in matchHelper
            next(stringToChar(sb));
        }
        else {
            SyntaxError(symbol);
        }
    }
    // Do third
    public static void body(String munchedWord){}
}
