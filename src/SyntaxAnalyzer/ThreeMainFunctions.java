package SyntaxAnalyzer;

import java.io.IOException;

import static SyntaxAnalyzer.LexicalAnalyzer.Next.*;
import static SyntaxAnalyzer.LexicalAnalyzer.Reader.sb;
import static SyntaxAnalyzer.SyntaxHelperFunctions.*;

public class ThreeMainFunctions {
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
            System.out.println(symbol);
            next(stringToChar(sb));
        }
        else {
            SyntaxError(symbol);
        }
    }
    // Do third
    public static void body (String munchedWord) throws IOException {
        if (matchHelper(munchedWord)) {
            System.out.println(munchedWord);
            next(stringToChar(sb));
        }
        else {
            SyntaxError(munchedWord);
        }
    }
}
