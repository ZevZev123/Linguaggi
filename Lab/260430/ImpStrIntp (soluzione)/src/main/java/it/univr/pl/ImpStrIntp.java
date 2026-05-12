package it.univr.pl;

import it.univr.pl.exception.TypeMismatchException;
import it.univr.pl.exception.UnknownVariableException;
import it.univr.pl.value.*;
import org.apache.commons.text.StringEscapeUtils;

public class ImpStrIntp extends ImpStrBaseVisitor<Value> {

    private final Mem mem;

    public ImpStrIntp() {
        this.mem = new Mem();
    }

    public ImpStrIntp(Mem mem) {
        if (mem != null) this.mem = new Mem(mem);
        else this.mem = new Mem();
    }

    public Mem getMem() { return mem; }

    private ComValue visitCom(ImpStrParser.ComContext ctx) {
        return (ComValue) visit(ctx);
    }

    private ExpValue<?> visitExp(ImpStrParser.ExpContext ctx) {
        return (ExpValue<?>) visit(ctx);
    }

    private NumValue<?> visitNumExp(ImpStrParser.ExpContext ctx) {
        try {
            return (NumValue<?>) visitExp(ctx);
        } catch (ClassCastException cce) {
            String err =
                    "Type mismatch!\n" +
                    "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n" +
                    ">>>>>>>>>>>>>>>>>>>>>>>>\n" +
                    ctx.getText() + "\n" +
                    "<<<<<<<<<<<<<<<<<<<<<<<<\n" +
                    "Numeric expression expected.";
            throw new TypeMismatchException(err);
        }
    }

    private BoolValue visitBoolExp(ImpStrParser.ExpContext ctx) {
        try {
            return (BoolValue) visitExp(ctx);
        } catch (ClassCastException cce) {
            String err =
                    "Type mismatch!\n" +
                    "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n" +
                    ">>>>>>>>>>>>>>>>>>>>>>>>\n" +
                    ctx.getText() + "\n" +
                    "<<<<<<<<<<<<<<<<<<<<<<<<\n" +
                    "Boolean expression expected.";
            throw new TypeMismatchException(err);
        }
    }

    private StringValue visitStringExp(ImpStrParser.ExpContext ctx) {
        try {
            return (StringValue) visit(ctx);
        } catch(ClassCastException e) {
            String err =
                    "Type mismatch!\n" +
                    "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n" +
                    ">>>>>>>>>>>>>>>>>>>>>>>>\n" +
                    ctx.getText() + "\n" +
                    "<<<<<<<<<<<<<<<<<<<<<<<<\n" +
                    "String expression expected.";
            throw new TypeMismatchException(err);
        }
    }

    private double unwrapToDouble(NumValue<?> numValue) {
        return numValue.toJavaValue().doubleValue();
    }

    @Override
    public ComValue visitMain(ImpStrParser.MainContext ctx) {
        return visitCom(ctx.com());
    }

    @Override
    public ComValue visitIf(ImpStrParser.IfContext ctx) {
        return visitBoolExp(ctx.exp()).toJavaValue()
                ? visitCom(ctx.com())
                : ComValue.INSTANCE;
    }

    @Override
    public ComValue visitIfElse(ImpStrParser.IfElseContext ctx) {
        return visitBoolExp(ctx.exp()).toJavaValue()
                ? visitCom(ctx.com(0))
                : visitCom(ctx.com(1));
    }

