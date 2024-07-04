// Generated from C:/Users/Davide Pinto/OneDrive/Área de Trabalho/Compiladores/T3_Final/src/Tasm.g4 by ANTLR 4.13.1
package Tasm;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TasmParser}.
 */
public interface TasmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TasmParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(TasmParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(TasmParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#labels}.
	 * @param ctx the parse tree
	 */
	void enterLabels(TasmParser.LabelsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#labels}.
	 * @param ctx the parse tree
	 */
	void exitLabels(TasmParser.LabelsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TasmParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(TasmParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TasmParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(TasmParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Iconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIconst(TasmParser.IconstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Iconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIconst(TasmParser.IconstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Dconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDconst(TasmParser.DconstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Dconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDconst(TasmParser.DconstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSconst(TasmParser.SconstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSconst(TasmParser.SconstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Jump}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterJump(TasmParser.JumpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Jump}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitJump(TasmParser.JumpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Jumpt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterJumpt(TasmParser.JumptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Jumpt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitJumpt(TasmParser.JumptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Jumpf}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterJumpf(TasmParser.JumpfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Jumpf}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitJumpf(TasmParser.JumpfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Galloc}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterGalloc(TasmParser.GallocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Galloc}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitGalloc(TasmParser.GallocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Gload}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterGload(TasmParser.GloadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Gload}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitGload(TasmParser.GloadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Gstore}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterGstore(TasmParser.GstoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Gstore}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitGstore(TasmParser.GstoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IPrint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIPrint(TasmParser.IPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IPrint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIPrint(TasmParser.IPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Iuminus}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIuminus(TasmParser.IuminusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Iuminus}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIuminus(TasmParser.IuminusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IAdd}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIAdd(TasmParser.IAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IAdd}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIAdd(TasmParser.IAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ISub}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterISub(TasmParser.ISubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ISub}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitISub(TasmParser.ISubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ilt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIlt(TasmParser.IltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ilt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIlt(TasmParser.IltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IMult}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIMult(TasmParser.IMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IMult}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIMult(TasmParser.IMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDiv}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIDiv(TasmParser.IDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDiv}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIDiv(TasmParser.IDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IMod}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIMod(TasmParser.IModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IMod}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIMod(TasmParser.IModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IEq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIEq(TasmParser.IEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IEq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIEq(TasmParser.IEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterINeq(TasmParser.INeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitINeq(TasmParser.INeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ILeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterILeq(TasmParser.ILeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ILeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitILeq(TasmParser.ILeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ITod}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterITod(TasmParser.ITodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ITod}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitITod(TasmParser.ITodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ITos}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterITos(TasmParser.ITosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ITos}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitITos(TasmParser.ITosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DPrint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDPrint(TasmParser.DPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DPrint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDPrint(TasmParser.DPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Duminus}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDuminus(TasmParser.DuminusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Duminus}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDuminus(TasmParser.DuminusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DAdd}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDAdd(TasmParser.DAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DAdd}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDAdd(TasmParser.DAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DSub}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDSub(TasmParser.DSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DSub}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDSub(TasmParser.DSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DMult}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDMult(TasmParser.DMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DMult}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDMult(TasmParser.DMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DDiv}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDDiv(TasmParser.DDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DDiv}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDDiv(TasmParser.DDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DEq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDEq(TasmParser.DEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DEq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDEq(TasmParser.DEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DNeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDNeq(TasmParser.DNeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DNeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDNeq(TasmParser.DNeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Dlt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDlt(TasmParser.DltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Dlt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDlt(TasmParser.DltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Dleq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDleq(TasmParser.DleqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Dleq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDleq(TasmParser.DleqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Dtos}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDtos(TasmParser.DtosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Dtos}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDtos(TasmParser.DtosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SPrint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSPrint(TasmParser.SPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SPrint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSPrint(TasmParser.SPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SAdd}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSAdd(TasmParser.SAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SAdd}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSAdd(TasmParser.SAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Seq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSeq(TasmParser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Seq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSeq(TasmParser.SeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SNeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSNeq(TasmParser.SNeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SNeq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSNeq(TasmParser.SNeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Beq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBeq(TasmParser.BeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Beq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBeq(TasmParser.BeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bneq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBneq(TasmParser.BneqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bneq}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBneq(TasmParser.BneqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Btos}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBtos(TasmParser.BtosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Btos}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBtos(TasmParser.BtosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAnd(TasmParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAnd(TasmParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterOr(TasmParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitOr(TasmParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterNot(TasmParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitNot(TasmParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Tconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterTconst(TasmParser.TconstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Tconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitTconst(TasmParser.TconstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Fconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterFconst(TasmParser.FconstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Fconst}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitFconst(TasmParser.FconstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bprint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBprint(TasmParser.BprintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bprint}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBprint(TasmParser.BprintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Halt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterHalt(TasmParser.HaltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Halt}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitHalt(TasmParser.HaltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lalloc}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterLalloc(TasmParser.LallocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lalloc}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitLalloc(TasmParser.LallocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lload}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterLload(TasmParser.LloadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lload}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitLload(TasmParser.LloadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lstore}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterLstore(TasmParser.LstoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lstore}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitLstore(TasmParser.LstoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pop}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPop(TasmParser.PopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pop}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPop(TasmParser.PopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterCall(TasmParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitCall(TasmParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Retval}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterRetval(TasmParser.RetvalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Retval}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitRetval(TasmParser.RetvalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ret}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterRet(TasmParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ret}
	 * labeled alternative in {@link TasmParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitRet(TasmParser.RetContext ctx);
}