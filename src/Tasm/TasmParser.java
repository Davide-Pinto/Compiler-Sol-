// Generated from C:/Users/Davide Pinto/OneDrive/Área de Trabalho/Compiladores/T3_Final/src/Tasm.g4 by ANTLR 4.13.1
package Tasm;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TasmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LALLOC=2, LLOAD=3, LSTORE=4, POP=5, CALL=6, RETVAL=7, RET=8, IMULT=9, 
		IADD=10, IDIV=11, ISUB=12, IUMINUS=13, IMOD=14, IEQ=15, INEQ=16, ILT=17, 
		ILEQ=18, ITOD=19, ITOS=20, DUMINUS=21, DADD=22, DSUB=23, DMULT=24, DDIV=25, 
		DEQ=26, DNEQ=27, DLT=28, DLEQ=29, DTOS=30, BEQ=31, BNEQ=32, BTOS=33, AND=34, 
		OR=35, NOT=36, SADD=37, SEQ=38, SNEQ=39, ICONST=40, DCONST=41, SCONST=42, 
		JUMP=43, JUMPT=44, JUMPF=45, GALLOC=46, GLOAD=47, GSTORE=48, IPRINT=49, 
		DPRINT=50, SPRINT=51, BPRINT=52, TCONST=53, FCONST=54, HALT=55, DOUBLE=56, 
		INT=57, QM=58, STRING=59, COLON=60, NEWLINE=61, WS=62, LABEL=63;
	public static final int
		RULE_s = 0, RULE_labels = 1, RULE_prog = 2, RULE_stmt = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"s", "labels", "prog", "stmt"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'lalloc'", "'lload'", "'lstore'", "'pop'", "'call'", "'retval'", 
			"'ret'", "'imult'", "'iadd'", "'idiv'", "'isub'", "'iuminus'", "'imod'", 
			"'ieq'", "'ineq'", "'ilt'", "'ileq'", "'itod'", "'itos'", "'duminus'", 
			"'dadd'", "'dsub'", "'dmult'", "'ddiv'", "'deq'", "'dneq'", "'dlt'", 
			"'dleq'", "'dtos'", "'beq'", "'bneq'", "'btos'", "'and'", "'or'", "'not'", 
			"'sadd'", "'seq'", "'sneq'", "'iconst'", "'dconst'", "'sconst'", "'jump'", 
			"'jumpt'", "'jumpf'", "'galloc'", "'gload'", "'gstore'", "'iprint'", 
			"'dprint'", "'sprint'", "'bprint'", "'tconst'", "'fconst'", "'halt'", 
			null, null, "'\"'", null, "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "LALLOC", "LLOAD", "LSTORE", "POP", "CALL", "RETVAL", "RET", 
			"IMULT", "IADD", "IDIV", "ISUB", "IUMINUS", "IMOD", "IEQ", "INEQ", "ILT", 
			"ILEQ", "ITOD", "ITOS", "DUMINUS", "DADD", "DSUB", "DMULT", "DDIV", "DEQ", 
			"DNEQ", "DLT", "DLEQ", "DTOS", "BEQ", "BNEQ", "BTOS", "AND", "OR", "NOT", 
			"SADD", "SEQ", "SNEQ", "ICONST", "DCONST", "SCONST", "JUMP", "JUMPT", 
			"JUMPF", "GALLOC", "GLOAD", "GSTORE", "IPRINT", "DPRINT", "SPRINT", "BPRINT", 
			"TCONST", "FCONST", "HALT", "DOUBLE", "INT", "QM", "STRING", "COLON", 
			"NEWLINE", "WS", "LABEL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Tasm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TasmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SContext extends ParserRuleContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			prog();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelsContext extends ParserRuleContext {
		public List<TerminalNode> LABEL() { return getTokens(TasmParser.LABEL); }
		public TerminalNode LABEL(int i) {
			return getToken(TasmParser.LABEL, i);
		}
		public LabelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labels; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterLabels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitLabels(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitLabels(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelsContext labels() throws RecognitionException {
		LabelsContext _localctx = new LabelsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_labels);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			match(LABEL);
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(11);
				match(T__0);
				setState(12);
				match(LABEL);
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(TasmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TasmParser.NEWLINE, i);
		}
		public List<LabelsContext> labels() {
			return getRuleContexts(LabelsContext.class);
		}
		public LabelsContext labels(int i) {
			return getRuleContext(LabelsContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(TasmParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(TasmParser.COLON, i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prog);
		int _la;
		try {
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LALLOC:
			case LLOAD:
			case LSTORE:
			case POP:
			case CALL:
			case RETVAL:
			case RET:
			case IMULT:
			case IADD:
			case IDIV:
			case ISUB:
			case IUMINUS:
			case IMOD:
			case IEQ:
			case INEQ:
			case ILT:
			case ILEQ:
			case ITOD:
			case ITOS:
			case DUMINUS:
			case DADD:
			case DSUB:
			case DMULT:
			case DDIV:
			case DEQ:
			case DNEQ:
			case DLT:
			case DLEQ:
			case DTOS:
			case BEQ:
			case BNEQ:
			case BTOS:
			case AND:
			case OR:
			case NOT:
			case SADD:
			case SEQ:
			case SNEQ:
			case ICONST:
			case DCONST:
			case SCONST:
			case JUMP:
			case JUMPT:
			case JUMPF:
			case GALLOC:
			case GLOAD:
			case GSTORE:
			case IPRINT:
			case DPRINT:
			case SPRINT:
			case BPRINT:
			case TCONST:
			case FCONST:
			case HALT:
			case LABEL:
				enterOuterAlt(_localctx, 1);
				{
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(21);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LABEL) {
						{
						setState(18);
						labels();
						setState(19);
						match(COLON);
						}
					}

					setState(23);
					stmt();
					setState(24);
					match(NEWLINE);
					}
					}
					setState(28); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -9151314442816847876L) != 0) );
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RetContext extends StmtContext {
		public TerminalNode RET() { return getToken(TasmParser.RET, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public RetContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IconstContext extends StmtContext {
		public TerminalNode ICONST() { return getToken(TasmParser.ICONST, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public IconstContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIconst(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends StmtContext {
		public TerminalNode OR() { return getToken(TasmParser.OR, 0); }
		public OrContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BneqContext extends StmtContext {
		public TerminalNode BNEQ() { return getToken(TasmParser.BNEQ, 0); }
		public BneqContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterBneq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitBneq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitBneq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IltContext extends StmtContext {
		public TerminalNode ILT() { return getToken(TasmParser.ILT, 0); }
		public IltContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIlt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIlt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIlt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JumpfContext extends StmtContext {
		public TerminalNode JUMPF() { return getToken(TasmParser.JUMPF, 0); }
		public TerminalNode LABEL() { return getToken(TasmParser.LABEL, 0); }
		public JumpfContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterJumpf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitJumpf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitJumpf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DEqContext extends StmtContext {
		public TerminalNode DEQ() { return getToken(TasmParser.DEQ, 0); }
		public DEqContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDEq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ISubContext extends StmtContext {
		public TerminalNode ISUB() { return getToken(TasmParser.ISUB, 0); }
		public ISubContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterISub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitISub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitISub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DNeqContext extends StmtContext {
		public TerminalNode DNEQ() { return getToken(TasmParser.DNEQ, 0); }
		public DNeqContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDNeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDNeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDNeq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DAddContext extends StmtContext {
		public TerminalNode DADD() { return getToken(TasmParser.DADD, 0); }
		public DAddContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SPrintContext extends StmtContext {
		public TerminalNode SPRINT() { return getToken(TasmParser.SPRINT, 0); }
		public SPrintContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterSPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitSPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitSPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDivContext extends StmtContext {
		public TerminalNode IDIV() { return getToken(TasmParser.IDIV, 0); }
		public IDivContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ILeqContext extends StmtContext {
		public TerminalNode ILEQ() { return getToken(TasmParser.ILEQ, 0); }
		public ILeqContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterILeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitILeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitILeq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LstoreContext extends StmtContext {
		public TerminalNode LSTORE() { return getToken(TasmParser.LSTORE, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public LstoreContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterLstore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitLstore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitLstore(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DconstContext extends StmtContext {
		public TerminalNode DCONST() { return getToken(TasmParser.DCONST, 0); }
		public TerminalNode DOUBLE() { return getToken(TasmParser.DOUBLE, 0); }
		public DconstContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDconst(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JumptContext extends StmtContext {
		public TerminalNode JUMPT() { return getToken(TasmParser.JUMPT, 0); }
		public TerminalNode LABEL() { return getToken(TasmParser.LABEL, 0); }
		public JumptContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterJumpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitJumpt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitJumpt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IMultContext extends StmtContext {
		public TerminalNode IMULT() { return getToken(TasmParser.IMULT, 0); }
		public IMultContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIMult(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PopContext extends StmtContext {
		public TerminalNode POP() { return getToken(TasmParser.POP, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public PopContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterPop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitPop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitPop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DDivContext extends StmtContext {
		public TerminalNode DDIV() { return getToken(TasmParser.DDIV, 0); }
		public DDivContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends StmtContext {
		public TerminalNode NOT() { return getToken(TasmParser.NOT, 0); }
		public NotContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class INeqContext extends StmtContext {
		public TerminalNode INEQ() { return getToken(TasmParser.INEQ, 0); }
		public INeqContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterINeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitINeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitINeq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RetvalContext extends StmtContext {
		public TerminalNode RETVAL() { return getToken(TasmParser.RETVAL, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public RetvalContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterRetval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitRetval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitRetval(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DtosContext extends StmtContext {
		public TerminalNode DTOS() { return getToken(TasmParser.DTOS, 0); }
		public DtosContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDtos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDtos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDtos(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GloadContext extends StmtContext {
		public TerminalNode GLOAD() { return getToken(TasmParser.GLOAD, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public GloadContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterGload(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitGload(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitGload(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends StmtContext {
		public TerminalNode AND() { return getToken(TasmParser.AND, 0); }
		public AndContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SconstContext extends StmtContext {
		public TerminalNode SCONST() { return getToken(TasmParser.SCONST, 0); }
		public TerminalNode STRING() { return getToken(TasmParser.STRING, 0); }
		public SconstContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterSconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitSconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitSconst(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IAddContext extends StmtContext {
		public TerminalNode IADD() { return getToken(TasmParser.IADD, 0); }
		public IAddContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SeqContext extends StmtContext {
		public TerminalNode SEQ() { return getToken(TasmParser.SEQ, 0); }
		public SeqContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HaltContext extends StmtContext {
		public TerminalNode HALT() { return getToken(TasmParser.HALT, 0); }
		public HaltContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterHalt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitHalt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitHalt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FconstContext extends StmtContext {
		public TerminalNode FCONST() { return getToken(TasmParser.FCONST, 0); }
		public FconstContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterFconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitFconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitFconst(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GstoreContext extends StmtContext {
		public TerminalNode GSTORE() { return getToken(TasmParser.GSTORE, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public GstoreContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterGstore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitGstore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitGstore(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BtosContext extends StmtContext {
		public TerminalNode BTOS() { return getToken(TasmParser.BTOS, 0); }
		public BtosContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterBtos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitBtos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitBtos(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IPrintContext extends StmtContext {
		public TerminalNode IPRINT() { return getToken(TasmParser.IPRINT, 0); }
		public IPrintContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DltContext extends StmtContext {
		public TerminalNode DLT() { return getToken(TasmParser.DLT, 0); }
		public DltContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDlt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDlt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDlt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LallocContext extends StmtContext {
		public TerminalNode LALLOC() { return getToken(TasmParser.LALLOC, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public LallocContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterLalloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitLalloc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitLalloc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LloadContext extends StmtContext {
		public TerminalNode LLOAD() { return getToken(TasmParser.LLOAD, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public LloadContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterLload(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitLload(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitLload(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IEqContext extends StmtContext {
		public TerminalNode IEQ() { return getToken(TasmParser.IEQ, 0); }
		public IEqContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIEq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BprintContext extends StmtContext {
		public TerminalNode BPRINT() { return getToken(TasmParser.BPRINT, 0); }
		public BprintContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterBprint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitBprint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitBprint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IuminusContext extends StmtContext {
		public TerminalNode IUMINUS() { return getToken(TasmParser.IUMINUS, 0); }
		public IuminusContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIuminus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIuminus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIuminus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IModContext extends StmtContext {
		public TerminalNode IMOD() { return getToken(TasmParser.IMOD, 0); }
		public IModContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterIMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitIMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitIMod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DuminusContext extends StmtContext {
		public TerminalNode DUMINUS() { return getToken(TasmParser.DUMINUS, 0); }
		public DuminusContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDuminus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDuminus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDuminus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SNeqContext extends StmtContext {
		public TerminalNode SNEQ() { return getToken(TasmParser.SNEQ, 0); }
		public SNeqContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterSNeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitSNeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitSNeq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends StmtContext {
		public TerminalNode CALL() { return getToken(TasmParser.CALL, 0); }
		public TerminalNode LABEL() { return getToken(TasmParser.LABEL, 0); }
		public CallContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ITodContext extends StmtContext {
		public TerminalNode ITOD() { return getToken(TasmParser.ITOD, 0); }
		public ITodContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterITod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitITod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitITod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SAddContext extends StmtContext {
		public TerminalNode SADD() { return getToken(TasmParser.SADD, 0); }
		public SAddContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterSAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitSAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitSAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JumpContext extends StmtContext {
		public TerminalNode JUMP() { return getToken(TasmParser.JUMP, 0); }
		public TerminalNode LABEL() { return getToken(TasmParser.LABEL, 0); }
		public JumpContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterJump(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitJump(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitJump(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ITosContext extends StmtContext {
		public TerminalNode ITOS() { return getToken(TasmParser.ITOS, 0); }
		public ITosContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterITos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitITos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitITos(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DPrintContext extends StmtContext {
		public TerminalNode DPRINT() { return getToken(TasmParser.DPRINT, 0); }
		public DPrintContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BeqContext extends StmtContext {
		public TerminalNode BEQ() { return getToken(TasmParser.BEQ, 0); }
		public BeqContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterBeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitBeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitBeq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TconstContext extends StmtContext {
		public TerminalNode TCONST() { return getToken(TasmParser.TCONST, 0); }
		public TconstContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterTconst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitTconst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitTconst(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DleqContext extends StmtContext {
		public TerminalNode DLEQ() { return getToken(TasmParser.DLEQ, 0); }
		public DleqContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDleq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDleq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDleq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DMultContext extends StmtContext {
		public TerminalNode DMULT() { return getToken(TasmParser.DMULT, 0); }
		public DMultContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDMult(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DSubContext extends StmtContext {
		public TerminalNode DSUB() { return getToken(TasmParser.DSUB, 0); }
		public DSubContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterDSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitDSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitDSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GallocContext extends StmtContext {
		public TerminalNode GALLOC() { return getToken(TasmParser.GALLOC, 0); }
		public TerminalNode INT() { return getToken(TasmParser.INT, 0); }
		public GallocContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).enterGalloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TasmListener ) ((TasmListener)listener).exitGalloc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TasmVisitor ) return ((TasmVisitor<? extends T>)visitor).visitGalloc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmt);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ICONST:
				_localctx = new IconstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(ICONST);
				setState(34);
				match(INT);
				}
				break;
			case DCONST:
				_localctx = new DconstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				match(DCONST);
				setState(36);
				match(DOUBLE);
				}
				break;
			case SCONST:
				_localctx = new SconstContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				match(SCONST);
				setState(38);
				match(STRING);
				}
				break;
			case JUMP:
				_localctx = new JumpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				match(JUMP);
				setState(40);
				match(LABEL);
				}
				break;
			case JUMPT:
				_localctx = new JumptContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(41);
				match(JUMPT);
				setState(42);
				match(LABEL);
				}
				break;
			case JUMPF:
				_localctx = new JumpfContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(43);
				match(JUMPF);
				setState(44);
				match(LABEL);
				}
				break;
			case GALLOC:
				_localctx = new GallocContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(45);
				match(GALLOC);
				setState(46);
				match(INT);
				}
				break;
			case GLOAD:
				_localctx = new GloadContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(47);
				match(GLOAD);
				setState(48);
				match(INT);
				}
				break;
			case GSTORE:
				_localctx = new GstoreContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(49);
				match(GSTORE);
				setState(50);
				match(INT);
				}
				break;
			case IPRINT:
				_localctx = new IPrintContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(51);
				match(IPRINT);
				}
				break;
			case IUMINUS:
				_localctx = new IuminusContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(52);
				match(IUMINUS);
				}
				break;
			case IADD:
				_localctx = new IAddContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(53);
				match(IADD);
				}
				break;
			case ISUB:
				_localctx = new ISubContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(54);
				match(ISUB);
				}
				break;
			case ILT:
				_localctx = new IltContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(55);
				match(ILT);
				}
				break;
			case IMULT:
				_localctx = new IMultContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(56);
				match(IMULT);
				}
				break;
			case IDIV:
				_localctx = new IDivContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(57);
				match(IDIV);
				}
				break;
			case IMOD:
				_localctx = new IModContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(58);
				match(IMOD);
				}
				break;
			case IEQ:
				_localctx = new IEqContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(59);
				match(IEQ);
				}
				break;
			case INEQ:
				_localctx = new INeqContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(60);
				match(INEQ);
				}
				break;
			case ILEQ:
				_localctx = new ILeqContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(61);
				match(ILEQ);
				}
				break;
			case ITOD:
				_localctx = new ITodContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(62);
				match(ITOD);
				}
				break;
			case ITOS:
				_localctx = new ITosContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(63);
				match(ITOS);
				}
				break;
			case DPRINT:
				_localctx = new DPrintContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(64);
				match(DPRINT);
				}
				break;
			case DUMINUS:
				_localctx = new DuminusContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(65);
				match(DUMINUS);
				}
				break;
			case DADD:
				_localctx = new DAddContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(66);
				match(DADD);
				}
				break;
			case DSUB:
				_localctx = new DSubContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(67);
				match(DSUB);
				}
				break;
			case DMULT:
				_localctx = new DMultContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(68);
				match(DMULT);
				}
				break;
			case DDIV:
				_localctx = new DDivContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(69);
				match(DDIV);
				}
				break;
			case DEQ:
				_localctx = new DEqContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(70);
				match(DEQ);
				}
				break;
			case DNEQ:
				_localctx = new DNeqContext(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(71);
				match(DNEQ);
				}
				break;
			case DLT:
				_localctx = new DltContext(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(72);
				match(DLT);
				}
				break;
			case DLEQ:
				_localctx = new DleqContext(_localctx);
				enterOuterAlt(_localctx, 32);
				{
				setState(73);
				match(DLEQ);
				}
				break;
			case DTOS:
				_localctx = new DtosContext(_localctx);
				enterOuterAlt(_localctx, 33);
				{
				setState(74);
				match(DTOS);
				}
				break;
			case SPRINT:
				_localctx = new SPrintContext(_localctx);
				enterOuterAlt(_localctx, 34);
				{
				setState(75);
				match(SPRINT);
				}
				break;
			case SADD:
				_localctx = new SAddContext(_localctx);
				enterOuterAlt(_localctx, 35);
				{
				setState(76);
				match(SADD);
				}
				break;
			case SEQ:
				_localctx = new SeqContext(_localctx);
				enterOuterAlt(_localctx, 36);
				{
				setState(77);
				match(SEQ);
				}
				break;
			case SNEQ:
				_localctx = new SNeqContext(_localctx);
				enterOuterAlt(_localctx, 37);
				{
				setState(78);
				match(SNEQ);
				}
				break;
			case BEQ:
				_localctx = new BeqContext(_localctx);
				enterOuterAlt(_localctx, 38);
				{
				setState(79);
				match(BEQ);
				}
				break;
			case BNEQ:
				_localctx = new BneqContext(_localctx);
				enterOuterAlt(_localctx, 39);
				{
				setState(80);
				match(BNEQ);
				}
				break;
			case BTOS:
				_localctx = new BtosContext(_localctx);
				enterOuterAlt(_localctx, 40);
				{
				setState(81);
				match(BTOS);
				}
				break;
			case AND:
				_localctx = new AndContext(_localctx);
				enterOuterAlt(_localctx, 41);
				{
				setState(82);
				match(AND);
				}
				break;
			case OR:
				_localctx = new OrContext(_localctx);
				enterOuterAlt(_localctx, 42);
				{
				setState(83);
				match(OR);
				}
				break;
			case NOT:
				_localctx = new NotContext(_localctx);
				enterOuterAlt(_localctx, 43);
				{
				setState(84);
				match(NOT);
				}
				break;
			case TCONST:
				_localctx = new TconstContext(_localctx);
				enterOuterAlt(_localctx, 44);
				{
				setState(85);
				match(TCONST);
				}
				break;
			case FCONST:
				_localctx = new FconstContext(_localctx);
				enterOuterAlt(_localctx, 45);
				{
				setState(86);
				match(FCONST);
				}
				break;
			case BPRINT:
				_localctx = new BprintContext(_localctx);
				enterOuterAlt(_localctx, 46);
				{
				setState(87);
				match(BPRINT);
				}
				break;
			case HALT:
				_localctx = new HaltContext(_localctx);
				enterOuterAlt(_localctx, 47);
				{
				setState(88);
				match(HALT);
				}
				break;
			case LALLOC:
				_localctx = new LallocContext(_localctx);
				enterOuterAlt(_localctx, 48);
				{
				setState(89);
				match(LALLOC);
				setState(90);
				match(INT);
				}
				break;
			case LLOAD:
				_localctx = new LloadContext(_localctx);
				enterOuterAlt(_localctx, 49);
				{
				setState(91);
				match(LLOAD);
				setState(92);
				match(INT);
				}
				break;
			case LSTORE:
				_localctx = new LstoreContext(_localctx);
				enterOuterAlt(_localctx, 50);
				{
				setState(93);
				match(LSTORE);
				setState(94);
				match(INT);
				}
				break;
			case POP:
				_localctx = new PopContext(_localctx);
				enterOuterAlt(_localctx, 51);
				{
				setState(95);
				match(POP);
				setState(96);
				match(INT);
				}
				break;
			case CALL:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 52);
				{
				setState(97);
				match(CALL);
				setState(98);
				match(LABEL);
				}
				break;
			case RETVAL:
				_localctx = new RetvalContext(_localctx);
				enterOuterAlt(_localctx, 53);
				{
				setState(99);
				match(RETVAL);
				setState(100);
				match(INT);
				}
				break;
			case RET:
				_localctx = new RetContext(_localctx);
				enterOuterAlt(_localctx, 54);
				{
				setState(101);
				match(RET);
				setState(102);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001?j\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001\u000e\b\u0001\n\u0001\f\u0001\u0011"+
		"\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0016\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002\u001b\b\u0002\u000b\u0002"+
		"\f\u0002\u001c\u0001\u0002\u0003\u0002 \b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003h\b\u0003\u0001\u0003\u0000\u0000"+
		"\u0004\u0000\u0002\u0004\u0006\u0000\u0000\u009e\u0000\b\u0001\u0000\u0000"+
		"\u0000\u0002\n\u0001\u0000\u0000\u0000\u0004\u001f\u0001\u0000\u0000\u0000"+
		"\u0006g\u0001\u0000\u0000\u0000\b\t\u0003\u0004\u0002\u0000\t\u0001\u0001"+
		"\u0000\u0000\u0000\n\u000f\u0005?\u0000\u0000\u000b\f\u0005\u0001\u0000"+
		"\u0000\f\u000e\u0005?\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\u000e"+
		"\u0011\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010"+
		"\u0001\u0000\u0000\u0000\u0010\u0003\u0001\u0000\u0000\u0000\u0011\u000f"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0003\u0002\u0001\u0000\u0013\u0014"+
		"\u0005<\u0000\u0000\u0014\u0016\u0001\u0000\u0000\u0000\u0015\u0012\u0001"+
		"\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0017\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0003\u0006\u0003\u0000\u0018\u0019\u0005"+
		"=\u0000\u0000\u0019\u001b\u0001\u0000\u0000\u0000\u001a\u0015\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d \u0001\u0000\u0000"+
		"\u0000\u001e \u0005=\u0000\u0000\u001f\u001a\u0001\u0000\u0000\u0000\u001f"+
		"\u001e\u0001\u0000\u0000\u0000 \u0005\u0001\u0000\u0000\u0000!\"\u0005"+
		"(\u0000\u0000\"h\u00059\u0000\u0000#$\u0005)\u0000\u0000$h\u00058\u0000"+
		"\u0000%&\u0005*\u0000\u0000&h\u0005;\u0000\u0000\'(\u0005+\u0000\u0000"+
		"(h\u0005?\u0000\u0000)*\u0005,\u0000\u0000*h\u0005?\u0000\u0000+,\u0005"+
		"-\u0000\u0000,h\u0005?\u0000\u0000-.\u0005.\u0000\u0000.h\u00059\u0000"+
		"\u0000/0\u0005/\u0000\u00000h\u00059\u0000\u000012\u00050\u0000\u0000"+
		"2h\u00059\u0000\u00003h\u00051\u0000\u00004h\u0005\r\u0000\u00005h\u0005"+
		"\n\u0000\u00006h\u0005\f\u0000\u00007h\u0005\u0011\u0000\u00008h\u0005"+
		"\t\u0000\u00009h\u0005\u000b\u0000\u0000:h\u0005\u000e\u0000\u0000;h\u0005"+
		"\u000f\u0000\u0000<h\u0005\u0010\u0000\u0000=h\u0005\u0012\u0000\u0000"+
		">h\u0005\u0013\u0000\u0000?h\u0005\u0014\u0000\u0000@h\u00052\u0000\u0000"+
		"Ah\u0005\u0015\u0000\u0000Bh\u0005\u0016\u0000\u0000Ch\u0005\u0017\u0000"+
		"\u0000Dh\u0005\u0018\u0000\u0000Eh\u0005\u0019\u0000\u0000Fh\u0005\u001a"+
		"\u0000\u0000Gh\u0005\u001b\u0000\u0000Hh\u0005\u001c\u0000\u0000Ih\u0005"+
		"\u001d\u0000\u0000Jh\u0005\u001e\u0000\u0000Kh\u00053\u0000\u0000Lh\u0005"+
		"%\u0000\u0000Mh\u0005&\u0000\u0000Nh\u0005\'\u0000\u0000Oh\u0005\u001f"+
		"\u0000\u0000Ph\u0005 \u0000\u0000Qh\u0005!\u0000\u0000Rh\u0005\"\u0000"+
		"\u0000Sh\u0005#\u0000\u0000Th\u0005$\u0000\u0000Uh\u00055\u0000\u0000"+
		"Vh\u00056\u0000\u0000Wh\u00054\u0000\u0000Xh\u00057\u0000\u0000YZ\u0005"+
		"\u0002\u0000\u0000Zh\u00059\u0000\u0000[\\\u0005\u0003\u0000\u0000\\h"+
		"\u00059\u0000\u0000]^\u0005\u0004\u0000\u0000^h\u00059\u0000\u0000_`\u0005"+
		"\u0005\u0000\u0000`h\u00059\u0000\u0000ab\u0005\u0006\u0000\u0000bh\u0005"+
		"?\u0000\u0000cd\u0005\u0007\u0000\u0000dh\u00059\u0000\u0000ef\u0005\b"+
		"\u0000\u0000fh\u00059\u0000\u0000g!\u0001\u0000\u0000\u0000g#\u0001\u0000"+
		"\u0000\u0000g%\u0001\u0000\u0000\u0000g\'\u0001\u0000\u0000\u0000g)\u0001"+
		"\u0000\u0000\u0000g+\u0001\u0000\u0000\u0000g-\u0001\u0000\u0000\u0000"+
		"g/\u0001\u0000\u0000\u0000g1\u0001\u0000\u0000\u0000g3\u0001\u0000\u0000"+
		"\u0000g4\u0001\u0000\u0000\u0000g5\u0001\u0000\u0000\u0000g6\u0001\u0000"+
		"\u0000\u0000g7\u0001\u0000\u0000\u0000g8\u0001\u0000\u0000\u0000g9\u0001"+
		"\u0000\u0000\u0000g:\u0001\u0000\u0000\u0000g;\u0001\u0000\u0000\u0000"+
		"g<\u0001\u0000\u0000\u0000g=\u0001\u0000\u0000\u0000g>\u0001\u0000\u0000"+
		"\u0000g?\u0001\u0000\u0000\u0000g@\u0001\u0000\u0000\u0000gA\u0001\u0000"+
		"\u0000\u0000gB\u0001\u0000\u0000\u0000gC\u0001\u0000\u0000\u0000gD\u0001"+
		"\u0000\u0000\u0000gE\u0001\u0000\u0000\u0000gF\u0001\u0000\u0000\u0000"+
		"gG\u0001\u0000\u0000\u0000gH\u0001\u0000\u0000\u0000gI\u0001\u0000\u0000"+
		"\u0000gJ\u0001\u0000\u0000\u0000gK\u0001\u0000\u0000\u0000gL\u0001\u0000"+
		"\u0000\u0000gM\u0001\u0000\u0000\u0000gN\u0001\u0000\u0000\u0000gO\u0001"+
		"\u0000\u0000\u0000gP\u0001\u0000\u0000\u0000gQ\u0001\u0000\u0000\u0000"+
		"gR\u0001\u0000\u0000\u0000gS\u0001\u0000\u0000\u0000gT\u0001\u0000\u0000"+
		"\u0000gU\u0001\u0000\u0000\u0000gV\u0001\u0000\u0000\u0000gW\u0001\u0000"+
		"\u0000\u0000gX\u0001\u0000\u0000\u0000gY\u0001\u0000\u0000\u0000g[\u0001"+
		"\u0000\u0000\u0000g]\u0001\u0000\u0000\u0000g_\u0001\u0000\u0000\u0000"+
		"ga\u0001\u0000\u0000\u0000gc\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000h\u0007\u0001\u0000\u0000\u0000\u0005\u000f\u0015\u001c\u001fg";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}