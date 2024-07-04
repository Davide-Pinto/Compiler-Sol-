// Generated from C:/Users/Davide Pinto/OneDrive/Área de Trabalho/Compiladores/T3_Final/src/Sol.g4 by ANTLR 4.13.1
package Sol;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SolVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SolParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(SolParser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SolParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(SolParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarChange}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarChange(SolParser.VarChangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Blocks}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlocks(SolParser.BlocksContext ctx);
	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(SolParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code For}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(SolParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(SolParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Break}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(SolParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Empty}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(SolParser.EmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallStmt}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStmt(SolParser.CallStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(SolParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SolParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(SolParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(SolParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(SolParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(SolParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SolParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SolParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(SolParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(SolParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(SolParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bethan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBethan(SolParser.BethanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mod}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMod(SolParser.ModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(SolParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Notequals}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotequals(SolParser.NotequalsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(SolParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lthan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLthan(SolParser.LthanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(SolParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(SolParser.DoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(SolParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lethan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLethan(SolParser.LethanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(SolParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(SolParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(SolParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(SolParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(SolParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(SolParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(SolParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bthan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBthan(SolParser.BthanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(SolParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(SolParser.MinusContext ctx);
}