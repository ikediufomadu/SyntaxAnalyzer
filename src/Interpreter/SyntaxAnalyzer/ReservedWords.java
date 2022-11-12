package Interpreter.SyntaxAnalyzer;

public class ReservedWords {
    static String[] reservedForMatch = {"program", "identifier", ":", "end"};

    static String[] reservedForBody = {"bool", "identifier", "int", "end", "bool", "int", ";", ":=", "if", "then", "else", "fi",
            "while", "do", "od", "print", "<", "=<", "=", "!=", ">=", ">", "+", "or", "*", "/", "and", "not",
            "false", "true", "_", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"
            , "l", "m", "n", "o", "p", "q", "u", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
}