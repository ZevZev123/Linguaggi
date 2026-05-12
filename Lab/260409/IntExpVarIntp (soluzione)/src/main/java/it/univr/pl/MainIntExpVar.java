package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainIntExpVar {

    private static final String IN =
            """
            base = 5;
            height = (base + -10);
            (base * height)
            """;

    public static void main(String[] args) {
        String prog = args[0]; // or IN
        CharStream cs = CharStreams.fromString(prog);
        IntExpVarLexer lexer = new IntExpVarLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IntExpVarParser parser = new IntExpVarParser(tokens);
        ParseTree tree = parser.main();

        IntExpVarIntp interpreter = new IntExpVarIntp();
        System.out.println("eval of\n\n" + prog + "\nyields " + interpreter.visit(tree));

    }
}
