// Generated from it/univr/pl/BinReverse.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BinReverseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BinReverseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BinReverseParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(BinReverseParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link BinReverseParser#rev}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRev(BinReverseParser.RevContext ctx);
}