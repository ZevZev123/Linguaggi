package it.univr.pl;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.List;

public class MainDecExpVar {

    private static final String IN =
            """
            a = 5.5;
            <!-- a = a + 1;
            b = (a ^ 2);
            (b / 10)
            """;

    public static void main(String[] args) {
        String prog = args[0]; // or IN
        CharStream cs = CharStreams.fromString(prog);
        DecExpVarLexer lexer = new DecExpVarLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DecExpVarParser parser = new DecExpVarParser(tokens);
        ParseTree tree = parser.main();

        DecExpVarIntp interpreter = new DecExpVarIntp();
        System.out.println("eval of\n\n" + prog + "\nyields " + interpreter.visit(tree));
  
    }
}
