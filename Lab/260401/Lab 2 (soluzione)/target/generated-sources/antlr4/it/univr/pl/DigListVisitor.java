// Generated from it/univr/pl/DigList.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DigListParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DigListVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DigListParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(DigListParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link DigListParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(DigListParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DigListParser#dig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDig(DigListParser.DigContext ctx);
	/**
	 * Visit a parse tree produced by {@link DigListParser#tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTail(DigListParser.TailContext ctx);
}