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
		VOIDTYPE=8, BREAK=9, CONTINUE=10, IF=11, ELSE=12, FOR=13, RETURN=14, WHILE=15, 
		DO=16, BOOLLIT=17, TRUE=18, FALSE=19, INTLIT=20, FLOATLIT=21, STRINGLIT=22, 
		ID=23, LB=24, RB=25, LP=26, RP=27, LS=28, RS=29, SEMI=30, DIVOP=31, MULOP=32, 
		MODOP=33, ADDOP=34, SUBOP=35, LTOP=36, LTEOP=37, GTOP=38, GTEOP=39, EQUALOP=40, 
		NEQUALOP=41, ANDOP=42, OROP=43, ASSIGNOP=44, UNCLOSE_STRING=45, ILLEGAL_ESCAPE=46, 
		ERROR_CHAR=47;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BLOCKCMT", "LINECMT", "WS", "INTTYPE", "BOOLTYPE", "FLOATTYPE", "STRINGTYPE", 
		"VOIDTYPE", "BREAK", "CONTINUE", "IF", "ELSE", "FOR", "RETURN", "WHILE", 
		"DO", "BOOLLIT", "TRUE", "FALSE", "DIGITS", "INTLIT", "EXP", "FRACTION", 
		"FLOATLIT", "ESCAPE", "STRINGLIT", "ID", "LB", "RB", "LP", "RP", "LS", 
		"RS", "SEMI", "DIVOP", "MULOP", "MODOP", "ADDOP", "SUBOP", "LTOP", "LTEOP", 
		"GTOP", "GTEOP", "EQUALOP", "NEQUALOP", "ANDOP", "OROP", "ASSIGNOP", "UNCLOSE_STRING", 
		"ILLEGAL_ESCAPE", "ERROR_CHAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'int'", "'boolean'", "'float'", "'string'", "'void'", 
		"'break'", "'continue'", "'if'", "'else'", "'for'", "'return'", "'while'", 
		"'do'", null, "'true'", "'false'", null, null, null, null, "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "';'", "'/'", "'*'", "'%'", "'+'", "'-'", 
		"'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BLOCKCMT", "LINECMT", "WS", "INTTYPE", "BOOLTYPE", "FLOATTYPE", 
		"STRINGTYPE", "VOIDTYPE", "BREAK", "CONTINUE", "IF", "ELSE", "FOR", "RETURN", 
		"WHILE", "DO", "BOOLLIT", "TRUE", "FALSE", "INTLIT", "FLOATLIT", "STRINGLIT", 
		"ID", "LB", "RB", "LP", "RP", "LS", "RS", "SEMI", "DIVOP", "MULOP", "MODOP", 
		"ADDOP", "SUBOP", "LTOP", "LTEOP", "GTOP", "GTEOP", "EQUALOP", "NEQUALOP", 
		"ANDOP", "OROP", "ASSIGNOP", "UNCLOSE_STRING", "ILLEGAL_ESCAPE", "ERROR_CHAR"
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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 25:
			STRINGLIT_action((RuleContext)_localctx, actionIndex);
			break;
		case 48:
			UNCLOSE_STRING_action((RuleContext)_localctx, actionIndex);
			break;
		case 49:
			ILLEGAL_ESCAPE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRINGLIT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			setText(getText().substring(1, getText().length()-1));
			break;
		}
	}
	private void UNCLOSE_STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			setText(getText().substring(1, getText().length()));
			break;
		}
	}
	private void ILLEGAL_ESCAPE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			setText(getText().substring(1, getText().length()));
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\61\u016a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\2\3\2\7\2n\n\2\f\2\16\2q\13\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\7\3|\n\3\f\3\16\3\177\13\3\3\3\3\3\3\4\6\4\u0084\n\4\r\4"+
		"\16\4\u0085\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3"+
		"\22\5\22\u00d5\n\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\26\6\26\u00e5\n\26\r\26\16\26\u00e6\3\27\3\27\5\27\u00eb"+
		"\n\27\3\27\6\27\u00ee\n\27\r\27\16\27\u00ef\3\30\6\30\u00f3\n\30\r\30"+
		"\16\30\u00f4\3\30\3\30\7\30\u00f9\n\30\f\30\16\30\u00fc\13\30\3\30\7\30"+
		"\u00ff\n\30\f\30\16\30\u0102\13\30\3\30\3\30\6\30\u0106\n\30\r\30\16\30"+
		"\u0107\5\30\u010a\n\30\3\31\3\31\5\31\u010e\n\31\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\7\33\u0116\n\33\f\33\16\33\u0119\13\33\3\33\3\33\3\33\3\34\6"+
		"\34\u011f\n\34\r\34\16\34\u0120\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3"+
		"!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3"+
		"+\3,\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\62\3\62\6\62\u0157\n\62\r\62\16\62\u0158\3\62\3\62\3\63\3\63\3\63"+
		"\3\63\7\63\u0161\n\63\f\63\16\63\u0164\13\63\3\63\3\63\3\63\3\64\3\64"+
		"\3o\2\65\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\2+\26-\2/\2\61\27\63\2\65\30\67\319\32"+
		";\33=\34?\35A\36C\37E G!I\"K#M$O%Q&S\'U(W)Y*[+],_-a.c/e\60g\61\3\2\t\4"+
		"\2\f\f\17\17\5\2\13\f\17\17\"\"\3\2\62;\4\2GGgg\7\2\n\f\16\17$$))^^\n"+
		"\2$$))^^ddhhppttvv\4\2C\\c|\u0179\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2+\3\2\2"+
		"\2\2\61\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2"+
		"\2\2\2e\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5w\3\2\2\2\7\u0083\3\2\2\2\t\u0089"+
		"\3\2\2\2\13\u008d\3\2\2\2\r\u0095\3\2\2\2\17\u009b\3\2\2\2\21\u00a2\3"+
		"\2\2\2\23\u00a7\3\2\2\2\25\u00ad\3\2\2\2\27\u00b6\3\2\2\2\31\u00b9\3\2"+
		"\2\2\33\u00be\3\2\2\2\35\u00c2\3\2\2\2\37\u00c9\3\2\2\2!\u00cf\3\2\2\2"+
		"#\u00d4\3\2\2\2%\u00d6\3\2\2\2\'\u00db\3\2\2\2)\u00e1\3\2\2\2+\u00e4\3"+
		"\2\2\2-\u00e8\3\2\2\2/\u0109\3\2\2\2\61\u010b\3\2\2\2\63\u010f\3\2\2\2"+
		"\65\u0111\3\2\2\2\67\u011e\3\2\2\29\u0122\3\2\2\2;\u0124\3\2\2\2=\u0126"+
		"\3\2\2\2?\u0128\3\2\2\2A\u012a\3\2\2\2C\u012c\3\2\2\2E\u012e\3\2\2\2G"+
		"\u0130\3\2\2\2I\u0132\3\2\2\2K\u0134\3\2\2\2M\u0136\3\2\2\2O\u0138\3\2"+
		"\2\2Q\u013a\3\2\2\2S\u013c\3\2\2\2U\u013f\3\2\2\2W\u0141\3\2\2\2Y\u0144"+
		"\3\2\2\2[\u0147\3\2\2\2]\u014a\3\2\2\2_\u014d\3\2\2\2a\u0150\3\2\2\2c"+
		"\u0152\3\2\2\2e\u015c\3\2\2\2g\u0168\3\2\2\2ij\7\61\2\2jk\7,\2\2ko\3\2"+
		"\2\2ln\13\2\2\2ml\3\2\2\2nq\3\2\2\2op\3\2\2\2om\3\2\2\2pr\3\2\2\2qo\3"+
		"\2\2\2rs\7,\2\2st\7\61\2\2tu\3\2\2\2uv\b\2\2\2v\4\3\2\2\2wx\7\61\2\2x"+
		"y\7\61\2\2y}\3\2\2\2z|\n\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2"+
		"\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\b\3\2\2\u0081\6\3\2\2\2\u0082"+
		"\u0084\t\3\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2"+
		"\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\b\4\2\2\u0088"+
		"\b\3\2\2\2\u0089\u008a\7k\2\2\u008a\u008b\7p\2\2\u008b\u008c\7v\2\2\u008c"+
		"\n\3\2\2\2\u008d\u008e\7d\2\2\u008e\u008f\7q\2\2\u008f\u0090\7q\2\2\u0090"+
		"\u0091\7n\2\2\u0091\u0092\7g\2\2\u0092\u0093\7c\2\2\u0093\u0094\7p\2\2"+
		"\u0094\f\3\2\2\2\u0095\u0096\7h\2\2\u0096\u0097\7n\2\2\u0097\u0098\7q"+
		"\2\2\u0098\u0099\7c\2\2\u0099\u009a\7v\2\2\u009a\16\3\2\2\2\u009b\u009c"+
		"\7u\2\2\u009c\u009d\7v\2\2\u009d\u009e\7t\2\2\u009e\u009f\7k\2\2\u009f"+
		"\u00a0\7p\2\2\u00a0\u00a1\7i\2\2\u00a1\20\3\2\2\2\u00a2\u00a3\7x\2\2\u00a3"+
		"\u00a4\7q\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7f\2\2\u00a6\22\3\2\2\2\u00a7"+
		"\u00a8\7d\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7c\2\2"+
		"\u00ab\u00ac\7m\2\2\u00ac\24\3\2\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7"+
		"q\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3"+
		"\7p\2\2\u00b3\u00b4\7w\2\2\u00b4\u00b5\7g\2\2\u00b5\26\3\2\2\2\u00b6\u00b7"+
		"\7k\2\2\u00b7\u00b8\7h\2\2\u00b8\30\3\2\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb"+
		"\7n\2\2\u00bb\u00bc\7u\2\2\u00bc\u00bd\7g\2\2\u00bd\32\3\2\2\2\u00be\u00bf"+
		"\7h\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1\7t\2\2\u00c1\34\3\2\2\2\u00c2\u00c3"+
		"\7t\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7w\2\2\u00c6"+
		"\u00c7\7t\2\2\u00c7\u00c8\7p\2\2\u00c8\36\3\2\2\2\u00c9\u00ca\7y\2\2\u00ca"+
		"\u00cb\7j\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7g\2\2"+
		"\u00ce \3\2\2\2\u00cf\u00d0\7f\2\2\u00d0\u00d1\7q\2\2\u00d1\"\3\2\2\2"+
		"\u00d2\u00d5\5%\23\2\u00d3\u00d5\5\'\24\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3"+
		"\3\2\2\2\u00d5$\3\2\2\2\u00d6\u00d7\7v\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9"+
		"\7w\2\2\u00d9\u00da\7g\2\2\u00da&\3\2\2\2\u00db\u00dc\7h\2\2\u00dc\u00dd"+
		"\7c\2\2\u00dd\u00de\7n\2\2\u00de\u00df\7u\2\2\u00df\u00e0\7g\2\2\u00e0"+
		"(\3\2\2\2\u00e1\u00e2\t\4\2\2\u00e2*\3\2\2\2\u00e3\u00e5\5)\25\2\u00e4"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7,\3\2\2\2\u00e8\u00ea\t\5\2\2\u00e9\u00eb\7/\2\2\u00ea\u00e9"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ee\5)\25\2\u00ed"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0.\3\2\2\2\u00f1\u00f3\5)\25\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00fa\7\60\2\2\u00f7\u00f9\5)\25\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3"+
		"\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u010a\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fd\u00ff\5)\25\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2"+
		"\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0103\u0105\7\60\2\2\u0104\u0106\5)\25\2\u0105\u0104\3"+
		"\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u010a\3\2\2\2\u0109\u00f2\3\2\2\2\u0109\u0100\3\2\2\2\u010a\60\3\2\2"+
		"\2\u010b\u010d\5/\30\2\u010c\u010e\5-\27\2\u010d\u010c\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e\62\3\2\2\2\u010f\u0110\t\6\2\2\u0110\64\3\2\2\2\u0111\u0117"+
		"\7$\2\2\u0112\u0113\7^\2\2\u0113\u0116\t\7\2\2\u0114\u0116\n\6\2\2\u0115"+
		"\u0112\3\2\2\2\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2"+
		"\2\2\u0117\u0118\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a"+
		"\u011b\7$\2\2\u011b\u011c\b\33\3\2\u011c\66\3\2\2\2\u011d\u011f\t\b\2"+
		"\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u01218\3\2\2\2\u0122\u0123\7*\2\2\u0123:\3\2\2\2\u0124\u0125"+
		"\7+\2\2\u0125<\3\2\2\2\u0126\u0127\7}\2\2\u0127>\3\2\2\2\u0128\u0129\7"+
		"\177\2\2\u0129@\3\2\2\2\u012a\u012b\7]\2\2\u012bB\3\2\2\2\u012c\u012d"+
		"\7_\2\2\u012dD\3\2\2\2\u012e\u012f\7=\2\2\u012fF\3\2\2\2\u0130\u0131\7"+
		"\61\2\2\u0131H\3\2\2\2\u0132\u0133\7,\2\2\u0133J\3\2\2\2\u0134\u0135\7"+
		"\'\2\2\u0135L\3\2\2\2\u0136\u0137\7-\2\2\u0137N\3\2\2\2\u0138\u0139\7"+
		"/\2\2\u0139P\3\2\2\2\u013a\u013b\7>\2\2\u013bR\3\2\2\2\u013c\u013d\7>"+
		"\2\2\u013d\u013e\7?\2\2\u013eT\3\2\2\2\u013f\u0140\7@\2\2\u0140V\3\2\2"+
		"\2\u0141\u0142\7@\2\2\u0142\u0143\7?\2\2\u0143X\3\2\2\2\u0144\u0145\7"+
		"?\2\2\u0145\u0146\7?\2\2\u0146Z\3\2\2\2\u0147\u0148\7#\2\2\u0148\u0149"+
		"\7?\2\2\u0149\\\3\2\2\2\u014a\u014b\7(\2\2\u014b\u014c\7(\2\2\u014c^\3"+
		"\2\2\2\u014d\u014e\7~\2\2\u014e\u014f\7~\2\2\u014f`\3\2\2\2\u0150\u0151"+
		"\7?\2\2\u0151b\3\2\2\2\u0152\u0156\7$\2\2\u0153\u0154\7^\2\2\u0154\u0157"+
		"\t\7\2\2\u0155\u0157\n\6\2\2\u0156\u0153\3\2\2\2\u0156\u0155\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3\2"+
		"\2\2\u015a\u015b\b\62\4\2\u015bd\3\2\2\2\u015c\u0162\7$\2\2\u015d\u015e"+
		"\7^\2\2\u015e\u0161\t\7\2\2\u015f\u0161\n\6\2\2\u0160\u015d\3\2\2\2\u0160"+
		"\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2"+
		"\2\2\u0163\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\t\6\2\2\u0166"+
		"\u0167\b\63\5\2\u0167f\3\2\2\2\u0168\u0169\13\2\2\2\u0169h\3\2\2\2\27"+
		"\2o}\u0085\u00d4\u00e6\u00ea\u00ef\u00f4\u00fa\u0100\u0107\u0109\u010d"+
		"\u0115\u0117\u0120\u0156\u0158\u0160\u0162\6\b\2\2\3\33\2\3\62\3\3\63"+
		"\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}