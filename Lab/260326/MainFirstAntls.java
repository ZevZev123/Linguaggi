import org.antlr.v4.runtime.charStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.BinWordsParser;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainFirstAntls {
    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString(args[0]); // input
        BinWordsLexer lexer = new BinWordsLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer); // estrae i token
        BinWordsParser parser = new BinWordsParser(tokens);

        ParseTree tree = parser.main(); // la condizione iniziale si chiama main (in BinWords.g4)
    }
}

// se args[0] fa parte del linguaggio non viene stampato nulla
// altrimenti viene stampato un errore
