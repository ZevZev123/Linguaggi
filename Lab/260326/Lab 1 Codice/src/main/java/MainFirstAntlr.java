import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainFirstAntlr {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString(args[0]); // or "1010"
        BinWordsLexer lexer = new BinWordsLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BinWordsParser parser = new BinWordsParser(tokens);
        ParseTree tree = parser.main();
    }

}
