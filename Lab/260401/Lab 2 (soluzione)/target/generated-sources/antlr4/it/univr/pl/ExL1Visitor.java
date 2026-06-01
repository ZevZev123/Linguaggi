// Generated from it/univr/pl/ExL1.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExL1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExL1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExL1Parser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(ExL1Parser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExL1Parser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(ExL1Parser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExL1Parser#x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX(ExL1Parser.XContext ctx);
}