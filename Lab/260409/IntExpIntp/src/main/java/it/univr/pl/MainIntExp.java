package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainIntExp {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString(args[0]); // or "(2 + (5 * 3))"
        IntExpLexer lexer = new IntExpLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IntExpParser parser = new IntExpParser(tokens);
        ParseTree tree = parser.main();
    }
}
