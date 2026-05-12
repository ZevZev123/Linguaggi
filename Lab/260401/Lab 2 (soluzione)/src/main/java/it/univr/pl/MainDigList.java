package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainDigList {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString(args[0]); // or "(2,0,1)"
        DigListLexer lexer = new DigListLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DigListParser parser = new DigListParser(tokens);
        ParseTree tree = parser.main();
    }
}
