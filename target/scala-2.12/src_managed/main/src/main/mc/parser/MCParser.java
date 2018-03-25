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
		BLOCKCMT=1, LINECMT=2, WS=3, INTTYPE=4, BOOLTYPE=5, FLOATTYPE=6, STRINGTYPE=7, 
		VOIDTYPE=8, TRUE=9, FALSE=10, ID=11, BOOLLIT=12, INTLIT=13, STRINGLIT=14, 
		LB=15, RB=16, LP=17, RP=18, LS=19, RS=20, SEMI=21, DIVOP=22, MULOP=23, 
		MODOP=24, PLUSOP=25, LTOP=26, LTEOP=27, GTOP=28, GTEOP=29, EQUALOP=30, 
		DIFOP=31, ANDOP=32, OROP=33, ASSIGNOP=34, ERROR_CHAR=35, UNCLOSE_STRING=36, 
		ILLEGAL_ESCAPE=37;
	public static final int
		RULE_program = 0;
	public static final String[] ruleNames = {
		"program"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'int'", "'boolean'", "'float'", "'string'", "'void'", 
		"'true'", "'false'", null, null, null, null, "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "';'", "'/'", "'*'", "'%'", "'+'", "'<'", "'<='", "'>'", 
		"'>='", "'=='", "'!='", "'&&'", "'||'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BLOCKCMT", "LINECMT", "WS", "INTTYPE", "BOOLTYPE", "FLOATTYPE", 
		"STRINGTYPE", "VOIDTYPE", "TRUE", "FALSE", "ID", "BOOLLIT", "INTLIT", 
		"STRINGLIT", "LB", "RB", "LP", "RP", "LS", "RS", "SEMI", "DIVOP", "MULOP", 
		"MODOP", "PLUSOP", "LTOP", "LTEOP", "GTOP", "GTEOP", "EQUALOP", "DIFOP", 
		"ANDOP", "OROP", "ASSIGNOP", "ERROR_CHAR", "UNCLOSE_STRING", "ILLEGAL_ESCAPE"
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			matchWildcard();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\7\4\2\t\2\3\2\3"+
		"\2\3\2\2\2\3\2\2\2\5\2\4\3\2\2\2\4\5\13\2\2\2\5\3\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}