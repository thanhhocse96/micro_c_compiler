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
		"DO", "BOOLLIT", "TRUE", "FALSE", "DIGITS", "INTLIT", "EXP", "FRACTION", 
		"FLOATLIT", "ESCAPE", "STRINGLIT", "ID", "LB", "RB", "LP", "RP", "LS", 
		"RS", "SEMI", "COMMA", "NEVOP", "DIVOP", "MULOP", "MODOP", "ADDOP", "SUBOP", 
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
		"WHILE", "DO", "BOOLLIT", "TRUE", "FALSE", "INTLIT", "FLOATLIT", "STRINGLIT", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\63\u0172\b\1\4\2"+
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
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\6\26\u00e9\n\26\r\26\16"+
		"\26\u00ea\3\27\3\27\5\27\u00ef\n\27\3\27\6\27\u00f2\n\27\r\27\16\27\u00f3"+
		"\3\30\6\30\u00f7\n\30\r\30\16\30\u00f8\3\30\3\30\7\30\u00fd\n\30\f\30"+
		"\16\30\u0100\13\30\3\30\7\30\u0103\n\30\f\30\16\30\u0106\13\30\3\30\3"+
		"\30\6\30\u010a\n\30\r\30\16\30\u010b\5\30\u010e\n\30\3\31\3\31\5\31\u0112"+
		"\n\31\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u011a\n\33\f\33\16\33\u011d\13"+
		"\33\3\33\3\33\3\33\3\34\6\34\u0123\n\34\r\34\16\34\u0124\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3"+
		"(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\6\64\u015f"+
		"\n\64\r\64\16\64\u0160\3\64\3\64\3\65\3\65\3\65\3\65\7\65\u0169\n\65\f"+
		"\65\16\65\u016c\13\65\3\65\3\65\3\65\3\66\3\66\3s\2\67\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\2+\26-\2/\2\61\27\63\2\65\30\67\319\32;\33=\34?\35A\36C\37E G!"+
		"I\"K#M$O%Q&S\'U(W)Y*[+],_-a.c/e\60g\61i\62k\63\3\2\t\4\2\f\f\17\17\5\2"+
		"\13\f\17\17\"\"\3\2\62;\4\2GGgg\7\2\n\f\16\17$$))^^\n\2$$))^^ddhhpptt"+
		"vv\4\2C\\c|\u0181\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2+\3\2\2\2\2\61\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\3m\3\2\2\2\5{\3\2\2\2\7\u0087\3\2\2\2"+
		"\t\u008d\3\2\2\2\13\u0091\3\2\2\2\r\u0099\3\2\2\2\17\u009f\3\2\2\2\21"+
		"\u00a6\3\2\2\2\23\u00ab\3\2\2\2\25\u00b1\3\2\2\2\27\u00ba\3\2\2\2\31\u00bd"+
		"\3\2\2\2\33\u00c2\3\2\2\2\35\u00c6\3\2\2\2\37\u00cd\3\2\2\2!\u00d3\3\2"+
		"\2\2#\u00d8\3\2\2\2%\u00da\3\2\2\2\'\u00df\3\2\2\2)\u00e5\3\2\2\2+\u00e8"+
		"\3\2\2\2-\u00ec\3\2\2\2/\u010d\3\2\2\2\61\u010f\3\2\2\2\63\u0113\3\2\2"+
		"\2\65\u0115\3\2\2\2\67\u0122\3\2\2\29\u0126\3\2\2\2;\u0128\3\2\2\2=\u012a"+
		"\3\2\2\2?\u012c\3\2\2\2A\u012e\3\2\2\2C\u0130\3\2\2\2E\u0132\3\2\2\2G"+
		"\u0134\3\2\2\2I\u0136\3\2\2\2K\u0138\3\2\2\2M\u013a\3\2\2\2O\u013c\3\2"+
		"\2\2Q\u013e\3\2\2\2S\u0140\3\2\2\2U\u0142\3\2\2\2W\u0144\3\2\2\2Y\u0147"+
		"\3\2\2\2[\u0149\3\2\2\2]\u014c\3\2\2\2_\u014f\3\2\2\2a\u0152\3\2\2\2c"+
		"\u0155\3\2\2\2e\u0158\3\2\2\2g\u015a\3\2\2\2i\u0164\3\2\2\2k\u0170\3\2"+
		"\2\2mn\7\61\2\2no\7,\2\2os\3\2\2\2pr\13\2\2\2qp\3\2\2\2ru\3\2\2\2st\3"+
		"\2\2\2sq\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7,\2\2wx\7\61\2\2xy\3\2\2\2yz\b"+
		"\2\2\2z\4\3\2\2\2{|\7\61\2\2|}\7\61\2\2}\u0081\3\2\2\2~\u0080\n\2\2\2"+
		"\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2"+
		"\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\b\3\2\2\u0085\6"+
		"\3\2\2\2\u0086\u0088\t\3\2\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\4"+
		"\2\2\u008c\b\3\2\2\2\u008d\u008e\7k\2\2\u008e\u008f\7p\2\2\u008f\u0090"+
		"\7v\2\2\u0090\n\3\2\2\2\u0091\u0092\7d\2\2\u0092\u0093\7q\2\2\u0093\u0094"+
		"\7q\2\2\u0094\u0095\7n\2\2\u0095\u0096\7g\2\2\u0096\u0097\7c\2\2\u0097"+
		"\u0098\7p\2\2\u0098\f\3\2\2\2\u0099\u009a\7h\2\2\u009a\u009b\7n\2\2\u009b"+
		"\u009c\7q\2\2\u009c\u009d\7c\2\2\u009d\u009e\7v\2\2\u009e\16\3\2\2\2\u009f"+
		"\u00a0\7u\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7k\2\2"+
		"\u00a3\u00a4\7p\2\2\u00a4\u00a5\7i\2\2\u00a5\20\3\2\2\2\u00a6\u00a7\7"+
		"x\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7f\2\2\u00aa\22"+
		"\3\2\2\2\u00ab\u00ac\7d\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7g\2\2\u00ae"+
		"\u00af\7c\2\2\u00af\u00b0\7m\2\2\u00b0\24\3\2\2\2\u00b1\u00b2\7e\2\2\u00b2"+
		"\u00b3\7q\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7k\2\2"+
		"\u00b6\u00b7\7p\2\2\u00b7\u00b8\7w\2\2\u00b8\u00b9\7g\2\2\u00b9\26\3\2"+
		"\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7h\2\2\u00bc\30\3\2\2\2\u00bd\u00be"+
		"\7g\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7u\2\2\u00c0\u00c1\7g\2\2\u00c1"+
		"\32\3\2\2\2\u00c2\u00c3\7h\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7t\2\2\u00c5"+
		"\34\3\2\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7v\2\2\u00c9"+
		"\u00ca\7w\2\2\u00ca\u00cb\7t\2\2\u00cb\u00cc\7p\2\2\u00cc\36\3\2\2\2\u00cd"+
		"\u00ce\7y\2\2\u00ce\u00cf\7j\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7n\2\2"+
		"\u00d1\u00d2\7g\2\2\u00d2 \3\2\2\2\u00d3\u00d4\7f\2\2\u00d4\u00d5\7q\2"+
		"\2\u00d5\"\3\2\2\2\u00d6\u00d9\5%\23\2\u00d7\u00d9\5\'\24\2\u00d8\u00d6"+
		"\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9$\3\2\2\2\u00da\u00db\7v\2\2\u00db\u00dc"+
		"\7t\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de\7g\2\2\u00de&\3\2\2\2\u00df\u00e0"+
		"\7h\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7n\2\2\u00e2\u00e3\7u\2\2\u00e3"+
		"\u00e4\7g\2\2\u00e4(\3\2\2\2\u00e5\u00e6\t\4\2\2\u00e6*\3\2\2\2\u00e7"+
		"\u00e9\5)\25\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00ea\u00eb\3\2\2\2\u00eb,\3\2\2\2\u00ec\u00ee\t\5\2\2\u00ed\u00ef"+
		"\7/\2\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0"+
		"\u00f2\5)\25\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f3\u00f4\3\2\2\2\u00f4.\3\2\2\2\u00f5\u00f7\5)\25\2\u00f6\u00f5"+
		"\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fe\7\60\2\2\u00fb\u00fd\5)\25\2\u00fc\u00fb\3"+
		"\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u010e\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0103\5)\25\2\u0102\u0101\3\2"+
		"\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0109\7\60\2\2\u0108\u010a\5"+
		")\25\2\u0109\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u00f6\3\2\2\2\u010d\u0104\3\2"+
		"\2\2\u010e\60\3\2\2\2\u010f\u0111\5/\30\2\u0110\u0112\5-\27\2\u0111\u0110"+
		"\3\2\2\2\u0111\u0112\3\2\2\2\u0112\62\3\2\2\2\u0113\u0114\t\6\2\2\u0114"+
		"\64\3\2\2\2\u0115\u011b\7$\2\2\u0116\u0117\7^\2\2\u0117\u011a\t\7\2\2"+
		"\u0118\u011a\n\6\2\2\u0119\u0116\3\2\2\2\u0119\u0118\3\2\2\2\u011a\u011d"+
		"\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011e\u011f\7$\2\2\u011f\u0120\b\33\3\2\u0120\66\3\2\2"+
		"\2\u0121\u0123\t\b\2\2\u0122\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122"+
		"\3\2\2\2\u0124\u0125\3\2\2\2\u01258\3\2\2\2\u0126\u0127\7*\2\2\u0127:"+
		"\3\2\2\2\u0128\u0129\7+\2\2\u0129<\3\2\2\2\u012a\u012b\7}\2\2\u012b>\3"+
		"\2\2\2\u012c\u012d\7\177\2\2\u012d@\3\2\2\2\u012e\u012f\7]\2\2\u012fB"+
		"\3\2\2\2\u0130\u0131\7_\2\2\u0131D\3\2\2\2\u0132\u0133\7=\2\2\u0133F\3"+
		"\2\2\2\u0134\u0135\7.\2\2\u0135H\3\2\2\2\u0136\u0137\7#\2\2\u0137J\3\2"+
		"\2\2\u0138\u0139\7\61\2\2\u0139L\3\2\2\2\u013a\u013b\7,\2\2\u013bN\3\2"+
		"\2\2\u013c\u013d\7\'\2\2\u013dP\3\2\2\2\u013e\u013f\7-\2\2\u013fR\3\2"+
		"\2\2\u0140\u0141\7/\2\2\u0141T\3\2\2\2\u0142\u0143\7>\2\2\u0143V\3\2\2"+
		"\2\u0144\u0145\7>\2\2\u0145\u0146\7?\2\2\u0146X\3\2\2\2\u0147\u0148\7"+
		"@\2\2\u0148Z\3\2\2\2\u0149\u014a\7@\2\2\u014a\u014b\7?\2\2\u014b\\\3\2"+
		"\2\2\u014c\u014d\7?\2\2\u014d\u014e\7?\2\2\u014e^\3\2\2\2\u014f\u0150"+
		"\7#\2\2\u0150\u0151\7?\2\2\u0151`\3\2\2\2\u0152\u0153\7(\2\2\u0153\u0154"+
		"\7(\2\2\u0154b\3\2\2\2\u0155\u0156\7~\2\2\u0156\u0157\7~\2\2\u0157d\3"+
		"\2\2\2\u0158\u0159\7?\2\2\u0159f\3\2\2\2\u015a\u015e\7$\2\2\u015b\u015c"+
		"\7^\2\2\u015c\u015f\t\7\2\2\u015d\u015f\n\6\2\2\u015e\u015b\3\2\2\2\u015e"+
		"\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2"+
		"\2\2\u0161\u0162\3\2\2\2\u0162\u0163\b\64\4\2\u0163h\3\2\2\2\u0164\u016a"+
		"\7$\2\2\u0165\u0166\7^\2\2\u0166\u0169\t\7\2\2\u0167\u0169\n\6\2\2\u0168"+
		"\u0165\3\2\2\2\u0168\u0167\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2"+
		"\2\2\u016a\u016b\3\2\2\2\u016b\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d"+
		"\u016e\t\6\2\2\u016e\u016f\b\65\5\2\u016fj\3\2\2\2\u0170\u0171\13\2\2"+
		"\2\u0171l\3\2\2\2\27\2s\u0081\u0089\u00d8\u00ea\u00ee\u00f3\u00f8\u00fe"+
		"\u0104\u010b\u010d\u0111\u0119\u011b\u0124\u015e\u0160\u0168\u016a\6\b"+
		"\2\2\3\33\2\3\64\3\3\65\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}