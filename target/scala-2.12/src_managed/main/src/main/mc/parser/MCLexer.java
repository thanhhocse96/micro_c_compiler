// Generated from src/main/mc/parser/MC.g4 by ANTLR 4.6

	package mc.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MCLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INTTYPE=2, VOIDTYPE=3, ID=4, INTLIT=5, LB=6, RB=7, LP=8, RP=9, 
		SEMI=10, WS=11, ERROR_CHAR=12, UNCLOSE_STRING=13, ILLEGAL_ESCAPE=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "INTTYPE", "VOIDTYPE", "ID", "INTLIT", "LB", "RB", "LP", "RP", 
		"SEMI", "WS", "ERROR_CHAR", "UNCLOSE_STRING", "ILLEGAL_ESCAPE"
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
	public Token emit() {
	    switch (getType()) {
	    case UNCLOSE_STRING:       
	        Token result = super.emit();
	        // you'll need to define this method
	        throw new UncloseString(result.getText());
	        
	    case ILLEGAL_ESCAPE:
	    	result = super.emit();
	    	throw new IllegalEscape(result.getText());

	    case ERROR_CHAR:
	    	result = super.emit();
	    	throw new ErrorToken(result.getText());	

	    default:
	        return super.emit();
	    }
	}


	public MCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\20N\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\6\5/\n\5\r\5\16\5\60\3\6\6\6\64\n\6\r\6"+
		"\16\6\65\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\6\fC\n\f\r\f\16"+
		"\fD\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\5\4\2C\\c|\3\2\62;"+
		"\5\2\13\f\17\17\"\"P\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2"+
		"\2\5$\3\2\2\2\7(\3\2\2\2\t.\3\2\2\2\13\63\3\2\2\2\r\67\3\2\2\2\179\3\2"+
		"\2\2\21;\3\2\2\2\23=\3\2\2\2\25?\3\2\2\2\27B\3\2\2\2\31H\3\2\2\2\33J\3"+
		"\2\2\2\35L\3\2\2\2\37 \7o\2\2 !\7c\2\2!\"\7k\2\2\"#\7p\2\2#\4\3\2\2\2"+
		"$%\7k\2\2%&\7p\2\2&\'\7v\2\2\'\6\3\2\2\2()\7x\2\2)*\7q\2\2*+\7k\2\2+,"+
		"\7f\2\2,\b\3\2\2\2-/\t\2\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3"+
		"\2\2\2\61\n\3\2\2\2\62\64\t\3\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3"+
		"\2\2\2\65\66\3\2\2\2\66\f\3\2\2\2\678\7*\2\28\16\3\2\2\29:\7+\2\2:\20"+
		"\3\2\2\2;<\7}\2\2<\22\3\2\2\2=>\7\177\2\2>\24\3\2\2\2?@\7=\2\2@\26\3\2"+
		"\2\2AC\t\4\2\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\b\f"+
		"\2\2G\30\3\2\2\2HI\13\2\2\2I\32\3\2\2\2JK\13\2\2\2K\34\3\2\2\2LM\13\2"+
		"\2\2M\36\3\2\2\2\6\2\60\65D\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}