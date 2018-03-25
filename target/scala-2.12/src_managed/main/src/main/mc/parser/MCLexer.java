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
		BLOCKCMT=1, LINECMT=2, WS=3, INTTYPE=4, BOOLTYPE=5, FLOATTYPE=6, STRINGTYPE=7, 
		VOIDTYPE=8, TRUE=9, FALSE=10, ID=11, BOOLLIT=12, INTLIT=13, STRINGLIT=14, 
		LB=15, RB=16, LP=17, RP=18, LS=19, RS=20, SEMI=21, DIVOP=22, MULOP=23, 
		MODOP=24, PLUSOP=25, LTOP=26, LTEOP=27, GTOP=28, GTEOP=29, EQUALOP=30, 
		DIFOP=31, ANDOP=32, OROP=33, ASSIGNOP=34, ERROR_CHAR=35, UNCLOSE_STRING=36, 
		ILLEGAL_ESCAPE=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BLOCKCMT", "LINECMT", "WS", "INTTYPE", "BOOLTYPE", "FLOATTYPE", "STRINGTYPE", 
		"VOIDTYPE", "TRUE", "FALSE", "ID", "BOOLLIT", "INTLIT", "ESCAPE", "STRINGLIT", 
		"LB", "RB", "LP", "RP", "LS", "RS", "SEMI", "DIVOP", "MULOP", "MODOP", 
		"PLUSOP", "LTOP", "LTEOP", "GTOP", "GTEOP", "EQUALOP", "DIFOP", "ANDOP", 
		"OROP", "ASSIGNOP", "ERROR_CHAR", "UNCLOSE_STRING", "ILLEGAL_ESCAPE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u00e7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\7\2T\n\2\f"+
		"\2\16\2W\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3b\n\3\f\3\16\3e\13"+
		"\3\3\3\3\3\3\4\6\4j\n\4\r\4\16\4k\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\6\f\u009a\n\f\r\f\16\f\u009b\3\r\3\r\5\r\u00a0\n\r\3\16\6\16\u00a3"+
		"\n\16\r\16\16\16\u00a4\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u00ad\n\20\f"+
		"\20\16\20\u00b0\13\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3"+
		"\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3U\2(\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\20!\21#\22%\23\'"+
		"\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37? A!C\"E#G$I%K"+
		"&M\'\3\2\b\4\2\f\f\17\17\5\2\13\f\17\17\"\"\4\2C\\c|\3\2\62;\7\2\n\f\16"+
		"\17$$))^^\n\2$$))^^ddhhppttvv\u00ed\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5"+
		"]\3\2\2\2\7i\3\2\2\2\to\3\2\2\2\13s\3\2\2\2\r{\3\2\2\2\17\u0081\3\2\2"+
		"\2\21\u0088\3\2\2\2\23\u008d\3\2\2\2\25\u0092\3\2\2\2\27\u0099\3\2\2\2"+
		"\31\u009f\3\2\2\2\33\u00a2\3\2\2\2\35\u00a6\3\2\2\2\37\u00a8\3\2\2\2!"+
		"\u00b3\3\2\2\2#\u00b5\3\2\2\2%\u00b7\3\2\2\2\'\u00b9\3\2\2\2)\u00bb\3"+
		"\2\2\2+\u00bd\3\2\2\2-\u00bf\3\2\2\2/\u00c1\3\2\2\2\61\u00c3\3\2\2\2\63"+
		"\u00c5\3\2\2\2\65\u00c7\3\2\2\2\67\u00c9\3\2\2\29\u00cb\3\2\2\2;\u00ce"+
		"\3\2\2\2=\u00d0\3\2\2\2?\u00d3\3\2\2\2A\u00d6\3\2\2\2C\u00d9\3\2\2\2E"+
		"\u00dc\3\2\2\2G\u00df\3\2\2\2I\u00e1\3\2\2\2K\u00e3\3\2\2\2M\u00e5\3\2"+
		"\2\2OP\7\61\2\2PQ\7,\2\2QU\3\2\2\2RT\13\2\2\2SR\3\2\2\2TW\3\2\2\2UV\3"+
		"\2\2\2US\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7,\2\2YZ\7\61\2\2Z[\3\2\2\2[\\"+
		"\b\2\2\2\\\4\3\2\2\2]^\7\61\2\2^_\7\61\2\2_c\3\2\2\2`b\n\2\2\2a`\3\2\2"+
		"\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\b\3\2\2g\6\3\2"+
		"\2\2hj\t\3\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\b\4"+
		"\2\2n\b\3\2\2\2op\7k\2\2pq\7p\2\2qr\7v\2\2r\n\3\2\2\2st\7d\2\2tu\7q\2"+
		"\2uv\7q\2\2vw\7n\2\2wx\7g\2\2xy\7c\2\2yz\7p\2\2z\f\3\2\2\2{|\7h\2\2|}"+
		"\7n\2\2}~\7q\2\2~\177\7c\2\2\177\u0080\7v\2\2\u0080\16\3\2\2\2\u0081\u0082"+
		"\7u\2\2\u0082\u0083\7v\2\2\u0083\u0084\7t\2\2\u0084\u0085\7k\2\2\u0085"+
		"\u0086\7p\2\2\u0086\u0087\7i\2\2\u0087\20\3\2\2\2\u0088\u0089\7x\2\2\u0089"+
		"\u008a\7q\2\2\u008a\u008b\7k\2\2\u008b\u008c\7f\2\2\u008c\22\3\2\2\2\u008d"+
		"\u008e\7v\2\2\u008e\u008f\7t\2\2\u008f\u0090\7w\2\2\u0090\u0091\7g\2\2"+
		"\u0091\24\3\2\2\2\u0092\u0093\7h\2\2\u0093\u0094\7c\2\2\u0094\u0095\7"+
		"n\2\2\u0095\u0096\7u\2\2\u0096\u0097\7g\2\2\u0097\26\3\2\2\2\u0098\u009a"+
		"\t\4\2\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\30\3\2\2\2\u009d\u00a0\5\23\n\2\u009e\u00a0\5\25"+
		"\13\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\32\3\2\2\2\u00a1\u00a3"+
		"\t\5\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\34\3\2\2\2\u00a6\u00a7\t\6\2\2\u00a7\36\3\2\2\2\u00a8"+
		"\u00ae\7$\2\2\u00a9\u00aa\7^\2\2\u00aa\u00ad\t\7\2\2\u00ab\u00ad\n\6\2"+
		"\2\u00ac\u00a9\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1"+
		"\u00b2\7$\2\2\u00b2 \3\2\2\2\u00b3\u00b4\7*\2\2\u00b4\"\3\2\2\2\u00b5"+
		"\u00b6\7+\2\2\u00b6$\3\2\2\2\u00b7\u00b8\7}\2\2\u00b8&\3\2\2\2\u00b9\u00ba"+
		"\7\177\2\2\u00ba(\3\2\2\2\u00bb\u00bc\7]\2\2\u00bc*\3\2\2\2\u00bd\u00be"+
		"\7_\2\2\u00be,\3\2\2\2\u00bf\u00c0\7=\2\2\u00c0.\3\2\2\2\u00c1\u00c2\7"+
		"\61\2\2\u00c2\60\3\2\2\2\u00c3\u00c4\7,\2\2\u00c4\62\3\2\2\2\u00c5\u00c6"+
		"\7\'\2\2\u00c6\64\3\2\2\2\u00c7\u00c8\7-\2\2\u00c8\66\3\2\2\2\u00c9\u00ca"+
		"\7>\2\2\u00ca8\3\2\2\2\u00cb\u00cc\7>\2\2\u00cc\u00cd\7?\2\2\u00cd:\3"+
		"\2\2\2\u00ce\u00cf\7@\2\2\u00cf<\3\2\2\2\u00d0\u00d1\7@\2\2\u00d1\u00d2"+
		"\7?\2\2\u00d2>\3\2\2\2\u00d3\u00d4\7?\2\2\u00d4\u00d5\7?\2\2\u00d5@\3"+
		"\2\2\2\u00d6\u00d7\7#\2\2\u00d7\u00d8\7?\2\2\u00d8B\3\2\2\2\u00d9\u00da"+
		"\7(\2\2\u00da\u00db\7(\2\2\u00dbD\3\2\2\2\u00dc\u00dd\7~\2\2\u00dd\u00de"+
		"\7~\2\2\u00deF\3\2\2\2\u00df\u00e0\7?\2\2\u00e0H\3\2\2\2\u00e1\u00e2\13"+
		"\2\2\2\u00e2J\3\2\2\2\u00e3\u00e4\13\2\2\2\u00e4L\3\2\2\2\u00e5\u00e6"+
		"\13\2\2\2\u00e6N\3\2\2\2\13\2Uck\u009b\u009f\u00a4\u00ac\u00ae\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}