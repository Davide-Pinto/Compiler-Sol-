// Generated from C:/Users/Davide Pinto/OneDrive/Área de Trabalho/Compiladores/T3_Final/src/Tasm.g4 by ANTLR 4.13.1
package Tasm;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TasmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TasmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TasmParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(TasmParser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#labels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabels(TasmParser.LabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TasmParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(TasmParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Iconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIconst(TasmParser.IconstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Dconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDconst(TasmParser.DconstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSconst(TasmParser.SconstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Jump}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump(TasmParser.JumpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Jumpt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpt(TasmParser.JumptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Jumpf}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpf(TasmParser.JumpfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Galloc}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGalloc(TasmParser.GallocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Gload}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGload(TasmParser.GloadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Gstore}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGstore(TasmParser.GstoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IPrint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIPrint(TasmParser.IPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Iuminus}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIuminus(TasmParser.IuminusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IAdd}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIAdd(TasmParser.IAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ISub}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitISub(TasmParser.ISubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ilt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIlt(TasmParser.IltContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IMult}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIMult(TasmParser.IMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDiv}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDiv(TasmParser.IDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IMod}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIMod(TasmParser.IModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IEq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIEq(TasmParser.IEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINeq(TasmParser.INeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ILeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitILeq(TasmParser.ILeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ITod}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITod(TasmParser.ITodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ITos}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITos(TasmParser.ITosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DPrint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDPrint(TasmParser.DPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Duminus}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuminus(TasmParser.DuminusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DAdd}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDAdd(TasmParser.DAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DSub}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDSub(TasmParser.DSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DMult}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDMult(TasmParser.DMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DDiv}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDDiv(TasmParser.DDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DEq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDEq(TasmParser.DEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DNeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDNeq(TasmParser.DNeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Dlt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDlt(TasmParser.DltContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Dleq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDleq(TasmParser.DleqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Dtos}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDtos(TasmParser.DtosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SPrint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSPrint(TasmParser.SPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SAdd}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSAdd(TasmParser.SAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Seq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(TasmParser.SeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SNeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSNeq(TasmParser.SNeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Beq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeq(TasmParser.BeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bneq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBneq(TasmParser.BneqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Btos}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBtos(TasmParser.BtosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(TasmParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(TasmParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(TasmParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Tconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTconst(TasmParser.TconstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Fconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFconst(TasmParser.FconstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bprint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBprint(TasmParser.BprintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Halt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalt(TasmParser.HaltContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lalloc}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLalloc(TasmParser.LallocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lload}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLload(TasmParser.LloadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lstore}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLstore(TasmParser.LstoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pop}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPop(TasmParser.PopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(TasmParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Retval}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetval(TasmParser.RetvalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ret}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(TasmParser.RetContext ctx);
}