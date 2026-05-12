package it.univr.pl;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainFirstAntlr {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString(args[0]);
        BinWordsLexer lexer = new BinWordsLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BinWordsParser parser = new BinWordsParser(tokens);
        ParseTree tree = parser.main();
    }
}
