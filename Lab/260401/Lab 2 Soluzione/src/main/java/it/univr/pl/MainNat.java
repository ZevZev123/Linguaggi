package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainNat {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString(args[0]); // or "1010"
        NatLexer lexer = new NatLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NatParser parser = new NatParser(tokens);
        ParseTree tree = parser.main();
    }

}
