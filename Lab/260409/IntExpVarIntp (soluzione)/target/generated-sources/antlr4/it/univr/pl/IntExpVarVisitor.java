// Generated from it/univr/pl/IntExpVar.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IntExpVarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IntExpVarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IntExpVarParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(IntExpVarParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntExpVarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(IntExpVarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idinit}
	 * labeled alternative in {@link IntExpVarParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdinit(IntExpVarParser.IdinitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nilinit}
	 * labeled alternative in {@link IntExpVarParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNilinit(IntExpVarParser.NilinitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code val}
	 * labeled alternative in {@link IntExpVarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(IntExpVarParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link IntExpVarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(IntExpVarParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add}
	 * labeled alternative in {@link IntExpVarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(IntExpVarParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul}
	 * labeled alternative in {@link IntExpVarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(IntExpVarParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sub}
	 * labeled alternative in {@link IntExpVarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(IntExpVarParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code div}
	 * labeled alternative in {@link IntExpVarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(IntExpVarParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mod}
	 * labeled alternative in {@link IntExpVarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMod(IntExpVarParser.ModContext ctx);
}