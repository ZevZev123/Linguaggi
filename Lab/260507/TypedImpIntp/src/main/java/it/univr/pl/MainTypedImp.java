package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainTypedImp {

    private static final String IN =
            """
            int i;
            int v;
            string s;
            dec x;
            int g;
            i = 0;
            while (i < 10) {
              v = i * i;
              i = i + 1
            };
            print toStr(v);
            print toStr("hello \\\\ world");
            s = "3";
            print s : "  " : toStr(8.7);
            x = 3.1;
            g = 3 / 2;
            print toStr(4.2)
            """;

    public static void main(String[] args) {
        String prog = args[0]; // or IN
        CharStream cs = CharStreams.fromString(prog);
        TypedImpLexer lexer = new TypedImpLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TypedImpParser parser = new TypedImpParser(tokens);
        ParseTree tree = parser.main();
        TypedImpTS typeSystem = new TypedImpTS();
        try {
            typeSystem.visit(tree);
            TypedImpIntp interpreter = new TypedImpIntp();
            interpreter.visit(tree);
            //System.out.println(interpreter.getMem());
        } catch (RuntimeException re) {
            System.out.println("Typing error(s) found.");
            System.out.println(re.getMessage());
        }
    }
}
