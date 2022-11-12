package SyntaxAnalyzer.LexicalAnalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static SyntaxAnalyzer.LexicalAnalyzer.Driver.main;
import static SyntaxAnalyzer.LexicalAnalyzer.GlobalVariables.currentLine;
import static SyntaxAnalyzer.LexicalAnalyzer.Next.next;
import static SyntaxAnalyzer.LexicalAnalyzer.ThreeMainFunctions.*;

public class Reader {
    public static void reader(String filenameToRead) throws IOException {
        File f = new File("./Test Examples/" + filenameToRead);

        if (f.exists() && !f.isDirectory() && f.isFile() && f.canRead()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String checker;
            StringBuilder sb = new StringBuilder();

            //Reads by line
            while ((checker = br.readLine()) != null) {
                currentLine++;
                //Accounts for last index in string, adds a space after it allowing the 'next' function to work with all strings
                checker += " ";
                for (int i = 0; i < checker.length(); i++) {
                    char c = checker.charAt(i);
                    //Skips code with comments
                    if (i + 1 < checker.length() && c == '/' && checker.charAt(i + 1) == '/') break;
                    sb.append(c);
                }
                //In case there is a comment at the end of the file this will allow it to be skipped without throughing an arrayoutofbounds error
                sb.append(" ");
                next(sb.toString().toCharArray(), currentLine);
            }
            br.close();
            fr.close();
            kind(null);
        } else {
            System.out.println("The file name you entered does not exist within this program's directory. Please recheck.\n");
            main(new String[0]);
        }
    }
}