package SyntaxAnalyzer;

import static SyntaxAnalyzer.LexicalAnalyzer.Next.*;
import static SyntaxAnalyzer.SyntaxHelperFunctions.SyntaxError;
import static SyntaxAnalyzer.SyntaxHelperFunctions.matchHelper;

public class ThreeMainFunctions {

    // Call this within your printer or kind function
    public static void program(){
        match (program);
        match (identifier);
        match (colon);
        body ();
        match (end);
    }
    // Do second
    public static void match(String symbol){
        if (matchHelper(symbol)) {
            //Might have to bypass this by just taking the string from the printer or kind function and then checking it with reserved strings in matchHelper
            //next();
        }
        else {
            SyntaxError(symbol);
        }
    }
    // Do third
    public static void body(){}
}
