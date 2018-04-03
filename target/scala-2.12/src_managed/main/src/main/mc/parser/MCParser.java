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
		VOIDTYPE=8, BREAK=9, CONTINUE=10, IF=11, ELSE=12, FOR=13, RETURN=14, WHILE=15, 
		DO=16, BOOLLIT=17, TRUE=18, FALSE=19, INTLIT=20, FLOATLIT=21, STRINGLIT=22, 
		ID=23, LB=24, RB=25, LP=26, RP=27, LS=28, RS=29, SEMI=30, COMMA=31, NEVOP=32, 
		DIVOP=33, MULOP=34, MODOP=35, ADDOP=36, SUBOP=37, LTOP=38, LTEOP=39, GTOP=40, 
		GTEOP=41, EQUALOP=42, NEQUALOP=43, ANDOP=44, OROP=45, ASSIGNOP=46, UNCLOSE_STRING=47, 
		ILLEGAL_ESCAPE=48, ERROR_CHAR=49;
	public static final int
		RULE_program = 0, RULE_declList = 1, RULE_decl = 2, RULE_varDecl = 3, 
		RULE_manyVar = 4, RULE_variable = 5, RULE_primitiveType = 6, RULE_funcDecl = 7, 
		RULE_funcType = 8, RULE_paraList = 9, RULE_paraListNonNull = 10, RULE_paraDecl = 11, 
		RULE_arrayPointerType = 12, RULE_inputArrPointerType = 13, RULE_outputArrPointerType = 14, 
		RULE_blockStmt = 15, RULE_declPart = 16, RULE_stmtPart = 17, RULE_stmt = 18, 
		RULE_otherStmt = 19, RULE_breakStmt = 20, RULE_continueStmt = 21, RULE_returnStmt = 22, 
		RULE_noExpReturn = 23, RULE_aExpReturn = 24, RULE_stmtmatch = 25, RULE_stmtunmatch = 26, 
		RULE_ifStmt = 27, RULE_ifmatch = 28, RULE_ifunmatch = 29, RULE_dowhileStmt = 30, 
		RULE_forStmt = 31, RULE_expStmt = 32, RULE_exp0 = 33, RULE_exp1 = 34, 
		RULE_exp2 = 35, RULE_exp3 = 36, RULE_exp4 = 37, RULE_exp5 = 38, RULE_exp6 = 39, 
		RULE_exp7 = 40, RULE_exp8 = 41, RULE_exp9 = 42, RULE_indexExp = 43, RULE_indexer = 44, 
		RULE_funcCall = 45, RULE_argList = 46, RULE_argListNonNull = 47;
	public static final String[] ruleNames = {
		"program", "declList", "decl", "varDecl", "manyVar", "variable", "primitiveType", 
		"funcDecl", "funcType", "paraList", "paraListNonNull", "paraDecl", "arrayPointerType", 
		"inputArrPointerType", "outputArrPointerType", "blockStmt", "declPart", 
		"stmtPart", "stmt", "otherStmt", "breakStmt", "continueStmt", "returnStmt", 
		"noExpReturn", "aExpReturn", "stmtmatch", "stmtunmatch", "ifStmt", "ifmatch", 
		"ifunmatch", "dowhileStmt", "forStmt", "expStmt", "exp0", "exp1", "exp2", 
		"exp3", "exp4", "exp5", "exp6", "exp7", "exp8", "exp9", "indexExp", "indexer", 
		"funcCall", "argList", "argListNonNull"
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
		public DeclListContext declList() {
			return getRuleContext(DeclListContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MCParser.EOF, 0); }
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
			setState(96);
			declList();
			setState(97);
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

	public static class DeclListContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitDeclList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclListContext declList() throws RecognitionException {
		DeclListContext _localctx = new DeclListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				decl();
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTTYPE) | (1L << BOOLTYPE) | (1L << FLOATTYPE) | (1L << STRINGTYPE) | (1L << VOIDTYPE))) != 0) );
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

	public static class DeclContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public FuncDeclContext funcDecl() {
			return getRuleContext(FuncDeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				funcDecl();
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

	public static class VarDeclContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ManyVarContext manyVar() {
			return getRuleContext(ManyVarContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			primitiveType();
			setState(109);
			manyVar();
			setState(110);
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

	public static class ManyVarContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MCParser.COMMA, i);
		}
		public ManyVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_manyVar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitManyVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ManyVarContext manyVar() throws RecognitionException {
		ManyVarContext _localctx = new ManyVarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_manyVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			variable();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(113);
				match(COMMA);
				setState(114);
				variable();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MCParser.ID, 0); }
		public TerminalNode LS() { return getToken(MCParser.LS, 0); }
		public TerminalNode INTLIT() { return getToken(MCParser.INTLIT, 0); }
		public TerminalNode RS() { return getToken(MCParser.RS, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variable);
		try {
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(ID);
				setState(122);
				match(LS);
				setState(123);
				match(INTLIT);
				setState(124);
				match(RS);
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode BOOLTYPE() { return getToken(MCParser.BOOLTYPE, 0); }
		public TerminalNode INTTYPE() { return getToken(MCParser.INTTYPE, 0); }
		public TerminalNode FLOATTYPE() { return getToken(MCParser.FLOATTYPE, 0); }
		public TerminalNode STRINGTYPE() { return getToken(MCParser.STRINGTYPE, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTTYPE) | (1L << BOOLTYPE) | (1L << FLOATTYPE) | (1L << STRINGTYPE))) != 0)) ) {
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

	public static class FuncDeclContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MCParser.ID, 0); }
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public ParaListContext paraList() {
			return getRuleContext(ParaListContext.class,0);
		}
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			funcType();
			setState(130);
			match(ID);
			setState(131);
			match(LB);
			setState(132);
			paraList();
			setState(133);
			match(RB);
			setState(134);
			blockStmt();
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

	public static class FuncTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode VOIDTYPE() { return getToken(MCParser.VOIDTYPE, 0); }
		public OutputArrPointerTypeContext outputArrPointerType() {
			return getRuleContext(OutputArrPointerTypeContext.class,0);
		}
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitFuncType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcType);
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				primitiveType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(VOIDTYPE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				outputArrPointerType();
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

	public static class ParaListContext extends ParserRuleContext {
		public ParaListNonNullContext paraListNonNull() {
			return getRuleContext(ParaListNonNullContext.class,0);
		}
		public ParaListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paraList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitParaList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParaListContext paraList() throws RecognitionException {
		ParaListContext _localctx = new ParaListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_paraList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTTYPE) | (1L << BOOLTYPE) | (1L << FLOATTYPE) | (1L << STRINGTYPE))) != 0)) {
				{
				setState(141);
				paraListNonNull();
				}
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

	public static class ParaListNonNullContext extends ParserRuleContext {
		public List<ParaDeclContext> paraDecl() {
			return getRuleContexts(ParaDeclContext.class);
		}
		public ParaDeclContext paraDecl(int i) {
			return getRuleContext(ParaDeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MCParser.COMMA, i);
		}
		public ParaListNonNullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paraListNonNull; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitParaListNonNull(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParaListNonNullContext paraListNonNull() throws RecognitionException {
		ParaListNonNullContext _localctx = new ParaListNonNullContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_paraListNonNull);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			paraDecl();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(145);
				match(COMMA);
				setState(146);
				paraDecl();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ParaDeclContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MCParser.ID, 0); }
		public TerminalNode LS() { return getToken(MCParser.LS, 0); }
		public TerminalNode RS() { return getToken(MCParser.RS, 0); }
		public ParaDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paraDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitParaDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParaDeclContext paraDecl() throws RecognitionException {
		ParaDeclContext _localctx = new ParaDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_paraDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			primitiveType();
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(153);
				match(ID);
				}
				break;
			case 2:
				{
				setState(154);
				match(ID);
				setState(155);
				match(LS);
				setState(156);
				match(RS);
				}
				break;
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

	public static class ArrayPointerTypeContext extends ParserRuleContext {
		public InputArrPointerTypeContext inputArrPointerType() {
			return getRuleContext(InputArrPointerTypeContext.class,0);
		}
		public OutputArrPointerTypeContext outputArrPointerType() {
			return getRuleContext(OutputArrPointerTypeContext.class,0);
		}
		public ArrayPointerTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayPointerType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitArrayPointerType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayPointerTypeContext arrayPointerType() throws RecognitionException {
		ArrayPointerTypeContext _localctx = new ArrayPointerTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayPointerType);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				inputArrPointerType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				outputArrPointerType();
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

	public static class InputArrPointerTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MCParser.ID, 0); }
		public TerminalNode LS() { return getToken(MCParser.LS, 0); }
		public TerminalNode RS() { return getToken(MCParser.RS, 0); }
		public InputArrPointerTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputArrPointerType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitInputArrPointerType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputArrPointerTypeContext inputArrPointerType() throws RecognitionException {
		InputArrPointerTypeContext _localctx = new InputArrPointerTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_inputArrPointerType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			primitiveType();
			setState(164);
			match(ID);
			setState(165);
			match(LS);
			setState(166);
			match(RS);
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

	public static class OutputArrPointerTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode LS() { return getToken(MCParser.LS, 0); }
		public TerminalNode RS() { return getToken(MCParser.RS, 0); }
		public OutputArrPointerTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputArrPointerType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitOutputArrPointerType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputArrPointerTypeContext outputArrPointerType() throws RecognitionException {
		OutputArrPointerTypeContext _localctx = new OutputArrPointerTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_outputArrPointerType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			primitiveType();
			setState(169);
			match(LS);
			setState(170);
			match(RS);
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

	public static class BlockStmtContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(MCParser.LP, 0); }
		public DeclPartContext declPart() {
			return getRuleContext(DeclPartContext.class,0);
		}
		public StmtPartContext stmtPart() {
			return getRuleContext(StmtPartContext.class,0);
		}
		public TerminalNode RP() { return getToken(MCParser.RP, 0); }
		public BlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_blockStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(LP);
			setState(173);
			declPart();
			setState(174);
			stmtPart();
			setState(175);
			match(RP);
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

	public static class DeclPartContext extends ParserRuleContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public DeclPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declPart; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitDeclPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclPartContext declPart() throws RecognitionException {
		DeclPartContext _localctx = new DeclPartContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_declPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTTYPE) | (1L << BOOLTYPE) | (1L << FLOATTYPE) | (1L << STRINGTYPE))) != 0)) {
				{
				{
				setState(177);
				varDecl();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StmtPartContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtPart; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitStmtPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtPartContext stmtPart() throws RecognitionException {
		StmtPartContext _localctx = new StmtPartContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stmtPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONTINUE) | (1L << IF) | (1L << FOR) | (1L << RETURN) | (1L << DO) | (1L << BOOLLIT) | (1L << INTLIT) | (1L << FLOATLIT) | (1L << STRINGLIT) | (1L << ID) | (1L << LB) | (1L << LP) | (1L << NEVOP) | (1L << SUBOP))) != 0)) {
				{
				{
				setState(183);
				stmt();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StmtContext extends ParserRuleContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public OtherStmtContext otherStmt() {
			return getRuleContext(OtherStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stmt);
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				ifStmt();
				}
				break;
			case BREAK:
			case CONTINUE:
			case FOR:
			case RETURN:
			case DO:
			case BOOLLIT:
			case INTLIT:
			case FLOATLIT:
			case STRINGLIT:
			case ID:
			case LB:
			case LP:
			case NEVOP:
			case SUBOP:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				otherStmt();
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

	public static class OtherStmtContext extends ParserRuleContext {
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public DowhileStmtContext dowhileStmt() {
			return getRuleContext(DowhileStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ExpStmtContext expStmt() {
			return getRuleContext(ExpStmtContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public OtherStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitOtherStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherStmtContext otherStmt() throws RecognitionException {
		OtherStmtContext _localctx = new OtherStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_otherStmt);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				forStmt();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				dowhileStmt();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				breakStmt();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(196);
				continueStmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				returnStmt();
				}
				break;
			case BOOLLIT:
			case INTLIT:
			case FLOATLIT:
			case STRINGLIT:
			case ID:
			case LB:
			case NEVOP:
			case SUBOP:
				enterOuterAlt(_localctx, 6);
				{
				setState(198);
				expStmt();
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 7);
				{
				setState(199);
				blockStmt();
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

	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MCParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(BREAK);
			setState(203);
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

	public static class ContinueStmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MCParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitContinueStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(CONTINUE);
			setState(206);
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public NoExpReturnContext noExpReturn() {
			return getRuleContext(NoExpReturnContext.class,0);
		}
		public AExpReturnContext aExpReturn() {
			return getRuleContext(AExpReturnContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnStmt);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				noExpReturn();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				aExpReturn();
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

	public static class NoExpReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MCParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public NoExpReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noExpReturn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitNoExpReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoExpReturnContext noExpReturn() throws RecognitionException {
		NoExpReturnContext _localctx = new NoExpReturnContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_noExpReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(RETURN);
			setState(213);
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

	public static class AExpReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MCParser.RETURN, 0); }
		public Exp0Context exp0() {
			return getRuleContext(Exp0Context.class,0);
		}
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public AExpReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aExpReturn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitAExpReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AExpReturnContext aExpReturn() throws RecognitionException {
		AExpReturnContext _localctx = new AExpReturnContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_aExpReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(RETURN);
			setState(216);
			exp0();
			setState(217);
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

	public static class StmtmatchContext extends ParserRuleContext {
		public IfmatchContext ifmatch() {
			return getRuleContext(IfmatchContext.class,0);
		}
		public OtherStmtContext otherStmt() {
			return getRuleContext(OtherStmtContext.class,0);
		}
		public StmtmatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtmatch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitStmtmatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtmatchContext stmtmatch() throws RecognitionException {
		StmtmatchContext _localctx = new StmtmatchContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_stmtmatch);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				ifmatch();
				}
				break;
			case BREAK:
			case CONTINUE:
			case FOR:
			case RETURN:
			case DO:
			case BOOLLIT:
			case INTLIT:
			case FLOATLIT:
			case STRINGLIT:
			case ID:
			case LB:
			case LP:
			case NEVOP:
			case SUBOP:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				otherStmt();
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

	public static class StmtunmatchContext extends ParserRuleContext {
		public IfunmatchContext ifunmatch() {
			return getRuleContext(IfunmatchContext.class,0);
		}
		public OtherStmtContext otherStmt() {
			return getRuleContext(OtherStmtContext.class,0);
		}
		public StmtunmatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtunmatch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitStmtunmatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtunmatchContext stmtunmatch() throws RecognitionException {
		StmtunmatchContext _localctx = new StmtunmatchContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_stmtunmatch);
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				ifunmatch();
				}
				break;
			case BREAK:
			case CONTINUE:
			case FOR:
			case RETURN:
			case DO:
			case BOOLLIT:
			case INTLIT:
			case FLOATLIT:
			case STRINGLIT:
			case ID:
			case LB:
			case LP:
			case NEVOP:
			case SUBOP:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				otherStmt();
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

	public static class IfStmtContext extends ParserRuleContext {
		public IfmatchContext ifmatch() {
			return getRuleContext(IfmatchContext.class,0);
		}
		public IfunmatchContext ifunmatch() {
			return getRuleContext(IfunmatchContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_ifStmt);
		try {
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				ifmatch();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				ifunmatch();
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

	public static class IfmatchContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MCParser.IF, 0); }
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public Exp0Context exp0() {
			return getRuleContext(Exp0Context.class,0);
		}
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public List<StmtmatchContext> stmtmatch() {
			return getRuleContexts(StmtmatchContext.class);
		}
		public StmtmatchContext stmtmatch(int i) {
			return getRuleContext(StmtmatchContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MCParser.ELSE, 0); }
		public IfmatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifmatch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitIfmatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfmatchContext ifmatch() throws RecognitionException {
		IfmatchContext _localctx = new IfmatchContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ifmatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(IF);
			setState(232);
			match(LB);
			setState(233);
			exp0();
			setState(234);
			match(RB);
			setState(235);
			stmtmatch();
			setState(236);
			match(ELSE);
			setState(237);
			stmtmatch();
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

	public static class IfunmatchContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MCParser.IF, 0); }
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public Exp0Context exp0() {
			return getRuleContext(Exp0Context.class,0);
		}
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtmatchContext stmtmatch() {
			return getRuleContext(StmtmatchContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(MCParser.ELSE, 0); }
		public StmtunmatchContext stmtunmatch() {
			return getRuleContext(StmtunmatchContext.class,0);
		}
		public IfunmatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifunmatch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitIfunmatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfunmatchContext ifunmatch() throws RecognitionException {
		IfunmatchContext _localctx = new IfunmatchContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ifunmatch);
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				match(IF);
				setState(240);
				match(LB);
				setState(241);
				exp0();
				setState(242);
				match(RB);
				setState(243);
				stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(IF);
				setState(246);
				match(LB);
				setState(247);
				exp0();
				setState(248);
				match(RB);
				setState(249);
				stmtmatch();
				setState(250);
				match(ELSE);
				setState(251);
				stmtunmatch();
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

	public static class DowhileStmtContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(MCParser.DO, 0); }
		public TerminalNode WHILE() { return getToken(MCParser.WHILE, 0); }
		public Exp0Context exp0() {
			return getRuleContext(Exp0Context.class,0);
		}
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public DowhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dowhileStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitDowhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DowhileStmtContext dowhileStmt() throws RecognitionException {
		DowhileStmtContext _localctx = new DowhileStmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_dowhileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(DO);
			setState(257); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(256);
				stmt();
				}
				}
				setState(259); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONTINUE) | (1L << IF) | (1L << FOR) | (1L << RETURN) | (1L << DO) | (1L << BOOLLIT) | (1L << INTLIT) | (1L << FLOATLIT) | (1L << STRINGLIT) | (1L << ID) | (1L << LB) | (1L << LP) | (1L << NEVOP) | (1L << SUBOP))) != 0) );
			setState(261);
			match(WHILE);
			setState(262);
			exp0();
			setState(263);
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

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MCParser.FOR, 0); }
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public List<Exp0Context> exp0() {
			return getRuleContexts(Exp0Context.class);
		}
		public Exp0Context exp0(int i) {
			return getRuleContext(Exp0Context.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MCParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MCParser.SEMI, i);
		}
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(FOR);
			setState(266);
			match(LB);
			setState(267);
			exp0();
			setState(268);
			match(SEMI);
			setState(269);
			exp0();
			setState(270);
			match(SEMI);
			setState(271);
			exp0();
			setState(272);
			match(RB);
			setState(273);
			stmt();
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

	public static class ExpStmtContext extends ParserRuleContext {
		public Exp0Context exp0() {
			return getRuleContext(Exp0Context.class,0);
		}
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public ExpStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExpStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpStmtContext expStmt() throws RecognitionException {
		ExpStmtContext _localctx = new ExpStmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			exp0();
			setState(276);
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

	public static class Exp0Context extends ParserRuleContext {
		public Exp1Context exp1() {
			return getRuleContext(Exp1Context.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(MCParser.ASSIGNOP, 0); }
		public Exp0Context exp0() {
			return getRuleContext(Exp0Context.class,0);
		}
		public Exp0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp0; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp0Context exp0() throws RecognitionException {
		Exp0Context _localctx = new Exp0Context(_ctx, getState());
		enterRule(_localctx, 66, RULE_exp0);
		try {
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				exp1(0);
				setState(279);
				match(ASSIGNOP);
				setState(280);
				exp0();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				exp1(0);
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

	public static class Exp1Context extends ParserRuleContext {
		public Exp2Context exp2() {
			return getRuleContext(Exp2Context.class,0);
		}
		public Exp1Context exp1() {
			return getRuleContext(Exp1Context.class,0);
		}
		public TerminalNode OROP() { return getToken(MCParser.OROP, 0); }
		public Exp1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp1Context exp1() throws RecognitionException {
		return exp1(0);
	}

	private Exp1Context exp1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp1Context _localctx = new Exp1Context(_ctx, _parentState);
		Exp1Context _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_exp1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(286);
			exp2(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp1Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp1);
					setState(288);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(289);
					match(OROP);
					setState(290);
					exp2(0);
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp2Context extends ParserRuleContext {
		public Exp3Context exp3() {
			return getRuleContext(Exp3Context.class,0);
		}
		public Exp2Context exp2() {
			return getRuleContext(Exp2Context.class,0);
		}
		public TerminalNode ANDOP() { return getToken(MCParser.ANDOP, 0); }
		public Exp2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp2Context exp2() throws RecognitionException {
		return exp2(0);
	}

	private Exp2Context exp2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp2Context _localctx = new Exp2Context(_ctx, _parentState);
		Exp2Context _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_exp2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(297);
			exp3();
			}
			_ctx.stop = _input.LT(-1);
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp2Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp2);
					setState(299);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(300);
					match(ANDOP);
					setState(301);
					exp3();
					}
					} 
				}
				setState(306);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp3Context extends ParserRuleContext {
		public List<Exp4Context> exp4() {
			return getRuleContexts(Exp4Context.class);
		}
		public Exp4Context exp4(int i) {
			return getRuleContext(Exp4Context.class,i);
		}
		public TerminalNode EQUALOP() { return getToken(MCParser.EQUALOP, 0); }
		public TerminalNode NEQUALOP() { return getToken(MCParser.NEQUALOP, 0); }
		public Exp3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp3Context exp3() throws RecognitionException {
		Exp3Context _localctx = new Exp3Context(_ctx, getState());
		enterRule(_localctx, 72, RULE_exp3);
		try {
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				exp4();
				setState(308);
				match(EQUALOP);
				setState(309);
				exp4();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				exp4();
				setState(312);
				match(NEQUALOP);
				setState(313);
				exp4();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(315);
				exp4();
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

	public static class Exp4Context extends ParserRuleContext {
		public List<Exp5Context> exp5() {
			return getRuleContexts(Exp5Context.class);
		}
		public Exp5Context exp5(int i) {
			return getRuleContext(Exp5Context.class,i);
		}
		public TerminalNode LTOP() { return getToken(MCParser.LTOP, 0); }
		public TerminalNode GTOP() { return getToken(MCParser.GTOP, 0); }
		public TerminalNode LTEOP() { return getToken(MCParser.LTEOP, 0); }
		public TerminalNode GTEOP() { return getToken(MCParser.GTEOP, 0); }
		public Exp4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp4Context exp4() throws RecognitionException {
		Exp4Context _localctx = new Exp4Context(_ctx, getState());
		enterRule(_localctx, 74, RULE_exp4);
		try {
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				exp5(0);
				setState(319);
				match(LTOP);
				setState(320);
				exp5(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(322);
				exp5(0);
				setState(323);
				match(GTOP);
				setState(324);
				exp5(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(326);
				exp5(0);
				setState(327);
				match(LTEOP);
				setState(328);
				exp5(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(330);
				exp5(0);
				setState(331);
				match(GTEOP);
				setState(332);
				exp5(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(334);
				exp5(0);
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

	public static class Exp5Context extends ParserRuleContext {
		public Exp6Context exp6() {
			return getRuleContext(Exp6Context.class,0);
		}
		public Exp5Context exp5() {
			return getRuleContext(Exp5Context.class,0);
		}
		public TerminalNode ADDOP() { return getToken(MCParser.ADDOP, 0); }
		public TerminalNode SUBOP() { return getToken(MCParser.SUBOP, 0); }
		public Exp5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp5; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp5Context exp5() throws RecognitionException {
		return exp5(0);
	}

	private Exp5Context exp5(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp5Context _localctx = new Exp5Context(_ctx, _parentState);
		Exp5Context _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_exp5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(338);
			exp6(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(348);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(346);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new Exp5Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp5);
						setState(340);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(341);
						match(ADDOP);
						setState(342);
						exp6(0);
						}
						break;
					case 2:
						{
						_localctx = new Exp5Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp5);
						setState(343);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(344);
						match(SUBOP);
						setState(345);
						exp6(0);
						}
						break;
					}
					} 
				}
				setState(350);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp6Context extends ParserRuleContext {
		public Exp7Context exp7() {
			return getRuleContext(Exp7Context.class,0);
		}
		public Exp6Context exp6() {
			return getRuleContext(Exp6Context.class,0);
		}
		public TerminalNode MULOP() { return getToken(MCParser.MULOP, 0); }
		public TerminalNode DIVOP() { return getToken(MCParser.DIVOP, 0); }
		public TerminalNode MODOP() { return getToken(MCParser.MODOP, 0); }
		public Exp6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp6; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp6(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp6Context exp6() throws RecognitionException {
		return exp6(0);
	}

	private Exp6Context exp6(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp6Context _localctx = new Exp6Context(_ctx, _parentState);
		Exp6Context _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_exp6, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(352);
			exp7();
			}
			_ctx.stop = _input.LT(-1);
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(363);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new Exp6Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp6);
						setState(354);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(355);
						match(MULOP);
						setState(356);
						exp7();
						}
						break;
					case 2:
						{
						_localctx = new Exp6Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp6);
						setState(357);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(358);
						match(DIVOP);
						setState(359);
						exp7();
						}
						break;
					case 3:
						{
						_localctx = new Exp6Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp6);
						setState(360);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(361);
						match(MODOP);
						setState(362);
						exp7();
						}
						break;
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp7Context extends ParserRuleContext {
		public TerminalNode SUBOP() { return getToken(MCParser.SUBOP, 0); }
		public Exp7Context exp7() {
			return getRuleContext(Exp7Context.class,0);
		}
		public TerminalNode NEVOP() { return getToken(MCParser.NEVOP, 0); }
		public Exp8Context exp8() {
			return getRuleContext(Exp8Context.class,0);
		}
		public Exp7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp7; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp7(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp7Context exp7() throws RecognitionException {
		Exp7Context _localctx = new Exp7Context(_ctx, getState());
		enterRule(_localctx, 80, RULE_exp7);
		try {
			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUBOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				match(SUBOP);
				setState(369);
				exp7();
				}
				break;
			case NEVOP:
				enterOuterAlt(_localctx, 2);
				{
				setState(370);
				match(NEVOP);
				setState(371);
				exp7();
				}
				break;
			case BOOLLIT:
			case INTLIT:
			case FLOATLIT:
			case STRINGLIT:
			case ID:
			case LB:
				enterOuterAlt(_localctx, 3);
				{
				setState(372);
				exp8();
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

	public static class Exp8Context extends ParserRuleContext {
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public Exp0Context exp0() {
			return getRuleContext(Exp0Context.class,0);
		}
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public Exp9Context exp9() {
			return getRuleContext(Exp9Context.class,0);
		}
		public Exp8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp8; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp8(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp8Context exp8() throws RecognitionException {
		Exp8Context _localctx = new Exp8Context(_ctx, getState());
		enterRule(_localctx, 82, RULE_exp8);
		try {
			setState(380);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LB:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				match(LB);
				setState(376);
				exp0();
				setState(377);
				match(RB);
				}
				break;
			case BOOLLIT:
			case INTLIT:
			case FLOATLIT:
			case STRINGLIT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				exp9();
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

	public static class Exp9Context extends ParserRuleContext {
		public IndexExpContext indexExp() {
			return getRuleContext(IndexExpContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public TerminalNode INTLIT() { return getToken(MCParser.INTLIT, 0); }
		public TerminalNode FLOATLIT() { return getToken(MCParser.FLOATLIT, 0); }
		public TerminalNode STRINGLIT() { return getToken(MCParser.STRINGLIT, 0); }
		public TerminalNode BOOLLIT() { return getToken(MCParser.BOOLLIT, 0); }
		public TerminalNode ID() { return getToken(MCParser.ID, 0); }
		public Exp9Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp9; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExp9(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp9Context exp9() throws RecognitionException {
		Exp9Context _localctx = new Exp9Context(_ctx, getState());
		enterRule(_localctx, 84, RULE_exp9);
		try {
			setState(389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				indexExp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				funcCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(384);
				match(INTLIT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(385);
				match(FLOATLIT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(386);
				match(STRINGLIT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(387);
				match(BOOLLIT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(388);
				match(ID);
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

	public static class IndexExpContext extends ParserRuleContext {
		public IndexerContext indexer() {
			return getRuleContext(IndexerContext.class,0);
		}
		public TerminalNode LS() { return getToken(MCParser.LS, 0); }
		public Exp0Context exp0() {
			return getRuleContext(Exp0Context.class,0);
		}
		public TerminalNode RS() { return getToken(MCParser.RS, 0); }
		public IndexExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitIndexExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexExpContext indexExp() throws RecognitionException {
		IndexExpContext _localctx = new IndexExpContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_indexExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			indexer();
			setState(392);
			match(LS);
			setState(393);
			exp0();
			setState(394);
			match(RS);
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

	public static class IndexerContext extends ParserRuleContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public TerminalNode ID() { return getToken(MCParser.ID, 0); }
		public IndexerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitIndexer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexerContext indexer() throws RecognitionException {
		IndexerContext _localctx = new IndexerContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_indexer);
		try {
			setState(398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				funcCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				match(ID);
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

	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MCParser.ID, 0); }
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(ID);
			setState(401);
			match(LB);
			setState(402);
			argList();
			setState(403);
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

	public static class ArgListContext extends ParserRuleContext {
		public ArgListNonNullContext argListNonNull() {
			return getRuleContext(ArgListNonNullContext.class,0);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLLIT) | (1L << INTLIT) | (1L << FLOATLIT) | (1L << STRINGLIT) | (1L << ID) | (1L << LB) | (1L << NEVOP) | (1L << SUBOP))) != 0)) {
				{
				setState(405);
				argListNonNull();
				}
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

	public static class ArgListNonNullContext extends ParserRuleContext {
		public List<Exp0Context> exp0() {
			return getRuleContexts(Exp0Context.class);
		}
		public Exp0Context exp0(int i) {
			return getRuleContext(Exp0Context.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MCParser.COMMA, i);
		}
		public ArgListNonNullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argListNonNull; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitArgListNonNull(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListNonNullContext argListNonNull() throws RecognitionException {
		ArgListNonNullContext _localctx = new ArgListNonNullContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_argListNonNull);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			exp0();
			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(409);
				match(COMMA);
				setState(410);
				exp0();
				}
				}
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 34:
			return exp1_sempred((Exp1Context)_localctx, predIndex);
		case 35:
			return exp2_sempred((Exp2Context)_localctx, predIndex);
		case 38:
			return exp5_sempred((Exp5Context)_localctx, predIndex);
		case 39:
			return exp6_sempred((Exp6Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp1_sempred(Exp1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp2_sempred(Exp2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp5_sempred(Exp5Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp6_sempred(Exp6Context _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u01a3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\3\6\3g\n\3\r"+
		"\3\16\3h\3\4\3\4\5\4m\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6v\n\6\f\6\16"+
		"\6y\13\6\3\7\3\7\3\7\3\7\3\7\5\7\u0080\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\5\n\u008e\n\n\3\13\5\13\u0091\n\13\3\f\3\f\3\f\7"+
		"\f\u0096\n\f\f\f\16\f\u0099\13\f\3\r\3\r\3\r\3\r\3\r\5\r\u00a0\n\r\3\16"+
		"\3\16\5\16\u00a4\n\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\7\22\u00b5\n\22\f\22\16\22\u00b8\13\22\3\23"+
		"\7\23\u00bb\n\23\f\23\16\23\u00be\13\23\3\24\3\24\5\24\u00c2\n\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00cb\n\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\30\3\30\5\30\u00d5\n\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\5\33\u00e0\n\33\3\34\3\34\5\34\u00e4\n\34\3\35\3\35\5\35\u00e8\n"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0100\n\37\3 \3 \6 \u0104"+
		"\n \r \16 \u0105\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\5#\u011e\n#\3$\3$\3$\3$\3$\3$\7$\u0126\n$\f$\16$\u0129"+
		"\13$\3%\3%\3%\3%\3%\3%\7%\u0131\n%\f%\16%\u0134\13%\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\5&\u013f\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\5\'\u0152\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u015d"+
		"\n(\f(\16(\u0160\13(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u016e\n)\f"+
		")\16)\u0171\13)\3*\3*\3*\3*\3*\5*\u0178\n*\3+\3+\3+\3+\3+\5+\u017f\n+"+
		"\3,\3,\3,\3,\3,\3,\3,\5,\u0188\n,\3-\3-\3-\3-\3-\3.\3.\5.\u0191\n.\3/"+
		"\3/\3/\3/\3/\3\60\5\60\u0199\n\60\3\61\3\61\3\61\7\61\u019e\n\61\f\61"+
		"\16\61\u01a1\13\61\3\61\2\6FHNP\62\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`\2\3\3\2\6\t\u01a5\2b\3"+
		"\2\2\2\4f\3\2\2\2\6l\3\2\2\2\bn\3\2\2\2\nr\3\2\2\2\f\177\3\2\2\2\16\u0081"+
		"\3\2\2\2\20\u0083\3\2\2\2\22\u008d\3\2\2\2\24\u0090\3\2\2\2\26\u0092\3"+
		"\2\2\2\30\u009a\3\2\2\2\32\u00a3\3\2\2\2\34\u00a5\3\2\2\2\36\u00aa\3\2"+
		"\2\2 \u00ae\3\2\2\2\"\u00b6\3\2\2\2$\u00bc\3\2\2\2&\u00c1\3\2\2\2(\u00ca"+
		"\3\2\2\2*\u00cc\3\2\2\2,\u00cf\3\2\2\2.\u00d4\3\2\2\2\60\u00d6\3\2\2\2"+
		"\62\u00d9\3\2\2\2\64\u00df\3\2\2\2\66\u00e3\3\2\2\28\u00e7\3\2\2\2:\u00e9"+
		"\3\2\2\2<\u00ff\3\2\2\2>\u0101\3\2\2\2@\u010b\3\2\2\2B\u0115\3\2\2\2D"+
		"\u011d\3\2\2\2F\u011f\3\2\2\2H\u012a\3\2\2\2J\u013e\3\2\2\2L\u0151\3\2"+
		"\2\2N\u0153\3\2\2\2P\u0161\3\2\2\2R\u0177\3\2\2\2T\u017e\3\2\2\2V\u0187"+
		"\3\2\2\2X\u0189\3\2\2\2Z\u0190\3\2\2\2\\\u0192\3\2\2\2^\u0198\3\2\2\2"+
		"`\u019a\3\2\2\2bc\5\4\3\2cd\7\2\2\3d\3\3\2\2\2eg\5\6\4\2fe\3\2\2\2gh\3"+
		"\2\2\2hf\3\2\2\2hi\3\2\2\2i\5\3\2\2\2jm\5\b\5\2km\5\20\t\2lj\3\2\2\2l"+
		"k\3\2\2\2m\7\3\2\2\2no\5\16\b\2op\5\n\6\2pq\7 \2\2q\t\3\2\2\2rw\5\f\7"+
		"\2st\7!\2\2tv\5\f\7\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\13\3\2"+
		"\2\2yw\3\2\2\2z\u0080\7\31\2\2{|\7\31\2\2|}\7\36\2\2}~\7\26\2\2~\u0080"+
		"\7\37\2\2\177z\3\2\2\2\177{\3\2\2\2\u0080\r\3\2\2\2\u0081\u0082\t\2\2"+
		"\2\u0082\17\3\2\2\2\u0083\u0084\5\22\n\2\u0084\u0085\7\31\2\2\u0085\u0086"+
		"\7\32\2\2\u0086\u0087\5\24\13\2\u0087\u0088\7\33\2\2\u0088\u0089\5 \21"+
		"\2\u0089\21\3\2\2\2\u008a\u008e\5\16\b\2\u008b\u008e\7\n\2\2\u008c\u008e"+
		"\5\36\20\2\u008d\u008a\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2"+
		"\u008e\23\3\2\2\2\u008f\u0091\5\26\f\2\u0090\u008f\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\25\3\2\2\2\u0092\u0097\5\30\r\2\u0093\u0094\7!\2\2\u0094"+
		"\u0096\5\30\r\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3"+
		"\2\2\2\u0097\u0098\3\2\2\2\u0098\27\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"\u009f\5\16\b\2\u009b\u00a0\7\31\2\2\u009c\u009d\7\31\2\2\u009d\u009e"+
		"\7\36\2\2\u009e\u00a0\7\37\2\2\u009f\u009b\3\2\2\2\u009f\u009c\3\2\2\2"+
		"\u00a0\31\3\2\2\2\u00a1\u00a4\5\34\17\2\u00a2\u00a4\5\36\20\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\33\3\2\2\2\u00a5\u00a6\5\16\b\2\u00a6"+
		"\u00a7\7\31\2\2\u00a7\u00a8\7\36\2\2\u00a8\u00a9\7\37\2\2\u00a9\35\3\2"+
		"\2\2\u00aa\u00ab\5\16\b\2\u00ab\u00ac\7\36\2\2\u00ac\u00ad\7\37\2\2\u00ad"+
		"\37\3\2\2\2\u00ae\u00af\7\34\2\2\u00af\u00b0\5\"\22\2\u00b0\u00b1\5$\23"+
		"\2\u00b1\u00b2\7\35\2\2\u00b2!\3\2\2\2\u00b3\u00b5\5\b\5\2\u00b4\u00b3"+
		"\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"#\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\5&\24\2\u00ba\u00b9\3\2\2\2"+
		"\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd%\3"+
		"\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\58\35\2\u00c0\u00c2\5(\25\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\'\3\2\2\2\u00c3\u00cb\5@!\2\u00c4"+
		"\u00cb\5> \2\u00c5\u00cb\5*\26\2\u00c6\u00cb\5,\27\2\u00c7\u00cb\5.\30"+
		"\2\u00c8\u00cb\5B\"\2\u00c9\u00cb\5 \21\2\u00ca\u00c3\3\2\2\2\u00ca\u00c4"+
		"\3\2\2\2\u00ca\u00c5\3\2\2\2\u00ca\u00c6\3\2\2\2\u00ca\u00c7\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb)\3\2\2\2\u00cc\u00cd\7\13\2\2"+
		"\u00cd\u00ce\7 \2\2\u00ce+\3\2\2\2\u00cf\u00d0\7\f\2\2\u00d0\u00d1\7 "+
		"\2\2\u00d1-\3\2\2\2\u00d2\u00d5\5\60\31\2\u00d3\u00d5\5\62\32\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5/\3\2\2\2\u00d6\u00d7\7\20\2\2"+
		"\u00d7\u00d8\7 \2\2\u00d8\61\3\2\2\2\u00d9\u00da\7\20\2\2\u00da\u00db"+
		"\5D#\2\u00db\u00dc\7 \2\2\u00dc\63\3\2\2\2\u00dd\u00e0\5:\36\2\u00de\u00e0"+
		"\5(\25\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\65\3\2\2\2\u00e1"+
		"\u00e4\5<\37\2\u00e2\u00e4\5(\25\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2"+
		"\2\2\u00e4\67\3\2\2\2\u00e5\u00e8\5:\36\2\u00e6\u00e8\5<\37\2\u00e7\u00e5"+
		"\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e89\3\2\2\2\u00e9\u00ea\7\r\2\2\u00ea"+
		"\u00eb\7\32\2\2\u00eb\u00ec\5D#\2\u00ec\u00ed\7\33\2\2\u00ed\u00ee\5\64"+
		"\33\2\u00ee\u00ef\7\16\2\2\u00ef\u00f0\5\64\33\2\u00f0;\3\2\2\2\u00f1"+
		"\u00f2\7\r\2\2\u00f2\u00f3\7\32\2\2\u00f3\u00f4\5D#\2\u00f4\u00f5\7\33"+
		"\2\2\u00f5\u00f6\5&\24\2\u00f6\u0100\3\2\2\2\u00f7\u00f8\7\r\2\2\u00f8"+
		"\u00f9\7\32\2\2\u00f9\u00fa\5D#\2\u00fa\u00fb\7\33\2\2\u00fb\u00fc\5\64"+
		"\33\2\u00fc\u00fd\7\16\2\2\u00fd\u00fe\5\66\34\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00f1\3\2\2\2\u00ff\u00f7\3\2\2\2\u0100=\3\2\2\2\u0101\u0103\7\22\2\2"+
		"\u0102\u0104\5&\24\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103"+
		"\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7\21\2\2"+
		"\u0108\u0109\5D#\2\u0109\u010a\7 \2\2\u010a?\3\2\2\2\u010b\u010c\7\17"+
		"\2\2\u010c\u010d\7\32\2\2\u010d\u010e\5D#\2\u010e\u010f\7 \2\2\u010f\u0110"+
		"\5D#\2\u0110\u0111\7 \2\2\u0111\u0112\5D#\2\u0112\u0113\7\33\2\2\u0113"+
		"\u0114\5&\24\2\u0114A\3\2\2\2\u0115\u0116\5D#\2\u0116\u0117\7 \2\2\u0117"+
		"C\3\2\2\2\u0118\u0119\5F$\2\u0119\u011a\7\60\2\2\u011a\u011b\5D#\2\u011b"+
		"\u011e\3\2\2\2\u011c\u011e\5F$\2\u011d\u0118\3\2\2\2\u011d\u011c\3\2\2"+
		"\2\u011eE\3\2\2\2\u011f\u0120\b$\1\2\u0120\u0121\5H%\2\u0121\u0127\3\2"+
		"\2\2\u0122\u0123\f\4\2\2\u0123\u0124\7/\2\2\u0124\u0126\5H%\2\u0125\u0122"+
		"\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"G\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\b%\1\2\u012b\u012c\5J&\2\u012c"+
		"\u0132\3\2\2\2\u012d\u012e\f\4\2\2\u012e\u012f\7.\2\2\u012f\u0131\5J&"+
		"\2\u0130\u012d\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133"+
		"\3\2\2\2\u0133I\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\5L\'\2\u0136\u0137"+
		"\7,\2\2\u0137\u0138\5L\'\2\u0138\u013f\3\2\2\2\u0139\u013a\5L\'\2\u013a"+
		"\u013b\7-\2\2\u013b\u013c\5L\'\2\u013c\u013f\3\2\2\2\u013d\u013f\5L\'"+
		"\2\u013e\u0135\3\2\2\2\u013e\u0139\3\2\2\2\u013e\u013d\3\2\2\2\u013fK"+
		"\3\2\2\2\u0140\u0141\5N(\2\u0141\u0142\7(\2\2\u0142\u0143\5N(\2\u0143"+
		"\u0152\3\2\2\2\u0144\u0145\5N(\2\u0145\u0146\7*\2\2\u0146\u0147\5N(\2"+
		"\u0147\u0152\3\2\2\2\u0148\u0149\5N(\2\u0149\u014a\7)\2\2\u014a\u014b"+
		"\5N(\2\u014b\u0152\3\2\2\2\u014c\u014d\5N(\2\u014d\u014e\7+\2\2\u014e"+
		"\u014f\5N(\2\u014f\u0152\3\2\2\2\u0150\u0152\5N(\2\u0151\u0140\3\2\2\2"+
		"\u0151\u0144\3\2\2\2\u0151\u0148\3\2\2\2\u0151\u014c\3\2\2\2\u0151\u0150"+
		"\3\2\2\2\u0152M\3\2\2\2\u0153\u0154\b(\1\2\u0154\u0155\5P)\2\u0155\u015e"+
		"\3\2\2\2\u0156\u0157\f\5\2\2\u0157\u0158\7&\2\2\u0158\u015d\5P)\2\u0159"+
		"\u015a\f\4\2\2\u015a\u015b\7\'\2\2\u015b\u015d\5P)\2\u015c\u0156\3\2\2"+
		"\2\u015c\u0159\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f"+
		"\3\2\2\2\u015fO\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\b)\1\2\u0162\u0163"+
		"\5R*\2\u0163\u016f\3\2\2\2\u0164\u0165\f\6\2\2\u0165\u0166\7$\2\2\u0166"+
		"\u016e\5R*\2\u0167\u0168\f\5\2\2\u0168\u0169\7#\2\2\u0169\u016e\5R*\2"+
		"\u016a\u016b\f\4\2\2\u016b\u016c\7%\2\2\u016c\u016e\5R*\2\u016d\u0164"+
		"\3\2\2\2\u016d\u0167\3\2\2\2\u016d\u016a\3\2\2\2\u016e\u0171\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170Q\3\2\2\2\u0171\u016f\3\2\2\2"+
		"\u0172\u0173\7\'\2\2\u0173\u0178\5R*\2\u0174\u0175\7\"\2\2\u0175\u0178"+
		"\5R*\2\u0176\u0178\5T+\2\u0177\u0172\3\2\2\2\u0177\u0174\3\2\2\2\u0177"+
		"\u0176\3\2\2\2\u0178S\3\2\2\2\u0179\u017a\7\32\2\2\u017a\u017b\5D#\2\u017b"+
		"\u017c\7\33\2\2\u017c\u017f\3\2\2\2\u017d\u017f\5V,\2\u017e\u0179\3\2"+
		"\2\2\u017e\u017d\3\2\2\2\u017fU\3\2\2\2\u0180\u0188\5X-\2\u0181\u0188"+
		"\5\\/\2\u0182\u0188\7\26\2\2\u0183\u0188\7\27\2\2\u0184\u0188\7\30\2\2"+
		"\u0185\u0188\7\23\2\2\u0186\u0188\7\31\2\2\u0187\u0180\3\2\2\2\u0187\u0181"+
		"\3\2\2\2\u0187\u0182\3\2\2\2\u0187\u0183\3\2\2\2\u0187\u0184\3\2\2\2\u0187"+
		"\u0185\3\2\2\2\u0187\u0186\3\2\2\2\u0188W\3\2\2\2\u0189\u018a\5Z.\2\u018a"+
		"\u018b\7\36\2\2\u018b\u018c\5D#\2\u018c\u018d\7\37\2\2\u018dY\3\2\2\2"+
		"\u018e\u0191\5\\/\2\u018f\u0191\7\31\2\2\u0190\u018e\3\2\2\2\u0190\u018f"+
		"\3\2\2\2\u0191[\3\2\2\2\u0192\u0193\7\31\2\2\u0193\u0194\7\32\2\2\u0194"+
		"\u0195\5^\60\2\u0195\u0196\7\33\2\2\u0196]\3\2\2\2\u0197\u0199\5`\61\2"+
		"\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199_\3\2\2\2\u019a\u019f\5"+
		"D#\2\u019b\u019c\7!\2\2\u019c\u019e\5D#\2\u019d\u019b\3\2\2\2\u019e\u01a1"+
		"\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0a\3\2\2\2\u01a1"+
		"\u019f\3\2\2\2$hlw\177\u008d\u0090\u0097\u009f\u00a3\u00b6\u00bc\u00c1"+
		"\u00ca\u00d4\u00df\u00e3\u00e7\u00ff\u0105\u011d\u0127\u0132\u013e\u0151"+
		"\u015c\u015e\u016d\u016f\u0177\u017e\u0187\u0190\u0198\u019f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}