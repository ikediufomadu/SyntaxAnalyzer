package SyntaxAnalyzer;

import static SyntaxAnalyzer.LexicalAnalyzer.Next.next;
import static SyntaxAnalyzer.LexicalAnalyzer.ThreeMainFunctions.kind;

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
        if (kind() == symbol) {
            next();
        }
        else {
            le
        }
    }
}
