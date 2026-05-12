package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainRecDigList {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString(args[0]); // or "(0,(),((2),3))"
        RecDigListLexer lexer = new RecDigListLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RecDigListParser parser = new RecDigListParser(tokens);
        ParseTree tree = parser.main();
    }

}
