// Generated from it/univr/pl/RecDigList.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RecDigListParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RecDigListVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RecDigListParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(RecDigListParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecDigListParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(RecDigListParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecDigListParser#dig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDig(RecDigListParser.DigContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecDigListParser#tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTail(RecDigListParser.TailContext ctx);
}