// Generated from it/univr/pl/ExL3.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExL3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExL3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExL3Parser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(ExL3Parser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExL3Parser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA(ExL3Parser.AContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExL3Parser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitB(ExL3Parser.BContext ctx);
}