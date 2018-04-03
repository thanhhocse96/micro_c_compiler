// Generated from src/main/mc/parser/MC.g4 by ANTLR 4.6

	package mc.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MCParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MCParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#declList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclList(MCParser.DeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(MCParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MCParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#manyVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManyVar(MCParser.ManyVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MCParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(MCParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#funcDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(MCParser.FuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(MCParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#paraList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParaList(MCParser.ParaListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#paraListNonNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParaListNonNull(MCParser.ParaListNonNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#paraDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParaDecl(MCParser.ParaDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#arrayPointerType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayPointerType(MCParser.ArrayPointerTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#inputArrPointerType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputArrPointerType(MCParser.InputArrPointerTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#outputArrPointerType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputArrPointerType(MCParser.OutputArrPointerTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#blockStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(MCParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#declPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclPart(MCParser.DeclPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#stmtPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtPart(MCParser.StmtPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(MCParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#otherStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherStmt(MCParser.OtherStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(MCParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#continueStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(MCParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MCParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#noExpReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoExpReturn(MCParser.NoExpReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#aExpReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAExpReturn(MCParser.AExpReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#stmtmatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtmatch(MCParser.StmtmatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#stmtunmatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtunmatch(MCParser.StmtunmatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MCParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#ifmatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfmatch(MCParser.IfmatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#ifunmatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfunmatch(MCParser.IfunmatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#dowhileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDowhileStmt(MCParser.DowhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(MCParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#expStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpStmt(MCParser.ExpStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#exp0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp0(MCParser.Exp0Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#exp1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp1(MCParser.Exp1Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#exp2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp2(MCParser.Exp2Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#exp3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp3(MCParser.Exp3Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#exp4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp4(MCParser.Exp4Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#exp5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp5(MCParser.Exp5Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#exp6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp6(MCParser.Exp6Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#exp7}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp7(MCParser.Exp7Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#exp8}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp8(MCParser.Exp8Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#exp9}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp9(MCParser.Exp9Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#indexExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExp(MCParser.IndexExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#indexer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexer(MCParser.IndexerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(MCParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(MCParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#argListNonNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgListNonNull(MCParser.ArgListNonNullContext ctx);
}