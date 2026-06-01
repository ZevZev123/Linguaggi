// Generated from it/univr/pl/ExL4.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExL4Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Z=1, O=2;
	public static final int
		RULE_main = 0, RULE_s = 1, RULE_s1 = 2, RULE_s2 = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "s", "s1", "s2"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'0'", "'1'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Z", "O"
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

	@Override
	public String getGrammarFileName() { return "ExL4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExL4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExL4Parser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExL4Visitor ) return ((ExL4Visitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			s();
			setState(9);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SContext extends ParserRuleContext {
		public S1Context s1() {
			return getRuleContext(S1Context.class,0);
		}
		public S2Context s2() {
			return getRuleContext(S2Context.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExL4Visitor ) return ((ExL4Visitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_s);
		try {
			setState(13);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(11);
				s1();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				s2();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class S1Context extends ParserRuleContext {
		public TerminalNode Z() { return getToken(ExL4Parser.Z, 0); }
		public S1Context s1() {
			return getRuleContext(S1Context.class,0);
		}
		public TerminalNode O() { return getToken(ExL4Parser.O, 0); }
		public S1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExL4Visitor ) return ((ExL4Visitor<? extends T>)visitor).visitS1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final S1Context s1() throws RecognitionException {
		S1Context _localctx = new S1Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_s1);
		try {
			setState(20);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Z:
				enterOuterAlt(_localctx, 1);
				{
				setState(15);
				match(Z);
				setState(16);
				s1();
				setState(17);
				match(O);
				}
				break;
			case EOF:
			case O:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class S2Context extends ParserRuleContext {
		public TerminalNode Z() { return getToken(ExL4Parser.Z, 0); }
		public S2Context s2() {
			return getRuleContext(S2Context.class,0);
		}
		public List<TerminalNode> O() { return getTokens(ExL4Parser.O); }
		public TerminalNode O(int i) {
			return getToken(ExL4Parser.O, i);
		}
		public S2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExL4Visitor ) return ((ExL4Visitor<? extends T>)visitor).visitS2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final S2Context s2() throws RecognitionException {
		S2Context _localctx = new S2Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_s2);
		try {
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Z:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(Z);
				setState(23);
				s2();
				setState(24);
				match(O);
				setState(25);
				match(O);
				}
				break;
			case EOF:
			case O:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0002\u001f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001\u000e\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0015\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u001d\b\u0003\u0001\u0003\u0000\u0000\u0004\u0000\u0002\u0004"+
		"\u0006\u0000\u0000\u001d\u0000\b\u0001\u0000\u0000\u0000\u0002\r\u0001"+
		"\u0000\u0000\u0000\u0004\u0014\u0001\u0000\u0000\u0000\u0006\u001c\u0001"+
		"\u0000\u0000\u0000\b\t\u0003\u0002\u0001\u0000\t\n\u0005\u0000\u0000\u0001"+
		"\n\u0001\u0001\u0000\u0000\u0000\u000b\u000e\u0003\u0004\u0002\u0000\f"+
		"\u000e\u0003\u0006\u0003\u0000\r\u000b\u0001\u0000\u0000\u0000\r\f\u0001"+
		"\u0000\u0000\u0000\u000e\u0003\u0001\u0000\u0000\u0000\u000f\u0010\u0005"+
		"\u0001\u0000\u0000\u0010\u0011\u0003\u0004\u0002\u0000\u0011\u0012\u0005"+
		"\u0002\u0000\u0000\u0012\u0015\u0001\u0000\u0000\u0000\u0013\u0015\u0001"+
		"\u0000\u0000\u0000\u0014\u000f\u0001\u0000\u0000\u0000\u0014\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0005\u0001\u0000\u0000\u0000\u0016\u0017\u0005"+
		"\u0001\u0000\u0000\u0017\u0018\u0003\u0006\u0003\u0000\u0018\u0019\u0005"+
		"\u0002\u0000\u0000\u0019\u001a\u0005\u0002\u0000\u0000\u001a\u001d\u0001"+
		"\u0000\u0000\u0000\u001b\u001d\u0001\u0000\u0000\u0000\u001c\u0016\u0001"+
		"\u0000\u0000\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d\u0007\u0001"+
		"\u0000\u0000\u0000\u0003\r\u0014\u001c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}