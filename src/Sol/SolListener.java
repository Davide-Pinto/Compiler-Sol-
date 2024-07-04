// Generated from C:/Users/Davide Pinto/OneDrive/Área de Trabalho/Compiladores/T3_Final/src/Sol.g4 by ANTLR 4.13.1
package Sol;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SolParser}.
 */
public interface SolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SolParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(SolParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(SolParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SolParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SolParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Print}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint(SolParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint(SolParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarChange}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterVarChange(SolParser.VarChangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarChange}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitVarChange(SolParser.VarChangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Blocks}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlocks(SolParser.BlocksContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Blocks}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlocks(SolParser.BlocksContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile(SolParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile(SolParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code For}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor(SolParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code For}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor(SolParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(SolParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(SolParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Break}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreak(SolParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Break}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreak(SolParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Empty}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterEmpty(SolParser.EmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Empty}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitEmpty(SolParser.EmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallStmt}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterCallStmt(SolParser.CallStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallStmt}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitCallStmt(SolParser.CallStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Return}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn(SolParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link SolParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn(SolParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SolParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SolParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(SolParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(SolParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(SolParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(SolParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(SolParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(SolParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(SolParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(SolParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SolParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SolParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SolParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(SolParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(SolParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd(SolParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd(SolParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSub(SolParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSub(SolParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bethan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBethan(SolParser.BethanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bethan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBethan(SolParser.BethanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mod}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMod(SolParser.ModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mod}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMod(SolParser.ModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(SolParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(SolParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Notequals}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotequals(SolParser.NotequalsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Notequals}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotequals(SolParser.NotequalsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(SolParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(SolParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lthan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLthan(SolParser.LthanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lthan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLthan(SolParser.LthanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(SolParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(SolParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Double}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDouble(SolParser.DoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDouble(SolParser.DoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(SolParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(SolParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lethan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLethan(SolParser.LethanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lethan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLethan(SolParser.LethanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDiv(SolParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDiv(SolParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(SolParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(SolParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEquals(SolParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEquals(SolParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMult(SolParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMult(SolParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBool(SolParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBool(SolParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(SolParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(SolParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(SolParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(SolParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bthan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBthan(SolParser.BthanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bthan}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBthan(SolParser.BthanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(SolParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(SolParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinus(SolParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link SolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinus(SolParser.MinusContext ctx);
}