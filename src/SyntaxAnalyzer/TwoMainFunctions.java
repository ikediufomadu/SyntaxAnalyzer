package SyntaxAnalyzer;

import static SyntaxAnalyzer.LexicalAnalyzer.Next.next;
import static SyntaxAnalyzer.LexicalAnalyzer.ThreeMainFunctions.kind;
import static SyntaxAnalyzer.SyntaxHelperFunctions.SyntaxError;
import static SyntaxAnalyzer.SyntaxHelperFunctions.matchHelper;
import static SyntaxAnalyzer.tempMethodHolder.body;

public class TwoMainFunctions {
    // Do first
    public static void program(){
        match ("program");
        match ("identifier");
        match (":");
        body ();
        match ("end");
    }
    // Do second
    public static void match(String symbol){
        if (matchHelper(symbol)) {
            next();
        }
        else {
            SyntaxError(symbol);
        }
    }
}