    @Override
    public ComValue visitAssign(ImpStrParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> v = visitExp(ctx.exp());

        mem.updateValue(id, v);

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitSeq(ImpStrParser.SeqContext ctx) {
        visitCom(ctx.com(0));
        return visitCom(ctx.com(1));
    }

    @Override
    public ComValue visitWhile(ImpStrParser.WhileContext ctx) {
        if (!visitBoolExp(ctx.exp()).toJavaValue())
            return ComValue.INSTANCE;

        visitCom(ctx.com());

        return visitWhile(ctx);
    }

    @Override
    public ComValue visitNop(ImpStrParser.NopContext ctx) {
        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitOut(ImpStrParser.OutContext ctx) {
        System.out.println(visitStringExp(ctx.exp()).toJavaValue());
        return ComValue.INSTANCE;
    }

    @Override
    public NumValue<?> visitNumeric(ImpStrParser.NumericContext ctx) {
        return (NumValue<?>) visit(ctx.num());
    }

    @Override
    public IntValue visitIntNum(ImpStrParser.IntNumContext ctx) {
        return new IntValue(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public DecValue visitDecNum(ImpStrParser.DecNumContext ctx) {
        return new DecValue(Double.parseDouble(ctx.DEC().getText()));
    }

    @Override
    public BoolValue visitBoolean(ImpStrParser.BooleanContext ctx) {
        return new BoolValue(Boolean.parseBoolean(ctx.BOOL().getText()));
    }

    @Override
    public StringValue visitString(ImpStrParser.StringContext ctx) {
        String str = ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1);
        return new StringValue(StringEscapeUtils.unescapeJava(str));
    }

    @Override
    public ExpValue<?> visitParExp(ImpStrParser.ParExpContext ctx) {
        return visitExp(ctx.exp());
    }

    @Override
    public ExpValue<?> visitPow(ImpStrParser.PowContext ctx) {
        NumValue<?> base = visitNumExp(ctx.exp(0));
        NumValue<?> exponent = visitNumExp(ctx.exp(1));

        double result = Math.pow(unwrapToDouble(base), unwrapToDouble(exponent));
        if (Math.floor(result) == result) return new IntValue((int) result);
        else return new DecValue(result);
    }

    @Override
    public Value visitTostr(ImpStrParser.TostrContext ctx) {
        return new StringValue(visitExp(ctx.exp()).toJavaValue().toString());
    }

    @Override
    public BoolValue visitNot(ImpStrParser.NotContext ctx) {
        return new BoolValue(!visitBoolExp(ctx.exp()).toJavaValue());
    }

    @Override
    public ExpValue<?> visitMulDivMod(ImpStrParser.MulDivModContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));

        Double result;
        switch (ctx.op.getType()) {
            case ImpStrParser.DIV -> result = unwrapToDouble(left) / unwrapToDouble(right);
            case ImpStrParser.MUL -> result = unwrapToDouble(left) * unwrapToDouble(right);
            case ImpStrParser.MOD -> result = unwrapToDouble(left) % unwrapToDouble(right);
            default -> result = null; // unreachable code
        }

        assert result != null; // always true
        if (Math.floor(result) == result) return new IntValue((int) result.doubleValue());
        else return new DecValue(result);
    }

    @Override
    public ExpValue<?> visitAddSub(ImpStrParser.AddSubContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));

        Double result;
        switch (ctx.op.getType()) {
            case ImpStrParser.ADD -> result = unwrapToDouble(left) + unwrapToDouble(right);
            case ImpStrParser.SUB -> result = unwrapToDouble(left) - unwrapToDouble(right);
            default -> result = null; // unreachable code
        }

        assert result != null; // always true
        if (Math.floor(result) == result) return new IntValue((int) result.doubleValue());
        else return new DecValue(result);
    }

    @Override
    public BoolValue visitEqExp(ImpStrParser.EqExpContext ctx) {
        ExpValue<?> left = visitExp(ctx.exp(0));
        ExpValue<?> right = visitExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case ImpStrParser.EQQ -> new BoolValue(left.equals(right));
            case ImpStrParser.NEQ -> new BoolValue(!left.equals(right));
            default -> null; // unreachable code
        };
    }

    @Override
    public ExpValue<?> visitId(ImpStrParser.IdContext ctx) {
        String id = ctx.ID().getText();

        if (!mem.contains(id)) {
            String err =
                    "Variable " + id + " used but never instantiated\n" +
                    "@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine();
            throw new UnknownVariableException(err);
        }

        return mem.getValue(id);
    }

    @Override
    public BoolValue visitCmpExp(ImpStrParser.CmpExpContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case ImpStrParser.GEQ -> new BoolValue(unwrapToDouble(left) >= unwrapToDouble(right));
            case ImpStrParser.LEQ -> new BoolValue(unwrapToDouble(left) <= unwrapToDouble(right));
            case ImpStrParser.LT  -> new BoolValue(unwrapToDouble(left) < unwrapToDouble(right));
            case ImpStrParser.GT  -> new BoolValue(unwrapToDouble(left) > unwrapToDouble(right));
            default -> null; // unreachable code
        };
    }

    @Override
    public BoolValue visitAndOr(ImpStrParser.AndOrContext ctx) {
        BoolValue left = visitBoolExp(ctx.exp(0));
        BoolValue right = visitBoolExp(ctx.exp(1));

        return switch (ctx.op.getType()) { // short-circuit
            case ImpStrParser.AND -> new BoolValue(left.toJavaValue() && right.toJavaValue());
            case ImpStrParser.OR -> new BoolValue(left.toJavaValue() || right.toJavaValue());
            default -> null; // unreachable code
        };
    }

    @Override
    public StringValue visitConcat(ImpStrParser.ConcatContext ctx) {
        StringValue left = visitStringExp(ctx.exp(0));
        StringValue right = visitStringExp(ctx.exp(1));

        return new StringValue(left.toJavaValue() + right.toJavaValue());
    }
}
