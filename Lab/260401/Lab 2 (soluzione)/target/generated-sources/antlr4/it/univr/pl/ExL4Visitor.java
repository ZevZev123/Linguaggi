// Generated from it/univr/pl/ExL4.g4 by ANTLR 4.13.2
package it.univr.pl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExL4Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExL4Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExL4Parser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(ExL4Parser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExL4Parser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(ExL4Parser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExL4Parser#s1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS1(ExL4Parser.S1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ExL4Parser#s2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS2(ExL4Parser.S2Context ctx);
}