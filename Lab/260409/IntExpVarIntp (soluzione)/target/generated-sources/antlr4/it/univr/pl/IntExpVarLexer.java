// Generated from it/univr/pl/IntExpVar.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IntExpVarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAR=1, RPAR=2, ADD=3, MUL=4, SUB=5, DIV=6, MOD=7, EQUAL=8, SEMICOLON=9, 
		ID=10, VAL=11, NAT=12, NEG=13, WS=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LPAR", "RPAR", "ADD", "MUL", "SUB", "DIV", "MOD", "EQUAL", "SEMICOLON", 
			"ID", "VAL", "NAT", "NEG", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'+'", "'*'", "'-'", "'/'", "'mod'", "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAR", "RPAR", "ADD", "MUL", "SUB", "DIV", "MOD", "EQUAL", "SEMICOLON", 
			"ID", "VAL", "NAT", "NEG", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public IntExpVarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IntExpVar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000eS\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0004"+
		"\t3\b\t\u000b\t\f\t4\u0001\n\u0001\n\u0003\n9\b\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b>\b\u000b\n\u000b\f\u000bA\t\u000b\u0003\u000b"+
		"C\b\u000b\u0001\f\u0001\f\u0001\f\u0005\fH\b\f\n\f\f\fK\t\f\u0001\r\u0004"+
		"\rN\b\r\u000b\r\f\rO\u0001\r\u0001\r\u0000\u0000\u000e\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u0001\u0000\u0004\u0001"+
		"\u0000az\u0001\u000019\u0001\u000009\u0003\u0000\t\n\r\r  X\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000"+
		"\u0000\u0000\u0003\u001f\u0001\u0000\u0000\u0000\u0005!\u0001\u0000\u0000"+
		"\u0000\u0007#\u0001\u0000\u0000\u0000\t%\u0001\u0000\u0000\u0000\u000b"+
		"\'\u0001\u0000\u0000\u0000\r)\u0001\u0000\u0000\u0000\u000f-\u0001\u0000"+
		"\u0000\u0000\u0011/\u0001\u0000\u0000\u0000\u00132\u0001\u0000\u0000\u0000"+
		"\u00158\u0001\u0000\u0000\u0000\u0017B\u0001\u0000\u0000\u0000\u0019D"+
		"\u0001\u0000\u0000\u0000\u001bM\u0001\u0000\u0000\u0000\u001d\u001e\u0005"+
		"(\u0000\u0000\u001e\u0002\u0001\u0000\u0000\u0000\u001f \u0005)\u0000"+
		"\u0000 \u0004\u0001\u0000\u0000\u0000!\"\u0005+\u0000\u0000\"\u0006\u0001"+
		"\u0000\u0000\u0000#$\u0005*\u0000\u0000$\b\u0001\u0000\u0000\u0000%&\u0005"+
		"-\u0000\u0000&\n\u0001\u0000\u0000\u0000\'(\u0005/\u0000\u0000(\f\u0001"+
		"\u0000\u0000\u0000)*\u0005m\u0000\u0000*+\u0005o\u0000\u0000+,\u0005d"+
		"\u0000\u0000,\u000e\u0001\u0000\u0000\u0000-.\u0005=\u0000\u0000.\u0010"+
		"\u0001\u0000\u0000\u0000/0\u0005;\u0000\u00000\u0012\u0001\u0000\u0000"+
		"\u000013\u0007\u0000\u0000\u000021\u0001\u0000\u0000\u000034\u0001\u0000"+
		"\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u00005\u0014"+
		"\u0001\u0000\u0000\u000069\u0003\u0017\u000b\u000079\u0003\u0019\f\u0000"+
		"86\u0001\u0000\u0000\u000087\u0001\u0000\u0000\u00009\u0016\u0001\u0000"+
		"\u0000\u0000:C\u00050\u0000\u0000;?\u0007\u0001\u0000\u0000<>\u0007\u0002"+
		"\u0000\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000B:\u0001\u0000\u0000\u0000B;\u0001\u0000\u0000"+
		"\u0000C\u0018\u0001\u0000\u0000\u0000DE\u0005-\u0000\u0000EI\u0007\u0001"+
		"\u0000\u0000FH\u0007\u0002\u0000\u0000GF\u0001\u0000\u0000\u0000HK\u0001"+
		"\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"J\u001a\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000LN\u0007\u0003"+
		"\u0000\u0000ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"QR\u0006\r\u0000\u0000R\u001c\u0001\u0000\u0000\u0000\u0007\u000048?B"+
		"IO\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}