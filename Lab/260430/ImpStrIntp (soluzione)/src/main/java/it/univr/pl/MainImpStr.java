package it.univr.pl;

import it.univr.pl.value.DecValue;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainImpStr {

    private static final String IN =
            """
            x = 2^2^3;
            y = (2^2)^3;
            s = "a" : " string";
            if (x != y) { z = z + 1 } // z changes to int
            else { z = z - 1 };
            r = toStr(4.32);
            print r;
            print "hello \\t world \\" \\\\";
            print "h" : toStr(3) : "ll" : toStr(4 mod 2)
            """;

    private static Mem mem = new Mem();
    static {
        mem.updateValue("z", new DecValue(3.0));
        mem.updateValue("k", new DecValue(3.14));
    }

    public static void main(String[] args) {
        String prog = IN;
        CharStream cs = CharStreams.fromString(prog);
        ImpStrLexer lexer = new ImpStrLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ImpStrParser parser = new ImpStrParser(tokens);
        ParseTree tree = parser.main();
        System.out.println(mem);
        //ImpStrIntp interpreter = new ImpStrIntp();
        ImpStrIntp interpreter = new ImpStrIntp(mem);
        try {
            interpreter.visit(tree);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        mem = interpreter.getMem();
        System.out.println(mem);
    }
}
