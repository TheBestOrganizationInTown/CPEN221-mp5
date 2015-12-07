// Generated from Grammar.g4 by ANTLR 4.4

package ca.ece.ubc.cpen221.mp5;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#in}.
	 * @param ctx the parse tree
	 */
	void enterIn(@NotNull GrammarParser.InContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#in}.
	 * @param ctx the parse tree
	 */
	void exitIn(@NotNull GrammarParser.InContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#price}.
	 * @param ctx the parse tree
	 */
	void enterPrice(@NotNull GrammarParser.PriceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#price}.
	 * @param ctx the parse tree
	 */
	void exitPrice(@NotNull GrammarParser.PriceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(@NotNull GrammarParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(@NotNull GrammarParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rating}.
	 * @param ctx the parse tree
	 */
	void enterRating(@NotNull GrammarParser.RatingContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rating}.
	 * @param ctx the parse tree
	 */
	void exitRating(@NotNull GrammarParser.RatingContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull GrammarParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull GrammarParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(@NotNull GrammarParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(@NotNull GrammarParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull GrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull GrammarParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#category}.
	 * @param ctx the parse tree
	 */
	void enterCategory(@NotNull GrammarParser.CategoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#category}.
	 * @param ctx the parse tree
	 */
	void exitCategory(@NotNull GrammarParser.CategoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull GrammarParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull GrammarParser.AndExprContext ctx);
}