// Generated from it/univr/pl/IntExpVar.g4 by ANTLR 4.13.2
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
public class IntExpVarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAR=1, RPAR=2, ADD=3, MUL=4, SUB=5, DIV=6, MOD=7, EQUAL=8, SEMICOLON=9, 
		ID=10, VAL=11, NAT=12, NEG=13, WS=14;
	public static final int
		RULE_main = 0, RULE_prog = 1, RULE_init = 2, RULE_exp = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "prog", "init", "exp"
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

	@Override
	public String getGrammarFileName() { return "IntExpVar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IntExpVarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public TerminalNode EOF() { return getToken(IntExpVarParser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitMain(this);
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
			prog();
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
	public static class ProgContext extends ParserRuleContext {
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			init();
			setState(12);
			exp();
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
	public static class InitContext extends ParserRuleContext {
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
	 
		public InitContext() { }
		public void copyFrom(InitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdinitContext extends InitContext {
		public TerminalNode ID() { return getToken(IntExpVarParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(IntExpVarParser.EQUAL, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IntExpVarParser.SEMICOLON, 0); }
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public IdinitContext(InitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitIdinit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NilinitContext extends InitContext {
		public NilinitContext(InitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitNilinit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_init);
		try {
			setState(21);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new IdinitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(ID);
				setState(15);
				match(EQUAL);
				setState(16);
				exp();
				setState(17);
				match(SEMICOLON);
				setState(18);
				init();
				}
				break;
			case 2:
				_localctx = new NilinitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
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
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValContext extends ExpContext {
		public TerminalNode VAL() { return getToken(IntExpVarParser.VAL, 0); }
		public ValContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(IntExpVarParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ADD() { return getToken(IntExpVarParser.ADD, 0); }
		public TerminalNode RPAR() { return getToken(IntExpVarParser.RPAR, 0); }
		public AddContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(IntExpVarParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode DIV() { return getToken(IntExpVarParser.DIV, 0); }
		public TerminalNode RPAR() { return getToken(IntExpVarParser.RPAR, 0); }
		public DivContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(IntExpVarParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode SUB() { return getToken(IntExpVarParser.SUB, 0); }
		public TerminalNode RPAR() { return getToken(IntExpVarParser.RPAR, 0); }
		public SubContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(IntExpVarParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MOD() { return getToken(IntExpVarParser.MOD, 0); }
		public TerminalNode RPAR() { return getToken(IntExpVarParser.RPAR, 0); }
		public ModContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitMod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(IntExpVarParser.LPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MUL() { return getToken(IntExpVarParser.MUL, 0); }
		public TerminalNode RPAR() { return getToken(IntExpVarParser.RPAR, 0); }
		public MulContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExpContext {
		public TerminalNode ID() { return getToken(IntExpVarParser.ID, 0); }
		public IdContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntExpVarVisitor ) return ((IntExpVarVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exp);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ValContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				match(VAL);
				}
				break;
			case 2:
				_localctx = new IdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				match(ID);
				}
				break;
			case 3:
				_localctx = new AddContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(25);
				match(LPAR);
				setState(26);
				exp();
				setState(27);
				match(ADD);
				setState(28);
				exp();
				setState(29);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new MulContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				match(LPAR);
				setState(32);
				exp();
				setState(33);
				match(MUL);
				setState(34);
				exp();
				setState(35);
				match(RPAR);
				}
				break;
			case 5:
				_localctx = new SubContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(37);
				match(LPAR);
				setState(38);
				exp();
				setState(39);
				match(SUB);
				setState(40);
				exp();
				setState(41);
				match(RPAR);
				}
				break;
			case 6:
				_localctx = new DivContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(43);
				match(LPAR);
				setState(44);
				exp();
				setState(45);
				match(DIV);
				setState(46);
				exp();
				setState(47);
				match(RPAR);
				}
				break;
			case 7:
				_localctx = new ModContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(49);
				match(LPAR);
				setState(50);
				exp();
				setState(51);
				match(MOD);
				setState(52);
				exp();
				setState(53);
				match(RPAR);
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

	public static final String _serializedATN =
		"\u0004\u0001\u000e:\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0016"+
		"\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u00038\b\u0003\u0001\u0003\u0000"+
		"\u0000\u0004\u0000\u0002\u0004\u0006\u0000\u0000<\u0000\b\u0001\u0000"+
		"\u0000\u0000\u0002\u000b\u0001\u0000\u0000\u0000\u0004\u0015\u0001\u0000"+
		"\u0000\u0000\u00067\u0001\u0000\u0000\u0000\b\t\u0003\u0002\u0001\u0000"+
		"\t\n\u0005\u0000\u0000\u0001\n\u0001\u0001\u0000\u0000\u0000\u000b\f\u0003"+
		"\u0004\u0002\u0000\f\r\u0003\u0006\u0003\u0000\r\u0003\u0001\u0000\u0000"+
		"\u0000\u000e\u000f\u0005\n\u0000\u0000\u000f\u0010\u0005\b\u0000\u0000"+
		"\u0010\u0011\u0003\u0006\u0003\u0000\u0011\u0012\u0005\t\u0000\u0000\u0012"+
		"\u0013\u0003\u0004\u0002\u0000\u0013\u0016\u0001\u0000\u0000\u0000\u0014"+
		"\u0016\u0001\u0000\u0000\u0000\u0015\u000e\u0001\u0000\u0000\u0000\u0015"+
		"\u0014\u0001\u0000\u0000\u0000\u0016\u0005\u0001\u0000\u0000\u0000\u0017"+
		"8\u0005\u000b\u0000\u0000\u00188\u0005\n\u0000\u0000\u0019\u001a\u0005"+
		"\u0001\u0000\u0000\u001a\u001b\u0003\u0006\u0003\u0000\u001b\u001c\u0005"+
		"\u0003\u0000\u0000\u001c\u001d\u0003\u0006\u0003\u0000\u001d\u001e\u0005"+
		"\u0002\u0000\u0000\u001e8\u0001\u0000\u0000\u0000\u001f \u0005\u0001\u0000"+
		"\u0000 !\u0003\u0006\u0003\u0000!\"\u0005\u0004\u0000\u0000\"#\u0003\u0006"+
		"\u0003\u0000#$\u0005\u0002\u0000\u0000$8\u0001\u0000\u0000\u0000%&\u0005"+
		"\u0001\u0000\u0000&\'\u0003\u0006\u0003\u0000\'(\u0005\u0005\u0000\u0000"+
		"()\u0003\u0006\u0003\u0000)*\u0005\u0002\u0000\u0000*8\u0001\u0000\u0000"+
		"\u0000+,\u0005\u0001\u0000\u0000,-\u0003\u0006\u0003\u0000-.\u0005\u0006"+
		"\u0000\u0000./\u0003\u0006\u0003\u0000/0\u0005\u0002\u0000\u000008\u0001"+
		"\u0000\u0000\u000012\u0005\u0001\u0000\u000023\u0003\u0006\u0003\u0000"+
		"34\u0005\u0007\u0000\u000045\u0003\u0006\u0003\u000056\u0005\u0002\u0000"+
		"\u000068\u0001\u0000\u0000\u00007\u0017\u0001\u0000\u0000\u00007\u0018"+
		"\u0001\u0000\u0000\u00007\u0019\u0001\u0000\u0000\u00007\u001f\u0001\u0000"+
		"\u0000\u00007%\u0001\u0000\u0000\u00007+\u0001\u0000\u0000\u000071\u0001"+
		"\u0000\u0000\u00008\u0007\u0001\u0000\u0000\u0000\u0002\u00157";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}