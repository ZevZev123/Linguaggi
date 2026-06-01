// Generated from it/univr/pl/ImpStr.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ImpStrParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ImpStrVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ImpStrParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(ImpStrParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link ImpStrParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(ImpStrParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link ImpStrParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(ImpStrParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElse}
	 * labeled alternative in {@link ImpStrParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(ImpStrParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nop}
	 * labeled alternative in {@link ImpStrParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNop(ImpStrParser.NopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seq}
	 * labeled alternative in {@link ImpStrParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(ImpStrParser.SeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ImpStrParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ImpStrParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code out}
	 * labeled alternative in {@link ImpStrParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOut(ImpStrParser.OutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tostr}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTostr(ImpStrParser.TostrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivMod}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(ImpStrParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ImpStrParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numeric}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric(ImpStrParser.NumericContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(ImpStrParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(ImpStrParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOr}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOr(ImpStrParser.AndOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(ImpStrParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(ImpStrParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(ImpStrParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmpExp}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExp(ImpStrParser.CmpExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExp}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExp(ImpStrParser.ParExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pow}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(ImpStrParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ImpStrParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ImpStrParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intNum}
	 * labeled alternative in {@link ImpStrParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntNum(ImpStrParser.IntNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decNum}
	 * labeled alternative in {@link ImpStrParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecNum(ImpStrParser.DecNumContext ctx);
}