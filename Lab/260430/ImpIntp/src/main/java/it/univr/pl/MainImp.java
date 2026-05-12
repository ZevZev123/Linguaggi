package it.univr.pl;

import it.univr.pl.value.IntValue;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainImp {

    private static final String IN =
            """
            x = 2^2^3;
            y = (2^2)^3;
            if (x != y) { z = z + 1 }
            """;

    private static Mem mem = new Mem();
    static {
        mem.update("z", new IntValue(3));
    }

    public static void main(String[] args) {
        String prog = args[0]; // or IN
        CharStream cs = CharStreams.fromString(prog);
        ImpLexer lexer = new ImpLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ImpParser parser = new ImpParser(tokens);
        ParseTree tree = parser.main();
        System.out.println(mem);
        //ImpIntp interpreter = new ImpIntp();
        ImpIntp interpreter = new ImpIntp(mem);
        try {
            interpreter.visit(tree);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        mem = interpreter.getMem();
        System.out.println(mem);
    }
}
