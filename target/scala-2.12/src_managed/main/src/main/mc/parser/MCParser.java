// Generated from src/main/mc/parser/MC.g4 by ANTLR 4.6

	package mc.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INTTYPE=2, VOIDTYPE=3, ID=4, INTLIT=5, LB=6, RB=7, LP=8, RP=9, 
		SEMI=10, WS=11, ERROR_CHAR=12, UNCLOSE_STRING=13, ILLEGAL_ESCAPE=14;
	public static final int
		RULE_program = 0, RULE_mctype = 1, RULE_body = 2, RULE_exp = 3, RULE_funcall = 4;
	public static final String[] ruleNames = {
		"program", "mctype", "body", "exp", "funcall"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'main'", "'int'", "'void'", null, null, "'('", "')'", "'{'", "'}'", 
		"';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "INTTYPE", "VOIDTYPE", "ID", "INTLIT", "LB", "RB", "LP", "RP", 
		"SEMI", "WS", "ERROR_CHAR", "UNCLOSE_STRING", "ILLEGAL_ESCAPE"
	};
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
	public String getGrammarFileName() { return "MC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public MctypeContext mctype() {
			return getRuleContext(MctypeContext.class,0);
		}
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public TerminalNode LP() { return getToken(MCParser.LP, 0); }
		public TerminalNode RP() { return getToken(MCParser.RP, 0); }
		public TerminalNode EOF() { return getToken(MCParser.EOF, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			mctype();
			setState(11);
			match(T__0);
			setState(12);
			match(LB);
			setState(13);
			match(RB);
			setState(14);
			match(LP);
			setState(16);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(15);
				body();
				}
			}

			setState(18);
			match(RP);
			setState(19);
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

	public static class MctypeContext extends ParserRuleContext {
		public TerminalNode INTTYPE() { return getToken(MCParser.INTTYPE, 0); }
		public TerminalNode VOIDTYPE() { return getToken(MCParser.VOIDTYPE, 0); }
		public MctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mctype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitMctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MctypeContext mctype() throws RecognitionException {
		MctypeContext _localctx = new MctypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mctype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_la = _input.LA(1);
			if ( !(_la==INTTYPE || _la==VOIDTYPE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class BodyContext extends ParserRuleContext {
		public FuncallContext funcall() {
			return getRuleContext(FuncallContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			funcall();
			setState(24);
			match(SEMI);
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

	public static class ExpContext extends ParserRuleContext {
		public FuncallContext funcall() {
			return getRuleContext(FuncallContext.class,0);
		}
		public TerminalNode INTLIT() { return getToken(MCParser.INTLIT, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exp);
		try {
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				funcall();
				}
				break;
			case INTLIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				match(INTLIT);
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

	public static class FuncallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MCParser.ID, 0); }
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public FuncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitFuncall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncallContext funcall() throws RecognitionException {
		FuncallContext _localctx = new FuncallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(ID);
			setState(31);
			match(LB);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID || _la==INTLIT) {
				{
				setState(32);
				exp();
				}
			}

			setState(35);
			match(RB);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20(\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\5\2\23\n\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\5\5\37\n\5\3\6\3\6\3\6\5\6$\n\6\3\6\3"+
		"\6\3\6\2\2\7\2\4\6\b\n\2\3\3\2\4\5%\2\f\3\2\2\2\4\27\3\2\2\2\6\31\3\2"+
		"\2\2\b\36\3\2\2\2\n \3\2\2\2\f\r\5\4\3\2\r\16\7\3\2\2\16\17\7\b\2\2\17"+
		"\20\7\t\2\2\20\22\7\n\2\2\21\23\5\6\4\2\22\21\3\2\2\2\22\23\3\2\2\2\23"+
		"\24\3\2\2\2\24\25\7\13\2\2\25\26\7\2\2\3\26\3\3\2\2\2\27\30\t\2\2\2\30"+
		"\5\3\2\2\2\31\32\5\n\6\2\32\33\7\f\2\2\33\7\3\2\2\2\34\37\5\n\6\2\35\37"+
		"\7\7\2\2\36\34\3\2\2\2\36\35\3\2\2\2\37\t\3\2\2\2 !\7\6\2\2!#\7\b\2\2"+
		"\"$\5\b\5\2#\"\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\7\t\2\2&\13\3\2\2\2\5\22"+
		"\36#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}