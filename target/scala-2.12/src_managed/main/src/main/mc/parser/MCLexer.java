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
		DO=16, BOOLLIT=17, TRUE=18, FALSE=19, FLOATLIT=20, INTLIT=21, STRINGLIT=22, 
		ID=23, LB=24, RB=25, LP=26, RP=27, LS=28, RS=29, SEMI=30, COMMA=31, NEVOP=32, 
		DIVOP=33, MULOP=34, MODOP=35, ADDOP=36, SUBOP=37, LTOP=38, LTEOP=39, GTOP=40, 
		GTEOP=41, EQUALOP=42, NEQUALOP=43, ANDOP=44, OROP=45, ASSIGNOP=46, UNCLOSE_STRING=47, 
		ILLEGAL_ESCAPE=48, ERROR_CHAR=49;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BLOCKCMT", "LINECMT", "WS", "INTTYPE", "BOOLTYPE", "FLOATTYPE", "STRINGTYPE", 
		"VOIDTYPE", "BREAK", "CONTINUE", "IF", "ELSE", "FOR", "RETURN", "WHILE", 
		"DO", "BOOLLIT", "TRUE", "FALSE", "DIGITS", "EXP", "FRACTION", "FLOATLIT", 
		"INTLIT", "ESCAPE", "STRINGLIT", "ID", "LB", "RB", "LP", "RP", "LS", "RS", 
		"SEMI", "COMMA", "NEVOP", "DIVOP", "MULOP", "MODOP", "ADDOP", "SUBOP", 
		"LTOP", "LTEOP", "GTOP", "GTEOP", "EQUALOP", "NEQUALOP", "ANDOP", "OROP", 
		"ASSIGNOP", "UNCLOSE_STRING", "ILLEGAL_ESCAPE", "ERROR_CHAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'int'", "'boolean'", "'float'", "'string'", "'void'", 
		"'break'", "'continue'", "'if'", "'else'", "'for'", "'return'", "'while'", 
		"'do'", null, "'true'", "'false'", null, null, null, null, "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "';'", "','", "'!'", "'/'", "'*'", "'%'", 
		"'+'", "'-'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", 
		"'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BLOCKCMT", "LINECMT", "WS", "INTTYPE", "BOOLTYPE", "FLOATTYPE", 
		"STRINGTYPE", "VOIDTYPE", "BREAK", "CONTINUE", "IF", "ELSE", "FOR", "RETURN", 
		"WHILE", "DO", "BOOLLIT", "TRUE", "FALSE", "FLOATLIT", "INTLIT", "STRINGLIT", 
		"ID", "LB", "RB", "LP", "RP", "LS", "RS", "SEMI", "COMMA", "NEVOP", "DIVOP", 
		"MULOP", "MODOP", "ADDOP", "SUBOP", "LTOP", "LTEOP", "GTOP", "GTEOP", 
		"EQUALOP", "NEQUALOP", "ANDOP", "OROP", "ASSIGNOP", "UNCLOSE_STRING", 
		"ILLEGAL_ESCAPE", "ERROR_CHAR"
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
		case 50:
			UNCLOSE_STRING_action((RuleContext)_localctx, actionIndex);
			break;
		case 51:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\63\u017d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\2\7\2r\n\2\f\2\16\2u\13\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u0080\n\3\f\3\16\3\u0083\13\3\3\3"+
		"\3\3\3\4\6\4\u0088\n\4\r\4\16\4\u0089\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\22\3\22\5\22\u00d9\n\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\5\26\u00ea\n\26\3\26"+
		"\6\26\u00ed\n\26\r\26\16\26\u00ee\3\27\6\27\u00f2\n\27\r\27\16\27\u00f3"+
		"\3\27\3\27\7\27\u00f8\n\27\f\27\16\27\u00fb\13\27\3\27\7\27\u00fe\n\27"+
		"\f\27\16\27\u0101\13\27\3\27\3\27\6\27\u0105\n\27\r\27\16\27\u0106\5\27"+
		"\u0109\n\27\3\30\3\30\5\30\u010d\n\30\3\30\6\30\u0110\n\30\r\30\16\30"+
		"\u0111\3\30\3\30\5\30\u0116\n\30\3\31\6\31\u0119\n\31\r\31\16\31\u011a"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u0123\n\33\f\33\16\33\u0126\13\33"+
		"\3\33\3\33\3\33\3\34\3\34\7\34\u012d\n\34\f\34\16\34\u0130\13\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&"+
		"\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64"+
		"\6\64\u016a\n\64\r\64\16\64\u016b\3\64\3\64\3\65\3\65\3\65\3\65\7\65\u0174"+
		"\n\65\f\65\16\65\u0177\13\65\3\65\3\65\3\65\3\66\3\66\3s\2\67\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\2+\2-\2/\26\61\27\63\2\65\30\67\319\32;\33=\34?\35A\36"+
		"C\37E G!I\"K#M$O%Q&S\'U(W)Y*[+],_-a.c/e\60g\61i\62k\63\3\2\n\4\2\f\f\17"+
		"\17\5\2\13\f\17\17\"\"\3\2\62;\4\2GGgg\7\2\n\f\16\17$$))^^\n\2$$))^^d"+
		"dhhppttvv\5\2C\\aac|\6\2\62;C\\aac|\u018e\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\3m\3\2\2\2\5"+
		"{\3\2\2\2\7\u0087\3\2\2\2\t\u008d\3\2\2\2\13\u0091\3\2\2\2\r\u0099\3\2"+
		"\2\2\17\u009f\3\2\2\2\21\u00a6\3\2\2\2\23\u00ab\3\2\2\2\25\u00b1\3\2\2"+
		"\2\27\u00ba\3\2\2\2\31\u00bd\3\2\2\2\33\u00c2\3\2\2\2\35\u00c6\3\2\2\2"+
		"\37\u00cd\3\2\2\2!\u00d3\3\2\2\2#\u00d8\3\2\2\2%\u00da\3\2\2\2\'\u00df"+
		"\3\2\2\2)\u00e5\3\2\2\2+\u00e7\3\2\2\2-\u0108\3\2\2\2/\u0115\3\2\2\2\61"+
		"\u0118\3\2\2\2\63\u011c\3\2\2\2\65\u011e\3\2\2\2\67\u012a\3\2\2\29\u0131"+
		"\3\2\2\2;\u0133\3\2\2\2=\u0135\3\2\2\2?\u0137\3\2\2\2A\u0139\3\2\2\2C"+
		"\u013b\3\2\2\2E\u013d\3\2\2\2G\u013f\3\2\2\2I\u0141\3\2\2\2K\u0143\3\2"+
		"\2\2M\u0145\3\2\2\2O\u0147\3\2\2\2Q\u0149\3\2\2\2S\u014b\3\2\2\2U\u014d"+
		"\3\2\2\2W\u014f\3\2\2\2Y\u0152\3\2\2\2[\u0154\3\2\2\2]\u0157\3\2\2\2_"+
		"\u015a\3\2\2\2a\u015d\3\2\2\2c\u0160\3\2\2\2e\u0163\3\2\2\2g\u0165\3\2"+
		"\2\2i\u016f\3\2\2\2k\u017b\3\2\2\2mn\7\61\2\2no\7,\2\2os\3\2\2\2pr\13"+
		"\2\2\2qp\3\2\2\2ru\3\2\2\2st\3\2\2\2sq\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7"+
		",\2\2wx\7\61\2\2xy\3\2\2\2yz\b\2\2\2z\4\3\2\2\2{|\7\61\2\2|}\7\61\2\2"+
		"}\u0081\3\2\2\2~\u0080\n\2\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2"+
		"\2\u0084\u0085\b\3\2\2\u0085\6\3\2\2\2\u0086\u0088\t\3\2\2\u0087\u0086"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\b\4\2\2\u008c\b\3\2\2\2\u008d\u008e\7k\2\2"+
		"\u008e\u008f\7p\2\2\u008f\u0090\7v\2\2\u0090\n\3\2\2\2\u0091\u0092\7d"+
		"\2\2\u0092\u0093\7q\2\2\u0093\u0094\7q\2\2\u0094\u0095\7n\2\2\u0095\u0096"+
		"\7g\2\2\u0096\u0097\7c\2\2\u0097\u0098\7p\2\2\u0098\f\3\2\2\2\u0099\u009a"+
		"\7h\2\2\u009a\u009b\7n\2\2\u009b\u009c\7q\2\2\u009c\u009d\7c\2\2\u009d"+
		"\u009e\7v\2\2\u009e\16\3\2\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7v\2\2\u00a1"+
		"\u00a2\7t\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7p\2\2\u00a4\u00a5\7i\2\2"+
		"\u00a5\20\3\2\2\2\u00a6\u00a7\7x\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7"+
		"k\2\2\u00a9\u00aa\7f\2\2\u00aa\22\3\2\2\2\u00ab\u00ac\7d\2\2\u00ac\u00ad"+
		"\7t\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7m\2\2\u00b0"+
		"\24\3\2\2\2\u00b1\u00b2\7e\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7p\2\2\u00b4"+
		"\u00b5\7v\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7p\2\2\u00b7\u00b8\7w\2\2"+
		"\u00b8\u00b9\7g\2\2\u00b9\26\3\2\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7"+
		"h\2\2\u00bc\30\3\2\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0"+
		"\7u\2\2\u00c0\u00c1\7g\2\2\u00c1\32\3\2\2\2\u00c2\u00c3\7h\2\2\u00c3\u00c4"+
		"\7q\2\2\u00c4\u00c5\7t\2\2\u00c5\34\3\2\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8"+
		"\7g\2\2\u00c8\u00c9\7v\2\2\u00c9\u00ca\7w\2\2\u00ca\u00cb\7t\2\2\u00cb"+
		"\u00cc\7p\2\2\u00cc\36\3\2\2\2\u00cd\u00ce\7y\2\2\u00ce\u00cf\7j\2\2\u00cf"+
		"\u00d0\7k\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7g\2\2\u00d2 \3\2\2\2\u00d3"+
		"\u00d4\7f\2\2\u00d4\u00d5\7q\2\2\u00d5\"\3\2\2\2\u00d6\u00d9\5%\23\2\u00d7"+
		"\u00d9\5\'\24\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9$\3\2\2\2"+
		"\u00da\u00db\7v\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de"+
		"\7g\2\2\u00de&\3\2\2\2\u00df\u00e0\7h\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2"+
		"\7n\2\2\u00e2\u00e3\7u\2\2\u00e3\u00e4\7g\2\2\u00e4(\3\2\2\2\u00e5\u00e6"+
		"\t\4\2\2\u00e6*\3\2\2\2\u00e7\u00e9\t\5\2\2\u00e8\u00ea\7/\2\2\u00e9\u00e8"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00ed\5)\25\2\u00ec"+
		"\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2"+
		"\2\2\u00ef,\3\2\2\2\u00f0\u00f2\5)\25\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f9\7\60\2\2\u00f6\u00f8\5)\25\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3"+
		"\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u0109\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fc\u00fe\5)\25\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2"+
		"\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0102\u0104\7\60\2\2\u0103\u0105\5)\25\2\u0104\u0103\3"+
		"\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u0109\3\2\2\2\u0108\u00f1\3\2\2\2\u0108\u00ff\3\2\2\2\u0109.\3\2\2\2"+
		"\u010a\u010c\5-\27\2\u010b\u010d\5+\26\2\u010c\u010b\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u0116\3\2\2\2\u010e\u0110\5)\25\2\u010f\u010e\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\u0114\5+\26\2\u0114\u0116\3\2\2\2\u0115\u010a\3\2\2\2\u0115"+
		"\u010f\3\2\2\2\u0116\60\3\2\2\2\u0117\u0119\5)\25\2\u0118\u0117\3\2\2"+
		"\2\u0119\u011a\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\62"+
		"\3\2\2\2\u011c\u011d\t\6\2\2\u011d\64\3\2\2\2\u011e\u0124\7$\2\2\u011f"+
		"\u0120\7^\2\2\u0120\u0123\t\7\2\2\u0121\u0123\n\6\2\2\u0122\u011f\3\2"+
		"\2\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128\7$"+
		"\2\2\u0128\u0129\b\33\3\2\u0129\66\3\2\2\2\u012a\u012e\t\b\2\2\u012b\u012d"+
		"\t\t\2\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f8\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\7*\2\2\u0132"+
		":\3\2\2\2\u0133\u0134\7+\2\2\u0134<\3\2\2\2\u0135\u0136\7}\2\2\u0136>"+
		"\3\2\2\2\u0137\u0138\7\177\2\2\u0138@\3\2\2\2\u0139\u013a\7]\2\2\u013a"+
		"B\3\2\2\2\u013b\u013c\7_\2\2\u013cD\3\2\2\2\u013d\u013e\7=\2\2\u013eF"+
		"\3\2\2\2\u013f\u0140\7.\2\2\u0140H\3\2\2\2\u0141\u0142\7#\2\2\u0142J\3"+
		"\2\2\2\u0143\u0144\7\61\2\2\u0144L\3\2\2\2\u0145\u0146\7,\2\2\u0146N\3"+
		"\2\2\2\u0147\u0148\7\'\2\2\u0148P\3\2\2\2\u0149\u014a\7-\2\2\u014aR\3"+
		"\2\2\2\u014b\u014c\7/\2\2\u014cT\3\2\2\2\u014d\u014e\7>\2\2\u014eV\3\2"+
		"\2\2\u014f\u0150\7>\2\2\u0150\u0151\7?\2\2\u0151X\3\2\2\2\u0152\u0153"+
		"\7@\2\2\u0153Z\3\2\2\2\u0154\u0155\7@\2\2\u0155\u0156\7?\2\2\u0156\\\3"+
		"\2\2\2\u0157\u0158\7?\2\2\u0158\u0159\7?\2\2\u0159^\3\2\2\2\u015a\u015b"+
		"\7#\2\2\u015b\u015c\7?\2\2\u015c`\3\2\2\2\u015d\u015e\7(\2\2\u015e\u015f"+
		"\7(\2\2\u015fb\3\2\2\2\u0160\u0161\7~\2\2\u0161\u0162\7~\2\2\u0162d\3"+
		"\2\2\2\u0163\u0164\7?\2\2\u0164f\3\2\2\2\u0165\u0169\7$\2\2\u0166\u0167"+
		"\7^\2\2\u0167\u016a\t\7\2\2\u0168\u016a\n\6\2\2\u0169\u0166\3\2\2\2\u0169"+
		"\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016c\u016d\3\2\2\2\u016d\u016e\b\64\4\2\u016eh\3\2\2\2\u016f\u0175"+
		"\7$\2\2\u0170\u0171\7^\2\2\u0171\u0174\t\7\2\2\u0172\u0174\n\6\2\2\u0173"+
		"\u0170\3\2\2\2\u0173\u0172\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2"+
		"\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178"+
		"\u0179\t\6\2\2\u0179\u017a\b\65\5\2\u017aj\3\2\2\2\u017b\u017c\13\2\2"+
		"\2\u017cl\3\2\2\2\31\2s\u0081\u0089\u00d8\u00e9\u00ee\u00f3\u00f9\u00ff"+
		"\u0106\u0108\u010c\u0111\u0115\u011a\u0122\u0124\u012e\u0169\u016b\u0173"+
		"\u0175\6\b\2\2\3\33\2\3\64\3\3\65\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}