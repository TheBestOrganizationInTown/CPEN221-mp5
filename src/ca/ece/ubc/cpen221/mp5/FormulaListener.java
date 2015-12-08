// Generated from Formula.g4 by ANTLR 4.4

package ca.ece.ubc.cpen221.mp5;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormulaParser}.
 */
public interface FormulaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormulaParser#in}.
	 * @param ctx the parse tree
	 */
	void enterIn(@NotNull FormulaParser.InContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#in}.
	 * @param ctx the parse tree
	 */
	void exitIn(@NotNull FormulaParser.InContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#price}.
	 * @param ctx the parse tree
	 */
	void enterPrice(@NotNull FormulaParser.PriceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#price}.
	 * @param ctx the parse tree
	 */
	void exitPrice(@NotNull FormulaParser.PriceContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(@NotNull FormulaParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(@NotNull FormulaParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#rating}.
	 * @param ctx the parse tree
	 */
	void enterRating(@NotNull FormulaParser.RatingContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#rating}.
	 * @param ctx the parse tree
	 */
	void exitRating(@NotNull FormulaParser.RatingContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull FormulaParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull FormulaParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(@NotNull FormulaParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(@NotNull FormulaParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull FormulaParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull FormulaParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#category}.
	 * @param ctx the parse tree
	 */
	void enterCategory(@NotNull FormulaParser.CategoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#category}.
	 * @param ctx the parse tree
	 */
	void exitCategory(@NotNull FormulaParser.CategoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull FormulaParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull FormulaParser.AndExprContext ctx);
}