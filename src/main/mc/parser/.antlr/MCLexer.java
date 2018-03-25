// Generated from /home/thomasho/Documents/PPL/micro_c_compiler/src/main/mc/parser/MC.g4 by ANTLR 4.7.1

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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BLOCKCMT=1, LINECMT=2, WS=3, INTTYPE=4, BOOLTYPE=5, FLOATTYPE=6, STRINGTYPE=7, 
		VOIDTYPE=8, TRUE=9, FALSE=10, ID=11, BOOLLIT=12, INTLIT=13, LB=14, RB=15, 
		LP=16, RP=17, LS=18, RS=19, SEMI=20, ASSIGN=21, ERROR_CHAR=22, UNCLOSE_STRING=23, 
		ILLEGAL_ESCAPE=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BLOCKCMT", "LINECMT", "WS", "INTTYPE", "BOOLTYPE", "FLOATTYPE", "STRINGTYPE", 
		"VOIDTYPE", "TRUE", "FALSE", "ID", "BOOLLIT", "INTLIT", "LB", "RB", "LP", 
		"RP", "LS", "RS", "SEMI", "ASSIGN", "ERROR_CHAR", "UNCLOSE_STRING", "ILLEGAL_ESCAPE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'int'", "'boolean'", "'float'", "'string'", "'void'", 
		"'true'", "'false'", null, null, null, "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "';'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BLOCKCMT", "LINECMT", "WS", "INTTYPE", "BOOLTYPE", "FLOATTYPE", 
		"STRINGTYPE", "VOIDTYPE", "TRUE", "FALSE", "ID", "BOOLLIT", "INTLIT", 
		"LB", "RB", "LP", "RP", "LS", "RS", "SEMI", "ASSIGN", "ERROR_CHAR", "UNCLOSE_STRING", 
		"ILLEGAL_ESCAPE"
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
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00a0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\7\3F\n\3\f\3\16\3I\13\3\3\3\3\3\3\4\6\4N\n\4\r\4\16\4O\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\6\f~\n\f\r\f\16\f\177\3\r\3\r"+
		"\5\r\u0084\n\r\3\16\6\16\u0087\n\16\r\16\16\16\u0088\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\39\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\3\2\6\4\2\f\f\17\17\5\2\13\f\17\17\"\"\4\2C\\c|\3\2\62;\2\u00a5"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\3\63\3\2\2\2\5A\3\2\2\2\7M\3\2\2\2\tS\3\2\2\2\13W\3\2"+
		"\2\2\r_\3\2\2\2\17e\3\2\2\2\21l\3\2\2\2\23q\3\2\2\2\25v\3\2\2\2\27}\3"+
		"\2\2\2\31\u0083\3\2\2\2\33\u0086\3\2\2\2\35\u008a\3\2\2\2\37\u008c\3\2"+
		"\2\2!\u008e\3\2\2\2#\u0090\3\2\2\2%\u0092\3\2\2\2\'\u0094\3\2\2\2)\u0096"+
		"\3\2\2\2+\u0098\3\2\2\2-\u009a\3\2\2\2/\u009c\3\2\2\2\61\u009e\3\2\2\2"+
		"\63\64\7\61\2\2\64\65\7,\2\2\659\3\2\2\2\668\13\2\2\2\67\66\3\2\2\28;"+
		"\3\2\2\29:\3\2\2\29\67\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7,\2\2=>\7\61\2\2"+
		">?\3\2\2\2?@\b\2\2\2@\4\3\2\2\2AB\7\61\2\2BC\7\61\2\2CG\3\2\2\2DF\n\2"+
		"\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\b\3"+
		"\2\2K\6\3\2\2\2LN\t\3\2\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PQ\3"+
		"\2\2\2QR\b\4\2\2R\b\3\2\2\2ST\7k\2\2TU\7p\2\2UV\7v\2\2V\n\3\2\2\2WX\7"+
		"d\2\2XY\7q\2\2YZ\7q\2\2Z[\7n\2\2[\\\7g\2\2\\]\7c\2\2]^\7p\2\2^\f\3\2\2"+
		"\2_`\7h\2\2`a\7n\2\2ab\7q\2\2bc\7c\2\2cd\7v\2\2d\16\3\2\2\2ef\7u\2\2f"+
		"g\7v\2\2gh\7t\2\2hi\7k\2\2ij\7p\2\2jk\7i\2\2k\20\3\2\2\2lm\7x\2\2mn\7"+
		"q\2\2no\7k\2\2op\7f\2\2p\22\3\2\2\2qr\7v\2\2rs\7t\2\2st\7w\2\2tu\7g\2"+
		"\2u\24\3\2\2\2vw\7h\2\2wx\7c\2\2xy\7n\2\2yz\7u\2\2z{\7g\2\2{\26\3\2\2"+
		"\2|~\t\4\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\30\3\2\2\2\u0081\u0084\5\23\n\2\u0082\u0084\5\25\13\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0082\3\2\2\2\u0084\32\3\2\2\2\u0085\u0087\t\5\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\34\3\2\2\2\u008a\u008b\7*\2\2\u008b\36\3\2\2\2\u008c\u008d\7+\2\2\u008d"+
		" \3\2\2\2\u008e\u008f\7}\2\2\u008f\"\3\2\2\2\u0090\u0091\7\177\2\2\u0091"+
		"$\3\2\2\2\u0092\u0093\7]\2\2\u0093&\3\2\2\2\u0094\u0095\7_\2\2\u0095("+
		"\3\2\2\2\u0096\u0097\7=\2\2\u0097*\3\2\2\2\u0098\u0099\7?\2\2\u0099,\3"+
		"\2\2\2\u009a\u009b\13\2\2\2\u009b.\3\2\2\2\u009c\u009d\13\2\2\2\u009d"+
		"\60\3\2\2\2\u009e\u009f\13\2\2\2\u009f\62\3\2\2\2\t\29GO\177\u0083\u0088"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}