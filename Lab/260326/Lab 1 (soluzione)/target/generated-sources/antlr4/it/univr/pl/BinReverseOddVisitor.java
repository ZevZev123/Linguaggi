// Generated from it/univr/pl/BinReverseOdd.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BinReverseOddParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BinReverseOddVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BinReverseOddParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(BinReverseOddParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link BinReverseOddParser#rev}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRev(BinReverseOddParser.RevContext ctx);
}